package androidx.datastore.core;

import R2.s;
import V2.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", l = {445, 466, 554, 476}, m = "invokeSuspend")
final class DataStoreImpl$InitDataStore$doRun$initData$1 extends l implements d3.l {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;
    final /* synthetic */ DataStoreImpl<T>.InitDataStore this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl<T> dataStoreImpl, DataStoreImpl<T>.InitDataStore initDataStore, d dVar) {
        super(1, dVar);
        this.this$0 = dataStoreImpl;
        this.this$1 = initDataStore;
    }

    public final d create(d dVar) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this.this$1, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create(dVar)).invokeSuspend(s.f8222a);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r12.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0064
            if (r1 == r6) goto L_0x0050
            if (r1 == r5) goto L_0x0038
            if (r1 == r4) goto L_0x0027
            if (r1 != r3) goto L_0x001f
            int r0 = r12.I$0
            java.lang.Object r1 = r12.L$0
            R2.n.b(r13)
            goto L_0x0110
        L_0x001f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0027:
            java.lang.Object r1 = r12.L$2
            x3.a r1 = (x3.a) r1
            java.lang.Object r4 = r12.L$1
            kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
            java.lang.Object r5 = r12.L$0
            kotlin.jvm.internal.z r5 = (kotlin.jvm.internal.z) r5
            R2.n.b(r13)
            goto L_0x00e9
        L_0x0038:
            java.lang.Object r1 = r12.L$4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r8 = r12.L$3
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1 r8 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1) r8
            java.lang.Object r9 = r12.L$2
            kotlin.jvm.internal.C r9 = (kotlin.jvm.internal.C) r9
            java.lang.Object r10 = r12.L$1
            kotlin.jvm.internal.z r10 = (kotlin.jvm.internal.z) r10
            java.lang.Object r11 = r12.L$0
            x3.a r11 = (x3.a) r11
            R2.n.b(r13)
            goto L_0x00ab
        L_0x0050:
            java.lang.Object r1 = r12.L$3
            kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
            java.lang.Object r8 = r12.L$2
            kotlin.jvm.internal.C r8 = (kotlin.jvm.internal.C) r8
            java.lang.Object r9 = r12.L$1
            kotlin.jvm.internal.z r9 = (kotlin.jvm.internal.z) r9
            java.lang.Object r10 = r12.L$0
            x3.a r10 = (x3.a) r10
            R2.n.b(r13)
            goto L_0x008a
        L_0x0064:
            R2.n.b(r13)
            x3.a r10 = x3.c.b(r2, r6, r7)
            kotlin.jvm.internal.z r9 = new kotlin.jvm.internal.z
            r9.<init>()
            kotlin.jvm.internal.C r1 = new kotlin.jvm.internal.C
            r1.<init>()
            androidx.datastore.core.DataStoreImpl<T> r13 = r12.this$0
            r12.L$0 = r10
            r12.L$1 = r9
            r12.L$2 = r1
            r12.L$3 = r1
            r12.label = r6
            java.lang.Object r13 = r13.readDataOrHandleCorruption(r6, r12)
            if (r13 != r0) goto L_0x0089
            goto L_0x010e
        L_0x0089:
            r8 = r1
        L_0x008a:
            androidx.datastore.core.Data r13 = (androidx.datastore.core.Data) r13
            java.lang.Object r13 = r13.getValue()
            r1.f20968a = r13
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1 r13 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1
            androidx.datastore.core.DataStoreImpl<T> r1 = r12.this$0
            r13.<init>(r10, r9, r8, r1)
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r1 = r12.this$1
            java.util.List r1 = r1.initTasks
            if (r1 == 0) goto L_0x00ce
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r13
        L_0x00ab:
            boolean r13 = r1.hasNext()
            if (r13 == 0) goto L_0x00ca
            java.lang.Object r13 = r1.next()
            d3.p r13 = (d3.p) r13
            r12.L$0 = r11
            r12.L$1 = r10
            r12.L$2 = r9
            r12.L$3 = r8
            r12.L$4 = r1
            r12.label = r5
            java.lang.Object r13 = r13.invoke(r8, r12)
            if (r13 != r0) goto L_0x00ab
            goto L_0x010e
        L_0x00ca:
            r8 = r9
            r5 = r10
            r1 = r11
            goto L_0x00d0
        L_0x00ce:
            r5 = r9
            r1 = r10
        L_0x00d0:
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r13 = r12.this$1
            r13.initTasks = r7
            r12.L$0 = r5
            r12.L$1 = r8
            r12.L$2 = r1
            r12.L$3 = r7
            r12.L$4 = r7
            r12.label = r4
            java.lang.Object r13 = r1.c(r7, r12)
            if (r13 != r0) goto L_0x00e8
            goto L_0x010e
        L_0x00e8:
            r4 = r8
        L_0x00e9:
            r5.f20985a = r6     // Catch:{ all -> 0x011c }
            R2.s r13 = R2.s.f8222a     // Catch:{ all -> 0x011c }
            r1.d(r7)
            java.lang.Object r1 = r4.f20968a
            if (r1 == 0) goto L_0x00f8
            int r2 = r1.hashCode()
        L_0x00f8:
            androidx.datastore.core.DataStoreImpl<T> r13 = r12.this$0
            androidx.datastore.core.InterProcessCoordinator r13 = r13.getCoordinator()
            r12.L$0 = r1
            r12.L$1 = r7
            r12.L$2 = r7
            r12.I$0 = r2
            r12.label = r3
            java.lang.Object r13 = r13.getVersion(r12)
            if (r13 != r0) goto L_0x010f
        L_0x010e:
            return r0
        L_0x010f:
            r0 = r2
        L_0x0110:
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            androidx.datastore.core.Data r2 = new androidx.datastore.core.Data
            r2.<init>(r1, r0, r13)
            return r2
        L_0x011c:
            r13 = move-exception
            r1.d(r7)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
