package j$.util.concurrent;

import j$.util.stream.B;
import j$.util.stream.C1144a;
import j$.util.stream.C1190j0;
import j$.util.stream.IntStream;
import j$.util.stream.W2;
import j$.util.y0;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ThreadLocalRandom extends Random {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f5133d = new ThreadLocal();

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f5134e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    public static final v f5135f = new ThreadLocal();

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLong f5136g = new AtomicLong(f(System.currentTimeMillis()) ^ f(System.nanoTime()));
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};
    private static final long serialVersionUID = -5851777807851030925L;

    /* renamed from: a  reason: collision with root package name */
    public long f5137a;

    /* renamed from: b  reason: collision with root package name */
    public int f5138b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5139c;

    public /* synthetic */ ThreadLocalRandom(int i4) {
        this();
    }

    public static int e(long j4) {
        long j5 = (j4 ^ (j4 >>> 33)) * -49064778989728563L;
        return (int) (((j5 ^ (j5 >>> 33)) * -4265267296055464877L) >>> 32);
    }

    public static long f(long j4) {
        long j5 = (j4 ^ (j4 >>> 33)) * -49064778989728563L;
        long j6 = (j5 ^ (j5 >>> 33)) * -4265267296055464877L;
        return j6 ^ (j6 >>> 33);
    }

    private ThreadLocalRandom() {
        this.f5139c = true;
    }

    public static final void d() {
        int addAndGet = f5134e.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long f4 = f(f5136g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f5135f.get();
        threadLocalRandom.f5137a = f4;
        threadLocalRandom.f5138b = addAndGet;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f5135f.get();
        if (threadLocalRandom.f5138b == 0) {
            d();
        }
        return threadLocalRandom;
    }

    public final void setSeed(long j4) {
        if (this.f5139c) {
            throw new UnsupportedOperationException();
        }
    }

    public final long g() {
        long j4 = this.f5137a - 7046029254386353131L;
        this.f5137a = j4;
        return j4;
    }

    public final int next(int i4) {
        return nextInt() >>> (32 - i4);
    }

    public final long c(long j4, long j5) {
        long f4 = f(g());
        if (j4 >= j5) {
            return f4;
        }
        long j6 = j5 - j4;
        long j7 = j6 - 1;
        if ((j6 & j7) == 0) {
            return (f4 & j7) + j4;
        }
        if (j6 > 0) {
            while (true) {
                long j8 = f4 >>> 1;
                long j9 = j8 + j7;
                long j10 = j8 % j6;
                if (j9 - j10 >= 0) {
                    return j10 + j4;
                }
                f4 = f(g());
            }
        } else {
            while (true) {
                if (f4 >= j4 && f4 < j5) {
                    return f4;
                }
                f4 = f(g());
            }
        }
    }

    public final int b(int i4, int i5) {
        int e5 = e(g());
        if (i4 >= i5) {
            return e5;
        }
        int i6 = i5 - i4;
        int i7 = i6 - 1;
        if ((i6 & i7) == 0) {
            return (e5 & i7) + i4;
        }
        if (i6 > 0) {
            int i8 = e5 >>> 1;
            while (true) {
                int i9 = i8 + i7;
                int i10 = i8 % i6;
                if (i9 - i10 >= 0) {
                    return i10 + i4;
                }
                i8 = e(g()) >>> 1;
            }
        } else {
            while (true) {
                if (e5 >= i4 && e5 < i5) {
                    return e5;
                }
                e5 = e(g());
            }
        }
    }

    public final double a(double d5, double d6) {
        double nextLong = ((double) (nextLong() >>> 11)) * 1.1102230246251565E-16d;
        if (d5 >= d6) {
            return nextLong;
        }
        double d7 = ((d6 - d5) * nextLong) + d5;
        return d7 >= d6 ? Double.longBitsToDouble(Double.doubleToLongBits(d6) - 1) : d7;
    }

    public final int nextInt() {
        return e(g());
    }

    public final int nextInt(int i4) {
        if (i4 > 0) {
            int e5 = e(g());
            int i5 = i4 - 1;
            if ((i4 & i5) == 0) {
                return e5 & i5;
            }
            while (true) {
                int i6 = e5 >>> 1;
                int i7 = i6 + i5;
                int i8 = i6 % i4;
                if (i7 - i8 >= 0) {
                    return i8;
                }
                e5 = e(g());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public final long nextLong() {
        return f(g());
    }

    public final double nextDouble() {
        return ((double) (f(g()) >>> 11)) * 1.1102230246251565E-16d;
    }

    public final boolean nextBoolean() {
        return e(g()) < 0;
    }

    public final float nextFloat() {
        return ((float) (e(g()) >>> 8)) * 5.9604645E-8f;
    }

    public final double nextGaussian() {
        ThreadLocal threadLocal = f5133d;
        Double d5 = (Double) threadLocal.get();
        if (d5 != null) {
            threadLocal.set((Object) null);
            return d5.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d6 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d6 < 1.0d && d6 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d6) * -2.0d) / d6);
                threadLocal.set(Double.valueOf(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final IntStream ints(long j4) {
        if (j4 >= 0) {
            x xVar = new x(0, j4, Integer.MAX_VALUE, 0);
            return IntStream.Wrapper.convert(new C1144a(xVar, W2.m(xVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints() {
        x xVar = new x(0, Long.MAX_VALUE, Integer.MAX_VALUE, 0);
        return IntStream.Wrapper.convert(new C1144a(xVar, W2.m(xVar), false));
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints(long j4, int i4, int i5) {
        if (j4 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (i4 < i5) {
            x xVar = new x(0, j4, i4, i5);
            return IntStream.Wrapper.convert(new C1144a(xVar, W2.m(xVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    public final java.util.stream.IntStream ints(int i4, int i5) {
        if (i4 < i5) {
            x xVar = new x(0, Long.MAX_VALUE, i4, i5);
            return IntStream.Wrapper.convert(new C1144a(xVar, W2.m(xVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r13v2, types: [j$.util.stream.k0, j$.util.stream.a] */
    public final LongStream longs(long j4) {
        if (j4 >= 0) {
            y yVar = new y(0, j4, Long.MAX_VALUE, 0);
            return C1190j0.w(new C1144a(yVar, W2.m(yVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.k0, j$.util.stream.a] */
    public final LongStream longs() {
        y yVar = new y(0, Long.MAX_VALUE, Long.MAX_VALUE, 0);
        return C1190j0.w(new C1144a(yVar, W2.m(yVar), false));
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [j$.util.stream.k0, j$.util.stream.a] */
    public final LongStream longs(long j4, long j5, long j6) {
        if (j4 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (j5 < j6) {
            y yVar = new y(0, j4, j5, j6);
            return C1190j0.w(new C1144a(yVar, W2.m(yVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.k0, j$.util.stream.a] */
    public final LongStream longs(long j4, long j5) {
        if (j4 < j5) {
            y yVar = new y(0, Long.MAX_VALUE, j4, j5);
            return C1190j0.w(new C1144a(yVar, W2.m(yVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r13v2, types: [j$.util.stream.a, j$.util.stream.C] */
    public final DoubleStream doubles(long j4) {
        if (j4 >= 0) {
            w wVar = new w(0, j4, Double.MAX_VALUE, 0.0d);
            return B.w(new C1144a(wVar, W2.m(wVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [j$.util.stream.a, j$.util.stream.C] */
    public final DoubleStream doubles() {
        w wVar = new w(0, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d);
        return B.w(new C1144a(wVar, W2.m(wVar), false));
    }

    /* JADX WARNING: type inference failed for: r11v3, types: [j$.util.stream.a, j$.util.stream.C] */
    public final DoubleStream doubles(long j4, double d5, double d6) {
        if (j4 < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (d5 < d6) {
            w wVar = new w(0, j4, d5, d6);
            return B.w(new C1144a(wVar, W2.m(wVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARNING: type inference failed for: r11v2, types: [j$.util.stream.a, j$.util.stream.C] */
    public final DoubleStream doubles(double d5, double d6) {
        if (d5 < d6) {
            w wVar = new w(0, Long.MAX_VALUE, d5, d6);
            return B.w(new C1144a(wVar, W2.m(wVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.ThreadLocal, j$.util.concurrent.v] */
    static {
        if (((Boolean) AccessController.doPrivileged(new y0(1))).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j4 = ((long) seed[0]) & 255;
            for (int i4 = 1; i4 < 8; i4++) {
                j4 = (j4 << 8) | (((long) seed[i4]) & 255);
            }
            f5136g.set(j4);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.f5137a);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    private Object readResolve() {
        return current();
    }
}
