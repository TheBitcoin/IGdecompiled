package L;

import J.C0303b;
import K.a;
import K.f;
import M.C0323d;
import M.C0335p;
import M.O;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import h0.e;
import i0.d;
import i0.l;
import java.util.Set;

public final class x extends d implements f.a, f.b {

    /* renamed from: p  reason: collision with root package name */
    private static final a.C0001a f409p = h0.d.f3410c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f410a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f411b;

    /* renamed from: k  reason: collision with root package name */
    private final a.C0001a f412k;

    /* renamed from: l  reason: collision with root package name */
    private final Set f413l;

    /* renamed from: m  reason: collision with root package name */
    private final C0323d f414m;

    /* renamed from: n  reason: collision with root package name */
    private e f415n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public w f416o;

    public x(Context context, Handler handler, C0323d dVar) {
        a.C0001a aVar = f409p;
        this.f410a = context;
        this.f411b = handler;
        this.f414m = (C0323d) C0335p.m(dVar, "ClientSettings must not be null");
        this.f413l = dVar.g();
        this.f412k = aVar;
    }

    static /* bridge */ /* synthetic */ void n0(x xVar, l lVar) {
        C0303b c5 = lVar.c();
        if (c5.k()) {
            O o4 = (O) C0335p.l(lVar.g());
            C0303b c6 = o4.c();
            if (!c6.k()) {
                String valueOf = String.valueOf(c6);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                xVar.f416o.b(c6);
                xVar.f415n.b();
                return;
            }
            xVar.f416o.c(o4.g(), xVar.f413l);
        } else {
            xVar.f416o.b(c5);
        }
        xVar.f415n.b();
    }

    public final void a0(l lVar) {
        this.f411b.post(new v(this, lVar));
    }

    public final void h(int i4) {
        this.f416o.d(i4);
    }

    public final void i(C0303b bVar) {
        this.f416o.b(bVar);
    }

    public final void k(Bundle bundle) {
        this.f415n.a(this);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [K.a$f, h0.e] */
    public final void o0(w wVar) {
        e eVar = this.f415n;
        if (eVar != null) {
            eVar.b();
        }
        this.f414m.k(Integer.valueOf(System.identityHashCode(this)));
        a.C0001a aVar = this.f412k;
        Context context = this.f410a;
        Handler handler = this.f411b;
        C0323d dVar = this.f414m;
        this.f415n = aVar.a(context, handler.getLooper(), dVar, dVar.h(), this, this);
        this.f416o = wVar;
        Set set = this.f413l;
        if (set == null || set.isEmpty()) {
            this.f411b.post(new u(this));
        } else {
            this.f415n.p();
        }
    }

    public final void p0() {
        e eVar = this.f415n;
        if (eVar != null) {
            eVar.b();
        }
    }
}
