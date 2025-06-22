package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import f0.p;

final class B1 {

    /* renamed from: a  reason: collision with root package name */
    private final p f2322a;

    B1(p pVar) {
        this.f2322a = pVar;
    }

    static B1 a(String str) {
        p pVar;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            pVar = p.UNINITIALIZED;
        } else {
            pVar = A3.g(str.charAt(0));
        }
        return new B1(pVar);
    }

    /* access modifiers changed from: package-private */
    public final p b() {
        return this.f2322a;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return String.valueOf(A3.a(this.f2322a));
    }
}
