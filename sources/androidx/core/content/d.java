package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.i;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f839a;

    public /* synthetic */ d(String str) {
        this.f839a = str;
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
        return this.f839a.equals(((Uri) obj).getAuthority());
    }
}
