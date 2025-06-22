package M0;

import K0.C1492a;
import K0.C1493b;
import K0.C1495d;
import K0.C1496e;
import K0.C1497f;
import K0.C1498g;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class d implements L0.b {

    /* renamed from: e  reason: collision with root package name */
    private static final C1495d f7383e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final C1497f f7384f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final C1497f f7385g = new c();

    /* renamed from: h  reason: collision with root package name */
    private static final b f7386h = new b((a) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map f7387a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f7388b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1495d f7389c = f7383e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f7390d = false;

    class a implements C1492a {
        a() {
        }

        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f7387a, d.this.f7388b, d.this.f7389c, d.this.f7390d);
            eVar.k(obj, false);
            eVar.u();
        }

        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    private static final class b implements C1497f {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f7392a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f7392a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* renamed from: b */
        public void a(Date date, C1498g gVar) {
            gVar.b(f7392a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f7384f);
        m(Boolean.class, f7385g);
        m(Date.class, f7386h);
    }

    public static /* synthetic */ void c(Object obj, C1496e eVar) {
        throw new C1493b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public C1492a i() {
        return new a();
    }

    public d j(L0.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z4) {
        this.f7390d = z4;
        return this;
    }

    /* renamed from: l */
    public d a(Class cls, C1495d dVar) {
        this.f7387a.put(cls, dVar);
        this.f7388b.remove(cls);
        return this;
    }

    public d m(Class cls, C1497f fVar) {
        this.f7388b.put(cls, fVar);
        this.f7387a.remove(cls);
        return this;
    }
}
