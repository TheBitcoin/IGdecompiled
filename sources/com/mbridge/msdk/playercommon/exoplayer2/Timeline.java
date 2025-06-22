package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdPlaybackState;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() {
        public final int getIndexOfPeriod(Object obj) {
            return -1;
        }

        public final Period getPeriod(int i4, Period period, boolean z4) {
            throw new IndexOutOfBoundsException();
        }

        public final int getPeriodCount() {
            return 0;
        }

        public final Window getWindow(int i4, Window window, boolean z4, long j4) {
            throw new IndexOutOfBoundsException();
        }

        public final int getWindowCount() {
            return 0;
        }
    };

    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public final int getAdCountInAdGroup(int i4) {
            return this.adPlaybackState.adGroups[i4].count;
        }

        public final long getAdDurationUs(int i4, int i5) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i4];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i5];
            }
            return C.TIME_UNSET;
        }

        public final int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public final int getAdGroupIndexAfterPositionUs(long j4) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j4);
        }

        public final int getAdGroupIndexForPositionUs(long j4) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j4);
        }

        public final long getAdGroupTimeUs(int i4) {
            return this.adPlaybackState.adGroupTimesUs[i4];
        }

        public final long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final int getFirstAdIndexToPlay(int i4) {
            return this.adPlaybackState.adGroups[i4].getFirstAdIndexToPlay();
        }

        public final int getNextAdIndexToPlay(int i4, int i5) {
            return this.adPlaybackState.adGroups[i4].getNextAdIndexToPlay(i5);
        }

        public final long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public final long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public final boolean hasPlayedAdGroup(int i4) {
            return !this.adPlaybackState.adGroups[i4].hasUnplayedAds();
        }

        public final boolean isAdAvailable(int i4, int i5) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i4];
            if (adGroup.count == -1 || adGroup.states[i5] == 0) {
                return false;
            }
            return true;
        }

        public final Period set(Object obj, Object obj2, int i4, long j4, long j5) {
            return set(obj, obj2, i4, j4, j5, AdPlaybackState.NONE);
        }

        public final Period set(Object obj, Object obj2, int i4, long j4, long j5, AdPlaybackState adPlaybackState2) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i4;
            this.durationUs = j4;
            this.positionInWindowUs = j5;
            this.adPlaybackState = adPlaybackState2;
            return this;
        }
    }

    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        @Nullable
        public Object tag;
        public long windowStartTimeMs;

        public final long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public final long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public final long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public final Window set(@Nullable Object obj, long j4, long j5, boolean z4, boolean z5, long j6, long j7, int i4, int i5, long j8) {
            this.tag = obj;
            this.presentationStartTimeMs = j4;
            this.windowStartTimeMs = j5;
            this.isSeekable = z4;
            this.isDynamic = z5;
            this.defaultPositionUs = j6;
            this.durationUs = j7;
            this.firstPeriodIndex = i4;
            this.lastPeriodIndex = i5;
            this.positionInFirstPeriodUs = j8;
            return this;
        }
    }

    public int getFirstWindowIndex(boolean z4) {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z4) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i4, Period period, Window window, int i5, boolean z4) {
        int i6 = getPeriod(i4, period).windowIndex;
        if (getWindow(i6, window).lastPeriodIndex != i4) {
            return i4 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i6, i5, z4);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i4, int i5, boolean z4) {
        if (i5 != 0) {
            if (i5 == 1) {
                return i4;
            }
            if (i5 != 2) {
                throw new IllegalStateException();
            } else if (i4 == getLastWindowIndex(z4)) {
                return getFirstWindowIndex(z4);
            } else {
                return i4 + 1;
            }
        } else if (i4 == getLastWindowIndex(z4)) {
            return -1;
        } else {
            return i4 + 1;
        }
    }

    public final Period getPeriod(int i4, Period period) {
        return getPeriod(i4, period, false);
    }

    public abstract Period getPeriod(int i4, Period period, boolean z4);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i4, long j4) {
        return getPeriodPosition(window, period, i4, j4, 0);
    }

    public int getPreviousWindowIndex(int i4, int i5, boolean z4) {
        if (i5 != 0) {
            if (i5 == 1) {
                return i4;
            }
            if (i5 != 2) {
                throw new IllegalStateException();
            } else if (i4 == getFirstWindowIndex(z4)) {
                return getLastWindowIndex(z4);
            } else {
                return i4 - 1;
            }
        } else if (i4 == getFirstWindowIndex(z4)) {
            return -1;
        } else {
            return i4 - 1;
        }
    }

    public final Window getWindow(int i4, Window window) {
        return getWindow(i4, window, false);
    }

    public abstract Window getWindow(int i4, Window window, boolean z4, long j4);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        if (getWindowCount() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isLastPeriod(int i4, Period period, Window window, int i5, boolean z4) {
        if (getNextPeriodIndex(i4, period, window, i5, z4) == -1) {
            return true;
        }
        return false;
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i4, long j4, long j5) {
        Assertions.checkIndex(i4, 0, getWindowCount());
        Window window2 = window;
        getWindow(i4, window2, false, j5);
        if (j4 == C.TIME_UNSET) {
            j4 = window2.getDefaultPositionUs();
            if (j4 == C.TIME_UNSET) {
                return null;
            }
        }
        int i5 = window2.firstPeriodIndex;
        long positionInFirstPeriodUs = window2.getPositionInFirstPeriodUs() + j4;
        long durationUs = getPeriod(i5, period).getDurationUs();
        while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i5 < window2.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i5++;
            durationUs = getPeriod(i5, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i5), Long.valueOf(positionInFirstPeriodUs));
    }

    public final Window getWindow(int i4, Window window, boolean z4) {
        return getWindow(i4, window, z4, 0);
    }
}
