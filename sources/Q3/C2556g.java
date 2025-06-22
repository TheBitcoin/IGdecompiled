package Q3;

import P3.C2546b;
import Y3.C2611a;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.Map;

/* renamed from: Q3.g  reason: case insensitive filesystem */
public class C2556g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23891c = C2546b.i(C2556g.class);

    /* renamed from: a  reason: collision with root package name */
    private final long f23892a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23893b;

    public C2556g(Map map) {
        this(d(map));
    }

    private static String c(String str) {
        try {
            return URLEncoder.encode(str, C.UTF8_NAME).replaceAll("\\+", "%20");
        } catch (Exception e5) {
            C2611a.b(f23891c).e(e5, "Cannot encode %s", str);
            return "";
        }
    }

    private static String d(Map map) {
        StringBuilder sb = new StringBuilder(100);
        sb.append('?');
        for (Map.Entry entry : map.entrySet()) {
            sb.append(c((String) entry.getKey()));
            sb.append('=');
            sb.append(c((String) entry.getValue()));
            sb.append('&');
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String a() {
        return this.f23893b;
    }

    public long b() {
        return this.f23892a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2556g gVar = (C2556g) obj;
            if (this.f23892a != gVar.f23892a || !this.f23893b.equals(gVar.f23893b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f23892a;
        return (((int) (j4 ^ (j4 >>> 32))) * 31) + this.f23893b.hashCode();
    }

    public String toString() {
        return a();
    }

    public C2556g(String str) {
        this(System.currentTimeMillis(), str);
    }

    public C2556g(long j4, String str) {
        this.f23892a = j4;
        this.f23893b = str;
    }
}
