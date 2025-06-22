package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.C0502a;

final class i implements C0502a.C0023a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0504c f1323a;

    i(C0504c cVar) {
        this.f1323a = cVar;
    }

    public final void a(boolean z4) {
        C0504c cVar = this.f1323a;
        cVar.f1306n.sendMessage(cVar.f1306n.obtainMessage(1, Boolean.valueOf(z4)));
    }
}
