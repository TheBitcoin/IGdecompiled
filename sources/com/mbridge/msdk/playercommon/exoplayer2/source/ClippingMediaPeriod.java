package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    long startUs;

    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public final void clearSentEos() {
            this.sentEos = false;
        }

        public final boolean isReady() {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity() || !this.childStream.isReady()) {
                return false;
            }
            return true;
        }

        public final void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.childStream.readData(formatHolder, decoderInputBuffer, z4);
            if (readData == -5) {
                Format format = formatHolder.format;
                int i4 = format.encoderDelay;
                if (!(i4 == 0 && format.encoderPadding == 0)) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i5 = 0;
                    if (clippingMediaPeriod.startUs != 0) {
                        i4 = 0;
                    }
                    if (clippingMediaPeriod.endUs == Long.MIN_VALUE) {
                        i5 = format.encoderPadding;
                    }
                    formatHolder.format = format.copyWithGaplessInfo(i4, i5);
                }
                return -5;
            }
            ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
            long j4 = clippingMediaPeriod2.endUs;
            if (j4 == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < j4) && (readData != -3 || clippingMediaPeriod2.getBufferedPositionUs() != Long.MIN_VALUE))) {
                return readData;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.sentEos = true;
            return -4;
        }

        public final int skipData(long j4) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j4);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod2, boolean z4, long j4, long j5) {
        long j6;
        this.mediaPeriod = mediaPeriod2;
        if (z4) {
            j6 = j4;
        } else {
            j6 = C.TIME_UNSET;
        }
        this.pendingInitialDiscontinuityPositionUs = j6;
        this.startUs = j4;
        this.endUs = j5;
    }

    private SeekParameters clipSeekParameters(long j4, SeekParameters seekParameters) {
        long j5;
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0, j4 - this.startUs);
        long j6 = seekParameters.toleranceAfterUs;
        long j7 = this.endUs;
        if (j7 == Long.MIN_VALUE) {
            j5 = Long.MAX_VALUE;
        } else {
            j5 = j7 - j4;
        }
        long constrainValue2 = Util.constrainValue(j6, 0, j5);
        if (constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs) {
            return seekParameters;
        }
        return new SeekParameters(constrainValue, constrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j4, TrackSelection[] trackSelectionArr) {
        if (j4 != 0) {
            for (TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean continueLoading(long j4) {
        return this.mediaPeriod.continueLoading(j4);
    }

    public final void discardBuffer(long j4, boolean z4) {
        this.mediaPeriod.discardBuffer(j4, z4);
    }

    public final long getAdjustedSeekPositionUs(long j4, SeekParameters seekParameters) {
        long j5 = this.startUs;
        if (j4 == j5) {
            return j5;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j4, clipSeekParameters(j4, seekParameters));
    }

    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j4 = this.endUs;
            if (j4 == Long.MIN_VALUE || bufferedPositionUs < j4) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j4 = this.endUs;
            if (j4 == Long.MIN_VALUE || nextLoadPositionUs < j4) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    /* access modifiers changed from: package-private */
    public final boolean isPendingInitialDiscontinuity() {
        if (this.pendingInitialDiscontinuityPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    public final void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        this.callback.onPrepared(this);
    }

    public final void prepare(MediaPeriod.Callback callback2, long j4) {
        this.callback = callback2;
        this.mediaPeriod.prepare(this, j4);
    }

    public final long readDiscontinuity() {
        boolean z4;
        if (isPendingInitialDiscontinuity()) {
            long j4 = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = C.TIME_UNSET;
            long readDiscontinuity = readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                return readDiscontinuity;
            }
            return j4;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z5 = false;
        if (readDiscontinuity2 >= this.startUs) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        long j5 = this.endUs;
        if (j5 == Long.MIN_VALUE || readDiscontinuity2 <= j5) {
            z5 = true;
        }
        Assertions.checkState(z5);
        return readDiscontinuity2;
    }

    public final void reevaluateBuffer(long j4) {
        this.mediaPeriod.reevaluateBuffer(j4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long seekToUs(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.pendingInitialDiscontinuityPositionUs = r0
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r6.sampleStreams
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.clearSentEos()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r0 = r6.mediaPeriod
            long r0 = r0.seekToUs(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.startUs
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.endUs
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.seekToUs(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        if (r10 > r13) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long selectTracks(com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection[] r10, boolean[] r11, com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[] r12, boolean[] r13, long r14) {
        /*
            r9 = this;
            int r0 = r12.length
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = new com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[r0]
            r9.sampleStreams = r0
            int r0 = r12.length
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[] r4 = new com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[r0]
            r0 = 0
            r1 = 0
        L_0x000a:
            int r2 = r12.length
            r8 = 0
            if (r1 >= r2) goto L_0x001f
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = r9.sampleStreams
            r3 = r12[r1]
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r3 = (com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream) r3
            r2[r1] = r3
            if (r3 == 0) goto L_0x001a
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream r8 = r3.childStream
        L_0x001a:
            r4[r1] = r8
            int r1 = r1 + 1
            goto L_0x000a
        L_0x001f:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r1 = r9.mediaPeriod
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            long r10 = r1.selectTracks(r2, r3, r4, r5, r6)
            boolean r13 = r9.isPendingInitialDiscontinuity()
            if (r13 == 0) goto L_0x003d
            long r13 = r9.startUs
            int r15 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x003d
            boolean r13 = shouldKeepInitialDiscontinuity(r13, r2)
            if (r13 == 0) goto L_0x003d
            r13 = r10
            goto L_0x0042
        L_0x003d:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0042:
            r9.pendingInitialDiscontinuityPositionUs = r13
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x005d
            long r13 = r9.startUs
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x005b
            long r13 = r9.endUs
            r1 = -9223372036854775808
            int r15 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r15 == 0) goto L_0x005d
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 > 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r13 = 0
            goto L_0x005e
        L_0x005d:
            r13 = 1
        L_0x005e:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r13)
        L_0x0061:
            int r13 = r12.length
            if (r0 >= r13) goto L_0x008b
            r13 = r4[r0]
            if (r13 != 0) goto L_0x006d
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            r13[r0] = r8
            goto L_0x0082
        L_0x006d:
            r14 = r12[r0]
            if (r14 == 0) goto L_0x0079
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r14 = r9.sampleStreams
            r14 = r14[r0]
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream r14 = r14.childStream
            if (r14 == r13) goto L_0x0082
        L_0x0079:
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r14 = r9.sampleStreams
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r15 = new com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream
            r15.<init>(r13)
            r14[r0] = r15
        L_0x0082:
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r13 = r9.sampleStreams
            r13 = r13[r0]
            r12[r0] = r13
            int r0 = r0 + 1
            goto L_0x0061
        L_0x008b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.selectTracks(com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection[], boolean[], com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    public final void updateClipping(long j4, long j5) {
        this.startUs = j4;
        this.endUs = j5;
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }
}
