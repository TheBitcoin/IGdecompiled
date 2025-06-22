package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.z2  reason: case insensitive filesystem */
public final class C0722z2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0722z2 zzc;
    private static volatile C0566g5 zzd;
    private C4 zze = C0668s4.C();

    /* renamed from: com.google.android.gms.internal.measurement.z2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(C0722z2.zzc);
        }
    }

    static {
        C0722z2 z2Var = new C0722z2();
        zzc = z2Var;
        C0668s4.r(C0722z2.class, z2Var);
    }

    private C0722z2() {
    }

    public static C0722z2 H() {
        return zzc;
    }

    public final List I() {
        return this.zze;
    }

    public final int j() {
        return this.zze.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (E2.f1454a[i4 - 1]) {
            case 1:
                return new C0722z2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", A2.class});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0722z2.class) {
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
