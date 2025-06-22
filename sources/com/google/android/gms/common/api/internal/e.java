package com.google.android.gms.common.api.internal;

import K.g;
import com.google.android.gms.common.api.Status;

final class e implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f1315a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1316b;

    e(g gVar, BasePendingResult basePendingResult) {
        this.f1316b = gVar;
        this.f1315a = basePendingResult;
    }

    public final void a(Status status) {
        this.f1316b.f1319a.remove(this.f1315a);
    }
}
