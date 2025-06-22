package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i4 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != DELETED) {
                if (i6 != i5) {
                    iArr[i5] = iArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.mGarbage = false;
        this.mSize = i5;
    }

    public void append(int i4, E e5) {
        int i5 = this.mSize;
        if (i5 == 0 || i4 > this.mKeys[i5 - 1]) {
            if (this.mGarbage && i5 >= this.mKeys.length) {
                gc();
            }
            int i6 = this.mSize;
            if (i6 >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i6 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                int[] iArr2 = this.mKeys;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i6] = i4;
            this.mValues[i6] = e5;
            this.mSize = i6 + 1;
            return;
        }
        put(i4, e5);
    }

    public void clear() {
        int i4 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(int i4) {
        if (indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e5) {
        if (indexOfValue(e5) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void delete(int i4) {
        remove(i4);
    }

    @Nullable
    public E get(int i4) {
        return get(i4, (Object) null);
    }

    public int indexOfKey(int i4) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i4);
    }

    public int indexOfValue(E e5) {
        if (this.mGarbage) {
            gc();
        }
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (this.mValues[i4] == e5) {
                return i4;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int keyAt(int i4) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i4];
    }

    public void put(int i4, E e5) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i4);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e5;
            return;
        }
        int i5 = ~binarySearch;
        int i6 = this.mSize;
        if (i5 < i6) {
            Object[] objArr = this.mValues;
            if (objArr[i5] == DELETED) {
                this.mKeys[i5] = i4;
                objArr[i5] = e5;
                return;
            }
        }
        if (this.mGarbage && i6 >= this.mKeys.length) {
            gc();
            i5 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i4);
        }
        int i7 = this.mSize;
        if (i7 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i7 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i8 = this.mSize;
        if (i8 - i5 != 0) {
            int[] iArr3 = this.mKeys;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i5, objArr4, i9, this.mSize - i5);
        }
        this.mKeys[i5] = i4;
        this.mValues[i5] = e5;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i4 = 0; i4 < size; i4++) {
            put(sparseArrayCompat.keyAt(i4), sparseArrayCompat.valueAt(i4));
        }
    }

    @Nullable
    public E putIfAbsent(int i4, E e5) {
        E e6 = get(i4);
        if (e6 == null) {
            put(i4, e5);
        }
        return e6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.mKeys
            int r1 = r3.mSize
            int r4 = androidx.collection.ContainerHelpers.binarySearch((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.mValues
            r1 = r0[r4]
            java.lang.Object r2 = DELETED
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.mGarbage = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.remove(int):void");
    }

    public void removeAt(int i4) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i4];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i4] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i4, int i5) {
        int min = Math.min(this.mSize, i5 + i4);
        while (i4 < min) {
            removeAt(i4);
            i4++;
        }
    }

    @Nullable
    public E replace(int i4, E e5) {
        int indexOfKey = indexOfKey(i4);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.mValues;
        E e6 = eArr[indexOfKey];
        eArr[indexOfKey] = e5;
        return e6;
    }

    public void setValueAt(int i4, E e5) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i4] = e5;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i4));
            sb.append('=');
            Object valueAt = valueAt(i4);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i4) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i4];
    }

    public SparseArrayCompat(int i4) {
        this.mGarbage = false;
        if (i4 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i4);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(int r3, E r4) {
        /*
            r2 = this;
            int[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.binarySearch((int[]) r0, (int) r1, (int) r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.mValues
            r3 = r0[r3]
            java.lang.Object r0 = DELETED
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.get(int, java.lang.Object):java.lang.Object");
    }

    public boolean replace(int i4, E e5, E e6) {
        int indexOfKey = indexOfKey(i4);
        if (indexOfKey < 0) {
            return false;
        }
        E e7 = this.mValues[indexOfKey];
        if (e7 != e5 && (e5 == null || !e5.equals(e7))) {
            return false;
        }
        this.mValues[indexOfKey] = e6;
        return true;
    }

    public boolean remove(int i4, Object obj) {
        int indexOfKey = indexOfKey(i4);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
