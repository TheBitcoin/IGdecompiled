package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i4, int i5, ByteBuffer byteBuffer) {
        __reset(i4, i5, byteBuffer);
        return this;
    }

    public Table get(Table table, int i4) {
        return Table.__union(table, __element(i4), this.bb);
    }
}
