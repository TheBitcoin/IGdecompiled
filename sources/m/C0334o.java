package M;

import K.g;
import K.j;
import k0.C0937l;
import k0.C0938m;

/* renamed from: M.o  reason: case insensitive filesystem */
public abstract class C0334o {

    /* renamed from: a  reason: collision with root package name */
    private static final L f570a = new I();

    /* renamed from: M.o$a */
    public interface a {
        Object a(j jVar);
    }

    public static C0937l a(g gVar, a aVar) {
        L l4 = f570a;
        C0938m mVar = new C0938m();
        gVar.a(new J(gVar, mVar, aVar, l4));
        return mVar.a();
    }

    public static C0937l b(g gVar) {
        return a(gVar, new K());
    }
}
