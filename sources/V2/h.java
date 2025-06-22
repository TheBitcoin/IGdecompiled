package V2;

import V2.g;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.p;
import java.io.Serializable;
import kotlin.jvm.internal.m;

public final class h implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final h f8445a = new h();

    private h() {
    }

    public Object fold(Object obj, p pVar) {
        m.e(pVar, "operation");
        return obj;
    }

    public g.b get(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public g minusKey(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this;
    }

    public g plus(g gVar) {
        m.e(gVar, "context");
        return gVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
