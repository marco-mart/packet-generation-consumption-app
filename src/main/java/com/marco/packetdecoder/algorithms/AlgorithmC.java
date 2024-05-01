package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;
import com.marco.packetdecoder.packet.TypeCValues;

public class AlgorithmC {

    /***
     * 16 bit signed integer
     * 16 bit signed integer  ==> use 16th bit for signing, store in int, flip MSB (32 bit) accordingly
     * 32 bit float           ==> can store in float I think, need to research
     * 5 char array
     */

    private static final int PAYLOAD_LENGTH = 13;

    public static TypeCValues interpretPayload(byte[] packetBytes) {

        /**
         * REMEMBER THAT WE HAVE TO USE AN 'AND' MASK
         * TO AVOID SIGN EXTENSION PROBLEMS!!
         * 
         * EX:
         * 00000000xxxxxxxx0000000000000000
         * VS
         * 111111111111111111111111xxxxxxxx
         * 
         * 
         */
        if (packetBytes.length - Packet.PAYLOAD_INDEX_START != PAYLOAD_LENGTH) {
            System.out.println("Payload length for packet TYPE C is not correct.");
            return null;
        }

        byte[] message = (byte[]) packetBytes.clone();
        short[] shortValues = new short[2];

        // Read in 2 byte signed int
        // Read in 2 byte signed int

        int i = 0;  // i scrolls through shortValues
        int j = Packet.PAYLOAD_INDEX_START;  // j scrolls through packet bytes
        short value = 0;
        int shifter = 8;
        for (; j <= Packet.PAYLOAD_INDEX_START + 4; j++) {
            if (j % 2 == 0 && j > 0) {
                shortValues[i] = value;  // assuming value stays as a short
                shifter = 8;
                i++;
                if (i > 1) break;
            }
            
            value |= (message[j] << shifter);
            shifter /= 8;
        }

        // We read in 4 byte values so actual index is now: Packet.PAYLOAD_INDEX_START + 4

        long floatValue = 0L;
        shifter = 24;
        // Read in 32 bit float
        for (; j <= Packet.PAYLOAD_INDEX_START + 8; j++) {
            floatValue |= message[j] << shifter;
        }

        // We can do this becuase we know that the data that is coming in is <= 32 bits
        float actualFloatValue = (float) floatValue;  

        // We read in another 4 bytes so actual index is now: Packet.PAYLOAD_INDEX_START + 8
        char[] charArr = new char[5];
        // Read in 5 char array
        i = 0;
        for (; j <= Packet.PAYLOAD_INDEX_START + 13; j++) {
            charArr[i++] |= message[j];
        }

        return new TypeCValues(shortValues, actualFloatValue, charArr);
    }
}
