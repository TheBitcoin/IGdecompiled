package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f858c;

    public /* synthetic */ B(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i4) {
        this.f856a = gpsStatusTransport;
        this.f857b = executor;
        this.f858c = i4;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.c(this.f856a, this.f857b, this.f858c);
    }
}
