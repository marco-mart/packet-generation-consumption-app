package com.marco.packetdecoder.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeAValues;

public class AlgorithmATest {

    public byte[] packetBytesTest1;
    public byte[] packetBytesTest2;
    public byte[] packetBytesTest3;


    @Before
    public void setup() {
        // Good
        packetBytesTest1 = new byte[] {
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

        // Bad length
        packetBytesTest2 = new byte[] {
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
            (byte) '\0'
        };
        
        // Invalid ascii character
        packetBytesTest3 = new byte[] {
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
            (byte) 128,
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
    public void testGoodPayload() {

        char[] charValues = new char[] {
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, '\0'
        };

        PacketPayloadType trueVal = new TypeAValues(charValues);

        PacketPayloadType result = AlgorithmA.interpretPayload(packetBytesTest1);

        assertTrue(trueVal.equals(result));
    }

    @Test
    public void testBadPayloadLength() {

        PacketPayloadType result = AlgorithmA.interpretPayload(packetBytesTest2);

        assertTrue(result == null);
    }

    @Test
    public void testBadCharacter() {

        PacketPayloadType result = AlgorithmA.interpretPayload(packetBytesTest3);

        assertTrue(result == null);
    }
}
