package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.s4  reason: case insensitive filesystem */
public abstract class C0668s4 extends C3 {
    private static Map<Class<?>, C0668s4> zzc = new ConcurrentHashMap();
    protected D5 zzb = D5.k();
    private int zzd = -1;

    /* renamed from: com.google.android.gms.internal.measurement.s4$a */
    protected static class a extends F3 {
        public a(C0668s4 s4Var) {
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.s4$b */
    public static abstract class b extends D3 {

        /* renamed from: a  reason: collision with root package name */
        private final C0668s4 f2152a;

        /* renamed from: b  reason: collision with root package name */
        protected C0668s4 f2153b;

        protected b(C0668s4 s4Var) {
            this.f2152a = s4Var;
            if (!s4Var.F()) {
                this.f2153b = s4Var.z();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static void j(Object obj, Object obj2) {
            C0611l5.a().c(obj).e(obj, obj2);
        }

        private final b p(byte[] bArr, int i4, int i5, C0556f4 f4Var) {
            if (!this.f2153b.F()) {
                o();
            }
            try {
                C0611l5.a().c(this.f2153b).g(this.f2153b, bArr, 0, i5, new J3(f4Var));
                return this;
            } catch (B4 e5) {
                throw e5;
            } catch (IndexOutOfBoundsException unused) {
                throw B4.g();
            } catch (IOException e6) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
            }
        }

        public /* synthetic */ Object clone() {
            b bVar = (b) this.f2152a.o(c.f2158e, (Object) null, (Object) null);
            bVar.f2153b = (C0668s4) u();
            return bVar;
        }

        public final /* synthetic */ D3 e(byte[] bArr, int i4, int i5) {
            return p(bArr, 0, i5, C0556f4.f1896c);
        }

        public final /* synthetic */ D3 f(byte[] bArr, int i4, int i5, C0556f4 f4Var) {
            return p(bArr, 0, i5, f4Var);
        }

        public final b i(C0668s4 s4Var) {
            if (this.f2152a.equals(s4Var)) {
                return this;
            }
            if (!this.f2153b.F()) {
                o();
            }
            j(this.f2153b, s4Var);
            return this;
        }

        /* renamed from: k */
        public final C0668s4 m() {
            C0668s4 s4Var = (C0668s4) u();
            if (C0668s4.s(s4Var, true)) {
                return s4Var;
            }
            throw new B5(s4Var);
        }

        /* renamed from: l */
        public C0668s4 u() {
            if (!this.f2153b.F()) {
                return this.f2153b;
            }
            this.f2153b.D();
            return this.f2153b;
        }

        /* access modifiers changed from: protected */
        public final void n() {
            if (!this.f2153b.F()) {
                o();
            }
        }

        /* access modifiers changed from: protected */
        public void o() {
            C0668s4 z4 = this.f2152a.z();
            j(z4, this.f2153b);
            this.f2153b = z4;
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.measurement.s4$c */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final int f2154a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f2155b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2156c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f2157d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f2158e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f2159f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f2160g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final /* synthetic */ int[] f2161h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f2161h.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.s4$d */
    public static class d extends C0565g4 {
    }

    protected static A4 A() {
        return C0692v4.h();
    }

    protected static C0716y4 B() {
        return J4.h();
    }

    protected static C4 C() {
        return C0602k5.j();
    }

    private final int j() {
        return C0611l5.a().c(this).d(this);
    }

    static C0668s4 l(Class cls) {
        C0668s4 s4Var = zzc.get(cls);
        if (s4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                s4Var = zzc.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (s4Var != null) {
            return s4Var;
        }
        C0668s4 s4Var2 = (C0668s4) ((C0668s4) F5.b(cls)).o(c.f2159f, (Object) null, (Object) null);
        if (s4Var2 != null) {
            zzc.put(cls, s4Var2);
            return s4Var2;
        }
        throw new IllegalStateException();
    }

    protected static C0716y4 m(C0716y4 y4Var) {
        return y4Var.e(y4Var.size() << 1);
    }

    protected static C4 n(C4 c42) {
        return c42.a(c42.size() << 1);
    }

    protected static Object p(Z4 z4, String str, Object[] objArr) {
        return new C0620m5(z4, str, objArr);
    }

    static Object q(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static void r(Class cls, C0668s4 s4Var) {
        s4Var.E();
        zzc.put(cls, s4Var);
    }

    protected static final boolean s(C0668s4 s4Var, boolean z4) {
        C0668s4 s4Var2;
        byte byteValue = ((Byte) s4Var.o(c.f2154a, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b5 = C0611l5.a().c(s4Var).b(s4Var);
        if (z4) {
            int i4 = c.f2155b;
            if (b5) {
                s4Var2 = s4Var;
            } else {
                s4Var2 = null;
            }
            s4Var.o(i4, s4Var2, (Object) null);
        }
        return b5;
    }

    private final int t(C0638o5 o5Var) {
        if (o5Var == null) {
            return C0611l5.a().c(this).a(this);
        }
        return o5Var.a(this);
    }

    /* access modifiers changed from: protected */
    public final void D() {
        C0611l5.a().c(this).c(this);
        E();
    }

    /* access modifiers changed from: package-private */
    public final void E() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final boolean F() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public final void a(C0520b4 b4Var) {
        C0611l5.a().c(this).f(this, C0547e4.P(b4Var));
    }

    public final /* synthetic */ Z4 b() {
        return (C0668s4) o(c.f2159f, (Object) null, (Object) null);
    }

    public final /* synthetic */ Y4 c() {
        return (b) o(c.f2158e, (Object) null, (Object) null);
    }

    public final int d() {
        return e((C0638o5) null);
    }

    /* access modifiers changed from: package-private */
    public final int e(C0638o5 o5Var) {
        if (F()) {
            int t4 = t(o5Var);
            if (t4 >= 0) {
                return t4;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + t4);
        } else if (g() != Integer.MAX_VALUE) {
            return g();
        } else {
            int t5 = t(o5Var);
            h(t5);
            return t5;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C0611l5.a().c(this).h(this, (C0668s4) obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int g() {
        return this.zzd & Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void h(int i4) {
        if (i4 >= 0) {
            this.zzd = (i4 & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i4);
    }

    public int hashCode() {
        if (F()) {
            return j();
        }
        if (this.zza == 0) {
            this.zza = j();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final b k(C0668s4 s4Var) {
        return x().i(s4Var);
    }

    /* access modifiers changed from: protected */
    public abstract Object o(int i4, Object obj, Object obj2);

    public String toString() {
        return C0512a5.a(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final b x() {
        return (b) o(c.f2158e, (Object) null, (Object) null);
    }

    public final b y() {
        return ((b) o(c.f2158e, (Object) null, (Object) null)).i(this);
    }

    /* access modifiers changed from: package-private */
    public final C0668s4 z() {
        return (C0668s4) o(c.f2157d, (Object) null, (Object) null);
    }
}
