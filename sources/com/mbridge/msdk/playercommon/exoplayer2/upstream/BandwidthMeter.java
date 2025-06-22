package com.mbridge.msdk.playercommon.exoplayer2.upstream;

public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int i4, long j4, long j5);
    }

    long getBitrateEstimate();
}
