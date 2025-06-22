package B0;

import B0.G;

/* renamed from: B0.E  reason: case insensitive filesystem */
final class C1275E extends G.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f5770a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5771b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5772c;

    C1275E(String str, String str2, boolean z4) {
        if (str != null) {
            this.f5770a = str;
            if (str2 != null) {
                this.f5771b = str2;
                this.f5772c = z4;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean b() {
        return this.f5772c;
    }

    public String c() {
        return this.f5771b;
    }

    public String d() {
        return this.f5770a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.c) {
            G.c cVar = (G.c) obj;
            if (!this.f5770a.equals(cVar.d()) || !this.f5771b.equals(cVar.c()) || this.f5772c != cVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.f5770a.hashCode() ^ 1000003) * 1000003) ^ this.f5771b.hashCode()) * 1000003;
        if (this.f5772c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    public String toString() {
        return "OsData{osRelease=" + this.f5770a + ", osCodeName=" + this.f5771b + ", isRooted=" + this.f5772c + "}";
    }
}
