package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i4, int i5, ByteBuffer byteBuffer) {
        __reset(i4, i5, byteBuffer);
        return this;
    }

    public String get(int i4) {
        return Table.__string(__element(i4), this.bb, this.utf8);
    }
}
