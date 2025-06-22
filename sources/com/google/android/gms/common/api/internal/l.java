package com.google.android.gms.common.api.internal;

final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1327a;

    l(m mVar) {
        this.f1327a = mVar;
    }

    public final void run() {
        n nVar = this.f1327a.f1328a;
        nVar.f1330b.d(nVar.f1330b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
