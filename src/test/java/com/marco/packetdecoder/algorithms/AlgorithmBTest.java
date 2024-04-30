package com.marco.packetdecoder.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeAValues;

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
                        // payload
            0xF,
            0xF,
            0xF,
            0xF,


        };
    }

    @Test
    public void testInterpretPayload() {

        char[] charValues = new char[] {
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, '\0'
        };

        PacketPayloadType trueVal = new TypeAValues(charValues);

        PacketPayloadType result = AlgorithmA.interpretPayload(packetBytes);

        assertTrue(trueVal.equals(result));
    }

    // @Test
    // public void testInterpretPayload() {

    // }
}
