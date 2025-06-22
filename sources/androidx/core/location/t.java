package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f892a;

    public /* synthetic */ t(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f892a = cancellableLocationListener;
    }

    public final void run() {
        LocationManagerCompat.CancellableLocationListener.a(this.f892a);
    }
}
