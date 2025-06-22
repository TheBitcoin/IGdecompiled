package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    private final boolean allowDynamicClippingUpdates;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    @Nullable
    private Object manifest;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    private static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j4, long j5) throws IllegalClippingException {
            super(timeline);
            long j6;
            long j7;
            boolean z4 = false;
            if (timeline.getPeriodCount() == 1) {
                Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), false);
                long max = Math.max(0, j4);
                if (j5 == Long.MIN_VALUE) {
                    j6 = window.durationUs;
                } else {
                    j6 = Math.max(0, j5);
                }
                long j8 = window.durationUs;
                if (j8 != C.TIME_UNSET) {
                    j6 = j6 > j8 ? j8 : j6;
                    if (max != 0 && !window.isSeekable) {
                        throw new IllegalClippingException(1);
                    } else if (max > j6) {
                        throw new IllegalClippingException(2);
                    }
                }
                this.startUs = max;
                this.endUs = j6;
                int i4 = (j6 > C.TIME_UNSET ? 1 : (j6 == C.TIME_UNSET ? 0 : -1));
                if (i4 == 0) {
                    j7 = -9223372036854775807L;
                } else {
                    j7 = j6 - max;
                }
                this.durationUs = j7;
                if (window.isDynamic && (i4 == 0 || (j8 != C.TIME_UNSET && j6 == j8))) {
                    z4 = true;
                }
                this.isDynamic = z4;
                return;
            }
            throw new IllegalClippingException(0);
        }

        public final Timeline.Period getPeriod(int i4, Timeline.Period period, boolean z4) {
            this.timeline.getPeriod(0, period, z4);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j4 = this.durationUs;
            long j5 = C.TIME_UNSET;
            if (j4 != C.TIME_UNSET) {
                j5 = j4 - positionInWindowUs;
            }
            return period.set(period.id, period.uid, 0, j5, positionInWindowUs);
        }

        public final Timeline.Window getWindow(int i4, Timeline.Window window, boolean z4, long j4) {
            Timeline.Window window2 = window;
            this.timeline.getWindow(0, window2, z4, 0);
            long j5 = window2.positionInFirstPeriodUs;
            long j6 = this.startUs;
            window2.positionInFirstPeriodUs = j5 + j6;
            window2.durationUs = this.durationUs;
            window2.isDynamic = this.isDynamic;
            long j7 = window2.defaultPositionUs;
            if (j7 != C.TIME_UNSET) {
                long max = Math.max(j7, j6);
                window2.defaultPositionUs = max;
                long j8 = this.endUs;
                if (j8 != C.TIME_UNSET) {
                    max = Math.min(max, j8);
                }
                window2.defaultPositionUs = max - this.startUs;
            }
            long usToMs = C.usToMs(this.startUs);
            long j9 = window2.presentationStartTimeMs;
            if (j9 != C.TIME_UNSET) {
                window2.presentationStartTimeMs = j9 + usToMs;
            }
            long j10 = window2.windowStartTimeMs;
            if (j10 != C.TIME_UNSET) {
                window2.windowStartTimeMs = j10 + usToMs;
            }
            return window2;
        }
    }

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i4) {
            super("Illegal clipping: " + getReasonDescription(i4));
            this.reason = i4;
        }

        private static String getReasonDescription(int i4) {
            if (i4 == 0) {
                return "invalid period count";
            }
            if (i4 == 1) {
                return "not seekable to start";
            }
            if (i4 != 2) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return "start exceeds end";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j4, long j5) {
        this(mediaSource2, j4, j5, true, false, false);
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long j4;
        Timeline timeline2 = timeline;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        long j5 = Long.MIN_VALUE;
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j6 = this.startUs;
            long j7 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j6 += defaultPositionUs;
                j7 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j6;
            if (this.endUs != Long.MIN_VALUE) {
                j5 = positionInFirstPeriodUs + j7;
            }
            this.periodEndUs = j5;
            int size = this.mediaPeriods.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mediaPeriods.get(i4).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            j4 = j6;
            j5 = j7;
        } else {
            long j8 = this.periodStartUs - positionInFirstPeriodUs;
            if (this.endUs != Long.MIN_VALUE) {
                j5 = this.periodEndUs - positionInFirstPeriodUs;
            }
            j4 = j8;
        }
        try {
            ClippingTimeline clippingTimeline2 = new ClippingTimeline(timeline2, j4, j5);
            this.clippingTimeline = clippingTimeline2;
            refreshSourceInfo(clippingTimeline2, this.manifest);
        } catch (IllegalClippingException e5) {
            this.clippingError = e5;
        }
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4) {
        super.prepareSourceInternal(exoPlayer, z4);
        prepareChildSource(null, this.mediaSource);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (this.mediaPeriods.isEmpty() && !this.allowDynamicClippingUpdates) {
            refreshClippedTimeline(this.clippingTimeline.timeline);
        }
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    @Deprecated
    public ClippingMediaSource(MediaSource mediaSource2, long j4, long j5, boolean z4) {
        this(mediaSource2, j4, j5, z4, false, false);
    }

    /* access modifiers changed from: protected */
    public final long getMediaTimeForChildMediaTime(Void voidR, long j4) {
        if (j4 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long usToMs = C.usToMs(this.startUs);
        long max = Math.max(0, j4 - usToMs);
        long j5 = this.endUs;
        return j5 != Long.MIN_VALUE ? Math.min(C.usToMs(j5) - usToMs, max) : max;
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource2, Timeline timeline, @Nullable Object obj) {
        if (this.clippingError == null) {
            this.manifest = obj;
            refreshClippedTimeline(timeline);
        }
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j4) {
        this(mediaSource2, 0, j4, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j4, long j5, boolean z4, boolean z5, boolean z6) {
        Assertions.checkArgument(j4 >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource2);
        this.startUs = j4;
        this.endUs = j5;
        this.enableInitialDiscontinuity = z4;
        this.allowDynamicClippingUpdates = z5;
        this.relativeToDefaultPosition = z6;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }
}
