package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0608l2;
import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.q2  reason: case insensitive filesystem */
public final class C0651q2 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final C0651q2 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private int zzf = 1;
    private C4 zzg = C0668s4.C();

    /* renamed from: com.google.android.gms.internal.measurement.q2$a */
    public static final class a extends C0668s4.b implements C0521b5 {
        public final a q(C0608l2.a aVar) {
            n();
            C0651q2.H((C0651q2) this.f2153b, (C0608l2) ((C0668s4) aVar.m()));
            return this;
        }

        private a() {
            super(C0651q2.zzc);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.q2$b */
    public enum b implements C0708x4 {
        RADS(1),
        PROVISIONING(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2114a;

        private b(int i4) {
            this.f2114a = i4;
        }

        public static b a(int i4) {
            if (i4 == 1) {
                return RADS;
            }
            if (i4 != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public static C0700w4 b() {
            return C0714y2.f2258a;
        }

        public final int A() {
            return this.f2114a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f2114a + " name=" + name() + '>';
        }
    }

    static {
        C0651q2 q2Var = new C0651q2();
        zzc = q2Var;
        C0668s4.r(C0651q2.class, q2Var);
    }

    private C0651q2() {
    }

    public static a G() {
        return (a) zzc.x();
    }

    static /* synthetic */ void H(C0651q2 q2Var, C0608l2 l2Var) {
        l2Var.getClass();
        C4 c42 = q2Var.zzg;
        if (!c42.b()) {
            q2Var.zzg = C0668s4.n(c42);
        }
        q2Var.zzg.add(l2Var);
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0545e2.f1885a[i4 - 1]) {
            case 1:
                return new C0651q2();
            case 2:
                return new a();
            case 3:
                return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", b.b(), "zzg", C0608l2.class});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (C0651q2.class) {
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
