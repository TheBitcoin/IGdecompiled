package M;

import K.g;
import M.C0334o;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;
import k0.C0938m;

final class J implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f431a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0938m f432b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0334o.a f433c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ L f434d;

    J(g gVar, C0938m mVar, C0334o.a aVar, L l4) {
        this.f431a = gVar;
        this.f432b = mVar;
        this.f433c = aVar;
        this.f434d = l4;
    }

    public final void a(Status status) {
        if (status.k()) {
            this.f432b.c(this.f433c.a(this.f431a.b(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f432b.b(C0321b.a(status));
    }
}
