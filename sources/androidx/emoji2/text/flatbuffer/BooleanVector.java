package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class BooleanVector extends BaseVector {
    public BooleanVector __assign(int i4, ByteBuffer byteBuffer) {
        __reset(i4, 1, byteBuffer);
        return this;
    }

    public boolean get(int i4) {
        if (this.bb.get(__element(i4)) != 0) {
            return true;
        }
        return false;
    }
}
