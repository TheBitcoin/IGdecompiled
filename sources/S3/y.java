package s3;

import q3.a;
import r3.I;

final class y extends r3.y implements I {
    public y(int i4) {
        super(1, Integer.MAX_VALUE, a.DROP_OLDEST);
        f(Integer.valueOf(i4));
    }

    /* renamed from: Y */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(((Number) L()).intValue());
        }
        return valueOf;
    }

    public final boolean Z(int i4) {
        boolean f4;
        synchronized (this) {
            f4 = f(Integer.valueOf(((Number) L()).intValue() + i4));
        }
        return f4;
    }
}
