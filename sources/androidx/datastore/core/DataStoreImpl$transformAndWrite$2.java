package androidx.datastore.core;

import R2.s;
import V2.d;
import V2.g;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {338, 339, 345}, m = "invokeSuspend")
final class DataStoreImpl$transformAndWrite$2 extends l implements d3.l {
    final /* synthetic */ g $callerContext;
    final /* synthetic */ p $transform;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2(DataStoreImpl<T> dataStoreImpl, g gVar, p pVar, d dVar) {
        super(1, dVar);
        this.this$0 = dataStoreImpl;
        this.$callerContext = gVar;
        this.$transform = pVar;
    }

    public final d create(d dVar) {
        return new DataStoreImpl$transformAndWrite$2(this.this$0, this.$callerContext, this.$transform, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataStoreImpl$transformAndWrite$2) create(dVar)).invokeSuspend(s.f8222a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r9 == r0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r9 == r0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r4) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r8.L$0
            R2.n.b(r9)
            return r0
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            java.lang.Object r1 = r8.L$0
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            R2.n.b(r9)
            goto L_0x0051
        L_0x0027:
            R2.n.b(r9)
            goto L_0x0039
        L_0x002b:
            R2.n.b(r9)
            androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
            r8.label = r4
            java.lang.Object r9 = r9.readDataOrHandleCorruption(r4, r8)
            if (r9 != r0) goto L_0x0039
            goto L_0x006a
        L_0x0039:
            r1 = r9
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            V2.g r9 = r8.$callerContext
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            d3.p r6 = r8.$transform
            r7 = 0
            r5.<init>(r6, r1, r7)
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = o3.C0977g.g(r9, r5, r8)
            if (r9 != r0) goto L_0x0051
            goto L_0x006a
        L_0x0051:
            r1.checkHashCode()
            java.lang.Object r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.m.a(r1, r9)
            if (r1 != 0) goto L_0x006b
            androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
            r8.L$0 = r9
            r8.label = r2
            java.lang.Object r1 = r1.writeData$datastore_core_release(r9, r4, r8)
            if (r1 != r0) goto L_0x006b
        L_0x006a:
            return r0
        L_0x006b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
