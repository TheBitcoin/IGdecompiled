package l0;

final class i extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20995a;

    i(Object obj) {
        this.f20995a = obj;
    }

    public Object b() {
        return this.f20995a;
    }

    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f20995a.equals(((i) obj).f20995a);
        }
        return false;
    }

    public int hashCode() {
        return this.f20995a.hashCode() + 1502476572;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f20995a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
