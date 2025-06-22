package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class VbriSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "VbriSeeker";
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j4) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j4;
    }

    public static VbriSeeker create(long j4, long j5, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int i4;
        int i5;
        long j6 = j4;
        MpegAudioHeader mpegAudioHeader2 = mpegAudioHeader;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray2.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i6 = mpegAudioHeader2.sampleRate;
        long j7 = (long) readInt;
        if (i6 >= 32000) {
            i4 = 1152;
        } else {
            i4 = 576;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j7, ((long) i4) * 1000000, (long) i6);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j8 = j5 + ((long) mpegAudioHeader2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long j9 = j5;
        int i7 = 0;
        while (i7 < readUnsignedShort) {
            jArr[i7] = (((long) i7) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j10 = j8;
            jArr2[i7] = Math.max(j9, j10);
            if (readUnsignedShort3 == 1) {
                i5 = parsableByteArray2.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i5 = parsableByteArray2.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i5 = parsableByteArray2.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i5 = parsableByteArray2.readUnsignedIntToInt();
            }
            j9 += (long) (i5 * readUnsignedShort2);
            i7++;
            parsableByteArray2 = parsableByteArray;
            j8 = j10;
            readUnsignedShort = readUnsignedShort;
        }
        if (!(j6 == -1 || j6 == j9)) {
            Log.w(TAG, "VBRI data size mismatch: " + j6 + ", " + j9);
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j4) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j4, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j4 || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i4 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i4], this.positions[i4]));
    }

    public final long getTimeUs(long j4) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j4, true, true)];
    }

    public final boolean isSeekable() {
        return true;
    }
}
