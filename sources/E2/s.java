package E2;

import A2.a;
import C2.b;
import S2.C1594h;
import b.c;
import b4.d;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import j$.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import z3.e;
import z3.l;

public final class s {

    /* renamed from: A  reason: collision with root package name */
    public Vector f6384A;

    /* renamed from: B  reason: collision with root package name */
    public Vector f6385B;

    /* renamed from: C  reason: collision with root package name */
    public Vector f6386C;

    /* renamed from: D  reason: collision with root package name */
    public Vector f6387D;

    /* renamed from: E  reason: collision with root package name */
    public Vector f6388E;

    /* renamed from: F  reason: collision with root package name */
    public Vector f6389F;

    /* renamed from: G  reason: collision with root package name */
    public j f6390G;

    /* renamed from: a  reason: collision with root package name */
    public e f6391a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f6392b;

    /* renamed from: c  reason: collision with root package name */
    public long f6393c;

    /* renamed from: d  reason: collision with root package name */
    public ZonedDateTime f6394d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6395e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6396f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6397g;

    /* renamed from: h  reason: collision with root package name */
    public String f6398h = "AA";

    /* renamed from: i  reason: collision with root package name */
    public int f6399i = 2;

    /* renamed from: j  reason: collision with root package name */
    public int f6400j;

    /* renamed from: k  reason: collision with root package name */
    public int f6401k = 2;

    /* renamed from: l  reason: collision with root package name */
    public String f6402l = "EN";

    /* renamed from: m  reason: collision with root package name */
    public int f6403m = 10;

    /* renamed from: n  reason: collision with root package name */
    public int f6404n = 2021;

    /* renamed from: o  reason: collision with root package name */
    public int f6405o;

    /* renamed from: p  reason: collision with root package name */
    public int f6406p;

    /* renamed from: q  reason: collision with root package name */
    public Vector f6407q = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: r  reason: collision with root package name */
    public Vector f6408r = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: s  reason: collision with root package name */
    public Vector f6409s = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: t  reason: collision with root package name */
    public Vector f6410t = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: u  reason: collision with root package name */
    public Vector f6411u = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: v  reason: collision with root package name */
    public Vector f6412v = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: w  reason: collision with root package name */
    public Vector f6413w = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: x  reason: collision with root package name */
    public Vector f6414x = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: y  reason: collision with root package name */
    public Vector f6415y = new Vector((Map) null, 1, (C2103g) null);

    /* renamed from: z  reason: collision with root package name */
    public Vector f6416z;

    public s(e eVar) {
        new LinkedHashSet();
        this.f6416z = new Vector((Map) null, 1, (C2103g) null);
        this.f6384A = new Vector((Map) null, 1, (C2103g) null);
        this.f6385B = new Vector((Map) null, 1, (C2103g) null);
        this.f6386C = new Vector((Map) null, 1, (C2103g) null);
        this.f6387D = new Vector((Map) null, 1, (C2103g) null);
        this.f6388E = new Vector((Map) null, 1, (C2103g) null);
        this.f6389F = new Vector((Map) null, 1, (C2103g) null);
        this.f6390G = new j(this.f6391a, (List) null, (List) null, (Map) null, 14);
    }

    public static final boolean c(s sVar, l lVar) {
        sVar.getClass();
        List list = d.f24465a.j().f170b.f137j;
        Set<Number> set = lVar.f4820e;
        if (b.l.a(set) && set.isEmpty()) {
            return false;
        }
        for (Number a5 : set) {
            if (c.a(a5, list)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(s sVar, l lVar) {
        sVar.getClass();
        List list = d.f24465a.j().f170b.f135h;
        Set<Number> set = lVar.f4819d;
        if (b.l.a(set) && set.isEmpty()) {
            return false;
        }
        for (Number a5 : set) {
            if (c.a(a5, list)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean g(s sVar, l lVar) {
        sVar.getClass();
        List list = d.f24465a.j().f170b.f139l;
        Set<Number> set = lVar.f4822g;
        if (b.l.a(set) && set.isEmpty()) {
            return false;
        }
        for (Number a5 : set) {
            if (c.a(a5, list)) {
                return true;
            }
        }
        return false;
    }

    public final int a() {
        return this.f6403m;
    }

    public final void b(String str) {
        String str2;
        m.e(str, "value");
        String[] iSOCountries = Locale.getISOCountries();
        m.d(iSOCountries, "getISOCountries()");
        Locale locale = Locale.getDefault();
        m.d(locale, "getDefault()");
        String upperCase = str.toUpperCase(locale);
        m.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        if (C1594h.o(iSOCountries, upperCase)) {
            Locale locale2 = Locale.getDefault();
            m.d(locale2, "getDefault()");
            String upperCase2 = str.toUpperCase(locale2);
            m.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
            this.f6398h = upperCase2;
            return;
        }
        u uVar = new u("publisherCountryCode", str, "");
        b bVar = b.f6277a;
        ChoiceError choiceError = ChoiceError.TC_MODEL_PROPERTY_ERROR;
        m.d("f.s", "TAG");
        String message = uVar.getMessage();
        if (message == null) {
            str2 = "";
        } else {
            str2 = message;
        }
        bVar.b(choiceError, "f.s", str2, C2.c.CONSOLE_AND_CALLBACK, uVar);
    }

    public final int d() {
        return this.f6404n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof s) && m.a(this.f6391a, ((s) obj).f6391a)) {
            return true;
        }
        return false;
    }

    public final int f() {
        Integer num;
        e eVar = this.f6391a;
        if (eVar == null) {
            num = null;
        } else {
            num = eVar.f4802c;
        }
        if (num == null) {
            return this.f6401k;
        }
        return num.intValue();
    }

    public final Vector h() {
        return this.f6412v;
    }

    public int hashCode() {
        e eVar = this.f6391a;
        if (eVar == null) {
            return 0;
        }
        return eVar.hashCode();
    }

    public final String i() {
        return this.f6398h;
    }

    public final Vector j() {
        return this.f6414x;
    }

    public final Vector k() {
        return this.f6415y;
    }

    public final Vector l() {
        return this.f6413w;
    }

    public final j m() {
        return this.f6390G;
    }

    public final Vector n() {
        return this.f6408r;
    }

    public final Vector o() {
        return this.f6409s;
    }

    public final boolean p() {
        return this.f6397g;
    }

    public final Vector q() {
        return this.f6407q;
    }

    public final boolean r() {
        return this.f6396f;
    }

    public final Vector s() {
        return this.f6416z;
    }

    public final Vector t() {
        return this.f6386C;
    }

    public String toString() {
        StringBuilder a5 = a.a("TCModel(gvl=");
        a5.append(this.f6391a);
        a5.append(')');
        return a5.toString();
    }

    public final Vector u() {
        return this.f6389F;
    }

    public final Vector v() {
        return this.f6388E;
    }

    public final boolean w() {
        return this.f6395e;
    }

    public final void x() {
        this.f6385B.setAllOwnedItems();
        this.f6416z.forEach(new o(this));
        this.f6408r.setAllOwnedItems();
        this.f6409s.setAllOwnedItems();
        this.f6407q.setAllOwnedItems();
        this.f6386C.forEach(new p(this));
        this.f6384A.forEach(new n(this));
        this.f6387D.setAllOwnedItems();
    }
}
