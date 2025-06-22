package o3;

import R2.s;
import V2.e;
import V2.g;
import W2.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.h;

public abstract class U {

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f3675a;

        /* renamed from: b  reason: collision with root package name */
        int f3676b;

        a(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f3675a = obj;
            this.f3676b |= Integer.MIN_VALUE;
            return U.a(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(V2.d r4) {
        /*
            boolean r0 = r4 instanceof o3.U.a
            if (r0 == 0) goto L_0x0013
            r0 = r4
            o3.U$a r0 = (o3.U.a) r0
            int r1 = r0.f3676b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f3676b = r1
            goto L_0x0018
        L_0x0013:
            o3.U$a r0 = new o3.U$a
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.f3675a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f3676b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x002d:
            R2.n.b(r4)
            goto L_0x0052
        L_0x0031:
            R2.n.b(r4)
            r0.f3676b = r3
            o3.n r4 = new o3.n
            V2.d r2 = W2.b.b(r0)
            r4.<init>(r2, r3)
            r4.z()
            java.lang.Object r4 = r4.v()
            java.lang.Object r2 = W2.b.c()
            if (r4 != r2) goto L_0x004f
            kotlin.coroutines.jvm.internal.h.c(r0)
        L_0x004f:
            if (r4 != r1) goto L_0x0052
            return r1
        L_0x0052:
            R2.d r4 = new R2.d
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.U.a(V2.d):java.lang.Object");
    }

    public static final Object b(long j4, V2.d dVar) {
        if (j4 <= 0) {
            return s.f8222a;
        }
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        if (j4 < Long.MAX_VALUE) {
            c(nVar.getContext()).n(j4, nVar);
        }
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            h.c(dVar);
        }
        if (v4 == b.c()) {
            return v4;
        }
        return s.f8222a;
    }

    public static final T c(g gVar) {
        T t4;
        g.b bVar = gVar.get(e.f8442a0);
        if (bVar instanceof T) {
            t4 = (T) bVar;
        } else {
            t4 = null;
        }
        if (t4 == null) {
            return P.a();
        }
        return t4;
    }
}
