package S2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: S2.b  reason: case insensitive filesystem */
public abstract class C1588b extends C1587a implements List, e3.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8237a = new a((C2103g) null);

    /* renamed from: S2.b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("startIndex: " + i4 + ", endIndex: " + i5 + ", size: " + i6);
            } else if (i4 > i5) {
                throw new IllegalArgumentException("startIndex: " + i4 + " > endIndex: " + i5);
            }
        }

        public final void b(int i4, int i5) {
            if (i4 < 0 || i4 >= i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void c(int i4, int i5) {
            if (i4 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void d(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + i6);
            } else if (i4 > i5) {
                throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i5);
            }
        }

        public final int e(int i4, int i5) {
            int i6 = i4 + (i4 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 <= 0) {
                return i6;
            }
            if (i5 > 2147483639) {
                return Integer.MAX_VALUE;
            }
            return 2147483639;
        }

        public final boolean f(Collection collection, Collection collection2) {
            m.e(collection, "c");
            m.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object a5 : collection) {
                if (!m.a(a5, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            int i4;
            m.e(collection, "c");
            int i5 = 1;
            for (Object next : collection) {
                int i6 = i5 * 31;
                if (next != null) {
                    i4 = next.hashCode();
                } else {
                    i4 = 0;
                }
                i5 = i6 + i4;
            }
            return i5;
        }

        private a() {
        }
    }

    /* renamed from: S2.b$b  reason: collision with other inner class name */
    private class C0107b implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private int f8238a;

        public C0107b() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f8238a;
        }

        /* access modifiers changed from: protected */
        public final void b(int i4) {
            this.f8238a = i4;
        }

        public boolean hasNext() {
            if (this.f8238a < C1588b.this.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                C1588b bVar = C1588b.this;
                int i4 = this.f8238a;
                this.f8238a = i4 + 1;
                return bVar.get(i4);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: S2.b$c */
    private class c extends C0107b implements ListIterator, e3.a {
        public c(int i4) {
            super();
            C1588b.f8237a.c(i4, C1588b.this.size());
            b(i4);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        public int nextIndex() {
            return a();
        }

        public Object previous() {
            if (hasPrevious()) {
                C1588b bVar = C1588b.this;
                b(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: S2.b$d */
    private static final class d extends C1588b implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private final C1588b f8241b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8242c;

        /* renamed from: d  reason: collision with root package name */
        private int f8243d;

        public d(C1588b bVar, int i4, int i5) {
            m.e(bVar, "list");
            this.f8241b = bVar;
            this.f8242c = i4;
            C1588b.f8237a.d(i4, i5, bVar.size());
            this.f8243d = i5 - i4;
        }

        public int c() {
            return this.f8243d;
        }

        public Object get(int i4) {
            C1588b.f8237a.b(i4, this.f8243d);
            return this.f8241b.get(this.f8242c + i4);
        }
    }

    protected C1588b() {
    }

    public void add(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f8237a.f(this, (Collection) obj);
    }

    public abstract Object get(int i4);

    public int hashCode() {
        return f8237a.g(this);
    }

    public int indexOf(Object obj) {
        int i4 = 0;
        for (Object a5 : this) {
            if (m.a(a5, obj)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public Iterator iterator() {
        return new C0107b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (m.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new c(0);
    }

    public Object remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int i4, int i5) {
        return new d(this, i4, i5);
    }

    public ListIterator listIterator(int i4) {
        return new c(i4);
    }
}
