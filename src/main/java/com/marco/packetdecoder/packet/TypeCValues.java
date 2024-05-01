package com.marco.packetdecoder.packet;

public class TypeCValues extends PacketPayloadType {

    public short[] shortValues;
    public float floatValue; // 32 bits
    public char[] charValues; // 5 char array


    public TypeCValues(
        short[] shortValues,
        float floatValue,
        char[] charValues
        ) {

        this.shortValues = shortValues;
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
