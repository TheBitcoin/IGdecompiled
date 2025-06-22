package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class IntVector extends BaseVector {
    public IntVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 4, byteBuffer);
        return this;
    }

    public int get(int i4) {
        return this.bb.getInt(__element(i4));
    }

    public long getAsUnsigned(int i4) {
        return ((long) get(i4)) & 4294967295L;
    }
}
