package D3;

import D3.C2469q;
import java.io.Closeable;

public final class z implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    final x f23215a;

    /* renamed from: b  reason: collision with root package name */
    final C2474v f23216b;

    /* renamed from: c  reason: collision with root package name */
    final int f23217c;

    /* renamed from: d  reason: collision with root package name */
    final String f23218d;

    /* renamed from: e  reason: collision with root package name */
    final C2468p f23219e;

    /* renamed from: f  reason: collision with root package name */
    final C2469q f23220f;

    /* renamed from: g  reason: collision with root package name */
    final C2450A f23221g;

    /* renamed from: h  reason: collision with root package name */
    final z f23222h;

    /* renamed from: i  reason: collision with root package name */
    final z f23223i;

    /* renamed from: j  reason: collision with root package name */
    final z f23224j;

    /* renamed from: k  reason: collision with root package name */
    final long f23225k;

    /* renamed from: l  reason: collision with root package name */
    final long f23226l;

    /* renamed from: m  reason: collision with root package name */
    private volatile C2456d f23227m;

    z(a aVar) {
        this.f23215a = aVar.f23228a;
        this.f23216b = aVar.f23229b;
        this.f23217c = aVar.f23230c;
        this.f23218d = aVar.f23231d;
        this.f23219e = aVar.f23232e;
        this.f23220f = aVar.f23233f.d();
        this.f23221g = aVar.f23234g;
        this.f23222h = aVar.f23235h;
        this.f23223i = aVar.f23236i;
        this.f23224j = aVar.f23237j;
        this.f23225k = aVar.f23238k;
        this.f23226l = aVar.f23239l;
    }

    public x A() {
        return this.f23215a;
    }

    public long D() {
        return this.f23225k;
    }

    public C2450A a() {
        return this.f23221g;
    }

    public void close() {
        C2450A a5 = this.f23221g;
        if (a5 != null) {
            a5.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public C2456d d() {
        C2456d dVar = this.f23227m;
        if (dVar != null) {
            return dVar;
        }
        C2456d l4 = C2456d.l(this.f23220f);
        this.f23227m = l4;
        return l4;
    }

    public z g() {
        return this.f23223i;
    }

    public int i() {
        return this.f23217c;
    }

    public C2468p k() {
        return this.f23219e;
    }

    public String l(String str) {
        return n(str, (String) null);
    }

    public String n(String str, String str2) {
        String a5 = this.f23220f.a(str);
        if (a5 != null) {
            return a5;
        }
        return str2;
    }

    public C2469q o() {
        return this.f23220f;
    }

    public boolean p() {
        int i4 = this.f23217c;
        if (i4 < 200 || i4 >= 300) {
            return false;
        }
        return true;
    }

    public String r() {
        return this.f23218d;
    }

    public String toString() {
        return "Response{protocol=" + this.f23216b + ", code=" + this.f23217c + ", message=" + this.f23218d + ", url=" + this.f23215a.i() + '}';
    }

    public z u() {
        return this.f23222h;
    }

    public a v() {
        return new a(this);
    }

    public z w() {
        return this.f23224j;
    }

    public C2474v x() {
        return this.f23216b;
    }

    public long z() {
        return this.f23226l;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        x f23228a;

        /* renamed from: b  reason: collision with root package name */
        C2474v f23229b;

        /* renamed from: c  reason: collision with root package name */
        int f23230c;

        /* renamed from: d  reason: collision with root package name */
        String f23231d;

        /* renamed from: e  reason: collision with root package name */
        C2468p f23232e;

        /* renamed from: f  reason: collision with root package name */
        C2469q.a f23233f;

        /* renamed from: g  reason: collision with root package name */
        C2450A f23234g;

        /* renamed from: h  reason: collision with root package name */
        z f23235h;

        /* renamed from: i  reason: collision with root package name */
        z f23236i;

        /* renamed from: j  reason: collision with root package name */
        z f23237j;

        /* renamed from: k  reason: collision with root package name */
        long f23238k;

        /* renamed from: l  reason: collision with root package name */
        long f23239l;

        public a() {
            this.f23230c = -1;
            this.f23233f = new C2469q.a();
        }

        private void e(z zVar) {
            if (zVar.f23221g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, z zVar) {
            if (zVar.f23221g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (zVar.f23222h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (zVar.f23223i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (zVar.f23224j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a a(String str, String str2) {
            this.f23233f.a(str, str2);
            return this;
        }

        public a b(C2450A a5) {
            this.f23234g = a5;
            return this;
        }

        public z c() {
            if (this.f23228a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f23229b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f23230c < 0) {
                throw new IllegalStateException("code < 0: " + this.f23230c);
            } else if (this.f23231d != null) {
                return new z(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a d(z zVar) {
            if (zVar != null) {
                f("cacheResponse", zVar);
            }
            this.f23236i = zVar;
            return this;
        }

        public a g(int i4) {
            this.f23230c = i4;
            return this;
        }

        public a h(C2468p pVar) {
            this.f23232e = pVar;
            return this;
        }

        public a i(C2469q qVar) {
            this.f23233f = qVar.d();
            return this;
        }

        public a j(String str) {
            this.f23231d = str;
            return this;
        }

        public a k(z zVar) {
            if (zVar != null) {
                f("networkResponse", zVar);
            }
            this.f23235h = zVar;
            return this;
        }

        public a l(z zVar) {
            if (zVar != null) {
                e(zVar);
            }
            this.f23237j = zVar;
            return this;
        }

        public a m(C2474v vVar) {
            this.f23229b = vVar;
            return this;
        }

        public a n(long j4) {
            this.f23239l = j4;
            return this;
        }

        public a o(x xVar) {
            this.f23228a = xVar;
            return this;
        }

        public a p(long j4) {
            this.f23238k = j4;
            return this;
        }

        a(z zVar) {
            this.f23230c = -1;
            this.f23228a = zVar.f23215a;
            this.f23229b = zVar.f23216b;
            this.f23230c = zVar.f23217c;
            this.f23231d = zVar.f23218d;
            this.f23232e = zVar.f23219e;
            this.f23233f = zVar.f23220f.d();
            this.f23234g = zVar.f23221g;
            this.f23235h = zVar.f23222h;
            this.f23236i = zVar.f23223i;
            this.f23237j = zVar.f23224j;
            this.f23238k = zVar.f23225k;
            this.f23239l = zVar.f23226l;
        }
    }
}
