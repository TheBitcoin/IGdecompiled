package androidx.datastore.core;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import r3.C1036f;

@f(c = "androidx.datastore.core.DataStoreImpl$updateCollection$1", f = "DataStoreImpl.kt", l = {80, 81}, m = "invokeSuspend")
final class DataStoreImpl$updateCollection$1 extends l implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$updateCollection$1(DataStoreImpl<T> dataStoreImpl, d dVar) {
        super(2, dVar);
        this.this$0 = dataStoreImpl;
    }

    public final d create(Object obj, d dVar) {
        return new DataStoreImpl$updateCollection$1(this.this$0, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
        if (r5.collect(r1, r4) == r0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r5.awaitComplete(r4) == r0) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            R2.n.b(r5)
            goto L_0x004e
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            R2.n.b(r5)
            goto L_0x0030
        L_0x001e:
            R2.n.b(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreImpl$InitDataStore r5 = r5.readAndInit
            r4.label = r3
            java.lang.Object r5 = r5.awaitComplete(r4)
            if (r5 != r0) goto L_0x0030
            goto L_0x004d
        L_0x0030:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = r5.getCoordinator()
            r3.e r5 = r5.getUpdateNotifications()
            r3.e r5 = r3.C1037g.j(r5)
            androidx.datastore.core.DataStoreImpl$updateCollection$1$1 r1 = new androidx.datastore.core.DataStoreImpl$updateCollection$1$1
            androidx.datastore.core.DataStoreImpl<T> r3 = r4.this$0
            r1.<init>(r3)
            r4.label = r2
            java.lang.Object r5 = r5.collect(r1, r4)
            if (r5 != r0) goto L_0x004e
        L_0x004d:
            return r0
        L_0x004e:
            R2.s r5 = R2.s.f8222a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$updateCollection$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C1036f fVar, d dVar) {
        return ((DataStoreImpl$updateCollection$1) create(fVar, dVar)).invokeSuspend(s.f8222a);
    }
}
