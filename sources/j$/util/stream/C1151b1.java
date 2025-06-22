package j$.util.stream;

import j$.util.f0;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.b1  reason: case insensitive filesystem */
public final class C1151b1 extends N2 implements A0, C1235u0 {
    public final A0 a() {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final E0 m27a() {
        return this;
    }

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

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.u(this, j4, j5);
    }

    public final void j() {
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
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
        C1232t1.o(this, (Integer[]) objArr, i4);
    }

    public final void e(Object obj) {
        super.e((IntConsumer) obj);
    }

    public final void q(int i4, Object obj) {
        super.q(i4, (int[]) obj);
    }

    public final f0 spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m28spliterator() {
        return super.spliterator();
    }

    public final void k(long j4) {
        clear();
        u(j4);
    }

    public final Object d() {
        return (int[]) super.d();
    }
}
