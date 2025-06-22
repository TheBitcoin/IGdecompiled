package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f11124a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11125b;

    public /* synthetic */ a(b bVar, Runnable runnable) {
        this.f11124a = bVar;
        this.f11125b = runnable;
    }

    public final void run() {
        b.a(this.f11124a, this.f11125b);
    }
}
