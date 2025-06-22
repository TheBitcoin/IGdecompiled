package y0;

import kotlin.jvm.internal.m;

public final class H {

    /* renamed from: a  reason: collision with root package name */
    private final String f22593a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22594b;

    public H(String str, String str2) {
        this.f22593a = str;
        this.f22594b = str2;
    }

    public final String a() {
        return this.f22594b;
    }

    public final String b() {
        return this.f22593a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h4 = (H) obj;
        if (m.a(this.f22593a, h4.f22593a) && m.a(this.f22594b, h4.f22594b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        String str = this.f22593a;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i6 = i4 * 31;
        String str2 = this.f22594b;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f22593a + ", authToken=" + this.f22594b + ')';
    }
}
