package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f898a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f899b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f900c;

    public /* synthetic */ y(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i4) {
        this.f898a = gnssMeasurementsTransport;
        this.f899b = executor;
        this.f900c = i4;
    }

    public final void run() {
        LocationManagerCompat.GnssMeasurementsTransport.b(this.f898a, this.f899b, this.f900c);
    }
}
