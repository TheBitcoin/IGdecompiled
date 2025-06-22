package androidx.collection;

import R2.l;
import kotlin.jvm.internal.m;

public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(l... lVarArr) {
        m.f(lVarArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(lVarArr.length);
        for (l lVar : lVarArr) {
            arrayMap.put(lVar.c(), lVar.d());
        }
        return arrayMap;
    }
}
