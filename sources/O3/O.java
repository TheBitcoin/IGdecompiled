package o3;

import j3.e;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.m;
import o3.C0972d0;

public final class O extends C0972d0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g  reason: collision with root package name */
    public static final O f3668g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f3669h;

    static {
        Long l4;
        O o4 = new O();
        f3668g = o4;
        C0970c0.K(o4, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f3669h = timeUnit.toNanos(l4.longValue());
    }

    private O() {
    }

    private final synchronized void f0() {
        if (i0()) {
            debugStatus = 3;
            a0();
            m.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread g0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean h0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean i0() {
        int i4 = debugStatus;
        if (i4 == 2 || i4 == 3) {
            return true;
        }
        return false;
    }

    private final synchronized boolean j0() {
        if (i0()) {
            return false;
        }
        debugStatus = 1;
        m.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void k0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    /* access modifiers changed from: protected */
    public Thread Q() {
        Thread thread = _thread;
        if (thread == null) {
            return g0();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    public void R(long j4, C0972d0.b bVar) {
        k0();
    }

    public void W(Runnable runnable) {
        if (h0()) {
            k0();
        }
        super.W(runnable);
    }

    public void run() {
        S0.f3672a.d(this);
        C0969c.a();
        try {
            if (j0()) {
                long j4 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long N4 = N();
                    if (N4 == Long.MAX_VALUE) {
                        C0969c.a();
                        long nanoTime = System.nanoTime();
                        if (j4 == Long.MAX_VALUE) {
                            j4 = f3669h + nanoTime;
                        }
                        long j5 = j4 - nanoTime;
                        if (j5 <= 0) {
                            _thread = null;
                            f0();
                            C0969c.a();
                            if (!Y()) {
                                Q();
                                return;
                            }
                            return;
                        }
                        N4 = e.d(N4, j5);
                    } else {
                        j4 = Long.MAX_VALUE;
                    }
                    if (N4 > 0) {
                        if (i0()) {
                            _thread = null;
                            f0();
                            C0969c.a();
                            if (!Y()) {
                                Q();
                                return;
                            }
                            return;
                        }
                        C0969c.a();
                        LockSupport.parkNanos(this, N4);
                    }
                }
            }
        } finally {
            _thread = null;
            f0();
            C0969c.a();
            if (!Y()) {
                Q();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
