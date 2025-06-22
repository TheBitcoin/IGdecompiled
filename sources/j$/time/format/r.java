package j$.time.format;

import j$.util.C1132g;
import j$.util.C1142q;
import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.function.Predicate$CC;
import j$.util.i0;
import j$.util.stream.A;
import j$.util.stream.A3;
import j$.util.stream.B;
import j$.util.stream.C;
import j$.util.stream.C1144a;
import j$.util.stream.C1183h3;
import j$.util.stream.C1185i0;
import j$.util.stream.C1187i2;
import j$.util.stream.C1190j0;
import j$.util.stream.C1193j3;
import j$.util.stream.C1195k0;
import j$.util.stream.Collectors;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import j$.util.stream.T2;
import j$.util.stream.U2;
import j$.util.stream.V2;
import j$.util.stream.l3;
import j$.util.x0;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public final class r implements Consumer, Predicate, Supplier, DoubleFunction, Function, LongFunction, BooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4969a;

    /* renamed from: b  reason: collision with root package name */
    public Object f4970b;

    public /* synthetic */ r(int i4) {
        this.f4969a = i4;
    }

    public /* synthetic */ r(int i4, Object obj) {
        this.f4969a = i4;
        this.f4970b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f4969a) {
            case 1:
                return Consumer$CC.$default$andThen(this, consumer);
            case 9:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    public boolean test(Object obj) {
        return !((Predicate) this.f4970b).test(obj);
    }

    public Object apply(Object obj) {
        Object apply = ((Function) this.f4970b).apply(obj);
        if (apply == null) {
            return null;
        }
        if (apply instanceof Stream) {
            return U2.w((Stream) apply);
        }
        if (apply instanceof java.util.stream.Stream) {
            return T2.w((java.util.stream.Stream) apply);
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        if (apply instanceof C) {
            return B.w((C) apply);
        }
        if (apply instanceof DoubleStream) {
            return A.w((DoubleStream) apply);
        }
        if (apply instanceof C1195k0) {
            return C1190j0.w((C1195k0) apply);
        }
        if (apply instanceof LongStream) {
            return C1185i0.w((LongStream) apply);
        }
        C1132g.a("java.util.stream.*Stream", apply.getClass());
        throw null;
    }

    public Object apply(double d5) {
        Object apply = ((DoubleFunction) this.f4970b).apply(d5);
        if (apply == null) {
            return null;
        }
        if (apply instanceof C) {
            return B.w((C) apply);
        }
        if (apply instanceof DoubleStream) {
            return A.w((DoubleStream) apply);
        }
        C1132g.a("java.util.stream.DoubleStream", apply.getClass());
        throw null;
    }

    public Object apply(long j4) {
        Object apply = ((LongFunction) this.f4970b).apply(j4);
        if (apply == null) {
            return null;
        }
        if (apply instanceof C1195k0) {
            return C1190j0.w((C1195k0) apply);
        }
        if (apply instanceof LongStream) {
            return C1185i0.w((LongStream) apply);
        }
        C1132g.a("java.util.stream.LongStream", apply.getClass());
        throw null;
    }

    public boolean getAsBoolean() {
        switch (this.f4969a) {
            case 12:
                C1183h3 h3Var = (C1183h3) this.f4970b;
                return h3Var.f5448d.tryAdvance(h3Var.f5449e);
            case 13:
                C1193j3 j3Var = (C1193j3) this.f4970b;
                return j3Var.f5448d.tryAdvance(j3Var.f5449e);
            case 14:
                l3 l3Var = (l3) this.f4970b;
                return l3Var.f5448d.tryAdvance(l3Var.f5449e);
            default:
                A3 a32 = (A3) this.f4970b;
                return a32.f5448d.tryAdvance(a32.f5449e);
        }
    }

    public void c(V2 v22) {
        ((EnumMap) this.f4970b).put(v22, 1);
    }

    public Object get() {
        switch (this.f4969a) {
            case 3:
                return ((C1144a) this.f4970b).K(0);
            case 4:
                return (i0) this.f4970b;
            default:
                Set set = Collectors.f5263a;
                return new x0((CharSequence) this.f4970b);
        }
    }

    public r(Map map) {
        this.f4969a = 0;
        this.f4970b = map;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                q qVar = b.f4931b;
                hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
            }
            ArrayList arrayList2 = new ArrayList(hashMap2.values());
            Collections.sort(arrayList2, b.f4931b);
            hashMap.put((v) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            hashMap.put((Object) null, arrayList);
        }
        Collections.sort(arrayList, b.f4931b);
    }

    public String b(long j4, v vVar) {
        Map map = (Map) ((Map) this.f4970b).get(vVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j4));
        }
        return null;
    }

    public void accept(Object obj) {
        switch (this.f4969a) {
            case 1:
                ((Consumer) this.f4970b).accept(new C1142q((Map.Entry) obj));
                return;
            case 9:
                ((C1187i2) this.f4970b).accept(obj);
                return;
            default:
                ((ArrayList) this.f4970b).add(obj);
                return;
        }
    }
}
