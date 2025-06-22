package n0;

import l0.h;

/* renamed from: n0.a  reason: case insensitive filesystem */
public abstract class C2156a extends C2157b {
    public static int a(int i4, int i5, int i6) {
        boolean z4;
        if (i5 <= i6) {
            z4 = true;
        } else {
            z4 = false;
        }
        h.f(z4, "min (%s) must be less than or equal to max (%s)", i5, i6);
        return Math.min(Math.max(i4, i5), i6);
    }
}
