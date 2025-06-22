package q3;

import d3.l;

public abstract class g {
    public static final d a(int i4, a aVar, l lVar) {
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 == Integer.MAX_VALUE) {
                        return new b(Integer.MAX_VALUE, lVar);
                    }
                    if (aVar == a.SUSPEND) {
                        return new b(i4, lVar);
                    }
                    return new p(i4, aVar, lVar);
                } else if (aVar == a.SUSPEND) {
                    return new b(0, lVar);
                } else {
                    return new p(1, aVar, lVar);
                }
            } else if (aVar == a.SUSPEND) {
                return new p(1, a.DROP_OLDEST, lVar);
            } else {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
        } else if (aVar == a.SUSPEND) {
            return new b(d.f4087l0.a(), lVar);
        } else {
            return new p(1, aVar, lVar);
        }
    }

    public static /* synthetic */ d b(int i4, a aVar, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i5 & 4) != 0) {
            lVar = null;
        }
        return a(i4, aVar, lVar);
    }
}
