package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    /* access modifiers changed from: protected */
    public int __element(int i4) {
        return this.vector + (i4 * this.element_size);
    }

    /* access modifiers changed from: protected */
    public void __reset(int i4, int i5, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i4;
            this.length = byteBuffer.getInt(i4 - 4);
            this.element_size = i5;
            return;
        }
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    /* access modifiers changed from: protected */
    public int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, (ByteBuffer) null);
    }
}
