package j$.util.stream;

import java.util.function.IntFunction;

public abstract class O0 extends G0 implements D0 {
    public final /* synthetic */ Object[] n(IntFunction intFunction) {
        return C1232t1.m(this, intFunction);
    }

    public final void e(Object obj) {
        ((D0) this.f5294a).e(obj);
        ((D0) this.f5295b).e(obj);
    }

    public final void q(int i4, Object obj) {
        E0 e02 = this.f5294a;
        ((D0) e02).q(i4, obj);
        ((D0) this.f5295b).q(i4 + ((int) ((D0) e02).count()), obj);
    }

    public final Object d() {
        long j4 = this.f5296c;
        if (j4 < 2147483639) {
            Object c5 = c((int) j4);
            q(0, c5);
            return c5;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final String toString() {
        long j4 = this.f5296c;
        if (j4 < 32) {
            return String.format("%s[%s.%s]", new Object[]{getClass().getName(), this.f5294a, this.f5295b});
        }
        return String.format("%s[size=%d]", new Object[]{getClass().getName(), Long.valueOf(j4)});
    }
}
