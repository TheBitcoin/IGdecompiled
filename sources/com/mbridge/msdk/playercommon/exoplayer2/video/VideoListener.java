package com.mbridge.msdk.playercommon.exoplayer2.video;

public interface VideoListener {
    void onRenderedFirstFrame();

    void onVideoSizeChanged(int i4, int i5, int i6, float f4);
}
