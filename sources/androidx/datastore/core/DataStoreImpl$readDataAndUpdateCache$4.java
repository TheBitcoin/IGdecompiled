package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {314, 317}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$4 extends l implements p {
    final /* synthetic */ int $cachedVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl<T> dataStoreImpl, int i4, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
        this.$cachedVersion = i4;
    }

    public final d create(Object obj, d dVar) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.this$0, this.$cachedVersion, dVar);
        dataStoreImpl$readDataAndUpdateCache$4.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (d) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        State state;
        boolean z4;
        int i4;
        Throwable th;
        boolean z5;
        Object c5 = b.c();
        int i5 = this.label;
        if (i5 == 0) {
            n.b(obj);
            z4 = this.Z$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.Z$0 = z4;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(z4, this);
            if (obj == c5) {
                return c5;
            }
        } else if (i5 == 1) {
            z4 = this.Z$0;
            try {
                n.b(obj);
            } catch (Throwable th2) {
                if (z4) {
                    InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
                    this.L$0 = th2;
                    this.Z$0 = z4;
                    this.label = 2;
                    Object version = access$getCoordinator.getVersion(this);
                    if (version != c5) {
                        z5 = z4;
                        th = th2;
                        obj = version;
                    }
                } else {
                    boolean z6 = z4;
                    th = th2;
                    i4 = this.$cachedVersion;
                    z5 = z6;
                }
            }
        } else if (i5 == 2) {
            z5 = this.Z$0;
            th = (Throwable) this.L$0;
            n.b(obj);
            i4 = ((Number) obj).intValue();
            ReadException readException = new ReadException(th, i4);
            z4 = z5;
            state = readException;
            return R2.p.a(state, kotlin.coroutines.jvm.internal.b.a(z4));
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        state = (State) obj;
        return R2.p.a(state, kotlin.coroutines.jvm.internal.b.a(z4));
    }

    public final Object invoke(boolean z4, d dVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z4), dVar)).invokeSuspend(s.f8222a);
    }
}
