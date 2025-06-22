package V2;

import V2.g;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.p;
import kotlin.jvm.internal.m;

public abstract class a implements g.b {
    private final g.c key;

    public a(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        this.key = cVar;
    }

    public <R> R fold(R r4, p pVar) {
        return g.b.a.a(this, r4, pVar);
    }

    public g.b get(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c getKey() {
        return this.key;
    }

    public g minusKey(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
