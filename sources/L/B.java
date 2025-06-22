package L;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

final class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f386a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f387b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C f388c;

    B(C c5, LifecycleCallback lifecycleCallback, String str) {
        this.f388c = c5;
        this.f386a = lifecycleCallback;
        this.f387b = str;
    }

    public final void run() {
        Bundle bundle;
        C c5 = this.f388c;
        if (c5.f391b > 0) {
            LifecycleCallback lifecycleCallback = this.f386a;
            if (c5.f392c != null) {
                bundle = c5.f392c.getBundle(this.f387b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f388c.f391b >= 2) {
            this.f386a.j();
        }
        if (this.f388c.f391b >= 3) {
            this.f386a.h();
        }
        if (this.f388c.f391b >= 4) {
            this.f386a.k();
        }
        if (this.f388c.f391b >= 5) {
            this.f386a.g();
        }
    }
}
