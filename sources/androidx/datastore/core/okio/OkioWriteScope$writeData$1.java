package androidx.datastore.core.okio;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", l = {211}, m = "writeData")
final class OkioWriteScope$writeData$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioWriteScope<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioWriteScope$writeData$1(OkioWriteScope<T> okioWriteScope, V2.d dVar) {
        super(dVar);
        this.this$0 = okioWriteScope;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeData(null, this);
    }
}
