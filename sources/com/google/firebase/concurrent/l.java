package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f11164c;

    public /* synthetic */ l(o oVar, Runnable runnable, p.b bVar) {
        this.f11162a = oVar;
        this.f11163b = runnable;
        this.f11164c = bVar;
    }

    public final void run() {
        this.f11162a.f11169a.execute(new e(this.f11163b, this.f11164c));
    }
}
