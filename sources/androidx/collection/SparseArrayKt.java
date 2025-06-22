package androidx.collection;

import S2.E;
import d3.a;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i4) {
        m.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.containsKey(i4);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p pVar) {
        m.f(sparseArrayCompat, "receiver$0");
        m.f(pVar, "action");
        int size = sparseArrayCompat.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i4)), sparseArrayCompat.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i4, T t4) {
        m.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.get(i4, t4);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i4, a aVar) {
        m.f(sparseArrayCompat, "receiver$0");
        m.f(aVar, "defaultValue");
        T t4 = sparseArrayCompat.get(i4);
        if (t4 != null) {
            return t4;
        }
        return aVar.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        m.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        m.f(sparseArrayCompat, "receiver$0");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> E keyIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.f(sparseArrayCompat, "receiver$0");
        return new SparseArrayKt$keyIterator$1(sparseArrayCompat);
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        m.f(sparseArrayCompat, "receiver$0");
        m.f(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat.size() + sparseArrayCompat2.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final <T> boolean remove(SparseArrayCompat<T> sparseArrayCompat, int i4, T t4) {
        m.f(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.remove(i4, t4);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i4, T t4) {
        m.f(sparseArrayCompat, "receiver$0");
        sparseArrayCompat.put(i4, t4);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.f(sparseArrayCompat, "receiver$0");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
