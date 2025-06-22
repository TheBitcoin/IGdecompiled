package O;

import J.C0305d;
import L.C0319c;
import L.h;
import M.C0323d;
import M.C0326g;
import M.C0341w;
import Z.d;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class e extends C0326g {

    /* renamed from: I  reason: collision with root package name */
    private final C0341w f603I;

    public e(Context context, Looper looper, C0323d dVar, C0341w wVar, C0319c cVar, h hVar) {
        super(context, looper, (int) SubsamplingScaleImageView.ORIENTATION_270, dVar, cVar, hVar);
        this.f603I = wVar;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f603I.b();
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean I() {
        return true;
    }

    public final int l() {
        return 203400000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (queryLocalInterface instanceof a) {
            return (a) queryLocalInterface;
        }
        return new a(iBinder);
    }

    public final C0305d[] v() {
        return d.f658b;
    }
}
