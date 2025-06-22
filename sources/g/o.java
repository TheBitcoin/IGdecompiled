package G;

import F.b;
import K.f;
import K.g;
import K.h;
import P.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0504c;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final a f219a = new a("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f219a.a("getFallbackSignInIntent()", new Object[0]);
        Intent c5 = c(context, googleSignInOptions);
        c5.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return c5;
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        f219a.a("getNoImplementationSignInIntent()", new Object[0]);
        Intent c5 = c(context, googleSignInOptions);
        c5.setAction("com.google.android.gms.auth.NO_IMPL");
        return c5;
    }

    public static Intent c(Context context, GoogleSignInOptions googleSignInOptions) {
        f219a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static b d(Intent intent) {
        if (intent == null) {
            return new b((GoogleSignInAccount) null, Status.f1251h);
        }
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount != null) {
            return new b(googleSignInAccount, Status.f1249f);
        }
        if (status == null) {
            status = Status.f1251h;
        }
        return new b((GoogleSignInAccount) null, status);
    }

    public static g e(f fVar, Context context, boolean z4) {
        f219a.a("Revoking access", new Object[0]);
        String e5 = c.b(context).e();
        g(context);
        if (z4) {
            return f.a(e5);
        }
        return fVar.a(new m(fVar));
    }

    public static g f(f fVar, Context context, boolean z4) {
        f219a.a("Signing out", new Object[0]);
        g(context);
        if (z4) {
            return h.b(Status.f1249f, fVar);
        }
        return fVar.a(new k(fVar));
    }

    private static void g(Context context) {
        p.a(context).b();
        for (f e5 : f.b()) {
            e5.e();
        }
        C0504c.a();
    }
}
