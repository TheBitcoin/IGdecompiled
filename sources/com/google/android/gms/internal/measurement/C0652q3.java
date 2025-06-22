package com.google.android.gms.internal.measurement;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.measurement.q3  reason: case insensitive filesystem */
final class C0652q3 extends C0591j3 {
    C0652q3(C0659r3 r3Var, String str, Boolean bool, boolean z4) {
        super(r3Var, str, bool);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object g(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (H2.f1491c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (H2.f1492d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String k4 = super.k();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", "Invalid boolean value for " + k4 + ": " + valueOf);
        return null;
    }
}
