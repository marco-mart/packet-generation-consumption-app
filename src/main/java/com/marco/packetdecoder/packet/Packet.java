package com.marco.packetdecoder.packet;

public class Packet {
    
    // LENGTH OF PACKET METADATA (BYTES) BEFORE THE
    // START OF THE ACTUAL PAYLOAD
    public static final int PAYLOAD_INDEX_START = 8;

    private int key;
    private int packetCount;
    private int payloadLength;
    private byte[] packetBytes;
    private PacketPayloadType payloadValues;

    public Packet() {}

    public void setKey(int key) {this.key = key;}
    public void setPacketCount(int count) {this.packetCount = count;}
    public void setPayloadLength(int length) {this.payloadLength = length;}
    public void setPacketBytes(byte[] packetBytes) {this.packetBytes = packetBytes;}
    public void setPayloadValues(PacketPayloadType values) {
        this.payloadValues = values;
    }

    public int getKey() {return this.key;}
    public int getPacketCount() {return this.packetCount;}
    public int getPayloadLength() {return this.payloadLength;}
    public byte[] getPacketBytes() {return this.packetBytes;}
    public PacketPayloadType getPayloadValues() {
        return this.payloadValues;
    }
}
