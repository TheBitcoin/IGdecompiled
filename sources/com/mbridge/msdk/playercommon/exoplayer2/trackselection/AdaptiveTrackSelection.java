package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public static final class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory(BandwidthMeter bandwidthMeter2) {
            this(bandwidthMeter2, 10000, 25000, 25000, 0.75f, 0.75f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
        }

        public Factory(BandwidthMeter bandwidthMeter2, int i4, int i5, int i6, float f4) {
            this(bandwidthMeter2, i4, i5, i6, f4, 0.75f, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
        }

        public final AdaptiveTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new AdaptiveTrackSelection(trackGroup, iArr, this.bandwidthMeter, (long) this.minDurationForQualityIncreaseMs, (long) this.maxDurationForQualityDecreaseMs, (long) this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }

        public Factory(BandwidthMeter bandwidthMeter2, int i4, int i5, int i6, float f4, float f5, long j4, Clock clock2) {
            this.bandwidthMeter = bandwidthMeter2;
            this.minDurationForQualityIncreaseMs = i4;
            this.maxDurationForQualityDecreaseMs = i5;
            this.minDurationToRetainAfterDiscardMs = i6;
            this.bandwidthFraction = f4;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f5;
            this.minTimeBetweenBufferReevaluationMs = j4;
            this.clock = clock2;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2) {
        this(trackGroup, iArr, bandwidthMeter2, WorkRequest.MIN_BACKOFF_MILLIS, 25000, 25000, 0.75f, 0.75f, DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, Clock.DEFAULT);
    }

    private int determineIdealSelectedIndex(long j4) {
        long bitrateEstimate = (long) (((float) this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction);
        int i4 = 0;
        for (int i5 = 0; i5 < this.length; i5++) {
            if (j4 == Long.MIN_VALUE || !isBlacklisted(i5, j4)) {
                if (((long) Math.round(((float) getFormat(i5).bitrate) * this.playbackSpeed)) <= bitrateEstimate) {
                    return i5;
                }
                i4 = i5;
            }
        }
        return i4;
    }

    private long minDurationForQualityIncreaseUs(long j4) {
        if (j4 == C.TIME_UNSET || j4 > this.minDurationForQualityIncreaseUs) {
            return this.minDurationForQualityIncreaseUs;
        }
        return (long) (((float) j4) * this.bufferedFractionToLiveEdgeForQualityIncrease);
    }

    public void enable() {
        this.lastBufferEvaluationMs = C.TIME_UNSET;
    }

    public int evaluateQueueSize(long j4, List<? extends MediaChunk> list) {
        int i4;
        int i5;
        long elapsedRealtime = this.clock.elapsedRealtime();
        long j5 = this.lastBufferEvaluationMs;
        if (j5 != C.TIME_UNSET && elapsedRealtime - j5 < this.minTimeBetweenBufferReevaluationMs) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j4, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs) {
            Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime));
            for (int i6 = 0; i6 < size; i6++) {
                MediaChunk mediaChunk = (MediaChunk) list.get(i6);
                Format format2 = mediaChunk.trackFormat;
                if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j4, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i4 = format2.height) != -1 && i4 < 720 && (i5 = format2.width) != -1 && i5 < 1280 && i4 < format.height) {
                    return i6;
                }
            }
        }
        return size;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void onPlaybackSpeed(float f4) {
        this.playbackSpeed = f4;
    }

    public void updateSelectedTrack(long j4, long j5, long j6) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i4 = this.selectedIndex;
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        this.selectedIndex = determineIdealSelectedIndex;
        if (determineIdealSelectedIndex != i4) {
            if (!isBlacklisted(i4, elapsedRealtime)) {
                Format format = getFormat(i4);
                Format format2 = getFormat(this.selectedIndex);
                if (format2.bitrate > format.bitrate && j5 < minDurationForQualityIncreaseUs(j6)) {
                    this.selectedIndex = i4;
                } else if (format2.bitrate < format.bitrate && j5 >= this.maxDurationForQualityDecreaseUs) {
                    this.selectedIndex = i4;
                }
            }
            if (this.selectedIndex != i4) {
                this.reason = 3;
            }
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2, long j4, long j5, long j6, float f4, float f5, long j7, Clock clock2) {
        super(trackGroup, iArr);
        this.bandwidthMeter = bandwidthMeter2;
        this.minDurationForQualityIncreaseUs = j4 * 1000;
        this.maxDurationForQualityDecreaseUs = j5 * 1000;
        this.minDurationToRetainAfterDiscardUs = j6 * 1000;
        this.bandwidthFraction = f4;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f5;
        this.minTimeBetweenBufferReevaluationMs = j7;
        this.clock = clock2;
        this.playbackSpeed = 1.0f;
        this.reason = 1;
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
    }
}
