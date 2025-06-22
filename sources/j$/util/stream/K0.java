package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

public class K0 extends C1159d {

    /* renamed from: h  reason: collision with root package name */
    public final C1144a f5355h;

    /* renamed from: i  reason: collision with root package name */
    public final LongFunction f5356i;

    /* renamed from: j  reason: collision with root package name */
    public final BinaryOperator f5357j;

    public final void onCompletion(CountedCompleter countedCompleter) {
        C1159d dVar = this.f5487d;
        if (dVar != null) {
            this.f5489f = (E0) this.f5357j.apply((E0) ((K0) dVar).f5489f, (E0) ((K0) this.f5488e).f5489f);
        }
        super.onCompletion(countedCompleter);
    }

    public K0(C1144a aVar, i0 i0Var, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(aVar, i0Var);
        this.f5355h = aVar;
        this.f5356i = longFunction;
        this.f5357j = binaryOperator;
    }

    public K0(K0 k02, i0 i0Var) {
        super((C1159d) k02, i0Var);
        this.f5355h = k02.f5355h;
        this.f5356i = k02.f5356i;
        this.f5357j = k02.f5357j;
    }

    public C1159d c(i0 i0Var) {
        return new K0(this, i0Var);
    }

    /* renamed from: f */
    public final E0 a() {
        C1243w0 w0Var = (C1243w0) this.f5356i.apply(this.f5355h.C(this.f5485b));
        this.f5355h.N(this.f5485b, w0Var);
        return w0Var.a();
    }
}
