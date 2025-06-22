package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11149a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f11150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f11151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f11152d;

    public /* synthetic */ h(o oVar, Callable callable, long j4, TimeUnit timeUnit) {
        this.f11149a = oVar;
        this.f11150b = callable;
        this.f11151c = j4;
        this.f11152d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f11149a.f11170b.schedule(new k(this.f11149a, this.f11150b, bVar), this.f11151c, this.f11152d);
    }
}
