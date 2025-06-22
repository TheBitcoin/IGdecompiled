package j3;

import kotlin.jvm.internal.m;

public interface a {

    /* renamed from: j3.a$a  reason: collision with other inner class name */
    public static final class C0258a {
        public static boolean a(a aVar, Comparable comparable) {
            m.e(comparable, "value");
            if (comparable.compareTo(aVar.getStart()) < 0 || comparable.compareTo(aVar.getEndInclusive()) > 0) {
                return false;
            }
            return true;
        }

        public static boolean b(a aVar) {
            if (aVar.getStart().compareTo(aVar.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }
    }

    Comparable getEndInclusive();

    Comparable getStart();
}
