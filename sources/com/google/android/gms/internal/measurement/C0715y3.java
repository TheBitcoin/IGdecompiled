package com.google.android.gms.internal.measurement;

import l0.h;
import m0.C2149q;

/* renamed from: com.google.android.gms.internal.measurement.y3  reason: case insensitive filesystem */
public final class C0715y3 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2259a;

    public C0715y3(C0707x3 x3Var) {
        h.j(x3Var, "BuildInfo must be non-null");
        this.f2259a = !x3Var.A();
    }

    public final boolean a(String str) {
        h.j(str, "flagName must not be null");
        if (!this.f2259a) {
            return true;
        }
        return ((C2149q) B3.f1408a.get()).b(str);
    }
}
