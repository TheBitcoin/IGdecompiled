package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

public final class U1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final U1 zzc;
    private static volatile C0566g5 zzd;
    private C4 zze = C0668s4.C();

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(U1.zzc);
        }
    }

    static {
        U1 u12 = new U1();
        zzc = u12;
        C0668s4.r(U1.class, u12);
    }

    private U1() {
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new U1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (U1.class) {
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
