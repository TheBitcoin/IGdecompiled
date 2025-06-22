package g2;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: g2.b  reason: case insensitive filesystem */
public final class C2044b {

    /* renamed from: j  reason: collision with root package name */
    public static final a f20534j = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20535a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f20536b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f20537c;

    /* renamed from: d  reason: collision with root package name */
    private String f20538d;

    /* renamed from: e  reason: collision with root package name */
    private String f20539e;

    /* renamed from: f  reason: collision with root package name */
    private String f20540f;

    /* renamed from: g  reason: collision with root package name */
    private String f20541g;

    /* renamed from: h  reason: collision with root package name */
    private String f20542h;

    /* renamed from: i  reason: collision with root package name */
    private String f20543i;

    /* renamed from: g2.b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final String e() {
        int i4 = this.f20536b;
        if (i4 == 1) {
            return "NEW_UPDATE";
        }
        if (i4 == 3) {
            return "DOWNLOADED_UPDATE";
        }
        if (i4 != 4) {
            return "Unknown";
        }
        return "INSTALLED_UPDATE";
    }

    public final String a() {
        return this.f20537c;
    }

    public final String b() {
        return this.f20542h;
    }

    public final String c() {
        return this.f20543i;
    }

    public final int d() {
        return this.f20536b;
    }

    public final String f() {
        return this.f20541g;
    }

    public final String g() {
        return this.f20540f;
    }

    public final String h() {
        return this.f20539e;
    }

    public final String i() {
        return this.f20538d;
    }

    public final void j(C2048f fVar, S s4, t tVar) {
        long j4;
        m.e(fVar, "appStored");
        m.e(s4, "update");
        m.e(tVar, "dbManager");
        C2044b bVar = new C2044b();
        bVar.f20537c = fVar.o();
        bVar.f20536b = 3;
        bVar.f20540f = String.valueOf(fVar.A());
        bVar.f20541g = String.valueOf(s4.j());
        bVar.f20538d = fVar.B();
        bVar.f20539e = s4.k();
        if (s4.a() != null) {
            C2060s a5 = s4.a();
            m.b(a5);
            j4 = a5.z();
        } else {
            j4 = 0;
        }
        bVar.f20542h = String.valueOf(j4);
        bVar.f20543i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        tVar.I0(bVar);
    }

    public final void k(C2048f fVar, t tVar) {
        m.e(fVar, "appUpdated");
        m.e(tVar, "dbManager");
        C2044b bVar = new C2044b();
        bVar.f20537c = fVar.o();
        bVar.f20536b = 4;
        bVar.f20541g = String.valueOf(fVar.A());
        bVar.f20539e = fVar.B();
        bVar.f20543i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        tVar.I0(bVar);
    }

    public final void l(C2048f fVar, S s4, t tVar) {
        long j4;
        m.e(fVar, "appStored");
        m.e(s4, "update");
        m.e(tVar, "dbManager");
        C2044b bVar = new C2044b();
        bVar.f20537c = fVar.o();
        bVar.f20536b = 1;
        bVar.f20540f = String.valueOf(fVar.A());
        bVar.f20541g = String.valueOf(s4.j());
        bVar.f20538d = fVar.B();
        bVar.f20539e = s4.k();
        if (s4.a() != null) {
            C2060s a5 = s4.a();
            m.b(a5);
            j4 = a5.z();
        } else {
            j4 = 0;
        }
        bVar.f20542h = String.valueOf(j4);
        bVar.f20543i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        tVar.I0(bVar);
    }

    public String toString() {
        return "{id=" + this.f20535a + ", type=" + this.f20536b + ", typeReadable=" + e() + ", packageName=" + this.f20537c + ", versionNameOld=" + this.f20538d + ", versionNameNew=" + this.f20539e + ", versionCodeOld=" + this.f20540f + ", versionCodeNew=" + this.f20541g + ", size=" + this.f20542h + ", timestamp=" + this.f20543i + '}';
    }
}
