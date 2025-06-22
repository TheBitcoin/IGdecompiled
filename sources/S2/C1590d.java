package S2;

import e3.b;
import java.util.AbstractList;
import java.util.List;

/* renamed from: S2.d  reason: case insensitive filesystem */
public abstract class C1590d extends AbstractList implements List, b {
    protected C1590d() {
    }

    public abstract int c();

    public abstract Object h(int i4);

    public final /* bridge */ Object remove(int i4) {
        return h(i4);
    }

    public final /* bridge */ int size() {
        return c();
    }
}
