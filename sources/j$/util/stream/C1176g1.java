package j$.util.stream;

import j$.util.i0;
import java.util.ArrayDeque;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.g1  reason: case insensitive filesystem */
public final class C1176g1 extends C1181h1 {
    public final boolean tryAdvance(Consumer consumer) {
        E0 a5;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = this.f5512d.tryAdvance(consumer);
        if (!tryAdvance) {
            if (this.f5511c != null || (a5 = C1181h1.a(this.f5513e)) == null) {
                this.f5509a = null;
            } else {
                i0 spliterator = a5.spliterator();
                this.f5512d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
        }
        return tryAdvance;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f5509a != null) {
            if (this.f5512d == null) {
                i0 i0Var = this.f5511c;
                if (i0Var == null) {
                    ArrayDeque b5 = b();
                    while (true) {
                        E0 a5 = C1181h1.a(b5);
                        if (a5 != null) {
                            a5.forEach(consumer);
                        } else {
                            this.f5509a = null;
                            return;
                        }
                    }
                } else {
                    i0Var.forEachRemaining(consumer);
                }
            } else {
                do {
                } while (tryAdvance(consumer));
            }
        }
    }
}
