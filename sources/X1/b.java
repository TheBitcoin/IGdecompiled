package x1;

import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import q1.n;
import t1.C2286c;
import t1.C2288e;
import w1.C2342i;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f22068a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f22069b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f22070c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet f22071d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet f22072e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet f22073f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap f22074g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final HashSet f22075h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private final Map f22076i = new WeakHashMap();

    /* renamed from: j  reason: collision with root package name */
    private boolean f22077j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2288e f22078a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f22079b = new ArrayList();

        public a(C2288e eVar, String str) {
            this.f22078a = eVar;
            b(str);
        }

        public C2288e a() {
            return this.f22078a;
        }

        public void b(String str) {
            this.f22079b.add(str);
        }

        public ArrayList c() {
            return this.f22079b;
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f22076i.remove(view);
            return Boolean.FALSE;
        } else if (this.f22076i.containsKey(view)) {
            return (Boolean) this.f22076i.get(view);
        } else {
            Map map = this.f22076i;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    private String c(View view, boolean z4) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue() && !z4) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String a5 = C2342i.a(view);
            if (a5 != null) {
                return a5;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        this.f22071d.addAll(hashSet);
        return null;
    }

    private void e(n nVar) {
        for (C2288e f4 : nVar.o()) {
            f(f4, nVar);
        }
    }

    private void f(C2288e eVar, n nVar) {
        View view = (View) eVar.c().get();
        if (view != null) {
            a aVar = (a) this.f22069b.get(view);
            if (aVar != null) {
                aVar.b(nVar.s());
            } else {
                this.f22069b.put(view, new a(eVar, nVar.s()));
            }
        }
    }

    public View a(String str) {
        return (View) this.f22070c.get(str);
    }

    public void d() {
        this.f22068a.clear();
        this.f22069b.clear();
        this.f22070c.clear();
        this.f22071d.clear();
        this.f22072e.clear();
        this.f22073f.clear();
        this.f22074g.clear();
        this.f22077j = false;
        this.f22075h.clear();
    }

    public String g(String str) {
        return (String) this.f22074g.get(str);
    }

    public HashSet h() {
        return this.f22073f;
    }

    public a i(View view) {
        a aVar = (a) this.f22069b.get(view);
        if (aVar != null) {
            this.f22069b.remove(view);
        }
        return aVar;
    }

    public String j(View view) {
        if (this.f22068a.size() == 0) {
            return null;
        }
        String str = (String) this.f22068a.get(view);
        if (str != null) {
            this.f22068a.remove(view);
        }
        return str;
    }

    public HashSet k() {
        return this.f22072e;
    }

    public boolean l(String str) {
        return this.f22075h.contains(str);
    }

    public d m(View view) {
        if (this.f22071d.contains(view)) {
            return d.PARENT_VIEW;
        }
        if (this.f22077j) {
            return d.OBSTRUCTION_VIEW;
        }
        return d.UNDERLYING_VIEW;
    }

    public void n() {
        this.f22077j = true;
    }

    public void o() {
        C2286c e5 = C2286c.e();
        if (e5 != null) {
            for (n nVar : e5.a()) {
                View n4 = nVar.n();
                if (nVar.q()) {
                    String s4 = nVar.s();
                    if (n4 != null) {
                        boolean e6 = C2342i.e(n4);
                        if (e6) {
                            this.f22075h.add(s4);
                        }
                        String c5 = c(n4, e6);
                        if (c5 == null) {
                            this.f22072e.add(s4);
                            this.f22068a.put(n4, s4);
                            e(nVar);
                        } else if (c5 != "noWindowFocus") {
                            this.f22073f.add(s4);
                            this.f22070c.put(s4, n4);
                            this.f22074g.put(s4, c5);
                        }
                    } else {
                        this.f22073f.add(s4);
                        this.f22074g.put(s4, "noAdView");
                    }
                }
            }
        }
    }

    public boolean p(View view) {
        if (!this.f22076i.containsKey(view)) {
            return true;
        }
        this.f22076i.put(view, Boolean.TRUE);
        return false;
    }
}
