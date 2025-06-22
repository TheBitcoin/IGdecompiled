package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 8, byteBuffer);
        return this;
    }

    public long get(int i4) {
        return this.bb.getLong(__element(i4));
    }
}
