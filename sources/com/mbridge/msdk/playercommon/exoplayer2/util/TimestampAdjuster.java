package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = C.TIME_UNSET;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j4) {
        setFirstSampleTimestampUs(j4);
    }

    public static long ptsToUs(long j4) {
        return (j4 * 1000000) / 90000;
    }

    public static long usToPts(long j4) {
        return (j4 * 90000) / 1000000;
    }

    public final long adjustSampleTimestamp(long j4) {
        if (j4 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            this.lastSampleTimestampUs = j4;
        } else {
            long j5 = this.firstSampleTimestampUs;
            if (j5 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j5 - j4;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = j4;
                notifyAll();
            }
        }
        return j4 + this.timestampOffsetUs;
    }

    public final long adjustTsTimestamp(long j4) {
        if (j4 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            long usToPts = usToPts(this.lastSampleTimestampUs);
            long j5 = (4294967296L + usToPts) / MAX_PTS_PLUS_ONE;
            long j6 = ((j5 - 1) * MAX_PTS_PLUS_ONE) + j4;
            j4 += j5 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j6 - usToPts) < Math.abs(j4 - usToPts)) {
                j4 = j6;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j4));
    }

    public final long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public final long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            return this.lastSampleTimestampUs + this.timestampOffsetUs;
        }
        long j4 = this.firstSampleTimestampUs;
        if (j4 != Long.MAX_VALUE) {
            return j4;
        }
        return C.TIME_UNSET;
    }

    public final long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0;
        }
        if (this.lastSampleTimestampUs == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return this.timestampOffsetUs;
    }

    public final void reset() {
        this.lastSampleTimestampUs = C.TIME_UNSET;
    }

    public final synchronized void setFirstSampleTimestampUs(long j4) {
        boolean z4;
        if (this.lastSampleTimestampUs == C.TIME_UNSET) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.firstSampleTimestampUs = j4;
    }

    public final synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestampUs == C.TIME_UNSET) {
            wait();
        }
    }
}
