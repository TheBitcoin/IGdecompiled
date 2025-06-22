package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.measurement.u0  reason: case insensitive filesystem */
public final class C0680u0 implements SharedPreferences {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map f2191a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Set f2192b = new HashSet();

    private final Object a(String str, Object obj) {
        Object obj2 = this.f2191a.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    public final boolean contains(String str) {
        return this.f2191a.containsKey(str);
    }

    public final SharedPreferences.Editor edit() {
        return new C0704x0(this);
    }

    public final Map getAll() {
        return this.f2191a;
    }

    public final boolean getBoolean(String str, boolean z4) {
        return ((Boolean) a(str, Boolean.valueOf(z4))).booleanValue();
    }

    public final float getFloat(String str, float f4) {
        return ((Float) a(str, Float.valueOf(f4))).floatValue();
    }

    public final int getInt(String str, int i4) {
        return ((Integer) a(str, Integer.valueOf(i4))).intValue();
    }

    public final long getLong(String str, long j4) {
        return ((Long) a(str, Long.valueOf(j4))).longValue();
    }

    public final String getString(String str, String str2) {
        return (String) a(str, str2);
    }

    public final Set getStringSet(String str, Set set) {
        return (Set) a(str, set);
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f2192b.add(onSharedPreferenceChangeListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f2192b.remove(onSharedPreferenceChangeListener);
    }
}
