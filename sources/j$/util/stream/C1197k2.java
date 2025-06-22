package j$.util.stream;

import j$.util.i0;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.k2  reason: case insensitive filesystem */
public final class C1197k2 extends Z1 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f5530m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f5531n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1197k2(C1147a2 a2Var, int i4, long j4, long j5) {
        super(a2Var, i4, 0);
        this.f5530m = j4;
        this.f5531n = j5;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 H(C1144a aVar, i0 i0Var) {
        long C4 = aVar.C(i0Var);
        long j4 = this.f5531n;
        if (C4 > 0 && i0Var.hasCharacteristics(16384)) {
            i0 P4 = aVar.P(i0Var);
            long j5 = this.f5530m;
            return new q3(P4, j5, C1232t1.A(j5, j4));
        } else if (!W2.ORDERED.n(aVar.f5463f)) {
            i0 P5 = aVar.P(i0Var);
            long j6 = this.f5530m;
            if (j6 <= C4) {
                long j7 = C4 - j6;
                if (j4 >= 0) {
                    j7 = Math.min(j4, j7);
                }
                j4 = j7;
                j6 = 0;
            }
            return new y3(P5, j6, j4);
        } else {
            return ((E0) new C1229s2(this, aVar, i0Var, new C1145a0(9), this.f5530m, this.f5531n).invoke()).spliterator();
        }
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [j$.util.stream.y3, j$.util.i0] */
    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        long j4;
        long j5;
        long C4 = aVar.C(i0Var);
        if (C4 <= 0 || !i0Var.hasCharacteristics(16384)) {
            i0 i0Var2 = i0Var;
            if (!W2.ORDERED.n(aVar.f5463f)) {
                i0 P4 = aVar.P(i0Var2);
                long j6 = this.f5530m;
                long j7 = this.f5531n;
                if (j6 <= C4) {
                    long j8 = C4 - j6;
                    j4 = j7 >= 0 ? Math.min(j7, j8) : j8;
                    j5 = 0;
                } else {
                    j4 = j7;
                    j5 = j6;
                }
                return C1232t1.B(this, new y3(P4, j5, j4), true, intFunction);
            }
            return (E0) new C1229s2(this, aVar, i0Var2, intFunction, this.f5530m, this.f5531n).invoke();
        }
        C1144a aVar2 = aVar;
        while (aVar2.f5462e > 0) {
            aVar2 = aVar2.f5459b;
        }
        return C1232t1.B(aVar, C1232t1.y(aVar2.E(), i0Var, this.f5530m, this.f5531n), true, intFunction);
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        return new C1192j2(this, i2Var);
    }
}
