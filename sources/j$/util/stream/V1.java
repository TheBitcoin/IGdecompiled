package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;

public final class V1 extends C1159d {

    /* renamed from: h  reason: collision with root package name */
    public final C1232t1 f5412h;

    public final void onCompletion(CountedCompleter countedCompleter) {
        C1159d dVar = this.f5487d;
        if (dVar != null) {
            O1 o12 = (O1) ((V1) dVar).f5489f;
            o12.f((O1) ((V1) this.f5488e).f5489f);
            this.f5489f = o12;
        }
        super.onCompletion(countedCompleter);
    }

    public V1(C1232t1 t1Var, C1144a aVar, i0 i0Var) {
        super(aVar, i0Var);
        this.f5412h = t1Var;
    }

    public V1(V1 v12, i0 i0Var) {
        super((C1159d) v12, i0Var);
        this.f5412h = v12.f5412h;
    }

    public final C1159d c(i0 i0Var) {
        return new V1(this, i0Var);
    }

    public final Object a() {
        C1144a aVar = this.f5484a;
        O1 Z4 = this.f5412h.Z();
        aVar.N(this.f5485b, Z4);
        return Z4;
    }
}
