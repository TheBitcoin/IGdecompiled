package H3;

import D3.C2463k;
import D3.C2464l;
import D3.C2471s;
import D3.x;
import D3.y;
import D3.z;
import E3.c;
import E3.d;
import N3.C2524o;
import N3.L;
import com.mbridge.msdk.foundation.download.Command;
import java.util.List;

/* renamed from: H3.a  reason: case insensitive filesystem */
public final class C2482a implements C2471s {

    /* renamed from: a  reason: collision with root package name */
    private final C2464l f23371a;

    public C2482a(C2464l lVar) {
        this.f23371a = lVar;
    }

    private String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 > 0) {
                sb.append("; ");
            }
            C2463k kVar = (C2463k) list.get(i4);
            sb.append(kVar.c());
            sb.append('=');
            sb.append(kVar.k());
        }
        return sb.toString();
    }

    public z a(C2471s.a aVar) {
        x request = aVar.request();
        x.a h4 = request.h();
        y a5 = request.a();
        if (a5 != null) {
            a5.b();
            long a6 = a5.a();
            if (a6 != -1) {
                h4.c("Content-Length", Long.toString(a6));
                h4.f("Transfer-Encoding");
            } else {
                h4.c("Transfer-Encoding", "chunked");
                h4.f("Content-Length");
            }
        }
        boolean z4 = false;
        if (request.c("Host") == null) {
            h4.c("Host", c.p(request.i(), false));
        }
        if (request.c("Connection") == null) {
            h4.c("Connection", "Keep-Alive");
        }
        if (request.c("Accept-Encoding") == null && request.c(Command.HTTP_HEADER_RANGE) == null) {
            h4.c("Accept-Encoding", "gzip");
            z4 = true;
        }
        List b5 = this.f23371a.b(request.i());
        if (!b5.isEmpty()) {
            h4.c("Cookie", b(b5));
        }
        if (request.c(Command.HTTP_HEADER_USER_AGENT) == null) {
            h4.c(Command.HTTP_HEADER_USER_AGENT, d.a());
        }
        z a7 = aVar.a(h4.a());
        e.g(this.f23371a, request.i(), a7.o());
        z.a o4 = a7.v().o(request);
        if (z4 && "gzip".equalsIgnoreCase(a7.l("Content-Encoding")) && e.c(a7)) {
            C2524o oVar = new C2524o(a7.a().i());
            o4.i(a7.o().d().g("Content-Encoding").g("Content-Length").d());
            o4.b(new h(a7.l("Content-Type"), -1, L.d(oVar)));
        }
        return o4.c();
    }
}
