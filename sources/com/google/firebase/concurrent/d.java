package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f11135a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f11136b;

    public /* synthetic */ d(Runnable runnable, p.b bVar) {
        this.f11135a = runnable;
        this.f11136b = bVar;
    }

    public final void run() {
        o.e(this.f11135a, this.f11136b);
    }
}
