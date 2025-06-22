package kotlin.jvm.internal;

import k3.c;
import k3.d;
import k3.e;
import k3.g;
import k3.i;
import k3.j;
import k3.k;

public abstract class D {

    /* renamed from: a  reason: collision with root package name */
    private static final E f20969a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f20970b = new c[0];

    static {
        E e5 = null;
        try {
            e5 = (E) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (e5 == null) {
            e5 = new E();
        }
        f20969a = e5;
    }

    public static e a(j jVar) {
        return f20969a.a(jVar);
    }

    public static c b(Class cls) {
        return f20969a.b(cls);
    }

    public static d c(Class cls) {
        return f20969a.c(cls, "");
    }

    public static g d(o oVar) {
        return f20969a.d(oVar);
    }

    public static i e(s sVar) {
        return f20969a.e(sVar);
    }

    public static j f(u uVar) {
        return f20969a.f(uVar);
    }

    public static k g(w wVar) {
        return f20969a.g(wVar);
    }

    public static String h(i iVar) {
        return f20969a.h(iVar);
    }

    public static String i(n nVar) {
        return f20969a.i(nVar);
    }
}
