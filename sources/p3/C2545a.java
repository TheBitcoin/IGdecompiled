package P3;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: P3.a  reason: case insensitive filesystem */
public final class C2545a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0287a f23784b = new C0287a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f23785a;

    /* renamed from: P3.a$a  reason: collision with other inner class name */
    public static final class C0287a {
        public /* synthetic */ C0287a(C2103g gVar) {
            this();
        }

        private C0287a() {
        }
    }

    public C2545a(C2546b bVar) {
        m.e(bVar, "matomo");
        this.f23785a = bVar.g();
    }

    public final void a(C2549e eVar) {
        m.e(eVar, "tracker");
        SharedPreferences g4 = eVar.g();
        if (this.f23785a.getBoolean("matomo.optout", false)) {
            g4.edit().putBoolean("tracker.optout", true).apply();
            this.f23785a.edit().remove("matomo.optout").apply();
        }
        if (this.f23785a.contains("tracker.userid")) {
            g4.edit().putString("tracker.userid", this.f23785a.getString("tracker.userid", UUID.randomUUID().toString())).apply();
            this.f23785a.edit().remove("tracker.userid").apply();
        }
        if (this.f23785a.contains("tracker.firstvisit")) {
            g4.edit().putLong("tracker.firstvisit", this.f23785a.getLong("tracker.firstvisit", -1)).apply();
            this.f23785a.edit().remove("tracker.firstvisit").apply();
        }
        if (this.f23785a.contains("tracker.visitcount")) {
            g4.edit().putLong("tracker.visitcount", (long) this.f23785a.getInt("tracker.visitcount", 0)).apply();
            this.f23785a.edit().remove("tracker.visitcount").apply();
        }
        if (this.f23785a.contains("tracker.previousvisit")) {
            g4.edit().putLong("tracker.previousvisit", this.f23785a.getLong("tracker.previousvisit", -1)).apply();
            this.f23785a.edit().remove("tracker.previousvisit").apply();
        }
        Map<String, ?> all = this.f23785a.getAll();
        m.d(all, "getAll(...)");
        for (Map.Entry<String, ?> key : all.entrySet()) {
            String str = (String) key.getKey();
            m.b(str);
            if (m3.m.y(str, "downloaded:", false, 2, (Object) null)) {
                g4.edit().putBoolean(str, true).apply();
                this.f23785a.edit().remove(str).apply();
            }
        }
    }
}
