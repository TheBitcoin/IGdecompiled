package androidx.core.util;

import S2.E;
import S2.F;
import android.util.SparseLongArray;
import d3.a;
import d3.p;

public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i4) {
        if (sparseLongArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i4) {
        if (sparseLongArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j4) {
        if (sparseLongArray.indexOfValue(j4) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseLongArray sparseLongArray, p pVar) {
        int size = sparseLongArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i4)), Long.valueOf(sparseLongArray.valueAt(i4)));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i4, long j4) {
        return sparseLongArray.get(i4, j4);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i4, a aVar) {
        int indexOfKey = sparseLongArray.indexOfKey(i4);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return ((Number) aVar.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final E keyIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i4), sparseLongArray2.valueAt(i4));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i4, long j4) {
        int indexOfKey = sparseLongArray.indexOfKey(i4);
        if (indexOfKey < 0 || j4 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i4, long j4) {
        sparseLongArray.put(i4, j4);
    }

    public static final F valueIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
