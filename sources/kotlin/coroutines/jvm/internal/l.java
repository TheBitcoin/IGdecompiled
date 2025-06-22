package kotlin.coroutines.jvm.internal;

import V2.d;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;

public abstract class l extends d implements i {
    private final int arity;

    public l(int i4, d dVar) {
        super(dVar);
        this.arity = i4;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String h4 = D.h(this);
        m.d(h4, "renderLambdaToString(...)");
        return h4;
    }
}
