package j$.util.stream;

import j$.util.f0;
import j$.util.i0;
import java.util.ArrayDeque;

/* renamed from: j$.util.stream.f1  reason: case insensitive filesystem */
public abstract class C1171f1 extends C1181h1 implements f0 {
    public final boolean tryAdvance(Object obj) {
        D0 d02;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = ((f0) this.f5512d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.f5511c != null || (d02 = (D0) C1181h1.a(this.f5513e)) == null) {
                this.f5509a = null;
            } else {
                f0 spliterator = d02.spliterator();
                this.f5512d = spliterator;
                return spliterator.tryAdvance(obj);
            }
        }
        return tryAdvance;
    }

    public final void forEachRemaining(Object obj) {
        if (this.f5509a != null) {
            if (this.f5512d == null) {
                i0 i0Var = this.f5511c;
                if (i0Var == null) {
                    ArrayDeque b5 = b();
                    while (true) {
                        D0 d02 = (D0) C1181h1.a(b5);
                        if (d02 != null) {
                            d02.e(obj);
                        } else {
                            this.f5509a = null;
                            return;
                        }
                    }
                } else {
                    ((f0) i0Var).forEachRemaining(obj);
                }
            } else {
                do {
                } while (tryAdvance(obj));
            }
        }
    }
}
