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
            0b0000_0001,
            0b0000_0001, // key
            0b0000_0000,
            0b0000_0000, // payload length
            0b0001_0000,
            (byte) 'a',
            (byte) 'b',
            (byte) 'c',
            (byte) 'd',
            (byte) 'e',
            (byte) 'f',
            (byte) 'g',
            (byte) 'h',
            (byte) 'i',
            (byte) 'j',
            (byte) 'k',
            (byte) 'l',
            (byte) 'm',
            (byte) 'n',
            (byte) 'o',
            (byte) '\0'
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

    @Test
    public void testDecodeKey() {
        int result = Decoder.decodeKey(packet);
        assertEquals(Decoder.KEY_A, result);
    }

    @Test
    public void testDecodeLength() {
        int result = Decoder.decodeLength(packet);
        assertEquals(16, result);
    }
}
