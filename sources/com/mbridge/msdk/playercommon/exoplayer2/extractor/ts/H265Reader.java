package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

public final class H265Reader implements ElementaryStreamReader {
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    private static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstParameterSet;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private boolean writingParameterSets;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private void outputSample(int i4) {
            boolean z4 = this.sampleIsKeyframe;
            int i5 = (int) (this.nalUnitStartPosition - this.samplePosition);
            this.output.sampleMetadata(this.sampleTimeUs, z4 ? 1 : 0, i5, i4, (TrackOutput.CryptoData) null);
        }

        public final void endNalUnit(long j4, int i4) {
            if (this.writingParameterSets && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.writingParameterSets = false;
            } else if (this.isFirstParameterSet || this.isFirstSlice) {
                if (this.readingSample) {
                    outputSample(i4 + ((int) (j4 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.readingSample = true;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
            }
        }

        public final void readNalUnitData(byte[] bArr, int i4, int i5) {
            boolean z4;
            if (this.lookingForFirstSliceFlag) {
                int i6 = this.nalUnitBytesRead;
                int i7 = (i4 + 2) - i6;
                if (i7 < i5) {
                    if ((bArr[i7] & 128) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.isFirstSlice = z4;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i6 + (i5 - i4);
            }
        }

        public final void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.readingSample = false;
            this.writingParameterSets = false;
        }

        public final void startNalUnit(long j4, int i4, int i5, long j5) {
            boolean z4;
            boolean z5 = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.nalUnitTimeUs = j5;
            this.nalUnitBytesRead = 0;
            this.nalUnitStartPosition = j4;
            if (i5 >= 32) {
                if (!this.writingParameterSets && this.readingSample) {
                    outputSample(i4);
                    this.readingSample = false;
                }
                if (i5 <= 34) {
                    this.isFirstParameterSet = !this.writingParameterSets;
                    this.writingParameterSets = true;
                }
            }
            if (i5 < 16 || i5 > 21) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.nalUnitHasKeyframeData = z4;
            if (z4 || i5 <= 9) {
                z5 = true;
            }
            this.lookingForFirstSliceFlag = z5;
        }
    }

    public H265Reader(SeiReader seiReader2) {
        this.seiReader = seiReader2;
    }

    private void endNalUnit(long j4, int i4, int i5, long j5) {
        if (this.hasOutputFormat) {
            this.sampleReader.endNalUnit(j4, i4);
        } else {
            this.vps.endNalUnit(i5);
            this.sps.endNalUnit(i5);
            this.pps.endNalUnit(i5);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i5)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
            this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j5, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i5)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
            this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j5, this.seiWrapper);
        }
    }

    private void nalUnitData(byte[] bArr, int i4, int i5) {
        if (this.hasOutputFormat) {
            this.sampleReader.readNalUnitData(bArr, i4, i5);
        } else {
            this.vps.appendToNalUnit(bArr, i4, i5);
            this.sps.appendToNalUnit(bArr, i4, i5);
            this.pps.appendToNalUnit(bArr, i4, i5);
        }
        this.prefixSei.appendToNalUnit(bArr, i4, i5);
        this.suffixSei.appendToNalUnit(bArr, i4, i5);
    }

    private static Format parseMediaFormat(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i4;
        float f4;
        int i5;
        NalUnitTargetBuffer nalUnitTargetBuffer4 = nalUnitTargetBuffer;
        NalUnitTargetBuffer nalUnitTargetBuffer5 = nalUnitTargetBuffer2;
        NalUnitTargetBuffer nalUnitTargetBuffer6 = nalUnitTargetBuffer3;
        int i6 = nalUnitTargetBuffer4.nalLength;
        byte[] bArr = new byte[(nalUnitTargetBuffer5.nalLength + i6 + nalUnitTargetBuffer6.nalLength)];
        System.arraycopy(nalUnitTargetBuffer4.nalData, 0, bArr, 0, i6);
        System.arraycopy(nalUnitTargetBuffer5.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength, nalUnitTargetBuffer5.nalLength);
        System.arraycopy(nalUnitTargetBuffer6.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength + nalUnitTargetBuffer5.nalLength, nalUnitTargetBuffer6.nalLength);
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer5.nalData, 0, nalUnitTargetBuffer5.nalLength);
        parsableNalUnitBitArray.skipBits(44);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i7 = 0;
        for (int i8 = 0; i8 < readBits; i8++) {
            if (parsableNalUnitBitArray.readBit()) {
                i7 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i7 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i7);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i9 = 1;
            if (readUnsignedExpGolombCodedInt == 1 || readUnsignedExpGolombCodedInt == 2) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            if (readUnsignedExpGolombCodedInt == 1) {
                i9 = 2;
            }
            readUnsignedExpGolombCodedInt2 -= i5 * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
            readUnsignedExpGolombCodedInt3 -= i9 * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
        }
        int i10 = readUnsignedExpGolombCodedInt2;
        int i11 = readUnsignedExpGolombCodedInt3;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            i4 = 0;
        } else {
            i4 = readBits;
        }
        while (i4 <= readBits) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i4++;
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            skipScalingList(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipShortTermRefPicSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i12 = 0; i12 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i12++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 5);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f5 = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = parsableNalUnitBitArray.readBits(16);
                int readBits4 = parsableNalUnitBitArray.readBits(16);
                if (!(readBits3 == 0 || readBits4 == 0)) {
                    f5 = ((float) readBits3) / ((float) readBits4);
                }
            } else {
                float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                if (readBits2 < fArr.length) {
                    f5 = fArr[readBits2];
                } else {
                    Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits2);
                }
            }
            f4 = f5;
            return Format.createVideoSampleFormat(str, MimeTypes.VIDEO_H265, (String) null, -1, -1, i10, i11, -1.0f, Collections.singletonList(bArr), -1, f4, (DrmInitData) null);
        }
        f4 = 1.0f;
        return Format.createVideoSampleFormat(str, MimeTypes.VIDEO_H265, (String) null, -1, -1, i10, i11, -1.0f, Collections.singletonList(bArr), -1, f4, (DrmInitData) null);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = 0;
            while (i5 < 6) {
                int i6 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i4 << 1) + 4));
                    if (i4 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i7 = 0; i7 < min; i7++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i4 == 3) {
                    i6 = 3;
                }
                i5 += i6;
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean z4 = false;
        int i4 = 0;
        for (int i5 = 0; i5 < readUnsignedExpGolombCodedInt; i5++) {
            if (i5 != 0) {
                z4 = parsableNalUnitBitArray.readBit();
            }
            if (z4) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i6 = 0; i6 <= i4; i6++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i7 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                for (int i8 = 0; i8 < readUnsignedExpGolombCodedInt2; i8++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i9 = 0; i9 < readUnsignedExpGolombCodedInt3; i9++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i4 = i7;
            }
        }
    }

    private void startNalUnit(long j4, int i4, int i5, long j5) {
        int i6;
        if (this.hasOutputFormat) {
            i6 = i5;
            this.sampleReader.startNalUnit(j4, i4, i6, j5);
        } else {
            i6 = i5;
            this.vps.startNalUnit(i6);
            this.sps.startNalUnit(i6);
            this.pps.startNalUnit(i6);
        }
        this.prefixSei.startNalUnit(i6);
        this.suffixSei.startNalUnit(i6);
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        int i4;
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] bArr = parsableByteArray.data;
            this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (true) {
                if (position < limit) {
                    int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
                    if (findNalUnit == limit) {
                        nalUnitData(bArr, position, limit);
                        return;
                    }
                    int h265NalUnitType = NalUnitUtil.getH265NalUnitType(bArr, findNalUnit);
                    int i5 = findNalUnit - position;
                    if (i5 > 0) {
                        nalUnitData(bArr, position, findNalUnit);
                    }
                    int i6 = limit - findNalUnit;
                    long j4 = this.totalBytesWritten - ((long) i6);
                    if (i5 < 0) {
                        i4 = -i5;
                    } else {
                        i4 = 0;
                    }
                    long j5 = j4;
                    int i7 = i4;
                    long j6 = j5;
                    endNalUnit(j6, i6, i7, this.pesTimeUs);
                    startNalUnit(j6, i6, h265NalUnitType, this.pesTimeUs);
                    position = findNalUnit + 3;
                }
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j4, boolean z4) {
        this.pesTimeUs = j4;
    }

    public final void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0;
    }
}
