package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private final CsdBuffer csdBuffer = new CsdBuffer(128);
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags = new boolean[4];
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;

    private static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i4) {
            this.data = new byte[i4];
        }

        public final void onData(byte[] bArr, int i4, int i5) {
            if (this.isFilling) {
                int i6 = i5 - i4;
                byte[] bArr2 = this.data;
                int length2 = bArr2.length;
                int i7 = this.length;
                if (length2 < i7 + i6) {
                    this.data = Arrays.copyOf(bArr2, (i7 + i6) * 2);
                }
                System.arraycopy(bArr, i4, this.data, this.length, i6);
                this.length += i6;
            }
        }

        public final boolean onStartCode(int i4, int i5) {
            if (this.isFilling) {
                int i6 = this.length - i5;
                this.length = i6;
                if (this.sequenceExtensionPosition == 0 && i4 == H262Reader.START_EXTENSION) {
                    this.sequenceExtensionPosition = i6;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i4 == H262Reader.START_SEQUENCE_HEADER) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public final void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.mbridge.msdk.playercommon.exoplayer2.Format, java.lang.Long> parseCsdBuffer(com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.H262Reader.CsdBuffer r20, java.lang.String r21) {
        /*
            r0 = r20
            byte[] r1 = r0.data
            int r2 = r0.length
            byte[] r1 = java.util.Arrays.copyOf(r1, r2)
            r2 = 4
            byte r3 = r1[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 5
            byte r5 = r1[r4]
            r6 = r5 & 255(0xff, float:3.57E-43)
            r7 = 6
            byte r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r2
            int r6 = r6 >> r2
            r13 = r3 | r6
            r3 = r5 & 15
            int r3 = r3 << 8
            r14 = r3 | r7
            r3 = 7
            byte r5 = r1[r3]
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r5 = r5 >> r2
            r6 = 2
            if (r5 == r6) goto L_0x0046
            r6 = 3
            if (r5 == r6) goto L_0x0040
            if (r5 == r2) goto L_0x0036
            r2 = 1065353216(0x3f800000, float:1.0)
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L_0x004c
        L_0x0036:
            int r2 = r14 * 121
            float r2 = (float) r2
            int r5 = r13 * 100
        L_0x003b:
            float r5 = (float) r5
            float r2 = r2 / r5
            r18 = r2
            goto L_0x004c
        L_0x0040:
            int r2 = r14 * 16
            float r2 = (float) r2
            int r5 = r13 * 9
            goto L_0x003b
        L_0x0046:
            int r2 = r14 * 4
            float r2 = (float) r2
            int r5 = r13 * 3
            goto L_0x003b
        L_0x004c:
            java.util.List r16 = java.util.Collections.singletonList(r1)
            r17 = -1
            r19 = 0
            java.lang.String r9 = "video/mpeg2"
            r10 = 0
            r11 = -1
            r12 = -1
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = r21
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            byte r3 = r1[r3]
            r3 = r3 & 15
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x008f
            double[] r5 = FRAME_RATE_VALUES
            int r6 = r5.length
            if (r3 >= r6) goto L_0x008f
            r6 = r5[r3]
            int r0 = r0.sequenceExtensionPosition
            int r0 = r0 + 9
            byte r0 = r1[r0]
            r1 = r0 & 96
            int r1 = r1 >> r4
            r0 = r0 & 31
            if (r1 == r0) goto L_0x0087
            double r3 = (double) r1
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r8
            int r0 = r0 + 1
            double r0 = (double) r0
            double r3 = r3 / r0
            double r6 = r6 * r3
        L_0x0087:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r6
            long r0 = (long) r0
            goto L_0x0091
        L_0x008f:
            r0 = 0
        L_0x0091:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            android.util.Pair r0 = android.util.Pair.create(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.H262Reader.parseCsdBuffer(com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.H262Reader$CsdBuffer, java.lang.String):android.util.Pair");
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        int i4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray2.getPosition();
        int limit = parsableByteArray2.limit();
        byte[] bArr = parsableByteArray2.data;
        this.totalBytesWritten += (long) parsableByteArray2.bytesLeft();
        this.output.sampleData(parsableByteArray2, parsableByteArray2.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i5 = findNalUnit + 3;
            byte b5 = parsableByteArray2.data[i5] & 255;
            boolean z4 = false;
            if (!this.hasOutputFormat) {
                int i6 = findNalUnit - position;
                if (i6 > 0) {
                    this.csdBuffer.onData(bArr, position, findNalUnit);
                }
                if (i6 < 0) {
                    i4 = -i6;
                } else {
                    i4 = 0;
                }
                if (this.csdBuffer.onStartCode(b5, i4)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            if (b5 == 0 || b5 == START_SEQUENCE_HEADER) {
                int i7 = limit - findNalUnit;
                if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                    this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i7, i7, (TrackOutput.CryptoData) null);
                }
                int i8 = i7;
                boolean z5 = this.startedFirstSample;
                if (!z5 || this.sampleHasPicture) {
                    this.samplePosition = this.totalBytesWritten - ((long) i8);
                    long j4 = this.pesTimeUs;
                    if (j4 == C.TIME_UNSET) {
                        if (z5) {
                            j4 = this.sampleTimeUs + this.frameDurationUs;
                        } else {
                            j4 = 0;
                        }
                    }
                    this.sampleTimeUs = j4;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = C.TIME_UNSET;
                    this.startedFirstSample = true;
                }
                if (b5 == 0) {
                    z4 = true;
                }
                this.sampleHasPicture = z4;
            } else if (b5 == START_GROUP) {
                this.sampleIsKeyframe = true;
            }
            position = i5;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, position, limit);
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j4, boolean z4) {
        this.pesTimeUs = j4;
    }

    public final void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        this.totalBytesWritten = 0;
        this.startedFirstSample = false;
    }
}
