package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i4) {
        if (i4 == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i4 == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.mHashes = new int[i4];
        this.mArray = new Object[(i4 << 1)];
    }

    private static int binarySearchHashes(int[] iArr, int i4, int i5) {
        try {
            return ContainerHelpers.binarySearch(iArr, i4, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void clear() {
        int i4 = this.mSize;
        if (i4 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i4);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i4) {
        int i5 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i4) {
            Object[] objArr = this.mArray;
            allocArrays(i4);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i5);
                System.arraycopy(objArr, 0, this.mArray, 0, i5 << 1);
            }
            freeArrays(iArr, objArr, i5);
        }
        if (this.mSize != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i4 = 0;
            while (i4 < this.mSize) {
                try {
                    Object keyAt = keyAt(i4);
                    Object valueAt = valueAt(i4);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i4++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i5 = 0;
            while (i5 < this.mSize) {
                try {
                    Object keyAt2 = keyAt(i5);
                    Object valueAt2 = valueAt(i5);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                    i5++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v4) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.mArray[(indexOfKey << 1) + 1];
        }
        return v4;
    }

    public int hashCode() {
        int i4;
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i5 = this.mSize;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            int i9 = iArr[i7];
            if (obj == null) {
                i4 = 0;
            } else {
                i4 = obj.hashCode();
            }
            i8 += i4 ^ i9;
            i7++;
            i6 += 2;
        }
        return i8;
    }

    /* access modifiers changed from: package-private */
    public int indexOf(Object obj, int i4) {
        int i5 = this.mSize;
        if (i5 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i5, i4);
        if (binarySearchHashes < 0 || obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i6 = binarySearchHashes + 1;
        while (i6 < i5 && this.mHashes[i6] == i4) {
            if (obj.equals(this.mArray[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        int i7 = binarySearchHashes - 1;
        while (i7 >= 0 && this.mHashes[i7] == i4) {
            if (obj.equals(this.mArray[i7 << 1])) {
                return i7;
            }
            i7--;
        }
        return ~i6;
    }

    public int indexOfKey(@Nullable Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int indexOfNull() {
        int i4 = this.mSize;
        if (i4 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i4, 0);
        if (binarySearchHashes < 0 || this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i5 = binarySearchHashes + 1;
        while (i5 < i4 && this.mHashes[i5] == 0) {
            if (this.mArray[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        int i6 = binarySearchHashes - 1;
        while (i6 >= 0 && this.mHashes[i6] == 0) {
            if (this.mArray[i6 << 1] == null) {
                return i6;
            }
            i6--;
        }
        return ~i5;
    }

    /* access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i4 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i4) {
        return this.mArray[i4 << 1];
    }

    @Nullable
    public V put(K k4, V v4) {
        int i4;
        int i5;
        int i6 = this.mSize;
        if (k4 == null) {
            i5 = indexOfNull();
            i4 = 0;
        } else {
            int hashCode = k4.hashCode();
            i4 = hashCode;
            i5 = indexOf(k4, hashCode);
        }
        if (i5 >= 0) {
            int i7 = (i5 << 1) + 1;
            V[] vArr = this.mArray;
            V v5 = vArr[i7];
            vArr[i7] = v4;
            return v5;
        }
        int i8 = ~i5;
        int[] iArr = this.mHashes;
        if (i6 >= iArr.length) {
            int i9 = 8;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i9 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i9);
            if (i6 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
                }
                freeArrays(iArr, objArr, i6);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i8 < i6) {
            int[] iArr3 = this.mHashes;
            int i10 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i10, i6 - i8);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i8 << 1, objArr2, i10 << 1, (this.mSize - i8) << 1);
        }
        int i11 = this.mSize;
        if (i6 == i11) {
            int[] iArr4 = this.mHashes;
            if (i8 < iArr4.length) {
                iArr4[i8] = i4;
                Object[] objArr3 = this.mArray;
                int i12 = i8 << 1;
                objArr3[i12] = k4;
                objArr3[i12 + 1] = v4;
                this.mSize = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i4 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i4);
        if (this.mSize != 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                put(simpleArrayMap.keyAt(i5), simpleArrayMap.valueAt(i5));
            }
        } else if (i4 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i4);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i4 << 1);
            this.mSize = i4;
        }
    }

    @Nullable
    public V putIfAbsent(K k4, V v4) {
        V v5 = get(k4);
        if (v5 == null) {
            return put(k4, v4);
        }
        return v5;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i4) {
        V[] vArr = this.mArray;
        int i5 = i4 << 1;
        V v4 = vArr[i5 + 1];
        int i6 = this.mSize;
        int i7 = 0;
        if (i6 <= 1) {
            freeArrays(this.mHashes, vArr, i6);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.mHashes;
            int i9 = 8;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                if (i4 < i8) {
                    int i10 = i4 + 1;
                    int i11 = i8 - i4;
                    System.arraycopy(iArr, i10, iArr, i4, i11);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i10 << 1, objArr, i5, i11 << 1);
                }
                Object[] objArr2 = this.mArray;
                int i12 = i8 << 1;
                objArr2[i12] = null;
                objArr2[i12 + 1] = null;
            } else {
                if (i6 > 8) {
                    i9 = i6 + (i6 >> 1);
                }
                allocArrays(i9);
                if (i6 == this.mSize) {
                    if (i4 > 0) {
                        System.arraycopy(iArr, 0, this.mHashes, 0, i4);
                        System.arraycopy(vArr, 0, this.mArray, 0, i5);
                    }
                    if (i4 < i8) {
                        int i13 = i4 + 1;
                        int i14 = i8 - i4;
                        System.arraycopy(iArr, i13, this.mHashes, i4, i14);
                        System.arraycopy(vArr, i13 << 1, this.mArray, i5, i14 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i7 = i8;
        }
        if (i6 == this.mSize) {
            this.mSize = i7;
            return v4;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k4, V v4) {
        int indexOfKey = indexOfKey(k4);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v4);
        }
        return null;
    }

    public V setValueAt(int i4, V v4) {
        int i5 = (i4 << 1) + 1;
        V[] vArr = this.mArray;
        V v5 = vArr[i5];
        vArr[i5] = v4;
        return v5;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i4);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
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

    public V valueAt(int i4) {
        return this.mArray[(i4 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k4, V v4, V v5) {
        int indexOfKey = indexOfKey(k4);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v4 && (v4 == null || !v4.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v5);
        return true;
    }

    public SimpleArrayMap(int i4) {
        if (i4 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i4);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
