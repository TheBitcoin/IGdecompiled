package j$.util.function;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final /* synthetic */ class c implements Function, BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f5206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function f5207c;

    public /* synthetic */ c(Function function, Function function2, int i4) {
        this.f5205a = i4;
        this.f5206b = function;
        this.f5207c = function2;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return a.b(this, biConsumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        switch (this.f5205a) {
            case 0:
                return Function$CC.$default$andThen(this, function);
            default:
                return Function$CC.$default$andThen(this, function);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f5205a) {
            case 0:
                return Function$CC.$default$compose(this, function);
            default:
                return Function$CC.$default$compose(this, function);
        }
    }

    public Object apply(Object obj) {
        switch (this.f5205a) {
            case 0:
                return this.f5207c.apply(this.f5206b.apply(obj));
            default:
                return this.f5206b.apply(this.f5207c.apply(obj));
        }
    }

    public void accept(Object obj, Object obj2) {
        Set set = Collectors.f5263a;
        Object apply = this.f5206b.apply(obj2);
        Object requireNonNull = Objects.requireNonNull(this.f5207c.apply(obj2));
        Object v4 = C1127b.v((Map) obj, apply, requireNonNull);
        if (v4 != null) {
            throw new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", new Object[]{apply, v4, requireNonNull}));
        }
    }
}
