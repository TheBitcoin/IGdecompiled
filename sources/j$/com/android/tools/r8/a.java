package j$.com.android.tools.r8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.ZoneOffset;
import j$.time.c;
import j$.time.chrono.C1116a;
import j$.time.chrono.C1117b;
import j$.time.chrono.C1120e;
import j$.time.chrono.C1124i;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.m;
import j$.time.chrono.s;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Objects;
import j$.util.concurrent.l;
import j$.util.concurrent.t;
import j$.util.function.b;
import j$.util.function.d;
import j$.util.function.e;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import sun.misc.Unsafe;

public abstract /* synthetic */ class a {
    public static /* synthetic */ long A(long j4, long j5) {
        long j6 = j4 % j5;
        if (j6 == 0) {
            return 0;
        }
        return (((j4 ^ j5) >> 63) | 1) > 0 ? j6 : j6 + j5;
    }

    public static /* synthetic */ long B(long j4, long j5) {
        long j6 = j4 / j5;
        return (j4 - (j5 * j6) != 0 && (((j4 ^ j5) >> 63) | 1) < 0) ? j6 - 1 : j6;
    }

    public static /* synthetic */ long C(long j4, long j5) {
        long j6 = j4 - j5;
        boolean z4 = false;
        boolean z5 = (j5 ^ j4) >= 0;
        if ((j4 ^ j6) >= 0) {
            z4 = true;
        }
        if (z5 || z4) {
            return j6;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long w(long j4, int i4) {
        long j5 = (long) i4;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j5) + Long.numberOfLeadingZeros(j5) + Long.numberOfLeadingZeros(~j4) + Long.numberOfLeadingZeros(j4);
        if (numberOfLeadingZeros > 65) {
            return j4 * j5;
        }
        if (numberOfLeadingZeros >= 64) {
            boolean z4 = false;
            int i5 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
            boolean z5 = i5 >= 0;
            if (j5 != Long.MIN_VALUE) {
                z4 = true;
            }
            if (z4 || z5) {
                long j6 = j4 * j5;
                if (i5 == 0 || j6 / j4 == j5) {
                    return j6;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long x(long j4, long j5) {
        long j6 = j4 + j5;
        boolean z4 = false;
        boolean z5 = (j5 ^ j4) < 0;
        if ((j4 ^ j6) >= 0) {
            z4 = true;
        }
        if (z5 || z4) {
            return j6;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ AbstractMap.SimpleImmutableEntry y(String str, String str2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(str), Objects.requireNonNull(str2));
    }

    public static /* synthetic */ boolean z(Unsafe unsafe, Object obj, long j4, l lVar) {
        while (true) {
            Unsafe unsafe2 = unsafe;
            Object obj2 = obj;
            long j5 = j4;
            l lVar2 = lVar;
            if (unsafe2.compareAndSwapObject(obj2, j5, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe2.getObject(obj2, j5) != null) {
                return false;
            }
            unsafe = unsafe2;
            obj = obj2;
            j4 = j5;
            lVar = lVar2;
        }
    }

    public static b d(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new b(doubleConsumer, doubleConsumer2);
    }

    public static d e(IntConsumer intConsumer, IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new d(intConsumer, intConsumer2);
    }

    public static e f(LongConsumer longConsumer, LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new e(longConsumer, longConsumer2);
    }

    public static t b(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new t(1, (Object) biConsumer, (Object) biConsumer2);
    }

    public static t c(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new t(biFunction, function);
    }

    public static void j(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static String D(Object obj, Object obj2) {
        String str;
        String obj3;
        String str2 = "null";
        if (obj == null || (str = obj.toString()) == null) {
            str = str2;
        }
        int length = str.length();
        if (!(obj2 == null || (obj3 = obj2.toString()) == null)) {
            str2 = obj3;
        }
        int length2 = str2.length();
        char[] cArr = new char[(length + length2 + 1)];
        str.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str2.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    public static boolean o(m mVar, q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.ERA : qVar != null && qVar.m(mVar);
    }

    public static j$.time.chrono.l v(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        Object obj = (j$.time.chrono.l) nVar.p(r.f5033b);
        s sVar = s.f4904c;
        if (obj == null) {
            obj = Objects.requireNonNull(sVar, "defaultObj");
        }
        return (j$.time.chrono.l) obj;
    }

    public static int k(ChronoZonedDateTime chronoZonedDateTime, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.a(chronoZonedDateTime, qVar);
        }
        int i4 = C1124i.f4882a[((j$.time.temporal.a) qVar).ordinal()];
        if (i4 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i4 != 2) {
            return chronoZonedDateTime.y().k(qVar);
        } else {
            return chronoZonedDateTime.g().f4853b;
        }
    }

    public static int l(m mVar, j$.time.temporal.a aVar) {
        if (aVar == j$.time.temporal.a.ERA) {
            return mVar.getValue();
        }
        return r.a(mVar, aVar);
    }

    public static long m(m mVar, q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return (long) mVar.getValue();
        }
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.k(mVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.chrono.l E(java.lang.String r4) {
        /*
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.chrono.C1116a.f4871a
            java.lang.String r0 = "id"
            j$.util.Objects.requireNonNull(r4, r0)
        L_0x0007:
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.chrono.C1116a.f4871a
            java.lang.Object r1 = r0.get(r4)
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
            if (r1 != 0) goto L_0x0019
            j$.util.concurrent.ConcurrentHashMap r1 = j$.time.chrono.C1116a.f4872b
            java.lang.Object r1 = r1.get(r4)
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
        L_0x0019:
            if (r1 == 0) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.String r1 = "ISO"
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L_0x0086
            j$.time.chrono.o r0 = j$.time.chrono.o.f4888l
            java.lang.String r2 = r0.i()
            j$.time.chrono.C1116a.j(r0, r2)
            j$.time.chrono.v r0 = j$.time.chrono.v.f4907c
            java.lang.String r2 = r0.i()
            j$.time.chrono.C1116a.j(r0, r2)
            j$.time.chrono.A r0 = j$.time.chrono.A.f4860c
            java.lang.String r2 = r0.i()
            j$.time.chrono.C1116a.j(r0, r2)
            j$.time.chrono.G r0 = j$.time.chrono.G.f4867c
            java.lang.String r2 = r0.i()
            j$.time.chrono.C1116a.j(r0, r2)
            r0 = 0
            j$.time.chrono.a[] r0 = new j$.time.chrono.C1116a[r0]     // Catch:{ all -> 0x007b }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ all -> 0x007b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x007b }
        L_0x0053:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0071
            java.lang.Object r2 = r0.next()
            j$.time.chrono.a r2 = (j$.time.chrono.C1116a) r2
            java.lang.String r3 = r2.i()
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0053
            java.lang.String r3 = r2.i()
            j$.time.chrono.C1116a.j(r2, r3)
            goto L_0x0053
        L_0x0071:
            j$.time.chrono.s r0 = j$.time.chrono.s.f4904c
            java.lang.String r1 = r0.i()
            j$.time.chrono.C1116a.j(r0, r1)
            goto L_0x0007
        L_0x007b:
            r4 = move-exception
            java.util.ServiceConfigurationError r0 = new java.util.ServiceConfigurationError
            java.lang.String r1 = r4.getMessage()
            r0.<init>(r1, r4)
            throw r0
        L_0x0086:
            java.lang.Class<j$.time.chrono.l> r0 = j$.time.chrono.l.class
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0090:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b1
            java.lang.Object r1 = r0.next()
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
            java.lang.String r2 = r1.i()
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00b0
            java.lang.String r2 = r1.s()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0090
        L_0x00b0:
            return r1
        L_0x00b1:
            j$.time.b r0 = new j$.time.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown chronology: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.com.android.tools.r8.a.E(java.lang.String):j$.time.chrono.l");
    }

    public static Object s(m mVar, j$.time.format.a aVar) {
        if (aVar == r.f5034c) {
            return j$.time.temporal.b.ERAS;
        }
        return r.c(mVar, aVar);
    }

    public static Object q(C1120e eVar, j$.time.format.a aVar) {
        if (aVar == r.f5032a || aVar == r.f5036e || aVar == r.f5035d) {
            return null;
        }
        if (aVar == r.f5038g) {
            return eVar.b();
        }
        if (aVar == r.f5033b) {
            return eVar.a();
        }
        if (aVar == r.f5034c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(eVar);
    }

    public static boolean n(C1117b bVar, q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).t();
        }
        return qVar != null && qVar.m(bVar);
    }

    public static long t(C1120e eVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((eVar.c().u() * 86400) + ((long) eVar.b().O())) - ((long) zoneOffset.f4853b);
    }

    public static Object r(ChronoZonedDateTime chronoZonedDateTime, j$.time.format.a aVar) {
        if (aVar == r.f5036e || aVar == r.f5032a) {
            return chronoZonedDateTime.r();
        }
        if (aVar == r.f5035d) {
            return chronoZonedDateTime.g();
        }
        if (aVar == r.f5038g) {
            return chronoZonedDateTime.b();
        }
        if (aVar == r.f5033b) {
            return chronoZonedDateTime.a();
        }
        if (aVar == r.f5034c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(chronoZonedDateTime);
    }

    public static int h(C1120e eVar, C1120e eVar2) {
        int z4 = eVar.c().z(eVar2.c());
        if (z4 != 0 || (z4 = eVar.b().compareTo(eVar2.b())) != 0) {
            return z4;
        }
        return ((C1116a) eVar.a()).i().compareTo(eVar2.a().i());
    }

    public static Object p(C1117b bVar, j$.time.format.a aVar) {
        if (aVar == r.f5032a || aVar == r.f5036e || aVar == r.f5035d || aVar == r.f5038g) {
            return null;
        }
        if (aVar == r.f5033b) {
            return bVar.a();
        }
        if (aVar == r.f5034c) {
            return j$.time.temporal.b.DAYS;
        }
        return aVar.a(bVar);
    }

    public static j$.time.temporal.m a(C1117b bVar, j$.time.temporal.m mVar) {
        return mVar.d(bVar.u(), j$.time.temporal.a.EPOCH_DAY);
    }

    public static long u(ChronoZonedDateTime chronoZonedDateTime) {
        return ((chronoZonedDateTime.c().u() * 86400) + ((long) chronoZonedDateTime.b().O())) - ((long) chronoZonedDateTime.g().f4853b);
    }

    public static int i(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int compare = Long.compare(chronoZonedDateTime.B(), chronoZonedDateTime2.B());
        if (compare != 0 || (compare = chronoZonedDateTime.b().f4990d - chronoZonedDateTime2.b().f4990d) != 0 || (compare = chronoZonedDateTime.y().x(chronoZonedDateTime2.y())) != 0 || (compare = chronoZonedDateTime.r().i().compareTo(chronoZonedDateTime2.r().i())) != 0) {
            return compare;
        }
        return ((C1116a) chronoZonedDateTime.a()).i().compareTo(chronoZonedDateTime2.a().i());
    }

    public static int g(C1117b bVar, C1117b bVar2) {
        int compare = Long.compare(bVar.u(), bVar2.u());
        if (compare != 0) {
            return compare;
        }
        return ((C1116a) bVar.a()).i().compareTo(bVar2.a().i());
    }
}
