package f0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.C0604k7;
import com.google.android.gms.measurement.internal.G;
import com.google.android.gms.measurement.internal.S2;
import com.google.android.gms.measurement.internal.f6;

public final class F extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final S2 f3366a;

    public F(S2 s22) {
        this.f3366a = s22;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.f3366a.a().L().a("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.f3366a.a().L().a("App receiver called with null action");
        } else if (!action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            this.f3366a.a().L().a("App receiver called with unknown action");
        } else {
            S2 s22 = this.f3366a;
            if (C0604k7.a() && s22.w().H((String) null, G.f2423J0)) {
                s22.a().K().a("App receiver notified triggers are available");
                s22.f().D(new f6(s22));
            }
        }
    }
}
