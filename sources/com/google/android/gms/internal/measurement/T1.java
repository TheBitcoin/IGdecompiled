package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.S1;
import j$.util.DesugarCollections;
import java.util.List;

public final class T1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final T1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private int zzh;
    private C4 zzi = C0668s4.C();
    private C4 zzj = C0668s4.C();
    /* access modifiers changed from: private */
    public C4 zzk = C0668s4.C();
    private String zzl = "";
    private boolean zzm;
    private C4 zzn = C0668s4.C();
    private C4 zzo = C0668s4.C();
    private String zzp = "";
    private String zzq = "";
    private Q1 zzr;
    private V1 zzs;
    private Y1 zzt;
    private W1 zzu;
    private U1 zzv;

    public static final class a extends C0668s4.b implements C0521b5 {
        public final int q() {
            return ((T1) this.f2153b).J();
        }

        public final S1 r(int i4) {
            return ((T1) this.f2153b).G(i4);
        }

        public final a s(int i4, S1.a aVar) {
            n();
            T1.I((T1) this.f2153b, i4, (S1) ((C0668s4) aVar.m()));
            return this;
        }

        public final a t() {
            n();
            ((T1) this.f2153b).zzk = C0668s4.C();
            return this;
        }

        public final String x() {
            return ((T1) this.f2153b).R();
        }

        public final List y() {
            return DesugarCollections.unmodifiableList(((T1) this.f2153b).S());
        }

        public final List z() {
            return DesugarCollections.unmodifiableList(((T1) this.f2153b).T());
        }

        private a() {
            super(T1.zzc);
        }
    }

    static {
        T1 t12 = new T1();
        zzc = t12;
        C0668s4.r(T1.class, t12);
    }

    private T1() {
    }

    static /* synthetic */ void I(T1 t12, int i4, S1 s12) {
        s12.getClass();
        C4 c42 = t12.zzj;
        if (!c42.b()) {
            t12.zzj = C0668s4.n(c42);
        }
        t12.zzj.set(i4, s12);
    }

    public static a M() {
        return (a) zzc.x();
    }

    public static T1 O() {
        return zzc;
    }

    public final S1 G(int i4) {
        return (S1) this.zzj.get(i4);
    }

    public final int J() {
        return this.zzj.size();
    }

    public final long K() {
        return this.zzf;
    }

    public final Q1 L() {
        Q1 q12 = this.zzr;
        if (q12 == null) {
            return Q1.H();
        }
        return q12;
    }

    public final Y1 P() {
        Y1 y12 = this.zzt;
        if (y12 == null) {
            return Y1.H();
        }
        return y12;
    }

    public final String Q() {
        return this.zzg;
    }

    public final String R() {
        return this.zzp;
    }

    public final List S() {
        return this.zzk;
    }

    public final List T() {
        return this.zzo;
    }

    public final List U() {
        return this.zzn;
    }

    public final List V() {
        return this.zzi;
    }

    public final boolean W() {
        if ((this.zze & 128) != 0) {
            return true;
        }
        return false;
    }

    public final boolean X() {
        if ((this.zze & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Y() {
        if ((this.zze & 512) != 0) {
            return true;
        }
        return false;
    }

    public final boolean Z() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.zzn.size();
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new T1();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", X1.class, "zzj", S1.class, "zzk", I1.class, "zzl", "zzm", "zzn", B2.class, "zzo", R1.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (T1.class) {
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
