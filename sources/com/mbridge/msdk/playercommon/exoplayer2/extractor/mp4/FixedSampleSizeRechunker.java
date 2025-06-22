package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] jArr, int[] iArr, int i4, long[] jArr2, int[] iArr2, long j4) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i4;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j4;
        }
    }

    private FixedSampleSizeRechunker() {
    }

    public static Results rechunk(int i4, long[] jArr, int[] iArr, long j4) {
        int[] iArr2 = iArr;
        int i5 = 8192 / i4;
        int i6 = 0;
        for (int ceilDivide : iArr2) {
            i6 += Util.ceilDivide(ceilDivide, i5);
        }
        long[] jArr2 = new long[i6];
        int[] iArr3 = new int[i6];
        long[] jArr3 = new long[i6];
        int[] iArr4 = new int[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            int i11 = iArr2[i10];
            long j5 = jArr[i10];
            while (i11 > 0) {
                int min = Math.min(i5, i11);
                jArr2[i8] = j5;
                int i12 = i4 * min;
                iArr3[i8] = i12;
                i9 = Math.max(i9, i12);
                jArr3[i8] = ((long) i7) * j4;
                iArr4[i8] = 1;
                j5 += (long) iArr3[i8];
                i7 += min;
                i11 -= min;
                i8++;
            }
        }
        return new Results(jArr2, iArr3, i9, jArr3, iArr4, j4 * ((long) i7));
    }
}
