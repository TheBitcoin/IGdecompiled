package G;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class p {

    /* renamed from: d  reason: collision with root package name */
    private static p f220d;

    /* renamed from: a  reason: collision with root package name */
    final c f221a;

    /* renamed from: b  reason: collision with root package name */
    GoogleSignInAccount f222b;

    /* renamed from: c  reason: collision with root package name */
    GoogleSignInOptions f223c;

    private p(Context context) {
        c b5 = c.b(context);
        this.f221a = b5;
        this.f222b = b5.c();
        this.f223c = b5.d();
    }

    public static synchronized p a(Context context) {
        p d5;
        synchronized (p.class) {
            d5 = d(context.getApplicationContext());
        }
        return d5;
    }

    private static synchronized p d(Context context) {
        synchronized (p.class) {
            p pVar = f220d;
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p(context);
            f220d = pVar2;
            return pVar2;
        }
    }

    public final synchronized void b() {
        this.f221a.a();
        this.f222b = null;
        this.f223c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f221a.f(googleSignInAccount, googleSignInOptions);
        this.f222b = googleSignInAccount;
        this.f223c = googleSignInOptions;
    }
}
