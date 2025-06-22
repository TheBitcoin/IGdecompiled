package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f11137a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f11138b;

    public /* synthetic */ e(Runnable runnable, p.b bVar) {
        this.f11137a = runnable;
        this.f11138b = bVar;
    }

    public final void run() {
        o.h(this.f11137a, this.f11138b);
    }
}
