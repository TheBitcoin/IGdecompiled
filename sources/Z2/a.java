package Z2;

import kotlin.jvm.internal.m;

public abstract class a extends Y2.a {

    /* renamed from: Z2.a$a  reason: collision with other inner class name */
    private static final class C0131a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0131a f8898a = new C0131a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f8899b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                    if (num != null && num.intValue() > 0) {
                        num2 = num;
                    }
                    f8899b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f8899b = num2;
        }

        private C0131a() {
        }
    }

    private final boolean c(int i4) {
        Integer num = C0131a.f8899b;
        if (num == null || num.intValue() >= i4) {
            return true;
        }
        return false;
    }

    public void a(Throwable th, Throwable th2) {
        m.e(th, "cause");
        m.e(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
