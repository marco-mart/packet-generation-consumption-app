package com.marco.packetdecoder.packet;

public class Packet {

    /***
     * Clients:
     * When payload is acquired using getPayloadValues(),
     * on the object that is returned, use the method:
     * getPayloadType(), then compare the result to the 
     * different values that the packet can be to cast 
     * it to the correct Class: TypeA, TypeB, or TypeC
     * @see com.marco.packetdecoder.packet.TypeAValues
     * @see com.marco.packetdecoder.packet.TypeBValues
     * @see com.marco.packetdecoder.packet.TypeCValues
     * 
     * The type are defined in the PacketPayloadType class:
     * @see com.marco.packetdecoder.packet.PacketPayloadType
     */
    
    // LENGTH OF PACKET METADATA (BYTES) BEFORE THE
    // START OF THE ACTUAL PAYLOAD
    public static final int PAYLOAD_INDEX_START = 8;

    private int key;
    private int packetCount;  // Sequence number
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
