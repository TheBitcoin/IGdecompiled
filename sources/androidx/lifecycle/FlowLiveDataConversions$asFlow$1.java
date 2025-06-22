package androidx.lifecycle;

import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import q3.s;

@f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {107, 112, 113, 115}, m = "invokeSuspend")
final class FlowLiveDataConversions$asFlow$1 extends l implements p {
    final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, d dVar) {
        super(2, dVar);
        this.$this_asFlow = liveData;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, Object obj) {
        sVar.B(obj);
    }

    public final d create(Object obj, d dVar) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, dVar);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (o3.C0977g.g(r10, r7, r9) == r0) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0040
            if (r1 == r5) goto L_0x0038
            if (r1 == r4) goto L_0x0030
            if (r1 == r3) goto L_0x0026
            if (r1 == r2) goto L_0x001d
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001d:
            java.lang.Object r0 = r9.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            R2.n.b(r10)
            goto L_0x00b2
        L_0x0026:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            R2.n.b(r10)     // Catch:{ all -> 0x002e }
            goto L_0x008b
        L_0x002e:
            r10 = move-exception
            goto L_0x0091
        L_0x0030:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            R2.n.b(r10)     // Catch:{ all -> 0x002e }
            goto L_0x0080
        L_0x0038:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            R2.n.b(r10)
            goto L_0x0066
        L_0x0040:
            R2.n.b(r10)
            java.lang.Object r10 = r9.L$0
            q3.s r10 = (q3.s) r10
            androidx.lifecycle.e r1 = new androidx.lifecycle.e
            r1.<init>(r10)
            o3.E0 r10 = o3.Y.c()
            o3.E0 r10 = r10.D()
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r7 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            androidx.lifecycle.LiveData<T> r8 = r9.$this_asFlow
            r7.<init>(r8, r1, r6)
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = o3.C0977g.g(r10, r7, r9)
            if (r10 != r0) goto L_0x0066
            goto L_0x00b0
        L_0x0066:
            o3.E0 r10 = o3.Y.c()     // Catch:{ all -> 0x002e }
            o3.E0 r10 = r10.D()     // Catch:{ all -> 0x002e }
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r5 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2     // Catch:{ all -> 0x002e }
            androidx.lifecycle.LiveData<T> r7 = r9.$this_asFlow     // Catch:{ all -> 0x002e }
            r5.<init>(r7, r1, r6)     // Catch:{ all -> 0x002e }
            r9.L$0 = r1     // Catch:{ all -> 0x002e }
            r9.label = r4     // Catch:{ all -> 0x002e }
            java.lang.Object r10 = o3.C0977g.g(r10, r5, r9)     // Catch:{ all -> 0x002e }
            if (r10 != r0) goto L_0x0080
            goto L_0x00b0
        L_0x0080:
            r9.L$0 = r1     // Catch:{ all -> 0x002e }
            r9.label = r3     // Catch:{ all -> 0x002e }
            java.lang.Object r10 = o3.U.a(r9)     // Catch:{ all -> 0x002e }
            if (r10 != r0) goto L_0x008b
            goto L_0x00b0
        L_0x008b:
            R2.d r10 = new R2.d     // Catch:{ all -> 0x002e }
            r10.<init>()     // Catch:{ all -> 0x002e }
            throw r10     // Catch:{ all -> 0x002e }
        L_0x0091:
            o3.E0 r3 = o3.Y.c()
            o3.E0 r3 = r3.D()
            o3.G0 r4 = o3.G0.f3654a
            V2.g r3 = r3.plus(r4)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3 r4 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3
            androidx.lifecycle.LiveData<T> r5 = r9.$this_asFlow
            r4.<init>(r5, r1, r6)
            r9.L$0 = r10
            r9.label = r2
            java.lang.Object r1 = o3.C0977g.g(r3, r4, r9)
            if (r1 != r0) goto L_0x00b1
        L_0x00b0:
            return r0
        L_0x00b1:
            r0 = r10
        L_0x00b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(s sVar, d dVar) {
        return ((FlowLiveDataConversions$asFlow$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
