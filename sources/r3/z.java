package r3;

import V2.g;
import q3.a;
import s3.h;
import t3.F;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static final F f4329a = new F("NO_VALUE");

    public static final s a(int i4, int i5, a aVar) {
        if (i4 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i4).toString());
        } else if (i5 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i5).toString());
        } else if (i4 > 0 || i5 > 0 || aVar == a.SUSPEND) {
            int i6 = i5 + i4;
            if (i6 < 0) {
                i6 = Integer.MAX_VALUE;
            }
            return new y(i4, i6, aVar);
        } else {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
        }
    }

    public static final C1035e d(x xVar, g gVar, int i4, a aVar) {
        if ((i4 == 0 || i4 == -3) && aVar == a.SUSPEND) {
            return xVar;
        }
        return new h(xVar, gVar, i4, aVar);
    }

    /* access modifiers changed from: private */
    public static final Object e(Object[] objArr, long j4) {
        return objArr[(objArr.length - 1) & ((int) j4)];
    }

    /* access modifiers changed from: private */
    public static final void f(Object[] objArr, long j4, Object obj) {
        objArr[(objArr.length - 1) & ((int) j4)] = obj;
    }
}
