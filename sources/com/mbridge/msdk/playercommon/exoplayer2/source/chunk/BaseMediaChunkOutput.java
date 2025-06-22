package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DummyTrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkExtractorWrapper;

public final class BaseMediaChunkOutput implements ChunkExtractorWrapper.TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    public final int[] getWriteIndices() {
        int[] iArr = new int[this.sampleQueues.length];
        int i4 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i4 >= sampleQueueArr.length) {
                return iArr;
            }
            SampleQueue sampleQueue = sampleQueueArr[i4];
            if (sampleQueue != null) {
                iArr[i4] = sampleQueue.getWriteIndex();
            }
            i4++;
        }
    }

    public final void setSampleOffsetUs(long j4) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue != null) {
                sampleQueue.setSampleOffsetUs(j4);
            }
        }
    }

    public final TrackOutput track(int i4, int i5) {
        int i6 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i6 >= iArr.length) {
                Log.e(TAG, "Unmatched track of type: " + i5);
                return new DummyTrackOutput();
            } else if (i5 == iArr[i6]) {
                return this.sampleQueues[i6];
            } else {
                i6++;
            }
        }
    }
}
