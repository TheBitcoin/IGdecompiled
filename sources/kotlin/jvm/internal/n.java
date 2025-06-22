package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class n implements i, Serializable {
    private final int arity;

    public n(int i4) {
        this.arity = i4;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String i4 = D.i(this);
        m.d(i4, "renderLambdaToString(...)");
        return i4;
    }
}
