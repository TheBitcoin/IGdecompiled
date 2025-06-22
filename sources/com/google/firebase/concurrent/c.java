package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class c implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11131a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f11133c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f11134d;

    public /* synthetic */ c(o oVar, Runnable runnable, long j4, TimeUnit timeUnit) {
        this.f11131a = oVar;
        this.f11132b = runnable;
        this.f11133c = j4;
        this.f11134d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f11131a.f11170b.schedule(new j(this.f11131a, this.f11132b, bVar), this.f11133c, this.f11134d);
    }
}
