package com.mbridge.msdk.playercommon.exoplayer2;

public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int i4, long j4);

    boolean dispatchSetPlayWhenReady(Player player, boolean z4);

    boolean dispatchSetRepeatMode(Player player, int i4);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z4);

    boolean dispatchStop(Player player, boolean z4);
}
