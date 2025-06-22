package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class E implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f864a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f865b;

    public /* synthetic */ E(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f864a = locationListenerTransport;
        this.f865b = str;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.e(this.f864a, this.f865b);
    }
}
