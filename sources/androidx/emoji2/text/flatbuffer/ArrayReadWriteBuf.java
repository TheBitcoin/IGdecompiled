package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public byte[] data() {
        return this.buffer;
    }

    public byte get(int i4) {
        return this.buffer[i4];
    }

    public boolean getBoolean(int i4) {
        if (this.buffer[i4] != 0) {
            return true;
        }
        return false;
    }

    public double getDouble(int i4) {
        return Double.longBitsToDouble(getLong(i4));
    }

    public float getFloat(int i4) {
        return Float.intBitsToFloat(getInt(i4));
    }

    public int getInt(int i4) {
        byte[] bArr = this.buffer;
        return (bArr[i4] & 255) | (bArr[i4 + 3] << 24) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
    }

    public long getLong(int i4) {
        byte[] bArr = this.buffer;
        long j4 = (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32);
        int i5 = i4 + 6;
        return (((long) bArr[i4 + 7]) << 56) | j4 | ((((long) bArr[i4 + 5]) & 255) << 40) | ((255 & ((long) bArr[i5])) << 48);
    }

    public short getShort(int i4) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i4] & 255) | (bArr[i4 + 1] << 8));
    }

    public String getString(int i4, int i5) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i4, i5);
    }

    public int limit() {
        return this.writePos;
    }

    public void put(byte[] bArr, int i4, int i5) {
        set(this.writePos, bArr, i4, i5);
        this.writePos += i5;
    }

    public void putBoolean(boolean z4) {
        setBoolean(this.writePos, z4);
        this.writePos++;
    }

    public void putDouble(double d5) {
        setDouble(this.writePos, d5);
        this.writePos += 8;
    }

    public void putFloat(float f4) {
        setFloat(this.writePos, f4);
        this.writePos += 4;
    }

    public void putInt(int i4) {
        setInt(this.writePos, i4);
        this.writePos += 4;
    }

    public void putLong(long j4) {
        setLong(this.writePos, j4);
        this.writePos += 8;
    }

    public void putShort(short s4) {
        setShort(this.writePos, s4);
        this.writePos += 2;
    }

    public boolean requestCapacity(int i4) {
        byte[] bArr = this.buffer;
        if (bArr.length > i4) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    public void set(int i4, byte b5) {
        requestCapacity(i4 + 1);
        this.buffer[i4] = b5;
    }

    public void setBoolean(int i4, boolean z4) {
        set(i4, z4 ? (byte) 1 : 0);
    }

    public void setDouble(int i4, double d5) {
        requestCapacity(i4 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d5);
        int i5 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i4] = (byte) (i5 & 255);
        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((i5 >> 16) & 255);
        bArr[i4 + 3] = (byte) ((i5 >> 24) & 255);
        int i6 = (int) (doubleToRawLongBits >> 32);
        bArr[i4 + 4] = (byte) (i6 & 255);
        bArr[i4 + 5] = (byte) ((i6 >> 8) & 255);
        bArr[i4 + 6] = (byte) ((i6 >> 16) & 255);
        bArr[i4 + 7] = (byte) ((i6 >> 24) & 255);
    }

    public void setFloat(int i4, float f4) {
        requestCapacity(i4 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f4);
        byte[] bArr = this.buffer;
        bArr[i4] = (byte) (floatToRawIntBits & 255);
        bArr[i4 + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i4 + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i4 + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    public void setInt(int i4, int i5) {
        requestCapacity(i4 + 4);
        byte[] bArr = this.buffer;
        bArr[i4] = (byte) (i5 & 255);
        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((i5 >> 16) & 255);
        bArr[i4 + 3] = (byte) ((i5 >> 24) & 255);
    }

    public void setLong(int i4, long j4) {
        requestCapacity(i4 + 8);
        int i5 = (int) j4;
        byte[] bArr = this.buffer;
        bArr[i4] = (byte) (i5 & 255);
        bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((i5 >> 16) & 255);
        bArr[i4 + 3] = (byte) ((i5 >> 24) & 255);
        int i6 = (int) (j4 >> 32);
        bArr[i4 + 4] = (byte) (i6 & 255);
        bArr[i4 + 5] = (byte) ((i6 >> 8) & 255);
        bArr[i4 + 6] = (byte) ((i6 >> 16) & 255);
        bArr[i4 + 7] = (byte) ((i6 >> 24) & 255);
    }

    public void setShort(int i4, short s4) {
        requestCapacity(i4 + 2);
        byte[] bArr = this.buffer;
        bArr[i4] = (byte) (s4 & 255);
        bArr[i4 + 1] = (byte) ((s4 >> 8) & 255);
    }

    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i4) {
        this(new byte[i4]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    public void put(byte b5) {
        set(this.writePos, b5);
        this.writePos++;
    }

    public void set(int i4, byte[] bArr, int i5, int i6) {
        requestCapacity((i6 - i5) + i4);
        System.arraycopy(bArr, i5, this.buffer, i4, i6);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i4) {
        this.buffer = bArr;
        this.writePos = i4;
    }
}
