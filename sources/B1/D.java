package b1;

import androidx.privacysandbox.ads.adservices.adselection.u;
import kotlin.jvm.internal.m;

public final class D {

    /* renamed from: a  reason: collision with root package name */
    private final String f8943a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8944b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8945c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8946d;

    /* renamed from: e  reason: collision with root package name */
    private final C1623f f8947e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8948f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8949g;

    public D(String str, String str2, int i4, long j4, C1623f fVar, String str3, String str4) {
        m.e(str, "sessionId");
        m.e(str2, "firstSessionId");
        m.e(fVar, "dataCollectionStatus");
        m.e(str3, "firebaseInstallationId");
        m.e(str4, "firebaseAuthenticationToken");
        this.f8943a = str;
        this.f8944b = str2;
        this.f8945c = i4;
        this.f8946d = j4;
        this.f8947e = fVar;
        this.f8948f = str3;
        this.f8949g = str4;
    }

    public final C1623f a() {
        return this.f8947e;
    }

    public final long b() {
        return this.f8946d;
    }

    public final String c() {
        return this.f8949g;
    }

    public final String d() {
        return this.f8948f;
    }

    public final String e() {
        return this.f8944b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d5 = (D) obj;
        if (m.a(this.f8943a, d5.f8943a) && m.a(this.f8944b, d5.f8944b) && this.f8945c == d5.f8945c && this.f8946d == d5.f8946d && m.a(this.f8947e, d5.f8947e) && m.a(this.f8948f, d5.f8948f) && m.a(this.f8949g, d5.f8949g)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f8943a;
    }

    public final int g() {
        return this.f8945c;
    }

    public int hashCode() {
        return (((((((((((this.f8943a.hashCode() * 31) + this.f8944b.hashCode()) * 31) + this.f8945c) * 31) + u.a(this.f8946d)) * 31) + this.f8947e.hashCode()) * 31) + this.f8948f.hashCode()) * 31) + this.f8949g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f8943a + ", firstSessionId=" + this.f8944b + ", sessionIndex=" + this.f8945c + ", eventTimestampUs=" + this.f8946d + ", dataCollectionStatus=" + this.f8947e + ", firebaseInstallationId=" + this.f8948f + ", firebaseAuthenticationToken=" + this.f8949g + ')';
    }
}
