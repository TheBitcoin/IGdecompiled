package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f11167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f11168b;

    public /* synthetic */ n(Callable callable, p.b bVar) {
        this.f11167a = callable;
        this.f11168b = bVar;
    }

    public final void run() {
        o.d(this.f11167a, this.f11168b);
    }
}
