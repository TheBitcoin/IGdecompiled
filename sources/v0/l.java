package v0;

import A0.m;
import R0.a;
import R0.b;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final a f21980a;

    public l(a aVar) {
        this.f21980a = aVar;
    }

    public static /* synthetic */ void a(e eVar, b bVar) {
        android.support.v4.media.a.a(bVar.get());
        throw null;
    }

    public void b(m mVar) {
        if (mVar == null) {
            g.f().k("Didn't successfully register with UserMetadata for rollouts listener");
            return;
        }
        this.f21980a.a(new k(new e(mVar)));
    }
}
