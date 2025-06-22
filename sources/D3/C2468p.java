package D3;

import E3.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: D3.p  reason: case insensitive filesystem */
public final class C2468p {

    /* renamed from: a  reason: collision with root package name */
    private final C2452C f23102a;

    /* renamed from: b  reason: collision with root package name */
    private final C2459g f23103b;

    /* renamed from: c  reason: collision with root package name */
    private final List f23104c;

    /* renamed from: d  reason: collision with root package name */
    private final List f23105d;

    private C2468p(C2452C c5, C2459g gVar, List list, List list2) {
        this.f23102a = c5;
        this.f23103b = gVar;
        this.f23104c = list;
        this.f23105d = list2;
    }

    public static C2468p b(C2452C c5, C2459g gVar, List list, List list2) {
        if (c5 == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (gVar != null) {
            return new C2468p(c5, gVar, c.q(list), c.q(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public static C2468p c(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            C2459g a5 = C2459g.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                C2452C a6 = C2452C.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = c.r(certificateArr);
                } else {
                    list = Collections.EMPTY_LIST;
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = c.r(localCertificates);
                } else {
                    list2 = Collections.EMPTY_LIST;
                }
                return new C2468p(a6, a5, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public C2459g a() {
        return this.f23103b;
    }

    public List d() {
        return this.f23105d;
    }

    public List e() {
        return this.f23104c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2468p)) {
            return false;
        }
        C2468p pVar = (C2468p) obj;
        if (!this.f23102a.equals(pVar.f23102a) || !this.f23103b.equals(pVar.f23103b) || !this.f23104c.equals(pVar.f23104c) || !this.f23105d.equals(pVar.f23105d)) {
            return false;
        }
        return true;
    }

    public C2452C f() {
        return this.f23102a;
    }

    public int hashCode() {
        return ((((((527 + this.f23102a.hashCode()) * 31) + this.f23103b.hashCode()) * 31) + this.f23104c.hashCode()) * 31) + this.f23105d.hashCode();
    }
}
