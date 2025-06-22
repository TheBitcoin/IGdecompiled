package j$.util;

import j$.time.format.r;
import j$.util.stream.C1232t1;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/* renamed from: j$.util.s  reason: case insensitive filesystem */
public final class C1143s extends C1260v {
    private static final long serialVersionUID = 7854390611657943733L;

    public final void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        Collection$EL.a(this.f5239a, new r(1, consumer));
    }

    public final i0 spliterator() {
        return new r(Collection$EL.c(this.f5239a));
    }

    public final Stream stream() {
        return C1232t1.a0(spliterator(), false);
    }

    public final Stream parallelStream() {
        return C1232t1.a0(spliterator(), true);
    }

    public final Iterator iterator() {
        return new C1138m(this);
    }

    public final Object[] toArray() {
        Object[] array = this.f5239a.toArray();
        for (int i4 = 0; i4 < array.length; i4++) {
            array[i4] = new C1142q((Map.Entry) array[i4]);
        }
        return array;
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.f5239a.toArray(objArr.length == 0 ? objArr : Arrays.copyOf(objArr, 0));
        for (int i4 = 0; i4 < array.length; i4++) {
            array[i4] = new C1142q((Map.Entry) array[i4]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return this.f5239a.contains(new C1142q((Map.Entry) obj));
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this.f5239a.size()) {
            return false;
        }
        return containsAll(set);
    }
}
