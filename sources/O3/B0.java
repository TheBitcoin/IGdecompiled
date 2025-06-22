package o3;

import t3.F;

public abstract class B0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f3640a = new F("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final F f3641b = new F("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final F f3642c = new F("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final F f3643d = new F("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final F f3644e = new F("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final C0968b0 f3645f = new C0968b0(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final C0968b0 f3646g = new C0968b0(true);

    public static final Object g(Object obj) {
        if (obj instanceof C0992n0) {
            return new C0994o0((C0992n0) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        C0994o0 o0Var;
        C0992n0 n0Var;
        if (obj instanceof C0994o0) {
            o0Var = (C0994o0) obj;
        } else {
            o0Var = null;
        }
        if (o0Var == null || (n0Var = o0Var.f3719a) == null) {
            return obj;
        }
        return n0Var;
    }
}
