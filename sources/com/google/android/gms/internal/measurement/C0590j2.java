package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.j2  reason: case insensitive filesystem */
public final class C0590j2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0590j2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private long zzg;

    /* renamed from: com.google.android.gms.internal.measurement.j2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(int i4) {
            n();
            C0590j2.G((C0590j2) this.f2153b, i4);
            return this;
        }

        public final a r(long j4) {
            n();
            C0590j2.H((C0590j2) this.f2153b, j4);
            return this;
        }

        private a() {
            super(C0590j2.zzc);
        }
    }

    static {
        C0590j2 j2Var = new C0590j2();
        zzc = j2Var;
        C0668s4.r(C0590j2.class, j2Var);
    }

    private C0590j2() {
    }

    static /* synthetic */ void G(C0590j2 j2Var, int i4) {
        j2Var.zze |= 1;
        j2Var.zzf = i4;
    }

    static /* synthetic */ void H(C0590j2 j2Var, long j4) {
        j2Var.zze |= 2;
        j2Var.zzg = j4;
    }

    public static a J() {
        return (a) zzc.x();
    }

    public final long I() {
        return this.zzg;
    }

    public final boolean L() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean M() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0590j2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0590j2.class) {
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
