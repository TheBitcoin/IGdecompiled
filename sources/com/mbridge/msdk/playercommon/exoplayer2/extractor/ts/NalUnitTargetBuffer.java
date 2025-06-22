package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i4, int i5) {
        this.targetType = i4;
        byte[] bArr = new byte[(i5 + 3)];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public final void appendToNalUnit(byte[] bArr, int i4, int i5) {
        if (this.isFilling) {
            int i6 = i5 - i4;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i7 = this.nalLength;
            if (length < i7 + i6) {
                this.nalData = Arrays.copyOf(bArr2, (i7 + i6) * 2);
            }
            System.arraycopy(bArr, i4, this.nalData, this.nalLength, i6);
            this.nalLength += i6;
        }
    }

    public final boolean endNalUnit(int i4) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i4;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public final void startNalUnit(int i4) {
        boolean z4 = true;
        Assertions.checkState(!this.isFilling);
        if (i4 != this.targetType) {
            z4 = false;
        }
        this.isFilling = z4;
        if (z4) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}
