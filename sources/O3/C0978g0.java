package o3;

import t3.F;

/* renamed from: o3.g0  reason: case insensitive filesystem */
public abstract class C0978g0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f3705a = new F("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final F f3706b = new F("CLOSED_EMPTY");

    public static final long c(long j4) {
        if (j4 <= 0) {
            return 0;
        }
        if (j4 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j4 * 1000000;
    }
}
