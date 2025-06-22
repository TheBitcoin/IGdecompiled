package o3;

import t3.C1064n;

public abstract class E0 extends G {
    public abstract E0 D();

    /* access modifiers changed from: protected */
    public final String F() {
        E0 e02;
        E0 c5 = Y.c();
        if (this == c5) {
            return "Dispatchers.Main";
        }
        try {
            e02 = c5.D();
        } catch (UnsupportedOperationException unused) {
            e02 = null;
        }
        if (this == e02) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public G limitedParallelism(int i4) {
        C1064n.a(i4);
        return this;
    }
}
