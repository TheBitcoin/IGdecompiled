package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;

abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z4, ShuffleOrder shuffleOrder2) {
        this.isAtomic = z4;
        this.shuffleOrder = shuffleOrder2;
        this.childCount = shuffleOrder2.getLength();
    }

    private int getNextChildIndex(int i4, boolean z4) {
        if (z4) {
            return this.shuffleOrder.getNextIndex(i4);
        }
        if (i4 < this.childCount - 1) {
            return i4 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i4, boolean z4) {
        if (z4) {
            return this.shuffleOrder.getPreviousIndex(i4);
        }
        if (i4 > 0) {
            return i4 - 1;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByChildUid(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByPeriodIndex(int i4);

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByWindowIndex(int i4);

    /* access modifiers changed from: protected */
    public abstract Object getChildUidByChildIndex(int i4);

    /* access modifiers changed from: protected */
    public abstract int getFirstPeriodIndexByChildIndex(int i4);

    public int getFirstWindowIndex(boolean z4) {
        if (this.childCount == 0) {
            return -1;
        }
        int i4 = 0;
        if (this.isAtomic) {
            z4 = false;
        }
        if (z4) {
            i4 = this.shuffleOrder.getFirstIndex();
        }
        while (getTimelineByChildIndex(i4).isEmpty()) {
            i4 = getNextChildIndex(i4, z4);
            if (i4 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i4) + getTimelineByChildIndex(i4).getFirstWindowIndex(z4);
    }

    /* access modifiers changed from: protected */
    public abstract int getFirstWindowIndexByChildIndex(int i4);

    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int childIndexByChildUid = getChildIndexByChildUid(obj2);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(obj3)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    public int getLastWindowIndex(boolean z4) {
        int i4;
        int i5 = this.childCount;
        if (i5 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z4 = false;
        }
        if (z4) {
            i4 = this.shuffleOrder.getLastIndex();
        } else {
            i4 = i5 - 1;
        }
        while (getTimelineByChildIndex(i4).isEmpty()) {
            i4 = getPreviousChildIndex(i4, z4);
            if (i4 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i4) + getTimelineByChildIndex(i4).getLastWindowIndex(z4);
    }

    public int getNextWindowIndex(int i4, int i5, boolean z4) {
        int i6 = 0;
        if (this.isAtomic) {
            if (i5 == 1) {
                i5 = 2;
            }
            z4 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i4);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i7 = i4 - firstWindowIndexByChildIndex;
        if (i5 != 2) {
            i6 = i5;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i7, i6, z4);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z4);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z4);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z4);
        }
        if (i5 == 2) {
            return getFirstWindowIndex(z4);
        }
        return -1;
    }

    public final Timeline.Period getPeriod(int i4, Timeline.Period period, boolean z4) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i4);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i4 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z4);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z4) {
            period.uid = Pair.create(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
        }
        return period;
    }

    public int getPreviousWindowIndex(int i4, int i5, boolean z4) {
        int i6 = 0;
        if (this.isAtomic) {
            if (i5 == 1) {
                i5 = 2;
            }
            z4 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i4);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i7 = i4 - firstWindowIndexByChildIndex;
        if (i5 != 2) {
            i6 = i5;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i7, i6, z4);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z4);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z4);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z4);
        }
        if (i5 == 2) {
            return getLastWindowIndex(z4);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract Timeline getTimelineByChildIndex(int i4);

    public final Timeline.Window getWindow(int i4, Timeline.Window window, boolean z4, long j4) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i4);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        Timeline.Window window2 = window;
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i4 - firstWindowIndexByChildIndex, window2, z4, j4);
        window2.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window2.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window2;
    }
}
