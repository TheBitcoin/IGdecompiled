package s;

import O2.a;

/* renamed from: s.a  reason: case insensitive filesystem */
public final class C1044a implements a {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4330c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile a f4331a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f4332b = f4330c;

    private C1044a(a aVar) {
        this.f4331a = aVar;
    }

    public static a a(a aVar) {
        d.b(aVar);
        if (aVar instanceof C1044a) {
            return aVar;
        }
        return new C1044a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f4330c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public Object get() {
        Object obj;
        Object obj2 = this.f4332b;
        Object obj3 = f4330c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f4332b;
                if (obj == obj3) {
                    obj = this.f4331a.get();
                    this.f4332b = b(this.f4332b, obj);
                    this.f4331a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
