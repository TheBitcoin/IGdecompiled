package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f11158c;

    public /* synthetic */ j(o oVar, Runnable runnable, p.b bVar) {
        this.f11156a = oVar;
        this.f11157b = runnable;
        this.f11158c = bVar;
    }

    public final void run() {
        this.f11156a.f11169a.execute(new m(this.f11157b, this.f11158c));
    }
}
