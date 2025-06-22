package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] bArr) {
        this.data = bArr;
        this.byteLimit = bArr.length;
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

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final boolean readBit() {
        boolean z4;
        if ((((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        skipBits(1);
        return z4;
    }

    public final int readBits(int i4) {
        int i5 = this.byteOffset;
        int min = Math.min(i4, 8 - this.bitOffset);
        int i6 = i5 + 1;
        int i7 = ((this.data[i5] & 255) >> this.bitOffset) & (255 >> (8 - min));
        while (min < i4) {
            i7 |= (this.data[i6] & 255) << min;
            min += 8;
            i6++;
        }
        int i8 = i7 & (-1 >>> (32 - i4));
        skipBits(i4);
        return i8;
    }

    public final void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public final void setPosition(int i4) {
        int i5 = i4 / 8;
        this.byteOffset = i5;
        this.bitOffset = i4 - (i5 * 8);
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
}
