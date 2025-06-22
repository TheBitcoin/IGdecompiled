package t1;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import q1.n;

/* renamed from: t1.c  reason: case insensitive filesystem */
public class C2286c {

    /* renamed from: c  reason: collision with root package name */
    private static C2286c f21790c = new C2286c();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f21791a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f21792b = new ArrayList();

    private C2286c() {
    }

    public static C2286c e() {
        return f21790c;
    }

    public Collection a() {
        return DesugarCollections.unmodifiableCollection(this.f21792b);
    }

    public void b(n nVar) {
        this.f21791a.add(nVar);
    }

    public Collection c() {
        return DesugarCollections.unmodifiableCollection(this.f21791a);
    }

    public void d(n nVar) {
        boolean g4 = g();
        this.f21791a.remove(nVar);
        this.f21792b.remove(nVar);
        if (g4 && !g()) {
            C2292i.d().f();
        }
    }

    public void f(n nVar) {
        boolean g4 = g();
        this.f21792b.add(nVar);
        if (!g4) {
            C2292i.d().e();
        }
    }

    public boolean g() {
        if (this.f21792b.size() > 0) {
            return true;
        }
        return false;
    }
}
