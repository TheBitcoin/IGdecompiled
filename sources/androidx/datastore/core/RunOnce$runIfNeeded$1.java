package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {552, 505}, m = "runIfNeeded")
final class RunOnce$runIfNeeded$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RunOnce this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RunOnce$runIfNeeded$1(RunOnce runOnce, V2.d dVar) {
        super(dVar);
        this.this$0 = runOnce;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runIfNeeded(this);
    }
}
