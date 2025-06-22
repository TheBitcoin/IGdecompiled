package x3;

import V2.d;

public interface a {

    /* renamed from: x3.a$a  reason: collision with other inner class name */
    public static final class C0052a {
        public static /* synthetic */ boolean a(a aVar, Object obj, int i4, Object obj2) {
            if (obj2 == null) {
                if ((i4 & 1) != 0) {
                    obj = null;
                }
                return aVar.a(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void b(a aVar, Object obj, int i4, Object obj2) {
            if (obj2 == null) {
                if ((i4 & 1) != 0) {
                    obj = null;
                }
                aVar.d(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    boolean a(Object obj);

    boolean b();

    Object c(Object obj, d dVar);

    void d(Object obj);
}
