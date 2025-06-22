package j$.util;

import j$.util.stream.Stream;
import j$.util.stream.U2;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* renamed from: j$.util.h  reason: case insensitive filesystem */
public class C1133h implements Collection, Serializable, C1128c {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: a  reason: collision with root package name */
    public final Collection f5216a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5217b;

    public final Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    public C1133h(Collection collection) {
        this.f5216a = (Collection) Objects.requireNonNull(collection);
        this.f5217b = this;
    }

    public C1133h(Collection collection, Object obj) {
        this.f5216a = (Collection) Objects.requireNonNull(collection);
        this.f5217b = Objects.requireNonNull(obj);
    }

    public final int size() {
        int size;
        synchronized (this.f5217b) {
            size = this.f5216a.size();
        }
        return size;
    }

    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f5217b) {
            isEmpty = this.f5216a.isEmpty();
        }
        return isEmpty;
    }

    public final boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f5217b) {
            contains = this.f5216a.contains(obj);
        }
        return contains;
    }

    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f5217b) {
            array = this.f5216a.toArray();
        }
        return array;
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f5217b) {
            array = this.f5216a.toArray(objArr);
        }
        return array;
    }

    public final Iterator iterator() {
        return this.f5216a.iterator();
    }

    public final boolean add(Object obj) {
        boolean add;
        synchronized (this.f5217b) {
            add = this.f5216a.add(obj);
        }
        return add;
    }

    public final boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f5217b) {
            remove = this.f5216a.remove(obj);
        }
        return remove;
    }

    public final boolean containsAll(Collection collection) {
        boolean containsAll;
        synchronized (this.f5217b) {
            containsAll = this.f5216a.containsAll(collection);
        }
        return containsAll;
    }

    public final boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.f5217b) {
            addAll = this.f5216a.addAll(collection);
        }
        return addAll;
    }

    public final boolean removeAll(Collection collection) {
        boolean removeAll;
        synchronized (this.f5217b) {
            removeAll = this.f5216a.removeAll(collection);
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        boolean retainAll;
        synchronized (this.f5217b) {
            retainAll = this.f5216a.retainAll(collection);
        }
        return retainAll;
    }

    public final void clear() {
        synchronized (this.f5217b) {
            this.f5216a.clear();
        }
    }

    public final String toString() {
        String obj;
        synchronized (this.f5217b) {
            obj = this.f5216a.toString();
        }
        return obj;
    }

    public final void forEach(Consumer consumer) {
        synchronized (this.f5217b) {
            Collection$EL.a(this.f5216a, consumer);
        }
    }

    public final boolean removeIf(Predicate predicate) {
        boolean z4;
        synchronized (this.f5217b) {
            Collection collection = this.f5216a;
            if (collection instanceof C1128c) {
                z4 = ((C1128c) collection).removeIf(predicate);
            } else {
                Objects.requireNonNull(predicate);
                Iterator it = collection.iterator();
                boolean z5 = false;
                while (it.hasNext()) {
                    if (predicate.test(it.next())) {
                        it.remove();
                        z5 = true;
                    }
                }
                z4 = z5;
            }
        }
        return z4;
    }

    public final i0 spliterator() {
        return Collection$EL.c(this.f5216a);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m18spliterator() {
        return h0.a(Collection$EL.c(this.f5216a));
    }

    public final Stream stream() {
        return Collection$EL.stream(this.f5216a);
    }

    /* renamed from: stream  reason: collision with other method in class */
    public final java.util.stream.Stream m19stream() {
        return U2.w(Collection$EL.stream(this.f5216a));
    }

    public final Stream parallelStream() {
        return Collection$EL.b(this.f5216a);
    }

    /* renamed from: parallelStream  reason: collision with other method in class */
    public final java.util.stream.Stream m17parallelStream() {
        return U2.w(Collection$EL.b(this.f5216a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f5217b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
