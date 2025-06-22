package O;

import M.C0338t;
import Z.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class a extends Z.a implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void l0(C0338t tVar) {
        Parcel h4 = h();
        c.c(h4, tVar);
        k(1, h4);
    }
}
