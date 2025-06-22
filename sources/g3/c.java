package G3;

import D3.C2451B;
import D3.C2453a;
import D3.C2457e;
import D3.C2460h;
import D3.C2461i;
import D3.C2467o;
import D3.C2468p;
import D3.C2470r;
import D3.C2471s;
import D3.C2473u;
import D3.C2474v;
import D3.x;
import D3.z;
import E3.C2476a;
import E3.d;
import H3.C2484c;
import H3.e;
import I3.C2485a;
import J3.C2487b;
import J3.C2491f;
import J3.C2492g;
import J3.i;
import L3.C2499f;
import M3.C2503d;
import N3.C2515f;
import N3.C2516g;
import N3.L;
import N3.Z;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class c extends C2492g.h implements C2460h {

    /* renamed from: b  reason: collision with root package name */
    private final C2461i f23329b;

    /* renamed from: c  reason: collision with root package name */
    private final C2451B f23330c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f23331d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f23332e;

    /* renamed from: f  reason: collision with root package name */
    private C2468p f23333f;

    /* renamed from: g  reason: collision with root package name */
    private C2474v f23334g;

    /* renamed from: h  reason: collision with root package name */
    private C2492g f23335h;

    /* renamed from: i  reason: collision with root package name */
    private C2516g f23336i;

    /* renamed from: j  reason: collision with root package name */
    private C2515f f23337j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23338k;

    /* renamed from: l  reason: collision with root package name */
    public int f23339l;

    /* renamed from: m  reason: collision with root package name */
    public int f23340m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final List f23341n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public long f23342o = Long.MAX_VALUE;

    public c(C2461i iVar, C2451B b5) {
        this.f23329b = iVar;
        this.f23330c = b5;
    }

    private void d(int i4, int i5, C2457e eVar, C2467o oVar) {
        Socket socket;
        Proxy b5 = this.f23330c.b();
        C2453a a5 = this.f23330c.a();
        if (b5.type() == Proxy.Type.DIRECT || b5.type() == Proxy.Type.HTTP) {
            socket = a5.j().createSocket();
        } else {
            socket = new Socket(b5);
        }
        this.f23331d = socket;
        oVar.f(eVar, this.f23330c.d(), b5);
        this.f23331d.setSoTimeout(i5);
        try {
            C2499f.i().g(this.f23331d, this.f23330c.d(), i4);
            try {
                this.f23336i = L.d(L.m(this.f23331d));
                this.f23337j = L.c(L.i(this.f23331d));
            } catch (NullPointerException e5) {
                if ("throw with null exception".equals(e5.getMessage())) {
                    throw new IOException(e5);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f23330c.d());
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0124 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(G3.b r8) {
        /*
            r7 = this;
            D3.B r0 = r7.f23330c
            D3.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            java.net.Socket r3 = r7.f23331d     // Catch:{ AssertionError -> 0x0117 }
            D3.r r4 = r0.l()     // Catch:{ AssertionError -> 0x0117 }
            java.lang.String r4 = r4.k()     // Catch:{ AssertionError -> 0x0117 }
            D3.r r5 = r0.l()     // Catch:{ AssertionError -> 0x0117 }
            int r5 = r5.w()     // Catch:{ AssertionError -> 0x0117 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0117 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0117 }
            D3.j r8 = r8.a(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x004a
            L3.f r3 = L3.C2499f.i()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            D3.r r4 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = r4.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r0.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.f(r1, r4, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r2 = r1
            goto L_0x0125
        L_0x0046:
            r8 = move-exception
            r2 = r1
            goto L_0x0118
        L_0x004a:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r4 = r7.n(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r4 == 0) goto L_0x010d
            D3.p r4 = D3.C2468p.c(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            D3.r r6 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r6 = r6.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x00bb
            D3.f r3 = r0.a()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            D3.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r4.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.a(r0, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r8 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r8 == 0) goto L_0x008e
            L3.f r8 = L3.C2499f.i()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r2 = r8.l(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x008e:
            r7.f23332e = r1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            N3.Z r8 = N3.L.m(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            N3.g r8 = N3.L.d(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f23336i = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.net.Socket r8 = r7.f23332e     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            N3.X r8 = N3.L.i(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            N3.f r8 = N3.L.c(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f23337j = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f23333f = r4     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r2 == 0) goto L_0x00af
            D3.v r8 = D3.C2474v.a(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x00b1
        L_0x00af:
            D3.v r8 = D3.C2474v.HTTP_1_1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x00b1:
            r7.f23334g = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            L3.f r8 = L3.C2499f.i()
            r8.a(r1)
            return
        L_0x00bb:
            java.util.List r8 = r4.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            D3.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = D3.C2458f.c(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r8 = M3.C2503d.a(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r2     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x010d:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "a valid ssl session was not established"
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0115:
            r8 = move-exception
            goto L_0x0125
        L_0x0117:
            r8 = move-exception
        L_0x0118:
            boolean r0 = E3.c.w(r8)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0124
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0115 }
            r0.<init>(r8)     // Catch:{ all -> 0x0115 }
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x0124:
            throw r8     // Catch:{ all -> 0x0115 }
        L_0x0125:
            if (r2 == 0) goto L_0x012e
            L3.f r0 = L3.C2499f.i()
            r0.a(r2)
        L_0x012e:
            E3.c.e(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.e(G3.b):void");
    }

    private void f(int i4, int i5, int i6, C2457e eVar, C2467o oVar) {
        x h4 = h();
        C2470r i7 = h4.i();
        int i8 = 0;
        while (i8 < 21) {
            d(i4, i5, eVar, oVar);
            h4 = g(i5, i6, h4, i7);
            if (h4 != null) {
                E3.c.e(this.f23331d);
                this.f23331d = null;
                this.f23337j = null;
                this.f23336i = null;
                oVar.d(eVar, this.f23330c.d(), this.f23330c.b(), (C2474v) null);
                i8++;
            } else {
                return;
            }
        }
    }

    private x g(int i4, int i5, x xVar, C2470r rVar) {
        String str = "CONNECT " + E3.c.p(rVar, true) + " HTTP/1.1";
        while (true) {
            C2485a aVar = new C2485a((C2473u) null, (g) null, this.f23336i, this.f23337j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f23336i.timeout().g((long) i4, timeUnit);
            this.f23337j.timeout().g((long) i5, timeUnit);
            aVar.l(xVar.d(), str);
            aVar.finishRequest();
            z c5 = aVar.readResponseHeaders(false).o(xVar).c();
            long b5 = e.b(c5);
            if (b5 == -1) {
                b5 = 0;
            }
            Z h4 = aVar.h(b5);
            E3.c.y(h4, Integer.MAX_VALUE, timeUnit);
            h4.close();
            int i6 = c5.i();
            if (i6 != 200) {
                if (i6 == 407) {
                    x a5 = this.f23330c.a().h().a(this.f23330c, c5);
                    if (a5 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(c5.l("Connection"))) {
                        return a5;
                    } else {
                        xVar = a5;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c5.i());
                }
            } else if (this.f23336i.buffer().exhausted() && this.f23337j.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private x h() {
        return new x.a().g(this.f23330c.a().l()).c("Host", E3.c.p(this.f23330c.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c(Command.HTTP_HEADER_USER_AGENT, d.a()).a();
    }

    private void i(b bVar, int i4, C2457e eVar, C2467o oVar) {
        if (this.f23330c.a().k() == null) {
            this.f23334g = C2474v.HTTP_1_1;
            this.f23332e = this.f23331d;
            return;
        }
        oVar.u(eVar);
        e(bVar);
        oVar.t(eVar, this.f23333f);
        if (this.f23334g == C2474v.HTTP_2) {
            this.f23332e.setSoTimeout(0);
            C2492g a5 = new C2492g.C0282g(true).d(this.f23332e, this.f23330c.a().l().k(), this.f23336i, this.f23337j).b(this).c(i4).a();
            this.f23335h = a5;
            a5.G();
        }
    }

    private boolean n(SSLSession sSLSession) {
        if ("NONE".equals(sSLSession.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite())) {
            return false;
        }
        return true;
    }

    public void a(C2492g gVar) {
        synchronized (this.f23329b) {
            this.f23340m = gVar.r();
        }
    }

    public void b(i iVar) {
        iVar.d(C2487b.REFUSED_STREAM);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: G3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: D3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: G3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: G3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: D3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: G3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: D3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: G3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: D3.o} */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099 A[Catch:{ IOException -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r13, int r14, int r15, int r16, boolean r17, D3.C2457e r18, D3.C2467o r19) {
        /*
            r12 = this;
            D3.v r0 = r12.f23334g
            if (r0 != 0) goto L_0x012f
            D3.B r0 = r12.f23330c
            D3.a r0 = r0.a()
            java.util.List r0 = r0.b()
            G3.b r7 = new G3.b
            r7.<init>(r0)
            D3.B r1 = r12.f23330c
            D3.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x006e
            D3.j r1 = D3.C2462j.f23069h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0061
            D3.B r0 = r12.f23330c
            D3.a r0 = r0.a()
            D3.r r0 = r0.l()
            java.lang.String r0 = r0.k()
            L3.f r1 = L3.C2499f.i()
            boolean r1 = r1.n(r0)
            if (r1 == 0) goto L_0x0040
            goto L_0x006e
        L_0x0040:
            G3.e r13 = new G3.e
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "CLEARTEXT communication to "
            r15.append(r1)
            r15.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x0061:
            G3.e r13 = new G3.e
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "CLEARTEXT communication not enabled for client"
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x006e:
            r8 = 0
            r9 = r8
        L_0x0070:
            D3.B r0 = r12.f23330c     // Catch:{ IOException -> 0x00e8 }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00e8 }
            if (r0 == 0) goto L_0x0099
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r18
            r6 = r19
            r1.f(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0094 }
            r10 = r3
            r2 = r5
            r1 = r6
            java.net.Socket r0 = r12.f23331d     // Catch:{ IOException -> 0x008e }
            if (r0 != 0) goto L_0x008b
            goto L_0x00b6
        L_0x008b:
            r11 = r16
            goto L_0x00a2
        L_0x008e:
            r0 = move-exception
        L_0x008f:
            r11 = r16
        L_0x0091:
            r6 = r0
            goto L_0x00f1
        L_0x0094:
            r0 = move-exception
            r10 = r3
            r2 = r5
            r1 = r6
            goto L_0x008f
        L_0x0099:
            r10 = r14
            r2 = r18
            r1 = r19
            r12.d(r13, r14, r2, r1)     // Catch:{ IOException -> 0x008e }
            goto L_0x008b
        L_0x00a2:
            r12.i(r7, r11, r2, r1)     // Catch:{ IOException -> 0x00e6 }
            D3.B r0 = r12.f23330c     // Catch:{ IOException -> 0x00e6 }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00e6 }
            D3.B r3 = r12.f23330c     // Catch:{ IOException -> 0x00e6 }
            java.net.Proxy r3 = r3.b()     // Catch:{ IOException -> 0x00e6 }
            D3.v r4 = r12.f23334g     // Catch:{ IOException -> 0x00e6 }
            r1.d(r2, r0, r3, r4)     // Catch:{ IOException -> 0x00e6 }
        L_0x00b6:
            D3.B r13 = r12.f23330c
            boolean r13 = r13.c()
            if (r13 == 0) goto L_0x00d0
            java.net.Socket r13 = r12.f23331d
            if (r13 == 0) goto L_0x00c3
            goto L_0x00d0
        L_0x00c3:
            java.net.ProtocolException r13 = new java.net.ProtocolException
            java.lang.String r14 = "Too many tunnel connections attempted: 21"
            r13.<init>(r14)
            G3.e r14 = new G3.e
            r14.<init>(r13)
            throw r14
        L_0x00d0:
            J3.g r13 = r12.f23335h
            if (r13 == 0) goto L_0x00e5
            D3.i r13 = r12.f23329b
            monitor-enter(r13)
            J3.g r14 = r12.f23335h     // Catch:{ all -> 0x00e1 }
            int r14 = r14.r()     // Catch:{ all -> 0x00e1 }
            r12.f23340m = r14     // Catch:{ all -> 0x00e1 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            goto L_0x00e5
        L_0x00e1:
            r0 = move-exception
            r14 = r0
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            throw r14
        L_0x00e5:
            return
        L_0x00e6:
            r0 = move-exception
            goto L_0x0091
        L_0x00e8:
            r0 = move-exception
            r10 = r14
            r11 = r16
            r2 = r18
            r1 = r19
            goto L_0x0091
        L_0x00f1:
            java.net.Socket r0 = r12.f23332e
            E3.c.e(r0)
            java.net.Socket r0 = r12.f23331d
            E3.c.e(r0)
            r12.f23332e = r8
            r12.f23331d = r8
            r12.f23336i = r8
            r12.f23337j = r8
            r12.f23333f = r8
            r12.f23334g = r8
            r12.f23335h = r8
            D3.B r0 = r12.f23330c
            java.net.InetSocketAddress r3 = r0.d()
            D3.B r0 = r12.f23330c
            java.net.Proxy r4 = r0.b()
            r5 = 0
            r1.e(r2, r3, r4, r5, r6)
            if (r9 != 0) goto L_0x0121
            G3.e r9 = new G3.e
            r9.<init>(r6)
            goto L_0x0124
        L_0x0121:
            r9.a(r6)
        L_0x0124:
            if (r17 == 0) goto L_0x012e
            boolean r0 = r7.b(r6)
            if (r0 == 0) goto L_0x012e
            goto L_0x0070
        L_0x012e:
            throw r9
        L_0x012f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "already connected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.c.c(int, int, int, int, boolean, D3.e, D3.o):void");
    }

    public C2468p j() {
        return this.f23333f;
    }

    public boolean k(C2453a aVar, C2451B b5) {
        Proxy.Type type;
        if (this.f23341n.size() >= this.f23340m || this.f23338k || !C2476a.f23240a.g(this.f23330c.a(), aVar)) {
            return false;
        }
        if (aVar.l().k().equals(p().a().l().k())) {
            return true;
        }
        if (this.f23335h == null || b5 == null || b5.b().type() != (type = Proxy.Type.DIRECT) || this.f23330c.b().type() != type || !this.f23330c.d().equals(b5.d()) || b5.a().e() != C2503d.f23635a || !r(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().k(), j().e());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean l(boolean z4) {
        int soTimeout;
        if (this.f23332e.isClosed() || this.f23332e.isInputShutdown() || this.f23332e.isOutputShutdown()) {
            return false;
        }
        C2492g gVar = this.f23335h;
        if (gVar != null) {
            return !gVar.p();
        }
        if (z4) {
            try {
                soTimeout = this.f23332e.getSoTimeout();
                this.f23332e.setSoTimeout(1);
                if (this.f23336i.exhausted()) {
                    this.f23332e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f23332e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f23332e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean m() {
        if (this.f23335h != null) {
            return true;
        }
        return false;
    }

    public C2484c o(C2473u uVar, C2471s.a aVar, g gVar) {
        if (this.f23335h != null) {
            return new C2491f(uVar, aVar, gVar, this.f23335h);
        }
        this.f23332e.setSoTimeout(aVar.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f23336i.timeout().g((long) aVar.readTimeoutMillis(), timeUnit);
        this.f23337j.timeout().g((long) aVar.writeTimeoutMillis(), timeUnit);
        return new C2485a(uVar, gVar, this.f23336i, this.f23337j);
    }

    public C2451B p() {
        return this.f23330c;
    }

    public Socket q() {
        return this.f23332e;
    }

    public boolean r(C2470r rVar) {
        if (rVar.w() != this.f23330c.a().l().w()) {
            return false;
        }
        if (rVar.k().equals(this.f23330c.a().l().k())) {
            return true;
        }
        if (this.f23333f == null || !C2503d.f23635a.c(rVar.k(), (X509Certificate) this.f23333f.e().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f23330c.a().l().k());
        sb.append(":");
        sb.append(this.f23330c.a().l().w());
        sb.append(", proxy=");
        sb.append(this.f23330c.b());
        sb.append(" hostAddress=");
        sb.append(this.f23330c.d());
        sb.append(" cipherSuite=");
        C2468p pVar = this.f23333f;
        if (pVar != null) {
            obj = pVar.a();
        } else {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f23334g);
        sb.append('}');
        return sb.toString();
    }
}
