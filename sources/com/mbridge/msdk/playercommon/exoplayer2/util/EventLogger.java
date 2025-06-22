package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsListener;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger implements AnalyticsListener {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period = new Timeline.Period();
    private final long startTimeMs = SystemClock.elapsedRealtime();
    @Nullable
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window = new Timeline.Window();

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this.trackSelector = mappingTrackSelector;
    }

    private static String getAdaptiveSupportString(int i4, int i5) {
        if (i4 < 2) {
            return "N/A";
        }
        if (i5 == 0) {
            return "NO";
        }
        if (i5 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i5 != 16) {
            return "?";
        }
        return "YES";
    }

    private static String getDiscontinuityReasonString(int i4) {
        if (i4 == 0) {
            return "PERIOD_TRANSITION";
        }
        if (i4 == 1) {
            return "SEEK";
        }
        if (i4 == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (i4 == 3) {
            return "AD_INSERTION";
        }
        if (i4 != 4) {
            return "?";
        }
        return "INTERNAL";
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str) {
        return str + " [" + getEventTimeString(eventTime) + "]";
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.mediaPeriodId.periodIndex;
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", " + getTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    private static String getFormatSupportString(int i4) {
        if (i4 == 0) {
            return "NO";
        }
        if (i4 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i4 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i4 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i4 != 4) {
            return "?";
        }
        return "YES";
    }

    private static String getRepeatModeString(int i4) {
        if (i4 == 0) {
            return "OFF";
        }
        if (i4 == 1) {
            return "ONE";
        }
        if (i4 != 2) {
            return "?";
        }
        return "ALL";
    }

    private static String getStateString(int i4) {
        if (i4 == 1) {
            return "IDLE";
        }
        if (i4 == 2) {
            return "BUFFERING";
        }
        if (i4 == 3) {
            return "READY";
        }
        if (i4 != 4) {
            return "?";
        }
        return "ENDED";
    }

    private static String getTimeString(long j4) {
        if (j4 == C.TIME_UNSET) {
            return "?";
        }
        return TIME_FORMAT.format((double) (((float) j4) / 1000.0f));
    }

    private static String getTimelineChangeReasonString(int i4) {
        if (i4 == 0) {
            return "PREPARED";
        }
        if (i4 == 1) {
            return "RESET";
        }
        if (i4 != 2) {
            return "?";
        }
        return "DYNAMIC";
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i4) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i4) == -1) ? false : true);
    }

    private static String getTrackTypeString(int i4) {
        if (i4 == 0) {
            return MRAIDCommunicatorUtil.STATES_DEFAULT;
        }
        if (i4 == 1) {
            return MimeTypes.BASE_TYPE_AUDIO;
        }
        if (i4 == 2) {
            return MimeTypes.BASE_TYPE_VIDEO;
        }
        if (i4 == 3) {
            return MimeTypes.BASE_TYPE_TEXT;
        }
        if (i4 == 4) {
            return TtmlNode.TAG_METADATA;
        }
        if (i4 == 5) {
            return "none";
        }
        if (i4 < 10000) {
            return "?";
        }
        return "custom (" + i4 + ")";
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i4 = 0; i4 < metadata.length(); i4++) {
            logd(str + metadata.get(i4));
        }
    }

    /* access modifiers changed from: protected */
    public void logd(String str) {
        Log.d(TAG, str);
    }

    /* access modifiers changed from: protected */
    public void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i4) {
        logd(eventTime, "audioSessionId", Integer.toString(i4));
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i4, long j4, long j5) {
        loge(eventTime, "audioTrackUnderrun", i4 + ", " + j4 + ", " + j5 + "]", (Throwable) null);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i4, long j4, long j5) {
    }

    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i4, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderDisabled", getTrackTypeString(i4));
    }

    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i4, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderEnabled", getTrackTypeString(i4));
    }

    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i4, String str, long j4) {
        logd(eventTime, "decoderInitialized", getTrackTypeString(i4) + ", " + str);
    }

    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i4, Format format) {
        logd(eventTime, "decoderInputFormatChanged", getTrackTypeString(i4) + ", " + Format.toLogString(format));
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormatChanged", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i4, long j4) {
        logd(eventTime, "droppedFrames", Integer.toString(i4));
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
        printInternalError(eventTime, "loadError", iOException);
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
        logd(eventTime, MRAIDCommunicatorUtil.STATES_LOADING, Boolean.toString(z4));
    }

    public void onMediaPeriodCreated(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodCreated");
    }

    public void onMediaPeriodReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReleased");
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime) + ", ");
        printMetadata(metadata, "  ");
        logd("]");
    }

    public void onNetworkTypeChanged(AnalyticsListener.EventTime eventTime, @Nullable NetworkInfo networkInfo) {
        String str;
        if (networkInfo == null) {
            str = "none";
        } else {
            str = networkInfo.toString();
        }
        logd(eventTime, "networkTypeChanged", str);
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", Util.formatInvariant("speed=%.2f, pitch=%.2f, skipSilence=%s", Float.valueOf(playbackParameters.speed), Float.valueOf(playbackParameters.pitch), Boolean.valueOf(playbackParameters.skipSilence)));
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        loge(eventTime, "playerFailed", exoPlaybackException);
    }

    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z4, int i4) {
        logd(eventTime, MRAIDCommunicatorUtil.KEY_STATE, z4 + ", " + getStateString(i4));
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i4) {
        logd(eventTime, "positionDiscontinuity", getDiscontinuityReasonString(i4));
    }

    public void onReadingStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReadingStarted");
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        logd(eventTime, "renderedFirstFrame", surface.toString());
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i4) {
        logd(eventTime, "repeatMode", getRepeatModeString(i4));
    }

    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekProcessed");
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekStarted");
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z4));
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i4) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timelineChanged [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i4));
        for (int i5 = 0; i5 < Math.min(periodCount, 3); i5++) {
            eventTime.timeline.getPeriod(i5, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i6 = 0; i6 < Math.min(windowCount, 3); i6++) {
            eventTime.timeline.getWindow(i6, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
        String str;
        int i4;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2;
        MappingTrackSelector mappingTrackSelector = this.trackSelector;
        if (mappingTrackSelector != null) {
            mappedTrackInfo = mappingTrackSelector.getCurrentMappedTrackInfo();
        } else {
            mappedTrackInfo = null;
        }
        if (mappedTrackInfo == null) {
            logd(eventTime, "tracksChanged", "[]");
            return;
        }
        AnalyticsListener.EventTime eventTime2 = eventTime;
        logd("tracksChanged [" + getEventTimeString(eventTime) + ", ");
        int rendererCount = mappedTrackInfo.getRendererCount();
        int i5 = 0;
        while (true) {
            str = "  ]";
            if (i5 >= rendererCount) {
                break;
            }
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i5);
            TrackSelection trackSelection = trackSelectionArray.get(i5);
            if (trackGroups.length > 0) {
                StringBuilder sb = new StringBuilder();
                i4 = rendererCount;
                sb.append("  Renderer:");
                sb.append(i5);
                sb.append(" [");
                logd(sb.toString());
                int i6 = 0;
                while (i6 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i6);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String str2 = str;
                    String adaptiveSupportString = getAdaptiveSupportString(trackGroup.length, mappedTrackInfo.getAdaptiveSupport(i5, i6, false));
                    logd("    Group:" + i6 + ", adaptive_supported=" + adaptiveSupportString + " [");
                    int i7 = 0;
                    while (i7 < trackGroup.length) {
                        String trackStatusString = getTrackStatusString(trackSelection, trackGroup, i7);
                        String formatSupportString = getFormatSupportString(mappedTrackInfo.getTrackSupport(i5, i6, i7));
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                        logd("      " + trackStatusString + " Track:" + i7 + ", " + Format.toLogString(trackGroup.getFormat(i7)) + ", supported=" + formatSupportString);
                        i7++;
                        mappedTrackInfo = mappedTrackInfo3;
                    }
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                    logd("    ]");
                    i6++;
                    TrackSelectionArray trackSelectionArray2 = trackSelectionArray;
                    trackGroups = trackGroupArray2;
                    str = str2;
                }
                mappedTrackInfo2 = mappedTrackInfo;
                String str3 = str;
                if (trackSelection != null) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= trackSelection.length()) {
                            break;
                        }
                        Metadata metadata = trackSelection.getFormat(i8).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i8++;
                    }
                }
                logd(str3);
            } else {
                mappedTrackInfo2 = mappedTrackInfo;
                i4 = rendererCount;
            }
            i5++;
            rendererCount = i4;
            mappedTrackInfo = mappedTrackInfo2;
        }
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
        String str4 = str;
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo5.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Renderer:None [");
            for (int i9 = 0; i9 < unmappedTrackGroups.length; i9++) {
                logd("    Group:" + i9 + " [");
                TrackGroup trackGroup2 = unmappedTrackGroups.get(i9);
                for (int i10 = 0; i10 < trackGroup2.length; i10++) {
                    String trackStatusString2 = getTrackStatusString(false);
                    String formatSupportString2 = getFormatSupportString(0);
                    logd("      " + trackStatusString2 + " Track:" + i10 + ", " + Format.toLogString(trackGroup2.getFormat(i10)) + ", supported=" + formatSupportString2);
                }
                logd("    ]");
            }
            logd(str4);
        }
        logd("]");
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i4, int i5, int i6, float f4) {
        logd(eventTime, "videoSizeChanged", i4 + ", " + i5);
    }

    public void onViewportSizeChange(AnalyticsListener.EventTime eventTime, int i4, int i5) {
        logd(eventTime, "viewportSizeChanged", i4 + ", " + i5);
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2) {
        return str + " [" + getEventTimeString(eventTime) + ", " + str2 + "]";
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        loge(getEventString(eventTime, str), th);
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        loge(getEventString(eventTime, str, str2), th);
    }

    private static String getTrackStatusString(boolean z4) {
        return z4 ? "[X]" : "[ ]";
    }
}
