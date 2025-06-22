package com.mbridge.msdk.playercommon.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    public boolean continueLoading(long j4) {
        boolean z4;
        boolean z5;
        long j5 = j4;
        boolean z6 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return z6;
            }
            z4 = false;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                if (nextLoadPositionUs2 == Long.MIN_VALUE || nextLoadPositionUs2 > j5) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (nextLoadPositionUs2 == nextLoadPositionUs || z5) {
                    z4 |= sequenceableLoader.continueLoading(j5);
                }
            }
            z6 |= z4;
        } while (z4);
        return z6;
    }

    public final long getBufferedPositionUs() {
        long j4 = Long.MAX_VALUE;
        for (SequenceableLoader bufferedPositionUs : this.loaders) {
            long bufferedPositionUs2 = bufferedPositionUs.getBufferedPositionUs();
            if (bufferedPositionUs2 != Long.MIN_VALUE) {
                j4 = Math.min(j4, bufferedPositionUs2);
            }
        }
        if (j4 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public final long getNextLoadPositionUs() {
        long j4 = Long.MAX_VALUE;
        for (SequenceableLoader nextLoadPositionUs : this.loaders) {
            long nextLoadPositionUs2 = nextLoadPositionUs.getNextLoadPositionUs();
            if (nextLoadPositionUs2 != Long.MIN_VALUE) {
                j4 = Math.min(j4, nextLoadPositionUs2);
            }
        }
        if (j4 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public final void reevaluateBuffer(long j4) {
        for (SequenceableLoader reevaluateBuffer : this.loaders) {
            reevaluateBuffer.reevaluateBuffer(j4);
        }
    }
}
