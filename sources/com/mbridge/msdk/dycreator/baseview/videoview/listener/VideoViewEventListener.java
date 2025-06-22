package com.mbridge.msdk.dycreator.baseview.videoview.listener;

public interface VideoViewEventListener {
    void onBufferingEnd();

    void onBufferingFail(String str);

    void onBufferingStart();

    void onPlayCompleted();

    void onPlayProgress(int i4, int i5);

    void onPlayStart(String str);

    void onPlayerError(int i4, String str);
}
