package kotlin.jvm.internal;

import k3.b;
import k3.g;
import k3.j;

public abstract class o extends q implements g {
    public o(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return D.d(this);
    }

    public Object getDelegate(Object obj) {
        return ((g) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public j.a getGetter() {
        ((g) getReflected()).getGetter();
        return null;
    }

    public g.a getSetter() {
        ((g) getReflected()).getSetter();
        return null;
    }
}
