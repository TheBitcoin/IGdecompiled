package D3;

import D3.C2457e;
import D3.C2467o;
import D3.C2469q;
import D3.z;
import E3.C2476a;
import E3.c;
import F3.f;
import G3.d;
import G3.g;
import L3.C2499f;
import M3.C2502c;
import M3.C2503d;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: D3.u  reason: case insensitive filesystem */
public class C2473u implements Cloneable, C2457e.a {

    /* renamed from: B  reason: collision with root package name */
    static final List f23132B = c.r(C2474v.HTTP_2, C2474v.HTTP_1_1);

    /* renamed from: C  reason: collision with root package name */
    static final List f23133C = c.r(C2462j.f23067f, C2462j.f23069h);

    /* renamed from: A  reason: collision with root package name */
    final int f23134A;

    /* renamed from: a  reason: collision with root package name */
    final C2465m f23135a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f23136b;

    /* renamed from: c  reason: collision with root package name */
    final List f23137c;

    /* renamed from: d  reason: collision with root package name */
    final List f23138d;

    /* renamed from: e  reason: collision with root package name */
    final List f23139e;

    /* renamed from: f  reason: collision with root package name */
    final List f23140f;

    /* renamed from: g  reason: collision with root package name */
    final C2467o.c f23141g;

    /* renamed from: h  reason: collision with root package name */
    final ProxySelector f23142h;

    /* renamed from: i  reason: collision with root package name */
    final C2464l f23143i;

    /* renamed from: j  reason: collision with root package name */
    final C2455c f23144j;

    /* renamed from: k  reason: collision with root package name */
    final f f23145k;

    /* renamed from: l  reason: collision with root package name */
    final SocketFactory f23146l;

    /* renamed from: m  reason: collision with root package name */
    final SSLSocketFactory f23147m;

    /* renamed from: n  reason: collision with root package name */
    final C2502c f23148n;

    /* renamed from: o  reason: collision with root package name */
    final HostnameVerifier f23149o;

    /* renamed from: p  reason: collision with root package name */
    final C2458f f23150p;

    /* renamed from: q  reason: collision with root package name */
    final C2454b f23151q;

    /* renamed from: r  reason: collision with root package name */
    final C2454b f23152r;

    /* renamed from: s  reason: collision with root package name */
    final C2461i f23153s;

    /* renamed from: t  reason: collision with root package name */
    final C2466n f23154t;

    /* renamed from: u  reason: collision with root package name */
    final boolean f23155u;

    /* renamed from: v  reason: collision with root package name */
    final boolean f23156v;

    /* renamed from: w  reason: collision with root package name */
    final boolean f23157w;

    /* renamed from: x  reason: collision with root package name */
    final int f23158x;

    /* renamed from: y  reason: collision with root package name */
    final int f23159y;

    /* renamed from: z  reason: collision with root package name */
    final int f23160z;

    /* renamed from: D3.u$a */
    class a extends C2476a {
        a() {
        }

        public void a(C2469q.a aVar, String str) {
            aVar.b(str);
        }

        public void b(C2469q.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        public void c(C2462j jVar, SSLSocket sSLSocket, boolean z4) {
            jVar.a(sSLSocket, z4);
        }

        public int d(z.a aVar) {
            return aVar.f23230c;
        }

        public boolean e(C2461i iVar, G3.c cVar) {
            return iVar.b(cVar);
        }

        public Socket f(C2461i iVar, C2453a aVar, g gVar) {
            return iVar.c(aVar, gVar);
        }

        public boolean g(C2453a aVar, C2453a aVar2) {
            return aVar.d(aVar2);
        }

        public G3.c h(C2461i iVar, C2453a aVar, g gVar, C2451B b5) {
            return iVar.d(aVar, gVar, b5);
        }

        public void i(C2461i iVar, G3.c cVar) {
            iVar.f(cVar);
        }

        public d j(C2461i iVar) {
            return iVar.f23063e;
        }
    }

    /* renamed from: D3.u$b */
    public static final class b {

        /* renamed from: A  reason: collision with root package name */
        int f23161A;

        /* renamed from: a  reason: collision with root package name */
        C2465m f23162a = new C2465m();

        /* renamed from: b  reason: collision with root package name */
        Proxy f23163b;

        /* renamed from: c  reason: collision with root package name */
        List f23164c = C2473u.f23132B;

        /* renamed from: d  reason: collision with root package name */
        List f23165d = C2473u.f23133C;

        /* renamed from: e  reason: collision with root package name */
        final List f23166e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List f23167f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        C2467o.c f23168g = C2467o.k(C2467o.f23100a);

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f23169h = ProxySelector.getDefault();

        /* renamed from: i  reason: collision with root package name */
        C2464l f23170i = C2464l.f23091a;

        /* renamed from: j  reason: collision with root package name */
        C2455c f23171j;

        /* renamed from: k  reason: collision with root package name */
        f f23172k;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f23173l = SocketFactory.getDefault();

        /* renamed from: m  reason: collision with root package name */
        SSLSocketFactory f23174m;

        /* renamed from: n  reason: collision with root package name */
        C2502c f23175n;

        /* renamed from: o  reason: collision with root package name */
        HostnameVerifier f23176o = C2503d.f23635a;

        /* renamed from: p  reason: collision with root package name */
        C2458f f23177p = C2458f.f22939c;

