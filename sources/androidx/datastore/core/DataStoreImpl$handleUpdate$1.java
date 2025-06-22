package androidx.datastore.core;

import androidx.datastore.core.Message;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {245, 251, 254}, m = "handleUpdate")
final class DataStoreImpl$handleUpdate$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$handleUpdate$1(DataStoreImpl<T> dataStoreImpl, V2.d dVar) {
        super(dVar);
        this.this$0 = dataStoreImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleUpdate((Message.Update) null, this);
    }
}
