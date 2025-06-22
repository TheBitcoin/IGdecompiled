package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11153a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f11155c;

    public /* synthetic */ i(o oVar, Runnable runnable, p.b bVar) {
        this.f11153a = oVar;
        this.f11154b = runnable;
        this.f11155c = bVar;
    }

    public final void run() {
        this.f11153a.f11169a.execute(new d(this.f11154b, this.f11155c));
    }
}
