package L3;

import D3.C2473u;
import D3.C2474v;
import M3.C2500a;
import M3.C2501b;
import M3.C2502c;
import M3.C2504e;
import N3.C2514e;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: L3.f  reason: case insensitive filesystem */
public class C2499f {

    /* renamed from: a  reason: collision with root package name */
    private static final C2499f f23631a = h();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f23632b = Logger.getLogger(C2473u.class.getName());

    public static List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            C2474v vVar = (C2474v) list.get(i4);
            if (vVar != C2474v.HTTP_1_0) {
                arrayList.add(vVar.toString());
            }
        }
        return arrayList;
    }

    static byte[] e(List list) {
        C2514e eVar = new C2514e();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            C2474v vVar = (C2474v) list.get(i4);
            if (vVar != C2474v.HTTP_1_0) {
                eVar.writeByte(vVar.toString().length());
                eVar.writeUtf8(vVar.toString());
            }
        }
        return eVar.readByteArray();
    }

    private static C2499f h() {
        C2499f r4;
        C2499f t4 = C2494a.t();
        if (t4 != null) {
            return t4;
        }
        if (o() && (r4 = C2495b.r()) != null) {
            return r4;
        }
        C2496c r5 = C2496c.r();
        if (r5 != null) {
            return r5;
        }
        C2499f r6 = C2497d.r();
        if (r6 != null) {
            return r6;
        }
        return new C2499f();
    }

    public static C2499f i() {
        return f23631a;
    }

    public static boolean o() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public C2502c c(X509TrustManager x509TrustManager) {
        return new C2500a(d(x509TrustManager));
    }

    public C2504e d(X509TrustManager x509TrustManager) {
        return new C2501b(x509TrustManager.getAcceptedIssuers());
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        socket.connect(inetSocketAddress, i4);
    }

    public String j() {
        return "OkHttp";
    }

    public SSLContext k() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException("No TLS provider", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        return null;
    }

    public Object m(String str) {
        if (f23632b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean n(String str) {
        return true;
    }

    public void p(int i4, String str, Throwable th) {
        Level level;
        if (i4 == 5) {
            level = Level.WARNING;
        } else {
            level = Level.INFO;
        }
        f23632b.log(level, str, th);
    }

    public void q(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        p(5, str, (Throwable) obj);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
    }
}
