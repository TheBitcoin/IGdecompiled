package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* renamed from: j$.util.i  reason: case insensitive filesystem */
public class C1134i extends C1133h implements List, C1264z {
    private static final long serialVersionUID = -7754090372962971524L;

    /* renamed from: c  reason: collision with root package name */
    public final List f5219c;

    public C1134i(List list) {
        super(list);
        this.f5219c = list;
    }

    public C1134i(List list, Object obj) {
        super(list, obj);
        this.f5219c = list;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f5217b) {
            equals = this.f5219c.equals(obj);
        }
        return equals;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f5217b) {
            hashCode = this.f5219c.hashCode();
        }
        return hashCode;
    }

    public final Object get(int i4) {
        Object obj;
        synchronized (this.f5217b) {
            obj = this.f5219c.get(i4);
        }
        return obj;
    }

    public final Object set(int i4, Object obj) {
        Object obj2;
        synchronized (this.f5217b) {
            obj2 = this.f5219c.set(i4, obj);
        }
        return obj2;
    }

    public final void add(int i4, Object obj) {
        synchronized (this.f5217b) {
            this.f5219c.add(i4, obj);
        }
    }

    public final Object remove(int i4) {
        Object remove;
        synchronized (this.f5217b) {
            remove = this.f5219c.remove(i4);
        }
        return remove;
    }

    public final int indexOf(Object obj) {
        int indexOf;
        synchronized (this.f5217b) {
            indexOf = this.f5219c.indexOf(obj);
        }
        return indexOf;
    }

    public final int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.f5217b) {
            lastIndexOf = this.f5219c.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public final boolean addAll(int i4, Collection collection) {
        boolean addAll;
        synchronized (this.f5217b) {
            addAll = this.f5219c.addAll(i4, collection);
        }
        return addAll;
    }

    public final ListIterator listIterator() {
        return this.f5219c.listIterator();
    }

    public final ListIterator listIterator(int i4) {
        return this.f5219c.listIterator(i4);
    }

    public List subList(int i4, int i5) {
        C1134i iVar;
        synchronized (this.f5217b) {
            iVar = new C1134i(this.f5219c.subList(i4, i5), this.f5217b);
        }
        return iVar;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Throwable, java.lang.Object, java.util.function.UnaryOperator] */
    public final void replaceAll(UnaryOperator unaryOperator) {
        synchronized (this.f5217b) {
            try {
                List list = this.f5219c;
                ? r22 = 0;
                if (list instanceof C1264z) {
                    ((C1264z) list).replaceAll(r22);
                } else {
                    Objects.requireNonNull(r22);
                    ListIterator listIterator = list.listIterator();
                    if (listIterator.hasNext()) {
                        r22.apply(listIterator.next());
                        throw r22;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void sort(Comparator comparator) {
        synchronized (this.f5217b) {
            C1127b.w(this.f5219c, comparator);
        }
    }

    private Object readResolve() {
        List list = this.f5219c;
        return list instanceof RandomAccess ? new C1134i(list) : this;
    }
}
