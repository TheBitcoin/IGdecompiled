package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i4 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != DELETED) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.mGarbage = false;
        this.mSize = i5;
    }

    public void append(long j4, E e5) {
        int i4 = this.mSize;
        if (i4 == 0 || j4 > this.mKeys[i4 - 1]) {
            if (this.mGarbage && i4 >= this.mKeys.length) {
                gc();
            }
            int i5 = this.mSize;
            if (i5 >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i5 + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                long[] jArr2 = this.mKeys;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            this.mKeys[i5] = j4;
            this.mValues[i5] = e5;
            this.mSize = i5 + 1;
            return;
        }
        put(j4, e5);
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

    public boolean containsKey(long j4) {
        if (indexOfKey(j4) >= 0) {
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
    public void delete(long j4) {
        remove(j4);
    }

    @Nullable
    public E get(long j4) {
        return get(j4, (Object) null);
    }

    public int indexOfKey(long j4) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j4);
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

    public long keyAt(int i4) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i4];
    }

    public void put(long j4, E e5) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j4);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e5;
            return;
        }
        int i4 = ~binarySearch;
        int i5 = this.mSize;
        if (i4 < i5) {
            Object[] objArr = this.mValues;
            if (objArr[i4] == DELETED) {
                this.mKeys[i4] = j4;
                objArr[i4] = e5;
                return;
            }
        }
        if (this.mGarbage && i5 >= this.mKeys.length) {
            gc();
            i4 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j4);
        }
        int i6 = this.mSize;
        if (i6 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i6 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i7 = this.mSize;
        if (i7 - i4 != 0) {
            long[] jArr3 = this.mKeys;
            int i8 = i4 + 1;
            System.arraycopy(jArr3, i4, jArr3, i8, i7 - i4);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i4, objArr4, i8, this.mSize - i4);
        }
        this.mKeys[i4] = j4;
        this.mValues[i4] = e5;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            put(longSparseArray.keyAt(i4), longSparseArray.valueAt(i4));
        }
    }

    @Nullable
    public E putIfAbsent(long j4, E e5) {
        E e6 = get(j4);
        if (e6 == null) {
            put(j4, e5);
        }
        return e6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.binarySearch((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.mValues
            r0 = r4[r3]
            java.lang.Object r1 = DELETED
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.mGarbage = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.remove(long):void");
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

    @Nullable
    public E replace(long j4, E e5) {
        int indexOfKey = indexOfKey(j4);
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

    public LongSparseArray(int i4) {
        this.mGarbage = false;
        if (i4 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealLongArraySize = ContainerHelpers.idealLongArraySize(i4);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(long r3, E r5) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.ContainerHelpers.binarySearch((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.mValues
            r3 = r4[r3]
            java.lang.Object r4 = DELETED
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.get(long, java.lang.Object):java.lang.Object");
    }

    public boolean replace(long j4, E e5, E e6) {
        int indexOfKey = indexOfKey(j4);
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

    public boolean remove(long j4, Object obj) {
        int indexOfKey = indexOfKey(j4);
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
