package com.marco.packetdecoder.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeAValues;
import com.marco.packetdecoder.packet.TypeBValues;

public class AlgorithmBTest {

    byte[] packetBytes;

    @Before
    public void setup() {
        packetBytes = new byte[] {
            0b0010_1011, // som
            0b0000_0000,
            0b0000_0000, // sequence number
            0b0000_0001,
            0b0000_0001, // key
            0b0000_0000,
            0b0000_0000, // payload length == 32 bytes
            0b0010_0000,
                          // payload 0xFFFFFFFF x 8
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
        };
    }

    @Test
    public void testInterpretPayload() {    

        long answer = 0xFFFFFFFFL;

        PacketPayloadType result = AlgorithmB.interpretPayload(packetBytes);

        TypeBValues bPayload = (TypeBValues) result;

        for (long pay : bPayload.values) {
            assertTrue(answer == pay);
        }
        
    }

    // @Test
    // public void testInterpretPayload() {

    // }
}
