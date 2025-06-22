package o3;

import V2.g;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import t3.C1053c;

/* renamed from: o3.j0  reason: case insensitive filesystem */
public final class C0984j0 extends C0982i0 implements T {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f3710b;

    public C0984j0(Executor executor) {
        this.f3710b = executor;
        C1053c.a(F());
    }

    private final void D(g gVar, RejectedExecutionException rejectedExecutionException) {
        C1009w0.c(gVar, C0980h0.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture G(ScheduledExecutorService scheduledExecutorService, Runnable runnable, g gVar, long j4) {
        try {
            return scheduledExecutorService.schedule(runnable, j4, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            D(gVar, e5);
            return null;
        }
    }

    public Executor F() {
        return this.f3710b;
    }

    public void close() {
        ExecutorService executorService;
        Executor F4 = F();
        if (F4 instanceof ExecutorService) {
            executorService = (ExecutorService) F4;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public void dispatch(g gVar, Runnable runnable) {
        try {
            Executor F4 = F();
            C0969c.a();
            F4.execute(runnable);
        } catch (RejectedExecutionException e5) {
            C0969c.a();
            D(gVar, e5);
            Y.b().dispatch(gVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0984j0) || ((C0984j0) obj).F() != F()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(F());
    }

    public void n(long j4, C0989m mVar) {
        ScheduledExecutorService scheduledExecutorService;
        long j5;
        Executor F4 = F();
        ScheduledFuture scheduledFuture = null;
        if (F4 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) F4;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j5 = j4;
            scheduledFuture = G(scheduledExecutorService, new M0(this, mVar), mVar.getContext(), j5);
        } else {
            j5 = j4;
        }
        if (scheduledFuture != null) {
            C1009w0.e(mVar, scheduledFuture);
        } else {
            O.f3668g.n(j5, mVar);
        }
    }

    public String toString() {
        return F().toString();
    }
}
