package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.jvm.kt", l = {93}, m = "invokeSuspend")
final class LifecycleCoroutineScope$launchWhenResumed$1 extends l implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScope$launchWhenResumed$1(LifecycleCoroutineScope lifecycleCoroutineScope, p pVar, d dVar) {
        super(2, dVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    public final d create(Object obj, d dVar) {
        return new LifecycleCoroutineScope$launchWhenResumed$1(this.this$0, this.$block, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
            p pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_common, pVar, (d) this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s.f8222a;
    }

    public final Object invoke(J j4, d dVar) {
        return ((LifecycleCoroutineScope$launchWhenResumed$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
