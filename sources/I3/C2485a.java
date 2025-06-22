package I3;

import D3.C2450A;
import D3.C2469q;
import D3.C2470r;
import D3.C2473u;
import D3.x;
import D3.z;
import E3.C2476a;
import H3.C2484c;
import H3.h;
import H3.i;
import H3.k;
import N3.C2514e;
import N3.C2515f;
import N3.C2516g;
import N3.C2523n;
import N3.L;
import N3.X;
import N3.Z;
import N3.a0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* renamed from: I3.a  reason: case insensitive filesystem */
public final class C2485a implements C2484c {

    /* renamed from: a  reason: collision with root package name */
    final C2473u f23401a;

    /* renamed from: b  reason: collision with root package name */
    final G3.g f23402b;

    /* renamed from: c  reason: collision with root package name */
    final C2516g f23403c;

    /* renamed from: d  reason: collision with root package name */
    final C2515f f23404d;

    /* renamed from: e  reason: collision with root package name */
    int f23405e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f23406f = 262144;

    /* renamed from: I3.a$b */
    private abstract class b implements Z {

        /* renamed from: a  reason: collision with root package name */
        protected final C2523n f23407a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f23408b;

        /* renamed from: c  reason: collision with root package name */
        protected long f23409c;

        private b() {
            this.f23407a = new C2523n(C2485a.this.f23403c.timeout());
            this.f23409c = 0;
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z4, IOException iOException) {
            C2485a aVar = C2485a.this;
            int i4 = aVar.f23405e;
            if (i4 != 6) {
                if (i4 == 5) {
                    aVar.d(this.f23407a);
                    C2485a aVar2 = C2485a.this;
                    aVar2.f23405e = 6;
                    G3.g gVar = aVar2.f23402b;
                    if (gVar != null) {
                        gVar.q(!z4, aVar2, this.f23409c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + C2485a.this.f23405e);
            }
        }

        public long e(C2514e eVar, long j4) {
            try {
                long e5 = C2485a.this.f23403c.e(eVar, j4);
                if (e5 <= 0) {
                    return e5;
                }
                this.f23409c += e5;
                return e5;
            } catch (IOException e6) {
                a(false, e6);
                throw e6;
            }
        }

        public a0 timeout() {
            return this.f23407a;
        }
    }

    /* renamed from: I3.a$c */
    private final class c implements X, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2523n f23411a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23412b;

        c() {
            this.f23411a = new C2523n(C2485a.this.f23404d.timeout());
        }

        public synchronized void close() {
            if (!this.f23412b) {
                this.f23412b = true;
                C2485a.this.f23404d.writeUtf8("0\r\n\r\n");
                C2485a.this.d(this.f23411a);
                C2485a.this.f23405e = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f23412b) {
                C2485a.this.f23404d.flush();
            }
        }

        public void m(C2514e eVar, long j4) {
            if (this.f23412b) {
                throw new IllegalStateException("closed");
            } else if (j4 != 0) {
                C2485a.this.f23404d.writeHexadecimalUnsignedLong(j4);
                C2485a.this.f23404d.writeUtf8("\r\n");
                C2485a.this.f23404d.m(eVar, j4);
                C2485a.this.f23404d.writeUtf8("\r\n");
            }
        }

        public a0 timeout() {
            return this.f23411a;
        }
    }

    /* renamed from: I3.a$d */
    private class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final C2470r f23414e;

        /* renamed from: f  reason: collision with root package name */
        private long f23415f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f23416g = true;

        d(C2470r rVar) {
            super();
            this.f23414e = rVar;
        }

        private void d() {
            if (this.f23415f != -1) {
                C2485a.this.f23403c.readUtf8LineStrict();
            }
            try {
                this.f23415f = C2485a.this.f23403c.readHexadecimalUnsignedLong();
                String trim = C2485a.this.f23403c.readUtf8LineStrict().trim();
                if (this.f23415f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f23415f + trim + "\"");
                } else if (this.f23415f == 0) {
                    this.f23416g = false;
                    H3.e.g(C2485a.this.f23401a.h(), this.f23414e, C2485a.this.k());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e5) {
                throw new ProtocolException(e5.getMessage());
            }
        }

        public void close() {
            if (!this.f23408b) {
                if (this.f23416g && !E3.c.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f23408b = true;
            }
        }

        public long e(C2514e eVar, long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j4);
            } else if (this.f23408b) {
                throw new IllegalStateException("closed");
            } else if (!this.f23416g) {
                return -1;
            } else {
                long j5 = this.f23415f;
                if (j5 == 0 || j5 == -1) {
                    d();
                    if (!this.f23416g) {
                        return -1;
                    }
                }
                long e5 = super.e(eVar, Math.min(j4, this.f23415f));
                if (e5 != -1) {
                    this.f23415f -= e5;
                    return e5;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }
    }

    /* renamed from: I3.a$e */
    private final class e implements X, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2523n f23418a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23419b;

        /* renamed from: c  reason: collision with root package name */
        private long f23420c;

        e(long j4) {
            this.f23418a = new C2523n(C2485a.this.f23404d.timeout());
            this.f23420c = j4;
        }

