package D3;

import D3.C2470r;
import E3.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: D3.a  reason: case insensitive filesystem */
public final class C2453a {

    /* renamed from: a  reason: collision with root package name */
    final C2470r f22870a;

    /* renamed from: b  reason: collision with root package name */
    final C2466n f22871b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f22872c;

    /* renamed from: d  reason: collision with root package name */
    final C2454b f22873d;

    /* renamed from: e  reason: collision with root package name */
    final List f22874e;

    /* renamed from: f  reason: collision with root package name */
    final List f22875f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f22876g;

    /* renamed from: h  reason: collision with root package name */
    final Proxy f22877h;

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f22878i;

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f22879j;

    /* renamed from: k  reason: collision with root package name */
    final C2458f f22880k;

    public C2453a(String str, int i4, C2466n nVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C2458f fVar, C2454b bVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f22870a = new C2470r.a().p(sSLSocketFactory != null ? "https" : "http").e(str).k(i4).a();
        if (nVar != null) {
            this.f22871b = nVar;
            if (socketFactory != null) {
                this.f22872c = socketFactory;
                if (bVar != null) {
                    this.f22873d = bVar;
                    if (list != null) {
                        this.f22874e = c.q(list);
                        if (list2 != null) {
                            this.f22875f = c.q(list2);
                            if (proxySelector != null) {
                                this.f22876g = proxySelector;
                                this.f22877h = proxy;
                                this.f22878i = sSLSocketFactory;
                                this.f22879j = hostnameVerifier;
                                this.f22880k = fVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public C2458f a() {
        return this.f22880k;
    }

    public List b() {
        return this.f22875f;
    }

    public C2466n c() {
        return this.f22871b;
    }

    /* access modifiers changed from: package-private */
    public boolean d(C2453a aVar) {
        if (!this.f22871b.equals(aVar.f22871b) || !this.f22873d.equals(aVar.f22873d) || !this.f22874e.equals(aVar.f22874e) || !this.f22875f.equals(aVar.f22875f) || !this.f22876g.equals(aVar.f22876g) || !c.n(this.f22877h, aVar.f22877h) || !c.n(this.f22878i, aVar.f22878i) || !c.n(this.f22879j, aVar.f22879j) || !c.n(this.f22880k, aVar.f22880k) || l().w() != aVar.l().w()) {
            return false;
        }
        return true;
    }

    public HostnameVerifier e() {
        return this.f22879j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2453a)) {
            return false;
        }
        C2453a aVar = (C2453a) obj;
        if (!this.f22870a.equals(aVar.f22870a) || !d(aVar)) {
            return false;
        }
        return true;
    }

    public List f() {
        return this.f22874e;
    }

    public Proxy g() {
        return this.f22877h;
    }

    public C2454b h() {
        return this.f22873d;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int hashCode = (((((((((((527 + this.f22870a.hashCode()) * 31) + this.f22871b.hashCode()) * 31) + this.f22873d.hashCode()) * 31) + this.f22874e.hashCode()) * 31) + this.f22875f.hashCode()) * 31) + this.f22876g.hashCode()) * 31;
        Proxy proxy = this.f22877h;
        int i7 = 0;
        if (proxy != null) {
            i4 = proxy.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (hashCode + i4) * 31;
        SSLSocketFactory sSLSocketFactory = this.f22878i;
        if (sSLSocketFactory != null) {
            i5 = sSLSocketFactory.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (i8 + i5) * 31;
        HostnameVerifier hostnameVerifier = this.f22879j;
        if (hostnameVerifier != null) {
            i6 = hostnameVerifier.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (i9 + i6) * 31;
        C2458f fVar = this.f22880k;
        if (fVar != null) {
            i7 = fVar.hashCode();
        }
        return i10 + i7;
    }

    public ProxySelector i() {
        return this.f22876g;
    }

    public SocketFactory j() {
        return this.f22872c;
    }

    public SSLSocketFactory k() {
        return this.f22878i;
    }

    public C2470r l() {
        return this.f22870a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f22870a.k());
        sb.append(":");
        sb.append(this.f22870a.w());
        if (this.f22877h != null) {
            sb.append(", proxy=");
            sb.append(this.f22877h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f22876g);
        }
        sb.append("}");
        return sb.toString();
    }
}
