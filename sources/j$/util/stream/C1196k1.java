package j$.util.stream;

import j$.util.f0;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.k1  reason: case insensitive filesystem */
public final class C1196k1 extends P2 implements C0, C1239v0 {
    public final C0 a() {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final E0 m34a() {
        return this;
    }

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

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.v(this, j4, j5);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final /* synthetic */ Object[] n(IntFunction intFunction) {
        return C1232t1.m(this, intFunction);
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final D0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void h(Object[] objArr, int i4) {
        C1232t1.p(this, (Long[]) objArr, i4);
    }

    public final void e(Object obj) {
        super.e((LongConsumer) obj);
    }

    public final void q(int i4, Object obj) {
        super.q(i4, (long[]) obj);
    }

    public final f0 spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m35spliterator() {
        return super.spliterator();
    }

    public final void k(long j4) {
        clear();
        u(j4);
    }

    public final Object d() {
        return (long[]) super.d();
    }
}
