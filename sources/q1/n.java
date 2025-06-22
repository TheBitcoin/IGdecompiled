package q1;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
import t1.C2284a;
import t1.C2286c;
import t1.C2289f;
import t1.C2292i;
import v1.C2329a;
import v1.b;
import v1.c;
import w1.C2340g;
import z1.C2447a;

public class n extends C2206b {

    /* renamed from: a  reason: collision with root package name */
    private final d f21564a;

    /* renamed from: b  reason: collision with root package name */
    private final C2207c f21565b;

    /* renamed from: c  reason: collision with root package name */
    private final C2289f f21566c;

    /* renamed from: d  reason: collision with root package name */
    private C2447a f21567d;

    /* renamed from: e  reason: collision with root package name */
    private C2329a f21568e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21569f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21570g;

    /* renamed from: h  reason: collision with root package name */
    private final String f21571h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21572i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f21573j;

    n(C2207c cVar, d dVar) {
        this(cVar, dVar, UUID.randomUUID().toString());
    }

    private void h() {
        if (this.f21572i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void i(View view) {
        Collection<n> c5 = C2286c.e().c();
        if (c5 != null && !c5.isEmpty()) {
            for (n nVar : c5) {
                if (nVar != this && nVar.n() == view) {
                    nVar.f21567d.clear();
                }
            }
        }
    }

    private void l() {
        if (this.f21573j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void m(View view) {
        this.f21567d = new C2447a(view);
    }

    public void a(View view, h hVar, String str) {
        if (!this.f21570g) {
            this.f21566c.c(view, hVar, str);
        }
    }

    public void c() {
        if (!this.f21570g) {
            this.f21567d.clear();
            e();
            this.f21570g = true;
            t().u();
            C2286c.e().d(this);
            t().o();
            this.f21568e = null;
        }
    }

    public void d(View view) {
        if (!this.f21570g) {
            C2340g.b(view, "AdView is null");
            if (n() != view) {
                m(view);
                t().a();
                i(view);
            }
        }
    }

    public void e() {
        if (!this.f21570g) {
            this.f21566c.f();
        }
    }

    public void f(View view) {
        if (!this.f21570g) {
            this.f21566c.g(view);
        }
    }

    public void g() {
        if (!this.f21569f) {
            this.f21569f = true;
            C2286c.e().f(this);
            this.f21568e.b(C2292i.d().c());
            this.f21568e.g(C2284a.a().c());
            this.f21568e.k(this, this.f21564a);
        }
    }

    public void j(List list) {
        if (p()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view = (View) ((C2447a) it.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public void k(JSONObject jSONObject) {
        l();
        t().h(jSONObject);
        this.f21573j = true;
    }

    public View n() {
        return (View) this.f21567d.get();
    }

    public List o() {
        return this.f21566c.a();
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        if (!this.f21569f || this.f21570g) {
            return false;
        }
        return true;
    }

    public boolean r() {
        return this.f21570g;
    }

    public String s() {
        return this.f21571h;
    }

    public C2329a t() {
        return this.f21568e;
    }

    public boolean u() {
        return this.f21565b.b();
    }

    public boolean v() {
        return this.f21565b.c();
    }

    public boolean w() {
        return this.f21569f;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        h();
        t().v();
        this.f21572i = true;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        l();
        t().x();
        this.f21573j = true;
    }

    n(C2207c cVar, d dVar, String str) {
        this.f21566c = new C2289f();
        this.f21569f = false;
        this.f21570g = false;
        this.f21565b = cVar;
        this.f21564a = dVar;
        this.f21571h = str;
        m((View) null);
        this.f21568e = (dVar.c() == e.HTML || dVar.c() == e.JAVASCRIPT) ? new b(str, dVar.j()) : new c(str, dVar.f(), dVar.g());
        this.f21568e.y();
        C2286c.e().b(this);
        this.f21568e.j(cVar);
    }
}
