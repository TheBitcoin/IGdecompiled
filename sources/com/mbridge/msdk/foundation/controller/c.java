package com.mbridge.msdk.foundation.controller;

import android.annotation.SuppressLint;
import com.mbridge.msdk.foundation.controller.a;

public class c extends a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    private static volatile c f12802f;

    private c() {
    }

    public static c m() {
        if (f12802f == null) {
            synchronized (c.class) {
                try {
                    if (f12802f == null) {
                        f12802f = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12802f;
    }

    /* access modifiers changed from: protected */
    public final void a(a.C0179a aVar) {
    }
}
