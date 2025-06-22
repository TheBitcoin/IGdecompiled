package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f884a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f885b;

    public /* synthetic */ M(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f884a = preRGnssStatusTransport;
        this.f885b = executor;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.c(this.f884a, this.f885b);
    }
}
