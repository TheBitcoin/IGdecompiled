package com.mbridge.msdk.tracker.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private volatile ThreadPoolExecutor f15654a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f15655b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final Set<u<?>> f15656c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<u<?>> f15657d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f15658e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f15659f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final n f15660g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final x f15661h;

    /* renamed from: i  reason: collision with root package name */
    private final List<a> f15662i = new ArrayList();

    public interface a {
        void a(u<?> uVar, int i4);
    }

    public v(n nVar, x xVar, int i4, b bVar) {
        this.f15658e = i4;
        this.f15659f = bVar;
        this.f15660g = nVar;
        this.f15661h = xVar;
    }

    private void a(int i4) {
        if (this.f15654a == null) {
            try {
                b(i4);
                if (this.f15654a != null) {
                    this.f15654a.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable unused) {
                try {
                    b(5);
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    if (this.f15654a != null) {
                        this.f15654a.allowCoreThreadTimeOut(true);
                    }
                    throw th;
                }
                if (this.f15654a != null) {
                    this.f15654a.allowCoreThreadTimeOut(true);
                }
            }
        }
    }

    private void b(int i4) {
        int i5 = i4;
        this.f15654a = new ThreadPoolExecutor(i5, i4, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "NetworkDispatcher");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    /* access modifiers changed from: package-private */
    public final <T> void b(u<T> uVar) {
        synchronized (this.f15656c) {
            this.f15656c.remove(uVar);
        }
        a(uVar, 5);
    }

    public final <T> u<T> a(u<T> uVar) {
        uVar.a(this);
        synchronized (this.f15656c) {
            this.f15656c.add(uVar);
        }
        uVar.c(this.f15655b.incrementAndGet());
        a(uVar, 0);
        this.f15657d.add(uVar);
        if (this.f15654a == null) {
            a(this.f15658e);
        }
        this.f15654a.execute(new Runnable() {
            public final void run() {
                try {
                    new o(v.this.f15657d, v.this.f15660g, v.this.f15659f, v.this.f15661h).run();
                } catch (Throwable unused) {
                }
            }
        });
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(u<?> uVar, int i4) {
        synchronized (this.f15662i) {
            try {
                for (a a5 : this.f15662i) {
                    a5.a(uVar, i4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        this.f15654a = null;
        a(this.f15658e);
    }
}
