package G;

import M.C0335p;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f207c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static c f208d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f209a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f210b;

    c(Context context) {
        this.f210b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        C0335p.l(context);
        Lock lock = f207c;
        lock.lock();
        try {
            if (f208d == null) {
                f208d = new c(context.getApplicationContext());
            }
            c cVar = f208d;
            lock.unlock();
            return cVar;
        } catch (Throwable th) {
            f207c.unlock();
            throw th;
        }
    }

    private static final String i(String str, String str2) {
        return str + ":" + str2;
    }

    public void a() {
        this.f209a.lock();
        try {
            this.f210b.edit().clear().apply();
        } finally {
            this.f209a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String g4;
        String g5 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(g5) && (g4 = g(i("googleSignInAccount", g5))) != null) {
            try {
                return GoogleSignInAccount.q(g4);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String g4;
        String g5 = g("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(g5) && (g4 = g(i("googleSignInOptions", g5))) != null) {
            try {
                return GoogleSignInOptions.p(g4);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        C0335p.l(googleSignInAccount);
        C0335p.l(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.r());
        C0335p.l(googleSignInAccount);
        C0335p.l(googleSignInOptions);
        String r4 = googleSignInAccount.r();
        h(i("googleSignInAccount", r4), googleSignInAccount.s());
        h(i("googleSignInOptions", r4), googleSignInOptions.t());
    }

    /* access modifiers changed from: protected */
    public final String g(String str) {
        this.f209a.lock();
        try {
            return this.f210b.getString(str, (String) null);
        } finally {
            this.f209a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void h(String str, String str2) {
        this.f209a.lock();
        try {
            this.f210b.edit().putString(str, str2).apply();
        } finally {
            this.f209a.unlock();
        }
    }
}
