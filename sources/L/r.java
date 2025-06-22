package L;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class r extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f401a;

    /* renamed from: b  reason: collision with root package name */
    private final q f402b;

    public r(q qVar) {
        this.f402b = qVar;
    }

    public final void a(Context context) {
        this.f401a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f401a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f401a = null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            this.f402b.a();
            b();
        }
    }
}
