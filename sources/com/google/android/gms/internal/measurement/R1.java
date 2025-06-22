package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class R1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final R1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private C4 zzg = C0668s4.C();
    private boolean zzh;

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(R1.zzc);
        }
    }

    static {
        R1 r12 = new R1();
        zzc = r12;
        C0668s4.r(R1.class, r12);
    }

    private R1() {
    }

    public final String H() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new R1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", W1.class, "zzh"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (R1.class) {
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
