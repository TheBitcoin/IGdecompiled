package j$.util.stream;

import j$.time.format.r;
import j$.util.Objects;
import j$.util.i0;
import java.util.function.Consumer;

public final class A3 extends Y2 {
    public final Y2 e(i0 i0Var) {
        return new Y2(this.f5446b, i0Var, this.f5445a);
    }

    public final void d() {
        S2 s22 = new S2();
        this.f5452h = s22;
        Objects.requireNonNull(s22);
        this.f5449e = this.f5446b.O(new z3(s22, 0));
        this.f5450f = new r(15, this);
    }

    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean a5 = a();
        if (!a5) {
            return a5;
        }
        S2 s22 = (S2) this.f5452h;
        long j4 = this.f5451g;
        if (s22.f5479c == 0) {
            if (j4 < ((long) s22.f5478b)) {
                obj = s22.f5402e[(int) j4];
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j4));
            }
        } else if (j4 < s22.count()) {
            int i4 = 0;
            while (i4 <= s22.f5479c) {
                long j5 = s22.f5480d[i4];
                Object[] objArr = s22.f5403f[i4];
                if (j4 < ((long) objArr.length) + j5) {
                    obj = objArr[(int) (j4 - j5)];
                } else {
                    i4++;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j4));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j4));
        }
        consumer.accept(obj);
        return a5;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f5452h != null || this.f5453i) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        Objects.requireNonNull(consumer);
        c();
        Objects.requireNonNull(consumer);
        z3 z3Var = new z3(consumer, 1);
        this.f5446b.N(this.f5448d, z3Var);
        this.f5453i = true;
    }
}
