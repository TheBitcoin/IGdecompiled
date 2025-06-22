package com.mbridge.msdk.playercommon.exoplayer2.decoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public class DecoderInputBuffer extends Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public long timeUs;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public DecoderInputBuffer(int i4) {
        this.bufferReplacementMode = i4;
    }

    private ByteBuffer createReplacementByteBuffer(int i4) {
        int i5;
        int i6 = this.bufferReplacementMode;
        if (i6 == 1) {
            return ByteBuffer.allocate(i4);
        }
        if (i6 == 2) {
            return ByteBuffer.allocateDirect(i4);
        }
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            i5 = 0;
        } else {
            i5 = byteBuffer.capacity();
        }
        throw new IllegalStateException("Buffer too small (" + i5 + " < " + i4 + ")");
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        return new DecoderInputBuffer(0);
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void ensureSpaceForWrite(int i4) throws IllegalStateException {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(i4);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.data.position();
        int i5 = i4 + position;
        if (capacity < i5) {
            ByteBuffer createReplacementByteBuffer = createReplacementByteBuffer(i5);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                createReplacementByteBuffer.put(this.data);
            }
            this.data = createReplacementByteBuffer;
        }
    }

    public final void flip() {
        this.data.flip();
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    public final boolean isFlagsOnly() {
        if (this.data == null && this.bufferReplacementMode == 0) {
            return true;
        }
        return false;
    }
}
