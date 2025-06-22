package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.Predicate;
import androidx.core.util.i;

/* renamed from: androidx.core.view.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0437b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f918a;

    public /* synthetic */ C0437b(java.util.function.Predicate predicate) {
        this.f918a = predicate;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return i.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return i.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return i.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f918a.test((ClipData.Item) obj);
    }
}
