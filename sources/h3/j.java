package H3;

import D3.C2450A;
import D3.C2451B;
import D3.C2453a;
import D3.C2457e;
import D3.C2458f;
import D3.C2467o;
import D3.C2470r;
import D3.C2471s;
import D3.C2473u;
import D3.x;
import D3.y;
import D3.z;
import G3.c;
import G3.e;
import G3.g;
import J3.C2486a;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j implements C2471s {

    /* renamed from: a  reason: collision with root package name */
    private final C2473u f23393a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23394b;

    /* renamed from: c  reason: collision with root package name */
    private volatile g f23395c;

    /* renamed from: d  reason: collision with root package name */
    private Object f23396d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f23397e;

    public j(C2473u uVar, boolean z4) {
        this.f23393a = uVar;
        this.f23394b = z4;
    }

    private C2453a b(C2470r rVar) {
        C2458f fVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (rVar.l()) {
            sSLSocketFactory = this.f23393a.C();
            hostnameVerifier = this.f23393a.n();
            fVar = this.f23393a.d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        return new C2453a(rVar.k(), rVar.w(), this.f23393a.j(), this.f23393a.B(), sSLSocketFactory, hostnameVerifier, fVar, this.f23393a.x(), this.f23393a.t(), this.f23393a.s(), this.f23393a.g(), this.f23393a.y());
    }

    private x c(z zVar, C2451B b5) {
        String l4;
        C2470r z4;
        Proxy proxy;
        if (zVar != null) {
            int i4 = zVar.i();
            String g4 = zVar.A().g();
            y yVar = null;
            if (i4 == 307 || i4 == 308) {
                if (!g4.equals(ShareTarget.METHOD_GET) && !g4.equals("HEAD")) {
                    return null;
                }
            } else if (i4 == 401) {
                return this.f23393a.b().a(b5, zVar);
            } else {
                if (i4 != 503) {
                    if (i4 == 407) {
                        if (b5 != null) {
                            proxy = b5.b();
                        } else {
                            proxy = this.f23393a.t();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f23393a.x().a(b5, zVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (i4 != 408) {
                        switch (i4) {
                            case MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f23393a.A()) {
                        return null;
                    } else {
                        zVar.A().a();
                        if ((zVar.w() == null || zVar.w().i() != 408) && f(zVar, 0) <= 0) {
                            return zVar.A();
                        }
                        return null;
                    }
                } else if ((zVar.w() == null || zVar.w().i() != 503) && f(zVar, Integer.MAX_VALUE) == 0) {
                    return zVar.A();
                } else {
                    return null;
                }
            }
            if (!this.f23393a.l() || (l4 = zVar.l("Location")) == null || (z4 = zVar.A().i().z(l4)) == null) {
                return null;
            }
            if (!z4.A().equals(zVar.A().i().A()) && !this.f23393a.m()) {
                return null;
            }
            x.a h4 = zVar.A().h();
            if (f.b(g4)) {
                boolean d5 = f.d(g4);
                if (f.c(g4)) {
                    h4.e(ShareTarget.METHOD_GET, (y) null);
                } else {
                    if (d5) {
                        yVar = zVar.A().a();
                    }
                    h4.e(g4, yVar);
                }
                if (!d5) {
                    h4.f("Transfer-Encoding");
                    h4.f("Content-Length");
                    h4.f("Content-Type");
                }
            }
            if (!g(zVar, z4)) {
                h4.f("Authorization");
            }
            return h4.g(z4).a();
        }
        throw new IllegalStateException();
    }

    private boolean d(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z4) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean e(IOException iOException, g gVar, boolean z4, x xVar) {
        gVar.p(iOException);
        if (!this.f23393a.A()) {
            return false;
        }
        if (z4) {
            xVar.a();
        }
        if (d(iOException, z4) && gVar.g()) {
            return true;
        }
        return false;
    }

    private int f(z zVar, int i4) {
        String l4 = zVar.l("Retry-After");
        if (l4 == null) {
            return i4;
        }
        if (l4.matches("\\d+")) {
            return Integer.valueOf(l4).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean g(z zVar, C2470r rVar) {
        C2470r i4 = zVar.A().i();
        if (!i4.k().equals(rVar.k()) || i4.w() != rVar.w() || !i4.A().equals(rVar.A())) {
            return false;
        }
        return true;
    }

    public z a(C2471s.a aVar) {
        x request = aVar.request();
        g gVar = (g) aVar;
        C2457e b5 = gVar.b();
        C2467o d5 = gVar.d();
        g gVar2 = new g(this.f23393a.f(), b(request.i()), b5, d5, this.f23396d);
        this.f23395c = gVar2;
        g gVar3 = gVar2;
        z zVar = null;
        int i4 = 0;
        x xVar = request;
        while (!this.f23397e) {
            try {
                z f4 = gVar.f(xVar, gVar3, (C2484c) null, (c) null);
                if (zVar != null) {
                    f4 = f4.v().l(zVar.v().b((C2450A) null).c()).c();
                }
                x c5 = c(f4, gVar3.n());
                if (c5 == null) {
                    if (!this.f23394b) {
                        gVar3.j();
                    }
                    return f4;
                }
                E3.c.d(f4.a());
                int i5 = i4 + 1;
                if (i5 <= 20) {
                    c5.a();
                    if (!g(f4, c5.i())) {
                        gVar3.j();
                        g gVar4 = new g(this.f23393a.f(), b(c5.i()), b5, d5, this.f23396d);
                        this.f23395c = gVar4;
                        gVar3 = gVar4;
                    } else if (gVar3.b() != null) {
                        throw new IllegalStateException("Closing the body of " + f4 + " didn't close its backing stream. Bad interceptor?");
                    }
                    zVar = f4;
                    xVar = c5;
                    i4 = i5;
                } else {
                    gVar3.j();
                    throw new ProtocolException("Too many follow-up requests: " + i5);
                }
            } catch (e e5) {
                if (!e(e5.c(), gVar3, false, xVar)) {
                    throw e5.c();
                }
            } catch (IOException e6) {
                if (!e(e6, gVar3, !(e6 instanceof C2486a), xVar)) {
                    throw e6;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                gVar3.p((IOException) null);
                gVar3.j();
                throw th2;
            }
        }
        gVar3.j();
        throw new IOException("Canceled");
    }

    public void h(Object obj) {
        this.f23396d = obj;
    }
}
