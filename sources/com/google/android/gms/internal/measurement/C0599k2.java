package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0617m2;
import com.google.android.gms.internal.measurement.C0668s4;
import j$.util.DesugarCollections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.k2  reason: case insensitive filesystem */
public final class C0599k2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0599k2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    /* access modifiers changed from: private */
    public C4 zzf = C0668s4.C();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    /* renamed from: com.google.android.gms.internal.measurement.k2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a A(Iterable iterable) {
            n();
            C0599k2.M((C0599k2) this.f2153b, iterable);
            return this;
        }

        public final a B(String str) {
            n();
            C0599k2.N((C0599k2) this.f2153b, str);
            return this;
        }

        public final long C() {
            return ((C0599k2) this.f2153b).Q();
        }

        public final a D(long j4) {
            n();
            C0599k2.P((C0599k2) this.f2153b, j4);
            return this;
        }

        public final C0617m2 E(int i4) {
            return ((C0599k2) this.f2153b).G(i4);
        }

        public final long F() {
            return ((C0599k2) this.f2153b).R();
        }

        public final a G() {
            n();
            ((C0599k2) this.f2153b).zzf = C0668s4.C();
            return this;
        }

        public final String H() {
            return ((C0599k2) this.f2153b).U();
        }

        public final List I() {
            return DesugarCollections.unmodifiableList(((C0599k2) this.f2153b).V());
        }

        public final boolean J() {
            return ((C0599k2) this.f2153b).Y();
        }

        public final int q() {
            return ((C0599k2) this.f2153b).O();
        }

        public final a r(int i4) {
            n();
            C0599k2.I((C0599k2) this.f2153b, i4);
            return this;
        }

        public final a s(int i4, C0617m2.a aVar) {
            n();
            C0599k2.J((C0599k2) this.f2153b, i4, (C0617m2) ((C0668s4) aVar.m()));
            return this;
        }

        public final a t(int i4, C0617m2 m2Var) {
            n();
            C0599k2.J((C0599k2) this.f2153b, i4, m2Var);
            return this;
        }

        public final a x(long j4) {
            n();
            C0599k2.K((C0599k2) this.f2153b, j4);
            return this;
        }

        public final a y(C0617m2.a aVar) {
            n();
            C0599k2.L((C0599k2) this.f2153b, (C0617m2) ((C0668s4) aVar.m()));
            return this;
        }

        public final a z(C0617m2 m2Var) {
            n();
            C0599k2.L((C0599k2) this.f2153b, m2Var);
            return this;
        }

        private a() {
            super(C0599k2.zzc);
        }
    }

    static {
        C0599k2 k2Var = new C0599k2();
        zzc = k2Var;
        C0668s4.r(C0599k2.class, k2Var);
    }

    private C0599k2() {
    }

    static /* synthetic */ void I(C0599k2 k2Var, int i4) {
        k2Var.Z();
        k2Var.zzf.remove(i4);
    }

    static /* synthetic */ void J(C0599k2 k2Var, int i4, C0617m2 m2Var) {
        m2Var.getClass();
        k2Var.Z();
        k2Var.zzf.set(i4, m2Var);
    }

    static /* synthetic */ void K(C0599k2 k2Var, long j4) {
        k2Var.zze |= 4;
        k2Var.zzi = j4;
    }

    static /* synthetic */ void L(C0599k2 k2Var, C0617m2 m2Var) {
        m2Var.getClass();
        k2Var.Z();
        k2Var.zzf.add(m2Var);
    }

    static /* synthetic */ void M(C0599k2 k2Var, Iterable iterable) {
        k2Var.Z();
        C3.f(iterable, k2Var.zzf);
    }

    static /* synthetic */ void N(C0599k2 k2Var, String str) {
        str.getClass();
        k2Var.zze |= 1;
        k2Var.zzg = str;
    }

    static /* synthetic */ void P(C0599k2 k2Var, long j4) {
        k2Var.zze |= 2;
        k2Var.zzh = j4;
    }

    public static a S() {
        return (a) zzc.x();
    }

    private final void Z() {
        C4 c42 = this.zzf;
        if (!c42.b()) {
            this.zzf = C0668s4.n(c42);
        }
    }

    public final C0617m2 G(int i4) {
        return (C0617m2) this.zzf.get(i4);
    }

    public final int O() {
        return this.zzf.size();
    }

    public final long Q() {
        return this.zzi;
    }

    public final long R() {
        return this.zzh;
    }

    public final String U() {
        return this.zzg;
    }

    public final List V() {
        return this.zzf;
    }

    public final boolean W() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean X() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Y() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0599k2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", C0617m2.class, "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0599k2.class) {
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
