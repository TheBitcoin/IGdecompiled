package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1", f = "DataStoreImpl.kt", l = {339}, m = "invokeSuspend")
final class DataStoreImpl$transformAndWrite$2$newData$1 extends l implements p {
    final /* synthetic */ Data<T> $curData;
    final /* synthetic */ p $transform;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2$newData$1(p pVar, Data<T> data, d dVar) {
        super(2, dVar);
        this.$transform = pVar;
        this.$curData = data;
    }

    public final d create(Object obj, d dVar) {
        return new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, this.$curData, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            p pVar = this.$transform;
            T value = this.$curData.getValue();
            this.label = 1;
            Object invoke = pVar.invoke(value, this);
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

    public final Object invoke(J j4, d dVar) {
        return ((DataStoreImpl$transformAndWrite$2$newData$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
