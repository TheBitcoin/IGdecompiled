package m0;

import java.util.Iterator;

public abstract class S implements Iterator {
    protected S() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
