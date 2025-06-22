package androidx.datastore.core;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", l = {226, 234}, m = "invokeSuspend")
final class DataStoreImpl$readState$2 extends l implements p {
    final /* synthetic */ boolean $requireLock;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readState$2(DataStoreImpl<T> dataStoreImpl, boolean z4, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
        this.$requireLock = z4;
    }

    public final d create(Object obj, d dVar) {
        return new DataStoreImpl$readState$2(this.this$0, this.$requireLock, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r5.readAndInitOrPropagateAndThrowFailure(r4) == r0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r5 == r0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            R2.n.b(r5)
            goto L_0x0054
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            R2.n.b(r5)     // Catch:{ all -> 0x001e }
            goto L_0x0047
        L_0x001e:
            r5 = move-exception
            goto L_0x0057
        L_0x0020:
            R2.n.b(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = r5.inMemoryCache
            androidx.datastore.core.State r5 = r5.getCurrentState()
            boolean r5 = r5 instanceof androidx.datastore.core.Final
            if (r5 == 0) goto L_0x003c
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = r5.inMemoryCache
            androidx.datastore.core.State r5 = r5.getCurrentState()
            return r5
        L_0x003c:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0     // Catch:{ all -> 0x001e }
            r4.label = r3     // Catch:{ all -> 0x001e }
            java.lang.Object r5 = r5.readAndInitOrPropagateAndThrowFailure(r4)     // Catch:{ all -> 0x001e }
            if (r5 != r0) goto L_0x0047
            goto L_0x0053
        L_0x0047:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            boolean r1 = r4.$requireLock
            r4.label = r2
            java.lang.Object r5 = r5.readDataAndUpdateCache(r1, r4)
            if (r5 != r0) goto L_0x0054
        L_0x0053:
            return r0
        L_0x0054:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            return r5
        L_0x0057:
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r1 = -1
            r0.<init>(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(J j4, d dVar) {
        return ((DataStoreImpl$readState$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
