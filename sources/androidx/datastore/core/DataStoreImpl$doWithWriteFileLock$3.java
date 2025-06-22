package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {424}, m = "invokeSuspend")
final class DataStoreImpl$doWithWriteFileLock$3 extends l implements d3.l {
    final /* synthetic */ d3.l $block;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$doWithWriteFileLock$3(d3.l lVar, d dVar) {
        super(1, dVar);
        this.$block = lVar;
    }

    public final d create(d dVar) {
        return new DataStoreImpl$doWithWriteFileLock$3(this.$block, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataStoreImpl$doWithWriteFileLock$3) create(dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            d3.l lVar = this.$block;
            this.label = 1;
            Object invoke = lVar.invoke(this);
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
}
