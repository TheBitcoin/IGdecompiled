package V2;

import V2.g;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.p;
import java.io.Serializable;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class c implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final g f8439a;

    /* renamed from: b  reason: collision with root package name */
    private final g.b f8440b;

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8441a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final String invoke(String str, g.b bVar) {
            m.e(str, "acc");
            m.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(g gVar, g.b bVar) {
        m.e(gVar, TtmlNode.LEFT);
        m.e(bVar, "element");
        this.f8439a = gVar;
        this.f8440b = bVar;
    }

    private final boolean b(g.b bVar) {
        return m.a(get(bVar.getKey()), bVar);
    }

    private final boolean c(c cVar) {
        while (b(cVar.f8440b)) {
            g gVar = cVar.f8439a;
            if (gVar instanceof c) {
                cVar = (c) gVar;
            } else {
                m.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((g.b) gVar);
            }
        }
        return false;
    }

    private final int e() {
        int i4 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f8439a;
            if (gVar instanceof c) {
                cVar = (c) gVar;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return i4;
            }
            i4++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.e() != e() || !cVar.c(this)) {
            return false;
        }
        return true;
    }

    public Object fold(Object obj, p pVar) {
        m.e(pVar, "operation");
        return pVar.invoke(this.f8439a.fold(obj, pVar), this.f8440b);
    }

    public g.b get(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        c cVar2 = this;
        while (true) {
            g.b bVar = cVar2.f8440b.get(cVar);
            if (bVar != null) {
                return bVar;
            }
            g gVar = cVar2.f8439a;
            if (!(gVar instanceof c)) {
                return gVar.get(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f8439a.hashCode() + this.f8440b.hashCode();
    }

    public g minusKey(g.c cVar) {
        m.e(cVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        if (this.f8440b.get(cVar) != null) {
            return this.f8439a;
        }
        g minusKey = this.f8439a.minusKey(cVar);
        if (minusKey == this.f8439a) {
            return this;
        }
        if (minusKey == h.f8445a) {
            return this.f8440b;
        }
        return new c(minusKey, this.f8440b);
    }

    public g plus(g gVar) {
        return g.a.a(this, gVar);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f8441a)) + ']';
    }
}
