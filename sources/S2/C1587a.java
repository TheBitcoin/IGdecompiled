package S2;

import d3.l;
import e3.a;
import java.util.Collection;
import kotlin.jvm.internal.C2102f;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

/* renamed from: S2.a  reason: case insensitive filesystem */
public abstract class C1587a implements Collection, a {

    /* renamed from: S2.a$a  reason: collision with other inner class name */
    static final class C0106a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1587a f8236a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0106a(C1587a aVar) {
            super(1);
            this.f8236a = aVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(Object obj) {
            if (obj == this.f8236a) {
                return "(this Collection)";
            }
            return String.valueOf(obj);
        }
    }

    protected C1587a() {
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int c();

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (Object a5 : this) {
            if (m.a(a5, obj)) {
                return true;
            }
        }
        return false;
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
        if (size() == 0) {
            return true;
        }
        return false;
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

    public Object[] toArray() {
        return C2102f.a(this);
    }

    public String toString() {
        return y.O(this, ", ", "[", "]", 0, (CharSequence) null, new C0106a(this), 24, (Object) null);
    }

    public Object[] toArray(Object[] objArr) {
        m.e(objArr, "array");
        return C2102f.b(this, objArr);
    }
}
