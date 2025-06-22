package j$.util.stream;

import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public interface E0 {
    E0 b(int i4);

    long count();

    void forEach(Consumer consumer);

    E0 g(long j4, long j5, IntFunction intFunction);

    void h(Object[] objArr, int i4);

    Object[] n(IntFunction intFunction);

    int p();

    i0 spliterator();
}
