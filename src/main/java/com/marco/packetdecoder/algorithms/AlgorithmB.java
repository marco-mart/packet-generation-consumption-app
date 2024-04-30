package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;
import com.marco.packetdecoder.packet.TypeBValues;

public class AlgorithmB {
    
    /***
     * Array of 32 bit unsigned integers, size=8
     * 
     * Total bytes =
     * each = 32 bits
     * 1 byte = 8 bits
     * each = 4 bytes
     * There are 8 of them
     * 8 * 4 = 32 bytes total
     * 
     * JAVA
     * int size = 31 (MSB is used for signing)
     * 
     * USE LONG (64 bits = 8 bytes)
     * 
     */
    private static final int PAYLOAD_LENGTH = 32; // 32 bytes

    public static TypeBValues interpretPayload(byte[] packetBytes) {

        /***
         * Need to consider "sign extension"
         * Happens when converting int to long
         * int's MSB is used to fill in the rest of the left side
         * of the long [32, 64]
         * 
         * To avoid this you need to mask the upper bits using the bitwise AND
         * operation with 0xFFFFFFFFL
         * 
         * Example:
         * 
         * 
         *         int int_overflow = 0xFFFFFFFF;
         *         System.out.println("Max int = " + int_overflow);
         *         long max_unsigned_int = 0L;
         *         // Need to & with a long so that "SIGN EXTENSION" doesn't happen
         *         max_unsigned_int |= int_overflow & 0xFFFFFFFFL;
         *         System.out.println("2^32=" + Math.pow(2, 32));
         *         System.out.println("max_unsigned_int=" + max_unsigned_int);
         */
        if (packetBytes.length - (32) !=  PAYLOAD_LENGTH) {
            System.out.println("Payload length for Packet TYPE B is not correct.");
            return null;
        }

        byte[] message = packetBytes.clone();
        long[] payload = new long[8];
        
        // Gotta shift it over 3 times to get it to the 4th byte of the long

        int i = 0;
        int shift = 3;
        // PAYLOAD STARTS AT THE 8TH INDEX
        for (int j = 0; j < PAYLOAD_LENGTH; j++) {
            if (j % 4 == 0) {
                i++;  // start setting next number in payload 
                shift = 3;  // restart shifter
            }
            payload[i] |= message[Packet.PAYLOAD_INDEX_START + j] << shift;
            shift -= 1;
        }

        
        TypeBValues values = new TypeBValues(payload);
        return values;
    }
}
