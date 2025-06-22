package j$.util.stream;

import j$.time.format.a;
import j$.time.format.r;
import j$.util.function.c;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public final class Collectors {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f5263a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set f5264b = Collections.EMPTY_SET;

    static {
        C1179h hVar = C1179h.CONCURRENT;
        C1179h hVar2 = C1179h.UNORDERED;
        C1179h hVar3 = C1179h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2));
        f5263a = Collections.unmodifiableSet(EnumSet.of(hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2));
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new C1194k(new a(11), new a(12), new a(15), f5263a);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new C1194k(new r(5, charSequence), new a(17), new a(18), new a(19), f5264b);
    }

    public static void a(double[] dArr, double d5) {
        double d6 = d5 - dArr[1];
        double d7 = dArr[0];
        double d8 = d7 + d6;
        dArr[1] = (d8 - d7) - d6;
        dArr[0] = d8;
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        return new C1194k(new a(20), new c(function, function2, 2), new a(9), f5263a);
    }
}
