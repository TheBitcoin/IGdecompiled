package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.W;
import j$.util.f0;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.h3  reason: case insensitive filesystem */
public final class C1183h3 extends Y2 implements W {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.h(this, consumer);
    }

    public final Y2 e(i0 i0Var) {
        return new Y2(this.f5446b, i0Var, this.f5445a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.R2, java.lang.Object, j$.util.stream.c, java.util.function.DoubleConsumer] */
    public final void d() {
        ? r22 = new R2();
        this.f5452h = r22;
        Objects.requireNonNull(r22);
        this.f5449e = this.f5446b.O(new C1178g3(r22, 1));
        this.f5450f = new r(12, this);
    }

    public final W trySplit() {
        return (W) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m29trySplit() {
        return (W) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final i0 m30trySplit() {
        return (W) super.trySplit();
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        double d5;
        Objects.requireNonNull(doubleConsumer);
        boolean a5 = a();
        if (a5) {
            L2 l22 = (L2) this.f5452h;
            long j4 = this.f5451g;
            int t4 = l22.t(j4);
            if (l22.f5479c == 0 && t4 == 0) {
                d5 = ((double[]) l22.f5396e)[(int) j4];
            } else {
                d5 = ((double[][]) l22.f5397f)[t4][(int) (j4 - l22.f5480d[t4])];
            }
            doubleConsumer.accept(d5);
        }
        return a5;
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.f5452h != null || this.f5453i) {
            do {
            } while (tryAdvance(doubleConsumer));
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        c();
        Objects.requireNonNull(doubleConsumer);
        C1178g3 g3Var = new C1178g3(doubleConsumer, 0);
        this.f5446b.N(this.f5448d, g3Var);
        this.f5453i = true;
    }
}
