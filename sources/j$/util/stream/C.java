package j$.util.stream;

import j$.time.format.r;
import j$.util.C1261w;
import j$.util.I;
import j$.util.W;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public interface C extends C1174g {
    C a(r rVar);

    j$.util.C average();

    C b();

    Stream boxed();

    C c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    C distinct();

    boolean f();

    j$.util.C findAny();

    j$.util.C findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    C1195k0 g();

    I iterator();

    C limit(long j4);

    Stream mapToObj(DoubleFunction doubleFunction);

    j$.util.C max();

    j$.util.C min();

    boolean n();

    C parallel();

    C peek(DoubleConsumer doubleConsumer);

    IntStream q();

    double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator);

    j$.util.C reduce(DoubleBinaryOperator doubleBinaryOperator);

    C sequential();

    C skip(long j4);

    C sorted();

    W spliterator();

    double sum();

    C1261w summaryStatistics();

    double[] toArray();

    boolean v();
}
