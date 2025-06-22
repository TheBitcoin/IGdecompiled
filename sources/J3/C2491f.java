package J3;

import D3.C2450A;
import D3.C2469q;
import D3.C2471s;
import D3.C2473u;
import D3.C2474v;
import D3.x;
import D3.z;
import E3.C2476a;
import E3.c;
import G3.g;
import H3.C2484c;
import H3.e;
import H3.h;
import H3.i;
import H3.k;
import N3.C2514e;
import N3.C2517h;
import N3.C2522m;
import N3.L;
import N3.X;
import N3.Z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: J3.f  reason: case insensitive filesystem */
public final class C2491f implements C2484c {

    /* renamed from: f  reason: collision with root package name */
    private static final C2517h f23472f;

    /* renamed from: g  reason: collision with root package name */
    private static final C2517h f23473g;

    /* renamed from: h  reason: collision with root package name */
    private static final C2517h f23474h;

    /* renamed from: i  reason: collision with root package name */
    private static final C2517h f23475i;

    /* renamed from: j  reason: collision with root package name */
    private static final C2517h f23476j;

    /* renamed from: k  reason: collision with root package name */
    private static final C2517h f23477k;

    /* renamed from: l  reason: collision with root package name */
    private static final C2517h f23478l;

    /* renamed from: m  reason: collision with root package name */
    private static final C2517h f23479m;

    /* renamed from: n  reason: collision with root package name */
    private static final List f23480n;

    /* renamed from: o  reason: collision with root package name */
    private static final List f23481o;

    /* renamed from: a  reason: collision with root package name */
    private final C2473u f23482a;

    /* renamed from: b  reason: collision with root package name */
    private final C2471s.a f23483b;

    /* renamed from: c  reason: collision with root package name */
    final g f23484c;

    /* renamed from: d  reason: collision with root package name */
    private final C2492g f23485d;

    /* renamed from: e  reason: collision with root package name */
    private i f23486e;

    /* renamed from: J3.f$a */
    class a extends C2522m {

        /* renamed from: b  reason: collision with root package name */
        boolean f23487b = false;

        /* renamed from: c  reason: collision with root package name */
        long f23488c = 0;

        a(Z z4) {
            super(z4);
        }

        private void d(IOException iOException) {
            if (!this.f23487b) {
                this.f23487b = true;
                C2491f fVar = C2491f.this;
                fVar.f23484c.q(false, fVar, this.f23488c, iOException);
            }
        }

        public void close() {
            super.close();
            d((IOException) null);
        }

        public long e(C2514e eVar, long j4) {
            try {
                long e5 = a().e(eVar, j4);
                if (e5 <= 0) {
                    return e5;
                }
                this.f23488c += e5;
                return e5;
            } catch (IOException e6) {
                d(e6);
                throw e6;
            }
        }
    }

    static {
        C2517h f4 = C2517h.f("connection");
        f23472f = f4;
        C2517h f5 = C2517h.f("host");
        f23473g = f5;
        C2517h f6 = C2517h.f("keep-alive");
        f23474h = f6;
        C2517h f7 = C2517h.f("proxy-connection");
        f23475i = f7;
        C2517h f8 = C2517h.f("transfer-encoding");
        f23476j = f8;
        C2517h f9 = C2517h.f("te");
        f23477k = f9;
        C2517h f10 = C2517h.f("encoding");
        f23478l = f10;
        C2517h f11 = C2517h.f("upgrade");
        f23479m = f11;
        f23480n = c.r(f4, f5, f6, f7, f9, f8, f10, f11, C2488c.f23441f, C2488c.f23442g, C2488c.f23443h, C2488c.f23444i);
        f23481o = c.r(f4, f5, f6, f7, f9, f8, f10, f11);
    }

    public C2491f(C2473u uVar, C2471s.a aVar, g gVar, C2492g gVar2) {
        this.f23482a = uVar;
        this.f23483b = aVar;
        this.f23484c = gVar;
        this.f23485d = gVar2;
    }

    public static List d(x xVar) {
        C2469q d5 = xVar.d();
        ArrayList arrayList = new ArrayList(d5.e() + 4);
        arrayList.add(new C2488c(C2488c.f23441f, xVar.g()));
        arrayList.add(new C2488c(C2488c.f23442g, i.c(xVar.i())));
        String c5 = xVar.c("Host");
        if (c5 != null) {
            arrayList.add(new C2488c(C2488c.f23444i, c5));
        }
        arrayList.add(new C2488c(C2488c.f23443h, xVar.i().A()));
        int e5 = d5.e();
        for (int i4 = 0; i4 < e5; i4++) {
            C2517h f4 = C2517h.f(d5.c(i4).toLowerCase(Locale.US));
            if (!f23480n.contains(f4)) {
                arrayList.add(new C2488c(f4, d5.f(i4)));
            }
        }
        return arrayList;
    }

    public static z.a e(List list) {
        C2469q.a aVar = new C2469q.a();
        int size = list.size();
        k kVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            C2488c cVar = (C2488c) list.get(i4);
            if (cVar != null) {
                C2517h hVar = cVar.f23445a;
                String M4 = cVar.f23446b.M();
                if (hVar.equals(C2488c.f23440e)) {
                    kVar = k.a("HTTP/1.1 " + M4);
                } else if (!f23481o.contains(hVar)) {
                    C2476a.f23240a.b(aVar, hVar.M(), M4);
                }
            } else if (kVar != null && kVar.f23399b == 100) {
                aVar = new C2469q.a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new z.a().m(C2474v.HTTP_2).g(kVar.f23399b).j(kVar.f23400c).i(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public C2450A a(z zVar) {
        g gVar = this.f23484c;
        gVar.f23361f.q(gVar.f23360e);
        return new h(zVar.l("Content-Type"), e.b(zVar), L.d(new a(this.f23486e.i())));
    }

    public X b(x xVar, long j4) {
        return this.f23486e.h();
    }

    public void c(x xVar) {
        boolean z4;
        if (this.f23486e == null) {
            if (xVar.a() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            i v4 = this.f23485d.v(d(xVar), z4);
            this.f23486e = v4;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            v4.l().g((long) this.f23483b.readTimeoutMillis(), timeUnit);
            this.f23486e.s().g((long) this.f23483b.writeTimeoutMillis(), timeUnit);
        }
    }

    public void finishRequest() {
        this.f23486e.h().close();
    }

    public void flushRequest() {
        this.f23485d.flush();
    }

    public z.a readResponseHeaders(boolean z4) {
        z.a e5 = e(this.f23486e.q());
        if (!z4 || C2476a.f23240a.d(e5) != 100) {
            return e5;
        }
        return null;
    }
}
