package q3;

import V2.d;
import d3.l;

public interface v {

    public static final class a {
        public static /* synthetic */ boolean a(v vVar, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return vVar.s(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    Object B(Object obj);

    boolean C();

    void f(l lVar);

    boolean s(Throwable th);

    Object t(Object obj, d dVar);
}
