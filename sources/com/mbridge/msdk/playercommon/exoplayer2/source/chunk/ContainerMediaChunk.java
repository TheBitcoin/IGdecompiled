package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i4, Object obj, long j4, long j5, long j6, long j7, int i5, long j8, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i4, obj, j4, j5, j6, j7);
        this.chunkCount = i5;
        this.sampleOffsetUs = j8;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    public final long bytesLoaded() {
        return (long) this.bytesLoaded;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public long getNextChunkIndex() {
        return this.chunkIndex + ((long) this.chunkCount);
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public final void load() throws IOException, InterruptedException {
        DefaultExtractorInput defaultExtractorInput;
        long j4;
        DataSpec subrange = this.dataSpec.subrange((long) this.bytesLoaded);
        try {
            DataSource dataSource = this.dataSource;
            defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
            if (this.bytesLoaded == 0) {
                BaseMediaChunkOutput output = getOutput();
                output.setSampleOffsetUs(this.sampleOffsetUs);
                ChunkExtractorWrapper chunkExtractorWrapper = this.extractorWrapper;
                long j5 = this.seekTimeUs;
                if (j5 == C.TIME_UNSET) {
                    j4 = 0;
                } else {
                    j4 = j5 - this.sampleOffsetUs;
                }
                chunkExtractorWrapper.init(output, j4);
            }
            Extractor extractor = this.extractorWrapper.extractor;
            boolean z4 = false;
            int i4 = 0;
            while (i4 == 0 && !this.loadCanceled) {
                i4 = extractor.read(defaultExtractorInput, (PositionHolder) null);
            }
            if (i4 != 1) {
                z4 = true;
            }
            Assertions.checkState(z4);
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
