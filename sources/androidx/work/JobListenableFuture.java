package androidx.work;

import R2.s;
import androidx.work.impl.utils.futures.SettableFuture;
import d3.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.C1001s0;

public final class JobListenableFuture<R> implements C2172d {
    private final C1001s0 job;
    /* access modifiers changed from: private */
    public final SettableFuture<R> underlying;

    public JobListenableFuture(C1001s0 s0Var, SettableFuture<R> settableFuture) {
        m.e(s0Var, "job");
        m.e(settableFuture, "underlying");
        this.job = s0Var;
        this.underlying = settableFuture;
        s0Var.i(new l(this) {
            final /* synthetic */ JobListenableFuture<R> this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return s.f8222a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    if (!this.this$0.underlying.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else if (th instanceof CancellationException) {
                    this.this$0.underlying.cancel(true);
                } else {
                    SettableFuture access$getUnderlying$p = this.this$0.underlying;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    access$getUnderlying$p.setException(th);
                }
            }
        });
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    public boolean cancel(boolean z4) {
        return this.underlying.cancel(z4);
    }

    public final void complete(R r4) {
        this.underlying.set(r4);
    }

    public R get() {
        return this.underlying.get();
    }

    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    public boolean isDone() {
        return this.underlying.isDone();
    }

    public R get(long j4, TimeUnit timeUnit) {
        return this.underlying.get(j4, timeUnit);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JobListenableFuture(o3.C1001s0 r1, androidx.work.impl.utils.futures.SettableFuture r2, int r3, kotlin.jvm.internal.C2103g r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            androidx.work.impl.utils.futures.SettableFuture r2 = androidx.work.impl.utils.futures.SettableFuture.create()
            java.lang.String r3 = "create()"
            kotlin.jvm.internal.m.d(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.JobListenableFuture.<init>(o3.s0, androidx.work.impl.utils.futures.SettableFuture, int, kotlin.jvm.internal.g):void");
    }
}
