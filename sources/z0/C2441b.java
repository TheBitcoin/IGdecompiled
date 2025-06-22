package z0;

import androidx.privacysandbox.ads.adservices.adid.h;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.C0927b;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;

/* renamed from: z0.b  reason: case insensitive filesystem */
public abstract class C2441b {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f22843a = new h();

    public static /* synthetic */ C0937l a(C0938m mVar, AtomicBoolean atomicBoolean, C0927b bVar, C0937l lVar) {
        if (lVar.n()) {
            mVar.e(lVar.j());
        } else if (lVar.i() != null) {
            mVar.d(lVar.i());
        } else if (atomicBoolean.getAndSet(true)) {
            bVar.a();
        }
        return C0940o.e((Object) null);
    }

    public static C0937l b(C0937l lVar, C0937l lVar2) {
        C0927b bVar = new C0927b();
        C0938m mVar = new C0938m(bVar.b());
        C2440a aVar = new C2440a(mVar, new AtomicBoolean(false), bVar);
        Executor executor = f22843a;
        lVar.h(executor, aVar);
        lVar2.h(executor, aVar);
        return mVar.a();
    }
}
