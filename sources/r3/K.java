package r3;

import V2.g;
import q3.a;
import s3.s;
import t3.F;

public abstract class K {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f4178a = new F("NONE");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final F f4179b = new F("PENDING");

    public static final t a(Object obj) {
        if (obj == null) {
            obj = s.f4399a;
        }
        return new J(obj);
    }

    public static final C1035e d(I i4, g gVar, int i5, a aVar) {
        if (((i5 < 0 || i5 >= 2) && i5 != -2) || aVar != a.DROP_OLDEST) {
            return z.d(i4, gVar, i5, aVar);
        }
        return i4;
    }
}
