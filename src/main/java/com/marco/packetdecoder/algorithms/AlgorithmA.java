package com.marco.packetdecoder.algorithms;

import com.marco.packetdecoder.packet.Packet;

public class AlgorithmA implements Packet.PayloadInterpreter {
    /***
     * The purpose of this class is to decode the
     * payload portion of an A type packet.
     */
    private static final int PAYLOAD_LENGTH = 16;

    public void interpretPayload() {
        
    }
}
