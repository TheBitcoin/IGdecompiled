package androidx.core.util;

import S2.C1600n;
import S2.E;
import android.util.SparseBooleanArray;
import d3.a;
import d3.p;

public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i4) {
        if (sparseBooleanArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i4) {
        if (sparseBooleanArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z4) {
        if (sparseBooleanArray.indexOfValue(z4) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p pVar) {
        int size = sparseBooleanArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i4)), Boolean.valueOf(sparseBooleanArray.valueAt(i4)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i4, boolean z4) {
        return sparseBooleanArray.get(i4, z4);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i4, a aVar) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i4);
        if (indexOfKey >= 0) {
            return sparseBooleanArray.valueAt(indexOfKey);
        }
        return ((Boolean) aVar.invoke()).booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final E keyIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i4), sparseBooleanArray2.valueAt(i4));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i4, boolean z4) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i4);
        if (indexOfKey < 0 || z4 != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i4);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i4, boolean z4) {
        sparseBooleanArray.put(i4, z4);
    }

    public static final C1600n valueIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
