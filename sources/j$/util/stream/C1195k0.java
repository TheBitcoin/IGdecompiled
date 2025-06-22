package j$.util.stream;

import j$.time.format.r;
import j$.util.A;
import j$.util.C;
import j$.util.E;
import j$.util.Q;
import j$.util.c0;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.k0  reason: case insensitive filesystem */
public interface C1195k0 extends C1174g {
    C1195k0 a(r rVar);

    C asDoubleStream();

    C average();

    C1195k0 b();

    Stream boxed();

    C1195k0 c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    C1195k0 distinct();

    E findAny();

    E findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    C i();

    Q iterator();

    boolean l();

    C1195k0 limit(long j4);

    Stream mapToObj(LongFunction longFunction);

    E max();

    E min();

    boolean o();

    C1195k0 parallel();

    C1195k0 peek(LongConsumer longConsumer);

    long reduce(long j4, LongBinaryOperator longBinaryOperator);

    E reduce(LongBinaryOperator longBinaryOperator);

    boolean s();

    C1195k0 sequential();

    C1195k0 skip(long j4);

    C1195k0 sorted();

    c0 spliterator();

    long sum();

    A summaryStatistics();

    IntStream t();

    long[] toArray();
}
