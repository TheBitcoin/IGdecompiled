package s3;

import V2.g;
import V2.h;
import r3.C1035e;

public interface p extends C1035e {

    public static final class a {
        public static /* synthetic */ C1035e a(p pVar, g gVar, int i4, q3.a aVar, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    gVar = h.f8445a;
                }
                if ((i5 & 2) != 0) {
                    i4 = -3;
                }
                if ((i5 & 4) != 0) {
                    aVar = q3.a.SUSPEND;
                }
                return pVar.b(gVar, i4, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    C1035e b(g gVar, int i4, q3.a aVar);
}
