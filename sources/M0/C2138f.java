package m0;

import java.io.Serializable;
import l0.c;
import l0.f;
import l0.h;

/* renamed from: m0.f  reason: case insensitive filesystem */
final class C2138f extends G implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final c f21094a;

    /* renamed from: b  reason: collision with root package name */
    final G f21095b;

    C2138f(c cVar, G g4) {
        this.f21094a = (c) h.i(cVar);
        this.f21095b = (G) h.i(g4);
    }

    public int compare(Object obj, Object obj2) {
        return this.f21095b.compare(this.f21094a.apply(obj), this.f21094a.apply(obj2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2138f) {
            C2138f fVar = (C2138f) obj;
            if (!this.f21094a.equals(fVar.f21094a) || !this.f21095b.equals(fVar.f21095b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return f.b(this.f21094a, this.f21095b);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f21095b);
        String valueOf2 = String.valueOf(this.f21094a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
