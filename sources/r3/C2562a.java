package R3;

import P3.C2546b;
import P3.C2548d;
import Y3.C2611a;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: R3.a  reason: case insensitive filesystem */
public abstract class C2562a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23910a = C2546b.i(C2562a.class);

    private static String a(int i4) {
        return TypedValues.Custom.S_DIMENSION + i4;
    }

    public static boolean b(C2548d dVar, int i4, String str) {
        if (i4 < 1) {
            C2611a.b(f23910a).c("dimensionId should be great than 0 (arg: %d)", Integer.valueOf(i4));
            return false;
        }
        if (str != null && str.length() > 255) {
            str = str.substring(0, 255);
            C2611a.b(f23910a).h("dimensionValue was truncated to 255 chars.", new Object[0]);
        }
        if (str != null && str.length() == 0) {
            str = null;
        }
        dVar.d(a(i4), str);
        return true;
    }
}
