package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

public final class H3 extends C1159d {

    /* renamed from: h  reason: collision with root package name */
    public final F3 f5315h;

    /* renamed from: i  reason: collision with root package name */
    public final IntFunction f5316i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f5317j;

    /* renamed from: k  reason: collision with root package name */
    public long f5318k;

    /* renamed from: l  reason: collision with root package name */
    public long f5319l;

    public final void onCompletion(CountedCompleter countedCompleter) {
        E0 F4;
        C1159d dVar = this.f5487d;
        if (dVar != null) {
            if (this.f5317j) {
                H3 h32 = (H3) dVar;
                long j4 = h32.f5319l;
                this.f5319l = j4;
                if (j4 == h32.f5318k) {
                    this.f5319l = j4 + ((H3) this.f5488e).f5319l;
                }
            }
            H3 h33 = (H3) dVar;
            long j5 = h33.f5318k;
            H3 h34 = (H3) this.f5488e;
            this.f5318k = j5 + h34.f5318k;
            if (h33.f5318k == 0) {
                F4 = (E0) h34.f5489f;
            } else if (h34.f5318k == 0) {
                F4 = (E0) h33.f5489f;
            } else {
                this.f5315h.getClass();
                F4 = C1232t1.F(X2.REFERENCE, (E0) ((H3) this.f5487d).f5489f, (E0) ((H3) this.f5488e).f5489f);
            }
            E0 e02 = F4;
            if (b() && this.f5317j) {
                e02 = e02.g(this.f5319l, e02.count(), this.f5316i);
            }
            this.f5489f = e02;
        }
        super.onCompletion(countedCompleter);
    }

    public H3(F3 f32, C1144a aVar, i0 i0Var, IntFunction intFunction) {
        super(aVar, i0Var);
        this.f5315h = f32;
        this.f5316i = intFunction;
        this.f5317j = W2.ORDERED.n(aVar.f5463f);
    }

    public H3(H3 h32, i0 i0Var) {
        super((C1159d) h32, i0Var);
        this.f5315h = h32.f5315h;
        this.f5316i = h32.f5316i;
        this.f5317j = h32.f5317j;
    }

    public final C1159d c(i0 i0Var) {
        return new H3(this, i0Var);
    }

    public final Object a() {
        long j4;
        boolean b5 = b();
        if (!b5 && this.f5317j) {
            W2 w22 = W2.SIZED;
            F3 f32 = this.f5315h;
            int i4 = f32.f5460c;
            int i5 = w22.f5442e;
            if ((i4 & i5) == i5) {
                j4 = f32.C(this.f5485b);
                C1243w0 F4 = this.f5484a.F(j4, this.f5316i);
                F3 f33 = this.f5315h;
                boolean z4 = !this.f5317j && !b5;
                f33.getClass();
                G3 g32 = new G3(f33, F4, z4);
                this.f5484a.N(this.f5485b, g32);
                E0 a5 = F4.a();
                this.f5318k = a5.count();
                this.f5319l = g32.f5302b;
                return a5;
            }
        }
        j4 = -1;
        C1243w0 F42 = this.f5484a.F(j4, this.f5316i);
        F3 f332 = this.f5315h;
        if (!this.f5317j) {
        }
        f332.getClass();
        G3 g322 = new G3(f332, F42, z4);
        this.f5484a.N(this.f5485b, g322);
        E0 a52 = F42.a();
        this.f5318k = a52.count();
        this.f5319l = g322.f5302b;
        return a52;
    }
}
