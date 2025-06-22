package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class N1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final N1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private boolean zzh;
    private C4 zzi = C0668s4.C();

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(N1.zzc);
        }
    }

    public enum b implements C0708x4 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1577a;

        private b(int i4) {
            this.f1577a = i4;
        }

        public static b a(int i4) {
            switch (i4) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public static C0700w4 b() {
            return P1.f1592a;
        }

        public final int A() {
            return this.f1577a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1577a + " name=" + name() + '>';
        }
    }

    static {
        N1 n12 = new N1();
        zzc = n12;
        C0668s4.r(N1.class, n12);
    }

    private N1() {
    }

    public static N1 I() {
        return zzc;
    }

    public final b G() {
        b a5 = b.a(this.zzf);
        if (a5 == null) {
            return b.UNKNOWN_MATCH_TYPE;
        }
        return a5;
    }

    public final String J() {
        return this.zzg;
    }

    public final List K() {
        return this.zzi;
    }

    public final boolean L() {
        return this.zzh;
    }

    public final boolean M() {
        if ((this.zze & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzi.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new N1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", b.b(), "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (N1.class) {
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
