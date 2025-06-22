package J3;

import N3.C2516g;
import java.util.List;

public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f23600a = new a();

    boolean a(int i4, C2516g gVar, int i5, boolean z4);

    void b(int i4, C2487b bVar);

    boolean onHeaders(int i4, List list, boolean z4);

    boolean onRequest(int i4, List list);

    class a implements l {
        a() {
        }

        public boolean a(int i4, C2516g gVar, int i5, boolean z4) {
            gVar.skip((long) i5);
            return true;
        }

        public boolean onHeaders(int i4, List list, boolean z4) {
            return true;
        }

        public boolean onRequest(int i4, List list) {
            return true;
        }

        public void b(int i4, C2487b bVar) {
        }
    }
}
