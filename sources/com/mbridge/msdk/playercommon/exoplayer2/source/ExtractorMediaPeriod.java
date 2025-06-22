package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ConditionVariable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

final class ExtractorMediaPeriod implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private int actualMinLoadableRetryCount;
    private final Allocator allocator;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPeriod.Callback callback;
    /* access modifiers changed from: private */
    public final long continueLoadingCheckIntervalBytes;
    /* access modifiers changed from: private */
    @Nullable
    public final String customCacheKey;
    private final DataSource dataSource;
    private long durationUs;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    /* access modifiers changed from: private */
    public final Handler handler;
    private boolean haveAudioVideoTracks;
    private long lastSeekPositionUs;
    private long length;
    private final Listener listener;
    private final ConditionVariable loadCondition;
    private final Loader loader = new Loader("Loader:ExtractorMediaPeriod");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final int minLoadableRetryCount;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    /* access modifiers changed from: private */
    public final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    /* access modifiers changed from: private */
    public boolean released;
    private int[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private boolean[] trackEnabledStates;
    private boolean[] trackFormatNotificationSent;
    private boolean[] trackIsAudioVideoFlags;
    private TrackGroupArray tracks;
    private final Uri uri;

    final class ExtractingLoadable implements Loader.Loadable {
        /* access modifiers changed from: private */
        public long bytesLoaded;
        private final DataSource dataSource;
        /* access modifiers changed from: private */
        public DataSpec dataSpec;
        private final ExtractorHolder extractorHolder;
        /* access modifiers changed from: private */
        public long length = -1;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private boolean pendingExtractorSeek = true;
        private final PositionHolder positionHolder = new PositionHolder();
        /* access modifiers changed from: private */
        public long seekTimeUs;
        private final Uri uri;

        public ExtractingLoadable(Uri uri2, DataSource dataSource2, ExtractorHolder extractorHolder2, ConditionVariable conditionVariable) {
            this.uri = (Uri) Assertions.checkNotNull(uri2);
            this.dataSource = (DataSource) Assertions.checkNotNull(dataSource2);
            this.extractorHolder = (ExtractorHolder) Assertions.checkNotNull(extractorHolder2);
            this.loadCondition = conditionVariable;
        }

        public final void cancelLoad() {
            this.loadCanceled = true;
        }

        public final void load() throws IOException, InterruptedException {
            int i4 = 0;
            while (i4 == 0 && !this.loadCanceled) {
                DefaultExtractorInput defaultExtractorInput = null;
                try {
                    long j4 = this.positionHolder.position;
                    DataSpec dataSpec2 = new DataSpec(this.uri, j4, -1, ExtractorMediaPeriod.this.customCacheKey);
                    this.dataSpec = dataSpec2;
                    long open = this.dataSource.open(dataSpec2);
                    this.length = open;
                    if (open != -1) {
                        this.length = open + j4;
                    }
                    DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, j4, this.length);
                    try {
                        Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.dataSource.getUri());
                        if (this.pendingExtractorSeek) {
                            selectExtractor.seek(j4, this.seekTimeUs);
                            this.pendingExtractorSeek = false;
                        }
                        while (i4 == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            i4 = selectExtractor.read(defaultExtractorInput2, this.positionHolder);
                            if (defaultExtractorInput2.getPosition() > ExtractorMediaPeriod.this.continueLoadingCheckIntervalBytes + j4) {
                                j4 = defaultExtractorInput2.getPosition();
                                this.loadCondition.close();
                                ExtractorMediaPeriod.this.handler.post(ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                        if (i4 == 1) {
                            i4 = 0;
                        } else {
                            this.positionHolder.position = defaultExtractorInput2.getPosition();
                            this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                        }
                        Util.closeQuietly(this.dataSource);
                    } catch (Throwable th) {
                        th = th;
                        defaultExtractorInput = defaultExtractorInput2;
                        this.positionHolder.position = defaultExtractorInput.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                        Util.closeQuietly(this.dataSource);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!(i4 == 1 || defaultExtractorInput == null)) {
                        this.positionHolder.position = defaultExtractorInput.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                    }
                    Util.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        public final void setLoadPosition(long j4, long j5) {
            this.positionHolder.position = j4;
            this.seekTimeUs = j5;
            this.pendingExtractorSeek = true;
        }
    }

    private static final class ExtractorHolder {
        private Extractor extractor;
        private final ExtractorOutput extractorOutput;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput2) {
            this.extractors = extractorArr;
            this.extractorOutput = extractorOutput2;
        }

        public final void release() {
            Extractor extractor2 = this.extractor;
            if (extractor2 != null) {
                extractor2.release();
                this.extractor = null;
            }
        }

        public final Extractor selectExtractor(ExtractorInput extractorInput, Uri uri) throws IOException, InterruptedException {
            Extractor extractor2 = this.extractor;
            if (extractor2 != null) {
                return extractor2;
            }
            Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                Extractor extractor3 = extractorArr[i4];
                try {
                    if (extractor3.sniff(extractorInput)) {
                        this.extractor = extractor3;
                        extractorInput.resetPeekPosition();
                        break;
                    }
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    extractorInput.resetPeekPosition();
                    throw th;
                }
                extractorInput.resetPeekPosition();
                i4++;
            }
            Extractor extractor4 = this.extractor;
            if (extractor4 != null) {
                extractor4.init(this.extractorOutput);
                return this.extractor;
            }
            throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
        }
    }

    interface Listener {
        void onSourceInfoRefreshed(long j4, boolean z4);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */
        public final int track;

        public SampleStreamImpl(int i4) {
            this.track = i4;
        }

        public final boolean isReady() {
            return ExtractorMediaPeriod.this.isReady(this.track);
        }

        public final void maybeThrowError() throws IOException {
            ExtractorMediaPeriod.this.maybeThrowError();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            return ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z4);
        }

        public final int skipData(long j4) {
            return ExtractorMediaPeriod.this.skipData(this.track, j4);
        }
    }

    public ExtractorMediaPeriod(Uri uri2, DataSource dataSource2, Extractor[] extractorArr, int i4, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener2, Allocator allocator2, @Nullable String str, int i5) {
        this.uri = uri2;
        this.dataSource = dataSource2;
        this.minLoadableRetryCount = i4;
        this.eventDispatcher = eventDispatcher2;
        this.listener = listener2;
        this.allocator = allocator2;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = (long) i5;
        this.extractorHolder = new ExtractorHolder(extractorArr, this);
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new Runnable() {
            public void run() {
                ExtractorMediaPeriod.this.maybeFinishPrepare();
            }
        };
        this.onContinueLoadingRequestedRunnable = new Runnable() {
            public void run() {
                if (!ExtractorMediaPeriod.this.released) {
                    ExtractorMediaPeriod.this.callback.onContinueLoadingRequested(ExtractorMediaPeriod.this);
                }
            }
        };
        this.handler = new Handler();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.length = -1;
        this.durationUs = C.TIME_UNSET;
        this.actualMinLoadableRetryCount = i4 == -1 ? 3 : i4;
        eventDispatcher2.mediaPeriodCreated();
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i4) {
        SeekMap seekMap2;
        if (this.length == -1 && ((seekMap2 = this.seekMap) == null || seekMap2.getDurationUs() == C.TIME_UNSET)) {
            if (!this.prepared || suppressRead()) {
                this.notifyDiscontinuity = this.prepared;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                extractingLoadable.setLoadPosition(0, 0);
                return true;
            }
            this.pendingDeferredRetry = true;
            return false;
        }
        this.extractedSamplesCountAtStartOfLoad = i4;
        return true;
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private int getExtractedSamplesCount() {
        int i4 = 0;
        for (SampleQueue writeIndex : this.sampleQueues) {
            i4 += writeIndex.getWriteIndex();
        }
        return i4;
    }

    private long getLargestQueuedTimestampUs() {
        long j4 = Long.MIN_VALUE;
        for (SampleQueue largestQueuedTimestampUs : this.sampleQueues) {
            j4 = Math.max(j4, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
        }
        return j4;
    }

    private static boolean isLoadableExceptionFatal(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        boolean z4;
        if (!this.released && !this.prepared && this.seekMap != null && this.sampleQueuesBuilt) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            int length2 = sampleQueueArr.length;
            int i4 = 0;
            while (i4 < length2) {
                if (sampleQueueArr[i4].getUpstreamFormat() != null) {
                    i4++;
                } else {
                    return;
                }
            }
            this.loadCondition.close();
            int length3 = this.sampleQueues.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length3];
            this.trackIsAudioVideoFlags = new boolean[length3];
            this.trackEnabledStates = new boolean[length3];
            this.trackFormatNotificationSent = new boolean[length3];
            this.durationUs = this.seekMap.getDurationUs();
            for (int i5 = 0; i5 < length3; i5++) {
                Format upstreamFormat = this.sampleQueues[i5].getUpstreamFormat();
                trackGroupArr[i5] = new TrackGroup(upstreamFormat);
                String str = upstreamFormat.sampleMimeType;
                if (MimeTypes.isVideo(str) || MimeTypes.isAudio(str)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.trackIsAudioVideoFlags[i5] = z4;
                this.haveAudioVideoTracks = z4 | this.haveAudioVideoTracks;
            }
            this.tracks = new TrackGroupArray(trackGroupArr);
            if (this.minLoadableRetryCount == -1 && this.length == -1 && this.seekMap.getDurationUs() == C.TIME_UNSET) {
                this.actualMinLoadableRetryCount = 6;
            }
            this.prepared = true;
            this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
            this.callback.onPrepared(this);
        }
    }

    private void maybeNotifyTrackFormat(int i4) {
        if (!this.trackFormatNotificationSent[i4]) {
            Format format = this.tracks.get(i4).getFormat(0);
            this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, (Object) null, this.lastSeekPositionUs);
            this.trackFormatNotificationSent[i4] = true;
        }
    }

    private void maybeStartDeferredRetry(int i4) {
        if (this.pendingDeferredRetry && this.trackIsAudioVideoFlags[i4] && !this.sampleQueues[i4].hasNextSample()) {
            this.pendingResetPositionUs = 0;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    private boolean seekInsideBufferUs(long j4) {
        int length2 = this.sampleQueues.length;
        for (int i4 = 0; i4 < length2; i4++) {
            SampleQueue sampleQueue = this.sampleQueues[i4];
            sampleQueue.rewind();
            if (sampleQueue.advanceTo(j4, true, false) == -1 && (this.trackIsAudioVideoFlags[i4] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j4 = this.durationUs;
            if (j4 == C.TIME_UNSET || this.pendingResetPositionUs < j4) {
                extractingLoadable.setLoadPosition(this.seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = C.TIME_UNSET;
            } else {
                this.loadingFinished = true;
                this.pendingResetPositionUs = C.TIME_UNSET;
                return;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, this.loader.startLoading(extractingLoadable, this, this.actualMinLoadableRetryCount));
    }

    private boolean suppressRead() {
        if (this.notifyDiscontinuity || isPendingReset()) {
            return true;
        }
        return false;
    }

    public final boolean continueLoading(long j4) {
        if (this.loadingFinished || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final void discardBuffer(long j4, boolean z4) {
        int length2 = this.sampleQueues.length;
        for (int i4 = 0; i4 < length2; i4++) {
            this.sampleQueues[i4].discardTo(j4, z4, this.trackEnabledStates[i4]);
        }
    }

    public final void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final long getAdjustedSeekPositionUs(long j4, SeekParameters seekParameters) {
        if (!this.seekMap.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j4);
        return Util.resolveSeekPositionUs(j4, seekParameters, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    public final long getBufferedPositionUs() {
        long j4;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length2 = this.sampleQueues.length;
            j4 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < length2; i4++) {
                if (this.trackIsAudioVideoFlags[i4]) {
                    j4 = Math.min(j4, this.sampleQueues[i4].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j4 = getLargestQueuedTimestampUs();
        }
        if (j4 == Long.MIN_VALUE) {
            return this.lastSeekPositionUs;
        }
        return j4;
    }

    public final long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    /* access modifiers changed from: package-private */
    public final boolean isReady(int i4) {
        if (suppressRead()) {
            return false;
        }
        if (this.loadingFinished || this.sampleQueues[i4].hasNextSample()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
    }

    public final void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    public final void onLoaderReleased() {
        for (SampleQueue reset : this.sampleQueues) {
            reset.reset();
        }
        this.extractorHolder.release();
    }

    public final void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final void prepare(MediaPeriod.Callback callback2, long j4) {
        this.callback = callback2;
        this.loadCondition.open();
        startLoading();
    }

    /* access modifiers changed from: package-private */
    public final int readData(int i4, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
        if (suppressRead()) {
            return -3;
        }
        int read = this.sampleQueues[i4].read(formatHolder, decoderInputBuffer, z4, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            maybeNotifyTrackFormat(i4);
            return read;
        }
        if (read == -3) {
            maybeStartDeferredRetry(i4);
        }
        return read;
    }

    public final long readDiscontinuity() {
        if (!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if (!this.notifyDiscontinuity) {
            return C.TIME_UNSET;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return C.TIME_UNSET;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    public final void reevaluateBuffer(long j4) {
    }

    public final void release() {
        if (this.prepared) {
            for (SampleQueue discardToEnd : this.sampleQueues) {
                discardToEnd.discardToEnd();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final long seekToUs(long j4) {
        if (!this.seekMap.isSeekable()) {
            j4 = 0;
        }
        this.lastSeekPositionUs = j4;
        this.notifyDiscontinuity = false;
        if (isPendingReset() || !seekInsideBufferUs(j4)) {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j4;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
                return j4;
            }
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
        }
        return j4;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j4) {
        boolean z4;
        TrackSelection trackSelection;
        boolean z5;
        boolean z6;
        Assertions.checkState(this.prepared);
        int i4 = this.enabledTrackCount;
        int i5 = 0;
        for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i6];
            if (sampleStreamImpl != null && (trackSelectionArr[i6] == null || !zArr[i6])) {
                int access$300 = sampleStreamImpl.track;
                Assertions.checkState(this.trackEnabledStates[access$300]);
                this.enabledTrackCount--;
                this.trackEnabledStates[access$300] = false;
                sampleStreamArr[i6] = null;
            }
        }
        if (!this.seenFirstTrackSelection ? j4 == 0 : i4 != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        for (int i7 = 0; i7 < trackSelectionArr.length; i7++) {
            if (sampleStreamArr[i7] == null && (trackSelection = trackSelectionArr[i7]) != null) {
                if (trackSelection.length() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assertions.checkState(z5);
                if (trackSelection.getIndexInTrackGroup(0) == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Assertions.checkState(z6);
                int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!this.trackEnabledStates[indexOf]);
                this.enabledTrackCount++;
                this.trackEnabledStates[indexOf] = true;
                sampleStreamArr[i7] = new SampleStreamImpl(indexOf);
                zArr2[i7] = true;
                if (!z4) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    sampleQueue.rewind();
                    if (sampleQueue.advanceTo(j4, true, true) != -1 || sampleQueue.getReadIndex() == 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length2 = sampleQueueArr.length;
                while (i5 < length2) {
                    sampleQueueArr[i5].discardToEnd();
                    i5++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length3 = sampleQueueArr2.length;
                while (i5 < length3) {
                    sampleQueueArr2[i5].reset();
                    i5++;
                }
            }
        } else if (z4) {
            j4 = seekToUs(j4);
            while (i5 < sampleStreamArr.length) {
                if (sampleStreamArr[i5] != null) {
                    zArr2[i5] = true;
                }
                i5++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j4;
    }

    /* access modifiers changed from: package-private */
    public final int skipData(int i4, long j4) {
        int i5 = 0;
        if (suppressRead()) {
            return 0;
        }
        SampleQueue sampleQueue = this.sampleQueues[i4];
        if (!this.loadingFinished || j4 <= sampleQueue.getLargestQueuedTimestampUs()) {
            int advanceTo = sampleQueue.advanceTo(j4, true, true);
            if (advanceTo != -1) {
                i5 = advanceTo;
            }
        } else {
            i5 = sampleQueue.advanceToEnd();
        }
        if (i5 > 0) {
            maybeNotifyTrackFormat(i4);
            return i5;
        }
        maybeStartDeferredRetry(i4);
        return i5;
    }

    public final TrackOutput track(int i4, int i5) {
        int length2 = this.sampleQueues.length;
        for (int i6 = 0; i6 < length2; i6++) {
            if (this.sampleQueueTrackIds[i6] == i4) {
                return this.sampleQueues[i6];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i7 = length2 + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i7);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length2] = i4;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i7);
        this.sampleQueues = sampleQueueArr;
        sampleQueueArr[length2] = sampleQueue;
        return sampleQueue;
    }

    public final void onLoadCanceled(ExtractingLoadable extractingLoadable, long j4, long j5, boolean z4) {
        this.eventDispatcher.loadCanceled(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j4, j5, extractingLoadable.bytesLoaded);
        if (!z4) {
            copyLengthFromLoader(extractingLoadable);
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            if (this.enabledTrackCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public final void onLoadCompleted(ExtractingLoadable extractingLoadable, long j4, long j5) {
        if (this.durationUs == C.TIME_UNSET) {
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            long j6 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : largestQueuedTimestampUs + 10000;
            this.durationUs = j6;
            this.listener.onSourceInfoRefreshed(j6, this.seekMap.isSeekable());
        }
        this.eventDispatcher.loadCompleted(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j4, j5, extractingLoadable.bytesLoaded);
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        this.callback.onContinueLoadingRequested(this);
    }

    public final int onLoadError(ExtractingLoadable extractingLoadable, long j4, long j5, IOException iOException) {
        boolean isLoadableExceptionFatal = isLoadableExceptionFatal(iOException);
        this.eventDispatcher.loadError(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j4, j5, extractingLoadable.bytesLoaded, iOException, isLoadableExceptionFatal);
        copyLengthFromLoader(extractingLoadable);
        if (isLoadableExceptionFatal) {
            return 3;
        }
        int extractedSamplesCount = getExtractedSamplesCount();
        boolean z4 = extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad;
        if (configureRetry(extractingLoadable, extractedSamplesCount)) {
            return z4 ? 1 : 0;
        }
        return 2;
    }
}
