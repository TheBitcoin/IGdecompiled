package androidx.datastore.core;

import d3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {66, 41}, m = "lock")
final class SingleProcessCoordinator$lock$1<T> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessCoordinator$lock$1(SingleProcessCoordinator singleProcessCoordinator, V2.d dVar) {
        super(dVar);
        this.this$0 = singleProcessCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.lock((l) null, this);
    }
}
