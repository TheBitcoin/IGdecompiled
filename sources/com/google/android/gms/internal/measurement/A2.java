package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class A2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final A2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private C4 zzg = C0668s4.C();

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(A2.zzc);
        }
    }

    static {
        A2 a22 = new A2();
        zzc = a22;
        C0668s4.r(A2.class, a22);
    }

    private A2() {
    }

    public final String H() {
        return this.zzf;
    }

    public final List I() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (E2.f1454a[i4 - 1]) {
            case 1:
                return new A2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", C2.class});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (A2.class) {
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
