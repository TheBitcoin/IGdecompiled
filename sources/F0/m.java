package f0;

import com.google.android.gms.internal.measurement.L7;
import com.google.android.gms.measurement.internal.H2;
import com.google.android.gms.measurement.internal.I2;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ I2 f3369a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f3370b;

    public /* synthetic */ m(I2 i22, String str) {
        this.f3369a = i22;
        this.f3370b = str;
    }

    public final Object call() {
        return new L7("internal.appMetadata", new H2(this.f3369a, this.f3370b));
    }
}
