package androidx.datastore.core.okio;

import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {231, 137}, m = "writeScope")
final class OkioStorageConnection$writeScope$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioStorageConnection<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorageConnection$writeScope$1(OkioStorageConnection<T> okioStorageConnection, V2.d dVar) {
        super(dVar);
        this.this$0 = okioStorageConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeScope((p) null, this);
    }
}
