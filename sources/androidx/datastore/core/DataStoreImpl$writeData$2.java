package androidx.datastore.core;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;

@f(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {360, 361}, m = "invokeSuspend")
final class DataStoreImpl$writeData$2 extends l implements p {
    final /* synthetic */ T $newData;
    final /* synthetic */ A $newVersion;
    final /* synthetic */ boolean $updateCache;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeData$2(A a5, DataStoreImpl<T> dataStoreImpl, T t4, boolean z4, d dVar) {
        super(2, dVar);
        this.$newVersion = a5;
        this.this$0 = dataStoreImpl;
        this.$newData = t4;
        this.$updateCache = z4;
    }

    public final d create(Object obj, d dVar) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.$newVersion, this.this$0, this.$newData, this.$updateCache, dVar);
        dataStoreImpl$writeData$2.L$0 = obj;
        return dataStoreImpl$writeData$2;
    }

    public final Object invoke(WriteScope<T> writeScope, d dVar) {
        return ((DataStoreImpl$writeData$2) create(writeScope, dVar)).invokeSuspend(s.f8222a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        if (r3.writeData(r7, r6) == r0) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            R2.n.b(r7)
            goto L_0x005d
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$1
            kotlin.jvm.internal.A r1 = (kotlin.jvm.internal.A) r1
            java.lang.Object r3 = r6.L$0
            androidx.datastore.core.WriteScope r3 = (androidx.datastore.core.WriteScope) r3
            R2.n.b(r7)
            goto L_0x0045
        L_0x0026:
            R2.n.b(r7)
            java.lang.Object r7 = r6.L$0
            androidx.datastore.core.WriteScope r7 = (androidx.datastore.core.WriteScope) r7
            kotlin.jvm.internal.A r1 = r6.$newVersion
            androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
            androidx.datastore.core.InterProcessCoordinator r4 = r4.getCoordinator()
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r3 = r4.incrementAndGetVersion(r6)
            if (r3 != r0) goto L_0x0042
            goto L_0x005c
        L_0x0042:
            r5 = r3
            r3 = r7
            r7 = r5
        L_0x0045:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r1.f20966a = r7
            T r7 = r6.$newData
            r1 = 0
            r6.L$0 = r1
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = r3.writeData(r7, r6)
            if (r7 != r0) goto L_0x005d
        L_0x005c:
            return r0
        L_0x005d:
            boolean r7 = r6.$updateCache
            if (r7 == 0) goto L_0x007d
            androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
            androidx.datastore.core.DataStoreInMemoryCache r7 = r7.inMemoryCache
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r6.$newData
            if (r1 == 0) goto L_0x0072
            int r2 = r1.hashCode()
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            kotlin.jvm.internal.A r3 = r6.$newVersion
            int r3 = r3.f20966a
            r0.<init>(r1, r2, r3)
            r7.tryUpdate(r0)
        L_0x007d:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
