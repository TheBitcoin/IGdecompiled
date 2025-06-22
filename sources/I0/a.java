package i0;

import G.c;
import J.C0303b;
import J.C0313l;
import M.C0322c;
import M.C0323d;
import M.C0326g;
import M.C0335p;
import M.M;
import M.O;
import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import h0.e;

public class a extends C0326g implements e {

    /* renamed from: M  reason: collision with root package name */
    public static final /* synthetic */ int f3416M = 0;

    /* renamed from: I  reason: collision with root package name */
    private final boolean f3417I = true;

    /* renamed from: J  reason: collision with root package name */
    private final C0323d f3418J;

    /* renamed from: K  reason: collision with root package name */
    private final Bundle f3419K;

    /* renamed from: L  reason: collision with root package name */
    private final Integer f3420L;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r8, android.os.Looper r9, boolean r10, M.C0323d r11, android.os.Bundle r12, K.f.a r13, K.f.b r14) {
        /*
            r7 = this;
            r3 = 44
            r0 = r7
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r13
            r6 = r14
            r0.<init>((android.content.Context) r1, (android.os.Looper) r2, (int) r3, (M.C0323d) r4, (K.f.a) r5, (K.f.b) r6)
            r8 = 1
            r0.f3417I = r8
            r0.f3418J = r4
            r0.f3419K = r12
            java.lang.Integer r8 = r4.i()
            r0.f3420L = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.<init>(android.content.Context, android.os.Looper, boolean, M.d, android.os.Bundle, K.f$a, K.f$b):void");
    }

    public static Bundle m0(C0323d dVar) {
        dVar.h();
        Integer i4 = dVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (i4 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i4.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        if (!y().getPackageName().equals(this.f3418J.f())) {
            this.f3419K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f3418J.f());
        }
        return this.f3419K;
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.signin.service.START";
    }

    public final void a(f fVar) {
        GoogleSignInAccount googleSignInAccount;
        C0335p.m(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c5 = this.f3418J.c();
            if ("<<default account>>".equals(c5.name)) {
                googleSignInAccount = c.b(y()).c();
            } else {
                googleSignInAccount = null;
            }
            ((g) D()).l0(new j(1, new M(c5, ((Integer) C0335p.l(this.f3420L)).intValue(), googleSignInAccount)), fVar);
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.a0(new l(1, new C0303b(8, (PendingIntent) null), (O) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    public final int l() {
        return C0313l.f342a;
    }

    public final boolean o() {
        return this.f3417I;
    }

    public final void p() {
        i(new C0322c.d());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new g(iBinder);
    }
}
