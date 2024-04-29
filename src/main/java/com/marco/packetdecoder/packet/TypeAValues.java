package com.marco.packetdecoder.packet;

public class TypeAValues extends PacketPayloadType {
    public char[] values;  // 16 character String (16th char == '\0')

    public TypeAValues(char[] values) {
        this.values = values;
    }
}
