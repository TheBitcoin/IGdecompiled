package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0658r2;
import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.i2  reason: case insensitive filesystem */
public final class C0581i2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0581i2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private C0658r2 zzg;
    private C0658r2 zzh;
    private boolean zzi;

    /* renamed from: com.google.android.gms.internal.measurement.i2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(int i4) {
            n();
            C0581i2.G((C0581i2) this.f2153b, i4);
            return this;
        }

        public final a r(C0658r2.a aVar) {
            n();
            C0581i2.H((C0581i2) this.f2153b, (C0658r2) ((C0668s4) aVar.m()));
            return this;
        }

        public final a s(C0658r2 r2Var) {
            n();
            C0581i2.K((C0581i2) this.f2153b, r2Var);
            return this;
        }

        public final a t(boolean z4) {
            n();
            C0581i2.I((C0581i2) this.f2153b, z4);
            return this;
        }

        private a() {
            super(C0581i2.zzc);
        }
    }

    static {
        C0581i2 i2Var = new C0581i2();
        zzc = i2Var;
        C0668s4.r(C0581i2.class, i2Var);
    }

    private C0581i2() {
    }

    static /* synthetic */ void G(C0581i2 i2Var, int i4) {
        i2Var.zze |= 1;
        i2Var.zzf = i4;
    }

    static /* synthetic */ void H(C0581i2 i2Var, C0658r2 r2Var) {
        r2Var.getClass();
        i2Var.zzg = r2Var;
        i2Var.zze |= 2;
    }

    static /* synthetic */ void I(C0581i2 i2Var, boolean z4) {
        i2Var.zze |= 8;
        i2Var.zzi = z4;
    }

    public static a J() {
        return (a) zzc.x();
    }

    static /* synthetic */ void K(C0581i2 i2Var, C0658r2 r2Var) {
        r2Var.getClass();
        i2Var.zzh = r2Var;
        i2Var.zze |= 4;
    }

    public final C0658r2 M() {
        C0658r2 r2Var = this.zzg;
        if (r2Var == null) {
            return C0658r2.T();
        }
        return r2Var;
    }

    public final C0658r2 N() {
        C0658r2 r2Var = this.zzh;
        if (r2Var == null) {
            return C0658r2.T();
        }
        return r2Var;
    }

    public final boolean O() {
        return this.zzi;
    }

    public final boolean P() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Q() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean R() {
        if ((this.zze & 4) != 0) {
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
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0581i2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0581i2.class) {
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
