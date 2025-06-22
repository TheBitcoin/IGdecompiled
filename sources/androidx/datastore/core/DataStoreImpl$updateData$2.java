package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.datastore.core.Message;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C1001s0;
import o3.C1006v;
import o3.C1010x;
import o3.J;

@f(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {177}, m = "invokeSuspend")
final class DataStoreImpl$updateData$2 extends l implements p {
    final /* synthetic */ p $transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$updateData$2(DataStoreImpl<T> dataStoreImpl, p pVar, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
        this.$transform = pVar;
    }

    public final d create(Object obj, d dVar) {
        DataStoreImpl$updateData$2 dataStoreImpl$updateData$2 = new DataStoreImpl$updateData$2(this.this$0, this.$transform, dVar);
        dataStoreImpl$updateData$2.L$0 = obj;
        return dataStoreImpl$updateData$2;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            C1006v b5 = C1010x.b((C1001s0) null, 1, (Object) null);
            this.this$0.writeActor.offer(new Message.Update(this.$transform, b5, this.this$0.inMemoryCache.getCurrentState(), ((J) this.L$0).getCoroutineContext()));
            this.label = 1;
            Object p4 = b5.p(this);
            if (p4 == c5) {
                return c5;
            }
            return p4;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(J j4, d dVar) {
        return ((DataStoreImpl$updateData$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
