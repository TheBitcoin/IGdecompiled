package S2;

import e3.a;
import java.util.Iterator;

/* renamed from: S2.n  reason: case insensitive filesystem */
public abstract class C1600n implements Iterator, a {
    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
