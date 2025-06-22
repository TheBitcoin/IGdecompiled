package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import java.util.ArrayList;

public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};

    private CodecSpecificDataUtil() {
    }

    public static byte[] buildAacAudioSpecificConfig(int i4, int i5, int i6) {
        return new byte[]{(byte) (((i4 << 3) & 248) | ((i5 >> 1) & 7)), (byte) (((i5 << 7) & 128) | ((i6 << 3) & 120))};
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i7 >= iArr.length) {
                break;
            }
            if (i4 == iArr[i7]) {
                i8 = i7;
            }
            i7++;
        }
        int i9 = -1;
        while (true) {
            int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if (i6 >= iArr2.length) {
                break;
            }
            if (i5 == iArr2[i6]) {
                i9 = i6;
            }
            i6++;
        }
        if (i4 != -1 && i9 != -1) {
            return buildAacAudioSpecificConfig(2, i8, i9);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i4 + ", " + i5);
    }

    public static byte[] buildNalUnit(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[(bArr2.length + i5)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i4, bArr3, bArr2.length, i5);
        return bArr3;
    }

    private static int findNalStartCode(byte[] bArr, int i4) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i4 <= length) {
            if (isNalStartCode(bArr, i4)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(5);
        if (readBits == 31) {
            return parsableBitArray.readBits(6) + 32;
        }
        return readBits;
    }

    private static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        boolean z4;
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        if (readBits < 13) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[readBits];
    }

    private static boolean isNalStartCode(byte[] bArr, int i4) {
        if (bArr.length - i4 <= NAL_START_CODE.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i4 + i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        return parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    private static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int i4, int i5) {
        parsableBitArray.skipBits(1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean readBit = parsableBitArray.readBit();
        if (i5 != 0) {
            if (i4 == 6 || i4 == 20) {
                parsableBitArray.skipBits(3);
            }
            if (readBit) {
                if (i4 == 22) {
                    parsableBitArray.skipBits(16);
                }
                if (i4 == 17 || i4 == 19 || i4 == 20 || i4 == 23) {
                    parsableBitArray.skipBits(3);
                }
                parsableBitArray.skipBits(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        int i4;
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        do {
            arrayList.add(Integer.valueOf(i5));
            i5 = findNalStartCode(bArr, i5 + NAL_START_CODE.length);
        } while (i5 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            int intValue = ((Integer) arrayList.get(i6)).intValue();
            if (i6 < arrayList.size() - 1) {
                i4 = ((Integer) arrayList.get(i6 + 1)).intValue();
            } else {
                i4 = bArr.length;
            }
            int i7 = i4 - intValue;
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr, intValue, bArr3, 0, i7);
            bArr2[i6] = bArr3;
        }
        return bArr2;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z4) throws ParserException {
        int aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
        int aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
        int readBits = parsableBitArray.readBits(4);
        if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
            aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
            aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
            if (aacAudioObjectType == 22) {
                readBits = parsableBitArray.readBits(4);
            }
        }
        boolean z5 = true;
        if (z4) {
            if (!(aacAudioObjectType == 1 || aacAudioObjectType == 2 || aacAudioObjectType == 3 || aacAudioObjectType == 4 || aacAudioObjectType == 6 || aacAudioObjectType == 7 || aacAudioObjectType == 17)) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                }
            }
            parseGaSpecificConfig(parsableBitArray, aacAudioObjectType, readBits);
            switch (aacAudioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int readBits2 = parsableBitArray.readBits(2);
                    if (readBits2 == 2 || readBits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + readBits2);
                    }
            }
        }
        int i4 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[readBits];
        if (i4 == -1) {
            z5 = false;
        }
        Assertions.checkArgument(z5);
        return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i4));
    }
}
