package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.List;

public final class Q1 extends C0668s4 implements C0521b5 {
    /* access modifiers changed from: private */
    public static final Q1 zzc;
    private static volatile C0566g5 zzd;
    private int zze;
    private C4 zzf = C0668s4.C();
    private C4 zzg = C0668s4.C();
    private C4 zzh = C0668s4.C();
    private boolean zzi;
    private C4 zzj = C0668s4.C();

    public static final class a extends C0668s4 implements C0521b5 {
        /* access modifiers changed from: private */
        public static final a zzc;
        private static volatile C0566g5 zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* renamed from: com.google.android.gms.internal.measurement.Q1$a$a  reason: collision with other inner class name */
        public static final class C0025a extends C0668s4.b implements C0521b5 {
            private C0025a() {
                super(a.zzc);
            }
        }

        static {
            a aVar = new a();
            zzc = aVar;
            C0668s4.r(a.class, aVar);
        }

        private a() {
        }

        public final d H() {
            d a5 = d.a(this.zzg);
            if (a5 == null) {
                return d.CONSENT_STATUS_UNSPECIFIED;
            }
            return a5;
        }

        public final e I() {
            e a5 = e.a(this.zzf);
            if (a5 == null) {
                return e.CONSENT_TYPE_UNSPECIFIED;
            }
            return a5;
        }

        /* access modifiers changed from: protected */
        public final Object o(int i4, Object obj, Object obj2) {
            C0566g5 g5Var;
            switch (C0509a2.f1748a[i4 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0025a();
                case 3:
                    return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.b(), "zzg", d.b()});
                case 4:
                    return zzc;
                case 5:
                    C0566g5 g5Var2 = zzd;
                    if (g5Var2 != null) {
                        return g5Var2;
                    }
                    synchronized (a.class) {
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

    public static final class b extends C0668s4.b implements C0521b5 {
        private b() {
            super(Q1.zzc);
        }
    }

    public static final class c extends C0668s4 implements C0521b5 {
        /* access modifiers changed from: private */
        public static final c zzc;
        private static volatile C0566g5 zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public static final class a extends C0668s4.b implements C0521b5 {
            private a() {
                super(c.zzc);
            }
        }

        static {
            c cVar = new c();
            zzc = cVar;
            C0668s4.r(c.class, cVar);
        }

        private c() {
        }

        public final e H() {
            e a5 = e.a(this.zzg);
            if (a5 == null) {
                return e.CONSENT_TYPE_UNSPECIFIED;
            }
            return a5;
        }

        public final e I() {
            e a5 = e.a(this.zzf);
            if (a5 == null) {
                return e.CONSENT_TYPE_UNSPECIFIED;
            }
            return a5;
        }

        /* access modifiers changed from: protected */
        public final Object o(int i4, Object obj, Object obj2) {
            C0566g5 g5Var;
            switch (C0509a2.f1748a[i4 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a();
                case 3:
                    return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.b(), "zzg", e.b()});
                case 4:
                    return zzc;
                case 5:
                    C0566g5 g5Var2 = zzd;
                    if (g5Var2 != null) {
                        return g5Var2;
                    }
                    synchronized (c.class) {
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

    public enum d implements C0708x4 {
        CONSENT_STATUS_UNSPECIFIED(0),
        GRANTED(1),
        DENIED(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1601a;

        private d(int i4) {
            this.f1601a = i4;
        }

        public static d a(int i4) {
            if (i4 == 0) {
                return CONSENT_STATUS_UNSPECIFIED;
            }
            if (i4 == 1) {
                return GRANTED;
            }
            if (i4 != 2) {
                return null;
            }
            return DENIED;
        }

        public static C0700w4 b() {
            return C0518b2.f1755a;
        }

        public final int A() {
            return this.f1601a;
        }

        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1601a + " name=" + name() + '>';
        }
    }

    public enum e implements C0708x4 {
        CONSENT_TYPE_UNSPECIFIED(0),
        AD_STORAGE(1),
        ANALYTICS_STORAGE(2),
        AD_USER_DATA(3),
        AD_PERSONALIZATION(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1608a;

        private e(int i4) {
            this.f1608a = i4;
        }

        public static e a(int i4) {
            if (i4 == 0) {
                return CONSENT_TYPE_UNSPECIFIED;
            }
            if (i4 == 1) {
                return AD_STORAGE;
            }
            if (i4 == 2) {
                return ANALYTICS_STORAGE;
            }
            if (i4 == 3) {
                return AD_USER_DATA;
            }
            if (i4 != 4) {
                return null;
            }
            return AD_PERSONALIZATION;
        }

        public static C0700w4 b() {
            return C0527c2.f1773a;
        }

        public final int A() {
            return this.f1608a;
        }

        public final String toString() {
            return "<" + e.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1608a + " name=" + name() + '>';
        }
    }

    public static final class f extends C0668s4 implements C0521b5 {
        /* access modifiers changed from: private */
        public static final f zzc;
        private static volatile C0566g5 zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        public static final class a extends C0668s4.b implements C0521b5 {
            private a() {
                super(f.zzc);
            }
        }

        static {
            f fVar = new f();
            zzc = fVar;
            C0668s4.r(f.class, fVar);
        }

        private f() {
        }

        public final String H() {
            return this.zzf;
        }

        /* access modifiers changed from: protected */
        public final Object o(int i4, Object obj, Object obj2) {
            C0566g5 g5Var;
            switch (C0509a2.f1748a[i4 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a();
                case 3:
                    return C0668s4.p(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    C0566g5 g5Var2 = zzd;
                    if (g5Var2 != null) {
                        return g5Var2;
                    }
                    synchronized (f.class) {
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

    static {
        Q1 q12 = new Q1();
        zzc = q12;
        C0668s4.r(Q1.class, q12);
    }

    private Q1() {
    }

    public static Q1 H() {
        return zzc;
    }

    public final List I() {
        return this.zzh;
    }

    public final List J() {
        return this.zzf;
    }

    public final List K() {
        return this.zzg;
    }

    public final List L() {
        return this.zzj;
    }

    public final boolean M() {
        return this.zzi;
    }

    public final boolean N() {
        if ((this.zze & 1) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final Object o(int i4, Object obj, Object obj2) {
        C0566g5 g5Var;
        switch (C0509a2.f1748a[i4 - 1]) {
            case 1:
                return new Q1();
            case 2:
                return new b();
            case 3:
                Class<a> cls = a.class;
                return C0668s4.p(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", cls, "zzg", c.class, "zzh", f.class, "zzi", "zzj", cls});
            case 4:
                return zzc;
            case 5:
                C0566g5 g5Var2 = zzd;
                if (g5Var2 != null) {
                    return g5Var2;
                }
                synchronized (Q1.class) {
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
