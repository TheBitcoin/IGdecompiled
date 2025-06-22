package H3;

import D3.C2474v;
import java.net.ProtocolException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final C2474v f23398a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23399b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23400c;

    public k(C2474v vVar, int i4, String str) {
        this.f23398a = vVar;
        this.f23399b = i4;
        this.f23400c = str;
    }

    public static k a(String str) {
        int i4;
        C2474v vVar;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i4 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vVar = C2474v.HTTP_1_0;
            } else if (charAt == 1) {
                vVar = C2474v.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            vVar = C2474v.HTTP_1_0;
            i4 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i5 = i4 + 3;
        if (str.length() >= i5) {
            try {
                int parseInt = Integer.parseInt(str.substring(i4, i5));
                if (str.length() <= i5) {
                    str2 = "";
                } else if (str.charAt(i5) == ' ') {
                    str2 = str.substring(i4 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(vVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f23398a == C2474v.HTTP_1_0) {
            str = "HTTP/1.0";
        } else {
            str = "HTTP/1.1";
        }
        sb.append(str);
        sb.append(' ');
        sb.append(this.f23399b);
        if (this.f23400c != null) {
            sb.append(' ');
            sb.append(this.f23400c);
        }
        return sb.toString();
    }
}
