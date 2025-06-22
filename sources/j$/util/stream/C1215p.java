package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* renamed from: j$.util.stream.p  reason: case insensitive filesystem */
public final /* synthetic */ class C1215p implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5558a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f5559b;

    public /* synthetic */ C1215p(BiConsumer biConsumer, int i4) {
        this.f5558a = i4;
        this.f5559b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f5558a) {
            case 0:
                return a.c(this, function);
            case 1:
                return a.c(this, function);
            default:
                return a.c(this, function);
        }
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.f5558a) {
            case 0:
                this.f5559b.accept(obj, obj2);
                return obj;
            case 1:
                this.f5559b.accept(obj, obj2);
                return obj;
            default:
                this.f5559b.accept(obj, obj2);
                return obj;
        }
    }
}
