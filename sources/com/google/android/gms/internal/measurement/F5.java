package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

abstract class F5 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f1461a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f1462b = H3.a();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f1463c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f1464d;

    /* renamed from: e  reason: collision with root package name */
    private static final b f1465e;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f1466f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f1467g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f1468h = ((long) o(byte[].class));

    /* renamed from: i  reason: collision with root package name */
    static final boolean f1469i;

    private static final class a extends b {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        public final double a(Object obj, long j4) {
            return Double.longBitsToDouble(m(obj, j4));
        }

        public final void b(Object obj, long j4, byte b5) {
            if (F5.f1469i) {
                F5.u(obj, j4, b5);
            } else {
                F5.y(obj, j4, b5);
            }
        }

        public final void c(Object obj, long j4, double d5) {
            f(obj, j4, Double.doubleToLongBits(d5));
        }

        public final void d(Object obj, long j4, float f4) {
            e(obj, j4, Float.floatToIntBits(f4));
        }

        public final void g(Object obj, long j4, boolean z4) {
            if (F5.f1469i) {
                F5.u(obj, j4, r3 ? (byte) 1 : 0);
            } else {
                F5.y(obj, j4, r3 ? (byte) 1 : 0);
            }
        }

        public final float i(Object obj, long j4) {
            return Float.intBitsToFloat(l(obj, j4));
        }

        public final boolean k(Object obj, long j4) {
            if (F5.f1469i) {
                return F5.D(obj, j4);
            }
            return F5.E(obj, j4);
        }
    }

    private static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f1470a;

        b(Unsafe unsafe) {
            this.f1470a = unsafe;
        }

        public abstract double a(Object obj, long j4);

        public abstract void b(Object obj, long j4, byte b5);

        public abstract void c(Object obj, long j4, double d5);

        public abstract void d(Object obj, long j4, float f4);

        public final void e(Object obj, long j4, int i4) {
            this.f1470a.putInt(obj, j4, i4);
        }

        public final void f(Object obj, long j4, long j5) {
            this.f1470a.putLong(obj, j4, j5);
        }

        public abstract void g(Object obj, long j4, boolean z4);

        public final boolean h() {
            Class<Class> cls = Class.class;
            Class<Object> cls2 = Object.class;
            Unsafe unsafe = this.f1470a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls3 = unsafe.getClass();
                cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls3.getMethod("arrayBaseOffset", new Class[]{cls});
                cls3.getMethod("arrayIndexScale", new Class[]{cls});
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", new Class[]{cls2, cls4});
                cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
                cls3.getMethod("getLong", new Class[]{cls2, cls4});
                cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
                cls3.getMethod("getObject", new Class[]{cls2, cls4});
                cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
                return true;
            } catch (Throwable th) {
                F5.l(th);
                return false;
            }
        }

        public abstract float i(Object obj, long j4);

        public final boolean j() {
            Unsafe unsafe = this.f1470a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (F5.C() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                F5.l(th);
                return false;
            }
        }

        public abstract boolean k(Object obj, long j4);

        public final int l(Object obj, long j4) {
            return this.f1470a.getInt(obj, j4);
        }

        public final long m(Object obj, long j4) {
            return this.f1470a.getLong(obj, j4);
        }
    }

    private static final class c extends b {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public final double a(Object obj, long j4) {
            return Double.longBitsToDouble(m(obj, j4));
        }

        public final void b(Object obj, long j4, byte b5) {
            if (F5.f1469i) {
                F5.u(obj, j4, b5);
            } else {
                F5.y(obj, j4, b5);
            }
        }

        public final void c(Object obj, long j4, double d5) {
            f(obj, j4, Double.doubleToLongBits(d5));
        }

        public final void d(Object obj, long j4, float f4) {
            e(obj, j4, Float.floatToIntBits(f4));
        }

        public final void g(Object obj, long j4, boolean z4) {
            if (F5.f1469i) {
                F5.u(obj, j4, r3 ? (byte) 1 : 0);
            } else {
                F5.y(obj, j4, r3 ? (byte) 1 : 0);
            }
        }

        public final float i(Object obj, long j4) {
            return Float.intBitsToFloat(l(obj, j4));
        }

        public final boolean k(Object obj, long j4) {
            if (F5.f1469i) {
                return F5.D(obj, j4);
            }
            return F5.E(obj, j4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    static {
        /*
            sun.misc.Unsafe r0 = p()
            f1461a = r0
            java.lang.Class r1 = com.google.android.gms.internal.measurement.H3.a()
            f1462b = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = A(r1)
            f1463c = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = A(r2)
            f1464d = r2
            if (r0 == 0) goto L_0x002e
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.internal.measurement.F5$c r1 = new com.google.android.gms.internal.measurement.F5$c
            r1.<init>(r0)
            goto L_0x002f
        L_0x0026:
            if (r2 == 0) goto L_0x002e
            com.google.android.gms.internal.measurement.F5$a r1 = new com.google.android.gms.internal.measurement.F5$a
            r1.<init>(r0)
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            f1465e = r1
            r0 = 0
            if (r1 != 0) goto L_0x0036
            r2 = 0
            goto L_0x003a
        L_0x0036:
            boolean r2 = r1.j()
        L_0x003a:
            f1466f = r2
            if (r1 != 0) goto L_0x0040
            r2 = 0
            goto L_0x0044
        L_0x0040:
            boolean r2 = r1.h()
        L_0x0044:
            f1467g = r2
            java.lang.Class<byte[]> r2 = byte[].class
            int r2 = o(r2)
            long r2 = (long) r2
            f1468h = r2
            java.lang.Class<boolean[]> r2 = boolean[].class
            o(r2)
            s(r2)
            java.lang.Class<int[]> r2 = int[].class
            o(r2)
            s(r2)
            java.lang.Class<long[]> r2 = long[].class
            o(r2)
            s(r2)
            java.lang.Class<float[]> r2 = float[].class
            o(r2)
            s(r2)
            java.lang.Class<double[]> r2 = double[].class
            o(r2)
            s(r2)
            java.lang.Class<java.lang.Object[]> r2 = java.lang.Object[].class
            o(r2)
            s(r2)
            java.lang.reflect.Field r2 = C()
            if (r2 == 0) goto L_0x008d
            if (r1 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            sun.misc.Unsafe r1 = r1.f1470a
            r1.objectFieldOffset(r2)
        L_0x008d:
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            if (r1 != r2) goto L_0x0096
            r0 = 1
        L_0x0096:
            f1469i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.F5.<clinit>():void");
    }

    private static boolean A(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        try {
            Class cls3 = f1462b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Object B(Object obj, long j4) {
        return f1465e.f1470a.getObject(obj, j4);
    }

    /* access modifiers changed from: private */
    public static Field C() {
        Class<Buffer> cls = Buffer.class;
        Field d5 = d(cls, "effectiveDirectAddress");
        if (d5 != null) {
            return d5;
        }
        Field d6 = d(cls, "address");
        if (d6 == null || d6.getType() != Long.TYPE) {
            return null;
        }
        return d6;
    }

    static /* synthetic */ boolean D(Object obj, long j4) {
        if (((byte) (t(obj, -4 & j4) >>> ((int) (((~j4) & 3) << 3)))) != 0) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean E(Object obj, long j4) {
        if (((byte) (t(obj, -4 & j4) >>> ((int) ((j4 & 3) << 3)))) != 0) {
            return true;
        }
        return false;
    }

    static boolean F(Object obj, long j4) {
        return f1465e.k(obj, j4);
    }

    static double a(Object obj, long j4) {
        return f1465e.a(obj, j4);
    }

    static Object b(Class cls) {
        try {
            return f1461a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static Field d(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static void f(Object obj, long j4, double d5) {
        f1465e.c(obj, j4, d5);
    }

    static void g(Object obj, long j4, float f4) {
        f1465e.d(obj, j4, f4);
    }

    static void h(Object obj, long j4, int i4) {
        f1465e.e(obj, j4, i4);
    }

    static void i(Object obj, long j4, long j5) {
        f1465e.f(obj, j4, j5);
    }

    static void j(Object obj, long j4, Object obj2) {
        f1465e.f1470a.putObject(obj, j4, obj2);
    }

    static /* synthetic */ void l(Throwable th) {
        Logger logger = Logger.getLogger(F5.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + valueOf);
    }

    static void m(byte[] bArr, long j4, byte b5) {
        f1465e.b(bArr, f1468h + j4, b5);
    }

    static float n(Object obj, long j4) {
        return f1465e.i(obj, j4);
    }

    private static int o(Class cls) {
        if (f1467g) {
            return f1465e.f1470a.arrayBaseOffset(cls);
        }
        return -1;
    }

    static Unsafe p() {
        try {
            return (Unsafe) AccessController.doPrivileged(new H5());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int s(Class cls) {
        if (f1467g) {
            return f1465e.f1470a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int t(Object obj, long j4) {
        return f1465e.l(obj, j4);
    }

    /* access modifiers changed from: private */
    public static void u(Object obj, long j4, byte b5) {
        long j5 = -4 & j4;
        int t4 = t(obj, j5);
        int i4 = ((~((int) j4)) & 3) << 3;
        h(obj, j5, ((255 & b5) << i4) | (t4 & (~(255 << i4))));
    }

    static void v(Object obj, long j4, boolean z4) {
        f1465e.g(obj, j4, z4);
    }

    static boolean w() {
        return f1467g;
    }

    static long x(Object obj, long j4) {
        return f1465e.m(obj, j4);
    }

    /* access modifiers changed from: private */
    public static void y(Object obj, long j4, byte b5) {
        long j5 = -4 & j4;
        int i4 = (((int) j4) & 3) << 3;
        h(obj, j5, ((255 & b5) << i4) | (t(obj, j5) & (~(255 << i4))));
    }

    static boolean z() {
        return f1466f;
    }
}
