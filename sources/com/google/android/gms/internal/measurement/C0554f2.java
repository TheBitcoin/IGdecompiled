package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.f2  reason: case insensitive filesystem */
public final class C0554f2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0554f2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private long zzm;

    /* renamed from: com.google.android.gms.internal.measurement.f2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a A(String str) {
            n();
            C0554f2.Q((C0554f2) this.f2153b, str);
            return this;
        }

        public final a B() {
            n();
            C0554f2.L((C0554f2) this.f2153b);
            return this;
        }

        public final a C(String str) {
            n();
            C0554f2.T((C0554f2) this.f2153b, str);
            return this;
        }

        public final a D() {
            n();
            C0554f2.P((C0554f2) this.f2153b);
            return this;
        }

        public final a E(String str) {
            n();
            C0554f2.W((C0554f2) this.f2153b, str);
            return this;
        }

        public final a F() {
            n();
            C0554f2.S((C0554f2) this.f2153b);
            return this;
        }

        public final a G(String str) {
            n();
            C0554f2.Z((C0554f2) this.f2153b, str);
            return this;
        }

        public final a H() {
            n();
            C0554f2.V((C0554f2) this.f2153b);
            return this;
        }

        public final a I() {
            n();
            C0554f2.Y((C0554f2) this.f2153b);
            return this;
        }

        public final long q() {
            return ((C0554f2) this.f2153b).G();
        }

        public final a r(long j4) {
            n();
            C0554f2.I((C0554f2) this.f2153b, j4);
            return this;
        }

        public final a s(String str) {
            n();
            C0554f2.J((C0554f2) this.f2153b, str);
            return this;
        }

        public final long t() {
            return ((C0554f2) this.f2153b).K();
        }

        public final a x(long j4) {
            n();
            C0554f2.M((C0554f2) this.f2153b, j4);
            return this;
        }

        public final a y(String str) {
            n();
            C0554f2.N((C0554f2) this.f2153b, str);
            return this;
        }

        public final a z() {
            n();
            C0554f2.H((C0554f2) this.f2153b);
            return this;
        }

        private a() {
            super(C0554f2.zzc);
        }
    }

    static {
        C0554f2 f2Var = new C0554f2();
        zzc = f2Var;
        C0668s4.r(C0554f2.class, f2Var);
    }

    private C0554f2() {
    }

    static /* synthetic */ void H(C0554f2 f2Var) {
        f2Var.zze &= -5;
        f2Var.zzh = zzc.zzh;
    }

    static /* synthetic */ void I(C0554f2 f2Var, long j4) {
        f2Var.zze |= 8;
        f2Var.zzi = j4;
    }

    static /* synthetic */ void J(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 4;
        f2Var.zzh = str;
    }

    static /* synthetic */ void L(C0554f2 f2Var) {
        f2Var.zze &= -3;
        f2Var.zzg = zzc.zzg;
    }

    static /* synthetic */ void M(C0554f2 f2Var, long j4) {
        f2Var.zze |= 128;
        f2Var.zzm = j4;
    }

    static /* synthetic */ void N(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 2;
        f2Var.zzg = str;
    }

    public static a O() {
        return (a) zzc.x();
    }

    static /* synthetic */ void P(C0554f2 f2Var) {
        f2Var.zze &= -2;
        f2Var.zzf = zzc.zzf;
    }

    static /* synthetic */ void Q(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 1;
        f2Var.zzf = str;
    }

    static /* synthetic */ void S(C0554f2 f2Var) {
        f2Var.zze &= -65;
        f2Var.zzl = zzc.zzl;
    }

    static /* synthetic */ void T(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 64;
        f2Var.zzl = str;
    }

    public static C0554f2 U() {
        return zzc;
    }

    static /* synthetic */ void V(C0554f2 f2Var) {
        f2Var.zze &= -33;
        f2Var.zzk = zzc.zzk;
    }

    static /* synthetic */ void W(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 32;
        f2Var.zzk = str;
    }

    static /* synthetic */ void Y(C0554f2 f2Var) {
        f2Var.zze &= -17;
        f2Var.zzj = zzc.zzj;
    }

    static /* synthetic */ void Z(C0554f2 f2Var, String str) {
        str.getClass();
        f2Var.zze |= 16;
        f2Var.zzj = str;
    }

    public final long G() {
        return this.zzi;
    }

    public final long K() {
        return this.zzm;
    }

    public final String X() {
        return this.zzh;
    }

    public final String a0() {
        return this.zzg;
    }

    public final String b0() {
        return this.zzf;
    }

    public final String c0() {
        return this.zzl;
    }

    public final String d0() {
        return this.zzk;
    }

    public final String e0() {
        return this.zzj;
    }

    public final boolean f0() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean g0() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean h0() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean i0() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean j0() {
        if ((this.zze & 128) != 0) {
            return true;
        }
        return false;
    }

    public final boolean k0() {
        if ((this.zze & 64) != 0) {
            return true;
        }
        return false;
    }

    public final boolean l0() {
        if ((this.zze & 32) != 0) {
            return true;
        }
        return false;
    }

    public final boolean m0() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0554f2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0554f2.class) {
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
