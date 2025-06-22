package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 8, byteBuffer);
        return this;
    }

    public double get(int i4) {
        return this.bb.getDouble(__element(i4));
    }
}
