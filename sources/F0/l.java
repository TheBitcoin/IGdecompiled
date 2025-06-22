package f0;

import M.C0335p;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.C0526c1;
import com.google.android.gms.measurement.internal.C0821n2;
import com.google.android.gms.measurement.internal.S2;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final a f3368a;

    public interface a {
        void a(Context context, Intent intent);
    }

    public l(a aVar) {
        C0335p.l(aVar);
        this.f3368a = aVar;
    }

    public final void a(Context context, Intent intent) {
        C0821n2 a5 = S2.b(context, (C0526c1) null, (Long) null).a();
        if (intent == null) {
            a5.L().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        a5.K().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            a5.K().a("Starting wakeful intent.");
            this.f3368a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            a5.L().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
