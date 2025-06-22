package com.google.android.gms.internal.measurement;

import java.net.URL;
import java.net.URLConnection;

public abstract class D0 {

    /* renamed from: a  reason: collision with root package name */
    private static D0 f1427a = new C0();

    public static synchronized D0 a() {
        D0 d02;
        synchronized (D0.class) {
            d02 = f1427a;
        }
        return d02;
    }

    public abstract URLConnection b(URL url, String str);
}
