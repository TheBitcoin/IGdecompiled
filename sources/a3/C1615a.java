package a3;

import Z2.a;
import h3.c;

/* renamed from: a3.a  reason: case insensitive filesystem */
public class C1615a extends a {

    /* renamed from: a3.a$a  reason: collision with other inner class name */
    private static final class C0132a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0132a f8916a = new C0132a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f8917b;

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
                    f8917b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f8917b = num2;
        }

        private C0132a() {
        }
    }

    private final boolean c(int i4) {
        Integer num = C0132a.f8917b;
        if (num == null || num.intValue() >= i4) {
            return true;
        }
        return false;
    }

    public c b() {
        if (c(34)) {
            return new i3.a();
        }
        return super.b();
    }
}
