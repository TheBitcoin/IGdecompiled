package D3;

import java.io.IOException;

/* renamed from: D3.v  reason: case insensitive filesystem */
public enum C2474v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    QUIC("quic");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f23194a;

    private C2474v(String str) {
        this.f23194a = str;
    }

    public static C2474v a(String str) {
        C2474v vVar = HTTP_1_0;
        if (str.equals(vVar.f23194a)) {
            return vVar;
        }
        C2474v vVar2 = HTTP_1_1;
        if (str.equals(vVar2.f23194a)) {
            return vVar2;
        }
        C2474v vVar3 = HTTP_2;
        if (str.equals(vVar3.f23194a)) {
            return vVar3;
        }
        C2474v vVar4 = SPDY_3;
        if (str.equals(vVar4.f23194a)) {
            return vVar4;
        }
        C2474v vVar5 = QUIC;
        if (str.equals(vVar5.f23194a)) {
            return vVar5;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f23194a;
    }
}
