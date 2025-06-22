package com.mbridge.msdk.playercommon.exoplayer2.offline;

public final class TrackKey {
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public TrackKey(int i4, int i5, int i6) {
        this.periodIndex = i4;
        this.groupIndex = i5;
        this.trackIndex = i6;
    }
}
