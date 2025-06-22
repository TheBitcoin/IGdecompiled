package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 1, byteBuffer);
        return this;
    }

    public byte get(int i4) {
        return this.bb.get(__element(i4));
    }

    public int getAsUnsigned(int i4) {
        return get(i4) & 255;
    }
}
