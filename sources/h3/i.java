package H3;

import D3.C2470r;
import D3.x;
import java.net.Proxy;

public abstract class i {
    public static String a(x xVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.g());
        sb.append(' ');
        if (b(xVar, type)) {
            sb.append(xVar.i());
        } else {
            sb.append(c(xVar.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(x xVar, Proxy.Type type) {
        if (xVar.f() || type != Proxy.Type.HTTP) {
            return false;
        }
        return true;
    }

    public static String c(C2470r rVar) {
        String g4 = rVar.g();
        String i4 = rVar.i();
        if (i4 == null) {
            return g4;
        }
        return g4 + '?' + i4;
    }
}
