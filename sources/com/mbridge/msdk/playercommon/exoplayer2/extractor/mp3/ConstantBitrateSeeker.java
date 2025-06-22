package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j4, long j5, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j5;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j4 == -1) {
            this.dataSize = -1;
            this.durationUs = C.TIME_UNSET;
            return;
        }
        this.dataSize = j4 - j5;
        this.durationUs = getTimeUs(j4);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j4) {
        long j5 = this.dataSize;
        if (j5 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.firstFramePosition));
        }
        int i4 = this.frameSize;
        long constrainValue = Util.constrainValue((((((long) this.bitrate) * j4) / 8000000) / ((long) i4)) * ((long) i4), 0, j5 - ((long) i4));
        long j6 = this.firstFramePosition + constrainValue;
        long timeUs = getTimeUs(j6);
        SeekPoint seekPoint = new SeekPoint(timeUs, j6);
        if (timeUs < j4) {
            long j7 = this.dataSize;
            int i5 = this.frameSize;
            if (constrainValue != j7 - ((long) i5)) {
                long j8 = j6 + ((long) i5);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j8), j8));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j4) {
        return (Math.max(0, j4 - this.firstFramePosition) * 8000000) / ((long) this.bitrate);
    }

    public final boolean isSeekable() {
        if (this.dataSize != -1) {
            return true;
        }
        return false;
    }
}
