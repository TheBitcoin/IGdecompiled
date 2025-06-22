package m0;

import java.util.Comparator;
import java.util.SortedSet;
import l0.h;

abstract class P {
    public static Comparator a(SortedSet sortedSet) {
        Comparator comparator = sortedSet.comparator();
        if (comparator == null) {
            return G.c();
        }
        return comparator;
    }

    public static boolean b(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        h.i(comparator);
        h.i(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof O)) {
            return false;
        } else {
            comparator2 = ((O) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
