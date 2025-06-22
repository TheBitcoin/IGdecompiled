package q;

import java.util.concurrent.Executor;
import s.C1045b;
import s.d;

public final class k implements C1045b {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f4013a = new k();
    }

    public static k a() {
        return a.f4013a;
    }

    public static Executor b() {
        return (Executor) d.d(j.a());
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
