package u2;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class E {

    public static final class a extends E {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21883a = new a();

        private a() {
            super((C2103g) null);
        }
    }

    public static final class b extends E {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21884a = new b();

        private b() {
            super((C2103g) null);
        }
    }

    public static final class c extends E {

        /* renamed from: a  reason: collision with root package name */
        private final Object f21885a;

        public c(Object obj) {
            super((C2103g) null);
            this.f21885a = obj;
        }

        public final Object a() {
            return this.f21885a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof c) && m.a(this.f21885a, ((c) obj).f21885a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f21885a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f21885a + ')';
        }
    }

    public /* synthetic */ E(C2103g gVar) {
        this();
    }

    private E() {
    }
}
