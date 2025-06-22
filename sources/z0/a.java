package Z0;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f8827a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8828b;

    a(String str, String str2) {
        if (str != null) {
            this.f8827a = str;
            if (str2 != null) {
                this.f8828b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String b() {
        return this.f8827a;
    }

    public String c() {
        return this.f8828b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!this.f8827a.equals(fVar.b()) || !this.f8828b.equals(fVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8827a.hashCode() ^ 1000003) * 1000003) ^ this.f8828b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f8827a + ", version=" + this.f8828b + "}";
    }
}
