package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class L implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f883b;

    public /* synthetic */ L(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f882a = preRGnssStatusTransport;
        this.f883b = executor;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.a(this.f882a, this.f883b);
    }
}
