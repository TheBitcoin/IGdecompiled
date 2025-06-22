package j$.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.f  reason: case insensitive filesystem */
public enum C1131f implements Comparator {
    ;

    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    public final Comparator thenComparing(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new C1130e(this, comparator);
    }

    public final Comparator thenComparing(Function function, Comparator comparator) {
        return C1127b.y(this, Comparator$CC.comparing(function, comparator));
    }

    public final Comparator reversed() {
        return Collections.reverseOrder();
    }

    public final Comparator thenComparing(Function function) {
        Objects.requireNonNull(function);
        return C1127b.y(this, new C1129d(2, function));
    }

    public final Comparator thenComparingInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return C1127b.y(this, new C1129d(0, toIntFunction));
    }

    public final Comparator thenComparingLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return C1127b.y(this, new C1129d(3, toLongFunction));
    }

    public final Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return C1127b.y(this, new C1129d(1, toDoubleFunction));
    }
}