        /* renamed from: q  reason: collision with root package name */
        C2454b f23178q;

        /* renamed from: r  reason: collision with root package name */
        C2454b f23179r;

        /* renamed from: s  reason: collision with root package name */
        C2461i f23180s;

        /* renamed from: t  reason: collision with root package name */
        C2466n f23181t;

        /* renamed from: u  reason: collision with root package name */
        boolean f23182u;

        /* renamed from: v  reason: collision with root package name */
        boolean f23183v;

        /* renamed from: w  reason: collision with root package name */
        boolean f23184w;

        /* renamed from: x  reason: collision with root package name */
        int f23185x;

        /* renamed from: y  reason: collision with root package name */
        int f23186y;

        /* renamed from: z  reason: collision with root package name */
        int f23187z;

        public b() {
            C2454b bVar = C2454b.f22881a;
            this.f23178q = bVar;
            this.f23179r = bVar;
            this.f23180s = new C2461i();
            this.f23181t = C2466n.f23099a;
            this.f23182u = true;
            this.f23183v = true;
            this.f23184w = true;
            this.f23185x = 10000;
            this.f23186y = 10000;
            this.f23187z = 10000;
            this.f23161A = 0;
        }

        public C2473u a() {
            return new C2473u(this);
        }

        public b b(C2455c cVar) {
            this.f23171j = cVar;
            this.f23172k = null;
            return this;
        }
    }

    static {
        C2476a.f23240a = new a();
    }

    C2473u(b bVar) {
        boolean z4;
        this.f23135a = bVar.f23162a;
        this.f23136b = bVar.f23163b;
        this.f23137c = bVar.f23164c;
        List list = bVar.f23165d;
        this.f23138d = list;
        this.f23139e = c.q(bVar.f23166e);
        this.f23140f = c.q(bVar.f23167f);
        this.f23141g = bVar.f23168g;
        this.f23142h = bVar.f23169h;
        this.f23143i = bVar.f23170i;
        this.f23144j = bVar.f23171j;
        this.f23145k = bVar.f23172k;
        this.f23146l = bVar.f23173l;
        Iterator it = list.iterator();
        loop0:
        while (true) {
            z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C2462j jVar = (C2462j) it.next();
                if (z4 || jVar.d()) {
                    z4 = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f23174m;
        if (sSLSocketFactory != null || !z4) {
            this.f23147m = sSLSocketFactory;
            this.f23148n = bVar.f23175n;
        } else {
            X509TrustManager E4 = E();
            this.f23147m = D(E4);
            this.f23148n = C2502c.b(E4);
        }
        this.f23149o = bVar.f23176o;
        this.f23150p = bVar.f23177p.e(this.f23148n);
        this.f23151q = bVar.f23178q;
        this.f23152r = bVar.f23179r;
        this.f23153s = bVar.f23180s;
        this.f23154t = bVar.f23181t;
        this.f23155u = bVar.f23182u;
        this.f23156v = bVar.f23183v;
        this.f23157w = bVar.f23184w;
        this.f23158x = bVar.f23185x;
        this.f23159y = bVar.f23186y;
        this.f23160z = bVar.f23187z;
        this.f23134A = bVar.f23161A;
        if (this.f23139e.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f23139e);
        } else if (this.f23140f.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f23140f);
        }
    }

    private SSLSocketFactory D(X509TrustManager x509TrustManager) {
        try {
            SSLContext k4 = C2499f.i().k();
            k4.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return k4.getSocketFactory();
        } catch (GeneralSecurityException e5) {
            throw c.a("No System TLS", e5);
        }
    }

    private X509TrustManager E() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e5) {
            throw c.a("No System TLS", e5);
        }
    }

    public boolean A() {
        return this.f23157w;
    }

    public SocketFactory B() {
        return this.f23146l;
    }

    public SSLSocketFactory C() {
        return this.f23147m;
    }

    public int F() {
        return this.f23160z;
    }

    public C2457e a(x xVar) {
        return C2475w.d(this, xVar, false);
    }

    public C2454b b() {
        return this.f23152r;
    }

    public C2455c c() {
        return this.f23144j;
    }

    public C2458f d() {
        return this.f23150p;
    }

    public int e() {
        return this.f23158x;
    }

    public C2461i f() {
        return this.f23153s;
    }

    public List g() {
        return this.f23138d;
    }

    public C2464l h() {
        return this.f23143i;
    }

    public C2465m i() {
        return this.f23135a;
    }

    public C2466n j() {
        return this.f23154t;
    }

    public C2467o.c k() {
        return this.f23141g;
    }

    public boolean l() {
        return this.f23156v;
    }

    public boolean m() {
        return this.f23155u;
    }

    public HostnameVerifier n() {
        return this.f23149o;
    }

    public List o() {
        return this.f23139e;
    }

    /* access modifiers changed from: package-private */
    public f p() {
        C2455c cVar = this.f23144j;
        if (cVar != null) {
            return cVar.f22882a;
        }
        return this.f23145k;
    }

    public List q() {
        return this.f23140f;
    }

    public int r() {
        return this.f23134A;
    }

    public List s() {
        return this.f23137c;
    }

    public Proxy t() {
        return this.f23136b;
    }

    public C2454b x() {
        return this.f23151q;
    }

    public ProxySelector y() {
        return this.f23142h;
    }

    public int z() {
        return this.f23159y;
    }
}
