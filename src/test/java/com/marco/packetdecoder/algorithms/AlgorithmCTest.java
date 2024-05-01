package com.marco.packetdecoder.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeCValues;

public class AlgorithmCTest {
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
            (byte) 0xFF, (byte) 0xFF,  // 0xFF (32767) x2
            (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,  // 32-bit float (signed) -> -1.0
            (byte) 'a',
            (byte) 'b',
            (byte) 'c',
            (byte) 'd',
            (byte) '\0'
        };
    }

    @Test
    public void testInterpretPayload() {    

        short maxShortSigned = -32768; // min value of a short, 2^15
        PacketPayloadType result = AlgorithmC.interpretPayload(packetBytes);

        short[] shorts = new short[] {maxShortSigned, maxShortSigned};
        float floatValue = 0xFFFFFFFF;
    
        TypeCValues _result = (TypeCValues) result;
        _result.shortValues = shorts;
        _result.floatValue = floatValue;
        _result.charValues = new char[] {97, 98, 99, 100, '\0'};

        assertTrue(_result.equals((TypeCValues) result));
    }
}
