package o3;

import V2.d;
import d3.l;

/* renamed from: o3.m  reason: case insensitive filesystem */
public interface C0989m extends d {

    /* renamed from: o3.m$a */
    public static final class a {
        public static /* synthetic */ boolean a(C0989m mVar, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return mVar.y(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    void D(Object obj);

    Object b(Object obj, Object obj2, l lVar);

    void c(Object obj, l lVar);

    void e(G g4, Object obj);

    void q(l lVar);

    boolean y(Throwable th);
}
