package y0;

import y0.J;

/* renamed from: y0.d  reason: case insensitive filesystem */
final class C2414d extends J.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f22631a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22632b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22633c;

    C2414d(String str, String str2, String str3) {
        if (str != null) {
            this.f22631a = str;
            this.f22632b = str2;
            this.f22633c = str3;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public String c() {
        return this.f22631a;
    }

    public String d() {
        return this.f22633c;
    }

    public String e() {
        return this.f22632b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof J.a) {
            J.a aVar = (J.a) obj;
            if (!this.f22631a.equals(aVar.c()) || ((str = this.f22632b) != null ? !str.equals(aVar.e()) : aVar.e() != null) || ((str2 = this.f22633c) != null ? !str2.equals(aVar.d()) : aVar.d() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (this.f22631a.hashCode() ^ 1000003) * 1000003;
        String str = this.f22632b;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i6 = (hashCode ^ i4) * 1000003;
        String str2 = this.f22633c;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f22631a + ", firebaseInstallationId=" + this.f22632b + ", firebaseAuthenticationToken=" + this.f22633c + "}";
    }
}
