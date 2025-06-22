package com.mbridge.msdk.dycreator.e;

import android.util.Log;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12640a = false;

    public static void a(String str) {
        if (f12640a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
