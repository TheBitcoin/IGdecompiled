package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.Map;
import j$.util.stream.C1232t1;
import j$.util.stream.Y1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.b  reason: case insensitive filesystem */
public abstract /* synthetic */ class C1127b {
    public static /* synthetic */ void s(Map map, BiConsumer biConsumer) {
        if (map instanceof Map) {
            ((Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            a.j((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }

    public static /* synthetic */ Object v(java.util.Map map, Object obj, Object obj2) {
        return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    public static B k(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? new B(optional.get()) : B.f5085b;
    }

    public static OptionalDouble p(C c5) {
        if (c5 == null) {
            return null;
        }
        boolean z4 = c5.f5088a;
        if (!z4) {
            return OptionalDouble.empty();
        }
        if (z4) {
            return OptionalDouble.of(c5.f5089b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static C l(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? new C(optionalDouble.getAsDouble()) : C.f5087c;
    }

    public static OptionalLong r(E e5) {
        if (e5 == null) {
            return null;
        }
        boolean z4 = e5.f5094a;
        if (!z4) {
            return OptionalLong.empty();
        }
        if (z4) {
            return OptionalLong.of(e5.f5095b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static E n(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? new E(optionalLong.getAsLong()) : E.f5093c;
    }

    public static OptionalInt q(D d5) {
        if (d5 == null) {
            return null;
        }
        boolean z4 = d5.f5091a;
        if (!z4) {
            return OptionalInt.empty();
        }
        if (z4) {
            return OptionalInt.of(d5.f5092b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static D m(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? new D(optionalInt.getAsInt()) : D.f5090c;
    }

    public static Object u(java.util.Map map, Object obj, Object obj2) {
        if (map instanceof Map) {
            return ((Map) map).getOrDefault(obj, obj2);
        }
        if (map instanceof ConcurrentMap) {
            Object obj3 = ((ConcurrentMap) map).get(obj);
            if (obj3 != null) {
                return obj3;
            }
        } else {
            Object obj4 = map.get(obj);
            if (obj4 != null || map.containsKey(obj)) {
                return obj4;
            }
        }
        return obj2;
    }

    public static void t(Iterator it, Consumer consumer) {
        if (it instanceof C1263y) {
            ((C1263y) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static Optional o(B b5) {
        if (b5 == null) {
            return null;
        }
        Object obj = b5.f5086a;
        if (obj == null) {
            return Optional.empty();
        }
        if (obj != null) {
            return Optional.of(obj);
        }
        throw new NoSuchElementException("No value present");
    }

    public static n0 x(Object[] objArr, int i4, int i5) {
        w0.a(((Object[]) Objects.requireNonNull(objArr)).length, i4, i5);
        return new n0(objArr, i4, i5, 1040);
    }

    public static C1130e y(C1131f fVar, Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new C1130e(fVar, comparator);
    }

    public static long d(i0 i0Var) {
        if ((i0Var.characteristics() & 64) == 0) {
            return -1;
        }
        return i0Var.estimateSize();
    }

    public static boolean e(i0 i0Var, int i4) {
        return (i0Var.characteristics() & i4) == i4;
    }

    public static void w(List list, Comparator comparator) {
        if (list instanceof C1264z) {
            ((C1264z) list).sort(comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public static boolean i(Z z4, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return z4.tryAdvance((IntConsumer) consumer);
        }
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            return z4.tryAdvance(new J(consumer, 0));
        }
        z0.a(z4.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    public static void b(Z z4, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            z4.forEachRemaining((IntConsumer) consumer);
        } else if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            z4.forEachRemaining(new J(consumer, 0));
        } else {
            z0.a(z4.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean j(c0 c0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return c0Var.tryAdvance((LongConsumer) consumer);
        }
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            return c0Var.tryAdvance(new N(consumer, 0));
        }
        z0.a(c0Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }

    public static Y1 g(Collection collection) {
        return C1232t1.a0(Collection$EL.c(collection), false);
    }

    public static Y1 f(Collection collection) {
        return C1232t1.a0(Collection$EL.c(collection), true);
    }

    public static void c(c0 c0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            c0Var.forEachRemaining((LongConsumer) consumer);
        } else if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            c0Var.forEachRemaining(new N(consumer, 0));
        } else {
            z0.a(c0Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean h(W w4, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return w4.tryAdvance((DoubleConsumer) consumer);
        }
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            return w4.tryAdvance(new F(consumer, 0));
        }
        z0.a(w4.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    public static void a(W w4, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            w4.forEachRemaining((DoubleConsumer) consumer);
        } else if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            w4.forEachRemaining(new F(consumer, 0));
        } else {
            z0.a(w4.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        }
    }

    public i0 trySplit() {
        return null;
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public long estimateSize() {
        return 0;
    }

    public int characteristics() {
        return 16448;
    }
}
