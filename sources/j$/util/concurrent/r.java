package j$.util.concurrent;

public final class r extends l {

    /* renamed from: e  reason: collision with root package name */
    public r f5173e;

    /* renamed from: f  reason: collision with root package name */
    public r f5174f;

    /* renamed from: g  reason: collision with root package name */
    public r f5175g;

    /* renamed from: h  reason: collision with root package name */
    public r f5176h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5177i;

    public r(int i4, Object obj, Object obj2, l lVar, r rVar) {
        super(i4, obj, obj2, lVar);
        this.f5173e = rVar;
    }

    public final l a(int i4, Object obj) {
        return b(i4, obj, (Class) null);
    }

    public final r b(int i4, Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        r rVar = this;
        do {
            r rVar2 = rVar.f5174f;
            r rVar3 = rVar.f5175g;
            int i5 = rVar.f5152a;
            if (i5 <= i4) {
                if (i5 >= i4) {
                    Object obj2 = rVar.f5153b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return rVar;
                    }
                    if (rVar2 != null) {
                        if (rVar3 != null) {
                            if (!(cls == null && (cls = ConcurrentHashMap.c(obj)) == null)) {
                                int i6 = ConcurrentHashMap.f5118g;
                                int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                                if (compareTo != 0) {
                                    if (compareTo >= 0) {
                                        rVar2 = rVar3;
                                    }
                                }
                            }
                            r b5 = rVar3.b(i4, obj, cls);
                            if (b5 != null) {
                                return b5;
                            }
                        }
                    }
                }
                rVar = rVar3;
                continue;
            }
            rVar = rVar2;
            continue;
        } while (rVar != null);
        return null;
    }
}
