package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    public final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
    }

    public final boolean continueLoading(long j4) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j4);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.childrenPendingPreparation.get(i4).continueLoading(j4);
        }
        return false;
    }

    public final void discardBuffer(long j4, boolean z4) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j4, z4);
        }
    }

    public final long getAdjustedSeekPositionUs(long j4, SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j4, seekParameters);
    }

    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public final long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public final void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i4 = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i4 += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i4];
            int i5 = 0;
            for (MediaPeriod trackGroups3 : this.periods) {
                TrackGroupArray trackGroups4 = trackGroups3.getTrackGroups();
                int i6 = trackGroups4.length;
                int i7 = 0;
                while (i7 < i6) {
                    trackGroupArr[i5] = trackGroups4.get(i7);
                    i7++;
                    i5++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    public final void prepare(MediaPeriod.Callback callback2, long j4) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j4);
        }
    }

    public final long readDiscontinuity() {
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        int i4 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i4 >= mediaPeriodArr.length) {
                if (readDiscontinuity != C.TIME_UNSET) {
                    MediaPeriod[] mediaPeriodArr2 = this.enabledPeriods;
                    int length = mediaPeriodArr2.length;
                    int i5 = 0;
                    while (i5 < length) {
                        MediaPeriod mediaPeriod = mediaPeriodArr2[i5];
                        if (mediaPeriod == this.periods[0] || mediaPeriod.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i5++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return readDiscontinuity;
            } else if (mediaPeriodArr[i4].readDiscontinuity() == C.TIME_UNSET) {
                i4++;
            } else {
                throw new IllegalStateException("Child reported discontinuity.");
            }
        }
    }

    public final void reevaluateBuffer(long j4) {
        this.compositeSequenceableLoader.reevaluateBuffer(j4);
    }

    public final long seekToUs(long j4) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j4);
        int i4 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i4 >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i4].seekToUs(seekToUs) == seekToUs) {
                i4++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j4) {
        boolean z4;
        SampleStream sampleStream;
        int i4;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i5 = 0; i5 < trackSelectionArr2.length; i5++) {
            SampleStream sampleStream2 = sampleStreamArr2[i5];
            if (sampleStream2 == null) {
                i4 = -1;
            } else {
                i4 = this.streamPeriodIndices.get(sampleStream2).intValue();
            }
            iArr[i5] = i4;
            iArr2[i5] = -1;
            TrackSelection trackSelection = trackSelectionArr2[i5];
            if (trackSelection != null) {
                TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i6 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i6 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i6].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i5] = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        int length = trackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j5 = j4;
        int i7 = 0;
        while (i7 < this.periods.length) {
            for (int i8 = 0; i8 < trackSelectionArr2.length; i8++) {
                TrackSelection trackSelection2 = null;
                if (iArr[i8] == i7) {
                    sampleStream = sampleStreamArr2[i8];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i8] = sampleStream;
                if (iArr2[i8] == i7) {
                    trackSelection2 = trackSelectionArr2[i8];
                }
                trackSelectionArr3[i8] = trackSelection2;
            }
            int i9 = i7;
            long selectTracks = this.periods[i7].selectTracks(trackSelectionArr3, zArr, sampleStreamArr4, zArr2, j5);
            if (i9 == 0) {
                j5 = selectTracks;
            } else if (selectTracks != j5) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            int i10 = 0;
            boolean z5 = false;
            while (i10 < trackSelectionArr2.length) {
                boolean z6 = true;
                if (iArr2[i10] == i9) {
                    if (sampleStreamArr4[i10] != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.checkState(z4);
                    sampleStreamArr3[i10] = sampleStreamArr4[i10];
                    this.streamPeriodIndices.put(sampleStreamArr4[i10], Integer.valueOf(i9));
                    z5 = true;
                } else if (iArr[i10] == i9) {
                    if (sampleStreamArr4[i10] != null) {
                        z6 = false;
                    }
                    Assertions.checkState(z6);
                }
                i10++;
                trackSelectionArr2 = trackSelectionArr;
            }
            if (z5) {
                arrayList.add(this.periods[i9]);
            }
            i7 = i9 + 1;
            trackSelectionArr2 = trackSelectionArr;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        MediaPeriod[] mediaPeriodArr2 = new MediaPeriod[arrayList.size()];
        this.enabledPeriods = mediaPeriodArr2;
        arrayList.toArray(mediaPeriodArr2);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j5;
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}
