package androidx.collection;

import kotlin.jvm.internal.m;

public final class ArraySetKt {
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        m.f(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T add : tArr) {
            arraySet.add(add);
        }
        return arraySet;
    }
}
