package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.m2  reason: case insensitive filesystem */
public final class C0617m2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0617m2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;
    /* access modifiers changed from: private */
    public C4 zzk = C0668s4.C();

    /* renamed from: com.google.android.gms.internal.measurement.m2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a A(String str) {
            n();
            C0617m2.P((C0617m2) this.f2153b, str);
            return this;
        }

        public final a B() {
            n();
            C0617m2.O((C0617m2) this.f2153b);
            return this;
        }

        public final a C() {
            n();
            ((C0617m2) this.f2153b).zzk = C0668s4.C();
            return this;
        }

        public final a D() {
            n();
            C0617m2.T((C0617m2) this.f2153b);
            return this;
        }

        public final String E() {
            return ((C0617m2) this.f2153b).W();
        }

        public final String F() {
            return ((C0617m2) this.f2153b).X();
        }

        public final int q() {
            return ((C0617m2) this.f2153b).Q();
        }

        public final a r(double d5) {
            n();
            C0617m2.I((C0617m2) this.f2153b, d5);
            return this;
        }

        public final a s(long j4) {
            n();
            C0617m2.J((C0617m2) this.f2153b, j4);
            return this;
        }

        public final a t(a aVar) {
            n();
            C0617m2.K((C0617m2) this.f2153b, (C0617m2) ((C0668s4) aVar.m()));
            return this;
        }

        public final a x(Iterable iterable) {
            n();
            C0617m2.L((C0617m2) this.f2153b, iterable);
            return this;
        }

        public final a y(String str) {
            n();
            C0617m2.M((C0617m2) this.f2153b, str);
            return this;
        }

        public final a z() {
            n();
            C0617m2.H((C0617m2) this.f2153b);
            return this;
        }

        private a() {
            super(C0617m2.zzc);
        }
    }

    static {
        C0617m2 m2Var = new C0617m2();
        zzc = m2Var;
        C0668s4.r(C0617m2.class, m2Var);
    }

    private C0617m2() {
    }

    static /* synthetic */ void H(C0617m2 m2Var) {
        m2Var.zze &= -17;
        m2Var.zzj = 0.0d;
    }

    static /* synthetic */ void I(C0617m2 m2Var, double d5) {
        m2Var.zze |= 16;
        m2Var.zzj = d5;
    }

    static /* synthetic */ void J(C0617m2 m2Var, long j4) {
        m2Var.zze |= 4;
        m2Var.zzh = j4;
    }

    static /* synthetic */ void K(C0617m2 m2Var, C0617m2 m2Var2) {
        m2Var2.getClass();
        m2Var.e0();
        m2Var.zzk.add(m2Var2);
    }

    static /* synthetic */ void L(C0617m2 m2Var, Iterable iterable) {
        m2Var.e0();
        C3.f(iterable, m2Var.zzk);
    }

    static /* synthetic */ void M(C0617m2 m2Var, String str) {
        str.getClass();
        m2Var.zze |= 1;
        m2Var.zzf = str;
    }

    static /* synthetic */ void O(C0617m2 m2Var) {
        m2Var.zze &= -5;
        m2Var.zzh = 0;
    }

    static /* synthetic */ void P(C0617m2 m2Var, String str) {
        str.getClass();
        m2Var.zze |= 2;
        m2Var.zzg = str;
    }

    static /* synthetic */ void T(C0617m2 m2Var) {
        m2Var.zze &= -3;
        m2Var.zzg = zzc.zzg;
    }

    public static a U() {
        return (a) zzc.x();
    }

    private final void e0() {
        C4 c42 = this.zzk;
        if (!c42.b()) {
            this.zzk = C0668s4.n(c42);
        }
    }

    public final double G() {
        return this.zzj;
    }

    public final float N() {
        return this.zzi;
    }

    public final int Q() {
        return this.zzk.size();
    }

    public final long S() {
        return this.zzh;
    }

    public final String W() {
        return this.zzf;
    }

    public final String X() {
        return this.zzg;
    }

    public final List Y() {
        return this.zzk;
    }

    public final boolean Z() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean a0() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b0() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean c0() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean d0() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0617m2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", C0617m2.class});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0617m2.class) {
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
