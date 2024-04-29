package com.marco.packetdecoder.decoder;

import java.lang.annotation.Documented;

import com.marco.packetdecoder.algorithms.AlgorithmA;
import com.marco.packetdecoder.algorithms.AlgorithmB;
import com.marco.packetdecoder.algorithms.AlgorithmC;
import com.marco.packetdecoder.packet.Packet;
import com.marco.packetdecoder.packet.Packet.PayloadInterpreter;

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
    public static void decode(byte[] message) {

        int startOfPacket = decodeStart(message);

        // Check if SOM is valid
        if (startOfPacket != START_OF_PACKET) {
            return;
        }

        Packet packet = new Packet();

        int packetSequence = decodePacketSequenceNumber(message);
        packet.setPacketCount(packetSequence);

        int messageKey = decodeKey(message);
        packet.setKey(messageKey);

        switch (packet.getKey()) {
            case KEY_A:
                packet.setPayloadInterpreter(new AlgorithmA());
                break;
            case KEY_B:
                packet.setPayloadInterpreter(new AlgorithmB());
                break;
            case KEY_C:
                packet.setPayloadInterpreter(new AlgorithmC());
                break;
            
            default:
                System.out.println("Not a valid payload!");
                break;
        }        
        // Return packet;
    }

    /***
     * SOM is 2 bytes long
     * [0, 1]
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
        packetStart |= packet[1];

        return packetStart;
    }

    /***
     * SEQNUM is 2 bytes long
     * [2, 3]
     * @param packet
     * @return The int value of the first 2 bytes read,
     *         or Integer.MIN_VALUE if packet is < 4 bytes.
     */
    public static int decodePacketSequenceNumber(byte[] packet) {
        if (packet.length < 4) {
            return Integer.MIN_VALUE;
        }

        int seqNum = 0;
        seqNum |= packet[2] << 8;
        seqNum |= packet[3];

        return seqNum;
    }

    /***
     * Unique 2-byte integer
     * [4, 5]
     * @param packet
     * @return
     */
    public static int decodeKey(byte[] packet) {
        
        if (packet.length < 6) {
            return Integer.MIN_VALUE;
        }
                   
        int key = 0;

        key |= packet[4] << 8;
        key |= packet[5];

        return key;
    }
}
