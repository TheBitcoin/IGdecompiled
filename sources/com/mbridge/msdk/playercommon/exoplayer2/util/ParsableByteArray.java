package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
    }

    public final int bytesLeft() {
        return this.limit - this.position;
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final char peekChar() {
        byte[] bArr = this.data;
        int i4 = this.position;
        return (char) ((bArr[i4 + 1] & 255) | ((bArr[i4] & 255) << 8));
    }

    public final int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public final void readBytes(ParsableBitArray parsableBitArray, int i4) {
        readBytes(parsableBitArray.data, 0, i4);
        parsableBitArray.setPosition(0);
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        byte b5 = ((bArr[i5] & 255) << 16) | ((bArr[i4] & 255) << 24);
        int i7 = i4 + 3;
        this.position = i7;
        this.position = i4 + 4;
        return (bArr[i7] & 255) | b5 | ((bArr[i6] & 255) << 8);
    }

    public final int readInt24() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.position = i4 + 3;
        return (bArr[i6] & 255) | i7 | (((bArr[i4] & 255) << 24) >> 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r0 == r2) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String readLine() {
        /*
            r6 = this;
            int r0 = r6.bytesLeft()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            int r0 = r6.position
        L_0x000a:
            int r1 = r6.limit
            if (r0 >= r1) goto L_0x001b
            byte[] r1 = r6.data
            byte r1 = r1[r0]
            boolean r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.isLinebreak(r1)
            if (r1 != 0) goto L_0x001b
            int r0 = r0 + 1
            goto L_0x000a
        L_0x001b:
            int r1 = r6.position
            int r2 = r0 - r1
            r3 = 3
            if (r2 < r3) goto L_0x003d
            byte[] r2 = r6.data
            byte r4 = r2[r1]
            r5 = -17
            if (r4 != r5) goto L_0x003d
            int r4 = r1 + 1
            byte r4 = r2[r4]
            r5 = -69
            if (r4 != r5) goto L_0x003d
            int r4 = r1 + 2
            byte r2 = r2[r4]
            r4 = -65
            if (r2 != r4) goto L_0x003d
            int r1 = r1 + r3
            r6.position = r1
        L_0x003d:
            byte[] r1 = r6.data
            int r2 = r6.position
            int r3 = r0 - r2
            java.lang.String r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.fromUtf8Bytes(r1, r2, r3)
            r6.position = r0
            int r2 = r6.limit
            if (r0 != r2) goto L_0x004e
            goto L_0x0069
        L_0x004e:
            byte[] r3 = r6.data
            byte r4 = r3[r0]
            r5 = 13
            if (r4 != r5) goto L_0x005d
            int r0 = r0 + 1
            r6.position = r0
            if (r0 != r2) goto L_0x005d
            goto L_0x0069
        L_0x005d:
            int r0 = r6.position
            byte r2 = r3[r0]
            r3 = 10
            if (r2 != r3) goto L_0x0069
            int r0 = r0 + 1
            r6.position = r0
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray.readLine():java.lang.String");
    }

    public final int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        byte b5 = ((bArr[i5] & 255) << 8) | (bArr[i4] & 255);
        int i7 = i4 + 3;
        this.position = i7;
        this.position = i4 + 4;
        return ((bArr[i7] & 255) << 24) | b5 | ((bArr[i6] & 255) << 16);
    }

    public final int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.position = i4 + 3;
        return ((bArr[i6] & 255) << 16) | i7 | (bArr[i4] & 255);
    }

    public final long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        long j4 = (((long) bArr[i4]) & 255) | ((((long) bArr[i5]) & 255) << 8);
        int i7 = i4 + 3;
        this.position = i7;
        int i8 = i4 + 4;
        this.position = i8;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 24);
        int i9 = i4 + 5;
        this.position = i9;
        int i10 = i4 + 6;
        this.position = i10;
        long j6 = j5 | ((((long) bArr[i8]) & 255) << 32) | ((((long) bArr[i9]) & 255) << 40);
        int i11 = i4 + 7;
        this.position = i11;
        this.position = i4 + 8;
        return ((((long) bArr[i11]) & 255) << 56) | j6 | ((((long) bArr[i10]) & 255) << 48);
    }

    public final short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i4 + 2;
        return (short) (((bArr[i5] & 255) << 8) | (bArr[i4] & 255));
    }

    public final long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = i4 + 3;
        this.position = i7;
        this.position = i4 + 4;
        return ((((long) bArr[i7]) & 255) << 24) | (((long) bArr[i4]) & 255) | ((((long) bArr[i5]) & 255) << 8) | ((((long) bArr[i6]) & 255) << 16);
    }

    public final int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.position = i4 + 3;
        return ((bArr[i6] & 255) << 16) | i7 | (bArr[i4] & 255);
    }

    public final int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
    }

    public final int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i4 + 2;
        return ((bArr[i5] & 255) << 8) | (bArr[i4] & 255);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = i4 + 3;
        this.position = i7;
        long j4 = ((((long) bArr[i4]) & 255) << 56) | ((((long) bArr[i5]) & 255) << 48) | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i4 + 4;
        this.position = i8;
        int i9 = i4 + 5;
        this.position = i9;
        long j5 = j4 | ((((long) bArr[i7]) & 255) << 32) | ((((long) bArr[i8]) & 255) << 24);
        int i10 = i4 + 6;
        this.position = i10;
        int i11 = i4 + 7;
        this.position = i11;
        this.position = i4 + 8;
        return (((long) bArr[i11]) & 255) | j5 | ((((long) bArr[i9]) & 255) << 16) | ((((long) bArr[i10]) & 255) << 8);
    }

    public final String readNullTerminatedString(int i4) {
        if (i4 == 0) {
            return "";
        }
        int i5 = this.position;
        int i6 = (i5 + i4) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.data, i5, (i6 >= this.limit || this.data[i6] != 0) ? i4 : i4 - 1);
        this.position += i4;
        return fromUtf8Bytes;
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i4 + 2;
        return (short) ((bArr[i5] & 255) | ((bArr[i4] & 255) << 8));
    }

    public final String readString(int i4) {
        return readString(i4, Charset.forName(C.UTF8_NAME));
    }

    public final int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i4 = this.position;
        this.position = i4 + 1;
        return bArr[i4] & 255;
    }

    public final int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i4 + 2;
        byte b5 = (bArr[i5] & 255) | ((bArr[i4] & 255) << 8);
        this.position = i4 + 4;
        return b5;
    }

    public final long readUnsignedInt() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = i4 + 3;
        this.position = i7;
        this.position = i4 + 4;
        return (((long) bArr[i7]) & 255) | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 16) | ((((long) bArr[i6]) & 255) << 8);
    }

    public final int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i4 + 2;
        this.position = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.position = i4 + 3;
        return (bArr[i6] & 255) | i7 | ((bArr[i4] & 255) << 16);
    }

    public final int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public final long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i4 + 2;
        return (bArr[i5] & 255) | ((bArr[i4] & 255) << 8);
    }

    public final long readUtf8EncodedLong() {
        int i4;
        int i5;
        long j4 = (long) this.data[this.position];
        int i6 = 7;
        while (true) {
            i4 = 1;
            if (i6 < 0) {
                break;
            }
            int i7 = 1 << i6;
            if ((((long) i7) & j4) != 0) {
                i6--;
            } else if (i6 < 6) {
                j4 &= (long) (i7 - 1);
                i5 = 7 - i6;
            } else if (i6 == 7) {
                i5 = 1;
            }
        }
        i5 = 0;
        if (i5 != 0) {
            while (i4 < i5) {
                byte b5 = this.data[this.position + i4];
                if ((b5 & 192) == 128) {
                    j4 = (j4 << 6) | ((long) (b5 & 63));
                    i4++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j4);
                }
            }
            this.position += i5;
            return j4;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j4);
    }

    public final void reset(int i4) {
        reset(capacity() < i4 ? new byte[i4] : this.data, i4);
    }

    public final void setLimit(int i4) {
        boolean z4;
        if (i4 < 0 || i4 > this.data.length) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkArgument(z4);
        this.limit = i4;
    }

    public final void setPosition(int i4) {
        boolean z4;
        if (i4 < 0 || i4 > this.limit) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkArgument(z4);
        this.position = i4;
    }

    public final void skipBytes(int i4) {
        setPosition(this.position + i4);
    }

    public ParsableByteArray(int i4) {
        this.data = new byte[i4];
        this.limit = i4;
    }

    public final String readString(int i4, Charset charset) {
        String str = new String(this.data, this.position, i4, charset);
        this.position += i4;
        return str;
    }

    public final void reset(byte[] bArr, int i4) {
        this.data = bArr;
        this.limit = i4;
        this.position = 0;
    }

    public final void readBytes(byte[] bArr, int i4, int i5) {
        System.arraycopy(this.data, this.position, bArr, i4, i5);
        this.position += i5;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public final void readBytes(ByteBuffer byteBuffer, int i4) {
        byteBuffer.put(this.data, this.position, i4);
        this.position += i4;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i4 = this.position;
        while (i4 < this.limit && this.data[i4] != 0) {
            i4++;
        }
        byte[] bArr = this.data;
        int i5 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i5, i4 - i5);
        this.position = i4;
        if (i4 < this.limit) {
            this.position = i4 + 1;
        }
        return fromUtf8Bytes;
    }

    public ParsableByteArray(byte[] bArr, int i4) {
        this.data = bArr;
        this.limit = i4;
    }
}
