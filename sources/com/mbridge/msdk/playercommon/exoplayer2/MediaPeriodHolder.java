package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.EmptySampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    public MediaPeriodHolder next;
    private TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    public long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    public TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j4, TrackSelector trackSelector2, Allocator allocator, MediaSource mediaSource2, Object obj, MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j4 - mediaPeriodInfo.startPositionUs;
        this.trackSelector = trackSelector2;
        this.mediaSource = mediaSource2;
        this.uid = Assertions.checkNotNull(obj);
        this.info = mediaPeriodInfo;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        MediaPeriod createPeriod = mediaSource2.createPeriod(mediaPeriodInfo.id, allocator);
        long j5 = mediaPeriodInfo.endPositionUs;
        this.mediaPeriod = j5 != Long.MIN_VALUE ? new ClippingMediaPeriod(createPeriod, true, 0, j5) : createPeriod;
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i4 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i4 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i4].getTrackType() == 5 && this.trackSelectorResult.isRendererEnabled(i4)) {
                    sampleStreamArr[i4] = new EmptySampleStream();
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private void disableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult2) {
        for (int i4 = 0; i4 < trackSelectorResult2.length; i4++) {
            boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i4);
            TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i4 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i4 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i4].getTrackType() == 5) {
                    sampleStreamArr[i4] = null;
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private void enableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult2) {
        for (int i4 = 0; i4 < trackSelectorResult2.length; i4++) {
            boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i4);
            TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
        }
    }

    private void updatePeriodTrackSelectorResult(TrackSelectorResult trackSelectorResult2) {
        TrackSelectorResult trackSelectorResult3 = this.periodTrackSelectorResult;
        if (trackSelectorResult3 != null) {
            disableTrackSelectionsInResult(trackSelectorResult3);
        }
        this.periodTrackSelectorResult = trackSelectorResult2;
        if (trackSelectorResult2 != null) {
            enableTrackSelectionsInResult(trackSelectorResult2);
        }
    }

    public final long applyTrackSelection(long j4, boolean z4) {
        return applyTrackSelection(j4, z4, new boolean[this.rendererCapabilities.length]);
    }

    public final void continueLoading(long j4) {
        this.mediaPeriod.continueLoading(toPeriodTime(j4));
    }

    public final long getBufferedPositionUs(boolean z4) {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE || !z4) {
            return bufferedPositionUs;
        }
        return this.info.durationUs;
    }

    public final long getDurationUs() {
        return this.info.durationUs;
    }

    public final long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public final long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public final void handlePrepared(float f4) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        selectTracks(f4);
        long applyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        long j4 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo = this.info;
        this.rendererPositionOffsetUs = j4 + (mediaPeriodInfo.startPositionUs - applyTrackSelection);
        this.info = mediaPeriodInfo.copyWithStartPositionUs(applyTrackSelection);
    }

    public final boolean isFullyBuffered() {
        if (!this.prepared) {
            return false;
        }
        if (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public final void reevaluateBuffer(long j4) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j4));
        }
    }

    public final void release() {
        updatePeriodTrackSelectorResult((TrackSelectorResult) null);
        try {
            if (this.info.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (RuntimeException e5) {
            Log.e(TAG, "Period release failed.", e5);
        }
    }

    public final boolean selectTracks(float f4) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroups);
        if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = selectTracks;
        for (TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f4);
            }
        }
        return true;
    }

    public final long toPeriodTime(long j4) {
        return j4 - getRendererOffset();
    }

    public final long toRendererTime(long j4) {
        return j4 + getRendererOffset();
    }

    public final long applyTrackSelection(long j4, boolean z4, boolean[] zArr) {
        int i4 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
            boolean z5 = true;
            if (i4 >= trackSelectorResult2.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z4 || !trackSelectorResult2.isEquivalent(this.periodTrackSelectorResult, i4)) {
                z5 = false;
            }
            zArr2[i4] = z5;
            i4++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j4);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i5 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i5 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i5] != null) {
                Assertions.checkState(this.trackSelectorResult.isRendererEnabled(i5));
                if (this.rendererCapabilities[i5].getTrackType() != 5) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i5) == null);
            }
            i5++;
        }
    }
}
