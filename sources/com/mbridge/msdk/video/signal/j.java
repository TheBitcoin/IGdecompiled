package com.mbridge.msdk.video.signal;

public interface j {
    void alertWebViewShowed();

    void closeVideoOperate(int i4, int i5);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    String getCurrentProgress();

    void hideAlertView(int i4);

    boolean isH5Canvas();

    void notifyCloseBtn(int i4);

    void progressBarOperate(int i4);

    void progressOperate(int i4, int i5);

    void setCover(boolean z4);

    void setMiniEndCardState(boolean z4);

    void setScaleFitXY(int i4);

    void setVisible(int i4);

    void showAlertView();

    void showIVRewardAlertView(String str);

    void showVideoLocation(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void soundOperate(int i4, int i5);

    void soundOperate(int i4, int i5, String str);

    void videoOperate(int i4);
}
