package P0;

import java.util.List;

final class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private final String f7968a;

    /* renamed from: b  reason: collision with root package name */
    private final List f7969b;

    a(String str, List list) {
        if (str != null) {
            this.f7968a = str;
            if (list != null) {
                this.f7969b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public List b() {
        return this.f7969b;
    }

    public String c() {
        return this.f7968a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (!this.f7968a.equals(lVar.c()) || !this.f7969b.equals(lVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f7968a.hashCode() ^ 1000003) * 1000003) ^ this.f7969b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f7968a + ", usedDates=" + this.f7969b + "}";
    }
}
