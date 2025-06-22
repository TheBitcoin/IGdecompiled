package G3;

import D3.C2471s;
import D3.C2473u;
import D3.x;
import D3.z;
import H3.g;
import androidx.browser.trusted.sharing.ShareTarget;

/* renamed from: G3.a  reason: case insensitive filesystem */
public final class C2481a implements C2471s {

    /* renamed from: a  reason: collision with root package name */
    public final C2473u f23324a;

    public C2481a(C2473u uVar) {
        this.f23324a = uVar;
    }

    public z a(C2471s.a aVar) {
        g gVar = (g) aVar;
        x request = gVar.request();
        g g4 = gVar.g();
        return gVar.f(request, g4, g4.h(this.f23324a, aVar, !request.g().equals(ShareTarget.METHOD_GET)), g4.c());
    }
}
