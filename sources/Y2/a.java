package Y2;

import S2.C1594h;
import h3.b;
import h3.c;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

public abstract class a {

    /* renamed from: Y2.a$a  reason: collision with other inner class name */
    private static final class C0128a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0128a f8823a = new C0128a();

        /* renamed from: b  reason: collision with root package name */
        public static final Method f8824b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f8825c;

        static {
            Method method;
            Method method2;
            Class<Throwable> cls = Throwable.class;
            Method[] methods = cls.getMethods();
            m.b(methods);
            int length = methods.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                method = null;
                if (i5 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i5];
                if (m.a(method2.getName(), "addSuppressed")) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    m.d(parameterTypes, "getParameterTypes(...)");
                    if (m.a(C1594h.E(parameterTypes), cls)) {
                        break;
                    }
                }
                i5++;
            }
            f8824b = method2;
            int length2 = methods.length;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                Method method3 = methods[i4];
                if (m.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i4++;
            }
            f8825c = method;
        }

        private C0128a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        m.e(th, "cause");
        m.e(th2, "exception");
        Method method = C0128a.f8824b;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    public c b() {
        return new b();
    }
}
