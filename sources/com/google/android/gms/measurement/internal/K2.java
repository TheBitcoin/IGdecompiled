package com.google.android.gms.measurement.internal;

import M.C0335p;
import androidx.collection.LruCache;

final class K2 extends LruCache {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ I2 f2602a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    K2(I2 i22, int i4) {
        super(20);
        this.f2602a = i22;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        C0335p.f(str);
        return I2.w(this.f2602a, str);
    }
}
