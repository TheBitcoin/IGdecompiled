package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f862a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f863b;

    public /* synthetic */ D(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f862a = locationListenerTransport;
        this.f863b = str;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.a(this.f862a, this.f863b);
    }
}
