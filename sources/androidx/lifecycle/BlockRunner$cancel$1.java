package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C1001s0;
import o3.J;
import o3.U;

@f(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {188}, m = "invokeSuspend")
final class BlockRunner$cancel$1 extends l implements p {
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockRunner$cancel$1(BlockRunner<T> blockRunner, d dVar) {
        super(2, dVar);
        this.this$0 = blockRunner;
    }

    public final d create(Object obj, d dVar) {
        return new BlockRunner$cancel$1(this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            long access$getTimeoutInMs$p = this.this$0.timeoutInMs;
            this.label = 1;
            if (U.b(access$getTimeoutInMs$p, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.this$0.liveData.hasActiveObservers()) {
            C1001s0 access$getRunningJob$p = this.this$0.runningJob;
            if (access$getRunningJob$p != null) {
                C1001s0.a.a(access$getRunningJob$p, (CancellationException) null, 1, (Object) null);
            }
            this.this$0.runningJob = null;
        }
        return s.f8222a;
    }

    public final Object invoke(J j4, d dVar) {
        return ((BlockRunner$cancel$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
