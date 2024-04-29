package com.marco.packetdecoder.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeAValues;

public class AlgorithmATest {

    byte[] packetBytes;
    AlgorithmA a = new AlgorithmA();

    @Before
    public void setup() {
        packetBytes = new byte[] {
            0b0010_1011, // som
            0b0000_0000,
            0b0000_0000, // sequence number
            0b0000_0001,
            0b0000_0001, // key
            0b0000_0000,
            0b0000_0000, // payload length
            0b0001_0000,
                        // payload
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
    public void testInterpretPayload() {

        char[] charValues = new char[] {
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, '\0'
        };

        PacketPayloadType trueVal = new TypeAValues(charValues);

        PacketPayloadType result = AlgorithmA.interpretPayload(packetBytes);

        assertTrue(trueVal.equals(result));
    }
}
