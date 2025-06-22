package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i4, Object obj, long j4, long j5, long j6) {
        super(dataSource, dataSpec, 1, format, i4, obj, j4, j5);
        Assertions.checkNotNull(format);
        this.chunkIndex = j6;
    }

    public long getNextChunkIndex() {
        long j4 = this.chunkIndex;
        if (j4 != -1) {
            return j4 + 1;
        }
        return -1;
    }

    public abstract boolean isLoadCompleted();
}
