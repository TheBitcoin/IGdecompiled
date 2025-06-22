package J;

import Z.i;
import android.content.Context;
import android.os.Message;
import android.util.Log;

final class q extends i {

    /* renamed from: b  reason: collision with root package name */
    private final Context f354b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0308g f355c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(J.C0308g r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.f355c = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x000d
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L_0x0011
        L_0x000d:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L_0x0011:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.f354b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J.q.<init>(J.g, android.content.Context):void");
    }

    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i4);
            return;
        }
        C0308g gVar = this.f355c;
        int g4 = gVar.g(this.f354b);
        if (gVar.j(g4)) {
            this.f355c.p(this.f354b, g4);
        }
    }
}
