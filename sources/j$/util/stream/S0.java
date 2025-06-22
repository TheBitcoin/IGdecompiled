package j$.util.stream;

import j$.util.f0;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

public final class S0 extends L2 implements C1251y0, C1231t0 {
    public final E0 a() {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final C1251y0 m24a() {
        return this;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.t(this, j4, j5);
    }

    public final void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final /* synthetic */ Object[] n(IntFunction intFunction) {
        return C1232t1.m(this, intFunction);
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final D0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void h(Object[] objArr, int i4) {
        C1232t1.n(this, (Double[]) objArr, i4);
    }

    public final void e(Object obj) {
        super.e((DoubleConsumer) obj);
    }

    public final void q(int i4, Object obj) {
        super.q(i4, (double[]) obj);
    }

    public final f0 spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m25spliterator() {
        return super.spliterator();
    }

    public final void k(long j4) {
        clear();
        u(j4);
    }

    public final Object d() {
        return (double[]) super.d();
    }
}
