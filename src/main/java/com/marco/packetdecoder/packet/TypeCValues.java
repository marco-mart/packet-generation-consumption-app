package com.marco.packetdecoder.packet;

public class TypeCValues extends PacketPayloadType {

    public int x;  // 16 bit signed int
    public int y;
    public float floatValue; // 32 bits
    public char[] charValues; // 5 char array


    public TypeCValues(
        int x, int y,
        float floatValue,
        char[] charValues
        ) {

        this.x = x;
        this.y = y;
        this.floatValue = floatValue;
        this.charValues = charValues;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    @Override
    public int getPayloadType() {
        return TYPE_C;
    }
}
