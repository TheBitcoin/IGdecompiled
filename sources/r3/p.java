package r3;

import R2.s;
import V2.d;
import V2.g;
import d3.q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import s3.i;
import t3.G;

abstract /* synthetic */ class p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4269a = G.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    static final class a extends l implements q {

        /* renamed from: a  reason: collision with root package name */
        int f4270a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4271b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f4272c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d3.p f4273d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d3.p pVar, d dVar) {
            super(3, dVar);
            this.f4273d = pVar;
        }

        /* renamed from: i */
        public final Object invoke(C1036f fVar, Object obj, d dVar) {
            a aVar = new a(this.f4273d, dVar);
            aVar.f4271b = fVar;
            aVar.f4272c = obj;
            return aVar.invokeSuspend(s.f8222a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: r3.f} */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
            if (r1.emit(r6, r5) == r0) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            if (r6 == r0) goto L_0x0044;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f4270a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r6)
                goto L_0x0045
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                java.lang.Object r1 = r5.f4271b
                r3.f r1 = (r3.C1036f) r1
                R2.n.b(r6)
                goto L_0x0039
            L_0x0022:
                R2.n.b(r6)
                java.lang.Object r6 = r5.f4271b
                r1 = r6
                r3.f r1 = (r3.C1036f) r1
                java.lang.Object r6 = r5.f4272c
                d3.p r4 = r5.f4273d
                r5.f4271b = r1
                r5.f4270a = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L_0x0039
                goto L_0x0044
            L_0x0039:
                r3 = 0
                r5.f4271b = r3
                r5.f4270a = r2
                java.lang.Object r6 = r1.emit(r6, r5)
                if (r6 != r0) goto L_0x0045
            L_0x0044:
                return r0
            L_0x0045:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.p.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final C1035e a(C1035e eVar, d3.p pVar) {
        return C1037g.z(eVar, new a(pVar, (d) null));
    }

    public static final C1035e b(C1035e eVar, q qVar) {
        return new i(qVar, eVar, (g) null, 0, (q3.a) null, 28, (C2103g) null);
    }
}
