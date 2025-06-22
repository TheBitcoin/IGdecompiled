package androidx.datastore.core;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import r3.C1036f;

@f(c = "androidx.datastore.core.DataStoreImpl$internalDataFlow$1", f = "DataStoreImpl.kt", l = {123, 125, 132}, m = "invokeSuspend")
final class DataStoreImpl$internalDataFlow$1 extends l implements p {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$internalDataFlow$1(DataStoreImpl<T> dataStoreImpl, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
    }

    public final d create(Object obj, d dVar) {
        DataStoreImpl$internalDataFlow$1 dataStoreImpl$internalDataFlow$1 = new DataStoreImpl$internalDataFlow$1(this.this$0, dVar);
        dataStoreImpl$internalDataFlow$1.L$0 = obj;
        return dataStoreImpl$internalDataFlow$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r3.C1037g.n(r1, r3, r7) == r0) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            R2.n.b(r8)
            goto L_0x00a7
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            java.lang.Object r1 = r7.L$1
            androidx.datastore.core.State r1 = (androidx.datastore.core.State) r1
            java.lang.Object r3 = r7.L$0
            r3.f r3 = (r3.C1036f) r3
            R2.n.b(r8)
            goto L_0x0066
        L_0x002a:
            java.lang.Object r1 = r7.L$0
            r3.f r1 = (r3.C1036f) r1
            R2.n.b(r8)
            goto L_0x004a
        L_0x0032:
            R2.n.b(r8)
            java.lang.Object r8 = r7.L$0
            r3.f r8 = (r3.C1036f) r8
            androidx.datastore.core.DataStoreImpl<T> r1 = r7.this$0
            r7.L$0 = r8
            r7.label = r4
            r4 = 0
            java.lang.Object r1 = r1.readState(r4, r7)
            if (r1 != r0) goto L_0x0047
            goto L_0x00a6
        L_0x0047:
            r6 = r1
            r1 = r8
            r8 = r6
        L_0x004a:
            androidx.datastore.core.State r8 = (androidx.datastore.core.State) r8
            boolean r4 = r8 instanceof androidx.datastore.core.Data
            if (r4 == 0) goto L_0x0069
            r4 = r8
            androidx.datastore.core.Data r4 = (androidx.datastore.core.Data) r4
            java.lang.Object r4 = r4.getValue()
            r7.L$0 = r1
            r7.L$1 = r8
            r7.label = r3
            java.lang.Object r3 = r1.emit(r4, r7)
            if (r3 != r0) goto L_0x0064
            goto L_0x00a6
        L_0x0064:
            r3 = r1
            r1 = r8
        L_0x0066:
            r8 = r1
            r1 = r3
            goto L_0x0078
        L_0x0069:
            boolean r3 = r8 instanceof androidx.datastore.core.UnInitialized
            if (r3 != 0) goto L_0x00b1
            boolean r3 = r8 instanceof androidx.datastore.core.ReadException
            if (r3 != 0) goto L_0x00aa
            boolean r3 = r8 instanceof androidx.datastore.core.Final
            if (r3 == 0) goto L_0x0078
            R2.s r8 = R2.s.f8222a
            return r8
        L_0x0078:
            androidx.datastore.core.DataStoreImpl<T> r3 = r7.this$0
            androidx.datastore.core.DataStoreInMemoryCache r3 = r3.inMemoryCache
            r3.e r3 = r3.getFlow()
            androidx.datastore.core.DataStoreImpl$internalDataFlow$1$1 r4 = new androidx.datastore.core.DataStoreImpl$internalDataFlow$1$1
            r5 = 0
            r4.<init>(r5)
            r3.e r3 = r3.C1037g.y(r3, r4)
            androidx.datastore.core.DataStoreImpl$internalDataFlow$1$2 r4 = new androidx.datastore.core.DataStoreImpl$internalDataFlow$1$2
            r4.<init>(r8, r5)
            r3.e r8 = r3.C1037g.l(r3, r4)
            androidx.datastore.core.DataStoreImpl$internalDataFlow$1$invokeSuspend$$inlined$map$1 r3 = new androidx.datastore.core.DataStoreImpl$internalDataFlow$1$invokeSuspend$$inlined$map$1
            r3.<init>(r8)
            r7.L$0 = r5
            r7.L$1 = r5
            r7.label = r2
            java.lang.Object r8 = r3.C1037g.n(r1, r3, r7)
            if (r8 != r0) goto L_0x00a7
        L_0x00a6:
            return r0
        L_0x00a7:
            R2.s r8 = R2.s.f8222a
            return r8
        L_0x00aa:
            androidx.datastore.core.ReadException r8 = (androidx.datastore.core.ReadException) r8
            java.lang.Throwable r8 = r8.getReadException()
            throw r8
        L_0x00b1:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$internalDataFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C1036f fVar, d dVar) {
        return ((DataStoreImpl$internalDataFlow$1) create(fVar, dVar)).invokeSuspend(s.f8222a);
    }
}
