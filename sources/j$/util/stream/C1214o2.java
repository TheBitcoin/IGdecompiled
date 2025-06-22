package j$.util.stream;

import j$.util.c0;
import j$.util.i0;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.o2  reason: case insensitive filesystem */
public final class C1214o2 extends C1175g0 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5556m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f5557n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1214o2(C1180h0 h0Var, int i4, long j4, long j5) {
        super(h0Var, i4, 0);
        this.f5556m = j4;
        this.f5557n = j5;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 H(C1144a aVar, i0 i0Var) {
        long C4 = aVar.C(i0Var);
        long j4 = this.f5557n;
        if (C4 > 0 && i0Var.hasCharacteristics(16384)) {
            long j5 = this.f5556m;
            return new p3((c0) aVar.P(i0Var), j5, C1232t1.A(j5, j4));
        } else if (!W2.ORDERED.n(aVar.f5463f)) {
            c0 c0Var = (c0) aVar.P(i0Var);
            long j6 = this.f5556m;
            if (j6 <= C4) {
                long j7 = C4 - j6;
                if (j4 >= 0) {
                    j7 = Math.min(j4, j7);
                }
                j4 = j7;
                j6 = 0;
            }
            return new y3(c0Var, j6, j4);
        } else {
            return ((E0) new C1229s2(this, aVar, i0Var, new C1145a0(19), this.f5556m, this.f5557n).invoke()).spliterator();
        }
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [j$.util.stream.y3, j$.util.i0] */
    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        long j4;
        long j5;
        long C4 = aVar.C(i0Var);
        if (C4 <= 0 || !i0Var.hasCharacteristics(16384)) {
            i0 i0Var2 = i0Var;
            if (!W2.ORDERED.n(aVar.f5463f)) {
                c0 c0Var = (c0) aVar.P(i0Var2);
                long j6 = this.f5556m;
                long j7 = this.f5557n;
                if (j6 <= C4) {
                    long j8 = C4 - j6;
                    j4 = j7 >= 0 ? Math.min(j7, j8) : j8;
                    j5 = 0;
                } else {
                    j4 = j7;
                    j5 = j6;
                }
                return C1232t1.E(this, new y3(c0Var, j5, j4), true);
            }
            return (E0) new C1229s2(this, aVar, i0Var2, intFunction, this.f5556m, this.f5557n).invoke();
        }
        C1144a aVar2 = aVar;
        while (aVar2.f5462e > 0) {
            aVar2 = aVar2.f5459b;
        }
        return C1232t1.E(aVar, C1232t1.y(aVar2.E(), i0Var, this.f5556m, this.f5557n), true);
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        return new C1210n2(this, i2Var);
    }
}
