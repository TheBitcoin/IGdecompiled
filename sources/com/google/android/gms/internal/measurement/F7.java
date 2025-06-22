package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;

public final class F7 extends C0623n {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final J7 f1473c;

    public F7(J7 j7) {
        super("internal.logger");
        this.f1473c = j7;
        this.f2066b.put("log", new I7(this, false, true));
        this.f2066b.put(NotificationCompat.GROUP_KEY_SILENT, new x7(this, NotificationCompat.GROUP_KEY_SILENT));
        ((C0623n) this.f2066b.get(NotificationCompat.GROUP_KEY_SILENT)).h("log", new I7(this, true, true));
        this.f2066b.put("unmonitored", new H7(this, "unmonitored"));
        ((C0623n) this.f2066b.get("unmonitored")).h("log", new I7(this, false, false));
    }

    public final C0663s a(Z2 z22, List list) {
        return C0663s.f2138b0;
    }
}
