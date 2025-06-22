package j$.util;

import java.util.ListIterator;
import java.util.function.Consumer;

/* renamed from: j$.util.o  reason: case insensitive filesystem */
public final class C1140o implements ListIterator, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public final ListIterator f5244a;

    public C1140o(C1141p pVar, int i4) {
        this.f5244a = pVar.f5249b.listIterator(i4);
    }

    public final boolean hasNext() {
        return this.f5244a.hasNext();
    }

    public final Object next() {
        return this.f5244a.next();
    }

    public final boolean hasPrevious() {
        return this.f5244a.hasPrevious();
    }

    public final Object previous() {
        return this.f5244a.previous();
    }

    public final int nextIndex() {
        return this.f5244a.nextIndex();
    }

    public final int previousIndex() {
        return this.f5244a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void forEachRemaining(Consumer consumer) {
        C1127b.t(this.f5244a, consumer);
    }
}
