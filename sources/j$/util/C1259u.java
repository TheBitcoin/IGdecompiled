package j$.util;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: j$.util.u  reason: case insensitive filesystem */
public final class C1259u extends C1141p implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public final List subList(int i4, int i5) {
        return new C1141p(this.f5249b.subList(i4, i5));
    }

    private Object writeReplace() {
        return new C1141p(this.f5249b);
    }
}
