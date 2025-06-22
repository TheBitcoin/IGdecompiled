package kotlin.jvm.internal;

import k3.b;
import k3.k;

public abstract class w extends y implements k {
    public w(Class cls, String str, String str2, int i4) {
        super(C2099c.NO_RECEIVER, cls, str, str2, i4);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return D.g(this);
    }

    public k.a getGetter() {
        ((k) getReflected()).getGetter();
        return null;
    }

    public Object invoke(Object obj, Object obj2) {
        return h(obj, obj2);
    }
}
