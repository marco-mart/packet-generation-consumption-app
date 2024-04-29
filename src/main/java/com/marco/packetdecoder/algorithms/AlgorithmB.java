package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;

public class AlgorithmB implements Packet.PayloadInterpreter {
    
    /***
     * Array of 32 bit unsigned integers, size=8
     * 
     * int size = 31 (MSB is used for signing)
     * 
     * USE LONG
     * 
     * ie. 32 bytes
     */
    private static final int PAYLOAD_LENGTH = 32;

    public void interpretPayload(Packet packet) {
        if (packet.getPayloadLength() != PAYLOAD_LENGTH) {
            System.out.println("Payload length for " + packet + " (TYPE A) is not correct.");
            return;
        }
    }
}
