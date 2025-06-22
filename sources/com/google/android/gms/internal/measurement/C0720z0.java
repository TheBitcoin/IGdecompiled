package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import l0.h;

/* renamed from: com.google.android.gms.internal.measurement.z0  reason: case insensitive filesystem */
public abstract class C0720z0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f2262a = new C0712y0();

    public static SharedPreferences a(Context context, String str, int i4, C0656r0 r0Var) {
        C0680u0 u0Var;
        if (C0597k0.a().a(str, r0Var, C0633o0.SHARED_PREFS_TYPE).equals("")) {
            u0Var = new C0680u0();
        } else {
            u0Var = null;
        }
        if (u0Var != null) {
            return u0Var;
        }
        ThreadLocal threadLocal = f2262a;
        h.d(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            f2262a.set(Boolean.TRUE);
            throw th;
        }
    }
}
