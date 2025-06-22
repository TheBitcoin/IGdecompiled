package com.google.android.gms.internal.measurement;

import java.net.URL;
import java.net.URLConnection;

final class C0 extends D0 {
    public final URLConnection b(URL url, String str) {
        return url.openConnection();
    }

    private C0() {
    }
}
