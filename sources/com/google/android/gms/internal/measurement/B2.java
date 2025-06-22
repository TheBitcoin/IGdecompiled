package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class B2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final B2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private C4 zzf = C0668s4.C();
    private C0722z2 zzg;

    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(B2.zzc);
        }
    }

    static {
        B2 b22 = new B2();
        zzc = b22;
        C0668s4.r(B2.class, b22);
    }

    private B2() {
    }

    public final C0722z2 G() {
        C0722z2 z2Var = this.zzg;
        if (z2Var == null) {
            return C0722z2.H();
        }
        return z2Var;
    }

    public final List I() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (E2.f1454a[i4 - 1]) {
            case 1:
                return new B2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", C2.class, "zzg"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (B2.class) {
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
