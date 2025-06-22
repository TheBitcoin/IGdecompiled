package V2;

import V2.e;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public interface g {

    public static final class a {

        /* renamed from: V2.g$a$a  reason: collision with other inner class name */
        static final class C0116a extends n implements p {

            /* renamed from: a  reason: collision with root package name */
            public static final C0116a f8444a = new C0116a();

            C0116a() {
                super(2);
            }

            /* renamed from: a */
            public final g invoke(g gVar, b bVar) {
                m.e(gVar, "acc");
                m.e(bVar, "element");
                g minusKey = gVar.minusKey(bVar.getKey());
                h hVar = h.f8445a;
                if (minusKey == hVar) {
                    return bVar;
                }
                e.b bVar2 = e.f8442a0;
                e eVar = (e) minusKey.get(bVar2);
                if (eVar == null) {
                    return new c(minusKey, bVar);
                }
                g minusKey2 = minusKey.minusKey(bVar2);
                if (minusKey2 == hVar) {
                    return new c(bVar, eVar);
                }
                return new c(new c(minusKey2, bVar), eVar);
            }
        }

        public static g a(g gVar, g gVar2) {
            m.e(gVar2, "context");
            if (gVar2 == h.f8445a) {
                return gVar;
            }
            return (g) gVar2.fold(gVar, C0116a.f8444a);
        }
    }

    public interface b extends g {

        public static final class a {
            public static Object a(b bVar, Object obj, p pVar) {
                m.e(pVar, "operation");
                return pVar.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
                if (!m.a(bVar.getKey(), cVar)) {
                    return null;
                }
                m.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c cVar) {
                m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
                if (m.a(bVar.getKey(), cVar)) {
                    return h.f8445a;
                }
                return bVar;
            }

            public static g d(b bVar, g gVar) {
                m.e(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        b get(c cVar);

        c getKey();
    }

    public interface c {
    }

    Object fold(Object obj, p pVar);

    b get(c cVar);

    g minusKey(c cVar);

    g plus(g gVar);
}
