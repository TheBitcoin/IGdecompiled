package j$.sun.misc;

import j$.util.concurrent.l;
import j$.util.concurrent.q;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f4833b;

    /* renamed from: a  reason: collision with root package name */
    public final Unsafe f4834a;

    static {
        Field g4 = g();
        g4.setAccessible(true);
        try {
            f4833b = new a((Unsafe) g4.get((Object) null));
        } catch (IllegalAccessException e5) {
            throw new AssertionError("Couldn't get the Unsafe", e5);
        }
    }

    public a(Unsafe unsafe) {
        this.f4834a = unsafe;
    }

    public static Field g() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e5) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e5);
        }
    }

    public final int e(q qVar, long j4) {
        while (true) {
            int intVolatile = this.f4834a.getIntVolatile(qVar, j4);
            q qVar2 = qVar;
            long j5 = j4;
            if (this.f4834a.compareAndSwapInt(qVar2, j5, intVolatile, intVolatile - 4)) {
                return intVolatile;
            }
            qVar = qVar2;
            j4 = j5;
        }
    }

    public final long i(Field field) {
        return this.f4834a.objectFieldOffset(field);
    }

    public final long h(Class cls, String str) {
        try {
            return i(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e5) {
            throw new AssertionError("Cannot find field:", e5);
        }
    }

    public final int a() {
        return this.f4834a.arrayBaseOffset(l[].class);
    }

    public final int b() {
        return this.f4834a.arrayIndexScale(l[].class);
    }

    public final Object f(Object obj, long j4) {
        return this.f4834a.getObjectVolatile(obj, j4);
    }

    public final void j(Object obj, long j4, l lVar) {
        this.f4834a.putObjectVolatile(obj, j4, lVar);
    }

    public final boolean c(Object obj, long j4, int i4, int i5) {
        return this.f4834a.compareAndSwapInt(obj, j4, i4, i5);
    }

    public final boolean d(Object obj, long j4, long j5, long j6) {
        return this.f4834a.compareAndSwapLong(obj, j4, j5, j6);
    }
}
