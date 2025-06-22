package S2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.m;

abstract class u extends t {
    public static final void s(List list) {
        m.e(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void t(List list, Comparator comparator) {
        m.e(list, "<this>");
        m.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
