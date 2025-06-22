package org.matomo.sdk.extra;

import P3.C2546b;
import R3.C2566e;
import Y3.C2611a;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.List;

public class InstallReferrerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24667a = C2546b.i(InstallReferrerReceiver.class);

    /* renamed from: b  reason: collision with root package name */
    static final List f24668b = Collections.singletonList("com.android.vending.INSTALL_REFERRER");

    public static /* synthetic */ void a(Context context, String str, BroadcastReceiver.PendingResult pendingResult) {
        C2546b.f(context.getApplicationContext()).g().edit().putString("referrer.extras", str).apply();
        C2611a.b(f24667a).a("Stored Google Play referrer extras: %s", str);
        pendingResult.finish();
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        String str = f24667a;
        C2611a.b(str).a(intent.toString(), new Object[0]);
        if (intent.getAction() == null || !f24668b.contains(intent.getAction())) {
            C2611a.b(str).h("Got called outside our responsibilities: %s", intent.getAction());
        } else if (intent.getBooleanExtra("forwarded", false)) {
            C2611a.b(str).a("Dropping forwarded intent", new Object[0]);
        } else {
            if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER") && (stringExtra = intent.getStringExtra("referrer")) != null) {
                new Thread(new C2566e(context, stringExtra, goAsync())).start();
            }
            intent.setComponent((ComponentName) null);
            intent.setPackage(context.getPackageName());
            intent.putExtra("forwarded", true);
            context.sendBroadcast(intent);
        }
    }
}
