package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class C implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f859a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f860b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssStatusCompat f861c;

    public /* synthetic */ C(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f859a = gpsStatusTransport;
        this.f860b = executor;
        this.f861c = gnssStatusCompat;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.d(this.f859a, this.f860b, this.f861c);
    }
}
