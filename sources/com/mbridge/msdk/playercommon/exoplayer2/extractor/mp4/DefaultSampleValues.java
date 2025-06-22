package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

final class DefaultSampleValues {
    public final int duration;
    public final int flags;
    public final int sampleDescriptionIndex;
    public final int size;

    public DefaultSampleValues(int i4, int i5, int i6, int i7) {
        this.sampleDescriptionIndex = i4;
        this.duration = i5;
        this.size = i6;
        this.flags = i7;
    }
}
