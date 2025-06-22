package androidx.work;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.C0991n;
import o3.C1001s0;
import o3.C1012y;
import o3.G;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public abstract class CoroutineWorker extends ListenableWorker {
    private final G coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final C1012y job = C1013y0.b((C1001s0) null, 1, (Object) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "appContext");
        m.e(workerParameters, "params");
        SettableFuture<ListenableWorker.Result> create = SettableFuture.create();
        m.d(create, "create()");
        this.future = create;
        create.addListener(new a(this), getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = Y.a();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(CoroutineWorker coroutineWorker) {
        m.e(coroutineWorker, "this$0");
        if (coroutineWorker.future.isCancelled()) {
            C1001s0.a.a(coroutineWorker.job, (CancellationException) null, 1, (Object) null);
        }
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, d dVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(d dVar);

    public G getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(d dVar) {
        return getForegroundInfo$suspendImpl(this, dVar);
    }

    public final C2172d getForegroundInfoAsync() {
        C1012y b5 = C1013y0.b((C1001s0) null, 1, (Object) null);
        J a5 = K.a(getCoroutineContext().plus(b5));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(b5, (SettableFuture) null, 2, (C2103g) null);
        C1001s0 unused = C0981i.d(a5, (g) null, (L) null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, (d) null), 3, (Object) null);
        return jobListenableFuture;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_release() {
        return this.future;
    }

    public final C1012y getJob$work_runtime_release() {
        return this.job;
    }

    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, d dVar) {
        C2172d foregroundAsync = setForegroundAsync(foregroundInfo);
        m.d(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                foregroundAsync.get();
            } catch (ExecutionException e5) {
                e = e5;
                Throwable cause = e.getCause();
                if (cause != null) {
                    e = cause;
                }
                throw e;
            }
        } else {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(nVar, foregroundAsync), DirectExecutor.INSTANCE);
            nVar.q(new ListenableFutureKt$await$2$2(foregroundAsync));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
        }
        return s.f8222a;
    }

    public final Object setProgress(Data data, d dVar) {
        C2172d progressAsync = setProgressAsync(data);
        m.d(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e5) {
                e = e5;
                Throwable cause = e.getCause();
                if (cause != null) {
                    e = cause;
                }
                throw e;
            }
        } else {
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(nVar, progressAsync), DirectExecutor.INSTANCE);
            nVar.q(new ListenableFutureKt$await$2$2(progressAsync));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar);
            }
            if (v4 == b.c()) {
                return v4;
            }
        }
        return s.f8222a;
    }

    public final C2172d startWork() {
        C1001s0 unused = C0981i.d(K.a(getCoroutineContext().plus(this.job)), (g) null, (L) null, new CoroutineWorker$startWork$1(this, (d) null), 3, (Object) null);
        return this.future;
    }
}
