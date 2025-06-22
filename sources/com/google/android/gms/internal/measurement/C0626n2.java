package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.n2  reason: case insensitive filesystem */
public final class C0626n2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0626n2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private C0563g2 zzh;

    /* renamed from: com.google.android.gms.internal.measurement.n2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        private a() {
            super(C0626n2.zzc);
        }
    }

    static {
        C0626n2 n2Var = new C0626n2();
        zzc = n2Var;
        C0668s4.r(C0626n2.class, n2Var);
    }

    private C0626n2() {
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0626n2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0626n2.class) {
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
