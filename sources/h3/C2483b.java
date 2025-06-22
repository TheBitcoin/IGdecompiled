package H3;

import D3.C2471s;
import D3.x;
import D3.z;
import G3.c;
import G3.g;
import N3.C2514e;
import N3.C2515f;
import N3.C2521l;
import N3.L;
import N3.X;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.ProtocolException;

/* renamed from: H3.b  reason: case insensitive filesystem */
public final class C2483b implements C2471s {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23372a;

    /* renamed from: H3.b$a */
    static final class a extends C2521l {

        /* renamed from: b  reason: collision with root package name */
        long f23373b;

        a(X x4) {
            super(x4);
        }

        public void m(C2514e eVar, long j4) {
            super.m(eVar, j4);
            this.f23373b += j4;
        }
    }

    public C2483b(boolean z4) {
        this.f23372a = z4;
    }

    public z a(C2471s.a aVar) {
        z zVar;
        g gVar = (g) aVar;
        C2484c e5 = gVar.e();
        g g4 = gVar.g();
        c cVar = (c) gVar.c();
        x request = gVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.d().o(gVar.b());
        e5.c(request);
        gVar.d().n(gVar.b(), request);
        z.a aVar2 = null;
        if (f.b(request.g()) && request.a() != null) {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                e5.flushRequest();
                gVar.d().s(gVar.b());
                aVar2 = e5.readResponseHeaders(true);
            }
            if (aVar2 == null) {
                gVar.d().m(gVar.b());
                a aVar3 = new a(e5.b(request, request.a().a()));
                C2515f c5 = L.c(aVar3);
                request.a().e(c5);
                c5.close();
                gVar.d().l(gVar.b(), aVar3.f23373b);
            } else if (!cVar.m()) {
                g4.i();
            }
        }
        e5.finishRequest();
        if (aVar2 == null) {
            gVar.d().s(gVar.b());
            aVar2 = e5.readResponseHeaders(false);
        }
        z c6 = aVar2.o(request).h(g4.c().j()).p(currentTimeMillis).n(System.currentTimeMillis()).c();
        int i4 = c6.i();
        if (i4 == 100) {
            c6 = e5.readResponseHeaders(false).o(request).h(g4.c().j()).p(currentTimeMillis).n(System.currentTimeMillis()).c();
            i4 = c6.i();
        }
        gVar.d().r(gVar.b(), c6);
        if (!this.f23372a || i4 != 101) {
            zVar = c6.v().b(e5.a(c6)).c();
        } else {
            zVar = c6.v().b(E3.c.f23244c).c();
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(zVar.A().c("Connection")) || CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(zVar.l("Connection"))) {
            g4.i();
        }
        if ((i4 != 204 && i4 != 205) || zVar.a().a() <= 0) {
            return zVar;
        }
        throw new ProtocolException("HTTP " + i4 + " had non-zero Content-Length: " + zVar.a().a());
    }
}
