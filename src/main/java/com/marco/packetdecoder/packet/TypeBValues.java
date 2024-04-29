package com.marco.packetdecoder.packet;

public class TypeBValues extends PacketPayloadType {
    public long[] values;  // 8, 32-bit unsigned ints

    public TypeBValues(long[] values) {
        this.values = values;
    }
}
