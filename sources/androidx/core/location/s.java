package androidx.core.location;

import android.location.Location;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f891a;

    public /* synthetic */ s(androidx.core.util.Consumer consumer) {
        this.f891a = consumer;
    }

    public final void accept(Object obj) {
        this.f891a.accept((Location) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
