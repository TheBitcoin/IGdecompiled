package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class J1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final J1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private C4 zzh = C0668s4.C();
    private boolean zzi;
    private L1 zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    public static final class a extends C0668s4.b implements C0521b5 {
        public final int q() {
            return ((J1) this.f2153b).j();
        }

        public final a r(int i4, K1 k12) {
            n();
            J1.H((J1) this.f2153b, i4, k12);
            return this;
        }

        public final a s(String str) {
            n();
            J1.I((J1) this.f2153b, str);
            return this;
        }

        public final K1 t(int i4) {
            return ((J1) this.f2153b).G(i4);
        }

        public final String x() {
            return ((J1) this.f2153b).N();
        }

        private a() {
            super(J1.zzc);
        }
    }

    static {
        J1 j12 = new J1();
        zzc = j12;
        C0668s4.r(J1.class, j12);
    }

    private J1() {
    }

    static /* synthetic */ void H(J1 j12, int i4, K1 k12) {
        k12.getClass();
        C4 c42 = j12.zzh;
        if (!c42.b()) {
            j12.zzh = C0668s4.n(c42);
        }
        j12.zzh.set(i4, k12);
    }

    static /* synthetic */ void I(J1 j12, String str) {
        str.getClass();
        j12.zze |= 2;
        j12.zzg = str;
    }

    public static a K() {
        return (a) zzc.x();
    }

    public final K1 G(int i4) {
        return (K1) this.zzh.get(i4);
    }

    public final int J() {
        return this.zzf;
    }

    public final L1 M() {
        L1 l12 = this.zzj;
        if (l12 == null) {
            return L1.I();
        }
        return l12;
    }

    public final String N() {
        return this.zzg;
    }

    public final List O() {
        return this.zzh;
    }

    public final boolean P() {
        return this.zzk;
    }

    public final boolean Q() {
        return this.zzl;
    }

    public final boolean R() {
        return this.zzm;
    }

    public final boolean S() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean T() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean U() {
        if ((this.zze & 64) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzh.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new J1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", K1.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (J1.class) {
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
