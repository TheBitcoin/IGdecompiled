package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.i;

public class g implements i {
    public String a() {
        af.a("js", "getEndScreenInfo");
        return "{}";
    }

    public void b(String str) {
        af.a("js", "setOrientation,landscape=" + str);
    }

    public void c(String str) {
        af.a("js", "handlerPlayableException，msg=" + str);
    }

    public void notifyCloseBtn(int i4) {
        af.a("js", "notifyCloseBtn,state=" + i4);
    }

    public void toggleCloseBtn(int i4) {
        af.a("js", "toggleCloseBtn,state=" + i4);
    }

    public void a(String str) {
        af.a("js", "triggerCloseBtn,state=" + str);
    }
}
