package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import java.util.List;

public interface TrackSelection {

    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i4, long j4);

    void disable();

    void enable();

    int evaluateQueueSize(long j4, List<? extends MediaChunk> list);

    Format getFormat(int i4);

    int getIndexInTrackGroup(int i4);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i4);

    int indexOf(Format format);

    int length();

    void onPlaybackSpeed(float f4);

    void updateSelectedTrack(long j4, long j5, long j6);
}
