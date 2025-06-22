package x1;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.a;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import q1.n;
import t1.C2286c;
import t1.k;
import u1.C2307a;
import u1.C2308b;
import w1.C2336c;
import w1.C2339f;
import w1.C2342i;
import x1.b;
import z1.C2447a;

/* renamed from: x1.a  reason: case insensitive filesystem */
public class C2349a implements C2307a.C0268a {

    /* renamed from: i  reason: collision with root package name */
    private static C2349a f22054i = new C2349a();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f22055j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Handler f22056k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f22057l = new b();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f22058m = new c();

    /* renamed from: a  reason: collision with root package name */
    private List f22059a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f22060b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22061c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List f22062d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private C2308b f22063e = new C2308b();

    /* renamed from: f  reason: collision with root package name */
    private b f22064f = new b();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public c f22065g = new c(new y1.c());

    /* renamed from: h  reason: collision with root package name */
    private long f22066h;

    /* renamed from: x1.a$a  reason: collision with other inner class name */
    class C0272a implements Runnable {
        C0272a() {
        }

        public void run() {
            C2349a.this.f22065g.c();
        }
    }

    /* renamed from: x1.a$b */
    class b implements Runnable {
        b() {
        }

        public void run() {
            C2349a.p().u();
        }
    }

    /* renamed from: x1.a$c */
    class c implements Runnable {
        c() {
        }

        public void run() {
            if (C2349a.f22056k != null) {
                C2349a.f22056k.post(C2349a.f22057l);
                C2349a.f22056k.postDelayed(C2349a.f22058m, 200);
            }
        }
    }

    C2349a() {
    }

    private void d(long j4) {
        if (this.f22059a.size() > 0) {
            Iterator it = this.f22059a.iterator();
            if (it.hasNext()) {
                a.a(it.next());
                TimeUnit.NANOSECONDS.toMillis(j4);
                throw null;
            }
        }
    }

    private void e(View view, C2307a aVar, JSONObject jSONObject, d dVar, boolean z4) {
        boolean z5;
        if (dVar == d.PARENT_VIEW) {
            z5 = true;
        } else {
            z5 = false;
        }
        aVar.a(view, jSONObject, this, z5, z4);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        C2307a b5 = this.f22063e.b();
        String g4 = this.f22064f.g(str);
        if (g4 != null) {
            JSONObject a5 = b5.a(view);
            C2336c.f(a5, str);
            C2336c.o(a5, g4);
            C2336c.h(jSONObject, a5);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        b.a i4 = this.f22064f.i(view);
        if (i4 == null) {
            return false;
        }
        C2336c.j(jSONObject, i4);
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j4 = this.f22064f.j(view);
        if (j4 == null) {
            return false;
        }
        C2336c.f(jSONObject, j4);
        C2336c.e(jSONObject, Boolean.valueOf(this.f22064f.p(view)));
        C2336c.n(jSONObject, Boolean.valueOf(this.f22064f.l(j4)));
        this.f22064f.n();
        return true;
    }

    private void l() {
        d(C2339f.b() - this.f22066h);
    }

    private void m() {
        this.f22060b = 0;
        this.f22062d.clear();
        this.f22061c = false;
        Iterator it = C2286c.e().a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((n) it.next()).p()) {
                    this.f22061c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f22066h = C2339f.b();
    }

    public static C2349a p() {
        return f22054i;
    }

    private void r() {
        if (f22056k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f22056k = handler;
            handler.post(f22057l);
            f22056k.postDelayed(f22058m, 200);
        }
    }

    private void t() {
        Handler handler = f22056k;
        if (handler != null) {
            handler.removeCallbacks(f22058m);
            f22056k = null;
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        k.f().a();
    }

    public void a(View view, C2307a aVar, JSONObject jSONObject, boolean z4) {
        d m4;
        C2349a aVar2;
        boolean z5;
        if (C2342i.f(view) && (m4 = this.f22064f.m(view)) != d.UNDERLYING_VIEW) {
            JSONObject a5 = aVar.a(view);
            C2336c.h(jSONObject, a5);
            if (!j(view, a5)) {
                boolean g4 = g(view, a5);
                if (z4 || g4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (this.f22061c && m4 == d.OBSTRUCTION_VIEW && !z5) {
                    this.f22062d.add(new C2447a(view));
                }
                aVar2 = this;
                aVar2.e(view, aVar, a5, m4, z5);
            } else {
                aVar2 = this;
            }
            aVar2.f22060b++;
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        C2349a aVar;
        this.f22064f.o();
        long b5 = C2339f.b();
        C2307a a5 = this.f22063e.a();
        if (this.f22064f.h().size() > 0) {
            Iterator it = this.f22064f.h().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a6 = a5.a((View) null);
                f(str, this.f22064f.a(str), a6);
                C2336c.m(a6);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f22065g.b(a6, hashSet, b5);
            }
        }
        if (this.f22064f.k().size() > 0) {
            JSONObject a7 = a5.a((View) null);
            aVar = this;
            aVar.e((View) null, a5, a7, d.PARENT_VIEW, false);
            C2336c.m(a7);
            aVar.f22065g.d(a7, aVar.f22064f.k(), b5);
            if (aVar.f22061c) {
                for (n j4 : C2286c.e().a()) {
                    j4.j(aVar.f22062d);
                }
            }
        } else {
            aVar = this;
            aVar.f22065g.c();
        }
        aVar.f22064f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f22059a.clear();
        f22055j.post(new C0272a());
    }
}
