package com.marco.packetdecoder.decoder;

import java.lang.annotation.Documented;

public class Decoder {
    
    /***
     * 1 byte = 8 bits
     * 1 hex digit = 4 bits long
     * 1 byte = 2 hex digits
     * 
     * Packet:
     * <header><payload> ==>
     * <start_of_packet><packet_counter>   <key><length><values>
     * 
     * length == num of bytes
     */

    /************** PACKET CONSTANTS **************/

    public static final int START_OF_PACKET = 0x2b00;

    public static final int KEY_A = 0x0100;
    public static final int KEY_B = 0x0110;
    public static final int KEY_C = 0x0201;

    // Entry
    public static void decode(byte[] packet) {

        int startOfPacket = decodeStart(packet);

        // Check if SOM is valid
        if (startOfPacket != START_OF_PACKET) {
            return;
        }

        int packetKey = decodeKey();
        

        
        // Return packet;
    }

    /***
     * SOM is 2 bytes longs
     * @param packet
     * @return The int value of the first 2 bytes read,
     *         or Integer.MIN_VALUE if packet is < 2 bytes.
     */
    public static int decodeStart(byte[] packet) {

        if (packet.length < 2) {
            return Integer.MIN_VALUE;
        }

        int packetStart = 0;
        packetStart |= packet[0] << 8;
        packetStart <<= packet[1];

        return packetStart;
    }
}
