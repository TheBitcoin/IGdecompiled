package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f886a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f887b;

    public /* synthetic */ p(Consumer consumer, Location location) {
        this.f886a = consumer;
        this.f887b = location;
    }

    public final void run() {
        this.f886a.accept(this.f887b);
    }
}
