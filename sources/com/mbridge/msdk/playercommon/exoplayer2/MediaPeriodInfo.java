package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource.MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j4, long j5, long j6, long j7, boolean z4, boolean z5) {
        this.id = mediaPeriodId;
        this.startPositionUs = j4;
        this.endPositionUs = j5;
        this.contentPositionUs = j6;
        this.durationUs = j7;
        this.isLastInTimelinePeriod = z4;
        this.isFinal = z5;
    }

    public final MediaPeriodInfo copyWithPeriodIndex(int i4) {
        return new MediaPeriodInfo(this.id.copyWithPeriodIndex(i4), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public final MediaPeriodInfo copyWithStartPositionUs(long j4) {
        return new MediaPeriodInfo(this.id, j4, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}
