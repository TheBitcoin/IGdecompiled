package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.r2  reason: case insensitive filesystem */
public final class C0658r2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0658r2 zzc;
    private static volatile C0566g5 zzd;
    /* access modifiers changed from: private */
    public C0716y4 zze = C0668s4.B();
    /* access modifiers changed from: private */
    public C0716y4 zzf = C0668s4.B();
    /* access modifiers changed from: private */
    public C4 zzg = C0668s4.C();
    /* access modifiers changed from: private */
    public C4 zzh = C0668s4.C();

    /* renamed from: com.google.android.gms.internal.measurement.r2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a A(Iterable iterable) {
            n();
            C0658r2.Q((C0658r2) this.f2153b, iterable);
            return this;
        }

        public final a q() {
            n();
            ((C0658r2) this.f2153b).zzg = C0668s4.C();
            return this;
        }

        public final a r(Iterable iterable) {
            n();
            C0658r2.H((C0658r2) this.f2153b, iterable);
            return this;
        }

        public final a s() {
            n();
            ((C0658r2) this.f2153b).zzf = C0668s4.B();
            return this;
        }

        public final a t(Iterable iterable) {
            n();
            C0658r2.K((C0658r2) this.f2153b, iterable);
            return this;
        }

        public final a x() {
            n();
            ((C0658r2) this.f2153b).zzh = C0668s4.C();
            return this;
        }

        public final a y(Iterable iterable) {
            n();
            C0658r2.N((C0658r2) this.f2153b, iterable);
            return this;
        }

        public final a z() {
            n();
            ((C0658r2) this.f2153b).zze = C0668s4.B();
            return this;
        }

        private a() {
            super(C0658r2.zzc);
        }
    }

    static {
        C0658r2 r2Var = new C0658r2();
        zzc = r2Var;
        C0668s4.r(C0658r2.class, r2Var);
    }

    private C0658r2() {
    }

    static /* synthetic */ void H(C0658r2 r2Var, Iterable iterable) {
        C4 c42 = r2Var.zzg;
        if (!c42.b()) {
            r2Var.zzg = C0668s4.n(c42);
        }
        C3.f(iterable, r2Var.zzg);
    }

    static /* synthetic */ void K(C0658r2 r2Var, Iterable iterable) {
        C0716y4 y4Var = r2Var.zzf;
        if (!y4Var.b()) {
            r2Var.zzf = C0668s4.m(y4Var);
        }
        C3.f(iterable, r2Var.zzf);
    }

    static /* synthetic */ void N(C0658r2 r2Var, Iterable iterable) {
        C4 c42 = r2Var.zzh;
        if (!c42.b()) {
            r2Var.zzh = C0668s4.n(c42);
        }
        C3.f(iterable, r2Var.zzh);
    }

    static /* synthetic */ void Q(C0658r2 r2Var, Iterable iterable) {
        C0716y4 y4Var = r2Var.zze;
        if (!y4Var.b()) {
            r2Var.zze = C0668s4.m(y4Var);
        }
        C3.f(iterable, r2Var.zze);
    }

    public static a R() {
        return (a) zzc.x();
    }

    public static C0658r2 T() {
        return zzc;
    }

    public final int I() {
        return this.zzf.size();
    }

    public final int L() {
        return this.zzh.size();
    }

    public final int O() {
        return this.zze.size();
    }

    public final List U() {
        return this.zzg;
    }

    public final List V() {
        return this.zzf;
    }

    public final List W() {
        return this.zzh;
    }

    public final List X() {
        return this.zze;
    }

    public final int j() {
        return this.zzg.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0658r2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", C0590j2.class, "zzh", C0666s2.class});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0658r2.class) {
                    try {
                        g5Var = zzd;
                        if (g5Var == null) {
                            g5Var = new C0668s4.a(zzc);
                            zzd = g5Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g5Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
