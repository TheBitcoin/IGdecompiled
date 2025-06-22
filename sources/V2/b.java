package V2;

import V2.g;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.l;
import kotlin.jvm.internal.m;

public abstract class b implements g.c {

    /* renamed from: a  reason: collision with root package name */
    private final l f8437a;

    /* renamed from: b  reason: collision with root package name */
    private final g.c f8438b;

    public b(g.c cVar, l lVar) {
        m.e(cVar, "baseKey");
        m.e(lVar, "safeCast");
        this.f8437a = lVar;
        this.f8438b = cVar instanceof b ? ((b) cVar).f8438b : cVar;
    }

    public final boolean a(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        if (cVar == this || this.f8438b == cVar) {
            return true;
        }
        return false;
    }

    public final g.b b(g.b bVar) {
        m.e(bVar, "element");
        return (g.b) this.f8437a.invoke(bVar);
    }
}
