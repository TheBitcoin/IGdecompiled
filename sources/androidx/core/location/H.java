package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f870a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f871b;

    public /* synthetic */ H(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i4) {
        this.f870a = locationListenerTransport;
        this.f871b = i4;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.f(this.f870a, this.f871b);
    }
}
