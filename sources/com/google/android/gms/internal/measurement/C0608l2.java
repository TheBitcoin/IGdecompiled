package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.l2  reason: case insensitive filesystem */
public final class C0608l2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0608l2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private String zzf = "";
    private long zzg;

    /* renamed from: com.google.android.gms.internal.measurement.l2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(long j4) {
            n();
            C0608l2.H((C0608l2) this.f2153b, j4);
            return this;
        }

        public final a r(String str) {
            n();
            C0608l2.I((C0608l2) this.f2153b, str);
            return this;
        }

        private a() {
            super(C0608l2.zzc);
        }
    }

    static {
        C0608l2 l2Var = new C0608l2();
        zzc = l2Var;
        C0668s4.r(C0608l2.class, l2Var);
    }

    private C0608l2() {
    }

    public static a G() {
        return (a) zzc.x();
    }

    static /* synthetic */ void H(C0608l2 l2Var, long j4) {
        l2Var.zze |= 2;
        l2Var.zzg = j4;
    }

    static /* synthetic */ void I(C0608l2 l2Var, String str) {
        str.getClass();
        l2Var.zze |= 1;
        l2Var.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0608l2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0608l2.class) {
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
