package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class P2 extends C0905z3 {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicLong f2674l = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public T2 f2675c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public T2 f2676d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue f2677e = new PriorityBlockingQueue();

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f2678f = new LinkedBlockingQueue();

    /* renamed from: g  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f2679g = new R2(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f2680h = new R2(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Object f2681i = new Object();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Semaphore f2682j = new Semaphore(2);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f2683k;

    P2(S2 s22) {
        super(s22);
    }

    private final void v(Q2 q22) {
        synchronized (this.f2681i) {
            try {
                this.f2677e.add(q22);
                T2 t22 = this.f2675c;
                if (t22 == null) {
                    T2 t23 = new T2(this, "Measurement Worker", this.f2677e);
                    this.f2675c = t23;
                    t23.setUncaughtExceptionHandler(this.f2679g);
                    this.f2675c.start();
                } else {
                    t22.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final void D(Runnable runnable) {
        m();
        C0335p.l(runnable);
        v(new Q2(this, runnable, false, "Task exception on worker thread"));
    }

    public final void G(Runnable runnable) {
        m();
        C0335p.l(runnable);
        v(new Q2(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean J() {
        if (Thread.currentThread() == this.f2675c) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final void i() {
        if (Thread.currentThread() != this.f2676d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final void k() {
        if (Thread.currentThread() != this.f2675c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3 = a().L();
        r3.a("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r2 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = a().L();
        r3.a("Timed out waiting for " + r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.P2 r0 = r1.f()     // Catch:{ all -> 0x002c }
            r0.D(r6)     // Catch:{ all -> 0x002c }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x002b
            com.google.android.gms.measurement.internal.n2 r3 = r1.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Timed out waiting for "
            r4.<init>(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.a(r4)
        L_0x002b:
            return r2
        L_0x002c:
            r3 = move-exception
            goto L_0x004a
        L_0x002e:
            com.google.android.gms.measurement.internal.n2 r3 = r1.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            java.lang.String r6 = "Interrupted waiting for "
            r4.<init>(r6)     // Catch:{ all -> 0x002c }
            r4.append(r5)     // Catch:{ all -> 0x002c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r4)     // Catch:{ all -> 0x002c }
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            r2 = 0
            return r2
        L_0x004a:
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.P2.s(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final Future t(Callable callable) {
        m();
        C0335p.l(callable);
        Q2 q22 = new Q2(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f2675c) {
            if (!this.f2677e.isEmpty()) {
                a().L().a("Callable skipped the worker queue.");
            }
            q22.run();
            return q22;
        }
        v(q22);
        return q22;
    }

    public final void w(Runnable runnable) {
        m();
        C0335p.l(runnable);
        Q2 q22 = new Q2(this, runnable, false, "Task exception on network thread");
        synchronized (this.f2681i) {
            try {
                this.f2678f.add(q22);
                T2 t22 = this.f2676d;
                if (t22 == null) {
                    T2 t23 = new T2(this, "Measurement Network", this.f2678f);
                    this.f2676d = t23;
                    t23.setUncaughtExceptionHandler(this.f2680h);
                    this.f2676d.start();
                } else {
                    t22.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Future y(Callable callable) {
        m();
        C0335p.l(callable);
        Q2 q22 = new Q2(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f2675c) {
            q22.run();
            return q22;
        }
        v(q22);
        return q22;
    }
}
