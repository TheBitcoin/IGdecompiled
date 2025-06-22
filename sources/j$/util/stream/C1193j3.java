package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.Z;
import j$.util.f0;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.j3  reason: case insensitive filesystem */
public final class C1193j3 extends Y2 implements Z {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.i(this, consumer);
    }

    public final Y2 e(i0 i0Var) {
        return new Y2(this.f5446b, i0Var, this.f5445a);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.function.IntConsumer, j$.util.stream.R2, java.lang.Object, j$.util.stream.c] */
    public final void d() {
        ? r22 = new R2();
        this.f5452h = r22;
        Objects.requireNonNull(r22);
        this.f5449e = this.f5446b.O(new C1188i3(r22, 1));
        this.f5450f = new r(13, this);
    }

    public final Z trySplit() {
        return (Z) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final f0 m32trySplit() {
        return (Z) super.trySplit();
    }

    /* renamed from: trySplit  reason: collision with other method in class */
    public final i0 m33trySplit() {
        return (Z) super.trySplit();
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i4;
        Objects.requireNonNull(intConsumer);
        boolean a5 = a();
        if (a5) {
            N2 n22 = (N2) this.f5452h;
            long j4 = this.f5451g;
            int t4 = n22.t(j4);
            if (n22.f5479c == 0 && t4 == 0) {
                i4 = ((int[]) n22.f5396e)[(int) j4];
            } else {
                i4 = ((int[][]) n22.f5397f)[t4][(int) (j4 - n22.f5480d[t4])];
            }
            intConsumer.accept(i4);
        }
        return a5;
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.f5452h != null || this.f5453i) {
            do {
            } while (tryAdvance(intConsumer));
            return;
        }
        Objects.requireNonNull(intConsumer);
        c();
        Objects.requireNonNull(intConsumer);
        C1188i3 i3Var = new C1188i3(intConsumer, 0);
        this.f5446b.N(this.f5448d, i3Var);
        this.f5453i = true;
    }
}
