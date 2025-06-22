package S2;

import e3.a;
import java.util.Iterator;

public abstract class F implements Iterator, a {
    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
