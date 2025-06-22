package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.c0;
import j$.util.f0;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class l3 extends Y2 implements c0 {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.j(this, consumer);
    }

    public final Y2 e(i0 i0Var) {
        return new Y2(this.f5446b, i0Var, this.f5445a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.R2, java.lang.Object, j$.util.stream.c, java.util.function.LongConsumer] */
    public final void d() {
        ? r22 = new R2();
        this.f5452h = r22;
        Objects.requireNonNull(r22);
        this.f5449e = this.f5446b.O(new C1198k3(r22, 1));
        this.f5450f = new r(14, this);
    }

    public final c0 trySplit() {
        return (c0) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m36trySplit() {
        return (c0) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final i0 m37trySplit() {
        return (c0) super.trySplit();
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        long j4;
        Objects.requireNonNull(longConsumer);
        boolean a5 = a();
        if (a5) {
            P2 p22 = (P2) this.f5452h;
            long j5 = this.f5451g;
            int t4 = p22.t(j5);
            if (p22.f5479c == 0 && t4 == 0) {
                j4 = ((long[]) p22.f5396e)[(int) j5];
            } else {
                j4 = ((long[][]) p22.f5397f)[t4][(int) (j5 - p22.f5480d[t4])];
            }
            longConsumer.accept(j4);
        }
        return a5;
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.f5452h != null || this.f5453i) {
            do {
            } while (tryAdvance(longConsumer));
            return;
        }
        Objects.requireNonNull(longConsumer);
        c();
        Objects.requireNonNull(longConsumer);
        C1198k3 k3Var = new C1198k3(longConsumer, 0);
        this.f5446b.N(this.f5448d, k3Var);
        this.f5453i = true;
    }
}
