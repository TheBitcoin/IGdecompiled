package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.f0;
import j$.util.i0;
import java.util.Comparator;

public abstract class v3 extends y3 implements f0 {
    public abstract void e(Object obj);

    public abstract C1158c3 g(int i4);

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (d() != x3.NO_MORE && ((f0) this.f5641a).tryAdvance(this)) {
            if (b(1) == 1) {
                e(obj);
                return true;
            }
        }
        return false;
    }

    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        C1158c3 c3Var = null;
        while (true) {
            x3 d5 = d();
            if (d5 != x3.NO_MORE) {
                x3 x3Var = x3.MAYBE_MORE;
                i0 i0Var = this.f5641a;
                if (d5 == x3Var) {
                    int i4 = this.f5643c;
                    if (c3Var == null) {
                        c3Var = g(i4);
                    } else {
                        c3Var.f5482b = 0;
                    }
                    long j4 = 0;
                    while (((f0) i0Var).tryAdvance(c3Var)) {
                        j4++;
                        if (j4 >= ((long) i4)) {
                            break;
                        }
                    }
                    if (j4 != 0) {
                        c3Var.b(obj, b(j4));
                    } else {
                        return;
                    }
                } else {
                    ((f0) i0Var).forEachRemaining(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }
}
