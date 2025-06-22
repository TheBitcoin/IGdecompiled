package androidx.emoji2.text.flatbuffer;

interface ReadWriteBuf extends ReadBuf {
    int limit();

    void put(byte b5);

    void put(byte[] bArr, int i4, int i5);

    void putBoolean(boolean z4);

    void putDouble(double d5);

    void putFloat(float f4);

    void putInt(int i4);

    void putLong(long j4);

    void putShort(short s4);

    boolean requestCapacity(int i4);

    void set(int i4, byte b5);

    void set(int i4, byte[] bArr, int i5, int i6);

    void setBoolean(int i4, boolean z4);

    void setDouble(int i4, double d5);

    void setFloat(int i4, float f4);

    void setInt(int i4, int i5);

    void setLong(int i4, long j4);

    void setShort(int i4, short s4);

    int writePosition();
}
