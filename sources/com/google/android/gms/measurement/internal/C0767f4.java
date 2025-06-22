package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.f4  reason: case insensitive filesystem */
final class C0767f4 implements c6 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ F3 f2980a;

    C0767f4(F3 f32) {
        this.f2980a = f32;
    }

    public final void b(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f2980a.i0("auto", str2, bundle, str);
        } else {
            this.f2980a.U0("auto", str2, bundle);
        }
    }
}
