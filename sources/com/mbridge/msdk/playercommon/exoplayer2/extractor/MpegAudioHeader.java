package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public final class MpegAudioHeader {
    private static final int[] BITRATE_V1_L1 = {32, 64, 96, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 288, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, 448};
    private static final int[] BITRATE_V1_L2 = {32, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384};
    private static final int[] BITRATE_V1_L3 = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320};
    private static final int[] BITRATE_V2 = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    private static final int[] BITRATE_V2_L1 = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, PsExtractor.AUDIO_STREAM, 224, 256};
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    private static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public static int getFrameSize(int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if ((i4 & -2097152) != -2097152 || (i5 = (i4 >>> 19) & 3) == 1 || (i6 = (i4 >>> 17) & 3) == 0 || (i7 = (i4 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i4 >>> 10) & 3) == 3) {
            return -1;
        }
        int i11 = SAMPLING_RATE_V1[i8];
        if (i5 == 2) {
            i11 /= 2;
        } else if (i5 == 0) {
            i11 /= 4;
        }
        int i12 = (i4 >>> 9) & 1;
        if (i6 == 3) {
            if (i5 == 3) {
                i10 = BITRATE_V1_L1[i7 - 1];
            } else {
                i10 = BITRATE_V2_L1[i7 - 1];
            }
            return (((i10 * 12000) / i11) + i12) * 4;
        }
        if (i5 != 3) {
            i9 = BITRATE_V2[i7 - 1];
        } else if (i6 == 2) {
            i9 = BITRATE_V1_L2[i7 - 1];
        } else {
            i9 = BITRATE_V1_L3[i7 - 1];
        }
        int i13 = 144000;
        if (i5 == 3) {
            return ((i9 * 144000) / i11) + i12;
        }
        if (i6 == 1) {
            i13 = DefaultOggSeeker.MATCH_RANGE;
        }
        return ((i13 * i9) / i11) + i12;
    }

    public static boolean populateHeader(int i4, MpegAudioHeader mpegAudioHeader) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i4 & -2097152) != -2097152 || (i5 = (i4 >>> 19) & 3) == 1 || (i6 = (i4 >>> 17) & 3) == 0 || (i7 = (i4 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i4 >>> 10) & 3) == 3) {
            return false;
        }
        int i14 = SAMPLING_RATE_V1[i8];
        int i15 = 2;
        if (i5 == 2) {
            i14 /= 2;
        } else if (i5 == 0) {
            i14 /= 4;
        }
        int i16 = i14;
        int i17 = (i4 >>> 9) & 1;
        if (i6 == 3) {
            if (i5 == 3) {
                i11 = BITRATE_V1_L1[i7 - 1];
            } else {
                i11 = BITRATE_V2_L1[i7 - 1];
            }
            i10 = (((i11 * 12000) / i16) + i17) * 4;
            i9 = 384;
        } else {
            int i18 = 1152;
            if (i5 != 3) {
                i13 = BITRATE_V2[i7 - 1];
                if (i6 == 1) {
                    i18 = 576;
                }
                if (i6 == 1) {
                    i12 = DefaultOggSeeker.MATCH_RANGE;
                    i9 = i18;
                    i10 = i17 + ((i12 * i11) / i16);
                }
            } else if (i6 == 2) {
                i13 = BITRATE_V1_L2[i7 - 1];
            } else {
                i13 = BITRATE_V1_L3[i7 - 1];
            }
            i12 = 144000;
            i9 = i18;
            i10 = i17 + ((i12 * i11) / i16);
        }
        String str = MIME_TYPE_BY_LAYER[3 - i6];
        if (((i4 >> 6) & 3) == 3) {
            i15 = 1;
        }
        int i19 = i10;
        int i20 = i15;
        int i21 = i19;
        mpegAudioHeader.setValues(i5, str, i21, i16, i20, i11 * 1000, i9);
        return true;
    }

    private void setValues(int i4, String str, int i5, int i6, int i7, int i8, int i9) {
        this.version = i4;
        this.mimeType = str;
        this.frameSize = i5;
        this.sampleRate = i6;
        this.channels = i7;
        this.bitrate = i8;
        this.samplesPerFrame = i9;
    }
}
