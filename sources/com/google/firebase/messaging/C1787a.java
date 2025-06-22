package com.google.firebase.messaging;

import K0.C1494c;
import K0.C1495d;
import K0.C1496e;
import L0.a;
import androidx.core.app.NotificationCompat;

/* renamed from: com.google.firebase.messaging.a  reason: case insensitive filesystem */
public final class C1787a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11311a = new C1787a();

    /* renamed from: com.google.firebase.messaging.a$a  reason: collision with other inner class name */
    private static final class C0164a implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final C0164a f11312a = new C0164a();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f11313b = C1494c.a("projectNumber").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f11314c = C1494c.a("messageId").b(N0.a.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f11315d = C1494c.a("instanceId").b(N0.a.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f11316e = C1494c.a("messageType").b(N0.a.b().c(4).a()).a();

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f11317f = C1494c.a("sdkPlatform").b(N0.a.b().c(5).a()).a();

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f11318g = C1494c.a("packageName").b(N0.a.b().c(6).a()).a();

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f11319h = C1494c.a("collapseKey").b(N0.a.b().c(7).a()).a();

        /* renamed from: i  reason: collision with root package name */
        private static final C1494c f11320i = C1494c.a("priority").b(N0.a.b().c(8).a()).a();

        /* renamed from: j  reason: collision with root package name */
        private static final C1494c f11321j = C1494c.a("ttl").b(N0.a.b().c(9).a()).a();

        /* renamed from: k  reason: collision with root package name */
        private static final C1494c f11322k = C1494c.a("topic").b(N0.a.b().c(10).a()).a();

        /* renamed from: l  reason: collision with root package name */
        private static final C1494c f11323l = C1494c.a("bulkId").b(N0.a.b().c(11).a()).a();

        /* renamed from: m  reason: collision with root package name */
        private static final C1494c f11324m = C1494c.a(NotificationCompat.CATEGORY_EVENT).b(N0.a.b().c(12).a()).a();

        /* renamed from: n  reason: collision with root package name */
        private static final C1494c f11325n = C1494c.a("analyticsLabel").b(N0.a.b().c(13).a()).a();

        /* renamed from: o  reason: collision with root package name */
        private static final C1494c f11326o = C1494c.a("campaignId").b(N0.a.b().c(14).a()).a();

        /* renamed from: p  reason: collision with root package name */
        private static final C1494c f11327p = C1494c.a("composerLabel").b(N0.a.b().c(15).a()).a();

        private C0164a() {
        }

        /* renamed from: b */
        public void a(X0.a aVar, C1496e eVar) {
            eVar.c(f11313b, aVar.l());
            eVar.a(f11314c, aVar.h());
            eVar.a(f11315d, aVar.g());
            eVar.a(f11316e, aVar.i());
            eVar.a(f11317f, aVar.m());
            eVar.a(f11318g, aVar.j());
            eVar.a(f11319h, aVar.d());
            eVar.d(f11320i, aVar.k());
            eVar.d(f11321j, aVar.o());
            eVar.a(f11322k, aVar.n());
            eVar.c(f11323l, aVar.b());
            eVar.a(f11324m, aVar.f());
            eVar.a(f11325n, aVar.a());
            eVar.c(f11326o, aVar.c());
            eVar.a(f11327p, aVar.e());
        }
    }

    /* renamed from: com.google.firebase.messaging.a$b */
    private static final class b implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final b f11328a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f11329b = C1494c.a("messagingClientEvent").b(N0.a.b().c(1).a()).a();

        private b() {
        }

        /* renamed from: b */
        public void a(X0.b bVar, C1496e eVar) {
            eVar.a(f11329b, bVar.a());
        }
    }

    /* renamed from: com.google.firebase.messaging.a$c */
    private static final class c implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final c f11330a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f11331b = C1494c.d("messagingClientEventExtension");

        private c() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((K) null, (C1496e) obj2);
        }

        public void b(K k4, C1496e eVar) {
            throw null;
        }
    }

    private C1787a() {
    }

    public void a(L0.b bVar) {
        bVar.a(K.class, c.f11330a);
        bVar.a(X0.b.class, b.f11328a);
        bVar.a(X0.a.class, C0164a.f11312a);
    }
}
