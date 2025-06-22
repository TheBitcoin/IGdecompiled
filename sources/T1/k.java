package t1;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.lang.ref.WeakReference;
import q1.n;
import v1.C2329a;

public class k {

    /* renamed from: d  reason: collision with root package name */
    private static k f21814d = new k();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f21815a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f21816b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f21817c = false;

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            k kVar;
            boolean d5;
            boolean z4;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                kVar = k.this;
                d5 = kVar.f21817c;
                z4 = true;
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                kVar = k.this;
                d5 = kVar.f21817c;
                z4 = false;
            } else {
                return;
            }
            kVar.c(z4, d5);
            boolean unused = k.this.f21816b = z4;
        }
    }

    public static k f() {
        return f21814d;
    }

    public void a() {
        boolean z4;
        Context context = (Context) this.f21815a.get();
        if (context != null) {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (Build.VERSION.SDK_INT >= 22) {
                z4 = keyguardManager.isDeviceLocked();
            } else {
                z4 = keyguardManager.inKeyguardRestrictedInputMode();
            }
            c(this.f21816b, z4);
            this.f21817c = z4;
        }
    }

    public void b(Context context) {
        if (context != null) {
            this.f21815a = new WeakReference(context);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            context.registerReceiver(new a(), intentFilter);
        }
    }

    public void c(boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        if (z5 || z4) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f21817c || this.f21816b) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z6 != z7) {
            for (n t4 : C2286c.e().c()) {
                C2329a t5 = t4.t();
                if (z5 || z4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                t5.q(z8);
            }
        }
    }
}
