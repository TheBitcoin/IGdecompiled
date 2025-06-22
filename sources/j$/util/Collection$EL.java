package j$.util;

import j$.util.stream.Stream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;

/* renamed from: j$.util.Collection$-EL  reason: invalid class name */
public final /* synthetic */ class Collection$EL {
    public static /* synthetic */ Stream b(Collection collection) {
        return collection instanceof C1128c ? ((C1128c) collection).parallelStream() : C1127b.f(collection);
    }

    public static /* synthetic */ Stream stream(Collection collection) {
        return collection instanceof C1128c ? ((C1128c) collection).stream() : C1127b.g(collection);
    }

    public static i0 c(Collection collection) {
        if (collection instanceof C1128c) {
            return ((C1128c) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            return new u0(17, (Collection) Objects.requireNonNull((LinkedHashSet) collection));
        }
        if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) collection;
            return new T(sortedSet, sortedSet);
        } else if (collection instanceof Set) {
            return new u0(1, (Collection) Objects.requireNonNull((Set) collection));
        } else {
            if (!(collection instanceof List)) {
                return new u0(0, (Collection) Objects.requireNonNull(collection));
            }
            List list = (List) collection;
            return list instanceof RandomAccess ? new C1126a(list) : new u0(16, (Collection) Objects.requireNonNull(list));
        }
    }

    public static void a(Collection collection, Consumer consumer) {
        if (collection instanceof C1128c) {
            ((C1128c) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        for (Object accept : collection) {
            consumer.accept(accept);
        }
    }
}
