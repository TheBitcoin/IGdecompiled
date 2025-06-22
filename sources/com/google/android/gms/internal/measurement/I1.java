package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.J1;
import com.google.android.gms.internal.measurement.M1;
import java.util.List;

public final class I1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final I1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf;
    private C4 zzg = C0668s4.C();
    private C4 zzh = C0668s4.C();
    private boolean zzi;
    private boolean zzj;

    public static final class a extends C0668s4.b implements C0521b5 {
        public final int q() {
            return ((I1) this.f2153b).J();
        }

        public final a r(int i4, J1.a aVar) {
            n();
            I1.H((I1) this.f2153b, i4, (J1) ((C0668s4) aVar.m()));
            return this;
        }

        public final a s(int i4, M1.a aVar) {
            n();
            I1.I((I1) this.f2153b, i4, (M1) ((C0668s4) aVar.m()));
            return this;
        }

        public final J1 t(int i4) {
            return ((I1) this.f2153b).G(i4);
        }

        public final int x() {
            return ((I1) this.f2153b).L();
        }

        public final M1 y(int i4) {
            return ((I1) this.f2153b).K(i4);
        }

        private a() {
            super(I1.zzc);
        }
    }

    static {
        I1 i12 = new I1();
        zzc = i12;
        C0668s4.r(I1.class, i12);
    }

    private I1() {
    }

    static /* synthetic */ void H(I1 i12, int i4, J1 j12) {
        j12.getClass();
        C4 c42 = i12.zzh;
        if (!c42.b()) {
            i12.zzh = C0668s4.n(c42);
        }
        i12.zzh.set(i4, j12);
    }

    static /* synthetic */ void I(I1 i12, int i4, M1 m12) {
        m12.getClass();
        C4 c42 = i12.zzg;
        if (!c42.b()) {
            i12.zzg = C0668s4.n(c42);
        }
        i12.zzg.set(i4, m12);
    }

    public final J1 G(int i4) {
        return (J1) this.zzh.get(i4);
    }

    public final int J() {
        return this.zzh.size();
    }

    public final M1 K(int i4) {
        return (M1) this.zzg.get(i4);
    }

    public final int L() {
        return this.zzg.size();
    }

    public final List N() {
        return this.zzh;
    }

    public final List O() {
        return this.zzg;
    }

    public final boolean P() {
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
        switch (H1.f1488a[i4 - 1]) {
            case 1:
                return new I1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", M1.class, "zzh", J1.class, "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (I1.class) {
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
