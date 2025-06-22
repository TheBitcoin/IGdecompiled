package com.google.firebase.crashlytics;

import S0.e;
import Z0.h;
import a1.C1613a;
import c1.C1648a;
import c1.C1649b;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import p0.C2194f;
import q0.C2204a;
import r0.C2213a;
import r0.C2214b;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.r;
import u0.C2306f;
import v0.C2327a;
import v0.g;
import z0.C2446g;

public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    private final C2264F f11173a;

    /* renamed from: b  reason: collision with root package name */
    private final C2264F f11174b;

    static {
        C1648a.a(C1649b.a.CRASHLYTICS);
    }

    public CrashlyticsRegistrar() {
        Class<ExecutorService> cls = ExecutorService.class;
        this.f11173a = C2264F.a(C2213a.class, cls);
        this.f11174b = C2264F.a(C2214b.class, cls);
    }

    /* access modifiers changed from: private */
    public a b(C2270e eVar) {
        C2446g.f(false);
        long currentTimeMillis = System.currentTimeMillis();
        a c5 = a.c((C2194f) eVar.a(C2194f.class), (e) eVar.a(e.class), eVar.i(C2327a.class), eVar.i(C2204a.class), eVar.i(C1613a.class), (ExecutorService) eVar.h(this.f11173a), (ExecutorService) eVar.h(this.f11174b));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 16) {
            g f4 = g.f();
            f4.b("Initializing Crashlytics blocked main for " + currentTimeMillis2 + " ms");
        }
        return c5;
    }

    public List getComponents() {
        return Arrays.asList(new C2268c[]{C2268c.c(a.class).h("fire-cls").b(r.k(C2194f.class)).b(r.k(e.class)).b(r.l(this.f11173a)).b(r.l(this.f11174b)).b(r.a(C2327a.class)).b(r.a(C2204a.class)).b(r.a(C1613a.class)).f(new C2306f(this)).e().d(), h.b("fire-cls", "19.2.1")});
    }
}
