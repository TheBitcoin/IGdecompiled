package androidx.work;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.work.ListenableWorker;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
final class CoroutineWorker$startWork$1 extends l implements p {
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, d dVar) {
        super(2, dVar);
        this.this$0 = coroutineWorker;
    }

    public final d create(Object obj, d dVar) {
        return new CoroutineWorker$startWork$1(this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            CoroutineWorker coroutineWorker = this.this$0;
            this.label = 1;
            obj = coroutineWorker.doWork(this);
            if (obj == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            try {
                n.b(obj);
            } catch (Throwable th) {
                this.this$0.getFuture$work_runtime_release().setException(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getFuture$work_runtime_release().set((ListenableWorker.Result) obj);
        return s.f8222a;
    }

    public final Object invoke(J j4, d dVar) {
        return ((CoroutineWorker$startWork$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
