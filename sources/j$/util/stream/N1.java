package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.E;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

public final class N1 implements O1, C1182h2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5374a;

    /* renamed from: b  reason: collision with root package name */
    public long f5375b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f5376c;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public N1(LongBinaryOperator longBinaryOperator) {
        this.f5376c = longBinaryOperator;
    }

    public final void f(O1 o12) {
        N1 n12 = (N1) o12;
        if (!n12.f5374a) {
            accept(n12.f5375b);
        }
    }

    public final void k(long j4) {
        this.f5374a = true;
        this.f5375b = 0;
    }

    public final void accept(long j4) {
        if (this.f5374a) {
            this.f5374a = false;
            this.f5375b = j4;
            return;
        }
        this.f5375b = this.f5376c.applyAsLong(this.f5375b, j4);
    }

    public final Object get() {
        return this.f5374a ? E.f5093c : new E(this.f5375b);
    }
}
