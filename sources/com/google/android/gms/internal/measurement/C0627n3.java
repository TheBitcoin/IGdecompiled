package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.n3  reason: case insensitive filesystem */
final class C0627n3 extends C0591j3 {
    C0627n3(C0659r3 r3Var, String str, Long l4, boolean z4) {
        super(r3Var, str, l4);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public final Long g(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String k4 = super.k();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", "Invalid long value for " + k4 + ": " + valueOf);
        return null;
    }
}
