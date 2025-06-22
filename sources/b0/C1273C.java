package B0;

import B0.G;
import v0.f;

/* renamed from: B0.C  reason: case insensitive filesystem */
final class C1273C extends G.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5755a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5756b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5757c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5758d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5759e;

    /* renamed from: f  reason: collision with root package name */
    private final f f5760f;

    C1273C(String str, String str2, String str3, String str4, int i4, f fVar) {
        if (str != null) {
            this.f5755a = str;
            if (str2 != null) {
                this.f5756b = str2;
                if (str3 != null) {
                    this.f5757c = str3;
                    if (str4 != null) {
                        this.f5758d = str4;
                        this.f5759e = i4;
                        if (fVar != null) {
                            this.f5760f = fVar;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    public String a() {
        return this.f5755a;
    }

    public int c() {
        return this.f5759e;
    }

    public f d() {
        return this.f5760f;
    }

    public String e() {
        return this.f5758d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.a) {
            G.a aVar = (G.a) obj;
            if (!this.f5755a.equals(aVar.a()) || !this.f5756b.equals(aVar.f()) || !this.f5757c.equals(aVar.g()) || !this.f5758d.equals(aVar.e()) || this.f5759e != aVar.c() || !this.f5760f.equals(aVar.d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f5756b;
    }

    public String g() {
        return this.f5757c;
    }

    public int hashCode() {
        return ((((((((((this.f5755a.hashCode() ^ 1000003) * 1000003) ^ this.f5756b.hashCode()) * 1000003) ^ this.f5757c.hashCode()) * 1000003) ^ this.f5758d.hashCode()) * 1000003) ^ this.f5759e) * 1000003) ^ this.f5760f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f5755a + ", versionCode=" + this.f5756b + ", versionName=" + this.f5757c + ", installUuid=" + this.f5758d + ", deliveryMechanism=" + this.f5759e + ", developmentPlatformProvider=" + this.f5760f + "}";
    }
}
