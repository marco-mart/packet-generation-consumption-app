package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;
import com.marco.packetdecoder.packet.PacketPayloadType;
import com.marco.packetdecoder.packet.TypeAValues;

public class AlgorithmA implements Packet.PayloadInterpreter {
    /***
     * 16 character String, 16th character is '\0'
     */
    private static final int PAYLOAD_LENGTH = 16;

    public void interpretPayload(Packet packet) {
        if (packet.getPayloadLength() != PAYLOAD_LENGTH) {
            System.out.println("Payload length for " + packet + " (TYPE A) is not correct.");
            return;
        }

        byte[] message = packet.getPacketBytes();
        char[] payload = new char[16];
        
        // PAYLOAD STARTS AT THE 8th INDEX
        for (int i = 0; i < PAYLOAD_LENGTH; i++) {
            payload[i] = (char) message[Packet.PAYLOAD_INDEX_START + i];
        }

        PacketPayloadType values = new TypeAValues(payload);
        packet.setPayloadValues(values);

    }
}
