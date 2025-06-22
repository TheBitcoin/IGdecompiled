package com.mbridge.msdk.video.signal;

public interface f {
    void configurationChanged(int i4, int i5, int i6);

    boolean endCardShowing();

    void hideAlertWebview();

    void ivRewardAdsWithoutVideo(String str);

    boolean miniCardShowing();

    void readyStatus(int i4);

    void resizeMiniCard(int i4, int i5, int i6);

    boolean showAlertWebView();

    void showEndcard(int i4);

    void showMiniCard(int i4, int i5, int i6, int i7, int i8);

    void showVideoClickView(int i4);

    void showVideoEndCover();
}
