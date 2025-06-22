package P3;

import Q3.C2553d;
import Q3.C2554e;
import S3.C2571d;
import Y3.C2611a;
import android.content.SharedPreferences;
import android.support.v4.media.a;
import androidx.core.os.EnvironmentCompat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/* renamed from: P3.e  reason: case insensitive filesystem */
public class C2549e {

    /* renamed from: q  reason: collision with root package name */
    private static final String f23841q = C2546b.i(C2549e.class);

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f23842r = Pattern.compile("^(\\w+)(?:://)(.+?)$");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f23843s = Pattern.compile("^[0-9a-f]{16}$");

    /* renamed from: a  reason: collision with root package name */
    private final C2546b f23844a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23845b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23846c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23847d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f23848e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final C2554e f23849f;

    /* renamed from: g  reason: collision with root package name */
    private final String f23850g;

    /* renamed from: h  reason: collision with root package name */
    private final Random f23851h = new Random(new Date().getTime());

    /* renamed from: i  reason: collision with root package name */
    private final C2548d f23852i;

    /* renamed from: j  reason: collision with root package name */
    private C2548d f23853j;

    /* renamed from: k  reason: collision with root package name */
    private long f23854k;

    /* renamed from: l  reason: collision with root package name */
    private long f23855l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23856m;

    /* renamed from: n  reason: collision with root package name */
    private SharedPreferences f23857n;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashSet f23858o;

    /* renamed from: p  reason: collision with root package name */
    private C2553d f23859p;

    protected C2549e(C2546b bVar, f fVar) {
        String str;
        C2548d dVar = new C2548d();
        this.f23852i = dVar;
        this.f23854k = 1800000;
        this.f23855l = 0;
        this.f23858o = new LinkedHashSet();
        this.f23844a = bVar;
        this.f23845b = fVar.c();
        this.f23846c = fVar.e();
        this.f23850g = fVar.f();
        this.f23847d = fVar.d();
        new C2545a(bVar).a(this);
        this.f23856m = g().getBoolean("tracker.optout", false);
        C2554e a5 = bVar.e().a(this);
        this.f23849f = a5;
        a5.a(b());
        dVar.c(C2547c.USER_ID, g().getString("tracker.userid", (String) null));
        String string = g().getString("tracker.visitorid", (String) null);
        if (string == null) {
            string = j();
            g().edit().putString("tracker.visitorid", string).apply();
        }
        dVar.c(C2547c.VISITOR_ID, string);
        dVar.c(C2547c.SESSION_START, "1");
        C2571d d5 = bVar.d();
        int[] a6 = d5.a();
        if (a6 != null) {
            str = String.format("%sx%s", new Object[]{Integer.valueOf(a6[0]), Integer.valueOf(a6[1])});
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        dVar.c(C2547c.SCREEN_RESOLUTION, str);
        dVar.c(C2547c.USER_AGENT, d5.b());
        dVar.c(C2547c.LANGUAGE, d5.c());
        dVar.c(C2547c.URL_PATH, fVar.d());
    }

    private void h(C2548d dVar) {
        dVar.f(C2547c.SITE_ID, this.f23846c);
        dVar.h(C2547c.RECORD, "1");
        dVar.h(C2547c.API_VERSION, "1");
        dVar.f(C2547c.RANDOM_NUMBER, this.f23851h.nextInt(DefaultOggSeeker.MATCH_BYTE_RANGE));
        dVar.h(C2547c.DATETIME_OF_REQUEST, new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.US).format(new Date()));
        dVar.h(C2547c.SEND_IMAGE, "0");
        C2547c cVar = C2547c.VISITOR_ID;
        dVar.h(cVar, this.f23852i.a(cVar));
        C2547c cVar2 = C2547c.USER_ID;
        dVar.h(cVar2, this.f23852i.a(cVar2));
        C2547c cVar3 = C2547c.SCREEN_RESOLUTION;
        dVar.h(cVar3, this.f23852i.a(cVar3));
        C2547c cVar4 = C2547c.USER_AGENT;
        dVar.h(cVar4, this.f23852i.a(cVar4));
        C2547c cVar5 = C2547c.LANGUAGE;
        dVar.h(cVar5, this.f23852i.a(cVar5));
        C2547c cVar6 = C2547c.URL_PATH;
        String a5 = dVar.a(cVar6);
        if (a5 == null) {
            a5 = this.f23852i.a(cVar6);
        } else if (!f23842r.matcher(a5).matches()) {
            StringBuilder sb = new StringBuilder(this.f23847d);
            if (!this.f23847d.endsWith("/") && !a5.startsWith("/")) {
                sb.append("/");
            } else if (this.f23847d.endsWith("/") && a5.startsWith("/")) {
                a5 = a5.substring(1);
            }
            sb.append(a5);
            a5 = sb.toString();
        }
        this.f23852i.c(cVar6, a5);
        dVar.c(cVar6, a5);
    }

