package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public final void add(long j4) {
        int i4 = this.size;
        long[] jArr = this.values;
        if (i4 == jArr.length) {
            this.values = Arrays.copyOf(jArr, i4 * 2);
        }
        long[] jArr2 = this.values;
        int i5 = this.size;
        this.size = i5 + 1;
        jArr2[i5] = j4;
    }

    public final long get(int i4) {
        if (i4 >= 0 && i4 < this.size) {
            return this.values[i4];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i4 + ", size is " + this.size);
    }

    public final int size() {
        return this.size;
    }

    public final long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }

    public LongArray(int i4) {
        this.values = new long[i4];
    }
}
