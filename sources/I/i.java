package I;

import a0.f;
import android.os.Looper;
import android.os.Message;

final class i extends f {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0296c f261b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(C0296c cVar, Looper looper) {
        super(looper);
        this.f261b = cVar;
    }

    public final void handleMessage(Message message) {
        C0296c.g(this.f261b, message);
    }
}
