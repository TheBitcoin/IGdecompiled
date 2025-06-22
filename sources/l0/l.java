package l0;

import j$.util.Objects;
import java.io.Serializable;

public abstract class l {

    static class a implements k, Serializable {

        /* renamed from: a  reason: collision with root package name */
        final k f20996a;

        /* renamed from: b  reason: collision with root package name */
        volatile transient boolean f20997b;

        /* renamed from: c  reason: collision with root package name */
        transient Object f20998c;

        a(k kVar) {
            this.f20996a = (k) h.i(kVar);
        }

        public Object get() {
            if (!this.f20997b) {
                synchronized (this) {
                    try {
                        if (!this.f20997b) {
                            Object obj = this.f20996a.get();
                            this.f20998c = obj;
                            this.f20997b = true;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return e.a(this.f20998c);
        }

        public String toString() {
            Object obj;
            if (this.f20997b) {
                String valueOf = String.valueOf(this.f20998c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            } else {
                obj = this.f20996a;
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    static class b implements k {

        /* renamed from: a  reason: collision with root package name */
        volatile k f20999a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f21000b;

        /* renamed from: c  reason: collision with root package name */
        Object f21001c;

        b(k kVar) {
            this.f20999a = (k) h.i(kVar);
        }

        public Object get() {
            if (!this.f21000b) {
                synchronized (this) {
                    try {
                        if (!this.f21000b) {
                            k kVar = this.f20999a;
                            Objects.requireNonNull(kVar);
                            Object obj = kVar.get();
                            this.f21001c = obj;
                            this.f21000b = true;
                            this.f20999a = null;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return e.a(this.f21001c);
        }

        public String toString() {
            Object obj = this.f20999a;
            if (obj == null) {
                String valueOf = String.valueOf(this.f21001c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    private static class c implements k, Serializable {

        /* renamed from: a  reason: collision with root package name */
        final Object f21002a;

        c(Object obj) {
            this.f21002a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return f.a(this.f21002a, ((c) obj).f21002a);
            }
            return false;
        }

        public Object get() {
            return this.f21002a;
        }

        public int hashCode() {
            return f.b(this.f21002a);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f21002a);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static k a(k kVar) {
        if ((kVar instanceof b) || (kVar instanceof a)) {
            return kVar;
        }
        if (kVar instanceof Serializable) {
            return new a(kVar);
        }
        return new b(kVar);
    }

    public static k b(Object obj) {
        return new c(obj);
    }
}
