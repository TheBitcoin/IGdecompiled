package androidx.work;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
final class CoroutineWorker$getForegroundInfoAsync$1 extends l implements p {
    final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
    Object L$0;
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, d dVar) {
        super(2, dVar);
        this.$jobFuture = jobListenableFuture;
        this.this$0 = coroutineWorker;
    }

    public final d create(Object obj, d dVar) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.$jobFuture, this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        JobListenableFuture<ForegroundInfo> jobListenableFuture;
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
            CoroutineWorker coroutineWorker = this.this$0;
            this.L$0 = jobListenableFuture2;
            this.label = 1;
            Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
            if (foregroundInfo == c5) {
                return c5;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = foregroundInfo;
        } else if (i4 == 1) {
            jobListenableFuture = (JobListenableFuture) this.L$0;
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        jobListenableFuture.complete(obj);
        return s.f8222a;
    }

    public final Object invoke(J j4, d dVar) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
