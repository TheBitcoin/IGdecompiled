package com.mbridge.msdk.playercommon.exoplayer2.text;

import java.util.List;

public interface Subtitle {
    List<Cue> getCues(long j4);

    long getEventTime(int i4);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j4);
}
