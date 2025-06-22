package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

public final /* synthetic */ class M3 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ F3 f2622a;

    public /* synthetic */ M3(F3 f32) {
        this.f2622a = f32;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f2622a.L(sharedPreferences, str);
    }
}
