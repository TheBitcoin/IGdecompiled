package G3;

import D3.C2451B;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set f23343a = new LinkedHashSet();

    public synchronized void a(C2451B b5) {
        this.f23343a.remove(b5);
    }

    public synchronized void b(C2451B b5) {
        this.f23343a.add(b5);
    }

    public synchronized boolean c(C2451B b5) {
        return this.f23343a.contains(b5);
    }
}
