package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 2, byteBuffer);
        return this;
    }

    public short get(int i4) {
        return this.bb.getShort(__element(i4));
    }

    public int getAsUnsigned(int i4) {
        return get(i4) & 65535;
    }
}
