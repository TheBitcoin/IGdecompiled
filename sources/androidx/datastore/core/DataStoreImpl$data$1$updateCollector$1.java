package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;
import r3.x;

@f(c = "androidx.datastore.core.DataStoreImpl$data$1$updateCollector$1", f = "DataStoreImpl.kt", l = {152}, m = "invokeSuspend")
final class DataStoreImpl$data$1$updateCollector$1 extends l implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$data$1$updateCollector$1(DataStoreImpl<T> dataStoreImpl, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
    }

    public final d create(Object obj, d dVar) {
        return new DataStoreImpl$data$1$updateCollector$1(this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            x access$getUpdateCollection$p = this.this$0.updateCollection;
            AnonymousClass1<T> r12 = AnonymousClass1.INSTANCE;
            this.label = 1;
            if (access$getUpdateCollection$p.collect(r12, this) == c5) {
                return c5;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            n.b(obj);
        }
        throw new R2.d();
    }

    public final Object invoke(J j4, d dVar) {
        return ((DataStoreImpl$data$1$updateCollector$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
