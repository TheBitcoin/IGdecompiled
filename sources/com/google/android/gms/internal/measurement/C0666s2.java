package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.s2  reason: case insensitive filesystem */
public final class C0666s2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0666s2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private C0716y4 zzg = C0668s4.B();

    /* renamed from: com.google.android.gms.internal.measurement.s2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(int i4) {
            n();
            C0666s2.H((C0666s2) this.f2153b, i4);
            return this;
        }

        public final a r(Iterable iterable) {
            n();
            C0666s2.I((C0666s2) this.f2153b, iterable);
            return this;
        }

        private a() {
            super(C0666s2.zzc);
        }
    }

    static {
        C0666s2 s2Var = new C0666s2();
        zzc = s2Var;
        C0668s4.r(C0666s2.class, s2Var);
    }

    private C0666s2() {
    }

    static /* synthetic */ void H(C0666s2 s2Var, int i4) {
        s2Var.zze |= 1;
        s2Var.zzf = i4;
    }

    static /* synthetic */ void I(C0666s2 s2Var, Iterable iterable) {
        C0716y4 y4Var = s2Var.zzg;
        if (!y4Var.b()) {
            s2Var.zzg = C0668s4.m(y4Var);
        }
        C3.f(iterable, s2Var.zzg);
    }

    public static a K() {
        return (a) zzc.x();
    }

    public final long G(int i4) {
        return this.zzg.d(i4);
    }

    public final int J() {
        return this.zzf;
    }

    public final List M() {
        return this.zzg;
    }

    public final boolean N() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzg.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0666s2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0666s2.class) {
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
