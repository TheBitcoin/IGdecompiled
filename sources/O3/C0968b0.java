package o3;

/* renamed from: o3.b0  reason: case insensitive filesystem */
final class C0968b0 implements C0992n0 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3689a;

    public C0968b0(boolean z4) {
        this.f3689a = z4;
    }

    public F0 b() {
        return null;
    }

    public boolean isActive() {
        return this.f3689a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
