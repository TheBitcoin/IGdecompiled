package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.s5  reason: case insensitive filesystem */
final class C0669s5 extends C0646p5 {
    C0669s5() {
        super();
    }

    public final void m() {
        if (!o()) {
            if (a() <= 0) {
                Iterator it = h().iterator();
                if (it.hasNext()) {
                    a.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            } else {
                a.a(f(0).getKey());
                throw null;
            }
        }
        super.m();
    }
}
