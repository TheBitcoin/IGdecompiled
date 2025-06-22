package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f902b;

    public /* synthetic */ z(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f901a = gpsStatusTransport;
        this.f902b = executor;
    }

    public final void run() {
        LocationManagerCompat.GpsStatusTransport.b(this.f901a, this.f902b);
    }
}
