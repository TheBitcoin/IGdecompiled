package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.A3;

public enum B3 {
    STORAGE(A3.a.AD_STORAGE, A3.a.ANALYTICS_STORAGE),
    DMA(A3.a.AD_USER_DATA);
    
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final A3.a[] f2330a;

    private B3(A3.a... aVarArr) {
        this.f2330a = aVarArr;
    }

    public final A3.a[] a() {
        return this.f2330a;
    }
}
