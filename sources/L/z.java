package L;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f417a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f418b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A f419c;

    z(A a5, LifecycleCallback lifecycleCallback, String str) {
        this.f419c = a5;
        this.f417a = lifecycleCallback;
        this.f418b = str;
    }

    public final void run() {
        Bundle bundle;
        A a5 = this.f419c;
        if (a5.f384b > 0) {
            LifecycleCallback lifecycleCallback = this.f417a;
            if (a5.f385c != null) {
                bundle = a5.f385c.getBundle(this.f418b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.f419c.f384b >= 2) {
            this.f417a.j();
        }
        if (this.f419c.f384b >= 3) {
            this.f417a.h();
        }
        if (this.f419c.f384b >= 4) {
            this.f417a.k();
        }
        if (this.f419c.f384b >= 5) {
            this.f417a.g();
        }
    }
}
