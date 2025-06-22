package y0;

import S0.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.work.WorkRequest;
import j$.util.Objects;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k0.C0940o;
import v0.g;
import y0.J;
import z0.C2446g;

public class I implements J {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f22595g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h  reason: collision with root package name */
    private static final String f22596h = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    private final K f22597a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22598b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22599c;

    /* renamed from: d  reason: collision with root package name */
    private final e f22600d;

    /* renamed from: e  reason: collision with root package name */
    private final D f22601e;

    /* renamed from: f  reason: collision with root package name */
    private J.a f22602f;

    public I(Context context, String str, e eVar, D d5) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.f22598b = context;
            this.f22599c = str;
            this.f22600d = eVar;
            this.f22601e = d5;
            this.f22597a = new K();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e5;
        e5 = e(UUID.randomUUID().toString());
        g f4 = g.f();
        f4.i("Created new Crashlytics installation ID: " + e5 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e5).putString("firebase.installation.id", str).apply();
        return e5;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        return f22595g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        if (str == null || !str.startsWith("SYN_")) {
            return false;
        }
        return true;
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String) null);
    }

    private String m(String str) {
        return str.replaceAll(f22596h, "");
    }

    private boolean n() {
        J.a aVar = this.f22602f;
        if (aVar == null) {
            return true;
        }
        if (aVar.e() != null || !this.f22601e.d()) {
            return false;
        }
        return true;
    }

    public synchronized J.a a() {
        String str;
        if (!n()) {
            return this.f22602f;
        }
        g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences q4 = C2420j.q(this.f22598b);
        String string = q4.getString("firebase.installation.id", (String) null);
        g f4 = g.f();
        f4.i("Cached Firebase Installation ID: " + string);
        if (this.f22601e.d()) {
            H d5 = d(false);
            g f5 = g.f();
            f5.i("Fetched Firebase Installation ID: " + d5.b());
            if (d5.b() == null) {
                if (string == null) {
                    str = c();
                } else {
                    str = string;
                }
                d5 = new H(str, (String) null);
            }
            if (Objects.equals(d5.b(), string)) {
                this.f22602f = J.a.a(l(q4), d5);
            } else {
                this.f22602f = J.a.a(b(d5.b(), q4), d5);
            }
        } else if (k(string)) {
            this.f22602f = J.a.b(l(q4));
        } else {
            this.f22602f = J.a.b(b(c(), q4));
        }
        g f6 = g.f();
        f6.i("Install IDs: " + this.f22602f);
        return this.f22602f;
    }

    public H d(boolean z4) {
        String str;
        C2446g.e();
        String str2 = null;
        if (z4) {
            try {
                str = ((com.google.firebase.installations.g) C0940o.b(this.f22600d.a(false), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)).b();
            } catch (Exception e5) {
                g.f().l("Error getting Firebase authentication token.", e5);
            }
            str2 = (String) C0940o.b(this.f22600d.getId(), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
            return new H(str2, str);
        }
        str = null;
        try {
            str2 = (String) C0940o.b(this.f22600d.getId(), WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (Exception e6) {
            g.f().l("Error getting Firebase installation id.", e6);
        }
        return new H(str2, str);
    }

    public String f() {
        return this.f22599c;
    }

    public String g() {
        return this.f22597a.a(this.f22598b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", new Object[]{m(Build.MANUFACTURER), m(Build.MODEL)});
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
