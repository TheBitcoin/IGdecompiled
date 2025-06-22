package o3;

import V2.d;
import V2.e;
import V2.g;
import V2.h;
import d3.p;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.n;

public abstract class F {

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3649a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final g invoke(g gVar, g.b bVar) {
            return gVar.plus(bVar);
        }
    }

    static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f3650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3651b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C c5, boolean z4) {
            super(2);
            this.f3650a = c5;
            this.f3651b = z4;
        }

        /* renamed from: a */
        public final g invoke(g gVar, g.b bVar) {
            return gVar.plus(bVar);
        }
    }

    static final class c extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f3652a = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z4, g.b bVar) {
            return Boolean.valueOf(z4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (g.b) obj2);
        }
    }

    private static final g a(g gVar, g gVar2, boolean z4) {
        boolean c5 = c(gVar);
        boolean c6 = c(gVar2);
        if (!c5 && !c6) {
            return gVar.plus(gVar2);
        }
        C c7 = new C();
        c7.f20968a = gVar2;
        h hVar = h.f8445a;
        g gVar3 = (g) gVar.fold(hVar, new b(c7, z4));
        if (c6) {
            c7.f20968a = ((g) c7.f20968a).fold(hVar, a.f3649a);
        }
        return gVar3.plus((g) c7.f20968a);
    }

    public static final String b(g gVar) {
        return null;
    }

    private static final boolean c(g gVar) {
        return ((Boolean) gVar.fold(Boolean.FALSE, c.f3652a)).booleanValue();
    }

    public static final g d(g gVar, g gVar2) {
        if (!c(gVar2)) {
            return gVar.plus(gVar2);
        }
        return a(gVar, gVar2, false);
    }

    public static final g e(J j4, g gVar) {
        g a5 = a(j4.getCoroutineContext(), gVar, true);
        if (a5 == Y.a() || a5.get(e.f8442a0) != null) {
            return a5;
        }
        return a5.plus(Y.a());
    }

    public static final U0 f(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof V) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof U0) {
                return (U0) eVar;
            }
        }
        return null;
    }

    public static final U0 g(d dVar, g gVar, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e) || gVar.get(V0.f3679a) == null) {
            return null;
        }
        U0 f4 = f((kotlin.coroutines.jvm.internal.e) dVar);
        if (f4 != null) {
            f4.Q0(gVar, obj);
        }
        return f4;
    }
}
