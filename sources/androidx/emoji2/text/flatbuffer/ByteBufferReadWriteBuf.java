package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte[] data() {
        return this.buffer.array();
    }

    public byte get(int i4) {
        return this.buffer.get(i4);
    }

    public boolean getBoolean(int i4) {
        if (get(i4) != 0) {
            return true;
        }
        return false;
    }

    public double getDouble(int i4) {
        return this.buffer.getDouble(i4);
    }

    public float getFloat(int i4) {
        return this.buffer.getFloat(i4);
    }

    public int getInt(int i4) {
        return this.buffer.getInt(i4);
    }

    public long getLong(int i4) {
        return this.buffer.getLong(i4);
    }

    public short getShort(int i4) {
        return this.buffer.getShort(i4);
    }

    public String getString(int i4, int i5) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i4, i5);
    }

    public int limit() {
        return this.buffer.limit();
    }

    public void put(byte[] bArr, int i4, int i5) {
        this.buffer.put(bArr, i4, i5);
    }

    public void putBoolean(boolean z4) {
        this.buffer.put(z4 ? (byte) 1 : 0);
    }

    public void putDouble(double d5) {
        this.buffer.putDouble(d5);
    }

    public void putFloat(float f4) {
        this.buffer.putFloat(f4);
    }

    public void putInt(int i4) {
        this.buffer.putInt(i4);
    }

    public void putLong(long j4) {
        this.buffer.putLong(j4);
    }

    public void putShort(short s4) {
        this.buffer.putShort(s4);
    }

    public boolean requestCapacity(int i4) {
        if (i4 <= this.buffer.limit()) {
            return true;
        }
        return false;
    }

    public void set(int i4, byte b5) {
        requestCapacity(i4 + 1);
        this.buffer.put(i4, b5);
    }

    public void setBoolean(int i4, boolean z4) {
        set(i4, z4 ? (byte) 1 : 0);
    }

    public void setDouble(int i4, double d5) {
        requestCapacity(i4 + 8);
        this.buffer.putDouble(i4, d5);
    }

    public void setFloat(int i4, float f4) {
        requestCapacity(i4 + 4);
        this.buffer.putFloat(i4, f4);
    }

    public void setInt(int i4, int i5) {
        requestCapacity(i4 + 4);
        this.buffer.putInt(i4, i5);
    }

    public void setLong(int i4, long j4) {
        requestCapacity(i4 + 8);
        this.buffer.putLong(i4, j4);
    }

    public void setShort(int i4, short s4) {
        requestCapacity(i4 + 2);
        this.buffer.putShort(i4, s4);
    }

    public int writePosition() {
        return this.buffer.position();
    }

    public void put(byte b5) {
        this.buffer.put(b5);
    }

    public void set(int i4, byte[] bArr, int i5, int i6) {
        requestCapacity((i6 - i5) + i4);
        int position = this.buffer.position();
        this.buffer.position(i4);
        this.buffer.put(bArr, i5, i6);
        this.buffer.position(position);
    }
}
