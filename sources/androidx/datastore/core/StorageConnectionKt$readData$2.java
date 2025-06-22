package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
final class StorageConnectionKt$readData$2 extends l implements q {
    private /* synthetic */ Object L$0;
    int label;

    StorageConnectionKt$readData$2(d dVar) {
        super(3, dVar);
    }

    public final Object invoke(ReadScope<T> readScope, boolean z4, d dVar) {
        StorageConnectionKt$readData$2 storageConnectionKt$readData$2 = new StorageConnectionKt$readData$2(dVar);
        storageConnectionKt$readData$2.L$0 = readScope;
        return storageConnectionKt$readData$2.invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            this.label = 1;
            Object readData = ((ReadScope) this.L$0).readData(this);
            if (readData == c5) {
                return c5;
            }
            return readData;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (d) obj3);
    }
}
