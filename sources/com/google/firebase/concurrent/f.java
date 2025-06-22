package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class f implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f11139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f11140b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f11141c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f11142d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f11143e;

    public /* synthetic */ f(o oVar, Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        this.f11139a = oVar;
        this.f11140b = runnable;
        this.f11141c = j4;
        this.f11142d = j5;
        this.f11143e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.c(this.f11139a, this.f11140b, this.f11141c, this.f11142d, this.f11143e, bVar);
    }
}
