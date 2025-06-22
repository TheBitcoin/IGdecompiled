package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport f895a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GnssMeasurementsEvent f897c;

    public /* synthetic */ x(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.f895a = gnssMeasurementsTransport;
        this.f896b = executor;
        this.f897c = gnssMeasurementsEvent;
    }

    public final void run() {
        LocationManagerCompat.GnssMeasurementsTransport.a(this.f895a, this.f896b, this.f897c);
    }
}
