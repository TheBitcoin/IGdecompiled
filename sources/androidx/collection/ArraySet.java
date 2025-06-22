package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i4) {
        if (i4 == 8) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr = sTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        sTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        sTwiceBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i4 == 4) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr2 = sBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        sBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        sBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.mHashes = new int[i4];
        this.mArray = new Object[i4];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i5 = i4 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        for (int i6 = i4 - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() {
                /* access modifiers changed from: protected */
                public void colClear() {
                    ArraySet.this.clear();
                }

                /* access modifiers changed from: protected */
                public Object colGetEntry(int i4, int i5) {
                    return ArraySet.this.mArray[i4];
                }

                /* access modifiers changed from: protected */
                public Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public int colGetSize() {
                    return ArraySet.this.mSize;
                }

                /* access modifiers changed from: protected */
                public int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                public int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                public void colPut(E e5, E e6) {
                    ArraySet.this.add(e5);
                }

                /* access modifiers changed from: protected */
                public void colRemoveAt(int i4) {
                    ArraySet.this.removeAt(i4);
                }

                /* access modifiers changed from: protected */
                public E colSetValue(int i4, E e5) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i4) {
        int i5 = this.mSize;
        if (i5 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i5, i4);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i6 = binarySearch + 1;
        while (i6 < i5 && this.mHashes[i6] == i4) {
            if (obj.equals(this.mArray[i6])) {
                return i6;
            }
            i6++;
        }
        int i7 = binarySearch - 1;
        while (i7 >= 0 && this.mHashes[i7] == i4) {
            if (obj.equals(this.mArray[i7])) {
                return i7;
            }
            i7--;
        }
        return ~i6;
    }

    private int indexOfNull() {
        int i4 = this.mSize;
        if (i4 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i4, 0);
        if (binarySearch < 0 || this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i5 = binarySearch + 1;
        while (i5 < i4 && this.mHashes[i5] == 0) {
            if (this.mArray[i5] == null) {
                return i5;
            }
            i5++;
        }
        int i6 = binarySearch - 1;
        while (i6 >= 0 && this.mHashes[i6] == 0) {
            if (this.mArray[i6] == null) {
                return i6;
            }
            i6--;
        }
        return ~i5;
    }

    public boolean add(@Nullable E e5) {
        int i4;
        int i5;
        if (e5 == null) {
            i5 = indexOfNull();
            i4 = 0;
        } else {
            int hashCode = e5.hashCode();
            i4 = hashCode;
            i5 = indexOf(e5, hashCode);
        }
        if (i5 >= 0) {
            return false;
        }
        int i6 = ~i5;
        int i7 = this.mSize;
        int[] iArr = this.mHashes;
        if (i7 >= iArr.length) {
            int i8 = 8;
            if (i7 >= 8) {
                i8 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i8 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i8);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i9 = this.mSize;
        if (i6 < i9) {
            int[] iArr3 = this.mHashes;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i6, objArr2, i10, this.mSize - i6);
        }
        this.mHashes[i6] = i4;
        this.mArray[i6] = e5;
        this.mSize++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i4 = arraySet.mSize;
        ensureCapacity(this.mSize + i4);
        if (this.mSize != 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                add(arraySet.valueAt(i5));
            }
        } else if (i4 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i4);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i4);
            this.mSize = i4;
        }
    }

    public void clear() {
        int i4 = this.mSize;
        if (i4 != 0) {
            freeArrays(this.mHashes, this.mArray, i4);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public boolean contains(@Nullable Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i4) {
        int[] iArr = this.mHashes;
        if (iArr.length < i4) {
            Object[] objArr = this.mArray;
            allocArrays(i4);
            int i5 = this.mSize;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i5);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i4 = 0;
            while (i4 < this.mSize) {
                try {
                    if (!set.contains(valueAt(i4))) {
                        return false;
                    }
                    i4++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        int i4 = this.mSize;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i4 = arraySet.mSize;
        int i5 = this.mSize;
        for (int i6 = 0; i6 < i4; i6++) {
            remove(arraySet.valueAt(i6));
        }
        if (i5 != this.mSize) {
            return true;
        }
        return false;
    }

    public E removeAt(int i4) {
        E[] eArr = this.mArray;
        E e5 = eArr[i4];
        int i5 = this.mSize;
        if (i5 <= 1) {
            freeArrays(this.mHashes, eArr, i5);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
            return e5;
        }
        int[] iArr = this.mHashes;
        int i6 = 8;
        if (iArr.length <= 8 || i5 >= iArr.length / 3) {
            int i7 = i5 - 1;
            this.mSize = i7;
            if (i4 < i7) {
                int i8 = i4 + 1;
                System.arraycopy(iArr, i8, iArr, i4, i7 - i4);
                Object[] objArr = this.mArray;
                System.arraycopy(objArr, i8, objArr, i4, this.mSize - i4);
            }
            this.mArray[this.mSize] = null;
            return e5;
        }
        if (i5 > 8) {
            i6 = i5 + (i5 >> 1);
        }
        allocArrays(i6);
        this.mSize--;
        if (i4 > 0) {
            System.arraycopy(iArr, 0, this.mHashes, 0, i4);
            System.arraycopy(eArr, 0, this.mArray, 0, i4);
        }
        int i9 = this.mSize;
        if (i4 < i9) {
            int i10 = i4 + 1;
            System.arraycopy(iArr, i10, this.mHashes, i4, i9 - i4);
            System.arraycopy(eArr, i10, this.mArray, i4, this.mSize - i4);
        }
        return e5;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z4 = false;
        for (int i4 = this.mSize - 1; i4 >= 0; i4--) {
            if (!collection.contains(this.mArray[i4])) {
                removeAt(i4);
                z4 = true;
            }
        }
        return z4;
    }

    public int size() {
        return this.mSize;
    }

    @NonNull
    public Object[] toArray() {
        int i4 = this.mSize;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.mArray, 0, objArr, 0, i4);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object valueAt = valueAt(i4);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Nullable
    public E valueAt(int i4) {
        return this.mArray[i4];
    }

    public ArraySet(int i4) {
        if (i4 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i4);
        }
        this.mSize = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i4 = this.mSize;
        if (length > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z4 = false;
        for (Object remove : collection) {
            z4 |= remove(remove);
        }
        return z4;
    }

    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        boolean z4 = false;
        for (Object add : collection) {
            z4 |= add(add);
        }
        return z4;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }
}
