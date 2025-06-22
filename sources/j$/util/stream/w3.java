package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class w3 extends y3 implements i0, Consumer {

    /* renamed from: f  reason: collision with root package name */
    public Object f5628f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final void accept(Object obj) {
        this.f5628f = obj;
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (d() != x3.NO_MORE && this.f5641a.tryAdvance(this)) {
            if (b(1) == 1) {
                consumer.accept(this.f5628f);
                this.f5628f = null;
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C1163d3 d3Var = null;
        while (true) {
            x3 d5 = d();
            if (d5 != x3.NO_MORE) {
                x3 x3Var = x3.MAYBE_MORE;
                i0 i0Var = this.f5641a;
                if (d5 == x3Var) {
                    int i4 = this.f5643c;
                    if (d3Var == null) {
                        d3Var = new C1163d3(i4);
                    } else {
                        d3Var.f5499a = 0;
                    }
                    long j4 = 0;
                    while (i0Var.tryAdvance(d3Var)) {
                        j4++;
                        if (j4 >= ((long) i4)) {
                            break;
                        }
                    }
                    if (j4 != 0) {
                        long b5 = b(j4);
                        for (int i5 = 0; ((long) i5) < b5; i5++) {
                            consumer.accept(d3Var.f5494b[i5]);
                        }
                    } else {
                        return;
                    }
                } else {
                    i0Var.forEachRemaining(consumer);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 c(i0 i0Var) {
        return new y3(i0Var, this);
    }
}
