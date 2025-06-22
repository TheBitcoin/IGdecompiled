package com.mbridge.msdk.playercommon;

import com.mbridge.msdk.foundation.tools.af;

public class DefaultVideoPlayerStatusListener implements VideoPlayerStatusListener {
    protected static final String TAG = "DefaultVideoPlayerStatusListener";

    public void onBufferingEnd() {
        af.a(TAG, "OnBufferingEnd");
    }

    public void onBufferingStart(String str) {
        af.a(TAG, "OnBufferingStart:" + str);
    }

    public void onPlayCompleted() {
        af.a(TAG, "onPlayCompleted");
    }

    public void onPlayError(String str) {
        af.a(TAG, "onPlayError:" + str);
    }

    public void onPlayProgress(int i4, int i5) {
        af.a(TAG, "onPlayProgress:" + i4 + ",allDuration:" + i5);
    }

    public void onPlayProgressMS(int i4, int i5) {
        af.a(TAG, "onPlayProgressMS:");
    }

    public void onPlaySetDataSourceError(String str) {
        af.a(TAG, "onPlaySetDataSourceError:" + str);
    }

    public void onPlayStarted(int i4) {
        af.a(TAG, "onPlayStarted:" + i4);
    }
}
