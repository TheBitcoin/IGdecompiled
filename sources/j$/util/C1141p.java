package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* renamed from: j$.util.p  reason: case insensitive filesystem */
public class C1141p extends C1139n implements List, C1264z {
    private static final long serialVersionUID = -283967356065247728L;

    /* renamed from: b  reason: collision with root package name */
    public final List f5249b;

    public C1141p(List list) {
        super(list);
        this.f5249b = list;
    }

    public final boolean equals(Object obj) {
        return obj == this || this.f5249b.equals(obj);
    }

    public final int hashCode() {
        return this.f5249b.hashCode();
    }

    public final Object get(int i4) {
        return this.f5249b.get(i4);
    }

    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(int i4) {
        throw new UnsupportedOperationException();
    }

    public final int indexOf(Object obj) {
        return this.f5249b.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.f5249b.lastIndexOf(obj);
    }

    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator listIterator() {
        return new C1140o(this, 0);
    }

    public final ListIterator listIterator(int i4) {
        return new C1140o(this, i4);
    }

    public List subList(int i4, int i5) {
        return new C1141p(this.f5249b.subList(i4, i5));
    }

    private Object readResolve() {
        List list = this.f5249b;
        return list instanceof RandomAccess ? new C1141p(list) : this;
    }
}
