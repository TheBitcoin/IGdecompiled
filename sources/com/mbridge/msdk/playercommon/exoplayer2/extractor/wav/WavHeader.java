package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.numChannels = i4;
        this.sampleRateHz = i5;
        this.averageBytesPerSecond = i6;
        this.blockAlignment = i7;
        this.bitsPerSample = i8;
        this.encoding = i9;
    }

    public final int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public final int getBytesPerFrame() {
        return this.blockAlignment;
    }

    public final long getDurationUs() {
        return ((this.dataSize / ((long) this.blockAlignment)) * 1000000) / ((long) this.sampleRateHz);
    }

    public final int getEncoding() {
        return this.encoding;
    }

    public final int getNumChannels() {
        return this.numChannels;
    }

    public final int getSampleRateHz() {
        return this.sampleRateHz;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j4) {
        int i4 = this.blockAlignment;
        long constrainValue = Util.constrainValue((((((long) this.averageBytesPerSecond) * j4) / 1000000) / ((long) i4)) * ((long) i4), 0, this.dataSize - ((long) i4));
        long j5 = this.dataStartPosition + constrainValue;
        long timeUs = getTimeUs(j5);
        SeekPoint seekPoint = new SeekPoint(timeUs, j5);
        if (timeUs < j4) {
            long j6 = this.dataSize;
            int i5 = this.blockAlignment;
            if (constrainValue != j6 - ((long) i5)) {
                long j7 = j5 + ((long) i5);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j7), j7));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j4) {
        return (Math.max(0, j4 - this.dataStartPosition) * 1000000) / ((long) this.averageBytesPerSecond);
    }

    public final boolean hasDataBounds() {
        if (this.dataStartPosition == 0 || this.dataSize == 0) {
            return false;
        }
        return true;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void setDataBounds(long j4, long j5) {
        this.dataStartPosition = j4;
        this.dataSize = j5;
    }
}
