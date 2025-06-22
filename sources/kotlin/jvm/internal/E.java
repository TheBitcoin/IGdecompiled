package kotlin.jvm.internal;

import k3.c;
import k3.d;
import k3.e;
import k3.g;
import k3.i;
import k3.j;
import k3.k;

public class E {
    public c b(Class cls) {
        return new C2101e(cls);
    }

    public d c(Class cls, String str) {
        return new r(cls, str);
    }

    public String h(i iVar) {
        String obj = iVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String i(n nVar) {
        return h(nVar);
    }

    public e a(j jVar) {
        return jVar;
    }

    public g d(o oVar) {
        return oVar;
    }

    public i e(s sVar) {
        return sVar;
    }

    public j f(u uVar) {
        return uVar;
    }

    public k g(w wVar) {
        return wVar;
    }
}
