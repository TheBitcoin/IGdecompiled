package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class C2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private C4 zzg = C0668s4.C();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;

    public enum a implements C0708x4 {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1423a;

        private a(int i4) {
            this.f1423a = i4;
        }

        public static a a(int i4) {
            if (i4 == 0) {
                return UNKNOWN;
            }
            if (i4 == 1) {
                return STRING;
            }
            if (i4 == 2) {
                return NUMBER;
            }
            if (i4 == 3) {
                return BOOLEAN;
            }
            if (i4 != 4) {
                return null;
            }
            return STATEMENT;
        }

        public static C0700w4 b() {
            return G2.f1478a;
        }

        public final int A() {
            return this.f1423a;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1423a + " name=" + name() + '>';
        }
    }

    public static final class b extends C0668s4.b implements C0521b5 {
        private b() {
            super(C2.zzc);
        }
    }

    static {
        C2 c22 = new C2();
        zzc = c22;
        C0668s4.r(C2.class, c22);
    }

    private C2() {
    }

    public final double G() {
        return this.zzk;
    }

    public final a H() {
        a a5 = a.a(this.zzf);
        if (a5 == null) {
            return a.UNKNOWN;
        }
        return a5;
    }

    public final String J() {
        return this.zzh;
    }

    public final String K() {
        return this.zzi;
    }

    public final List L() {
        return this.zzg;
    }

    public final boolean M() {
        return this.zzj;
    }

    public final boolean N() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (E2.f1454a[i4 - 1]) {
            case 1:
                return new C2();
            case 2:
                return new b();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", a.b(), "zzg", C2.class, "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C2.class) {
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
