package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f872a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f874c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f875d;

    public /* synthetic */ I(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i4, Bundle bundle) {
        this.f872a = locationListenerTransport;
        this.f873b = str;
        this.f874c = i4;
        this.f875d = bundle;
    }

    public final void run() {
        LocationManagerCompat.LocationListenerTransport.b(this.f872a, this.f873b, this.f874c, this.f875d);
    }
}
