package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

public final class I3 extends C1149b {

    /* renamed from: j  reason: collision with root package name */
    public final F3 f5328j;

    /* renamed from: k  reason: collision with root package name */
    public final IntFunction f5329k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5330l;

    /* renamed from: m  reason: collision with root package name */
    public long f5331m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5332n;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f5333o;

    public final void f() {
        this.f5472i = true;
        if (this.f5330l && this.f5333o) {
            this.f5328j.getClass();
            d(C1232t1.H(X2.REFERENCE));
        }
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        Object obj;
        C1159d dVar = this.f5487d;
        if (dVar != null) {
            this.f5332n = ((I3) dVar).f5332n | ((I3) this.f5488e).f5332n;
            if (!this.f5330l || !this.f5472i) {
                if (this.f5330l) {
                    I3 i32 = (I3) this.f5487d;
                    if (i32.f5332n) {
                        this.f5331m = i32.f5331m;
                        obj = (E0) i32.i();
                    }
                }
                I3 i33 = (I3) this.f5487d;
                long j4 = i33.f5331m;
                I3 i34 = (I3) this.f5488e;
                this.f5331m = j4 + i34.f5331m;
                if (i33.f5331m == 0) {
                    obj = (E0) i34.i();
                } else if (i34.f5331m == 0) {
                    obj = (E0) i33.i();
                } else {
                    this.f5328j.getClass();
                    obj = C1232t1.F(X2.REFERENCE, (E0) ((I3) this.f5487d).i(), (E0) ((I3) this.f5488e).i());
                }
            } else {
                this.f5331m = 0;
                this.f5328j.getClass();
                obj = C1232t1.H(X2.REFERENCE);
            }
            d(obj);
        }
        this.f5333o = true;
        super.onCompletion(countedCompleter);
    }

    public I3(F3 f32, C1144a aVar, i0 i0Var, IntFunction intFunction) {
        super(aVar, i0Var);
        this.f5328j = f32;
        this.f5329k = intFunction;
        this.f5330l = W2.ORDERED.n(aVar.f5463f);
    }

    public I3(I3 i32, i0 i0Var) {
        super((C1149b) i32, i0Var);
        this.f5328j = i32.f5328j;
        this.f5329k = i32.f5329k;
        this.f5330l = i32.f5330l;
    }

    public final C1159d c(i0 i0Var) {
        return new I3(this, i0Var);
    }

    public final Object h() {
        this.f5328j.getClass();
        return C1232t1.H(X2.REFERENCE);
    }

    public final Object a() {
        C1243w0 F4 = this.f5484a.F(-1, this.f5329k);
        F3 f32 = this.f5328j;
        int i4 = this.f5484a.f5463f;
        f32.getClass();
        C1199l lVar = new C1199l(f32, (C1187i2) F4);
        C1144a aVar = this.f5484a;
        boolean x4 = aVar.x(this.f5485b, aVar.O(lVar));
        this.f5332n = x4;
        if (x4) {
            g();
        }
        E0 a5 = F4.a();
        this.f5331m = a5.count();
        return a5;
    }
}
