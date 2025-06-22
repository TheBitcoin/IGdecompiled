package com.google.android.gms.auth.api.signin.internal;

import G.p;
import G.x;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1237f = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1238a = false;

    /* renamed from: b  reason: collision with root package name */
    private SignInConfiguration f1239b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1240c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f1241d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Intent f1242e;

    private final void m() {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new a(this, (x) null));
        f1237f = false;
    }

    private final void n(int i4) {
        Status status = new Status(i4);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f1237f = false;
    }

    private final void o(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f1239b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f1238a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            n(17);
        }
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i4, int i5, Intent intent) {
        if (!this.f1238a) {
            setResult(0);
            if (i4 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.c() != null) {
                        GoogleSignInAccount c5 = signInAccount.c();
                        if (c5 == null) {
                            Log.e("AuthSignInClient", "Google account is null");
                            n(12500);
                            return;
                        }
                        p.a(this).c(this.f1239b.c(), c5);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", c5);
                        this.f1240c = true;
                        this.f1241d = i5;
                        this.f1242e = intent;
                        m();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        n(intExtra);
                        return;
                    }
                }
                n(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            Log.e("AuthSignInClient", "Null action");
            n(12500);
        } else if (action.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            n(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            if (bundleExtra == null) {
                Log.e("AuthSignInClient", "Activity started with no configuration.");
                setResult(0);
                finish();
                return;
            }
            SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.f1239b = signInConfiguration;
            if (bundle != null) {
                boolean z4 = bundle.getBoolean("signingInGoogleApiClients");
                this.f1240c = z4;
                if (z4) {
                    this.f1241d = bundle.getInt("signInResultCode");
                    Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                    if (intent2 == null) {
                        Log.e("AuthSignInClient", "Sign in result data cannot be null");
                        setResult(0);
                        finish();
                        return;
                    }
                    this.f1242e = intent2;
                    m();
                }
            } else if (f1237f) {
                setResult(0);
                n(12502);
            } else {
                f1237f = true;
                o(action);
            }
        } else {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f1237f = false;
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f1240c);
        if (this.f1240c) {
            bundle.putInt("signInResultCode", this.f1241d);
            bundle.putParcelable("signInResultData", this.f1242e);
        }
    }
}
