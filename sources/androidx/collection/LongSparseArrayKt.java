package androidx.collection;

import S2.F;
import d3.a;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j4) {
        m.f(longSparseArray, "receiver$0");
        return longSparseArray.containsKey(j4);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        m.f(longSparseArray, "receiver$0");
        m.f(pVar, "action");
        int size = longSparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i4)), longSparseArray.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j4, T t4) {
        m.f(longSparseArray, "receiver$0");
        return longSparseArray.get(j4, t4);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j4, a aVar) {
        m.f(longSparseArray, "receiver$0");
        m.f(aVar, "defaultValue");
        T t4 = longSparseArray.get(j4);
        if (t4 != null) {
            return t4;
        }
        return aVar.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        m.f(longSparseArray, "receiver$0");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        m.f(longSparseArray, "receiver$0");
        return !longSparseArray.isEmpty();
    }

    public static final <T> F keyIterator(LongSparseArray<T> longSparseArray) {
        m.f(longSparseArray, "receiver$0");
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        m.f(longSparseArray, "receiver$0");
        m.f(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j4, T t4) {
        m.f(longSparseArray, "receiver$0");
        return longSparseArray.remove(j4, t4);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j4, T t4) {
        m.f(longSparseArray, "receiver$0");
        longSparseArray.put(j4, t4);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        m.f(longSparseArray, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
