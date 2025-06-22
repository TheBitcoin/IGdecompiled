package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public static long assembleVarint(byte[] bArr, int i4, boolean z4) {
        long j4 = ((long) bArr[0]) & 255;
        if (z4) {
            j4 &= ~VARINT_LENGTH_MASKS[i4 - 1];
        }
        for (int i5 = 1; i5 < i4; i5++) {
            j4 = (j4 << 8) | (((long) bArr[i5]) & 255);
        }
        return j4;
    }

    public static int parseUnsignedVarintLength(int i4) {
        int i5 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i5 >= jArr.length) {
                return -1;
            }
            if ((jArr[i5] & ((long) i4)) != 0) {
                return i5 + 1;
            }
            i5++;
        }
    }

    public final int getLastLength() {
        return this.length;
    }

    public final long readUnsignedVarint(ExtractorInput extractorInput, boolean z4, boolean z5, int i4) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z4)) {
                return -1;
            }
            int parseUnsignedVarintLength = parseUnsignedVarintLength(this.scratch[0] & 255);
            this.length = parseUnsignedVarintLength;
            if (parseUnsignedVarintLength != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i5 = this.length;
        if (i5 > i4) {
            this.state = 0;
            return -2;
        }
        if (i5 != 1) {
            extractorInput.readFully(this.scratch, 1, i5 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z5);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }
}
