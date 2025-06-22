package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f855b;

    public /* synthetic */ A(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f854a = gpsStatusTransport;
        this.f855b = executor;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.a(this.f854a, this.f855b);
    }
}
