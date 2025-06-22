package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class W2 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U2 f1653a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    W2(U2 u22, Handler handler) {
        super((Handler) null);
        this.f1653a = u22;
    }

    public final void onChange(boolean z4) {
        this.f1653a.f();
    }
}
