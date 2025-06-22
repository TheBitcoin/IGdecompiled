package com.mbridge.msdk.playercommon.exoplayer2.util;

public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i4, int i5) {
        reset(bArr, i4, i5);
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

    private int readExpGolombCodeNum() {
        int i4 = 0;
        int i5 = 0;
        while (!readBit()) {
            i5++;
        }
        int i6 = (1 << i5) - 1;
        if (i5 > 0) {
            i4 = readBits(i5);
        }
        return i6 + i4;
    }

    private boolean shouldSkipByte(int i4) {
        if (2 > i4 || i4 >= this.byteLimit) {
            return false;
        }
        byte[] bArr = this.data;
        if (bArr[i4] == 3 && bArr[i4 - 2] == 0 && bArr[i4 - 1] == 0) {
            return true;
        }
        return false;
    }

    public final boolean canReadBits(int i4) {
        int i5 = this.byteOffset;
        int i6 = i4 / 8;
        int i7 = i5 + i6;
        int i8 = (this.bitOffset + i4) - (i6 * 8);
        if (i8 > 7) {
            i7++;
            i8 -= 8;
        }
        while (true) {
            i5++;
            if (i5 > i7 || i7 >= this.byteLimit) {
                int i9 = this.byteLimit;
            } else if (shouldSkipByte(i5)) {
                i7++;
                i5 += 2;
            }
        }
        int i92 = this.byteLimit;
        if (i7 < i92) {
            return true;
        }
        if (i7 == i92 && i8 == 0) {
            return true;
        }
        return false;
    }

    public final boolean canReadExpGolombCodedNum() {
        boolean z4;
        int i4 = this.byteOffset;
        int i5 = this.bitOffset;
        int i6 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i6++;
        }
        if (this.byteOffset == this.byteLimit) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.byteOffset = i4;
        this.bitOffset = i5;
        if (z4 || !canReadBits((i6 * 2) + 1)) {
            return false;
        }
        return true;
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
        int i6;
        this.bitOffset += i4;
        int i7 = 0;
        while (true) {
            i5 = this.bitOffset;
            i6 = 2;
            if (i5 <= 8) {
                break;
            }
            int i8 = i5 - 8;
            this.bitOffset = i8;
            byte[] bArr = this.data;
            int i9 = this.byteOffset;
            i7 |= (bArr[i9] & 255) << i8;
            if (!shouldSkipByte(i9 + 1)) {
                i6 = 1;
            }
            this.byteOffset = i9 + i6;
        }
        byte[] bArr2 = this.data;
        int i10 = this.byteOffset;
        int i11 = (-1 >>> (32 - i4)) & (i7 | ((bArr2[i10] & 255) >> (8 - i5)));
        if (i5 == 8) {
            this.bitOffset = 0;
            if (!shouldSkipByte(i10 + 1)) {
                i6 = 1;
            }
            this.byteOffset = i10 + i6;
        }
        assertValidOffset();
        return i11;
    }

    public final int readSignedExpGolombCodedInt() {
        int i4;
        int readExpGolombCodeNum = readExpGolombCodeNum();
        if (readExpGolombCodeNum % 2 == 0) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        return i4 * ((readExpGolombCodeNum + 1) / 2);
    }

    public final int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public final void reset(byte[] bArr, int i4, int i5) {
        this.data = bArr;
        this.byteOffset = i4;
        this.byteLimit = i5;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public final void skipBit() {
        int i4 = 1;
        int i5 = this.bitOffset + 1;
        this.bitOffset = i5;
        if (i5 == 8) {
            this.bitOffset = 0;
            int i6 = this.byteOffset;
            if (shouldSkipByte(i6 + 1)) {
                i4 = 2;
            }
            this.byteOffset = i6 + i4;
        }
        assertValidOffset();
    }

    public final void skipBits(int i4) {
        int i5 = this.byteOffset;
        int i6 = i4 / 8;
        int i7 = i5 + i6;
        this.byteOffset = i7;
        int i8 = this.bitOffset + (i4 - (i6 * 8));
        this.bitOffset = i8;
        if (i8 > 7) {
            this.byteOffset = i7 + 1;
            this.bitOffset = i8 - 8;
        }
        while (true) {
            i5++;
            if (i5 > this.byteOffset) {
                assertValidOffset();
                return;
            } else if (shouldSkipByte(i5)) {
                this.byteOffset++;
                i5 += 2;
            }
        }
    }
}
