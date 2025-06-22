package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f876a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f877b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f878c;

    public /* synthetic */ J(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i4) {
        this.f876a = preRGnssStatusTransport;
        this.f877b = executor;
        this.f878c = i4;
    }

    public final void run() {
        LocationManagerCompat.PreRGnssStatusTransport.b(this.f876a, this.f877b, this.f878c);
    }
}
