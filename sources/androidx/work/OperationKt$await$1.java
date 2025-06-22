package androidx.work;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.work.OperationKt", f = "Operation.kt", l = {39}, m = "await")
final class OperationKt$await$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    OperationKt$await$1(V2.d dVar) {
        super(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await((Operation) null, this);
    }
}
