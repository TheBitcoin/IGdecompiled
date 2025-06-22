package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

public final class M1 implements O1, C1182h2 {

    /* renamed from: a  reason: collision with root package name */
    public long f5369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f5370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f5371c;

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

    public M1(long j4, LongBinaryOperator longBinaryOperator) {
        this.f5370b = j4;
        this.f5371c = longBinaryOperator;
    }

    public final void f(O1 o12) {
        accept(((M1) o12).f5369a);
    }

    public final void k(long j4) {
        this.f5369a = this.f5370b;
    }

    public final void accept(long j4) {
        this.f5369a = this.f5371c.applyAsLong(this.f5369a, j4);
    }

    public final Object get() {
        return Long.valueOf(this.f5369a);
    }
}
