package com.marco.packetdecoder.decoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class DecoderTest {

    byte[] packet;

    @Before
    public void setup() {
        packet = new byte[] {
            0b0010_1011, // som
            0b0000_0000,
            0b0000_0000, // sequence number
            0b0000_0001
        };
    }

    @Test
    public void testDecodePacketSequenceNumber() {
        int result = Decoder.decodePacketSequenceNumber(packet);
        assertEquals(1, result);

        packet[3] <<= 1;
        result = Decoder.decodePacketSequenceNumber(packet);
        assertEquals(2, result);
    }

    @Test
    public void testDecodeStart() {

        // SOM = 0x2B00;

        int result = Decoder.decodeStart(packet);
        assertEquals(Decoder.START_OF_PACKET, result);

        packet[0] |= 16;
        result = Decoder.decodeStart(packet);
        assertFalse(Decoder.START_OF_PACKET == result);
    }
}
