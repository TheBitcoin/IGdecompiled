package com.mbridge.msdk.playercommon;

public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(String str);

    void onPlayCompleted();

    void onPlayError(String str);

    void onPlayProgress(int i4, int i5);

    void onPlayProgressMS(int i4, int i5);

    void onPlaySetDataSourceError(String str);

    void onPlayStarted(int i4);
}
