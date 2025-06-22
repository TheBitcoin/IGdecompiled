package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Timeline.Period period = new Timeline.Period();
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private Timeline timeline;
    private final Timeline.Window window = new Timeline.Window();

    private boolean canKeepMediaPeriodHolder(MediaPeriodHolder mediaPeriodHolder, MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.info;
        if (mediaPeriodInfo2.startPositionUs == mediaPeriodInfo.startPositionUs && mediaPeriodInfo2.endPositionUs == mediaPeriodInfo.endPositionUs && mediaPeriodInfo2.id.equals(mediaPeriodInfo.id)) {
            return true;
        }
        return false;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs);
    }

    @Nullable
    private MediaPeriodInfo getFollowingMediaPeriodInfo(MediaPeriodHolder mediaPeriodHolder, long j4) {
        long j5;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder2.info;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodInfo.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i4 = this.timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj = this.period.uid;
            long j6 = mediaPeriodInfo.id.windowSequenceNumber;
            long j7 = 0;
            if (this.timeline.getWindow(i4, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Integer, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i4, C.TIME_UNSET, Math.max(0, (mediaPeriodHolder2.getRendererOffset() + mediaPeriodInfo.durationUs) - j4));
                if (periodPosition == null) {
                    return null;
                }
                nextPeriodIndex = ((Integer) periodPosition.first).intValue();
                j7 = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder2.next;
                if (mediaPeriodHolder3 == null || !mediaPeriodHolder3.uid.equals(obj)) {
                    j5 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j5;
                } else {
                    j5 = mediaPeriodHolder2.next.info.id.windowSequenceNumber;
                }
                j6 = j5;
            }
            long j8 = j7;
            return getMediaPeriodInfo(resolveMediaPeriodIdForAds(nextPeriodIndex, j8, j6), j8, j8);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            int i5 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i5);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i5, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay >= adCountInAdGroup) {
                int i6 = mediaPeriodId.periodIndex;
                long j9 = mediaPeriodInfo.contentPositionUs;
                long j10 = mediaPeriodId.windowSequenceNumber;
                return getMediaPeriodInfoForContent(i6, j9, j10);
            } else if (!this.period.isAdAvailable(i5, nextAdIndexToPlay)) {
                return null;
            } else {
                int i7 = mediaPeriodId.periodIndex;
                long j11 = mediaPeriodInfo.contentPositionUs;
                int i8 = i5;
                long j12 = mediaPeriodId.windowSequenceNumber;
                return getMediaPeriodInfoForAd(i7, i8, nextAdIndexToPlay, j11, j12);
            }
        } else {
            long j13 = mediaPeriodInfo.endPositionUs;
            if (j13 != Long.MIN_VALUE) {
                int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j13);
                if (adGroupIndexForPositionUs == -1) {
                    long j14 = mediaPeriodInfo.endPositionUs;
                    return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j14, mediaPeriodId.windowSequenceNumber);
                }
                int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
                if (!this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                    return null;
                }
                int i9 = mediaPeriodId.periodIndex;
                long j15 = mediaPeriodInfo.endPositionUs;
                return getMediaPeriodInfoForAd(i9, adGroupIndexForPositionUs, firstAdIndexToPlay, j15, mediaPeriodId.windowSequenceNumber);
            }
            int adGroupCount = this.period.getAdGroupCount();
            if (adGroupCount == 0) {
                return null;
            }
            int i10 = adGroupCount - 1;
            if (this.period.getAdGroupTimeUs(i10) != Long.MIN_VALUE || this.period.hasPlayedAdGroup(i10)) {
                return null;
            }
            int firstAdIndexToPlay2 = this.period.getFirstAdIndexToPlay(i10);
            if (!this.period.isAdAvailable(i10, firstAdIndexToPlay2)) {
                return null;
            }
            long durationUs = this.period.getDurationUs();
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i10, firstAdIndexToPlay2, durationUs, mediaPeriodId.windowSequenceNumber);
        }
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j4, long j5) {
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (!mediaPeriodId.isAd()) {
            return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j5, mediaPeriodId.windowSequenceNumber);
        } else if (!this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
            return null;
        } else {
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j4, mediaPeriodId.windowSequenceNumber);
        }
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(int i4, int i5, int i6, long j4, long j5) {
        long j6;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i4, i5, i6, j5);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, Long.MIN_VALUE);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        long adDurationUs = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        if (i6 == this.period.getFirstAdIndexToPlay(i5)) {
            j6 = this.period.getAdResumePositionUs();
        } else {
            j6 = 0;
        }
        return new MediaPeriodInfo(mediaPeriodId, j6, Long.MIN_VALUE, j4, adDurationUs, isLastInPeriod, isLastInTimeline);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(int i4, long j4, long j5) {
        long j6;
        long j7;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i4, j5);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j4);
        if (adGroupIndexAfterPositionUs == -1) {
            j6 = Long.MIN_VALUE;
        } else {
            j6 = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        }
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j6);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        if (j6 == Long.MIN_VALUE) {
            j7 = this.period.getDurationUs();
        } else {
            j7 = j6;
        }
        return new MediaPeriodInfo(mediaPeriodId, j4, j6, C.TIME_UNSET, j7, isLastInPeriod, isLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j4) {
        int adGroupCount = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdGroupCount();
        if (adGroupCount == 0) {
            return true;
        }
        int i4 = adGroupCount - 1;
        boolean isAd = mediaPeriodId.isAd();
        if (this.period.getAdGroupTimeUs(i4) == Long.MIN_VALUE) {
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i4);
            if (adCountInAdGroup == -1) {
                return false;
            }
            if ((!isAd || mediaPeriodId.adGroupIndex != i4 || mediaPeriodId.adIndexInAdGroup != adCountInAdGroup - 1) && (isAd || this.period.getFirstAdIndexToPlay(i4) != adCountInAdGroup)) {
                return false;
            }
            return true;
        } else if (isAd || j4 != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isLastInTimeline(MediaSource.MediaPeriodId mediaPeriodId, boolean z4) {
        if (this.timeline.getWindow(this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).windowIndex, this.window).isDynamic || !this.timeline.isLastPeriod(mediaPeriodId.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) || !z4) {
            return false;
        }
        return true;
    }

    private long resolvePeriodIndexToWindowSequenceNumber(int i4) {
        int indexOfPeriod;
        Object obj = this.timeline.getPeriod(i4, this.period, true).uid;
        int i5 = this.period.windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = this.timeline.getIndexOfPeriod(obj2)) != -1 && this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i5) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder frontPeriod = getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (frontPeriod.uid.equals(obj)) {
                return frontPeriod.info.id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder frontPeriod2 = getFrontPeriod(); frontPeriod2 != null; frontPeriod2 = frontPeriod2.next) {
            int indexOfPeriod2 = this.timeline.getIndexOfPeriod(frontPeriod2.uid);
            if (indexOfPeriod2 != -1 && this.timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i5) {
                return frontPeriod2.info.id.windowSequenceNumber;
            }
        }
        long j4 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j4;
        return j4;
    }

    private boolean updateForPlaybackModeChange() {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod == null) {
            return true;
        }
        while (true) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(frontPeriod.info.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (true) {
                mediaPeriodHolder = frontPeriod.next;
                if (mediaPeriodHolder != null && !frontPeriod.info.isLastInTimelinePeriod) {
                    frontPeriod = mediaPeriodHolder;
                }
            }
            if (nextPeriodIndex == -1 || mediaPeriodHolder == null || mediaPeriodHolder.info.id.periodIndex != nextPeriodIndex) {
                boolean removeAfter = removeAfter(frontPeriod);
                MediaPeriodInfo mediaPeriodInfo = frontPeriod.info;
                frontPeriod.info = getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id);
            } else {
                frontPeriod = mediaPeriodHolder;
            }
        }
        boolean removeAfter2 = removeAfter(frontPeriod);
        MediaPeriodInfo mediaPeriodInfo2 = frontPeriod.info;
        frontPeriod.info = getUpdatedMediaPeriodInfo(mediaPeriodInfo2, mediaPeriodInfo2.id);
        if (!removeAfter2 || !hasPlayingPeriod()) {
            return true;
        }
        return false;
    }

    public final MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            if (mediaPeriodHolder == this.reading) {
                this.reading = mediaPeriodHolder.next;
            }
            mediaPeriodHolder.release();
            int i4 = this.length - 1;
            this.length = i4;
            if (i4 == 0) {
                this.loading = null;
                MediaPeriodHolder mediaPeriodHolder2 = this.playing;
                this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
                this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.id.windowSequenceNumber;
            }
            this.playing = this.playing.next;
        } else {
            MediaPeriodHolder mediaPeriodHolder3 = this.loading;
            this.playing = mediaPeriodHolder3;
            this.reading = mediaPeriodHolder3;
        }
        return this.playing;
    }

    public final MediaPeriodHolder advanceReadingPeriod() {
        boolean z4;
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        if (mediaPeriodHolder == null || mediaPeriodHolder.next == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkState(z4);
        MediaPeriodHolder mediaPeriodHolder2 = this.reading.next;
        this.reading = mediaPeriodHolder2;
        return mediaPeriodHolder2;
    }

    public final void clear(boolean z4) {
        Object obj;
        MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod != null) {
            if (z4) {
                obj = frontPeriod.uid;
            } else {
                obj = null;
            }
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = frontPeriod.info.id.windowSequenceNumber;
            frontPeriod.release();
            removeAfter(frontPeriod);
        } else if (!z4) {
            this.oldFrontPeriodUid = null;
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public final MediaPeriod enqueueNextMediaPeriod(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSource mediaSource, Object obj, MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodInfo mediaPeriodInfo2;
        long rendererOffset;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            mediaPeriodInfo2 = mediaPeriodInfo;
            rendererOffset = mediaPeriodInfo2.startPositionUs;
        } else {
            mediaPeriodInfo2 = mediaPeriodInfo;
            rendererOffset = mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, rendererOffset, trackSelector, allocator, mediaSource, obj, mediaPeriodInfo2);
        if (this.loading != null) {
            Assertions.checkState(hasPlayingPeriod());
            this.loading.next = mediaPeriodHolder2;
        }
        this.oldFrontPeriodUid = null;
        this.loading = mediaPeriodHolder2;
        this.length++;
        return mediaPeriodHolder2.mediaPeriod;
    }

    public final MediaPeriodHolder getFrontPeriod() {
        if (hasPlayingPeriod()) {
            return this.playing;
        }
        return this.loading;
    }

    public final MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    @Nullable
    public final MediaPeriodInfo getNextMediaPeriodInfo(long j4, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(mediaPeriodHolder, j4);
    }

    public final MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public final MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public final MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, int i4) {
        return getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.id.copyWithPeriodIndex(i4));
    }

    public final boolean hasPlayingPeriod() {
        if (this.playing != null) {
            return true;
        }
        return false;
    }

    public final boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null || mediaPeriodHolder.mediaPeriod != mediaPeriod) {
            return false;
        }
        return true;
    }

    public final void reevaluateBuffer(long j4) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j4);
        }
    }

    public final boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z4;
        boolean z5 = false;
        if (mediaPeriodHolder != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.loading = mediaPeriodHolder;
        while (true) {
            mediaPeriodHolder = mediaPeriodHolder.next;
            if (mediaPeriodHolder != null) {
                if (mediaPeriodHolder == this.reading) {
                    this.reading = this.playing;
                    z5 = true;
                }
                mediaPeriodHolder.release();
                this.length--;
            } else {
                this.loading.next = null;
                return z5;
            }
        }
    }

    public final MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int i4, long j4) {
        return resolveMediaPeriodIdForAds(i4, j4, resolvePeriodIndexToWindowSequenceNumber(i4));
    }

    public final void setTimeline(Timeline timeline2) {
        this.timeline = timeline2;
    }

    public final boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return true;
        }
        if (mediaPeriodHolder.info.isFinal || !mediaPeriodHolder.isFullyBuffered() || this.loading.info.durationUs == C.TIME_UNSET || this.length >= 100) {
            return false;
        }
        return true;
    }

    public final boolean updateQueuedPeriods(MediaSource.MediaPeriodId mediaPeriodId, long j4) {
        int i4 = mediaPeriodId.periodIndex;
        MediaPeriodHolder mediaPeriodHolder = null;
        int i5 = i4;
        for (MediaPeriodHolder frontPeriod = getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (mediaPeriodHolder == null) {
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info, i5);
            } else if (i5 == -1 || !frontPeriod.uid.equals(this.timeline.getPeriod(i5, this.period, true).uid)) {
                return true ^ removeAfter(mediaPeriodHolder);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(mediaPeriodHolder, j4);
                if (followingMediaPeriodInfo == null) {
                    return true ^ removeAfter(mediaPeriodHolder);
                }
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info, i5);
                if (!canKeepMediaPeriodHolder(frontPeriod, followingMediaPeriodInfo)) {
                    return true ^ removeAfter(mediaPeriodHolder);
                }
            }
            if (frontPeriod.info.isLastInTimelinePeriod) {
                i5 = this.timeline.getNextPeriodIndex(i5, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            }
            mediaPeriodHolder = frontPeriod;
        }
        return true;
    }

    public final boolean updateRepeatMode(int i4) {
        this.repeatMode = i4;
        return updateForPlaybackModeChange();
    }

    public final boolean updateShuffleModeEnabled(boolean z4) {
        this.shuffleModeEnabled = z4;
        return updateForPlaybackModeChange();
    }

    private MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int i4, long j4, long j5) {
        this.timeline.getPeriod(i4, this.period);
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j4);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(i4, j5);
        }
        return new MediaSource.MediaPeriodId(i4, adGroupIndexForPositionUs, this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j5);
    }

    private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, MediaSource.MediaPeriodId mediaPeriodId) {
        long j4;
        long durationUs;
        long j5 = mediaPeriodInfo.startPositionUs;
        long j6 = mediaPeriodInfo.endPositionUs;
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j6);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else if (j6 == Long.MIN_VALUE) {
            durationUs = this.period.getDurationUs();
        } else {
            j4 = j6;
            return new MediaPeriodInfo(mediaPeriodId, j5, j6, mediaPeriodInfo.contentPositionUs, j4, isLastInPeriod, isLastInTimeline);
        }
        j4 = durationUs;
        return new MediaPeriodInfo(mediaPeriodId, j5, j6, mediaPeriodInfo.contentPositionUs, j4, isLastInPeriod, isLastInTimeline);
    }
}
