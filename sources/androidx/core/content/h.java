package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f843a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f844b;

    public /* synthetic */ h(Class cls, Predicate predicate) {
        this.f843a = cls;
        this.f844b = predicate;
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
        return IntentSanitizer.Builder.e(this.f843a, this.f844b, obj);
    }
}
