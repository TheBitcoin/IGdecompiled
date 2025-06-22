package N0;

import N0.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f7746a;

    /* renamed from: b  reason: collision with root package name */
    private d.a f7747b = d.a.DEFAULT;

    /* renamed from: N0.a$a  reason: collision with other inner class name */
    private static final class C0094a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f7748a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f7749b;

        C0094a(int i4, d.a aVar) {
            this.f7748a = i4;
            this.f7749b = aVar;
        }

        public Class annotationType() {
            return d.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f7748a != dVar.tag() || !this.f7749b.equals(dVar.intEncoding())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (14552422 ^ this.f7748a) + (this.f7749b.hashCode() ^ 2041407134);
        }

        public d.a intEncoding() {
            return this.f7749b;
        }

        public int tag() {
            return this.f7748a;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.f7748a + "intEncoding=" + this.f7749b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0094a(this.f7746a, this.f7747b);
    }

    public a c(int i4) {
        this.f7746a = i4;
        return this;
    }
}
