package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class L1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final L1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(L1.zzc);
        }
    }

    public enum b implements C0708x4 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1527a;

        private b(int i4) {
            this.f1527a = i4;
        }

        public static b a(int i4) {
            if (i4 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i4 == 1) {
                return LESS_THAN;
            }
            if (i4 == 2) {
                return GREATER_THAN;
            }
            if (i4 == 3) {
                return EQUAL;
            }
            if (i4 != 4) {
                return null;
            }
            return BETWEEN;
        }

        public static C0700w4 b() {
            return O1.f1586a;
        }

        public final int A() {
            return this.f1527a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1527a + " name=" + name() + '>';
        }
    }

    static {
        L1 l12 = new L1();
        zzc = l12;
        C0668s4.r(L1.class, l12);
    }

    private L1() {
    }

    public static L1 I() {
        return zzc;
    }

    public final b G() {
        b a5 = b.a(this.zzf);
        if (a5 == null) {
            return b.UNKNOWN_COMPARISON_TYPE;
        }
        return a5;
    }

    public final String J() {
        return this.zzh;
    }

    public final String K() {
        return this.zzj;
    }

    public final String L() {
        return this.zzi;
    }

    public final boolean M() {
        return this.zzg;
    }

    public final boolean N() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Q() {
        if ((this.zze & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean R() {
        if ((this.zze & 8) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new L1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", b.b(), "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (L1.class) {
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
