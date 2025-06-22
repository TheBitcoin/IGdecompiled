package kotlin.jvm.internal;

import k3.b;
import k3.j;

public abstract class u extends y implements j {
    public u(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return D.f(this);
    }

    public Object getDelegate(Object obj) {
        return ((j) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public j.a getGetter() {
        ((j) getReflected()).getGetter();
        return null;
    }
}
