package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

public final class L7 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private final Callable f1530c;

    public L7(String str, Callable callable) {
        super(str);
        this.f1530c = callable;
    }

    public final C0663s a(Z2 z22, List list) {
        try {
            return C0511a4.b(this.f1530c.call());
        } catch (Exception unused) {
            return C0663s.f2138b0;
        }
    }
}
