package S2;

import e3.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.C2102f;
import kotlin.jvm.internal.m;

/* renamed from: S2.f  reason: case insensitive filesystem */
final class C1592f implements Collection, a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f8244a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8245b;

    public C1592f(Object[] objArr, boolean z4) {
        m.e(objArr, "values");
        this.f8244a = objArr;
        this.f8245b = z4;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int c() {
        return this.f8244a.length;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return C1598l.o(this.f8244a, obj);
    }

    public boolean containsAll(Collection collection) {
        m.e(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        if (this.f8244a.length == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return C2098b.a(this.f8244a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return c();
    }

    public Object[] toArray(Object[] objArr) {
        m.e(objArr, "array");
        return C2102f.b(this, objArr);
    }

    public final Object[] toArray() {
        return C1602p.b(this.f8244a, this.f8245b);
    }
}
