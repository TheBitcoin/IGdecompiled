package com.mbridge.msdk.playercommon.exoplayer2.util;

public final class FlacStreamInfo {
    public final int bitsPerSample;
    public final int channels;
    public final int maxBlockSize;
    public final int maxFrameSize;
    public final int minBlockSize;
    public final int minFrameSize;
    public final int sampleRate;
    public final long totalSamples;

    public FlacStreamInfo(byte[] bArr, int i4) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.setPosition(i4 * 8);
        this.minBlockSize = parsableBitArray.readBits(16);
        this.maxBlockSize = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        this.sampleRate = parsableBitArray.readBits(20);
        this.channels = parsableBitArray.readBits(3) + 1;
        this.bitsPerSample = parsableBitArray.readBits(5) + 1;
        this.totalSamples = ((((long) parsableBitArray.readBits(4)) & 15) << 32) | (((long) parsableBitArray.readBits(32)) & 4294967295L);
    }

    public final int bitRate() {
        return this.bitsPerSample * this.sampleRate;
    }

    public final long durationUs() {
        return (this.totalSamples * 1000000) / ((long) this.sampleRate);
    }

    public final long getApproxBytesPerFrame() {
        long j4;
        long j5;
        long j6;
        int i4 = this.maxFrameSize;
        if (i4 > 0) {
            j5 = (((long) i4) + ((long) this.minFrameSize)) / 2;
            j6 = 1;
        } else {
            int i5 = this.minBlockSize;
            if (i5 != this.maxBlockSize || i5 <= 0) {
                j4 = 4096;
            } else {
                j4 = (long) i5;
            }
            j5 = ((j4 * ((long) this.channels)) * ((long) this.bitsPerSample)) / 8;
            j6 = 64;
        }
        return j5 + j6;
    }

    public final long getSampleIndex(long j4) {
        return Util.constrainValue((j4 * ((long) this.sampleRate)) / 1000000, 0, this.totalSamples - 1);
    }

    public final int maxDecodedFrameSize() {
        return this.maxBlockSize * this.channels * (this.bitsPerSample / 8);
    }

    public FlacStreamInfo(int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4) {
        this.minBlockSize = i4;
        this.maxBlockSize = i5;
        this.minFrameSize = i6;
        this.maxFrameSize = i7;
        this.sampleRate = i8;
        this.channels = i9;
        this.bitsPerSample = i10;
        this.totalSamples = j4;
    }
}
