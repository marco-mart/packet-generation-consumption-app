package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;
import com.marco.packetdecoder.packet.TypeAValues;

public class AlgorithmA {
    /***
     * 16 character String, 16th character is '\0'
     */
    private static final int PAYLOAD_LENGTH = 16;

    public static TypeAValues interpretPayload(byte[] packetBytes) {
        if (packetBytes.length - Packet.PAYLOAD_INDEX_START != PAYLOAD_LENGTH) {
            System.out.println("Payload length for Packet (TYPE A) is not correct.");
            return null;
        }

        byte[] message = packetBytes;
        char[] payload = new char[16];
        
        // PAYLOAD STARTS AT THE 8th INDEX
        for (int i = 0; i < PAYLOAD_LENGTH; i++) {
            payload[i] = (char) message[Packet.PAYLOAD_INDEX_START + i];
        }

        TypeAValues values = new TypeAValues(payload);
        return values;
    }
}
