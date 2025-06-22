package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C0694v6;
import java.util.Map;

final class M2 implements C0694v6 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2620a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ I2 f2621b;

    M2(I2 i22, String str) {
        this.f2620a = str;
        this.f2621b = i22;
    }

    public final String c(String str) {
        Map map = (Map) this.f2621b.f2570d.get(this.f2620a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
