package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f11165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f11166b;

    public /* synthetic */ m(Runnable runnable, p.b bVar) {
        this.f11165a = runnable;
        this.f11166b = bVar;
    }

    public final void run() {
        o.j(this.f11165a, this.f11166b);
    }
}
