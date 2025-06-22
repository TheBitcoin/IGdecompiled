package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import j$.util.stream.C1144a;
import j$.util.stream.C1173f3;
import j$.util.stream.C1204m0;
import j$.util.stream.C1220q0;
import j$.util.stream.C1223r0;
import j$.util.stream.C1227s0;
import j$.util.stream.C3;
import j$.util.stream.W2;
import j$.util.stream.X2;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final /* synthetic */ class t implements BiConsumer, BiFunction, Consumer, Supplier, C3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5178a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5179b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5180c;

    public /* synthetic */ t(int i4, Object obj, Object obj2) {
        this.f5178a = i4;
        this.f5179b = obj;
        this.f5180c = obj2;
    }

    public /* synthetic */ t(BiFunction biFunction, Function function) {
        this.f5178a = 2;
        this.f5180c = biFunction;
        this.f5179b = function;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f5178a) {
            case 0:
                return a.b(this, biConsumer);
            default:
                return a.b(this, biConsumer);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return a.c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5178a) {
            case 3:
                return Consumer$CC.$default$andThen(this, consumer);
            case 4:
                return Consumer$CC.$default$andThen(this, consumer);
            case 7:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public Object apply(Object obj, Object obj2) {
        return ((Function) this.f5179b).apply(((BiFunction) this.f5180c).apply(obj, obj2));
    }

    public void accept(Object obj, Object obj2) {
        ConcurrentMap concurrentMap;
        switch (this.f5178a) {
            case 0:
                break;
            default:
                ((BiConsumer) this.f5179b).accept(obj, obj2);
                ((BiConsumer) this.f5180c).accept(obj, obj2);
                return;
        }
        do {
            Object apply = ((BiFunction) this.f5180c).apply(obj, obj2);
            concurrentMap = (ConcurrentMap) this.f5179b;
            if (concurrentMap.replace(obj, obj2, apply) || (obj2 = concurrentMap.get(obj)) == null) {
            }
            Object apply2 = ((BiFunction) this.f5180c).apply(obj, obj2);
            concurrentMap = (ConcurrentMap) this.f5179b;
            return;
        } while ((obj2 = concurrentMap.get(obj)) == null);
    }

    public Object get() {
        return new C1204m0((C1223r0) this.f5179b, (Predicate) this.f5180c);
    }

    public t(X2 x22, C1223r0 r0Var, Supplier supplier) {
        this.f5178a = 6;
        this.f5179b = r0Var;
        this.f5180c = supplier;
    }

    public int d() {
        return W2.f5436u | W2.f5433r;
    }

    public Object b(C1144a aVar, i0 i0Var) {
        C1220q0 q0Var = (C1220q0) ((Supplier) this.f5180c).get();
        aVar.N(i0Var, q0Var);
        return Boolean.valueOf(q0Var.f5573b);
    }

    public Object c(C1144a aVar, i0 i0Var) {
        return (Boolean) new C1227s0(this, aVar, i0Var).invoke();
    }

    public void accept(Object obj) {
        switch (this.f5178a) {
            case 3:
                ((Consumer) this.f5179b).accept(obj);
                ((Consumer) this.f5180c).accept(obj);
                return;
            case 4:
                if (obj == null) {
                    ((AtomicBoolean) this.f5179b).set(true);
                    return;
                } else {
                    ((ConcurrentHashMap) this.f5180c).putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 7:
                ((BiConsumer) this.f5179b).accept(this.f5180c, obj);
                return;
            default:
                C1173f3 f3Var = (C1173f3) this.f5179b;
                f3Var.getClass();
                if (f3Var.f5503b.putIfAbsent(obj != null ? obj : C1173f3.f5501d, Boolean.TRUE) == null) {
                    ((Consumer) this.f5180c).accept(obj);
                    return;
                }
                return;
        }
    }
}
