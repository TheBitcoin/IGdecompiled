package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.h2  reason: case insensitive filesystem */
public final class C0572h2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0572h2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    /* renamed from: com.google.android.gms.internal.measurement.h2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(boolean z4) {
            n();
            C0572h2.H((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a r(boolean z4) {
            n();
            C0572h2.J((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a s(boolean z4) {
            n();
            C0572h2.L((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a t(boolean z4) {
            n();
            C0572h2.M((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a x(boolean z4) {
            n();
            C0572h2.O((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a y(boolean z4) {
            n();
            C0572h2.Q((C0572h2) this.f2153b, z4);
            return this;
        }

        public final a z(boolean z4) {
            n();
            C0572h2.S((C0572h2) this.f2153b, z4);
            return this;
        }

        private a() {
            super(C0572h2.zzc);
        }
    }

    static {
        C0572h2 h2Var = new C0572h2();
        zzc = h2Var;
        C0668s4.r(C0572h2.class, h2Var);
    }

    private C0572h2() {
    }

    public static a G() {
        return (a) zzc.x();
    }

    static /* synthetic */ void H(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 32;
        h2Var.zzk = z4;
    }

    static /* synthetic */ void J(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 16;
        h2Var.zzj = z4;
    }

    public static C0572h2 K() {
        return zzc;
    }

    static /* synthetic */ void L(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 1;
        h2Var.zzf = z4;
    }

    static /* synthetic */ void M(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 64;
        h2Var.zzl = z4;
    }

    static /* synthetic */ void O(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 2;
        h2Var.zzg = z4;
    }

    static /* synthetic */ void Q(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 4;
        h2Var.zzh = z4;
    }

    static /* synthetic */ void S(C0572h2 h2Var, boolean z4) {
        h2Var.zze |= 8;
        h2Var.zzi = z4;
    }

    public final boolean N() {
        return this.zzk;
    }

    public final boolean P() {
        return this.zzj;
    }

    public final boolean R() {
        return this.zzf;
    }

    public final boolean T() {
        return this.zzl;
    }

    public final boolean U() {
        return this.zzg;
    }

    public final boolean V() {
        return this.zzh;
    }

    public final boolean W() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0572h2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0572h2.class) {
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
