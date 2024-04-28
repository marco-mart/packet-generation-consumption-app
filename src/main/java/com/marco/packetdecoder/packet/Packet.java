package com.marco.packetdecoder.packet;

public class Packet {
    
    /***
     * To get String representation use:
     * packet.getPayloadInterpreter().interpretPayload()
     */

    /**
     * PayloadInterpreter
     */
    public static interface PayloadInterpreter {
        public void interpretPayload();
    }

    private int key;
    private int packetCount;
    private byte[] payload;
    private PayloadInterpreter interpretPayload;

    public Packet() {}

    public void setKey(int key) {this.key = key;}
    public void setPacketCount(int count) {this.packetCount = count;}
    public void setPayload(byte[] payload) {this.payload = payload;}
    public void setPayloadInterpreter(PayloadInterpreter payloadInterpreter) {
        this.interpretPayload = payloadInterpreter;
    }

    public int getKey() {return this.key;}
    public int getPacketCount() {return this.packetCount;}
    public byte[] getPayload() {return this.payload;}
    public PayloadInterpreter getPayloadInterpreter() {
        return this.interpretPayload;
    }


}
