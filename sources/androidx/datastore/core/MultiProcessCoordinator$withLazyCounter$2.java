package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", l = {163}, m = "invokeSuspend")
public final class MultiProcessCoordinator$withLazyCounter$2 extends l implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$withLazyCounter$2(p pVar, MultiProcessCoordinator multiProcessCoordinator, d dVar) {
        super(2, dVar);
        this.$block = pVar;
        this.this$0 = multiProcessCoordinator;
    }

    public final d create(Object obj, d dVar) {
        return new MultiProcessCoordinator$withLazyCounter$2(this.$block, this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            p pVar = this.$block;
            SharedCounter access$getSharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object invoke = pVar.invoke(access$getSharedCounter, this);
            if (invoke == c5) {
                return c5;
            }
            return invoke;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke(this.this$0.getSharedCounter(), this);
    }

    public final Object invoke(J j4, d dVar) {
        return ((MultiProcessCoordinator$withLazyCounter$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
