package com.mbridge.msdk.d;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.d.a;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;

public class b {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static b f12175a = new b();
    }

    public static b getInstance() {
        return a.f12175a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            a.C0175a.f12174a.b(str, str2);
        } catch (Exception e5) {
            af.b("TimerController", "addInterstitialList error:" + e5.getMessage());
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            a.C0175a.f12174a.a(str, str2);
        } catch (Exception e5) {
            af.b("TimerController", "addRewardList error:" + e5.getMessage());
        }
    }

    public void start() {
        g b5 = h.a().b(c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        int o4 = b5.o();
        if (o4 > 0) {
            a.C0175a.f12174a.a((long) (o4 * 1000));
        }
    }

    private b() {
    }
}
