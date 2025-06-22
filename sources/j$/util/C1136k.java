package j$.util;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: j$.util.k  reason: case insensitive filesystem */
public final class C1136k extends C1134i implements RandomAccess {
    private static final long serialVersionUID = 1530674583602358482L;

    public final List subList(int i4, int i5) {
        C1134i iVar;
        synchronized (this.f5217b) {
            iVar = new C1134i(this.f5219c.subList(i4, i5), this.f5217b);
        }
        return iVar;
    }

    private Object writeReplace() {
        return new C1134i(this.f5219c);
    }
}
