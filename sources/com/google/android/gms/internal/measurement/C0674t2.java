package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.t2  reason: case insensitive filesystem */
public final class C0674t2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0674t2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    /* renamed from: com.google.android.gms.internal.measurement.t2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a A() {
            n();
            C0674t2.Q((C0674t2) this.f2153b);
            return this;
        }

        public final a q() {
            n();
            C0674t2.H((C0674t2) this.f2153b);
            return this;
        }

        public final a r(double d5) {
            n();
            C0674t2.I((C0674t2) this.f2153b, d5);
            return this;
        }

        public final a s(long j4) {
            n();
            C0674t2.J((C0674t2) this.f2153b, j4);
            return this;
        }

        public final a t(String str) {
            n();
            C0674t2.K((C0674t2) this.f2153b, str);
            return this;
        }

        public final a x() {
            n();
            C0674t2.M((C0674t2) this.f2153b);
            return this;
        }

        public final a y(long j4) {
            n();
            C0674t2.N((C0674t2) this.f2153b, j4);
            return this;
        }

        public final a z(String str) {
            n();
            C0674t2.O((C0674t2) this.f2153b, str);
            return this;
        }

        private a() {
            super(C0674t2.zzc);
        }
    }

    static {
        C0674t2 t2Var = new C0674t2();
        zzc = t2Var;
        C0668s4.r(C0674t2.class, t2Var);
    }

    private C0674t2() {
    }

    static /* synthetic */ void H(C0674t2 t2Var) {
        t2Var.zze &= -33;
        t2Var.zzk = 0.0d;
    }

    static /* synthetic */ void I(C0674t2 t2Var, double d5) {
        t2Var.zze |= 32;
        t2Var.zzk = d5;
    }

    static /* synthetic */ void J(C0674t2 t2Var, long j4) {
        t2Var.zze |= 8;
        t2Var.zzi = j4;
    }

    static /* synthetic */ void K(C0674t2 t2Var, String str) {
        str.getClass();
        t2Var.zze |= 2;
        t2Var.zzg = str;
    }

    static /* synthetic */ void M(C0674t2 t2Var) {
        t2Var.zze &= -9;
        t2Var.zzi = 0;
    }

    static /* synthetic */ void N(C0674t2 t2Var, long j4) {
        t2Var.zze |= 1;
        t2Var.zzf = j4;
    }

    static /* synthetic */ void O(C0674t2 t2Var, String str) {
        str.getClass();
        t2Var.zze |= 4;
        t2Var.zzh = str;
    }

    static /* synthetic */ void Q(C0674t2 t2Var) {
        t2Var.zze &= -5;
        t2Var.zzh = zzc.zzh;
    }

    public static a S() {
        return (a) zzc.x();
    }

    public final double G() {
        return this.zzk;
    }

    public final float L() {
        return this.zzj;
    }

    public final long P() {
        return this.zzi;
    }

    public final long R() {
        return this.zzf;
    }

    public final String U() {
        return this.zzg;
    }

    public final String V() {
        return this.zzh;
    }

    public final boolean W() {
        if ((this.zze & 32) != 0) {
            return true;
        }
        return false;
    }

    public final boolean X() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Y() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Z() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean a0() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0674t2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0674t2.class) {
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
