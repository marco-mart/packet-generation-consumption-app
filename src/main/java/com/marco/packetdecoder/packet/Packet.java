package com.marco.packetdecoder.packet;

public class Packet {
    
    public static final int PAYLOAD_INDEX_START = 8;

    /***
     * To get String representation use:
     * packet.getPayloadInterpreter().interpretPayload()
     */

    /**
     * PayloadInterpreter
     */
    public static interface PayloadInterpreter {
        public void interpretPayload(Packet packet);
    }

    private int key;
    private int packetCount;
    private int payloadLength;
    private byte[] packetBytes;
    private PayloadInterpreter interpretPayload;
    private PacketPayloadType payloadValues;

    public Packet() {}

    public void setKey(int key) {this.key = key;}
    public void setPacketCount(int count) {this.packetCount = count;}
    public void setPayloadLength(int length) {this.payloadLength = length;}
    public void setPacketBytes(byte[] packetBytes) {this.packetBytes = packetBytes;}
    public void setPayloadInterpreter(PayloadInterpreter payloadInterpreter) {
        this.interpretPayload = payloadInterpreter;
    }
    public void setPayloadValues(PacketPayloadType values) {
        this.payloadValues = values;
    }

    public int getKey() {return this.key;}
    public int getPacketCount() {return this.packetCount;}
    public int getPayloadLength() {return this.payloadLength;}
    public byte[] getPacketBytes() {return this.packetBytes;}
    public PayloadInterpreter getPayloadInterpreter() {
        return this.interpretPayload;
    }
    public PacketPayloadType getPayloadValues() {
        return this.payloadValues;
    }
}
