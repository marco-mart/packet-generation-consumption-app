package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;

public class AlgorithmC {

    /***
     * 16 bit signed integer
     * 16 bit signed integer  ==> use 16th bit for signing, store in int, flip MSB (32 bit) accordingly
     * 32 bit float           ==> can store in float I think, need to research
     * 5 char array
     */

    private static final int PAYLOAD_LENGTH = 13;

    public static void interpretPayload(byte[] packetBytes) {

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
            return;
        }

        byte[] message = (byte[]) packetBytes.clone();
        short[] shortValues = new short[2];

        // Read in 2 byte signed int
        // Read in 2 byte signed int

        int i = 0;  // i scrolls through shortValues
        short value = 0;
        int shifter = 8;
        for (int j = 0; j <= 4; j++) {  // j scrolls through packet bytes
            if (j % 2 == 0 && j > 0) {
                shortValues[i] = value;  // assuming value stays as a short
                shifter = 8;
                i++;
                if (i > 1) break;
            }
            
            value |= (message[Packet.PAYLOAD_INDEX_START + j] << shifter);
            shifter /= 8;
        }

        // Read in 32 bit float
        // Read in 5 char array
    }
}
