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

    public static void interpretPayload(Packet packet) {

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
        if (packet.getPayloadLength() != PAYLOAD_LENGTH) {
            System.out.println("Payload length for " + packet + " (TYPE A) is not correct.");
            return;
        }
    }
}
