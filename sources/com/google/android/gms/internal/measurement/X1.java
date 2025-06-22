package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class X1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final X1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(X1.zzc);
        }
    }

    static {
        X1 x12 = new X1();
        zzc = x12;
        C0668s4.r(X1.class, x12);
    }

    private X1() {
    }

    public final String H() {
        return this.zzf;
    }

    public final String I() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new X1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (X1.class) {
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
