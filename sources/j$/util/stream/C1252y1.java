package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.y1  reason: case insensitive filesystem */
public final class C1252y1 extends C1232t1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5636h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f5637i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f5638j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f5639k;

    public /* synthetic */ C1252y1(X2 x22, Object obj, Object obj2, Object obj3, int i4) {
        this.f5636h = i4;
        this.f5638j = obj;
        this.f5639k = obj2;
        this.f5637i = obj3;
    }

    public final O1 Z() {
        switch (this.f5636h) {
            case 0:
                return new C1240v1((Supplier) this.f5637i, (ObjLongConsumer) this.f5639k, (C1215p) this.f5638j);
            case 1:
                return new B1((Supplier) this.f5637i, (ObjDoubleConsumer) this.f5639k, (C1215p) this.f5638j);
            case 2:
                return new D1(this.f5637i, (BiFunction) this.f5639k, (BinaryOperator) this.f5638j);
            case 3:
                return new H1((Supplier) this.f5637i, (BiConsumer) this.f5639k, (BiConsumer) this.f5638j);
            default:
                return new L1((Supplier) this.f5637i, (ObjIntConsumer) this.f5639k, (C1215p) this.f5638j);
        }
    }
}
