package com.mbridge.msdk.playercommon.exoplayer2.text;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.OutputBuffer;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    public List<Cue> getCues(long j4) {
        return this.subtitle.getCues(j4 - this.subsampleOffsetUs);
    }

    public long getEventTime(int i4) {
        return this.subtitle.getEventTime(i4) + this.subsampleOffsetUs;
    }

    public int getEventTimeCount() {
        return this.subtitle.getEventTimeCount();
    }

    public int getNextEventTimeIndex(long j4) {
        return this.subtitle.getNextEventTimeIndex(j4 - this.subsampleOffsetUs);
    }

    public abstract void release();

    public void setContent(long j4, Subtitle subtitle2, long j5) {
        this.timeUs = j4;
        this.subtitle = subtitle2;
        if (j5 != Long.MAX_VALUE) {
            j4 = j5;
        }
        this.subsampleOffsetUs = j4;
    }
}
