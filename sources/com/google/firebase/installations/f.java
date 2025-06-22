package com.google.firebase.installations;

import T0.d;
import k0.C0938m;

class f implements h {

    /* renamed from: a  reason: collision with root package name */
    final C0938m f11208a;

    public f(C0938m mVar) {
        this.f11208a = mVar;
    }

    public boolean a(d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f11208a.e(dVar.d());
        return true;
    }

    public boolean b(Exception exc) {
        return false;
    }
}
