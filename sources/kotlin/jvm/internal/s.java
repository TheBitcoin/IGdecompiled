package kotlin.jvm.internal;

import k3.b;
import k3.i;

public abstract class s extends y implements i {
    public s(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return D.e(this);
    }

    public Object invoke() {
        return get();
    }
}
