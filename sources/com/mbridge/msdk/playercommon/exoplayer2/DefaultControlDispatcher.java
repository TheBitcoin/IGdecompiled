package com.mbridge.msdk.playercommon.exoplayer2;

public class DefaultControlDispatcher implements ControlDispatcher {
    public boolean dispatchSeekTo(Player player, int i4, long j4) {
        player.seekTo(i4, j4);
        return true;
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean z4) {
        player.setPlayWhenReady(z4);
        return true;
    }

    public boolean dispatchSetRepeatMode(Player player, int i4) {
        player.setRepeatMode(i4);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z4) {
        player.setShuffleModeEnabled(z4);
        return true;
    }

    public boolean dispatchStop(Player player, boolean z4) {
        player.stop(z4);
        return true;
    }
}
