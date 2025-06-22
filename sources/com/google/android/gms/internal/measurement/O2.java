package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class O2 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M2 f1587a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    O2(M2 m22, Handler handler) {
        super((Handler) null);
        this.f1587a = m22;
    }

    public final void onChange(boolean z4) {
        this.f1587a.f1532a.set(true);
    }
}
