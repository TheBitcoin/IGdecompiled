package F3;

import D3.C2450A;
import D3.C2469q;
import D3.C2471s;
import D3.C2474v;
import D3.x;
import D3.z;
import E3.C2476a;
import E3.c;
import F3.C2480c;
import H3.e;
import H3.f;
import H3.h;
import N3.C2514e;
import N3.C2515f;
import N3.C2516g;
import N3.L;
import N3.X;
import N3.Z;
import N3.a0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: F3.a  reason: case insensitive filesystem */
public final class C2478a implements C2471s {

    /* renamed from: a  reason: collision with root package name */
    final f f23262a;

    /* renamed from: F3.a$a  reason: collision with other inner class name */
    class C0279a implements Z, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        boolean f23263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2516g f23264b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2479b f23265c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2515f f23266d;

        C0279a(C2516g gVar, C2479b bVar, C2515f fVar) {
            this.f23264b = gVar;
            this.f23265c = bVar;
            this.f23266d = fVar;
        }

        public void close() {
            if (!this.f23263a && !c.m(this, 100, TimeUnit.MILLISECONDS)) {
                this.f23263a = true;
                this.f23265c.abort();
            }
            this.f23264b.close();
        }

        public long e(C2514e eVar, long j4) {
            try {
                long e5 = this.f23264b.e(eVar, j4);
                if (e5 == -1) {
                    if (!this.f23263a) {
                        this.f23263a = true;
                        this.f23266d.close();
                    }
                    return -1;
                }
                eVar.k(this.f23266d.buffer(), eVar.A() - e5, e5);
                this.f23266d.emitCompleteSegments();
                return e5;
            } catch (IOException e6) {
                IOException iOException = e6;
                if (!this.f23263a) {
                    this.f23263a = true;
                    this.f23265c.abort();
                }
                throw iOException;
            }
        }

        public a0 timeout() {
            return this.f23264b.timeout();
        }
    }

    public C2478a(f fVar) {
        this.f23262a = fVar;
    }

    private z b(C2479b bVar, z zVar) {
        X body;
        if (bVar == null || (body = bVar.body()) == null) {
            return zVar;
        }
        C0279a aVar = new C0279a(zVar.a().i(), bVar, L.c(body));
        return zVar.v().b(new h(zVar.l("Content-Type"), zVar.a().a(), L.d(aVar))).c();
    }

    private static C2469q c(C2469q qVar, C2469q qVar2) {
        C2469q.a aVar = new C2469q.a();
        int e5 = qVar.e();
        for (int i4 = 0; i4 < e5; i4++) {
            String c5 = qVar.c(i4);
            String f4 = qVar.f(i4);
            if ((!"Warning".equalsIgnoreCase(c5) || !f4.startsWith("1")) && (d(c5) || !e(c5) || qVar2.a(c5) == null)) {
                C2476a.f23240a.b(aVar, c5, f4);
            }
        }
        int e6 = qVar2.e();
        for (int i5 = 0; i5 < e6; i5++) {
            String c6 = qVar2.c(i5);
            if (!d(c6) && e(c6)) {
                C2476a.f23240a.b(aVar, c6, qVar2.f(i5));
            }
        }
        return aVar.d();
    }

    static boolean d(String str) {
        if ("Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    static boolean e(String str) {
        if ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    private static z f(z zVar) {
        if (zVar == null || zVar.a() == null) {
            return zVar;
        }
        return zVar.v().b((C2450A) null).c();
    }

    public z a(C2471s.a aVar) {
        f fVar = this.f23262a;
        z b5 = fVar != null ? fVar.b(aVar.request()) : null;
        C2480c c5 = new C2480c.a(System.currentTimeMillis(), aVar.request(), b5).c();
        x xVar = c5.f23268a;
        z zVar = c5.f23269b;
        f fVar2 = this.f23262a;
        if (fVar2 != null) {
            fVar2.d(c5);
        }
        if (b5 != null && zVar == null) {
            c.d(b5.a());
        }
        if (xVar == null && zVar == null) {
            return new z.a().o(aVar.request()).m(C2474v.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).j("Unsatisfiable Request (only-if-cached)").b(c.f23244c).p(-1).n(System.currentTimeMillis()).c();
        }
        if (xVar == null) {
            return zVar.v().d(f(zVar)).c();
        }
        try {
            z a5 = aVar.a(xVar);
            if (a5 == null && b5 != null) {
            }
            if (zVar != null) {
                if (a5.i() == 304) {
                    z c6 = zVar.v().i(c(zVar.o(), a5.o())).p(a5.D()).n(a5.z()).d(f(zVar)).k(f(a5)).c();
                    a5.a().close();
                    this.f23262a.trackConditionalCacheHit();
                    this.f23262a.e(zVar, c6);
                    return c6;
                }
                c.d(zVar.a());
            }
            z c7 = a5.v().d(f(zVar)).k(f(a5)).c();
            if (this.f23262a != null) {
                if (e.c(c7) && C2480c.a(c7, xVar)) {
                    return b(this.f23262a.c(c7), c7);
                }
                if (f.a(xVar.g())) {
                    try {
                        this.f23262a.a(xVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c7;
        } finally {
            if (b5 != null) {
                c.d(b5.a());
            }
        }
    }
}
