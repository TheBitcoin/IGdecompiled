package com.google.android.gms.common.api.internal;

import J.C0303b;
import J.C0308g;
import L.C0318b;
import L.e;
import M.C0335p;
import android.app.Activity;
import androidx.collection.ArraySet;

public final class h extends C {

    /* renamed from: f  reason: collision with root package name */
    private final ArraySet f1321f = new ArraySet();

    /* renamed from: g  reason: collision with root package name */
    private final C0504c f1322g;

    h(e eVar, C0504c cVar, C0308g gVar) {
        super(eVar, gVar);
        this.f1322g = cVar;
        this.f1281a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, C0504c cVar, C0318b bVar) {
        e d5 = LifecycleCallback.d(activity);
        h hVar = (h) d5.b("ConnectionlessLifecycleHelper", h.class);
        if (hVar == null) {
            hVar = new h(d5, cVar, C0308g.n());
        }
        C0335p.m(bVar, "ApiKey cannot be null");
        hVar.f1321f.add(bVar);
        cVar.b(hVar);
    }

    private final void v() {
        if (!this.f1321f.isEmpty()) {
            this.f1322g.b(this);
        }
    }

    public final void h() {
        super.h();
        v();
    }

    public final void j() {
        super.j();
        v();
    }

    public final void k() {
        super.k();
        this.f1322g.c(this);
    }

    /* access modifiers changed from: protected */
    public final void m(C0303b bVar, int i4) {
        this.f1322g.D(bVar, i4);
    }

    /* access modifiers changed from: protected */
    public final void n() {
        this.f1322g.E();
    }

    /* access modifiers changed from: package-private */
    public final ArraySet t() {
        return this.f1321f;
    }
}
