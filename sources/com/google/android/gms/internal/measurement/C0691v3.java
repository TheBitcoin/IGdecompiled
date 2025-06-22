package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.measurement.v3  reason: case insensitive filesystem */
public final /* synthetic */ class C0691v3 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ C0699w3 f2210a;

    public /* synthetic */ C0691v3(C0699w3 w3Var) {
        this.f2210a = w3Var;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f2210a.e(sharedPreferences, str);
    }
}
