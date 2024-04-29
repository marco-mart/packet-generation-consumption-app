package com.marco.packetdecoder.packet;

public class TypeBValues extends PacketPayloadType {
    public long[] values;  // 8, 32-bit unsigned ints

    public TypeBValues(long[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    @Override
    public int getPayloadType() {
        return TYPE_B;
    }
}
