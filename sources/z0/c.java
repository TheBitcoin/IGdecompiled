package Z0;

import java.util.Iterator;
import java.util.Set;
import s0.C2268c;
import s0.C2270e;
import s0.r;

public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private final String f8829a;

    /* renamed from: b  reason: collision with root package name */
    private final d f8830b;

    c(Set set, d dVar) {
        this.f8829a = d(set);
        this.f8830b = dVar;
    }

    public static /* synthetic */ i b(C2270e eVar) {
        return new c(eVar.e(f.class), d.a());
    }

    public static C2268c c() {
        return C2268c.c(i.class).b(r.o(f.class)).f(new b()).d();
    }

    private static String d(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb.append(fVar.b());
            sb.append('/');
            sb.append(fVar.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String a() {
        if (this.f8830b.b().isEmpty()) {
            return this.f8829a;
        }
        return this.f8829a + ' ' + d(this.f8830b.b());
    }
}
