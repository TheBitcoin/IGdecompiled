package p;

import p.s;

final class i extends s {

    /* renamed from: a  reason: collision with root package name */
    private final r f3826a;

    static final class b extends s.a {

        /* renamed from: a  reason: collision with root package name */
        private r f3827a;

        b() {
        }

        public s a() {
            return new i(this.f3827a);
        }

        public s.a b(r rVar) {
            this.f3827a = rVar;
            return this;
        }
    }

    public r b() {
        return this.f3826a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        r rVar = this.f3826a;
        r b5 = ((s) obj).b();
        if (rVar != null) {
            return rVar.equals(b5);
        }
        if (b5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        r rVar = this.f3826a;
        if (rVar == null) {
            i4 = 0;
        } else {
            i4 = rVar.hashCode();
        }
        return i4 ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f3826a + "}";
    }

    private i(r rVar) {
        this.f3826a = rVar;
    }
}
