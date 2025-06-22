package D;

import K.a;
import M.C0333n;
import android.os.Bundle;

public final class g implements a.d {

    /* renamed from: d  reason: collision with root package name */
    public static final g f196d = new g(new f());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f197a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f198b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f199c;

    public g(f fVar) {
        this.f198b = fVar.f194a.booleanValue();
        this.f199c = fVar.f195b;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", (String) null);
        bundle.putBoolean("force_save_dialog", this.f198b);
        bundle.putString("log_session_id", this.f199c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        String str = gVar.f197a;
        if (!C0333n.a((Object) null, (Object) null) || this.f198b != gVar.f198b || !C0333n.a(this.f199c, gVar.f199c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0333n.b(null, Boolean.valueOf(this.f198b), this.f199c);
    }
}
