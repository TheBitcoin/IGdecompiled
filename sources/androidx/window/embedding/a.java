package androidx.window.embedding;

import android.content.Intent;
import j$.util.function.Predicate$CC;
import java.util.Set;
import java.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f1030a;

    public /* synthetic */ a(Set set) {
        this.f1030a = set;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m8translateIntentPredicates$lambda8(this.f1030a, (Intent) obj);
    }
}
