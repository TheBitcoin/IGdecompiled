package q3;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class h {

    /* renamed from: b  reason: collision with root package name */
    public static final b f4091b = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f4092c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f4093a;

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f4094a;

        public a(Throwable th) {
            this.f4094a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || !m.a(this.f4094a, ((a) obj).f4094a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.f4094a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.f4094a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final Object a(Throwable th) {
            return h.c(new a(th));
        }

        public final Object b() {
            return h.c(h.f4092c);
        }

        public final Object c(Object obj) {
            return h.c(obj);
        }

        private b() {
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ h(Object obj) {
        this.f4093a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        if ((obj2 instanceof h) && m.a(obj, ((h) obj2).k())) {
            return true;
        }
        return false;
    }

    public static final Throwable e(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.f4094a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (!(obj instanceof c)) {
            return obj;
        }
        return null;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f4093a, obj);
    }

    public int hashCode() {
        return g(this.f4093a);
    }

    public final /* synthetic */ Object k() {
        return this.f4093a;
    }

    public String toString() {
        return j(this.f4093a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
