package x;

import java.util.concurrent.Executor;
import q.p;
import y.C1094d;
import z.C1115b;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4674a;

    /* renamed from: b  reason: collision with root package name */
    private final C1094d f4675b;

    /* renamed from: c  reason: collision with root package name */
    private final x f4676c;

    /* renamed from: d  reason: collision with root package name */
    private final C1115b f4677d;

    v(Executor executor, C1094d dVar, x xVar, C1115b bVar) {
        this.f4674a = executor;
        this.f4675b = dVar;
        this.f4676c = xVar;
        this.f4677d = bVar;
    }

    public static /* synthetic */ Object a(v vVar) {
        for (p b5 : vVar.f4675b.j()) {
            vVar.f4676c.b(b5, 1);
        }
        return null;
    }

    public void c() {
        this.f4674a.execute(new t(this));
    }
}
