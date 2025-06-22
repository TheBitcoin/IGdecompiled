package q3;

import R2.m;
import R2.s;
import V2.g;
import V2.h;
import d3.l;
import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.n;
import o3.C0989m;
import o3.F;
import o3.J;
import o3.L;

public abstract class q {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4103a;

        /* renamed from: b  reason: collision with root package name */
        Object f4104b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f4105c;

        /* renamed from: d  reason: collision with root package name */
        int f4106d;

        a(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4105c = obj;
            this.f4106d |= Integer.MIN_VALUE;
            return q.a((s) null, (d3.a) null, this);
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0989m f4107a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C0989m mVar) {
            super(1);
            this.f4107a = mVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s.f8222a;
        }

        public final void invoke(Throwable th) {
            C0989m mVar = this.f4107a;
            m.a aVar = m.f8216a;
            mVar.resumeWith(m.a(s.f8222a));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: d3.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(q3.s r4, d3.a r5, V2.d r6) {
        /*
            boolean r0 = r6 instanceof q3.q.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            q3.q$a r0 = (q3.q.a) r0
            int r1 = r0.f4106d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4106d = r1
            goto L_0x0018
        L_0x0013:
            q3.q$a r0 = new q3.q$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f4105c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4106d
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.f4104b
            r5 = r4
            d3.a r5 = (d3.a) r5
            java.lang.Object r4 = r0.f4103a
            q3.s r4 = (q3.s) r4
            R2.n.b(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x0075
        L_0x0032:
            r4 = move-exception
            goto L_0x007b
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            R2.n.b(r6)
            V2.g r6 = r0.getContext()
            o3.s0$b r2 = o3.C1001s0.f3726k0
            V2.g$b r6 = r6.get(r2)
            if (r6 != r4) goto L_0x007f
            r0.f4103a = r4     // Catch:{ all -> 0x0032 }
            r0.f4104b = r5     // Catch:{ all -> 0x0032 }
            r0.f4106d = r3     // Catch:{ all -> 0x0032 }
            o3.n r6 = new o3.n     // Catch:{ all -> 0x0032 }
            V2.d r2 = W2.b.b(r0)     // Catch:{ all -> 0x0032 }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x0032 }
            r6.z()     // Catch:{ all -> 0x0032 }
            q3.q$b r2 = new q3.q$b     // Catch:{ all -> 0x0032 }
            r2.<init>(r6)     // Catch:{ all -> 0x0032 }
            r4.f(r2)     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r6.v()     // Catch:{ all -> 0x0032 }
            java.lang.Object r6 = W2.b.c()     // Catch:{ all -> 0x0032 }
            if (r4 != r6) goto L_0x0072
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch:{ all -> 0x0032 }
        L_0x0072:
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r5.invoke()
            R2.s r4 = R2.s.f8222a
            return r4
        L_0x007b:
            r5.invoke()
            throw r4
        L_0x007f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.q.a(q3.s, d3.a, V2.d):java.lang.Object");
    }

    public static final u b(J j4, g gVar, int i4, a aVar, L l4, l lVar, p pVar) {
        r rVar = new r(F.e(j4, gVar), g.b(i4, aVar, (l) null, 4, (Object) null));
        if (lVar != null) {
            rVar.i(lVar);
        }
        rVar.O0(l4, rVar, pVar);
        return rVar;
    }

    public static /* synthetic */ u c(J j4, g gVar, int i4, a aVar, L l4, l lVar, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gVar = h.f8445a;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i5 & 8) != 0) {
            l4 = L.DEFAULT;
        }
        if ((i5 & 16) != 0) {
            lVar = null;
        }
        l lVar2 = lVar;
        p pVar2 = pVar;
        L l5 = l4;
        int i6 = i4;
        return b(j4, gVar, i6, aVar, l5, lVar2, pVar2);
    }
}
