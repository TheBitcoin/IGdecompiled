package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class G implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f868a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f869b;

    public /* synthetic */ G(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f868a = locationListenerTransport;
        this.f869b = location;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.c(this.f868a, this.f869b);
    }
}
