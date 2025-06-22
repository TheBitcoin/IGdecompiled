package com.google.firebase.installations;

import T0.d;
import k0.C0938m;

class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private final i f11206a;

    /* renamed from: b  reason: collision with root package name */
    private final C0938m f11207b;

    public e(i iVar, C0938m mVar) {
        this.f11206a = iVar;
        this.f11207b = mVar;
    }

    public boolean a(d dVar) {
        if (!dVar.k() || this.f11206a.f(dVar)) {
            return false;
        }
        this.f11207b.c(g.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }

    public boolean b(Exception exc) {
        this.f11207b.d(exc);
        return true;
    }
}
