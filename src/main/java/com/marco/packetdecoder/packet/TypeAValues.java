package com.marco.packetdecoder.packet;

import java.util.Arrays;

public class TypeAValues extends PacketPayloadType {
    public char[] values;  // 16 character String (16th char == '\0')

    public TypeAValues(char[] values) {
        this.values = values;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeAValues other = (TypeAValues) obj;
        if (!Arrays.equals(values, other.values))
            return false;
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    @Override
    public int getPayloadType() {
        return TYPE_A;
    }
}
