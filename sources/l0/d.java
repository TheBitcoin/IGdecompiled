package l0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public abstract class d {

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f20987a;

        /* renamed from: b  reason: collision with root package name */
        private final a f20988b;

        /* renamed from: c  reason: collision with root package name */
        private a f20989c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f20990d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f20991e;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            String f20992a;

            /* renamed from: b  reason: collision with root package name */
            Object f20993b;

            /* renamed from: c  reason: collision with root package name */
            a f20994c;

            private a() {
            }
        }

        private a a() {
            a aVar = new a();
            this.f20989c.f20994c = aVar;
            this.f20989c = aVar;
            return aVar;
        }

        private b b(Object obj) {
            a().f20993b = obj;
            return this;
        }

        private static boolean d(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() == 0) {
                    return true;
                }
                return false;
            } else if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            } else {
                if (obj instanceof Map) {
                    return ((Map) obj).isEmpty();
                }
                if (obj instanceof g) {
                    return !((g) obj).c();
                }
                if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                    return false;
                }
                return true;
            }
        }

        public b c(Object obj) {
            return b(obj);
        }

        public String toString() {
            boolean z4 = this.f20990d;
            boolean z5 = this.f20991e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f20987a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f20988b.f20994c; aVar != null; aVar = aVar.f20994c) {
                Object obj = aVar.f20993b;
                if (obj == null) {
                    if (z4) {
                    }
                } else if (z5 && d(obj)) {
                }
                sb.append(str);
                String str2 = aVar.f20992a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append(deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f20988b = aVar;
            this.f20989c = aVar;
            this.f20990d = false;
            this.f20991e = false;
            this.f20987a = (String) h.i(str);
        }
    }

    public static b a(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
