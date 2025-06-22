package androidx.datastore.core;

import R2.n;
import R2.p;
import R2.s;
import V2.d;
import W2.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {306, 308}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$3 extends l implements d3.l {
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$3(DataStoreImpl<T> dataStoreImpl, d dVar) {
        super(1, dVar);
        this.this$0 = dataStoreImpl;
    }

    public final d create(d dVar) {
        return new DataStoreImpl$readDataAndUpdateCache$3(this.this$0, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$3) create(dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        State state;
        Throwable th;
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
            if (obj == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            try {
                n.b(obj);
            } catch (Throwable th2) {
                InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.label = 2;
                Object version = access$getCoordinator.getVersion(this);
                if (version != c5) {
                    th = th2;
                    obj = version;
                }
            }
        } else if (i4 == 2) {
            th = (Throwable) this.L$0;
            n.b(obj);
            state = new ReadException(th, ((Number) obj).intValue());
            return p.a(state, kotlin.coroutines.jvm.internal.b.a(true));
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        state = (State) obj;
        return p.a(state, kotlin.coroutines.jvm.internal.b.a(true));
    }
}
