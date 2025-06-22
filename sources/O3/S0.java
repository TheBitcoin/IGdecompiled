package o3;

import t3.F;
import t3.M;

public final class S0 {

    /* renamed from: a  reason: collision with root package name */
    public static final S0 f3672a = new S0();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f3673b = M.a(new F("ThreadLocalEventLoop"));

    private S0() {
    }

    public final C0970c0 a() {
        return (C0970c0) f3673b.get();
    }

    public final C0970c0 b() {
        ThreadLocal threadLocal = f3673b;
        C0970c0 c0Var = (C0970c0) threadLocal.get();
        if (c0Var != null) {
            return c0Var;
        }
        C0970c0 a5 = C0976f0.a();
        threadLocal.set(a5);
        return a5;
    }

    public final void c() {
        f3673b.set((Object) null);
    }

    public final void d(C0970c0 c0Var) {
        f3673b.set(c0Var);
    }
}
