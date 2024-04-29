package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;

public class AlgorithmC implements Packet.PayloadInterpreter {

    /***
     * 16 bit signed integer
     * 16 bit signed integer  ==> use 16th bit for signing, store in int, flip MSB (32 bit) accordingly
     * 32 bit float           ==> can store in float I think, need to research
     * 5 char array
     */

    private static final int PAYLOAD_LENGTH = 13;

    public void interpretPayload(Packet packet) {
        if (packet.getPayloadLength() != PAYLOAD_LENGTH) {
            System.out.println("Payload length for " + packet + " (TYPE A) is not correct.");
            return;
        }
    }
}
