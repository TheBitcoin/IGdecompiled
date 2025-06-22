package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline2) {
        this.timeline = timeline2;
    }

    public int getFirstWindowIndex(boolean z4) {
        return this.timeline.getFirstWindowIndex(z4);
    }

    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    public int getLastWindowIndex(boolean z4) {
        return this.timeline.getLastWindowIndex(z4);
    }

    public int getNextWindowIndex(int i4, int i5, boolean z4) {
        return this.timeline.getNextWindowIndex(i4, i5, z4);
    }

    public Timeline.Period getPeriod(int i4, Timeline.Period period, boolean z4) {
        return this.timeline.getPeriod(i4, period, z4);
    }

    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    public int getPreviousWindowIndex(int i4, int i5, boolean z4) {
        return this.timeline.getPreviousWindowIndex(i4, i5, z4);
    }

    public Timeline.Window getWindow(int i4, Timeline.Window window, boolean z4, long j4) {
        return this.timeline.getWindow(i4, window, z4, j4);
    }

    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
