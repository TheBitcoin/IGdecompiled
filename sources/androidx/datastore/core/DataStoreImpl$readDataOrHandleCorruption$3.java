package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {395, 396, 398}, m = "invokeSuspend")
final class DataStoreImpl$readDataOrHandleCorruption$3 extends l implements d3.l {
    final /* synthetic */ C $newData;
    final /* synthetic */ A $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataOrHandleCorruption$3(C c5, DataStoreImpl<T> dataStoreImpl, A a5, d dVar) {
        super(1, dVar);
        this.$newData = c5;
        this.this$0 = dataStoreImpl;
        this.$version = a5;
    }

    public final d create(d dVar) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        A a5;
        A a6;
        C c5;
        Object c6 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            c5 = this.$newData;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.L$0 = c5;
            this.label = 1;
            obj = dataStoreImpl.readDataFromFileOrDefault(this);
            if (obj == c6) {
                return c6;
            }
        } else if (i4 == 1) {
            c5 = (C) this.L$0;
            n.b(obj);
        } else if (i4 == 2) {
            a6 = (A) this.L$0;
            try {
                n.b(obj);
                a6.f20966a = ((Number) obj).intValue();
            } catch (CorruptionException unused) {
                A a7 = this.$version;
                DataStoreImpl<T> dataStoreImpl2 = this.this$0;
                Object obj2 = this.$newData.f20968a;
                this.L$0 = a7;
                this.label = 3;
                Object writeData$datastore_core_release = dataStoreImpl2.writeData$datastore_core_release(obj2, true, this);
                if (writeData$datastore_core_release != c6) {
                    a5 = a7;
                    obj = writeData$datastore_core_release;
                }
            }
            return s.f8222a;
        } else if (i4 == 3) {
            a5 = (A) this.L$0;
            n.b(obj);
            a5.f20966a = ((Number) obj).intValue();
            return s.f8222a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c5.f20968a = obj;
        a6 = this.$version;
        InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
        this.L$0 = a6;
        this.label = 2;
        obj = access$getCoordinator.getVersion(this);
        if (obj == c6) {
            return c6;
        }
        a6.f20966a = ((Number) obj).intValue();
        return s.f8222a;
    }
}
