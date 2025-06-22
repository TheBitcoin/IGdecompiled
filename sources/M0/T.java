package m0;

import java.util.ListIterator;

public abstract class T extends S implements ListIterator {
    protected T() {
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
