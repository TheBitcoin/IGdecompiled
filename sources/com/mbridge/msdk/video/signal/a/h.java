package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.j;

public class h implements j {
    public void alertWebViewShowed() {
        af.a("DefaultJSVideoModule", "alertWebViewShowed:");
    }

    public void closeVideoOperate(int i4, int i5) {
        af.a("DefaultJSVideoModule", "closeOperte:close=" + i4 + "closeViewVisible=" + i5);
    }

    public void dismissAllAlert() {
        af.a("DefaultJSVideoModule", "dismissAllAlert");
    }

    public int getBorderViewHeight() {
        return 0;
    }

    public int getBorderViewLeft() {
        return 0;
    }

    public int getBorderViewRadius() {
        return 0;
    }

    public int getBorderViewTop() {
        return 0;
    }

    public int getBorderViewWidth() {
        return 0;
    }

    public String getCurrentProgress() {
        af.a("DefaultJSVideoModule", "getCurrentProgress");
        return "{}";
    }

    public void hideAlertView(int i4) {
        af.a("DefaultJSVideoModule", "hideAlertView:");
    }

    public boolean isH5Canvas() {
        return false;
    }

    public void notifyCloseBtn(int i4) {
        af.a("DefaultJSVideoModule", "notifyCloseBtn:" + i4);
    }

    public void progressBarOperate(int i4) {
        af.a("DefaultJSVideoModule", "progressBarOperate:progressViewVisible=" + i4);
    }

    public void progressOperate(int i4, int i5) {
        af.a("DefaultJSVideoModule", "progressOperate:progress=" + i4 + "progressViewVisible=" + i5);
    }

    public void setCover(boolean z4) {
        af.a("DefaultJSVideoModule", "setCover:" + z4);
    }

    public void setMiniEndCardState(boolean z4) {
        af.a("DefaultJSVideoModule", "setMiniEndCardState");
    }

    public void setScaleFitXY(int i4) {
        af.a("DefaultJSVideoModule", "setScaleFitXY:" + i4);
    }

    public void setVisible(int i4) {
        af.a("DefaultJSVideoModule", "setVisible:" + i4);
    }

    public void showAlertView() {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    public void showIVRewardAlertView(String str) {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    public void showVideoLocation(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        af.a("DefaultJSVideoModule", "showVideoLocation:marginTop=" + i4 + ",marginLeft=" + i5 + ",width=" + i6 + ",height=" + i7 + ",radius=" + i8 + ",borderTop=" + i9 + ",borderTop=" + i9 + ",borderLeft=" + i10 + ",borderWidth=" + i11 + ",borderHeight=" + i12);
    }

    public void soundOperate(int i4, int i5) {
        af.a("DefaultJSVideoModule", "soundOperate:mute=" + i4 + ",soundViewVisible=" + i5);
    }

    public void videoOperate(int i4) {
        af.a("DefaultJSVideoModule", "videoOperate:" + i4);
    }

    public void soundOperate(int i4, int i5, String str) {
        af.a("DefaultJSVideoModule", "soundOperate:mute=" + i4 + ",soundViewVisible=" + i5 + ",pt=" + str);
    }
}
