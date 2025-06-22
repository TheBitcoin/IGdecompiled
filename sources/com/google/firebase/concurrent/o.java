package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class o implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f11169a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f11170b;

    o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f11169a = executorService;
        this.f11170b = scheduledExecutorService;
    }

    public static /* synthetic */ ScheduledFuture b(o oVar, Runnable runnable, long j4, long j5, TimeUnit timeUnit, p.b bVar) {
        o oVar2 = oVar;
        return oVar2.f11170b.scheduleWithFixedDelay(new l(oVar2, runnable, bVar), j4, j5, timeUnit);
    }

    public static /* synthetic */ ScheduledFuture c(o oVar, Runnable runnable, long j4, long j5, TimeUnit timeUnit, p.b bVar) {
        o oVar2 = oVar;
        return oVar2.f11170b.scheduleAtFixedRate(new i(oVar2, runnable, bVar), j4, j5, timeUnit);
    }

    public static /* synthetic */ void d(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    public static /* synthetic */ void e(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e5) {
            bVar.a(e5);
            throw e5;
        }
    }

    public static /* synthetic */ void h(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    public static /* synthetic */ void j(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set((Object) null);
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    public boolean awaitTermination(long j4, TimeUnit timeUnit) {
        return this.f11169a.awaitTermination(j4, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f11169a.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.f11169a.invokeAll(collection);
    }

    public Object invokeAny(Collection collection) {
        return this.f11169a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f11169a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f11169a.isTerminated();
    }

    public ScheduledFuture schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        return new p(new c(this, runnable, j4, timeUnit));
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return new p(new f(this, runnable, j4, j5, timeUnit));
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return new p(new g(this, runnable, j4, j5, timeUnit));
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public Future submit(Callable callable) {
        return this.f11169a.submit(callable);
    }

    public List invokeAll(Collection collection, long j4, TimeUnit timeUnit) {
        return this.f11169a.invokeAll(collection, j4, timeUnit);
    }

    public Object invokeAny(Collection collection, long j4, TimeUnit timeUnit) {
        return this.f11169a.invokeAny(collection, j4, timeUnit);
    }

    public ScheduledFuture schedule(Callable callable, long j4, TimeUnit timeUnit) {
        return new p(new h(this, callable, j4, timeUnit));
    }

    public Future submit(Runnable runnable, Object obj) {
        return this.f11169a.submit(runnable, obj);
    }

    public Future submit(Runnable runnable) {
        return this.f11169a.submit(runnable);
    }
}
