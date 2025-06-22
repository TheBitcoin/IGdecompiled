package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f11160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f11161c;

    public /* synthetic */ k(o oVar, Callable callable, p.b bVar) {
        this.f11159a = oVar;
        this.f11160b = callable;
        this.f11161c = bVar;
    }

    public final Object call() {
        return this.f11159a.f11169a.submit(new n(this.f11160b, this.f11161c));
    }
}
