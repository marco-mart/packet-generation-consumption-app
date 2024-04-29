package com.marco.packetdecoder.packet;

abstract public class PacketPayloadType {

    public static final int TYPE_A = 0xAAAA;
    public static final int TYPE_B = 0xBBBB;
    public static final int TYPE_C = 0xCCCC;

    abstract public int getPayloadType();
    abstract public String toString();
}
