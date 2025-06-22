package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f893a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f894b;

    public /* synthetic */ u(Consumer consumer, Location location) {
        this.f893a = consumer;
        this.f894b = location;
    }

    public final void run() {
        this.f893a.accept(this.f894b);
    }
}
