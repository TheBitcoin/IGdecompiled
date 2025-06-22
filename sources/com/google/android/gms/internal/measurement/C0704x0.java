package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import m0.M;
import m0.S;

/* renamed from: com.google.android.gms.internal.measurement.x0  reason: case insensitive filesystem */
final class C0704x0 implements SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2243a;

    /* renamed from: b  reason: collision with root package name */
    private Set f2244b;

    /* renamed from: c  reason: collision with root package name */
    private Map f2245c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C0680u0 f2246d;

    private final void a(String str, Object obj) {
        if (obj != null) {
            this.f2245c.put(str, obj);
        } else {
            remove(str);
        }
    }

    public final void apply() {
        commit();
    }

    public final SharedPreferences.Editor clear() {
        this.f2243a = true;
        return this;
    }

    public final boolean commit() {
        if (this.f2243a) {
            this.f2246d.f2191a.clear();
        }
        this.f2246d.f2191a.keySet().removeAll(this.f2244b);
        for (Map.Entry entry : this.f2245c.entrySet()) {
            this.f2246d.f2191a.put((String) entry.getKey(), entry.getValue());
        }
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f2246d.f2192b) {
            S c5 = M.c(this.f2244b, this.f2245c.keySet()).c();
            while (c5.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f2246d, (String) c5.next());
            }
        }
        if (this.f2243a || !this.f2244b.isEmpty() || !this.f2245c.isEmpty()) {
            return true;
        }
        return false;
    }

    public final SharedPreferences.Editor putBoolean(String str, boolean z4) {
        a(str, Boolean.valueOf(z4));
        return this;
    }

    public final SharedPreferences.Editor putFloat(String str, float f4) {
        a(str, Float.valueOf(f4));
        return this;
    }

    public final SharedPreferences.Editor putInt(String str, int i4) {
        a(str, Integer.valueOf(i4));
        return this;
    }

    public final SharedPreferences.Editor putLong(String str, long j4) {
        a(str, Long.valueOf(j4));
        return this;
    }

    public final SharedPreferences.Editor putString(String str, String str2) {
        a(str, str2);
        return this;
    }

    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        a(str, set);
        return this;
    }

    public final SharedPreferences.Editor remove(String str) {
        this.f2244b.add(str);
        return this;
    }

    private C0704x0(C0680u0 u0Var) {
        this.f2246d = u0Var;
        this.f2243a = false;
        this.f2244b = new HashSet();
        this.f2245c = new HashMap();
    }
}
