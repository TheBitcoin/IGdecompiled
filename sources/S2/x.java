package S2;

import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.m;

abstract class x extends w {
    public static SortedSet z(Iterable iterable) {
        m.e(iterable, "<this>");
        return (SortedSet) y.X(iterable, new TreeSet());
    }
}
