package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class XingSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long j4, int i4, long j5) {
        this(j4, i4, j5, -1, (long[]) null);
    }

    public static XingSeeker create(long j4, long j5, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        long j6 = j4;
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        int i4 = mpegAudioHeader2.samplesPerFrame;
        int i5 = mpegAudioHeader2.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readUnsignedIntToInt, ((long) i4) * 1000000, (long) i5);
        if ((readInt & 6) != 6) {
            return new XingSeeker(j5, mpegAudioHeader2.frameSize, scaleLargeTimestamp);
        }
        long readUnsignedIntToInt2 = (long) parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[100];
        for (int i6 = 0; i6 < 100; i6++) {
            jArr[i6] = (long) parsableByteArray.readUnsignedByte();
        }
        if (j6 != -1) {
            long j7 = j5 + readUnsignedIntToInt2;
            if (j6 != j7) {
                Log.w(TAG, "XING data size mismatch: " + j6 + ", " + j7);
            }
        }
        return new XingSeeker(j5, mpegAudioHeader2.frameSize, scaleLargeTimestamp, readUnsignedIntToInt2, jArr);
    }

    private long getTimeUsForTableIndex(int i4) {
        return (this.durationUs * ((long) i4)) / 100;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j4) {
        double d5;
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.dataStartPosition + ((long) this.xingFrameSize)));
        }
        long constrainValue = Util.constrainValue(j4, 0, this.durationUs);
        double d6 = (((double) constrainValue) * 100.0d) / ((double) this.durationUs);
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            if (d6 >= 100.0d) {
                d7 = 256.0d;
            } else {
                int i4 = (int) d6;
                long[] jArr = this.tableOfContents;
                double d8 = (double) jArr[i4];
                if (i4 == 99) {
                    d5 = 256.0d;
                } else {
                    d5 = (double) jArr[i4 + 1];
                }
                d7 = d8 + ((d6 - ((double) i4)) * (d5 - d8));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d7 / 256.0d) * ((double) this.dataSize)), (long) this.xingFrameSize, this.dataSize - 1)));
    }

    public final long getTimeUs(long j4) {
        long j5;
        double d5;
        long j6 = j4 - this.dataStartPosition;
        if (!isSeekable() || j6 <= ((long) this.xingFrameSize)) {
            return 0;
        }
        double d6 = (((double) j6) * 256.0d) / ((double) this.dataSize);
        int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d6, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(binarySearchFloor);
        long j7 = this.tableOfContents[binarySearchFloor];
        int i4 = binarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i4);
        if (binarySearchFloor == 99) {
            j5 = 256;
        } else {
            j5 = this.tableOfContents[i4];
        }
        if (j7 == j5) {
            d5 = 0.0d;
        } else {
            d5 = (d6 - ((double) j7)) / ((double) (j5 - j7));
        }
        return timeUsForTableIndex + Math.round(d5 * ((double) (timeUsForTableIndex2 - timeUsForTableIndex)));
    }

    public final boolean isSeekable() {
        if (this.tableOfContents != null) {
            return true;
        }
        return false;
    }

    private XingSeeker(long j4, int i4, long j5, long j6, long[] jArr) {
        this.dataStartPosition = j4;
        this.xingFrameSize = i4;
        this.durationUs = j5;
        this.dataSize = j6;
        this.tableOfContents = jArr;
    }
}
