package A0;

/* renamed from: A0.b  reason: case insensitive filesystem */
final class C1266b extends i {

    /* renamed from: b  reason: collision with root package name */
    private final String f5691b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5692c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5693d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5694e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5695f;

    C1266b(String str, String str2, String str3, String str4, long j4) {
        if (str != null) {
            this.f5691b = str;
            if (str2 != null) {
                this.f5692c = str2;
                if (str3 != null) {
                    this.f5693d = str3;
                    if (str4 != null) {
                        this.f5694e = str4;
                        this.f5695f = j4;
                        return;
                    }
                    throw new NullPointerException("Null variantId");
                }
                throw new NullPointerException("Null parameterValue");
            }
            throw new NullPointerException("Null parameterKey");
        }
        throw new NullPointerException("Null rolloutId");
    }

    public String c() {
        return this.f5692c;
    }

    public String d() {
        return this.f5693d;
    }

    public String e() {
        return this.f5691b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (!this.f5691b.equals(iVar.e()) || !this.f5692c.equals(iVar.c()) || !this.f5693d.equals(iVar.d()) || !this.f5694e.equals(iVar.g()) || this.f5695f != iVar.f()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public long f() {
        return this.f5695f;
    }

    public String g() {
        return this.f5694e;
    }

    public int hashCode() {
        long j4 = this.f5695f;
        return ((((((((this.f5691b.hashCode() ^ 1000003) * 1000003) ^ this.f5692c.hashCode()) * 1000003) ^ this.f5693d.hashCode()) * 1000003) ^ this.f5694e.hashCode()) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f5691b + ", parameterKey=" + this.f5692c + ", parameterValue=" + this.f5693d + ", variantId=" + this.f5694e + ", templateVersion=" + this.f5695f + "}";
    }
}
