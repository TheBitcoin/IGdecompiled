package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z4, int i4) {
        this(z4, i4, 0);
    }

    public final synchronized Allocation allocate() {
        Allocation allocation;
        try {
            this.allocatedCount++;
            int i4 = this.availableCount;
            if (i4 > 0) {
                Allocation[] allocationArr = this.availableAllocations;
                int i5 = i4 - 1;
                this.availableCount = i5;
                allocation = allocationArr[i5];
                allocationArr[i5] = null;
            } else {
                allocation = new Allocation(new byte[this.individualAllocationSize], 0);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return allocation;
    }

    public final int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    public final synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    public final synchronized void release(Allocation allocation) {
        Allocation[] allocationArr = this.singleAllocationReleaseHolder;
        allocationArr[0] = allocation;
        release(allocationArr);
    }

    public final synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public final synchronized void setTargetBufferSize(int i4) {
        boolean z4;
        if (i4 < this.targetBufferSize) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.targetBufferSize = i4;
        if (z4) {
            trim();
        }
    }

    public final synchronized void trim() {
        try {
            int i4 = 0;
            int max = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
            int i5 = this.availableCount;
            if (max < i5) {
                if (this.initialAllocationBlock != null) {
                    int i6 = i5 - 1;
                    while (i4 <= i6) {
                        Allocation[] allocationArr = this.availableAllocations;
                        Allocation allocation = allocationArr[i4];
                        byte[] bArr = allocation.data;
                        byte[] bArr2 = this.initialAllocationBlock;
                        if (bArr == bArr2) {
                            i4++;
                        } else {
                            Allocation allocation2 = allocationArr[i6];
                            if (allocation2.data != bArr2) {
                                i6--;
                            } else {
                                allocationArr[i4] = allocation2;
                                allocationArr[i6] = allocation;
                                i6--;
                                i4++;
                            }
                        }
                    }
                    max = Math.max(max, i4);
                    if (max >= this.availableCount) {
                        return;
                    }
                }
                Arrays.fill(this.availableAllocations, max, this.availableCount, (Object) null);
                this.availableCount = max;
            }
        } finally {
            while (true) {
            }
        }
    }

    public DefaultAllocator(boolean z4, int i4, int i5) {
        Assertions.checkArgument(i4 > 0);
        Assertions.checkArgument(i5 >= 0);
        this.trimOnReset = z4;
        this.individualAllocationSize = i4;
        this.availableCount = i5;
        this.availableAllocations = new Allocation[(i5 + 100)];
        if (i5 > 0) {
            this.initialAllocationBlock = new byte[(i5 * i4)];
            for (int i6 = 0; i6 < i5; i6++) {
                this.availableAllocations[i6] = new Allocation(this.initialAllocationBlock, i6 * i4);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    public final synchronized void release(Allocation[] allocationArr) {
        try {
            int i4 = this.availableCount;
            int length = allocationArr.length + i4;
            Allocation[] allocationArr2 = this.availableAllocations;
            if (length >= allocationArr2.length) {
                this.availableAllocations = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i4 + allocationArr.length));
            }
            for (Allocation allocation : allocationArr) {
                byte[] bArr = allocation.data;
                if (bArr != this.initialAllocationBlock) {
                    if (bArr.length != this.individualAllocationSize) {
                        throw new IllegalArgumentException("Unexpected allocation: " + System.identityHashCode(allocation.data) + ", " + System.identityHashCode(this.initialAllocationBlock) + ", " + allocation.data.length + ", " + this.individualAllocationSize);
                    }
                }
                Allocation[] allocationArr3 = this.availableAllocations;
                int i5 = this.availableCount;
                this.availableCount = i5 + 1;
                allocationArr3[i5] = allocation;
            }
            this.allocatedCount -= allocationArr.length;
            notifyAll();
        } finally {
            while (true) {
            }
        }
    }
}
