package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f845a;

    public /* synthetic */ i(ComponentName componentName) {
        this.f845a = componentName;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.i.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return androidx.core.util.i.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.i.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f845a.equals((ComponentName) obj);
    }
}
