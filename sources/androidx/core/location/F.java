package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f866a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f867b;

    public /* synthetic */ F(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f866a = locationListenerTransport;
        this.f867b = list;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.d(this.f866a, this.f867b);
    }
}
