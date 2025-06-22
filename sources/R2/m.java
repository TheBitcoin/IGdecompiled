package R2;

import java.io.Serializable;
import kotlin.jvm.internal.C2103g;

public abstract class m implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8216a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f8217a;

        public b(Throwable th) {
            kotlin.jvm.internal.m.e(th, "exception");
            this.f8217a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b) || !kotlin.jvm.internal.m.a(this.f8217a, ((b) obj).f8217a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f8217a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f8217a + ')';
        }
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f8217a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }

    public static Object a(Object obj) {
        return obj;
    }
}
