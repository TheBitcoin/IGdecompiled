package com.mbridge.msdk.playercommon.exoplayer2.analytics;

import android.net.NetworkInfo;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;

public interface AnalyticsListener {

    public static final class EventTime {
        public final long currentPlaybackPositionMs;
        public final long eventPlaybackPositionMs;
        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long j4, Timeline timeline2, int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j5, long j6, long j7) {
            this.realtimeMs = j4;
            this.timeline = timeline2;
            this.windowIndex = i4;
            this.mediaPeriodId = mediaPeriodId2;
            this.eventPlaybackPositionMs = j5;
            this.currentPlaybackPositionMs = j6;
            this.totalBufferedDurationMs = j7;
        }
    }

    void onAudioSessionId(EventTime eventTime, int i4);

    void onAudioUnderrun(EventTime eventTime, int i4, long j4, long j5);

    void onBandwidthEstimate(EventTime eventTime, int i4, long j4, long j5);

    void onDecoderDisabled(EventTime eventTime, int i4, DecoderCounters decoderCounters);

    void onDecoderEnabled(EventTime eventTime, int i4, DecoderCounters decoderCounters);

    void onDecoderInitialized(EventTime eventTime, int i4, String str, long j4);

    void onDecoderInputFormatChanged(EventTime eventTime, int i4, Format format);

    void onDownstreamFormatChanged(EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onDrmKeysLoaded(EventTime eventTime);

    void onDrmKeysRemoved(EventTime eventTime);

    void onDrmKeysRestored(EventTime eventTime);

    void onDrmSessionManagerError(EventTime eventTime, Exception exc);

    void onDroppedVideoFrames(EventTime eventTime, int i4, long j4);

    void onLoadCanceled(EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadCompleted(EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadError(EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4);

    void onLoadStarted(EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadingChanged(EventTime eventTime, boolean z4);

    void onMediaPeriodCreated(EventTime eventTime);

    void onMediaPeriodReleased(EventTime eventTime);

    void onMetadata(EventTime eventTime, Metadata metadata);

    void onNetworkTypeChanged(EventTime eventTime, @Nullable NetworkInfo networkInfo);

    void onPlaybackParametersChanged(EventTime eventTime, PlaybackParameters playbackParameters);

    void onPlayerError(EventTime eventTime, ExoPlaybackException exoPlaybackException);

    void onPlayerStateChanged(EventTime eventTime, boolean z4, int i4);

    void onPositionDiscontinuity(EventTime eventTime, int i4);

    void onReadingStarted(EventTime eventTime);

    void onRenderedFirstFrame(EventTime eventTime, Surface surface);

    void onRepeatModeChanged(EventTime eventTime, int i4);

    void onSeekProcessed(EventTime eventTime);

    void onSeekStarted(EventTime eventTime);

    void onShuffleModeChanged(EventTime eventTime, boolean z4);

    void onTimelineChanged(EventTime eventTime, int i4);

    void onTracksChanged(EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

    void onUpstreamDiscarded(EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onVideoSizeChanged(EventTime eventTime, int i4, int i5, int i6, float f4);

    void onViewportSizeChange(EventTime eventTime, int i4, int i5);
}
