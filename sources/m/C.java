package M;

import L.e;
import android.content.Intent;

final class C extends D {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f425a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f426b;

    C(Intent intent, e eVar, int i4) {
        this.f425a = intent;
        this.f426b = eVar;
    }

    public final void a() {
        Intent intent = this.f425a;
        if (intent != null) {
            this.f426b.startActivityForResult(intent, 2);
        }
    }
}
