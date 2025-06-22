package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.D;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public final class K1 implements O1, C1177g2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5358a;

    /* renamed from: b  reason: collision with root package name */
    public int f5359b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f5360c;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public K1(IntBinaryOperator intBinaryOperator) {
        this.f5360c = intBinaryOperator;
    }

    public final void f(O1 o12) {
        K1 k12 = (K1) o12;
        if (!k12.f5358a) {
            accept(k12.f5359b);
        }
    }

    public final void k(long j4) {
        this.f5358a = true;
        this.f5359b = 0;
    }

    public final void accept(int i4) {
        if (this.f5358a) {
            this.f5358a = false;
            this.f5359b = i4;
            return;
        }
        this.f5359b = this.f5360c.applyAsInt(this.f5359b, i4);
    }

    public final Object get() {
        return this.f5358a ? D.f5090c : new D(this.f5359b);
    }
}
