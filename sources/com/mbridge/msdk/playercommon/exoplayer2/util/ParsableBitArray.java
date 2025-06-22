package com.mbridge.msdk.playercommon.exoplayer2.util;

import androidx.core.view.MotionEventCompat;

public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
    }

    private void assertValidOffset() {
        boolean z4;
        int i4;
        int i5 = this.byteOffset;
        if (i5 < 0 || (i5 >= (i4 = this.byteLimit) && !(i5 == i4 && this.bitOffset == 0))) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkState(z4);
    }

    public final int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public final void byteAlign() {
        if (this.bitOffset != 0) {
            this.bitOffset = 0;
            this.byteOffset++;
            assertValidOffset();
        }
    }

    public final int getBytePosition() {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        return this.byteOffset;
    }

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final void putInt(int i4, int i5) {
        if (i5 < 32) {
            i4 &= (1 << i5) - 1;
        }
        int min = Math.min(8 - this.bitOffset, i5);
        int i6 = this.bitOffset;
        int i7 = (8 - i6) - min;
        byte b5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i6) | ((1 << i7) - 1);
        byte[] bArr = this.data;
        int i8 = this.byteOffset;
        byte b6 = (byte) (b5 & bArr[i8]);
        bArr[i8] = b6;
        int i9 = i5 - min;
        bArr[i8] = (byte) (b6 | ((i4 >>> i9) << i7));
        int i10 = i8 + 1;
        while (i9 > 8) {
            this.data[i10] = (byte) (i4 >>> (i9 - 8));
            i9 -= 8;
            i10++;
        }
        int i11 = 8 - i9;
        byte[] bArr2 = this.data;
        byte b7 = (byte) (bArr2[i10] & ((1 << i11) - 1));
        bArr2[i10] = b7;
        bArr2[i10] = (byte) (((i4 & ((1 << i9) - 1)) << i11) | b7);
        skipBits(i5);
        assertValidOffset();
    }

    public final boolean readBit() {
        boolean z4;
        if ((this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        skipBit();
        return z4;
    }

    public final int readBits(int i4) {
        int i5;
        if (i4 == 0) {
            return 0;
        }
        this.bitOffset += i4;
        int i6 = 0;
        while (true) {
            i5 = this.bitOffset;
            if (i5 <= 8) {
                break;
            }
            int i7 = i5 - 8;
            this.bitOffset = i7;
            byte[] bArr = this.data;
            int i8 = this.byteOffset;
            this.byteOffset = i8 + 1;
            i6 |= (bArr[i8] & 255) << i7;
        }
        byte[] bArr2 = this.data;
        int i9 = this.byteOffset;
        int i10 = (-1 >>> (32 - i4)) & (i6 | ((bArr2[i9] & 255) >> (8 - i5)));
        if (i5 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i9 + 1;
        }
        assertValidOffset();
        return i10;
    }

    public final void readBytes(byte[] bArr, int i4, int i5) {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        System.arraycopy(this.data, this.byteOffset, bArr, i4, i5);
        this.byteOffset += i5;
        assertValidOffset();
    }

    public final void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public final void setPosition(int i4) {
        int i5 = i4 / 8;
        this.byteOffset = i5;
        this.bitOffset = i4 - (i5 * 8);
        assertValidOffset();
    }

    public final void skipBit() {
        int i4 = this.bitOffset + 1;
        this.bitOffset = i4;
        if (i4 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public final void skipBits(int i4) {
        int i5 = i4 / 8;
        int i6 = this.byteOffset + i5;
        this.byteOffset = i6;
        int i7 = this.bitOffset + (i4 - (i5 * 8));
        this.bitOffset = i7;
        if (i7 > 7) {
            this.byteOffset = i6 + 1;
            this.bitOffset = i7 - 8;
        }
        assertValidOffset();
    }

    public final void skipBytes(int i4) {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.byteOffset += i4;
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public final void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr, int i4) {
        this.data = bArr;
        this.byteLimit = i4;
    }

    public final void reset(byte[] bArr, int i4) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i4;
    }

    public final void readBits(byte[] bArr, int i4, int i5) {
        int i6 = (i5 >> 3) + i4;
        while (i4 < i6) {
            byte[] bArr2 = this.data;
            int i7 = this.byteOffset;
            int i8 = i7 + 1;
            this.byteOffset = i8;
            byte b5 = bArr2[i7];
            int i9 = this.bitOffset;
            byte b6 = (byte) (b5 << i9);
            bArr[i4] = b6;
            bArr[i4] = (byte) (((255 & bArr2[i8]) >> (8 - i9)) | b6);
            i4++;
        }
        int i10 = i5 & 7;
        if (i10 != 0) {
            byte b7 = (byte) (bArr[i6] & (255 >> i10));
            bArr[i6] = b7;
            int i11 = this.bitOffset;
            if (i11 + i10 > 8) {
                byte[] bArr3 = this.data;
                int i12 = this.byteOffset;
                this.byteOffset = i12 + 1;
                bArr[i6] = (byte) (b7 | ((bArr3[i12] & 255) << i11));
                this.bitOffset = i11 - 8;
            }
            int i13 = this.bitOffset + i10;
            this.bitOffset = i13;
            byte[] bArr4 = this.data;
            int i14 = this.byteOffset;
            bArr[i6] = (byte) (((byte) (((255 & bArr4[i14]) >> (8 - i13)) << (8 - i10))) | bArr[i6]);
            if (i13 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i14 + 1;
            }
            assertValidOffset();
        }
    }
}
