package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class b implements Collection, Serializable {
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f5142a;

    public abstract boolean contains(Object obj);

    public abstract Iterator iterator();

    public abstract boolean remove(Object obj);

    public b(ConcurrentHashMap concurrentHashMap) {
        this.f5142a = concurrentHashMap;
    }

    public final void clear() {
        this.f5142a.clear();
    }

    public final int size() {
        return this.f5142a.size();
    }

    public final boolean isEmpty() {
        return this.f5142a.isEmpty();
    }

    public final Object[] toArray() {
        long j4 = this.f5142a.j();
        if (j4 < 0) {
            j4 = 0;
        }
        if (j4 <= 2147483639) {
            int i4 = (int) j4;
            Object[] objArr = new Object[i4];
            Iterator it = iterator();
            int i5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i5 == i4) {
                    int i6 = 2147483639;
                    if (i4 < 2147483639) {
                        if (i4 < 1073741819) {
                            i6 = (i4 >>> 1) + 1 + i4;
                        }
                        objArr = Arrays.copyOf(objArr, i6);
                        i4 = i6;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                objArr[i5] = next;
                i5++;
            }
            if (i5 == i4) {
                return objArr;
            }
            return Arrays.copyOf(objArr, i5);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        long j4 = this.f5142a.j();
        if (j4 < 0) {
            j4 = 0;
        }
        if (j4 <= 2147483639) {
            int i4 = (int) j4;
            if (objArr.length >= i4) {
                objArr2 = objArr;
            } else {
                objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
            }
            int length = objArr2.length;
            Iterator it = iterator();
            int i5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i5 == length) {
                    int i6 = 2147483639;
                    if (length < 2147483639) {
                        if (length < 1073741819) {
                            i6 = (length >>> 1) + 1 + length;
                        }
                        objArr2 = Arrays.copyOf(objArr2, i6);
                        length = i6;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                objArr2[i5] = next;
                i5++;
            }
            if (objArr == objArr2 && i5 < length) {
                objArr2[i5] = null;
                return objArr2;
            } else if (i5 == length) {
                return objArr2;
            } else {
                return Arrays.copyOf(objArr2, i5);
            }
        } else {
            throw new OutOfMemoryError("Required array size too large");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean containsAll(java.util.Collection r2) {
        /*
            r1 = this;
            if (r2 == r1) goto L_0x001a
            java.util.Iterator r2 = r2.iterator()
        L_0x0006:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r2.next()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L_0x0006
        L_0x0018:
            r2 = 0
            return r2
        L_0x001a:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.b.containsAll(java.util.Collection):boolean");
    }

    public boolean removeAll(Collection collection) {
        collection.getClass();
        l[] lVarArr = this.f5142a.f5127a;
        boolean z4 = false;
        if (lVarArr == null) {
            return false;
        }
        if (!(collection instanceof Set) || collection.size() <= lVarArr.length) {
            for (Object remove : collection) {
                z4 |= remove(remove);
            }
            return z4;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z4 = true;
            }
        }
        return z4;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z4 = true;
            }
        }
        return z4;
    }
}
