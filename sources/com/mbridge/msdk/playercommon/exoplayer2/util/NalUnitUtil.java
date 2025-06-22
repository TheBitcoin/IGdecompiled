package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i4, int i5, boolean z4) {
            this.picParameterSetId = i4;
            this.seqParameterSetId = i5;
            this.bottomFieldPicOrderInFramePresentFlag = z4;
        }
    }

    public static final class SpsData {
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i4, int i5, int i6, float f4, boolean z4, boolean z5, int i7, int i8, int i9, boolean z6) {
            this.seqParameterSetId = i4;
            this.width = i5;
            this.height = i6;
            this.pixelWidthAspectRatio = f4;
            this.separateColorPlaneFlag = z4;
            this.frameMbsOnlyFlag = z5;
            this.frameNumLength = i7;
            this.picOrderCountType = i8;
            this.picOrderCntLsbLength = i9;
            this.deltaPicOrderAlwaysZeroFlag = z6;
        }
    }

    private NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 1;
            if (i6 < position) {
                byte b5 = byteBuffer.get(i4) & 255;
                if (i5 == 3) {
                    if (b5 == 1 && (byteBuffer.get(i6) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i4 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b5 == 0) {
                    i5++;
                }
                if (b5 != 0) {
                    i5 = 0;
                }
                i4 = i6;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int findNalUnit(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            int r0 = r10 - r9
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r3)
            if (r0 != 0) goto L_0x0010
            goto L_0x00bc
        L_0x0010:
            r3 = 2
            if (r11 == 0) goto L_0x0041
            boolean r4 = r11[r1]
            if (r4 == 0) goto L_0x001d
            clearPrefixFlags(r11)
            int r9 = r9 + -3
            return r9
        L_0x001d:
            if (r0 <= r2) goto L_0x002c
            boolean r4 = r11[r2]
            if (r4 == 0) goto L_0x002c
            byte r4 = r8[r9]
            if (r4 != r2) goto L_0x002c
            clearPrefixFlags(r11)
            int r9 = r9 - r3
            return r9
        L_0x002c:
            if (r0 <= r3) goto L_0x0041
            boolean r4 = r11[r3]
            if (r4 == 0) goto L_0x0041
            byte r4 = r8[r9]
            if (r4 != 0) goto L_0x0041
            int r4 = r9 + 1
            byte r4 = r8[r4]
            if (r4 != r2) goto L_0x0041
            clearPrefixFlags(r11)
            int r9 = r9 - r2
            return r9
        L_0x0041:
            int r4 = r10 + -1
            int r9 = r9 + r3
        L_0x0044:
            if (r9 >= r4) goto L_0x0066
            byte r5 = r8[r9]
            r6 = r5 & 254(0xfe, float:3.56E-43)
            if (r6 == 0) goto L_0x004d
            goto L_0x0063
        L_0x004d:
            int r6 = r9 + -2
            byte r7 = r8[r6]
            if (r7 != 0) goto L_0x0061
            int r7 = r9 + -1
            byte r7 = r8[r7]
            if (r7 != 0) goto L_0x0061
            if (r5 != r2) goto L_0x0061
            if (r11 == 0) goto L_0x0060
            clearPrefixFlags(r11)
        L_0x0060:
            return r6
        L_0x0061:
            int r9 = r9 + -2
        L_0x0063:
            int r9 = r9 + 3
            goto L_0x0044
        L_0x0066:
            if (r11 == 0) goto L_0x00bc
            if (r0 <= r3) goto L_0x007e
            int r9 = r10 + -3
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007c
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007c
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007c
        L_0x007a:
            r9 = 1
            goto L_0x0098
        L_0x007c:
            r9 = 0
            goto L_0x0098
        L_0x007e:
            if (r0 != r3) goto L_0x008f
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x007c
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007c
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007c
            goto L_0x007a
        L_0x008f:
            boolean r9 = r11[r2]
            if (r9 == 0) goto L_0x007c
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007c
            goto L_0x007a
        L_0x0098:
            r11[r1] = r9
            if (r0 <= r2) goto L_0x00aa
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x00a8
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00a8
        L_0x00a6:
            r9 = 1
            goto L_0x00b3
        L_0x00a8:
            r9 = 0
            goto L_0x00b3
        L_0x00aa:
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x00a8
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00a8
            goto L_0x00a6
        L_0x00b3:
            r11[r2] = r9
            byte r8 = r8[r4]
            if (r8 != 0) goto L_0x00ba
            r1 = 1
        L_0x00ba:
            r11[r3] = r1
        L_0x00bc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.findNalUnit(byte[], int, int, boolean[]):int");
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i4, int i5) {
        while (i4 < i5 - 2) {
            if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static int getH265NalUnitType(byte[] bArr, int i4) {
        return (bArr[i4 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i4) {
        return bArr[i4 + 3] & 31;
    }

    public static boolean isNalUnitSei(String str, byte b5) {
        if ((!MimeTypes.VIDEO_H264.equals(str) || (b5 & 31) != 6) && (!MimeTypes.VIDEO_H265.equals(str) || ((b5 & 126) >> 1) != 39)) {
            return false;
        }
        return true;
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i4, int i5) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i4, i5);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r19, int r20, int r21) {
        /*
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r19
            r2 = r20
            r3 = r21
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.skipBits(r1)
            int r2 = r0.readBits(r1)
            r3 = 16
            r0.skipBits(r3)
            int r5 = r0.readUnsignedExpGolombCodedInt()
            r4 = 100
            r6 = 3
            r7 = 1
            if (r2 == r4) goto L_0x004b
            r4 = 110(0x6e, float:1.54E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 122(0x7a, float:1.71E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 244(0xf4, float:3.42E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 44
            if (r2 == r4) goto L_0x004b
            r4 = 83
            if (r2 == r4) goto L_0x004b
            r4 = 86
            if (r2 == r4) goto L_0x004b
            r4 = 118(0x76, float:1.65E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 128(0x80, float:1.794E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 138(0x8a, float:1.93E-43)
            if (r2 != r4) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r2 = 1
            r9 = 0
            goto L_0x0085
        L_0x004b:
            int r2 = r0.readUnsignedExpGolombCodedInt()
            if (r2 != r6) goto L_0x0056
            boolean r4 = r0.readBit()
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            boolean r9 = r0.readBit()
            if (r9 == 0) goto L_0x0084
            if (r2 == r6) goto L_0x006b
            r9 = 8
            goto L_0x006d
        L_0x006b:
            r9 = 12
        L_0x006d:
            r10 = 0
        L_0x006e:
            if (r10 >= r9) goto L_0x0084
            boolean r11 = r0.readBit()
            if (r11 == 0) goto L_0x0081
            r11 = 6
            if (r10 >= r11) goto L_0x007c
            r11 = 16
            goto L_0x007e
        L_0x007c:
            r11 = 64
        L_0x007e:
            skipScalingList(r0, r11)
        L_0x0081:
            int r10 = r10 + 1
            goto L_0x006e
        L_0x0084:
            r9 = r4
        L_0x0085:
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r11 = r4 + 4
            int r12 = r0.readUnsignedExpGolombCodedInt()
            if (r12 != 0) goto L_0x009c
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r4 = r4 + 4
            r13 = r4
            r20 = r9
        L_0x009a:
            r14 = 0
            goto L_0x00c2
        L_0x009c:
            if (r12 != r7) goto L_0x00be
            boolean r4 = r0.readBit()
            r0.readSignedExpGolombCodedInt()
            r0.readSignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            long r13 = (long) r10
            r20 = r9
            r10 = 0
        L_0x00b0:
            long r8 = (long) r10
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00bb
            r0.readUnsignedExpGolombCodedInt()
            int r10 = r10 + 1
            goto L_0x00b0
        L_0x00bb:
            r14 = r4
            r13 = 0
            goto L_0x00c2
        L_0x00be:
            r20 = r9
            r13 = 0
            goto L_0x009a
        L_0x00c2:
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r4 = r4 + r7
            int r8 = r0.readUnsignedExpGolombCodedInt()
            int r8 = r8 + r7
            boolean r10 = r0.readBit()
            int r9 = 2 - r10
            int r9 = r9 * r8
            if (r10 != 0) goto L_0x00df
            r0.skipBit()
        L_0x00df:
            r0.skipBit()
            int r4 = r4 * 16
            int r9 = r9 * 16
            boolean r8 = r0.readBit()
            if (r8 == 0) goto L_0x011a
            int r8 = r0.readUnsignedExpGolombCodedInt()
            int r15 = r0.readUnsignedExpGolombCodedInt()
            int r16 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            if (r2 != 0) goto L_0x0101
            int r2 = 2 - r10
            goto L_0x0110
        L_0x0101:
            r18 = 2
            if (r2 != r6) goto L_0x0107
            r6 = 1
            goto L_0x0108
        L_0x0107:
            r6 = 2
        L_0x0108:
            if (r2 != r7) goto L_0x010b
            r7 = 2
        L_0x010b:
            int r2 = 2 - r10
            int r2 = r2 * r7
            r7 = r6
        L_0x0110:
            int r8 = r8 + r15
            int r8 = r8 * r7
            int r4 = r4 - r8
            int r16 = r16 + r17
            int r16 = r16 * r2
            int r9 = r9 - r16
        L_0x011a:
            r6 = r4
            r7 = r9
            boolean r2 = r0.readBit()
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0162
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x0162
            int r1 = r0.readBits(r1)
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L_0x0144
            int r1 = r0.readBits(r3)
            int r0 = r0.readBits(r3)
            if (r1 == 0) goto L_0x0142
            if (r0 == 0) goto L_0x0142
            float r1 = (float) r1
            float r0 = (float) r0
            float r4 = r1 / r0
        L_0x0142:
            r8 = r4
            goto L_0x0164
        L_0x0144:
            float[] r0 = ASPECT_RATIO_IDC_VALUES
            int r2 = r0.length
            if (r1 >= r2) goto L_0x014c
            r4 = r0[r1]
            goto L_0x0142
        L_0x014c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NalUnitUtil"
            android.util.Log.w(r1, r0)
        L_0x0162:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0164:
            com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData r4 = new com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData
            r9 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData");
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i4) {
        int i5 = 8;
        int i6 = 8;
        for (int i7 = 0; i7 < i4; i7++) {
            if (i5 != 0) {
                i5 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i6) + 256) % 256;
            }
            if (i5 != 0) {
                i6 = i5;
            }
        }
    }

    public static int unescapeStream(byte[] bArr, int i4) {
        int i5;
        synchronized (scratchEscapePositionsLock) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                try {
                    i6 = findNextUnescapeIndex(bArr, i6, i4);
                    if (i6 < i4) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i7) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i7] = i6;
                        i6 += 3;
                        i7++;
                    }
                } finally {
                }
            }
            i5 = i4 - i7;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i7; i10++) {
                int i11 = scratchEscapePositions[i10] - i9;
                System.arraycopy(bArr, i9, bArr, i8, i11);
                int i12 = i8 + i11;
                int i13 = i12 + 1;
                bArr[i12] = 0;
                i8 = i12 + 2;
                bArr[i13] = 0;
                i9 += i11 + 3;
            }
            System.arraycopy(bArr, i9, bArr, i8, i5 - i8);
        }
        return i5;
    }
}
