package M;

import android.app.Activity;
import android.content.Intent;

final class B extends D {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f422a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f423b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f424c;

    B(Intent intent, Activity activity, int i4) {
        this.f422a = intent;
        this.f423b = activity;
        this.f424c = i4;
    }

    public final void a() {
        Intent intent = this.f422a;
        if (intent != null) {
            this.f423b.startActivityForResult(intent, this.f424c);
        }
    }
}
