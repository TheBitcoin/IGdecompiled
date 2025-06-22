package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class M1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final M1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private K1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(String str) {
            n();
            M1.G((M1) this.f2153b, str);
            return this;
        }

        private a() {
            super(M1.zzc);
        }
    }

    static {
        M1 m12 = new M1();
        zzc = m12;
        C0668s4.r(M1.class, m12);
    }

    private M1() {
    }

    static /* synthetic */ void G(M1 m12, String str) {
        str.getClass();
        m12.zze |= 2;
        m12.zzg = str;
    }

    public static a I() {
        return (a) zzc.x();
    }

    public final K1 H() {
        K1 k12 = this.zzh;
        if (k12 == null) {
            return K1.I();
        }
        return k12;
    }

    public final String K() {
        return this.zzg;
    }

    public final boolean L() {
        return this.zzi;
    }

    public final boolean M() {
        return this.zzj;
    }

    public final boolean N() {
        return this.zzk;
    }

    public final boolean O() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        if ((this.zze & 32) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new M1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (M1.class) {
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
