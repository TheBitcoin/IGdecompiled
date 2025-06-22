package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final String TAG = "ChunkSampleStream";
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final T chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    /* access modifiers changed from: private */
    public final Format[] embeddedTrackFormats;
    /* access modifiers changed from: private */
    public final int[] embeddedTrackTypes;
    /* access modifiers changed from: private */
    public final boolean[] embeddedTracksSelected;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    /* access modifiers changed from: private */
    public long lastSeekPositionUs;
    private final Loader loader = new Loader("Loader:ChunkSampleStream");
    boolean loadingFinished;
    private final BaseMediaChunkOutput mediaChunkOutput;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    private final int minLoadableRetryCount;
    private final ChunkHolder nextChunkHolder = new ChunkHolder();
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;
    @Nullable
    private ReleaseCallback<T> releaseCallback;

    public final class EmbeddedSampleStream implements SampleStream {
        private boolean formatNotificationSent;
        private final int index;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue2, int i4) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue2;
            this.index = i4;
        }

        private void maybeNotifyTrackFormatChanged() {
            if (!this.formatNotificationSent) {
                ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, (Object) null, ChunkSampleStream.this.lastSeekPositionUs);
                this.formatNotificationSent = true;
            }
        }

        public final boolean isReady() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.loadingFinished) {
                return true;
            }
            if (chunkSampleStream.isPendingReset() || !this.sampleQueue.hasNextSample()) {
                return false;
            }
            return true;
        }

        public final void maybeThrowError() throws IOException {
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            SampleQueue sampleQueue2 = this.sampleQueue;
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            int read = sampleQueue2.read(formatHolder, decoderInputBuffer, z4, chunkSampleStream.loadingFinished, chunkSampleStream.decodeOnlyUntilPositionUs);
            if (read == -4) {
                maybeNotifyTrackFormatChanged();
            }
            return read;
        }

        public final void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        public final int skipData(long j4) {
            int i4;
            if (!ChunkSampleStream.this.loadingFinished || j4 <= this.sampleQueue.getLargestQueuedTimestampUs()) {
                i4 = this.sampleQueue.advanceTo(j4, true, true);
                if (i4 == -1) {
                    i4 = 0;
                }
            } else {
                i4 = this.sampleQueue.advanceToEnd();
            }
            if (i4 > 0) {
                maybeNotifyTrackFormatChanged();
            }
            return i4;
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i4, int[] iArr, Format[] formatArr, T t4, SequenceableLoader.Callback<ChunkSampleStream<T>> callback2, Allocator allocator, long j4, int i5, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        int i6;
        this.primaryTrackType = i4;
        this.embeddedTrackTypes = iArr;
        this.embeddedTrackFormats = formatArr;
        this.chunkSource = t4;
        this.callback = callback2;
        this.eventDispatcher = eventDispatcher2;
        this.minLoadableRetryCount = i5;
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = DesugarCollections.unmodifiableList(arrayList);
        int i7 = 0;
        if (iArr == null) {
            i6 = 0;
        } else {
            i6 = iArr.length;
        }
        this.embeddedSampleQueues = new SampleQueue[i6];
        this.embeddedTracksSelected = new boolean[i6];
        int i8 = i6 + 1;
        int[] iArr2 = new int[i8];
        SampleQueue[] sampleQueueArr = new SampleQueue[i8];
        SampleQueue sampleQueue = new SampleQueue(allocator);
        this.primarySampleQueue = sampleQueue;
        iArr2[0] = i4;
        sampleQueueArr[0] = sampleQueue;
        while (i7 < i6) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator);
            this.embeddedSampleQueues[i7] = sampleQueue2;
            int i9 = i7 + 1;
            sampleQueueArr[i9] = sampleQueue2;
            iArr2[i9] = iArr[i7];
            i7 = i9;
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j4;
        this.lastSeekPositionUs = j4;
    }

    private void discardDownstreamMediaChunks(int i4) {
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i4, 0);
        if (primaryStreamIndexToMediaChunkIndex > 0) {
            Util.removeRange(this.mediaChunks, 0, primaryStreamIndexToMediaChunkIndex);
        }
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i4) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i4);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i4, arrayList.size());
        int i5 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i5 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i5];
            i5++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i5));
        }
    }

    private BaseMediaChunk getLastMediaChunk() {
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean haveReadFromMediaChunk(int i4) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i4);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i5 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i5 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i5].getReadIndex();
            i5++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i5));
        return true;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i4, int i5) {
        int i6;
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i4 - i5, 0);
        if (i5 == 1) {
            i6 = primaryStreamIndexToMediaChunkIndex;
        } else {
            i6 = primaryStreamIndexToMediaChunkIndex(i4 - 1, primaryStreamIndexToMediaChunkIndex);
        }
        while (primaryStreamIndexToMediaChunkIndex <= i6) {
            maybeNotifyPrimaryTrackFormatChanged(primaryStreamIndexToMediaChunkIndex);
            primaryStreamIndexToMediaChunkIndex++;
        }
    }

    private int primaryStreamIndexToMediaChunkIndex(int i4, int i5) {
        do {
            i5++;
            if (i5 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i5).getFirstSampleIndex(0) <= i4);
        return i5 - 1;
    }

    public boolean continueLoading(long j4) {
        BaseMediaChunk lastMediaChunk;
        long j5;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        boolean isPendingReset = isPendingReset();
        if (isPendingReset) {
            j5 = this.pendingResetPositionUs;
            lastMediaChunk = null;
        } else {
            lastMediaChunk = getLastMediaChunk();
            j5 = lastMediaChunk.endTimeUs;
        }
        this.chunkSource.getNextChunk(lastMediaChunk, j4, j5, this.nextChunkHolder);
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z4 = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z4) {
            this.pendingResetPositionUs = C.TIME_UNSET;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (isPendingReset) {
                    long j6 = baseMediaChunk.startTimeUs;
                    long j7 = this.pendingResetPositionUs;
                    if (j6 == j7) {
                        j7 = Long.MIN_VALUE;
                    }
                    this.decodeOnlyUntilPositionUs = j7;
                    this.pendingResetPositionUs = C.TIME_UNSET;
                }
                baseMediaChunk.init(this.mediaChunkOutput);
                this.mediaChunks.add(baseMediaChunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    public void discardBuffer(long j4, boolean z4) {
        int firstIndex = this.primarySampleQueue.getFirstIndex();
        this.primarySampleQueue.discardTo(j4, z4, true);
        int firstIndex2 = this.primarySampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
            int i4 = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                if (i4 < sampleQueueArr.length) {
                    sampleQueueArr[i4].discardTo(firstTimestampUs, z4, this.embeddedTracksSelected[i4]);
                    i4++;
                } else {
                    discardDownstreamMediaChunks(firstIndex2);
                    return;
                }
            }
        }
    }

    public long getAdjustedSeekPositionUs(long j4, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j4, seekParameters);
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j4 = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j4 = Math.max(j4, lastMediaChunk.endTimeUs);
        }
        return Math.max(j4, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    /* access modifiers changed from: package-private */
    public boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    public boolean isReady() {
        if (this.loadingFinished) {
            return true;
        }
        if (isPendingReset() || !this.primarySampleQueue.hasNextSample()) {
            return false;
        }
        return true;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (SampleQueue reset : this.embeddedSampleQueues) {
            reset.reset();
        }
        ReleaseCallback<T> releaseCallback2 = this.releaseCallback;
        if (releaseCallback2 != null) {
            releaseCallback2.onSampleStreamReleased(this);
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
        if (isPendingReset()) {
            return -3;
        }
        int read = this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z4, this.loadingFinished, this.decodeOnlyUntilPositionUs);
        if (read == -4) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), 1);
        }
        return read;
    }

    public void reevaluateBuffer(long j4) {
        int size;
        int preferredQueueSize;
        if (!this.loader.isLoading() && !isPendingReset() && (size = this.mediaChunks.size()) > (preferredQueueSize = this.chunkSource.getPreferredQueueSize(j4, this.readOnlyMediaChunks))) {
            while (true) {
                if (preferredQueueSize >= size) {
                    preferredQueueSize = size;
                    break;
                } else if (!haveReadFromMediaChunk(preferredQueueSize)) {
                    break;
                } else {
                    preferredQueueSize++;
                }
            }
            if (preferredQueueSize != size) {
                long j5 = getLastMediaChunk().endTimeUs;
                BaseMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(preferredQueueSize);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
                this.loadingFinished = false;
                this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, discardUpstreamMediaChunksFromIndex.startTimeUs, j5);
            }
        }
    }

    public void release() {
        release((ReleaseCallback) null);
    }

    public void seekToUs(long j4) {
        boolean z4;
        BaseMediaChunk baseMediaChunk;
        boolean z5;
        this.lastSeekPositionUs = j4;
        this.primarySampleQueue.rewind();
        if (isPendingReset()) {
            z4 = false;
        } else {
            int i4 = 0;
            while (true) {
                if (i4 >= this.mediaChunks.size()) {
                    break;
                }
                baseMediaChunk = this.mediaChunks.get(i4);
                int i5 = (baseMediaChunk.startTimeUs > j4 ? 1 : (baseMediaChunk.startTimeUs == j4 ? 0 : -1));
                if (i5 == 0 && baseMediaChunk.seekTimeUs == C.TIME_UNSET) {
                    break;
                } else if (i5 > 0) {
                    break;
                } else {
                    i4++;
                }
            }
            baseMediaChunk = null;
            if (baseMediaChunk != null) {
                z4 = this.primarySampleQueue.setReadPosition(baseMediaChunk.getFirstSampleIndex(0));
                this.decodeOnlyUntilPositionUs = Long.MIN_VALUE;
            } else {
                SampleQueue sampleQueue = this.primarySampleQueue;
                if (j4 < getNextLoadPositionUs()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (sampleQueue.advanceTo(j4, true, z5) != -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
            }
        }
        if (z4) {
            for (SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
                sampleQueue2.rewind();
                sampleQueue2.advanceTo(j4, true, false);
            }
            return;
        }
        this.pendingResetPositionUs = j4;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.primarySampleQueue.reset();
        for (SampleQueue reset : this.embeddedSampleQueues) {
            reset.reset();
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j4, int i4) {
        for (int i5 = 0; i5 < this.embeddedSampleQueues.length; i5++) {
            if (this.embeddedTrackTypes[i5] == i4) {
                Assertions.checkState(!this.embeddedTracksSelected[i5]);
                this.embeddedTracksSelected[i5] = true;
                this.embeddedSampleQueues[i5].rewind();
                this.embeddedSampleQueues[i5].advanceTo(j4, true, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i5], i5);
            }
        }
        throw new IllegalStateException();
    }

    public int skipData(long j4) {
        int i4 = 0;
        if (isPendingReset()) {
            return 0;
        }
        if (!this.loadingFinished || j4 <= this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            int advanceTo = this.primarySampleQueue.advanceTo(j4, true, true);
            if (advanceTo != -1) {
                i4 = advanceTo;
            }
        } else {
            i4 = this.primarySampleQueue.advanceToEnd();
        }
        if (i4 > 0) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), i4);
        }
        return i4;
    }

    public void onLoadCanceled(Chunk chunk, long j4, long j5, boolean z4) {
        Chunk chunk2 = chunk;
        MediaSourceEventListener.EventDispatcher eventDispatcher2 = this.eventDispatcher;
        MediaSourceEventListener.EventDispatcher eventDispatcher3 = eventDispatcher2;
        MediaSourceEventListener.EventDispatcher eventDispatcher4 = eventDispatcher3;
        MediaSourceEventListener.EventDispatcher eventDispatcher5 = eventDispatcher4;
        MediaSourceEventListener.EventDispatcher eventDispatcher6 = eventDispatcher5;
        MediaSourceEventListener.EventDispatcher eventDispatcher7 = eventDispatcher6;
        MediaSourceEventListener.EventDispatcher eventDispatcher8 = eventDispatcher7;
        MediaSourceEventListener.EventDispatcher eventDispatcher9 = eventDispatcher8;
        eventDispatcher9.loadCanceled(chunk2.dataSpec, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j4, j5, chunk2.bytesLoaded());
        if (!z4) {
            this.primarySampleQueue.reset();
            for (SampleQueue reset : this.embeddedSampleQueues) {
                reset.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCompleted(Chunk chunk, long j4, long j5) {
        Chunk chunk2 = chunk;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        this.eventDispatcher.loadCompleted(chunk2.dataSpec, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j4, j5, chunk2.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onLoadError(com.mbridge.msdk.playercommon.exoplayer2.source.chunk.Chunk r22, long r23, long r25, java.io.IOException r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            long r16 = r1.bytesLoaded()
            boolean r2 = r21.isMediaChunk(r22)
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk> r3 = r0.mediaChunks
            int r3 = r3.size()
            r4 = 1
            int r3 = r3 - r4
            r5 = 0
            r20 = 0
            int r7 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0027
            if (r2 == 0) goto L_0x0027
            boolean r5 = r0.haveReadFromMediaChunk(r3)
            if (r5 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r5 = 0
            goto L_0x0028
        L_0x0027:
            r5 = 1
        L_0x0028:
            T r6 = r0.chunkSource
            r7 = r27
            boolean r6 = r6.onChunkLoadError(r1, r5, r7)
            if (r6 == 0) goto L_0x0059
            if (r5 != 0) goto L_0x003c
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r3 = "Ignoring attempt to cancel non-cancelable load."
            android.util.Log.w(r2, r3)
            goto L_0x0059
        L_0x003c:
            if (r2 == 0) goto L_0x0056
            com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk r2 = r0.discardUpstreamMediaChunksFromIndex(r3)
            if (r2 != r1) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r2)
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk> r2 = r0.mediaChunks
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0056
            long r2 = r0.lastSeekPositionUs
            r0.pendingResetPositionUs = r2
        L_0x0056:
            r19 = 1
            goto L_0x005b
        L_0x0059:
            r19 = 0
        L_0x005b:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener$EventDispatcher r2 = r0.eventDispatcher
            r3 = r2
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r2 = r1.dataSpec
            r4 = r3
            int r3 = r1.type
            r5 = r4
            int r4 = r0.primaryTrackType
            r6 = r5
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r1.trackFormat
            r8 = r6
            int r6 = r1.trackSelectionReason
            java.lang.Object r7 = r1.trackSelectionData
            r10 = r8
            long r8 = r1.startTimeUs
            long r11 = r1.endTimeUs
            r14 = r25
            r18 = r27
            r1 = r10
            r10 = r11
            r12 = r23
            r1.loadError(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r16, r18, r19)
            if (r19 == 0) goto L_0x0087
            com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader$Callback<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSampleStream<T>> r1 = r0.callback
            r1.onContinueLoadingRequested(r0)
            r1 = 2
            return r1
        L_0x0087:
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSampleStream.onLoadError(com.mbridge.msdk.playercommon.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException):int");
    }

    public void release(@Nullable ReleaseCallback<T> releaseCallback2) {
        this.releaseCallback = releaseCallback2;
        this.primarySampleQueue.discardToEnd();
        for (SampleQueue discardToEnd : this.embeddedSampleQueues) {
            discardToEnd.discardToEnd();
        }
        this.loader.release(this);
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i4) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i4);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }
}
