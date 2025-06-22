package o;

/* renamed from: o.b  reason: case insensitive filesystem */
final class C0961b extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f3617a;

    C0961b(Integer num) {
        this.f3617a = num;
    }

    public Integer a() {
        return this.f3617a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Integer num = this.f3617a;
        Integer a5 = ((g) obj).a();
        if (num != null) {
            return num.equals(a5);
        }
        if (a5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Integer num = this.f3617a;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        return i4 ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f3617a + "}";
    }
}
