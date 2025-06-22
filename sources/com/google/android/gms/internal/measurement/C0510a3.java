package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* renamed from: com.google.android.gms.internal.measurement.a3  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0510a3 {
    public static Object a(C0537d3 d3Var) {
        long clearCallingIdentity;
        try {
            return d3Var.A();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object A4 = d3Var.A();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return A4;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
