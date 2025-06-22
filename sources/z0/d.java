package Z0;

import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f8831b;

    /* renamed from: a  reason: collision with root package name */
    private final Set f8832a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar;
        d dVar2 = f8831b;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f8831b;
                if (dVar == null) {
                    dVar = new d();
                    f8831b = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public Set b() {
        Set unmodifiableSet;
        synchronized (this.f8832a) {
            unmodifiableSet = DesugarCollections.unmodifiableSet(this.f8832a);
        }
        return unmodifiableSet;
    }
}
