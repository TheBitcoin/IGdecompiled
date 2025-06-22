package q;

import A.a;
import android.content.Context;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Set;
import o.C0962c;
import o.j;
import o.k;
import q.i;
import w.C1076e;
import x.r;
import x.v;

public class u implements t {

    /* renamed from: e  reason: collision with root package name */
    private static volatile v f4025e;

    /* renamed from: a  reason: collision with root package name */
    private final a f4026a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4027b;

    /* renamed from: c  reason: collision with root package name */
    private final C1076e f4028c;

    /* renamed from: d  reason: collision with root package name */
    private final r f4029d;

    u(a aVar, a aVar2, C1076e eVar, r rVar, v vVar) {
        this.f4026a = aVar;
        this.f4027b = aVar2;
        this.f4028c = eVar;
        this.f4029d = rVar;
        vVar.c();
    }

    private i b(o oVar) {
        i.a g4 = i.a().i(this.f4026a.a()).o(this.f4027b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (!(oVar.c().e() == null || oVar.c().e().a() == null)) {
            g4.l(oVar.c().e().a());
        }
        oVar.c().b();
        return g4.d();
    }

    public static u c() {
        v vVar = f4025e;
        if (vVar != null) {
            return vVar.d();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f fVar) {
        if (fVar instanceof g) {
            return DesugarCollections.unmodifiableSet(((g) fVar).a());
        }
        return Collections.singleton(C0962c.b("proto"));
    }

    public static void f(Context context) {
        if (f4025e == null) {
            synchronized (u.class) {
                try {
                    if (f4025e == null) {
                        f4025e = e.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void a(o oVar, k kVar) {
        this.f4028c.a(oVar.f().f(oVar.c().d()), b(oVar), kVar);
    }

    public r e() {
        return this.f4029d;
    }

    public j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
