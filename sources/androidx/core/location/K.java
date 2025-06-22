package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class K implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatus f881c;

    public /* synthetic */ K(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f879a = preRGnssStatusTransport;
        this.f880b = executor;
        this.f881c = gnssStatus;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.d(this.f879a, this.f880b, this.f881c);
    }
}
