package p1;

import android.content.Context;
import t1.C2284a;
import t1.C2285b;
import t1.C2290g;
import t1.C2292i;
import t1.k;
import w1.C2334a;
import w1.C2336c;
import w1.C2338e;
import w1.C2340g;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21461a;

    private void c(Context context) {
        C2340g.b(context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        c(context);
        if (!d()) {
            b(true);
            C2292i.d().b(context);
            C2285b.k().a(context);
            C2334a.b(context);
            C2336c.d(context);
            C2338e.c(context);
            C2290g.c().b(context);
            C2284a.a().b(context);
            k.f().b(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z4) {
        this.f21461a = z4;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f21461a;
    }
}
