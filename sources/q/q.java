package q;

import java.util.Set;
import o.C0962c;
import o.h;
import o.i;
import o.j;

final class q implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Set f4017a;

    /* renamed from: b  reason: collision with root package name */
    private final p f4018b;

    /* renamed from: c  reason: collision with root package name */
    private final t f4019c;

    q(Set set, p pVar, t tVar) {
        this.f4017a = set;
        this.f4018b = pVar;
        this.f4019c = tVar;
    }

    public i a(String str, Class cls, C0962c cVar, h hVar) {
        if (this.f4017a.contains(cVar)) {
            return new s(this.f4018b, str, cVar, hVar, this.f4019c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{cVar, this.f4017a}));
    }
}
