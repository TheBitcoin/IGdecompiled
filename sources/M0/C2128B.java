package m0;

/* renamed from: m0.B  reason: case insensitive filesystem */
public abstract class C2128B {
    static boolean a(C2127A a5, Object obj) {
        if (obj == a5) {
            return true;
        }
        if (obj instanceof C2127A) {
            return a5.a().equals(((C2127A) obj).a());
        }
        return false;
    }
}