        public void close() {
            if (!this.f23419b) {
                this.f23419b = true;
                if (this.f23420c <= 0) {
                    C2485a.this.d(this.f23418a);
                    C2485a.this.f23405e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.f23419b) {
                C2485a.this.f23404d.flush();
            }
        }

        public void m(C2514e eVar, long j4) {
            if (!this.f23419b) {
                long j5 = j4;
                E3.c.c(eVar.A(), 0, j5);
                if (j5 <= this.f23420c) {
                    C2485a.this.f23404d.m(eVar, j5);
                    this.f23420c -= j5;
                    return;
                }
                throw new ProtocolException("expected " + this.f23420c + " bytes but received " + j5);
            }
            throw new IllegalStateException("closed");
        }

        public a0 timeout() {
            return this.f23418a;
        }
    }

    /* renamed from: I3.a$f */
    private class f extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f23422e;

        f(long j4) {
            super();
            this.f23422e = j4;
            if (j4 == 0) {
                a(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.f23408b) {
                if (this.f23422e != 0 && !E3.c.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f23408b = true;
            }
        }

        public long e(C2514e eVar, long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j4);
            } else if (!this.f23408b) {
                long j5 = this.f23422e;
                if (j5 == 0) {
                    return -1;
                }
                long e5 = super.e(eVar, Math.min(j5, j4));
                if (e5 != -1) {
                    long j6 = this.f23422e - e5;
                    this.f23422e = j6;
                    if (j6 == 0) {
                        a(true, (IOException) null);
                    }
                    return e5;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* renamed from: I3.a$g */
    private class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f23424e;

        g() {
            super();
        }

        public void close() {
            if (!this.f23408b) {
                if (!this.f23424e) {
                    a(false, (IOException) null);
                }
                this.f23408b = true;
            }
        }

        public long e(C2514e eVar, long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j4);
            } else if (this.f23408b) {
                throw new IllegalStateException("closed");
            } else if (this.f23424e) {
                return -1;
            } else {
                long e5 = super.e(eVar, j4);
                if (e5 != -1) {
                    return e5;
                }
                this.f23424e = true;
                a(true, (IOException) null);
                return -1;
            }
        }
    }

    public C2485a(C2473u uVar, G3.g gVar, C2516g gVar2, C2515f fVar) {
        this.f23401a = uVar;
        this.f23402b = gVar;
        this.f23403c = gVar2;
        this.f23404d = fVar;
    }

    private String j() {
        String readUtf8LineStrict = this.f23403c.readUtf8LineStrict(this.f23406f);
        this.f23406f -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public C2450A a(z zVar) {
        G3.g gVar = this.f23402b;
        gVar.f23361f.q(gVar.f23360e);
        String l4 = zVar.l("Content-Type");
        if (!H3.e.c(zVar)) {
            return new h(l4, 0, L.d(h(0)));
        }
        if ("chunked".equalsIgnoreCase(zVar.l("Transfer-Encoding"))) {
            return new h(l4, -1, L.d(f(zVar.A().i())));
        }
        long b5 = H3.e.b(zVar);
        if (b5 != -1) {
            return new h(l4, b5, L.d(h(b5)));
        }
        return new h(l4, -1, L.d(i()));
    }

    public X b(x xVar, long j4) {
        if ("chunked".equalsIgnoreCase(xVar.c("Transfer-Encoding"))) {
            return e();
        }
        if (j4 != -1) {
            return g(j4);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void c(x xVar) {
        l(xVar.d(), i.a(xVar, this.f23402b.c().p().b().type()));
    }

    /* access modifiers changed from: package-private */
    public void d(C2523n nVar) {
        a0 i4 = nVar.i();
        nVar.j(a0.f23669e);
        i4.a();
        i4.b();
    }

    public X e() {
        if (this.f23405e == 1) {
            this.f23405e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public Z f(C2470r rVar) {
        if (this.f23405e == 4) {
            this.f23405e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public void finishRequest() {
        this.f23404d.flush();
    }

    public void flushRequest() {
        this.f23404d.flush();
    }

    public X g(long j4) {
        if (this.f23405e == 1) {
            this.f23405e = 2;
            return new e(j4);
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public Z h(long j4) {
        if (this.f23405e == 4) {
            this.f23405e = 5;
            return new f(j4);
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public Z i() {
        if (this.f23405e == 4) {
            G3.g gVar = this.f23402b;
            if (gVar != null) {
                this.f23405e = 5;
                gVar.i();
                return new g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public C2469q k() {
        C2469q.a aVar = new C2469q.a();
        while (true) {
            String j4 = j();
            if (j4.length() == 0) {
                return aVar.d();
            }
            C2476a.f23240a.a(aVar, j4);
        }
    }

    public void l(C2469q qVar, String str) {
        if (this.f23405e == 0) {
            this.f23404d.writeUtf8(str).writeUtf8("\r\n");
            int e5 = qVar.e();
            for (int i4 = 0; i4 < e5; i4++) {
                this.f23404d.writeUtf8(qVar.c(i4)).writeUtf8(": ").writeUtf8(qVar.f(i4)).writeUtf8("\r\n");
            }
            this.f23404d.writeUtf8("\r\n");
            this.f23405e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f23405e);
    }

    public z.a readResponseHeaders(boolean z4) {
        int i4 = this.f23405e;
        if (i4 == 1 || i4 == 3) {
            try {
                k a5 = k.a(j());
                z.a i5 = new z.a().m(a5.f23398a).g(a5.f23399b).j(a5.f23400c).i(k());
                if (z4 && a5.f23399b == 100) {
                    return null;
                }
                if (a5.f23399b == 100) {
                    this.f23405e = 3;
                    return i5;
                }
                this.f23405e = 4;
                return i5;
            } catch (EOFException e5) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f23402b);
                iOException.initCause(e5);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f23405e);
        }
    }
}
