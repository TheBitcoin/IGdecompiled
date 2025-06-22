package u2;

import P3.C2546b;
import P3.C2549e;
import P3.f;
import R2.s;
import R3.C2567f;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.a;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.activities.preferences.a;
import g2.C2061t;
import g2.L;
import kotlin.jvm.internal.m;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21951a;

    /* renamed from: b  reason: collision with root package name */
    private FirebaseAnalytics f21952b;

    /* renamed from: c  reason: collision with root package name */
    private C2549e f21953c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f21954d = new Object();

    public x(Context context) {
        this.f21951a = context;
        if (context != null) {
            a b5 = a.b();
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            b5.d(aVar.O(context));
            this.f21952b = FirebaseAnalytics.getInstance(context);
            if (aVar.M(context)) {
                FirebaseAnalytics firebaseAnalytics = this.f21952b;
                if (firebaseAnalytics != null) {
                    firebaseAnalytics.b(true);
                }
                c(context);
                return;
            }
            FirebaseAnalytics firebaseAnalytics2 = this.f21952b;
            if (firebaseAnalytics2 != null) {
                firebaseAnalytics2.b(false);
            }
            a();
        }
    }

    private final void a() {
        synchronized (this.f21954d) {
            this.f21953c = null;
            s sVar = s.f8222a;
        }
    }

    private final C2549e c(Context context) {
        C2549e eVar;
        synchronized (this.f21954d) {
            try {
                if (this.f21953c == null) {
                    this.f21953c = f.b("https://m.uptodown.net/matomo.php", 6).a(C2546b.f23786e.a(context));
                }
                eVar = this.f21953c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final void b() {
        if (this.f21953c != null && this.f21951a != null) {
            C2567f.c().a().a(this.f21953c);
        }
    }

    public final void d(String str, Bundle bundle) {
        m.e(str, NotificationCompat.CATEGORY_EVENT);
        m.e(bundle, "params");
        FirebaseAnalytics firebaseAnalytics = this.f21952b;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.a(str, bundle);
        }
        C2061t.f20768d.g(str, bundle, this.f21951a);
    }

    public final void e(String str) {
        m.e(str, RewardPlus.NAME);
        if (this.f21953c != null) {
            C2567f.c().b(str).c(this.f21953c);
        }
    }

    public final void f(String str, Bundle bundle, L l4, String str2) {
        m.e(str, "type");
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle = bundle2;
        }
        if (l4 != null) {
            if (l4.f() > 0) {
                bundle.putString("responseCode", String.valueOf(l4.f()));
            }
            if (l4.c() != null) {
                bundle.putString("exception", l4.c());
            }
        }
        if (str2 != null) {
            bundle.putString("workRequest", str2);
        }
        bundle.putString("type", str);
        d("tracking", bundle);
    }
}
