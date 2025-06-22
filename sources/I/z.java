package I;

import android.os.Bundle;

final class z extends A {
    z(int i4, int i5, Bundle bundle) {
        super(i4, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d((Object) null);
        } else {
            c(new B(4, "Invalid response to one way request", (Throwable) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }
}
