package G;

import R.o;
import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;

public final class v extends q {

    /* renamed from: a  reason: collision with root package name */
    private final Context f224a;

    public v(Context context) {
        this.f224a = context;
    }

    private final void i() {
        if (!o.a(this.f224a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            throw new SecurityException("Calling UID " + callingUid + " is not Google Play services.");
        }
    }

    public final void q() {
        i();
        p.a(this.f224a).b();
    }

    public final void x() {
        i();
        c b5 = c.b(this.f224a);
        GoogleSignInAccount c5 = b5.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f1202l;
        if (c5 != null) {
            googleSignInOptions = b5.d();
        }
        b a5 = a.a(this.f224a, googleSignInOptions);
        if (c5 != null) {
            a5.r();
        } else {
            a5.s();
        }
    }
}
