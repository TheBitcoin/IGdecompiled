package j$.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public class DesugarCollections {
    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> collection) {
        return new C1139n(collection);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Set<T>, j$.util.n] */
    public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
        return new C1139n(set);
    }

    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        if (list instanceof RandomAccess) {
            return new C1141p(list);
        }
        return new C1141p(list);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return new C1258t(map);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Set<T>, j$.util.h] */
    public static <T> Set<T> synchronizedSet(Set<T> set) {
        return new C1133h(set);
    }

    public static <T> List<T> synchronizedList(List<T> list) {
        if (list instanceof RandomAccess) {
            return new C1134i(list);
        }
        return new C1134i(list);
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return new C1135j(map);
    }
}
