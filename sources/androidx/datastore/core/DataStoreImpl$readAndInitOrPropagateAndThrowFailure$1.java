package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {272, 274}, m = "readAndInitOrPropagateAndThrowFailure")
final class DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 extends d {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1(DataStoreImpl<T> dataStoreImpl, V2.d dVar) {
        super(dVar);
        this.this$0 = dataStoreImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
    }
}
