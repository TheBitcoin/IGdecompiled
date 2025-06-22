package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0643p2;
import com.google.android.gms.internal.measurement.C0668s4;
import j$.util.DesugarCollections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.o2  reason: case insensitive filesystem */
public final class C0635o2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0635o2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    /* access modifiers changed from: private */
    public C4 zzf = C0668s4.C();
    private String zzg = "";
    private String zzh = "";
    private int zzi;

    /* renamed from: com.google.android.gms.internal.measurement.o2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final String A() {
            return ((C0635o2) this.f2153b).P();
        }

        public final List B() {
            return DesugarCollections.unmodifiableList(((C0635o2) this.f2153b).R());
        }

        public final int q() {
            return ((C0635o2) this.f2153b).j();
        }

        public final a r(C0643p2.a aVar) {
            n();
            C0635o2.I((C0635o2) this.f2153b, (C0643p2) ((C0668s4) aVar.m()));
            return this;
        }

        public final a s(Iterable iterable) {
            n();
            C0635o2.J((C0635o2) this.f2153b, iterable);
            return this;
        }

        public final a t(String str) {
            n();
            C0635o2.K((C0635o2) this.f2153b, str);
            return this;
        }

        public final C0643p2 x(int i4) {
            return ((C0635o2) this.f2153b).H(0);
        }

        public final a y() {
            n();
            ((C0635o2) this.f2153b).zzf = C0668s4.C();
            return this;
        }

        public final a z(String str) {
            n();
            C0635o2.N((C0635o2) this.f2153b, str);
            return this;
        }

        private a() {
            super(C0635o2.zzc);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.o2$b */
    public enum b implements C0708x4 {
        SDK(0),
        SGTM(1);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2089a;

        private b(int i4) {
            this.f2089a = i4;
        }

        public static b a(int i4) {
            if (i4 == 0) {
                return SDK;
            }
            if (i4 != 1) {
                return null;
            }
            return SGTM;
        }

        public static C0700w4 b() {
            return C0706x2.f2251a;
        }

        public final int A() {
            return this.f2089a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f2089a + " name=" + name() + '>';
        }
    }

    static {
        C0635o2 o2Var = new C0635o2();
        zzc = o2Var;
        C0668s4.r(C0635o2.class, o2Var);
    }

    private C0635o2() {
    }

    public static a G(C0635o2 o2Var) {
        return (a) zzc.k(o2Var);
    }

    static /* synthetic */ void I(C0635o2 o2Var, C0643p2 p2Var) {
        p2Var.getClass();
        o2Var.U();
        o2Var.zzf.add(p2Var);
    }

    static /* synthetic */ void J(C0635o2 o2Var, Iterable iterable) {
        o2Var.U();
        C3.f(iterable, o2Var.zzf);
    }

    static /* synthetic */ void K(C0635o2 o2Var, String str) {
        str.getClass();
        o2Var.zze |= 1;
        o2Var.zzg = str;
    }

    public static a L() {
        return (a) zzc.x();
    }

    static /* synthetic */ void N(C0635o2 o2Var, String str) {
        str.getClass();
        o2Var.zze |= 2;
        o2Var.zzh = str;
    }

    private final void U() {
        C4 c42 = this.zzf;
        if (!c42.b()) {
            this.zzf = C0668s4.n(c42);
        }
    }

    public final C0643p2 H(int i4) {
        return (C0643p2) this.zzf.get(0);
    }

    public final String P() {
        return this.zzg;
    }

    public final String Q() {
        return this.zzh;
    }

    public final List R() {
        return this.zzf;
    }

    public final boolean S() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean T() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzf.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0635o2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", C0643p2.class, "zzg", "zzh", "zzi", b.b()});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0635o2.class) {
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
