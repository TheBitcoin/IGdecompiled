package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i4, int i5, long[] jArr, int i6, boolean z4) {
            this.dimensions = i4;
            this.entries = i5;
            this.lengthMap = jArr;
            this.lookupType = i6;
            this.isOrdered = z4;
        }
    }

    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i4) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i4;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z4, int i4, int i5, int i6) {
            this.blockFlag = z4;
            this.windowType = i4;
            this.transformType = i5;
            this.mapping = i6;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j4, int i4, long j5, int i5, int i6, int i7, int i8, int i9, boolean z4, byte[] bArr) {
            this.version = j4;
            this.channels = i4;
            this.sampleRate = j5;
            this.bitrateMax = i5;
            this.bitrateNominal = i6;
            this.bitrateMin = i7;
            this.blockSize0 = i8;
            this.blockSize1 = i9;
            this.framingFlag = z4;
            this.data = bArr;
        }

        public final int getApproximateBitrate() {
            int i4 = this.bitrateNominal;
            if (i4 == 0) {
                return (this.bitrateMin + this.bitrateMax) / 2;
            }
            return i4;
        }
    }

    private VorbisUtil() {
    }

    public static int iLog(int i4) {
        int i5 = 0;
        while (i4 > 0) {
            i5++;
            i4 >>>= 1;
        }
        return i5;
    }

    private static long mapType1QuantValues(long j4, long j5) {
        return (long) Math.floor(Math.pow((double) j4, 1.0d / ((double) j5)));
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) == 5653314) {
            int readBits = vorbisBitArray.readBits(16);
            int readBits2 = vorbisBitArray.readBits(24);
            long[] jArr = new long[readBits2];
            boolean readBit = vorbisBitArray.readBit();
            long j4 = 0;
            if (!readBit) {
                boolean readBit2 = vorbisBitArray.readBit();
                for (int i4 = 0; i4 < readBits2; i4++) {
                    if (!readBit2 || vorbisBitArray.readBit()) {
                        jArr[i4] = (long) (vorbisBitArray.readBits(5) + 1);
                    } else {
                        jArr[i4] = 0;
                    }
                }
            } else {
                int readBits3 = vorbisBitArray.readBits(5) + 1;
                int i5 = 0;
                while (i5 < readBits2) {
                    int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i5));
                    for (int i6 = 0; i6 < readBits4 && i5 < readBits2; i6++) {
                        jArr[i5] = (long) readBits3;
                        i5++;
                    }
                    readBits3++;
                }
            }
            int readBits5 = vorbisBitArray.readBits(4);
            if (readBits5 <= 2) {
                if (readBits5 == 1 || readBits5 == 2) {
                    vorbisBitArray.skipBits(32);
                    vorbisBitArray.skipBits(32);
                    int readBits6 = vorbisBitArray.readBits(4) + 1;
                    vorbisBitArray.skipBits(1);
                    if (readBits5 != 1) {
                        j4 = ((long) readBits2) * ((long) readBits);
                    } else if (readBits != 0) {
                        j4 = mapType1QuantValues((long) readBits2, (long) readBits);
                    }
                    vorbisBitArray.skipBits((int) (j4 * ((long) readBits6)));
                }
                return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
            }
            throw new ParserException("lookup type greater than 2 not decodable: " + readBits5);
        }
        throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition());
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i4 = 0; i4 < readBits; i4++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits3 = vorbisBitArray.readBits(4) + 1;
                for (int i5 = 0; i5 < readBits3; i5++) {
                    vorbisBitArray.skipBits(8);
                }
            } else if (readBits2 == 1) {
                int readBits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[readBits4];
                int i6 = -1;
                for (int i7 = 0; i7 < readBits4; i7++) {
                    int readBits5 = vorbisBitArray.readBits(4);
                    iArr[i7] = readBits5;
                    if (readBits5 > i6) {
                        i6 = readBits5;
                    }
                }
                int i8 = i6 + 1;
                int[] iArr2 = new int[i8];
                for (int i9 = 0; i9 < i8; i9++) {
                    iArr2[i9] = vorbisBitArray.readBits(3) + 1;
                    int readBits6 = vorbisBitArray.readBits(2);
                    if (readBits6 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i10 = 0; i10 < (1 << readBits6); i10++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int readBits7 = vorbisBitArray.readBits(4);
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < readBits4; i13++) {
                    i11 += iArr2[iArr[i13]];
                    while (i12 < i11) {
                        vorbisBitArray.skipBits(readBits7);
                        i12++;
                    }
                }
            } else {
                throw new ParserException("floor type greater than 1 not decodable: " + readBits2);
            }
        }
    }

    private static void readMappings(int i4, VorbisBitArray vorbisBitArray) throws ParserException {
        int i5;
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i6 = 0; i6 < readBits; i6++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                Log.e(TAG, "mapping type other than 0 not supported: " + readBits2);
            } else {
                if (vorbisBitArray.readBit()) {
                    i5 = vorbisBitArray.readBits(4) + 1;
                } else {
                    i5 = 1;
                }
                if (vorbisBitArray.readBit()) {
                    int readBits3 = vorbisBitArray.readBits(8) + 1;
                    for (int i7 = 0; i7 < readBits3; i7++) {
                        int i8 = i4 - 1;
                        vorbisBitArray.skipBits(iLog(i8));
                        vorbisBitArray.skipBits(iLog(i8));
                    }
                }
                if (vorbisBitArray.readBits(2) == 0) {
                    if (i5 > 1) {
                        for (int i9 = 0; i9 < i4; i9++) {
                            vorbisBitArray.skipBits(4);
                        }
                    }
                    for (int i10 = 0; i10 < i5; i10++) {
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[readBits];
        for (int i4 = 0; i4 < readBits; i4++) {
            modeArr[i4] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int i4;
        int readBits = vorbisBitArray.readBits(6) + 1;
        int i5 = 0;
        while (i5 < readBits) {
            if (vorbisBitArray.readBits(16) <= 2) {
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                int readBits2 = vorbisBitArray.readBits(6) + 1;
                vorbisBitArray.skipBits(8);
                int[] iArr = new int[readBits2];
                for (int i6 = 0; i6 < readBits2; i6++) {
                    int readBits3 = vorbisBitArray.readBits(3);
                    if (vorbisBitArray.readBit()) {
                        i4 = vorbisBitArray.readBits(5);
                    } else {
                        i4 = 0;
                    }
                    iArr[i6] = (i4 * 8) + readBits3;
                }
                for (int i7 = 0; i7 < readBits2; i7++) {
                    for (int i8 = 0; i8 < 8; i8++) {
                        if ((iArr[i7] & (1 << i8)) != 0) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                }
                i5++;
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[((int) readLittleEndianUnsignedInt)];
        int i4 = length + 15;
        for (int i5 = 0; ((long) i5) < readLittleEndianUnsignedInt; i5++) {
            String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i5] = readString2;
            i4 = i4 + 4 + readString2.length();
        }
        if ((parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, i4 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        verifyVorbisHeaderCapturePattern(1, parsableByteArray2, false);
        long readLittleEndianUnsignedInt = parsableByteArray2.readLittleEndianUnsignedInt();
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        long readLittleEndianUnsignedInt2 = parsableByteArray2.readLittleEndianUnsignedInt();
        int readLittleEndianInt = parsableByteArray2.readLittleEndianInt();
        int readLittleEndianInt2 = parsableByteArray2.readLittleEndianInt();
        int readLittleEndianInt3 = parsableByteArray2.readLittleEndianInt();
        int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
        int pow = (int) Math.pow(2.0d, (double) (readUnsignedByte2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((readUnsignedByte2 & PsExtractor.VIDEO_STREAM_MASK) >> 4));
        if ((parsableByteArray2.readUnsignedByte() & 1) > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return new VorbisIdHeader(readLittleEndianUnsignedInt, readUnsignedByte, readLittleEndianUnsignedInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, pow, pow2, z4, Arrays.copyOf(parsableByteArray2.data, parsableByteArray2.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i4) throws ParserException {
        int i5 = 0;
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i6 = 0; i6 < readUnsignedByte; i6++) {
            readBook(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        while (i5 < readBits) {
            if (vorbisBitArray.readBits(16) == 0) {
                i5++;
            } else {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i4, vorbisBitArray);
        Mode[] readModes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return readModes;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i4, ParsableByteArray parsableByteArray, boolean z4) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z4) {
                return false;
            }
            throw new ParserException("too short header: " + parsableByteArray.bytesLeft());
        } else if (parsableByteArray.readUnsignedByte() != i4) {
            if (z4) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i4));
        } else if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        } else {
            if (z4) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }
}
