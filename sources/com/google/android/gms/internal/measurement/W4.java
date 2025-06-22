package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class W4 {

    /* renamed from: a  reason: collision with root package name */
    private Map f1656a = new HashMap();

    public final C0663s a(String str) {
        if (!this.f1656a.containsKey(str)) {
            return C0663s.f2138b0;
        }
        try {
            return (C0663s) ((Callable) this.f1656a.get(str)).call();
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to create API implementation: " + str);
        }
    }

    public final void b(String str, Callable callable) {
        this.f1656a.put(str, callable);
    }
}
