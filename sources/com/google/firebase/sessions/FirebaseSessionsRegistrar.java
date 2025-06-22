package com.google.firebase.sessions;

import R0.b;
import S0.e;
import S2.C1601o;
import V2.g;
import Z0.h;
import android.content.Context;
import androidx.annotation.Keep;
import b1.C;
import b1.C1625h;
import b1.H;
import b1.K;
import b1.l;
import b1.n;
import b1.o;
import b1.p;
import b1.q;
import b1.s;
import b1.y;
import com.google.firebase.components.ComponentRegistrar;
import d1.f;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o.j;
import o3.G;
import p0.C2194f;
import r0.C2213a;
import r0.C2214b;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.r;

@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final a Companion = new a((C2103g) null);
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final C2264F backgroundDispatcher;
    private static final C2264F blockingDispatcher;
    private static final C2264F firebaseApp;
    private static final C2264F firebaseInstallationsApi;
    private static final C2264F sessionLifecycleServiceBinder;
    private static final C2264F sessionsSettings;
    private static final C2264F transportFactory;

    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static {
        C2264F b5 = C2264F.b(C2194f.class);
        m.d(b5, "unqualified(FirebaseApp::class.java)");
        firebaseApp = b5;
        C2264F b6 = C2264F.b(e.class);
        m.d(b6, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = b6;
        Class<G> cls = G.class;
        C2264F a5 = C2264F.a(C2213a.class, cls);
        m.d(a5, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = a5;
        C2264F a6 = C2264F.a(C2214b.class, cls);
        m.d(a6, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = a6;
        C2264F b7 = C2264F.b(j.class);
        m.d(b7, "unqualified(TransportFactory::class.java)");
        transportFactory = b7;
        C2264F b8 = C2264F.b(f.class);
        m.d(b8, "unqualified(SessionsSettings::class.java)");
        sessionsSettings = b8;
        C2264F b9 = C2264F.b(b1.G.class);
        m.d(b9, "unqualified(SessionLifec…erviceBinder::class.java)");
        sessionLifecycleServiceBinder = b9;
    }

    /* access modifiers changed from: private */
    public static final l getComponents$lambda$0(C2270e eVar) {
        Object h4 = eVar.h(firebaseApp);
        m.d(h4, "container[firebaseApp]");
        Object h5 = eVar.h(sessionsSettings);
        m.d(h5, "container[sessionsSettings]");
        Object h6 = eVar.h(backgroundDispatcher);
        m.d(h6, "container[backgroundDispatcher]");
        Object h7 = eVar.h(sessionLifecycleServiceBinder);
        m.d(h7, "container[sessionLifecycleServiceBinder]");
        return new l((C2194f) h4, (f) h5, (g) h6, (b1.G) h7);
    }

    /* access modifiers changed from: private */
    public static final c getComponents$lambda$1(C2270e eVar) {
        return new c(K.f8968a, (d3.a) null, 2, (C2103g) null);
    }

    /* access modifiers changed from: private */
    public static final b getComponents$lambda$2(C2270e eVar) {
        Object h4 = eVar.h(firebaseApp);
        m.d(h4, "container[firebaseApp]");
        Object h5 = eVar.h(firebaseInstallationsApi);
        m.d(h5, "container[firebaseInstallationsApi]");
        Object h6 = eVar.h(sessionsSettings);
        m.d(h6, "container[sessionsSettings]");
        b g4 = eVar.g(transportFactory);
        m.d(g4, "container.getProvider(transportFactory)");
        C1625h hVar = new C1625h(g4);
        Object h7 = eVar.h(backgroundDispatcher);
        m.d(h7, "container[backgroundDispatcher]");
        return new C((C2194f) h4, (e) h5, (f) h6, hVar, (g) h7);
    }

    /* access modifiers changed from: private */
    public static final f getComponents$lambda$3(C2270e eVar) {
        Object h4 = eVar.h(firebaseApp);
        m.d(h4, "container[firebaseApp]");
        Object h5 = eVar.h(blockingDispatcher);
        m.d(h5, "container[blockingDispatcher]");
        Object h6 = eVar.h(backgroundDispatcher);
        m.d(h6, "container[backgroundDispatcher]");
        Object h7 = eVar.h(firebaseInstallationsApi);
        m.d(h7, "container[firebaseInstallationsApi]");
        return new f((C2194f) h4, (g) h5, (g) h6, (e) h7);
    }

    /* access modifiers changed from: private */
    public static final a getComponents$lambda$4(C2270e eVar) {
        Context k4 = ((C2194f) eVar.h(firebaseApp)).k();
        m.d(k4, "container[firebaseApp].applicationContext");
        Object h4 = eVar.h(backgroundDispatcher);
        m.d(h4, "container[backgroundDispatcher]");
        return new y(k4, (g) h4);
    }

    /* access modifiers changed from: private */
    public static final b1.G getComponents$lambda$5(C2270e eVar) {
        Object h4 = eVar.h(firebaseApp);
        m.d(h4, "container[firebaseApp]");
        return new H((C2194f) h4);
    }

    public List<C2268c> getComponents() {
        C2268c.b h4 = C2268c.c(l.class).h(LIBRARY_NAME);
        C2264F f4 = firebaseApp;
        C2268c.b b5 = h4.b(r.l(f4));
        C2264F f5 = sessionsSettings;
        C2268c.b b6 = b5.b(r.l(f5));
        C2264F f6 = backgroundDispatcher;
        C2268c d5 = b6.b(r.l(f6)).b(r.l(sessionLifecycleServiceBinder)).f(new n()).e().d();
        C2268c d6 = C2268c.c(c.class).h("session-generator").f(new o()).d();
        C2268c.b b7 = C2268c.c(b.class).h("session-publisher").b(r.l(f4));
        C2264F f7 = firebaseInstallationsApi;
        return C1601o.k(d5, d6, b7.b(r.l(f7)).b(r.l(f5)).b(r.n(transportFactory)).b(r.l(f6)).f(new p()).d(), C2268c.c(f.class).h("sessions-settings").b(r.l(f4)).b(r.l(blockingDispatcher)).b(r.l(f6)).b(r.l(f7)).f(new q()).d(), C2268c.c(a.class).h("sessions-datastore").b(r.l(f4)).b(r.l(f6)).f(new b1.r()).d(), C2268c.c(b1.G.class).h("sessions-service-binder").b(r.l(f4)).f(new s()).d(), h.b(LIBRARY_NAME, "2.0.6"));
    }
}
