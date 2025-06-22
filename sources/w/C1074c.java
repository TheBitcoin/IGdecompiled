package w;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import o.k;
import q.i;
import q.p;
import q.u;
import r.C1022e;
import r.C1030m;
import x.x;
import y.C1094d;
import z.C1115b;

/* renamed from: w.c  reason: case insensitive filesystem */
public class C1074c implements C1076e {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f4594f = Logger.getLogger(u.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final x f4595a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f4596b;

    /* renamed from: c  reason: collision with root package name */
    private final C1022e f4597c;

    /* renamed from: d  reason: collision with root package name */
    private final C1094d f4598d;

    /* renamed from: e  reason: collision with root package name */
    private final C1115b f4599e;

    public C1074c(Executor executor, C1022e eVar, x xVar, C1094d dVar, C1115b bVar) {
        this.f4596b = executor;
        this.f4597c = eVar;
        this.f4595a = xVar;
        this.f4598d = dVar;
        this.f4599e = bVar;
    }

    public static /* synthetic */ Object b(C1074c cVar, p pVar, i iVar) {
        cVar.f4598d.B(pVar, iVar);
        cVar.f4595a.b(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(C1074c cVar, p pVar, k kVar, i iVar) {
        cVar.getClass();
        try {
            C1030m mVar = cVar.f4597c.get(pVar.b());
            if (mVar == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{pVar.b()});
                f4594f.warning(format);
                kVar.a(new IllegalArgumentException(format));
                return;
            }
            cVar.f4599e.i(new C1073b(cVar, pVar, mVar.b(iVar)));
            kVar.a((Exception) null);
        } catch (Exception e5) {
            Logger logger = f4594f;
            logger.warning("Error scheduling event " + e5.getMessage());
            kVar.a(e5);
        }
    }

    public void a(p pVar, i iVar, k kVar) {
        this.f4596b.execute(new C1072a(this, pVar, kVar, iVar));
    }
}
