package androidx.core.view;

import S2.C1601o;
import d3.l;
import e3.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TreeIterator<T> implements Iterator<T>, a {
    private final l getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, l lVar) {
        this.getChildIterator = lVar;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t4) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t4);
        if (it == null || !it.hasNext()) {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) C1601o.P(this.stack);
                C1601o.x(this.stack);
            }
            return;
        }
        this.stack.add(this.iterator);
        this.iterator = it;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
