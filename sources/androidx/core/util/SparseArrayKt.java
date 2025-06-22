package androidx.core.util;

import S2.E;
import android.util.SparseArray;
import d3.a;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i4) {
        if (sparseArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i4) {
        if (sparseArray.indexOfKey(i4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t4) {
        if (sparseArray.indexOfValue(t4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p pVar) {
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i4)), sparseArray.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i4, T t4) {
        T t5 = sparseArray.get(i4);
        if (t5 == null) {
            return t4;
        }
        return t5;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i4, a aVar) {
        T t4 = sparseArray.get(i4);
        if (t4 == null) {
            return aVar.invoke();
        }
        return t4;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> E keyIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$keyIterator$1(sparseArray);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseArray.put(sparseArray2.keyAt(i4), sparseArray2.valueAt(i4));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i4, T t4) {
        int indexOfKey = sparseArray.indexOfKey(i4);
        if (indexOfKey < 0 || !m.a(t4, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i4, T t4) {
        sparseArray.put(i4, t4);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
