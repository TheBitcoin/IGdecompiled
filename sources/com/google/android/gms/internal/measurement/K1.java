package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class K1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final K1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private N1 zzf;
    private L1 zzg;
    private boolean zzh;
    private String zzi = "";

    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(String str) {
            n();
            K1.H((K1) this.f2153b, str);
            return this;
        }

        private a() {
            super(K1.zzc);
        }
    }

    static {
        K1 k12 = new K1();
        zzc = k12;
        C0668s4.r(K1.class, k12);
    }

    private K1() {
    }

    static /* synthetic */ void H(K1 k12, String str) {
        str.getClass();
        k12.zze |= 8;
        k12.zzi = str;
    }

    public static K1 I() {
        return zzc;
    }

    public final L1 J() {
        L1 l12 = this.zzg;
        if (l12 == null) {
            return L1.I();
        }
        return l12;
    }

    public final N1 K() {
        N1 n12 = this.zzf;
        if (n12 == null) {
            return N1.I();
        }
        return n12;
    }

    public final String L() {
        return this.zzi;
    }

    public final boolean M() {
        return this.zzh;
    }

    public final boolean N() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Q() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new K1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (K1.class) {
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
