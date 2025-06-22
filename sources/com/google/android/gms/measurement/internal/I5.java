package com.google.android.gms.measurement.internal;

import f0.C;
import java.util.Collections;
import java.util.Map;

final class I5 {

    /* renamed from: a  reason: collision with root package name */
    private String f2589a;

    /* renamed from: b  reason: collision with root package name */
    private Map f2590b;

    /* renamed from: c  reason: collision with root package name */
    private C f2591c;

    I5(String str, C c5) {
        this.f2589a = str;
        this.f2591c = c5;
    }

    public final C a() {
        return this.f2591c;
    }

    public final String b() {
        return this.f2589a;
    }

    public final Map c() {
        Map map = this.f2590b;
        if (map == null) {
            return Collections.EMPTY_MAP;
        }
        return map;
    }

    I5(String str, Map map, C c5) {
        this.f2589a = str;
        this.f2590b = map;
        this.f2591c = c5;
    }
}
