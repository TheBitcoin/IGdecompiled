package j$.util;

import j$.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* renamed from: j$.util.c  reason: case insensitive filesystem */
public interface C1128c {
    void forEach(Consumer consumer);

    Stream parallelStream();

    boolean removeIf(Predicate predicate);

    i0 spliterator();

    Stream stream();
}
