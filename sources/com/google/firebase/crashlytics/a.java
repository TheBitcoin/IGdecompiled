package com.google.firebase.crashlytics;

import D0.b;
import S0.e;
import android.content.Context;
import android.content.pm.PackageManager;
import c1.C1648a;
import java.util.List;
import java.util.concurrent.ExecutorService;
import p0.C2194f;
import u0.C2304d;
import v0.d;
import v0.f;
import v0.g;
import v0.l;
import y0.C2412b;
import y0.C2417g;
import y0.C2420j;
import y0.C2424n;
import y0.C2433x;
import y0.D;
import y0.I;
import z0.C2446g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final C2433x f11175a;

    private a(C2433x xVar) {
        this.f11175a = xVar;
    }

    public static a b() {
        a aVar = (a) C2194f.l().j(a.class);
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    static a c(C2194f fVar, e eVar, R0.a aVar, R0.a aVar2, R0.a aVar3, ExecutorService executorService, ExecutorService executorService2) {
        Context k4 = fVar.k();
        String packageName = k4.getPackageName();
        g f4 = g.f();
        f4.g("Initializing Firebase Crashlytics " + C2433x.k() + " for " + packageName);
        C2446g gVar = new C2446g(executorService, executorService2);
        E0.g gVar2 = new E0.g(k4);
        C2194f fVar2 = fVar;
        D d5 = new D(fVar2);
        I i4 = new I(k4, packageName, eVar, d5);
        d dVar = new d(aVar);
        C2304d dVar2 = new C2304d(aVar2);
        C2424n nVar = new C2424n(d5, gVar2);
        C1648a.e(nVar);
        I i5 = i4;
        D d6 = d5;
        d dVar3 = dVar;
        C2433x xVar = new C2433x(fVar2, i5, dVar3, d6, dVar2.e(), dVar2.d(), gVar2, nVar, new l(aVar3), gVar);
        D d7 = d6;
        C2433x xVar2 = xVar;
        String c5 = fVar.n().c();
        String m4 = C2420j.m(k4);
        List<C2417g> j4 = C2420j.j(k4);
        g f5 = g.f();
        f5.b("Mapping file ID is: " + m4);
        for (C2417g gVar3 : j4) {
            g.f().b(String.format("Build id for %s on %s: %s", new Object[]{gVar3.c(), gVar3.a(), gVar3.b()}));
        }
        Context context = k4;
        String str = c5;
        I i6 = i4;
        try {
            C2412b a5 = C2412b.a(context, i6, str, m4, j4, new f(k4));
            g f6 = g.f();
            f6.i("Installer package name is: " + a5.f22621d);
            G0.g l4 = G0.g.l(context, str, i6, new b(), a5.f22623f, a5.f22624g, gVar2, d7);
            l4.p(gVar).e(new u0.g());
            if (xVar2.p(a5, l4)) {
                xVar2.i(l4);
            }
            return new a(xVar2);
        } catch (PackageManager.NameNotFoundException e5) {
            g.f().e("Error retrieving app package info.", e5);
            return null;
        }
    }

    public void d(boolean z4) {
        this.f11175a.q(Boolean.valueOf(z4));
    }
}
