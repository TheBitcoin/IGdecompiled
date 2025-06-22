package c1;

import kotlin.jvm.internal.m;

/* renamed from: c1.b  reason: case insensitive filesystem */
public interface C1649b {

    /* renamed from: c1.b$a */
    public enum a {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    /* renamed from: c1.b$b  reason: collision with other inner class name */
    public static final class C0162b {

        /* renamed from: a  reason: collision with root package name */
        private final String f9672a;

        public C0162b(String str) {
            m.e(str, "sessionId");
            this.f9672a = str;
        }

        public final String a() {
            return this.f9672a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof C0162b) && m.a(this.f9672a, ((C0162b) obj).f9672a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f9672a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f9672a + ')';
        }
    }

    boolean a();

    a b();

    void c(C0162b bVar);
}
