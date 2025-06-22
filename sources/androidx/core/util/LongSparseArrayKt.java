package androidx.core.util;

import S2.F;
import android.util.LongSparseArray;
import d3.a;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j4) {
        if (longSparseArray.indexOfKey(j4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j4) {
        if (longSparseArray.indexOfKey(j4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t4) {
        if (longSparseArray.indexOfValue(t4) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        int size = longSparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i4)), longSparseArray.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j4, T t4) {
        T t5 = longSparseArray.get(j4);
        if (t5 == null) {
            return t4;
        }
        return t5;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j4, a aVar) {
        T t4 = longSparseArray.get(j4);
        if (t4 == null) {
            return aVar.invoke();
        }
        return t4;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> F keyIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            longSparseArray.put(longSparseArray2.keyAt(i4), longSparseArray2.valueAt(i4));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j4, T t4) {
        int indexOfKey = longSparseArray.indexOfKey(j4);
        if (indexOfKey < 0 || !m.a(t4, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j4, T t4) {
        longSparseArray.put(j4, t4);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
