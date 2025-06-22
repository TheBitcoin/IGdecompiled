package V2;

import V2.g;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import b.l;
import kotlin.jvm.internal.m;

public interface e extends g.b {

    /* renamed from: a0  reason: collision with root package name */
    public static final b f8442a0 = b.f8443a;

    public static final class a {
        public static g.b a(e eVar, g.c cVar) {
            m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (bVar.a(eVar.getKey())) {
                    g.b b5 = bVar.b(eVar);
                    if (l.a(b5)) {
                        return b5;
                    }
                }
                return null;
            } else if (e.f8442a0 != cVar) {
                return null;
            } else {
                m.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
        }

        public static g b(e eVar, g.c cVar) {
            m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) {
                    return eVar;
                }
                return h.f8445a;
            } else if (e.f8442a0 == cVar) {
                return h.f8445a;
            } else {
                return eVar;
            }
        }
    }

    public static final class b implements g.c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f8443a = new b();

        private b() {
        }
    }

    d interceptContinuation(d dVar);

    void releaseInterceptedContinuation(d dVar);
}
