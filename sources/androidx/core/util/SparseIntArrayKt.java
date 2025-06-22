package androidx.core.util;

import S2.E;
import android.util.SparseIntArray;
import d3.a;
import d3.p;

public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i4) {
        if (sparseIntArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i4) {
        if (sparseIntArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i4) {
        if (sparseIntArray.indexOfValue(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p pVar) {
        int size = sparseIntArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i4)), Integer.valueOf(sparseIntArray.valueAt(i4)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i4, int i5) {
        return sparseIntArray.get(i4, i5);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i4, a aVar) {
        int indexOfKey = sparseIntArray.indexOfKey(i4);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return ((Number) aVar.invoke()).intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final E keyIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i4), sparseIntArray2.valueAt(i4));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i4, int i5) {
        int indexOfKey = sparseIntArray.indexOfKey(i4);
        if (indexOfKey < 0 || i5 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i4, int i5) {
        sparseIntArray.put(i4, i5);
    }

    public static final E valueIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
