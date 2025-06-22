package androidx.datastore.preferences.core;

import S2.C1601o;
import androidx.annotation.RestrictTo;
import j$.util.DesugarCollections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import o3.G;
import o3.Y;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Actual_jvmKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        m.e(set, "set");
        Set<T> unmodifiableSet = DesugarCollections.unmodifiableSet(C1601o.d0(set));
        m.d(unmodifiableSet, "unmodifiableSet(set.toSet())");
        return unmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        m.e(map, "map");
        Map<K, V> unmodifiableMap = DesugarCollections.unmodifiableMap(map);
        m.d(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }

    public static final G ioDispatcher() {
        return Y.b();
    }
}