    private void i(C2548d dVar) {
        long j4;
        long j5;
        long j6;
        C2548d dVar2 = dVar;
        SharedPreferences g4 = g();
        synchronized (g4) {
            try {
                SharedPreferences.Editor edit = g4.edit();
                j4 = g().getLong("tracker.visitcount", 0) + 1;
                edit.putLong("tracker.visitcount", j4);
                j5 = g4.getLong("tracker.firstvisit", -1);
                if (j5 == -1) {
                    j5 = System.currentTimeMillis() / 1000;
                    edit.putLong("tracker.firstvisit", j5);
                }
                j6 = g4.getLong("tracker.previousvisit", -1);
                edit.putLong("tracker.previousvisit", System.currentTimeMillis() / 1000);
                edit.apply();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        C2548d dVar3 = this.f23852i;
        C2547c cVar = C2547c.FIRST_VISIT_TIMESTAMP;
        dVar3.g(cVar, j5);
        C2548d dVar4 = this.f23852i;
        C2547c cVar2 = C2547c.TOTAL_NUMBER_OF_VISITS;
        dVar4.g(cVar2, j4);
        if (j6 != -1) {
            this.f23852i.g(C2547c.PREVIOUS_VISIT_TIMESTAMP, j6);
        }
        C2547c cVar3 = C2547c.SESSION_START;
        dVar2.h(cVar3, this.f23852i.a(cVar3));
        dVar2.h(cVar, this.f23852i.a(cVar));
        dVar2.h(cVar2, this.f23852i.a(cVar2));
        C2547c cVar4 = C2547c.PREVIOUS_VISIT_TIMESTAMP;
        dVar2.h(cVar4, this.f23852i.a(cVar4));
    }

    public static String j() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }

    public String a() {
        return this.f23845b;
    }

    public C2553d b() {
        if (this.f23859p == null) {
            C2553d b5 = C2553d.b(g().getString("tracker.dispatcher.mode", (String) null));
            this.f23859p = b5;
            if (b5 == null) {
                this.f23859p = C2553d.ALWAYS;
            }
        }
        return this.f23859p;
    }

    public C2546b c() {
        return this.f23844a;
    }

    public String d() {
        return this.f23850g;
    }

    public long e() {
        return g().getLong("tracker.cache.age", 86400000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2549e eVar = (C2549e) obj;
        if (this.f23846c == eVar.f23846c && this.f23845b.equals(eVar.f23845b)) {
            return this.f23850g.equals(eVar.f23850g);
        }
        return false;
    }

    public long f() {
        return g().getLong("tracker.cache.size", 4194304);
    }

    public SharedPreferences g() {
        if (this.f23857n == null) {
            this.f23857n = this.f23844a.h(this);
        }
        return this.f23857n;
    }

    public int hashCode() {
        return (((this.f23845b.hashCode() * 31) + this.f23846c) * 31) + this.f23850g.hashCode();
    }

    public C2549e k(C2548d dVar) {
        synchronized (this.f23848e) {
            try {
                if (System.currentTimeMillis() - this.f23855l > this.f23854k) {
                    this.f23855l = System.currentTimeMillis();
                    i(dVar);
                }
                h(dVar);
                Iterator it = this.f23858o.iterator();
                if (!it.hasNext()) {
                    this.f23853j = dVar;
                    if (!this.f23856m) {
                        this.f23849f.b(dVar);
                        C2611a.b(f23841q).a("Event added to the queue: %s", dVar);
                    } else {
                        C2611a.b(f23841q).a("Event omitted due to opt out: %s", dVar);
                    }
                } else {
                    a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }
}
