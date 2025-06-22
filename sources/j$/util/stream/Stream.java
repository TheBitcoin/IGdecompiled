package j$.util.stream;

import j$.time.format.r;
import j$.util.B;
import j$.util.C1127b;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface Stream<T> extends C1174g {
    Stream a(r rVar);

    boolean allMatch(Predicate predicate);

    boolean anyMatch(Predicate predicate);

    <R, A> R collect(Collector<? super T, A, R> collector);

    Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2);

    long count();

    Stream distinct();

    Stream dropWhile(Predicate predicate);

    Stream filter(Predicate predicate);

    B findAny();

    B findFirst();

    void forEach(Consumer consumer);

    void forEachOrdered(Consumer consumer);

    C1195k0 h(r rVar);

    C j(r rVar);

    Stream limit(long j4);

    IntStream m(r rVar);

    <R> Stream<R> map(Function<? super T, ? extends R> function);

    C mapToDouble(ToDoubleFunction toDoubleFunction);

    IntStream mapToInt(ToIntFunction toIntFunction);

    C1195k0 mapToLong(ToLongFunction toLongFunction);

    B max(Comparator comparator);

    B min(Comparator comparator);

    boolean noneMatch(Predicate predicate);

    Stream peek(Consumer consumer);

    B reduce(BinaryOperator binaryOperator);

    Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator);

    Object reduce(Object obj, BinaryOperator binaryOperator);

    Stream skip(long j4);

    Stream<T> sorted();

    Stream sorted(Comparator comparator);

    Stream takeWhile(Predicate predicate);

    Object[] toArray();

    Object[] toArray(IntFunction intFunction);

    /* renamed from: j$.util.stream.Stream$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T> Stream<T> of(T... tArr) {
            return C1232t1.a0(C1127b.x(tArr, 0, tArr.length), false);
        }
    }
}
