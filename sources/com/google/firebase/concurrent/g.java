package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class g implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11144a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f11146c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f11147d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f11148e;

    public /* synthetic */ g(o oVar, Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        this.f11144a = oVar;
        this.f11145b = runnable;
        this.f11146c = j4;
        this.f11147d = j5;
        this.f11148e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.b(this.f11144a, this.f11145b, this.f11146c, this.f11147d, this.f11148e, bVar);
    }
}
