package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.p3  reason: case insensitive filesystem */
final class C0644p3 extends C0591j3 {
    C0644p3(C0659r3 r3Var, String str, Double d5, boolean z4) {
        super(r3Var, str, d5);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public final Double g(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String k4 = super.k();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", "Invalid double value for " + k4 + ": " + valueOf);
        return null;
    }
}
