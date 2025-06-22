package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;

public class e implements f, h {
    public void configurationChanged(int i4, int i5, int i6) {
    }

    public boolean endCardShowing() {
        af.a("DefaultJSContainerModule", "endCardShowing");
        return true;
    }

    public void hideAlertWebview() {
        af.a("DefaultJSContainerModule", "hideAlertWebview ,msg=");
    }

    public void ivRewardAdsWithoutVideo(String str) {
        af.a("DefaultJSContainerModule", "ivRewardAdsWithoutVideo,params=");
    }

    public boolean miniCardShowing() {
        af.a("DefaultJSContainerModule", "miniCardShowing");
        return false;
    }

    public void notifyCloseBtn(int i4) {
        af.a("DefaultJSContainerModule", "notifyCloseBtn:state = " + i4);
    }

    public void readyStatus(int i4) {
        af.a("DefaultJSContainerModule", "readyStatus:isReady=" + i4);
    }

    public void resizeMiniCard(int i4, int i5, int i6) {
        af.a("DefaultJSContainerModule", "showMiniCard width = " + i4 + " height = " + i5 + " radius = " + i6);
    }

    public boolean showAlertWebView() {
        af.a("DefaultJSContainerModule", "showAlertWebView ,msg=");
        return false;
    }

    public void showEndcard(int i4) {
        af.a("DefaultJSContainerModule", "showEndcard,type=" + i4);
    }

    public void showMiniCard(int i4, int i5, int i6, int i7, int i8) {
        af.a("DefaultJSContainerModule", "showMiniCard top = " + i4 + " left = " + i5 + " width = " + i6 + " height = " + i7 + " radius = " + i8);
    }

    public void showVideoClickView(int i4) {
        af.a("DefaultJSContainerModule", "showVideoClickView:" + i4);
    }

    public void showVideoEndCover() {
        af.a("DefaultJSContainerModule", "showVideoEndCover");
    }

    public void toggleCloseBtn(int i4) {
        af.a("DefaultJSContainerModule", "toggleCloseBtn:state=" + i4);
    }
}
