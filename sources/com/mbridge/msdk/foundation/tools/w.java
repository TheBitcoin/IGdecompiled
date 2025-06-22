package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;
import com.mbridge.msdk.foundation.controller.c;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static ConnectivityManager f13695a;

    public static synchronized ConnectivityManager a() {
        ConnectivityManager connectivityManager;
        synchronized (w.class) {
            try {
                if (f13695a == null && c.m().c() != null) {
                    f13695a = (ConnectivityManager) c.m().c().getSystemService("connectivity");
                }
            } catch (Exception e5) {
                af.b("NetManager", e5.getMessage());
            }
            connectivityManager = f13695a;
        }
        return connectivityManager;
    }
}
