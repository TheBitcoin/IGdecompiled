package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class x implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f853a;

    public /* synthetic */ x(UriMatcher uriMatcher) {
        this.f853a = uriMatcher;
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
        return UriMatcherCompat.a(this.f853a, (Uri) obj);
    }
}
