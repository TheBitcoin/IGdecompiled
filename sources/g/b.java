package G;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f206a = 1;

    public b a(Object obj) {
        int i4;
        int i5 = this.f206a * 31;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        this.f206a = i5 + i4;
        return this;
    }

    public int b() {
        return this.f206a;
    }

    public final b c(boolean z4) {
        this.f206a = (this.f206a * 31) + (z4 ? 1 : 0);
        return this;
    }
}
