package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z4) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z4;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public final boolean moveNext() {
            long j4;
            int i4;
            int i5 = this.index + 1;
            this.index = i5;
            if (i5 == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j4 = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j4 = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j4;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i6 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i6;
                if (i6 > 0) {
                    i4 = this.stsc.readUnsignedIntToInt() - 1;
                } else {
                    i4 = -1;
                }
                this.nextSamplesPerChunkChangeIndex = i4;
            }
            return true;
        }
    }

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i4) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i4];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final boolean isFixedSampleSize() {
            if (this.fixedSampleSize != 0) {
                return true;
            }
            return false;
        }

        public final int readNextSampleSize() {
            int i4 = this.fixedSampleSize;
            if (i4 == 0) {
                return this.data.readUnsignedIntToInt();
            }
            return i4;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final boolean isFixedSampleSize() {
            return false;
        }

        public final int readNextSampleSize() {
            int i4 = this.fieldSize;
            if (i4 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i4 == 16) {
                return this.data.readUnsignedShort();
            }
            int i5 = this.sampleIndex;
            this.sampleIndex = i5 + 1;
            if (i5 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */
        public final int id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i4, long j4, int i5) {
            this.id = i4;
            this.duration = j4;
            this.rotationDegrees = i5;
        }
    }

    public static final class UnhandledEditListException extends ParserException {
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j4, long j5, long j6) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(3, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 3, 0, length);
        if (jArr[0] > j5 || j5 >= jArr[constrainValue] || jArr[constrainValue2] >= j6 || j6 > j4) {
            return false;
        }
        return true;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i4, int i5) {
        boolean z4;
        int position = parsableByteArray.getPosition();
        while (position - i4 < i5) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r29, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.StsdData r30, int r31) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r22
            r1 = r24
            r2 = r25
            r11 = r27
            r3 = r29
            r14 = r30
            int r4 = r1 + 16
            r0.setPosition(r4)
            r4 = 6
            if (r28 == 0) goto L_0x001c
            int r5 = r0.readUnsignedShort()
            r0.skipBytes(r4)
            goto L_0x0022
        L_0x001c:
            r5 = 8
            r0.skipBytes(r5)
            r5 = 0
        L_0x0022:
            r6 = 2
            r7 = 1
            r8 = 16
            if (r5 == 0) goto L_0x0043
            if (r5 != r7) goto L_0x002b
            goto L_0x0043
        L_0x002b:
            if (r5 != r6) goto L_0x0200
            r0.skipBytes(r8)
            double r4 = r0.readDouble()
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r0.readUnsignedIntToInt()
            r8 = 20
            r0.skipBytes(r8)
            goto L_0x0055
        L_0x0043:
            int r9 = r0.readUnsignedShort()
            r0.skipBytes(r4)
            int r4 = r0.readUnsignedFixedPoint1616()
            if (r5 != r7) goto L_0x0053
            r0.skipBytes(r8)
        L_0x0053:
            r5 = r4
            r4 = r9
        L_0x0055:
            int r8 = r0.getPosition()
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_enca
            r16 = 0
            r10 = r23
            if (r10 != r9) goto L_0x0089
            android.util.Pair r9 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r9 == 0) goto L_0x0086
            java.lang.Object r10 = r9.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r3 != 0) goto L_0x0074
            r3 = r16
            goto L_0x007e
        L_0x0074:
            java.lang.Object r12 = r9.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r12 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r12
            java.lang.String r12 = r12.schemeType
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r12)
        L_0x007e:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox[] r12 = r14.trackEncryptionBoxes
            java.lang.Object r9 = r9.second
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            r12[r31] = r9
        L_0x0086:
            r0.setPosition(r8)
        L_0x0089:
            r9 = r3
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ac_3
            java.lang.String r12 = "audio/raw"
            if (r10 != r3) goto L_0x0093
            java.lang.String r3 = "audio/ac3"
            goto L_0x00dd
        L_0x0093:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ec_3
            if (r10 != r3) goto L_0x009a
            java.lang.String r3 = "audio/eac3"
            goto L_0x00dd
        L_0x009a:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsc
            if (r10 != r3) goto L_0x00a1
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x00dd
        L_0x00a1:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsh
            if (r10 == r3) goto L_0x00db
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtsl
            if (r10 != r3) goto L_0x00aa
            goto L_0x00db
        L_0x00aa:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dtse
            if (r10 != r3) goto L_0x00b1
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00dd
        L_0x00b1:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_samr
            if (r10 != r3) goto L_0x00b8
            java.lang.String r3 = "audio/3gpp"
            goto L_0x00dd
        L_0x00b8:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sawb
            if (r10 != r3) goto L_0x00bf
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x00dd
        L_0x00bf:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_lpcm
            if (r10 == r3) goto L_0x00d9
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_sowt
            if (r10 != r3) goto L_0x00c8
            goto L_0x00d9
        L_0x00c8:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE__mp3
            if (r10 != r3) goto L_0x00cf
            java.lang.String r3 = "audio/mpeg"
            goto L_0x00dd
        L_0x00cf:
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r10 != r3) goto L_0x00d6
            java.lang.String r3 = "audio/alac"
            goto L_0x00dd
        L_0x00d6:
            r3 = r16
            goto L_0x00dd
        L_0x00d9:
            r3 = r12
            goto L_0x00dd
        L_0x00db:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x00dd:
            r17 = r4
            r4 = r3
            r3 = r8
            r8 = r17
            r17 = r16
        L_0x00e5:
            int r10 = r3 - r1
            if (r10 >= r2) goto L_0x01ce
            r0.setPosition(r3)
            int r10 = r0.readInt()
            if (r10 <= 0) goto L_0x00f4
            r6 = 1
            goto L_0x00f5
        L_0x00f4:
            r6 = 0
        L_0x00f5:
            java.lang.String r7 = "childAtomSize should be positive"
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r6, r7)
            int r6 = r0.readInt()
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r6 == r7) goto L_0x0108
            if (r28 == 0) goto L_0x0114
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_wave
            if (r6 != r13) goto L_0x0114
        L_0x0108:
            r15 = r3
            r11 = r9
            r2 = r10
            r1 = r12
            r18 = 2
            r19 = 1
            r9 = r5
            r5 = 0
            goto L_0x0188
        L_0x0114:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dac3
            if (r6 != r7) goto L_0x0133
            int r6 = r3 + 8
            r0.setPosition(r6)
            java.lang.String r6 = java.lang.Integer.toString(r26)
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r6, r11, r9)
            r14.format = r6
        L_0x0127:
            r15 = r3
            r11 = r9
            r2 = r10
            r1 = r12
            r18 = 2
            r19 = 1
            r9 = r5
        L_0x0130:
            r5 = 0
            goto L_0x01bf
        L_0x0133:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_dec3
            if (r6 != r7) goto L_0x0147
            int r6 = r3 + 8
            r0.setPosition(r6)
            java.lang.String r6 = java.lang.Integer.toString(r26)
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r6, r11, r9)
            r14.format = r6
            goto L_0x0127
        L_0x0147:
            int r7 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ddts
            if (r6 != r7) goto L_0x016f
            r7 = r3
            java.lang.String r3 = java.lang.Integer.toString(r26)
            r6 = r10
            r10 = 0
            r13 = r12
            r12 = 0
            r11 = r9
            r9 = r5
            r5 = 0
            r20 = r6
            r6 = -1
            r21 = r7
            r7 = -1
            r1 = r13
            r2 = r20
            r15 = r21
            r18 = 2
            r19 = 1
            r13 = r27
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.format = r3
            goto L_0x0130
        L_0x016f:
            r15 = r3
            r11 = r9
            r2 = r10
            r1 = r12
            r18 = 2
            r19 = 1
            r9 = r5
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r6 != r3) goto L_0x0130
            byte[] r3 = new byte[r2]
            r0.setPosition(r15)
            r5 = 0
            r0.readBytes(r3, r5, r2)
            r17 = r3
            goto L_0x01bf
        L_0x0188:
            if (r6 != r7) goto L_0x018d
            r3 = r15
        L_0x018b:
            r6 = -1
            goto L_0x0192
        L_0x018d:
            int r3 = findEsdsPosition(r0, r15, r2)
            goto L_0x018b
        L_0x0192:
            if (r3 == r6) goto L_0x01bf
            android.util.Pair r3 = parseEsdsFromParent(r0, r3)
            java.lang.Object r4 = r3.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.second
            r17 = r3
            byte[] r17 = (byte[]) r17
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01bf
            android.util.Pair r3 = com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(r17)
            java.lang.Object r6 = r3.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r8 = r3.intValue()
            r9 = r6
        L_0x01bf:
            int r3 = r15 + r2
            r2 = r25
            r12 = r1
            r5 = r9
            r9 = r11
            r6 = 2
            r7 = 1
            r1 = r24
            r11 = r27
            goto L_0x00e5
        L_0x01ce:
            r11 = r9
            r1 = r12
            r6 = -1
            r18 = 2
            r9 = r5
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r14.format
            if (r0 != 0) goto L_0x0200
            if (r4 == 0) goto L_0x0200
            boolean r0 = r1.equals(r4)
            if (r0 == 0) goto L_0x01e2
            r7 = 2
            goto L_0x01e3
        L_0x01e2:
            r7 = -1
        L_0x01e3:
            java.lang.String r0 = java.lang.Integer.toString(r26)
            if (r17 != 0) goto L_0x01ea
            goto L_0x01ee
        L_0x01ea:
            java.util.List r16 = java.util.Collections.singletonList(r17)
        L_0x01ee:
            r10 = 0
            r2 = 0
            r3 = -1
            r1 = r4
            r4 = -1
            r5 = r8
            r6 = r9
            r9 = r11
            r8 = r16
            r11 = r27
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.format = r0
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i4, int i5) {
        boolean z4;
        boolean z5;
        int i6 = i4 + 8;
        boolean z6 = false;
        String str = null;
        Integer num = null;
        int i7 = -1;
        int i8 = 0;
        while (i6 - i4 < i5) {
            parsableByteArray.setPosition(i6);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i7 = i6;
                i8 = readInt;
            }
            i6 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        if (num != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4, "frma atom is mandatory");
        if (i7 != -1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkArgument(z5, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i7, i8, str);
        if (parseSchiFromParent != null) {
            z6 = true;
        }
        Assertions.checkArgument(z6, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        long j4;
        long j5;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i4 = 0;
        while (i4 < readUnsignedIntToInt) {
            if (parseFullAtomVersion == 1) {
                j4 = parsableByteArray.readUnsignedLongToLong();
            } else {
                j4 = parsableByteArray.readUnsignedInt();
            }
            jArr[i4] = j4;
            if (parseFullAtomVersion == 1) {
                j5 = parsableByteArray.readLong();
            } else {
                j5 = (long) parsableByteArray.readInt();
            }
            jArr2[i4] = j5;
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i4++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i4) {
        parsableByteArray.setPosition(i4 + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i4 = readUnsignedByte & ModuleDescriptor.MODULE_VERSION;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i4 = (i4 << 7) | (readUnsignedByte & ModuleDescriptor.MODULE_VERSION);
        }
        return i4;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        if (readInt == TYPE_meta) {
            return 4;
        }
        return -1;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i4) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i4) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i4;
        int i5 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i4 = 8;
        } else {
            i4 = 16;
        }
        parsableByteArray.skipBytes(i4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i5 = 4;
        }
        parsableByteArray.skipBytes(i5);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i4) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i4) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i4 = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i4 = 16;
        }
        parsableByteArray.skipBytes(i4);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i4) {
        parsableByteArray.setPosition(i4 + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i4, int i5) {
        int i6 = i4 + 8;
        while (i6 - i4 < i5) {
            parsableByteArray.setPosition(i6);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i6, readInt + i6);
            }
            i6 += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i4, int i5) {
        boolean z4;
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i4 < i5) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i4, int i5, String str) {
        int i6;
        int i7;
        boolean z4;
        int i8 = i4 + 8;
        while (true) {
            byte[] bArr = null;
            if (i8 - i4 >= i5) {
                return null;
            }
            parsableByteArray.setPosition(i8);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i7 = 0;
                    i6 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i6 = readUnsignedByte & 15;
                    i7 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                if (parsableByteArray.readUnsignedByte() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z4 && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z4, str, readUnsignedByte2, bArr2, i7, i6, bArr);
            }
            String str2 = str;
            i8 += readInt;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0235  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track r42, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.ContainerAtom r43, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder r44) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
        /*
            r0 = r43
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsz
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r2 = r0.getLeafAtomOfType(r2)
            if (r2 == 0) goto L_0x0010
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r3 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            r3.<init>(r2)
            goto L_0x001d
        L_0x0010:
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stz2
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r2 = r0.getLeafAtomOfType(r2)
            if (r2 == 0) goto L_0x045f
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r3 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r3.<init>(r2)
        L_0x001d:
            int r2 = r3.getSampleCount()
            r4 = 0
            if (r2 != 0) goto L_0x003a
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r4]
            int[] r3 = new int[r4]
            long[] r5 = new long[r4]
            int[] r6 = new int[r4]
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 0
            r1 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x003a:
            r5 = r42
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stco
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x004d
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_co64
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r8 = 1
            goto L_0x004e
        L_0x004d:
            r8 = 0
        L_0x004e:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r6 = r6.data
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stsc
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r9 = r9.data
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r10.data
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_stss
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            r12 = 0
            if (r11 == 0) goto L_0x006c
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r11 = r11.data
            goto L_0x006d
        L_0x006c:
            r11 = r12
        L_0x006d:
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ctts
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0078
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x0079
        L_0x0078:
            r0 = r12
        L_0x0079:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x009a
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x009b
        L_0x009a:
            r15 = 0
        L_0x009b:
            r16 = -1
            if (r11 == 0) goto L_0x00b0
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00b2
            int r12 = r11.readUnsignedIntToInt()
            int r16 = r12 + -1
            r12 = r11
            goto L_0x00b2
        L_0x00b0:
            r12 = r11
            r6 = 0
        L_0x00b2:
            boolean r11 = r3.isFixedSampleSize()
            if (r11 == 0) goto L_0x00ce
            com.mbridge.msdk.playercommon.exoplayer2.Format r11 = r5.format
            java.lang.String r11 = r11.sampleMimeType
            r17 = 0
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x00d0
            if (r8 != 0) goto L_0x00d0
            if (r15 != 0) goto L_0x00d0
            if (r6 != 0) goto L_0x00d0
            r4 = 1
            goto L_0x00d1
        L_0x00ce:
            r17 = 0
        L_0x00d0:
            r4 = 0
        L_0x00d1:
            java.lang.String r11 = "AtomParsers"
            r18 = 0
            if (r4 != 0) goto L_0x01d9
            long[] r4 = new long[r2]
            r20 = 1
            int[] r7 = new int[r2]
            r43 = r0
            long[] r0 = new long[r2]
            r21 = r0
            int[] r0 = new int[r2]
            r22 = r16
            r16 = r0
            r0 = r22
            r22 = r3
            r23 = r4
            r25 = r7
            r26 = r10
            r27 = r18
            r29 = r27
            r3 = 0
            r4 = 0
            r7 = 0
            r10 = 0
            r24 = 0
        L_0x00fd:
            if (r3 >= r2) goto L_0x016e
        L_0x00ff:
            if (r7 != 0) goto L_0x0113
            boolean r7 = r13.moveNext()
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r7)
            r31 = r2
            long r1 = r13.offset
            int r7 = r13.numSamples
            r29 = r1
            r2 = r31
            goto L_0x00ff
        L_0x0113:
            r31 = r2
            if (r43 == 0) goto L_0x0128
        L_0x0117:
            if (r24 != 0) goto L_0x0126
            if (r15 <= 0) goto L_0x0126
            int r24 = r43.readUnsignedIntToInt()
            int r4 = r43.readInt()
            int r15 = r15 + -1
            goto L_0x0117
        L_0x0126:
            int r24 = r24 + -1
        L_0x0128:
            r23[r3] = r29
            int r1 = r22.readNextSampleSize()
            r25[r3] = r1
            if (r1 <= r10) goto L_0x0133
            r10 = r1
        L_0x0133:
            long r1 = (long) r4
            long r1 = r27 + r1
            r21[r3] = r1
            if (r12 != 0) goto L_0x013c
            r1 = 1
            goto L_0x013d
        L_0x013c:
            r1 = 0
        L_0x013d:
            r16[r3] = r1
            if (r3 != r0) goto L_0x014d
            r16[r3] = r20
            int r6 = r6 + -1
            if (r6 <= 0) goto L_0x014d
            int r0 = r12.readUnsignedIntToInt()
            int r0 = r0 + -1
        L_0x014d:
            long r1 = (long) r14
            long r27 = r27 + r1
            int r9 = r9 + -1
            if (r9 != 0) goto L_0x0162
            if (r8 <= 0) goto L_0x0162
            int r1 = r26.readUnsignedIntToInt()
            int r2 = r26.readInt()
            int r8 = r8 + -1
            r9 = r1
            r14 = r2
        L_0x0162:
            r1 = r25[r3]
            long r1 = (long) r1
            long r29 = r29 + r1
            int r7 = r7 + -1
            int r3 = r3 + 1
            r2 = r31
            goto L_0x00fd
        L_0x016e:
            r31 = r2
            long r0 = (long) r4
            long r27 = r27 + r0
            if (r24 != 0) goto L_0x0177
            r0 = 1
            goto L_0x0178
        L_0x0177:
            r0 = 0
        L_0x0178:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r0)
        L_0x017b:
            if (r15 <= 0) goto L_0x018f
            int r0 = r43.readUnsignedIntToInt()
            if (r0 != 0) goto L_0x0185
            r0 = 1
            goto L_0x0186
        L_0x0185:
            r0 = 0
        L_0x0186:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkArgument(r0)
            r43.readInt()
            int r15 = r15 + -1
            goto L_0x017b
        L_0x018f:
            if (r6 != 0) goto L_0x0197
            if (r9 != 0) goto L_0x0197
            if (r7 != 0) goto L_0x0197
            if (r8 == 0) goto L_0x01cd
        L_0x0197:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Inconsistent stbl box for track "
            r0.append(r1)
            int r1 = r5.id
            r0.append(r1)
            java.lang.String r1 = ": remainingSynchronizationSamples "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", remainingSamplesInChunk "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r11, r0)
        L_0x01cd:
            r6 = r16
            r0 = r21
            r2 = r23
            r3 = r25
            r21 = r27
        L_0x01d7:
            r4 = r10
            goto L_0x0216
        L_0x01d9:
            r31 = r2
            r20 = 1
            int r0 = r13.length
            long[] r1 = new long[r0]
            int[] r0 = new int[r0]
        L_0x01e3:
            boolean r2 = r13.moveNext()
            if (r2 == 0) goto L_0x01f4
            int r2 = r13.index
            long r3 = r13.offset
            r1[r2] = r3
            int r3 = r13.numSamples
            r0[r2] = r3
            goto L_0x01e3
        L_0x01f4:
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r5.format
            int r3 = r2.pcmEncoding
            int r2 = r2.channelCount
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmFrameSize(r3, r2)
            long r3 = (long) r14
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r2, r1, r0, r3)
            long[] r4 = r0.offsets
            int[] r7 = r0.sizes
            int r10 = r0.maximumSize
            long[] r1 = r0.timestamps
            int[] r2 = r0.flags
            long r8 = r0.duration
            r0 = r1
            r6 = r2
            r2 = r4
            r3 = r7
            r21 = r8
            goto L_0x01d7
        L_0x0216:
            long r7 = r5.timescale
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r25 = r7
            long r7 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long[] r1 = r5.editListDurations
            if (r1 == 0) goto L_0x022b
            boolean r1 = r44.hasGaplessInfo()
            if (r1 == 0) goto L_0x0235
        L_0x022b:
            r30 = r2
            r31 = r3
            r21 = r4
            r1 = r5
            r5 = r0
            goto L_0x044b
        L_0x0235:
            long[] r1 = r5.editListDurations
            int r12 = r1.length
            r13 = 1
            if (r12 != r13) goto L_0x02be
            int r12 = r5.type
            if (r12 != r13) goto L_0x02be
            int r12 = r0.length
            r13 = 2
            if (r12 < r13) goto L_0x02be
            long[] r12 = r5.editListMediaTimes
            r24 = r12[r17]
            r32 = r1[r17]
            long r12 = r5.timescale
            long r14 = r5.movieTimescale
            r34 = r12
            r36 = r14
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            long r26 = r24 + r12
            r22 = r21
            r21 = r0
            boolean r0 = canApplyEditWithGaplessInfo(r21, r22, r24, r26)
            r1 = r21
            r21 = r22
            if (r0 == 0) goto L_0x0292
            long r32 = r21 - r26
            r12 = r1[r17]
            long r34 = r24 - r12
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r5.format
            int r0 = r0.sampleRate
            long r12 = (long) r0
            long r14 = r5.timescale
            r36 = r12
            r38 = r14
            long r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r34, r36, r38)
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r5.format
            int r0 = r0.sampleRate
            long r14 = (long) r0
            long r9 = r5.timescale
            r36 = r9
            r34 = r14
            long r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            int r0 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x0298
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0292
            goto L_0x0298
        L_0x0292:
            r40 = r5
            r5 = r1
            r1 = r40
            goto L_0x02c0
        L_0x0298:
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0292
            int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0292
            int r0 = (int) r12
            r11 = r44
            r11.encoderDelay = r0
            int r0 = (int) r9
            r11.encoderPadding = r0
            long r9 = r5.timescale
            r11 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r1, r11, r9)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r40 = r5
            r5 = r1
            r1 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x02be:
            r1 = r5
            r5 = r0
        L_0x02c0:
            long[] r0 = r1.editListDurations
            int r7 = r0.length
            r13 = 1
            if (r7 != r13) goto L_0x02f8
            r7 = r0[r17]
            int r0 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x02f8
            long[] r0 = r1.editListMediaTimes
            r7 = r0[r17]
            r0 = 0
        L_0x02d1:
            int r9 = r5.length
            if (r0 >= r9) goto L_0x02e7
            r9 = r5[r0]
            long r11 = r9 - r7
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r1.timescale
            r15 = r9
            long r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x02d1
        L_0x02e7:
            long r9 = r21 - r7
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r1.timescale
            long r7 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r9, r11, r13)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x02f8:
            int r0 = r1.type
            r13 = 1
            if (r0 != r13) goto L_0x02ff
            r13 = 1
            goto L_0x0300
        L_0x02ff:
            r13 = 0
        L_0x0300:
            r0 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0304:
            long[] r10 = r1.editListDurations
            int r12 = r10.length
            if (r0 >= r12) goto L_0x0349
            long[] r12 = r1.editListMediaTimes
            r43 = -1
            r14 = r12[r0]
            int r12 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            if (r12 == 0) goto L_0x033c
            r21 = r10[r0]
            r12 = r11
            long r10 = r1.timescale
            r23 = r10
            long r10 = r1.movieTimescale
            r25 = r10
            long r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r16 = r0
            r21 = r4
            r0 = 1
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r0, (boolean) r0)
            long r14 = r14 + r10
            r0 = 0
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r13, (boolean) r0)
            int r0 = r10 - r4
            int r8 = r8 + r0
            if (r9 == r4) goto L_0x0338
            r0 = 1
            goto L_0x0339
        L_0x0338:
            r0 = 0
        L_0x0339:
            r7 = r7 | r0
            r9 = r10
            goto L_0x0341
        L_0x033c:
            r16 = r0
            r21 = r4
            r12 = r11
        L_0x0341:
            int r0 = r16 + 1
            r11 = r12
            r4 = r21
            r17 = 0
            goto L_0x0304
        L_0x0349:
            r21 = r4
            r12 = r11
            r0 = r31
            r43 = -1
            if (r8 == r0) goto L_0x0354
            r0 = 1
            goto L_0x0355
        L_0x0354:
            r0 = 0
        L_0x0355:
            r0 = r0 | r7
            if (r0 == 0) goto L_0x035b
            long[] r4 = new long[r8]
            goto L_0x035c
        L_0x035b:
            r4 = r2
        L_0x035c:
            if (r0 == 0) goto L_0x0361
            int[] r7 = new int[r8]
            goto L_0x0362
        L_0x0361:
            r7 = r3
        L_0x0362:
            if (r0 == 0) goto L_0x0366
            r21 = 0
        L_0x0366:
            if (r0 == 0) goto L_0x036b
            int[] r9 = new int[r8]
            goto L_0x036c
        L_0x036b:
            r9 = r6
        L_0x036c:
            long[] r8 = new long[r8]
            r14 = r21
            r10 = 0
            r11 = 0
            r21 = r18
        L_0x0374:
            long[] r15 = r1.editListDurations
            r16 = r0
            int r0 = r15.length
            if (r10 >= r0) goto L_0x042a
            long[] r0 = r1.editListMediaTimes
            r18 = r14
            r19 = r15
            r14 = r0[r10]
            r23 = r19[r10]
            int r0 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            r19 = r8
            if (r0 == 0) goto L_0x0411
            r0 = r9
            long r8 = r1.timescale
            r25 = r8
            long r8 = r1.movieTimescale
            r27 = r8
            long r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r23, r25, r27)
            r27 = r23
            long r8 = r8 + r14
            r23 = r0
            r20 = r10
            r0 = 1
            int r10 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r0, (boolean) r0)
            r0 = 0
            r29 = 1
            int r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r8, (boolean) r13, (boolean) r0)
            if (r16 == 0) goto L_0x03bb
            int r9 = r8 - r10
            java.lang.System.arraycopy(r2, r10, r4, r11, r9)
            java.lang.System.arraycopy(r3, r10, r7, r11, r9)
            r0 = r23
            java.lang.System.arraycopy(r6, r10, r0, r11, r9)
            goto L_0x03bd
        L_0x03bb:
            r0 = r23
        L_0x03bd:
            if (r10 >= r8) goto L_0x03d1
            r9 = r0[r11]
            r9 = r9 & 1
            if (r9 == 0) goto L_0x03c6
            goto L_0x03d1
        L_0x03c6:
            java.lang.String r0 = "Ignoring edit list: edit does not start with a sync sample."
            android.util.Log.w(r12, r0)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers$UnhandledEditListException
            r0.<init>()
            throw r0
        L_0x03d1:
            r9 = r18
        L_0x03d3:
            if (r10 >= r8) goto L_0x040b
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r2
            r31 = r3
            long r2 = r1.movieTimescale
            r25 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r23 = r5[r10]
            long r32 = r23 - r14
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r2
            long r2 = r1.timescale
            r36 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r32, r34, r36)
            long r2 = r23 + r2
            r19[r11] = r2
            if (r16 == 0) goto L_0x0402
            r2 = r7[r11]
            if (r2 <= r9) goto L_0x0402
            r2 = r31[r10]
            r9 = r2
        L_0x0402:
            int r11 = r11 + 1
            int r10 = r10 + 1
            r2 = r30
            r3 = r31
            goto L_0x03d3
        L_0x040b:
            r14 = r9
        L_0x040c:
            r30 = r2
            r31 = r3
            goto L_0x041b
        L_0x0411:
            r0 = r9
            r20 = r10
            r27 = r23
            r29 = 1
            r14 = r18
            goto L_0x040c
        L_0x041b:
            long r21 = r21 + r27
            int r10 = r20 + 1
            r9 = r0
            r0 = r16
            r8 = r19
            r2 = r30
            r3 = r31
            goto L_0x0374
        L_0x042a:
            r19 = r8
            r0 = r9
            r18 = r14
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r1.timescale
            r25 = r2
            long r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r6 = r0
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r40 = r2
            r3 = r7
            r7 = r40
            r2 = r4
            r4 = r18
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x044b:
            long r2 = r1.timescale
            r11 = 1000000(0xf4240, double:4.940656E-318)
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r11, r2)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable r0 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable
            r4 = r21
            r2 = r30
            r3 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x045f:
            com.mbridge.msdk.playercommon.exoplayer2.ParserException r0 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track, com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder):com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i4, int i5, String str, DrmInitData drmInitData, boolean z4) throws ParserException {
        boolean z5;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        int i6 = 0;
        while (i6 < readInt) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Assertions.checkArgument(z5, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09) {
                StsdData stsdData2 = stsdData;
                int i7 = i6;
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i4, i5, drmInitData, stsdData2, i7);
                stsdData = stsdData2;
                i6 = i7;
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i4, str, z4, drmInitData, stsdData3, i6);
                stsdData = stsdData3;
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i4, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i4), MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, (DrmInitData) null);
            }
            parsableByteArray.setPosition(position + readInt2);
            i6++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i4, int i5, int i6, int i7, String str, StsdData stsdData) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i8 = i4;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i5 + 16);
        int i9 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List list = null;
        long j4 = Long.MAX_VALUE;
        if (i8 != i9) {
            if (i8 == Atom.TYPE_tx3g) {
                int i10 = i6 - 16;
                byte[] bArr = new byte[i10];
                parsableByteArray2.readBytes(bArr, 0, i10);
                list = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i8 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i8 == Atom.TYPE_stpp) {
                j4 = 0;
            } else if (i8 == Atom.TYPE_c608) {
                stsdData2.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData2.format = Format.createTextSampleFormat(Integer.toString(i7), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j4, list);
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        int i4;
        long j4;
        long j5;
        int i5 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i4 = 8;
        } else {
            i4 = 16;
        }
        parsableByteArray.skipBytes(i4);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i5 = 4;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            j4 = C.TIME_UNSET;
            if (i7 >= i5) {
                parsableByteArray.skipBytes(i5);
                break;
            } else if (parsableByteArray.data[position + i7] != -1) {
                if (parseFullAtomVersion == 0) {
                    j5 = parsableByteArray.readUnsignedInt();
                } else {
                    j5 = parsableByteArray.readUnsignedLongToLong();
                }
                if (j5 != 0) {
                    j4 = j5;
                }
            } else {
                i7++;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i6 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i6 = SubsamplingScaleImageView.ORIENTATION_270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i6 = SubsamplingScaleImageView.ORIENTATION_180;
        }
        return new TkhdData(readInt, j4, i6);
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j4, DrmInitData drmInitData, boolean z4, boolean z5) throws ParserException {
        long j5;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j6 = C.TIME_UNSET;
        if (j4 == C.TIME_UNSET) {
            j5 = parseTkhd.duration;
        } else {
            j5 = j4;
        }
        long parseMvhd = parseMvhd(leafAtom.data);
        if (j5 != C.TIME_UNSET) {
            j6 = Util.scaleLargeTimestamp(j5, 1000000, parseMvhd);
        }
        long j7 = j6;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z5);
        if (!z4) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom2.getContainerAtomOfType(Atom.TYPE_edts));
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j7, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z4) {
        if (z4) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i4, int i5, int i6, int i7, int i8, DrmInitData drmInitData, StsdData stsdData, int i9) throws ParserException {
        boolean z4;
        String str;
        List<byte[]> list;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i10 = i5;
        int i11 = i6;
        DrmInitData drmInitData2 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i10 + 16);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray2.getPosition();
        String str2 = null;
        int i12 = i4;
        if (i12 == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i10, i11);
            if (parseSampleEntryEncryptionData != null) {
                i12 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i9] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitData2;
        List<byte[]> list2 = null;
        byte[] bArr = null;
        boolean z5 = false;
        float f4 = 1.0f;
        int i13 = -1;
        while (position - i10 < i11) {
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray2.getPosition();
            int readInt = parsableByteArray2.readInt();
            if (readInt == 0 && parsableByteArray2.getPosition() - i10 == i11) {
                break;
            }
            boolean z6 = true;
            if (readInt > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4, "childAtomSize should be positive");
            int readInt2 = parsableByteArray2.readInt();
            if (readInt2 == Atom.TYPE_avcC) {
                if (str2 != null) {
                    z6 = false;
                }
                Assertions.checkState(z6);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray2);
                list = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z5) {
                    f4 = parse.pixelWidthAspectRatio;
                }
                str = MimeTypes.VIDEO_H264;
            } else if (readInt2 == Atom.TYPE_hvcC) {
                if (str2 != null) {
                    z6 = false;
                }
                Assertions.checkState(z6);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray2);
                list = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = MimeTypes.VIDEO_H265;
            } else {
                if (readInt2 == Atom.TYPE_vpcC) {
                    if (str2 != null) {
                        z6 = false;
                    }
                    Assertions.checkState(z6);
                    if (i12 == Atom.TYPE_vp08) {
                        str = MimeTypes.VIDEO_VP8;
                    } else {
                        str = MimeTypes.VIDEO_VP9;
                    }
                } else if (readInt2 == Atom.TYPE_d263) {
                    if (str2 != null) {
                        z6 = false;
                    }
                    Assertions.checkState(z6);
                    str = MimeTypes.VIDEO_H263;
                } else {
                    if (readInt2 == Atom.TYPE_esds) {
                        if (str2 != null) {
                            z6 = false;
                        }
                        Assertions.checkState(z6);
                        Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                        str2 = (String) parseEsdsFromParent.first;
                        list2 = Collections.singletonList(parseEsdsFromParent.second);
                    } else if (readInt2 == Atom.TYPE_pasp) {
                        f4 = parsePaspFromParent(parsableByteArray2, position2);
                        z5 = true;
                    } else if (readInt2 == Atom.TYPE_sv3d) {
                        bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
                    } else if (readInt2 == Atom.TYPE_st3d) {
                        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                        parsableByteArray2.skipBytes(3);
                        if (readUnsignedByte == 0) {
                            int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                            if (readUnsignedByte2 == 0) {
                                i13 = 0;
                            } else if (readUnsignedByte2 == 1) {
                                i13 = 1;
                            } else if (readUnsignedByte2 == 2) {
                                i13 = 2;
                            } else if (readUnsignedByte2 == 3) {
                                i13 = 3;
                            }
                        }
                    }
                    position += readInt;
                }
                str2 = str;
                position += readInt;
            }
            list2 = list;
            str2 = str;
            position += readInt;
        }
        if (str2 != null) {
            stsdData2.format = Format.createVideoSampleFormat(Integer.toString(i7), str2, (String) null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list2, i8, f4, bArr, i13, (ColorInfo) null, drmInitData3);
        }
    }
}
