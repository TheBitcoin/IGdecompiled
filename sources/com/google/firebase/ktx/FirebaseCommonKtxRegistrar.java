package com.google.firebase.ktx;

import S2.C1601o;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;
import o3.C0986k0;
import o3.G;
import r0.C2213a;
import r0.C2214b;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.h;
import s0.r;

@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    public static final class a implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final a f11213a = new a();

        /* renamed from: b */
        public final G a(C2270e eVar) {
            Object h4 = eVar.h(C2264F.a(C2213a.class, Executor.class));
            m.d(h4, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return C0986k0.a((Executor) h4);
        }
    }

    public static final class b implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11214a = new b();

        /* renamed from: b */
        public final G a(C2270e eVar) {
            Object h4 = eVar.h(C2264F.a(r0.c.class, Executor.class));
            m.d(h4, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return C0986k0.a((Executor) h4);
        }
    }

    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final c f11215a = new c();

        /* renamed from: b */
        public final G a(C2270e eVar) {
            Object h4 = eVar.h(C2264F.a(C2214b.class, Executor.class));
            m.d(h4, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return C0986k0.a((Executor) h4);
        }
    }

    public static final class d implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final d f11216a = new d();

        /* renamed from: b */
        public final G a(C2270e eVar) {
            Object h4 = eVar.h(C2264F.a(r0.d.class, Executor.class));
            m.d(h4, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return C0986k0.a((Executor) h4);
        }
    }

    public List<C2268c> getComponents() {
        Class<C2213a> cls = C2213a.class;
        Class<G> cls2 = G.class;
        Class<Executor> cls3 = Executor.class;
        C2268c d5 = C2268c.e(C2264F.a(cls, cls2)).b(r.l(C2264F.a(cls, cls3))).f(a.f11213a).d();
        m.d(d5, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<r0.c> cls4 = r0.c.class;
        C2268c d6 = C2268c.e(C2264F.a(cls4, cls2)).b(r.l(C2264F.a(cls4, cls3))).f(b.f11214a).d();
        m.d(d6, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<C2214b> cls5 = C2214b.class;
        C2268c d7 = C2268c.e(C2264F.a(cls5, cls2)).b(r.l(C2264F.a(cls5, cls3))).f(c.f11215a).d();
        m.d(d7, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<r0.d> cls6 = r0.d.class;
        C2268c d8 = C2268c.e(C2264F.a(cls6, cls2)).b(r.l(C2264F.a(cls6, cls3))).f(d.f11216a).d();
        m.d(d8, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return C1601o.k(d5, d6, d7, d8);
    }
}
