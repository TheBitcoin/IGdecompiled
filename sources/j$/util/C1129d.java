package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1129d implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5193a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5194b;

    public /* synthetic */ C1129d(int i4, Object obj) {
        this.f5193a = i4;
        this.f5194b = obj;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.f5193a) {
            case 0:
                ToIntFunction toIntFunction = (ToIntFunction) this.f5194b;
                return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            case 1:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f5194b;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 2:
                Function function = (Function) this.f5194b;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
            default:
                ToLongFunction toLongFunction = (ToLongFunction) this.f5194b;
                return Long.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
        }
    }
}
