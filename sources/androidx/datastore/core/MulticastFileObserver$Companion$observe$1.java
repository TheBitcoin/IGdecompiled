package androidx.datastore.core;

import V2.d;
import d3.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import q3.s;

@f(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", l = {84, 85}, m = "invokeSuspend")
final class MulticastFileObserver$Companion$observe$1 extends l implements p {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MulticastFileObserver$Companion$observe$1(File file, d dVar) {
        super(2, dVar);
        this.$file = file;
    }

    public final d create(Object obj, d dVar) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, dVar);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
        if (q3.q.a(r3, r7, r6) == r0) goto L_0x0065;
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
            goto L_0x0066
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$1
            o3.Z r1 = (o3.Z) r1
            java.lang.Object r3 = r6.L$0
            q3.s r3 = (q3.s) r3
            R2.n.b(r7)
            goto L_0x0053
        L_0x0026:
            R2.n.b(r7)
            java.lang.Object r7 = r6.L$0
            q3.s r7 = (q3.s) r7
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1 r1 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1
            java.io.File r4 = r6.$file
            r1.<init>(r4, r7)
            androidx.datastore.core.MulticastFileObserver$Companion r4 = androidx.datastore.core.MulticastFileObserver.Companion
            java.io.File r5 = r6.$file
            java.io.File r5 = r5.getParentFile()
            kotlin.jvm.internal.m.b(r5)
            o3.Z r1 = r4.observe(r5, r1)
            R2.s r4 = R2.s.f8222a
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r3 = r7.t(r4, r6)
            if (r3 != r0) goto L_0x0052
            goto L_0x0065
        L_0x0052:
            r3 = r7
        L_0x0053:
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1 r7 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1
            r7.<init>(r1)
            r1 = 0
            r6.L$0 = r1
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = q3.q.a(r3, r7, r6)
            if (r7 != r0) goto L_0x0066
        L_0x0065:
            return r0
        L_0x0066:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MulticastFileObserver$Companion$observe$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(s sVar, d dVar) {
        return ((MulticastFileObserver$Companion$observe$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
