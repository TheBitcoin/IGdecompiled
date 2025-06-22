package androidx.lifecycle;

import R2.c;
import d3.l;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, h {
    private final /* synthetic */ l function;

    Transformations$sam$androidx_lifecycle_Observer$0(l lVar) {
        m.e(lVar, "function");
        this.function = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof h)) {
            return false;
        }
        return m.a(getFunctionDelegate(), ((h) obj).getFunctionDelegate());
    }

    public final c getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
