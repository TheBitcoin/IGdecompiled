package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

/* renamed from: j$.util.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1130e implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5196a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f5197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f5198c;

    public /* synthetic */ C1130e(C1131f fVar, Comparator comparator) {
        this.f5198c = fVar;
        this.f5197b = comparator;
    }

    public /* synthetic */ C1130e(Function function, Comparator comparator) {
        this.f5197b = comparator;
        this.f5198c = function;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.f5196a) {
            case 0:
                int compare = ((C1131f) this.f5198c).compare(obj, obj2);
                return compare != 0 ? compare : this.f5197b.compare(obj, obj2);
            default:
                Function function = (Function) this.f5198c;
                return this.f5197b.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
