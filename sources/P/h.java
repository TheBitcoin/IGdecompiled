package p;

import p.r;

final class h extends r {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f3824a;

    static final class b extends r.a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f3825a;

        b() {
        }

        public r a() {
            return new h(this.f3825a);
        }

        public r.a b(Integer num) {
            this.f3825a = num;
            return this;
        }
    }

    public Integer b() {
        return this.f3824a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        Integer num = this.f3824a;
        Integer b5 = ((r) obj).b();
        if (num != null) {
            return num.equals(b5);
        }
        if (b5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Integer num = this.f3824a;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        return i4 ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f3824a + "}";
    }

    private h(Integer num) {
        this.f3824a = num;
    }
}
