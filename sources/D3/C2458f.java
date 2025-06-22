package D3;

import E3.c;
import M3.C2502c;
import N3.C2517h;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: D3.f  reason: case insensitive filesystem */
public final class C2458f {

    /* renamed from: c  reason: collision with root package name */
    public static final C2458f f22939c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set f22940a;

    /* renamed from: b  reason: collision with root package name */
    private final C2502c f22941b;

    /* renamed from: D3.f$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f22942a = new ArrayList();

        public C2458f a() {
            return new C2458f(new LinkedHashSet(this.f22942a), (C2502c) null);
        }
    }

    C2458f(Set set, C2502c cVar) {
        this.f22940a = set;
        this.f22941b = cVar;
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + d((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static C2517h d(X509Certificate x509Certificate) {
        return C2517h.w(x509Certificate.getPublicKey().getEncoded()).F();
    }

    public void a(String str, List list) {
        List b5 = b(str);
        if (!b5.isEmpty()) {
            C2502c cVar = this.f22941b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i4);
                if (b5.size() <= 0) {
                    i4++;
                } else {
                    android.support.v4.media.a.a(b5.get(0));
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i5 = 0; i5 < size2; i5++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i5);
                sb.append("\n    ");
                sb.append(c(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size3 = b5.size();
            for (int i6 = 0; i6 < size3; i6++) {
                android.support.v4.media.a.a(b5.get(i6));
                sb.append("\n    ");
                sb.append((Object) null);
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public List b(String str) {
        List list = Collections.EMPTY_LIST;
        Iterator it = this.f22940a.iterator();
        if (!it.hasNext()) {
            return list;
        }
        android.support.v4.media.a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: package-private */
    public C2458f e(C2502c cVar) {
        if (c.n(this.f22941b, cVar)) {
            return this;
        }
        return new C2458f(this.f22940a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2458f)) {
            return false;
        }
        C2458f fVar = (C2458f) obj;
        if (!c.n(this.f22941b, fVar.f22941b) || !this.f22940a.equals(fVar.f22940a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i4;
        C2502c cVar = this.f22941b;
        if (cVar != null) {
            i4 = cVar.hashCode();
        } else {
            i4 = 0;
        }
        return (i4 * 31) + this.f22940a.hashCode();
    }
}
