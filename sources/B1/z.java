package b1;

import androidx.privacysandbox.ads.adservices.adselection.u;
import kotlin.jvm.internal.m;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private final String f9094a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9095b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9096c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9097d;

    public z(String str, String str2, int i4, long j4) {
        m.e(str, "sessionId");
        m.e(str2, "firstSessionId");
        this.f9094a = str;
        this.f9095b = str2;
        this.f9096c = i4;
        this.f9097d = j4;
    }

    public final String a() {
        return this.f9095b;
    }

    public final String b() {
        return this.f9094a;
    }

    public final int c() {
        return this.f9096c;
    }

    public final long d() {
        return this.f9097d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (m.a(this.f9094a, zVar.f9094a) && m.a(this.f9095b, zVar.f9095b) && this.f9096c == zVar.f9096c && this.f9097d == zVar.f9097d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f9094a.hashCode() * 31) + this.f9095b.hashCode()) * 31) + this.f9096c) * 31) + u.a(this.f9097d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f9094a + ", firstSessionId=" + this.f9095b + ", sessionIndex=" + this.f9096c + ", sessionStartTimestampUs=" + this.f9097d + ')';
    }
}
