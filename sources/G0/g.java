package G0;

import D0.b;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import k0.C0936k;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;
import org.json.JSONObject;
import y0.C2410C;
import y0.C2420j;
import y0.D;
import y0.E;
import y0.I;
import y0.a0;
import z0.C2446g;

public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6539a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final k f6540b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h f6541c;

    /* renamed from: d  reason: collision with root package name */
    private final C2410C f6542d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final C1299a f6543e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final l f6544f;

    /* renamed from: g  reason: collision with root package name */
    private final D f6545g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference f6546h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference f6547i = new AtomicReference(new C0938m());

    class a implements C0936k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2446g f6548a;

        a(C2446g gVar) {
            this.f6548a = gVar;
        }

        /* renamed from: c */
        public C0937l a(Void voidR) {
            JSONObject jSONObject = (JSONObject) this.f6548a.f22854d.c().submit(new f(this)).get();
            if (jSONObject != null) {
                d b5 = g.this.f6541c.b(jSONObject);
                g.this.f6543e.c(b5.f6523c, jSONObject);
                g.this.q(jSONObject, "Loaded settings: ");
                g gVar = g.this;
                boolean unused = gVar.r(gVar.f6540b.f6556f);
                g.this.f6546h.set(b5);
                ((C0938m) g.this.f6547i.get()).e(b5);
            }
            return C0940o.e((Object) null);
        }
    }

    g(Context context, k kVar, C2410C c5, h hVar, C1299a aVar, l lVar, D d5) {
        AtomicReference atomicReference = new AtomicReference();
        this.f6546h = atomicReference;
        this.f6539a = context;
        this.f6540b = kVar;
        this.f6542d = c5;
        this.f6541c = hVar;
        this.f6543e = aVar;
        this.f6544f = lVar;
        this.f6545g = d5;
        atomicReference.set(b.b(c5));
    }

    public static g l(Context context, String str, I i4, b bVar, String str2, String str3, E0.g gVar, D d5) {
        String g4 = i4.g();
        a0 a0Var = new a0();
        h hVar = new h(a0Var);
        C1299a aVar = new C1299a(gVar);
        c cVar = new c(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", new Object[]{str}), bVar);
        String str4 = str2;
        String str5 = str3;
        return new g(context, new k(str, i4.h(), i4.i(), i4.j(), i4, C2420j.h(C2420j.m(context), str, str5, str4), str5, str4, E.b(g4).c()), a0Var, hVar, aVar, cVar, d5);
    }

    private d m(e eVar) {
        d dVar = null;
        try {
            if (!e.SKIP_CACHE_LOOKUP.equals(eVar)) {
                JSONObject b5 = this.f6543e.b();
                if (b5 != null) {
                    d b6 = this.f6541c.b(b5);
                    if (b6 != null) {
                        q(b5, "Loaded cached settings: ");
                        long a5 = this.f6542d.a();
                        if (!e.IGNORE_CACHE_EXPIRATION.equals(eVar)) {
                            if (b6.a(a5)) {
                                v0.g.f().i("Cached settings have expired.");
                                return null;
                            }
                        }
                        try {
                            v0.g.f().i("Returning cached settings.");
                            return b6;
                        } catch (Exception e5) {
                            e = e5;
                            dVar = b6;
                            v0.g.f().e("Failed to get cached settings", e);
                            return dVar;
                        }
                    } else {
                        v0.g.f().e("Failed to parse cached settings data.", (Throwable) null);
                        return null;
                    }
                } else {
                    v0.g.f().b("No cached settings data found.");
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
            v0.g.f().e("Failed to get cached settings", e);
            return dVar;
        }
    }

    private String n() {
        return C2420j.q(this.f6539a).getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) {
        v0.g f4 = v0.g.f();
        f4.b(str + jSONObject.toString());
    }

    /* access modifiers changed from: private */
    public boolean r(String str) {
        SharedPreferences.Editor edit = C2420j.q(this.f6539a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    public C0937l a() {
        return ((C0938m) this.f6547i.get()).a();
    }

    public d b() {
        return (d) this.f6546h.get();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return !n().equals(this.f6540b.f6556f);
    }

    public C0937l o(e eVar, C2446g gVar) {
        d m4;
        if (k() || (m4 = m(eVar)) == null) {
            d m5 = m(e.IGNORE_CACHE_EXPIRATION);
            if (m5 != null) {
                this.f6546h.set(m5);
                ((C0938m) this.f6547i.get()).e(m5);
            }
            return this.f6545g.k().o(gVar.f22851a, new a(gVar));
        }
        this.f6546h.set(m4);
        ((C0938m) this.f6547i.get()).e(m4);
        return C0940o.e((Object) null);
    }

    public C0937l p(C2446g gVar) {
        return o(e.USE_CACHE, gVar);
    }
}
