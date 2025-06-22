package x3;

import t3.F;

public abstract class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f4694a = new F("NO_OWNER");

    /* renamed from: b  reason: collision with root package name */
    private static final F f4695b = new F("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z4) {
        return new b(z4);
    }

    public static /* synthetic */ a b(boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        return a(z4);
    }
}
