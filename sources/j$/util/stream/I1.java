package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public final class I1 implements O1, C1177g2 {

    /* renamed from: a  reason: collision with root package name */
    public int f5323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5324b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f5325c;

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

    public I1(int i4, IntBinaryOperator intBinaryOperator) {
        this.f5324b = i4;
        this.f5325c = intBinaryOperator;
    }

    public final void f(O1 o12) {
        accept(((I1) o12).f5323a);
    }

    public final void k(long j4) {
        this.f5323a = this.f5324b;
    }

    public final void accept(int i4) {
        this.f5323a = this.f5325c.applyAsInt(this.f5323a, i4);
    }

    public final Object get() {
        return Integer.valueOf(this.f5323a);
    }
}
