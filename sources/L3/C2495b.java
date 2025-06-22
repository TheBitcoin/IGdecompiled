package L3;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

/* renamed from: L3.b  reason: case insensitive filesystem */
public class C2495b extends C2499f {
    private C2495b() {
    }

    public static C2499f r() {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            Conscrypt.setUseEngineSocketByDefault(true);
            return new C2495b();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider s() {
        return new OpenSSLProvider();
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C2499f.b(list).toArray(new String[0]));
            return;
        }
        super.f(sSLSocket, str, list);
    }

    public SSLContext k() {
        try {
            return SSLContext.getInstance("TLS", s());
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException("No TLS provider", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.l(sSLSocket);
    }
}
