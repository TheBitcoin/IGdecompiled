package M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: M.n  reason: case insensitive filesystem */
public abstract class C0333n {

    /* renamed from: M.n$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f561a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f562b;

        /* synthetic */ a(Object obj, Z z4) {
            C0335p.l(obj);
            this.f562b = obj;
        }

        public a a(String str, Object obj) {
            C0335p.l(str);
            String valueOf = String.valueOf(obj);
            this.f561a.add(str + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f562b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f561a.size();
            for (int i4 = 0; i4 < size; i4++) {
                sb.append((String) this.f561a.get(i4));
                if (i4 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, (Z) null);
    }
}
