package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class S1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final S1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    public static final class a extends C0668s4.b implements C0521b5 {
        public final boolean A() {
            return ((S1) this.f2153b).N();
        }

        public final int q() {
            return ((S1) this.f2153b).j();
        }

        public final a r(String str) {
            n();
            S1.G((S1) this.f2153b, str);
            return this;
        }

        public final String s() {
            return ((S1) this.f2153b).I();
        }

        public final boolean t() {
            return ((S1) this.f2153b).J();
        }

        public final boolean x() {
            return ((S1) this.f2153b).K();
        }

        public final boolean y() {
            return ((S1) this.f2153b).L();
        }

        public final boolean z() {
            return ((S1) this.f2153b).M();
        }

        private a() {
            super(S1.zzc);
        }
    }

    static {
        S1 s12 = new S1();
        zzc = s12;
        C0668s4.r(S1.class, s12);
    }

    private S1() {
    }

    static /* synthetic */ void G(S1 s12, String str) {
        str.getClass();
        s12.zze |= 1;
        s12.zzf = str;
    }

    public final String I() {
        return this.zzf;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final boolean K() {
        return this.zzh;
    }

    public final boolean L() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean M() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new S1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (S1.class) {
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
