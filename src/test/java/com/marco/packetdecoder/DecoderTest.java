package com.marco.packetdecoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import com.marco.packetdecoder.decoder.Decoder;

public class DecoderTest {

    @Before
    public void setup() {

    }
    
    @Test
    public void decodeStartTest() {
        System.out.println("decodeStartTest");

        // SOM = 0x2B00;
        byte[] som = new byte[] {0b00101011, 0b00000000};
        
        int result = Decoder.decodeStart(som);

        assertEquals(Decoder.START_OF_PACKET, result);

        som = new byte[] {0b01111111, 0b00000000};
        result = Decoder.decodeStart(som);

        assertFalse(result == Decoder.START_OF_PACKET);
    }
}