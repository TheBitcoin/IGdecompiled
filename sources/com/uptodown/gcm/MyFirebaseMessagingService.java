package com.uptodown.gcm;

import N1.k;
import R2.n;
import R2.s;
import V2.g;
import android.app.Activity;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.S;
import com.uptodown.activities.C1826a;
import d3.p;
import g2.C2033A;
import java.util.Map;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: h  reason: collision with root package name */
    public static final a f19247h = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f19249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19250c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MyFirebaseMessagingService f19251d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f19252e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f19253f;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19254a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f19255b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f19256c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f19257d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, String str2, long j4, V2.d dVar) {
                super(2, dVar);
                this.f19255b = str;
                this.f19256c = str2;
                this.f19257d = j4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19255b, this.f19256c, this.f19257d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19254a == 0) {
                    n.b(obj);
                    Activity g4 = k.f7778g.g();
                    if (g4 != null && (g4 instanceof C1826a)) {
                        ((C1826a) g4).W1(this.f19255b, this.f19256c, this.f19257d);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(long j4, String str, MyFirebaseMessagingService myFirebaseMessagingService, String str2, String str3, V2.d dVar) {
            super(2, dVar);
            this.f19249b = j4;
            this.f19250c = str;
            this.f19251d = myFirebaseMessagingService;
            this.f19252e = str2;
            this.f19253f = str3;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19249b, this.f19250c, this.f19251d, this.f19252e, this.f19253f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19248a;
            if (i4 == 0) {
                n.b(obj);
                C2033A a5 = new C2033A();
                a5.j(this.f19249b);
                a5.m(this.f19250c);
                Context applicationContext = this.f19251d.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                a5.n(applicationContext);
                E0 c6 = Y.c();
                a aVar = new a(this.f19252e, this.f19253f, this.f19249b, (V2.d) null);
                this.f19248a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyFirebaseMessagingService f19259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19260c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19261d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ B f19262e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f19263f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MyFirebaseMessagingService myFirebaseMessagingService, String str, String str2, B b5, String str3, V2.d dVar) {
            super(2, dVar);
            this.f19259b = myFirebaseMessagingService;
            this.f19260c = str;
            this.f19261d = str2;
            this.f19262e = b5;
            this.f19263f = str3;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19259b, this.f19260c, this.f19261d, this.f19262e, this.f19263f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19258a;
            if (i4 == 0) {
                n.b(obj);
                MyFirebaseMessagingService myFirebaseMessagingService = this.f19259b;
                String str = this.f19260c;
                String str2 = this.f19261d;
                long j4 = this.f19262e.f20967a;
                String str3 = this.f19263f;
                this.f19258a = 1;
                if (myFirebaseMessagingService.v(str, str2, j4, str3, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19264a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19265b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19266c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19267d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Activity activity, String str, String str2, V2.d dVar) {
            super(2, dVar);
            this.f19265b = activity;
            this.f19266c = str;
            this.f19267d = str2;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19265b, this.f19266c, this.f19267d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19264a == 0) {
                n.b(obj);
                ((C1826a) this.f19265b).Y1(this.f19266c, this.f19267d);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final Object v(String str, String str2, long j4, String str3, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(j4, str3, this, str, str2, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void w(String str) {
    }

    public void p(S s4) {
        m.e(s4, "remoteMessage");
        Map c5 = s4.c();
        m.d(c5, "getData(...)");
        if (!c5.isEmpty()) {
            String str = (String) s4.c().get("appId");
            if (str != null) {
                B b5 = new B();
                b5.f20967a = -1;
                try {
                    b5.f20967a = Long.parseLong(str);
                } catch (NumberFormatException e5) {
                    e5.printStackTrace();
                }
                if (b5.f20967a > 0) {
                    String str2 = (String) s4.c().get("packageName");
                    if (!new u2.m().s(str2, getApplicationContext()) && s4.g() != null) {
                        S.b g4 = s4.g();
                        m.b(g4);
                        String a5 = g4.a();
                        S.b g5 = s4.g();
                        m.b(g5);
                        String c6 = g5.c();
                        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new c(this, c6, a5, b5, str2, (V2.d) null), 3, (Object) null);
                        return;
                    }
                    return;
                }
                return;
            }
            String str3 = (String) s4.c().get("campaign");
            if (str3 != null && m3.m.p(str3, "BlackFriday", true) && s4.g() != null) {
                S.b g6 = s4.g();
                m.b(g6);
                String a6 = g6.a();
                S.b g7 = s4.g();
                m.b(g7);
                String c7 = g7.c();
                Activity g8 = k.f7778g.g();
                if (g8 != null && (g8 instanceof C1826a)) {
                    C1001s0 unused2 = C0981i.d(K.a(Y.c()), (g) null, (L) null, new d(g8, c7, a6, (V2.d) null), 3, (Object) null);
                }
            }
        }
    }

    public void r(String str) {
        m.e(str, "token");
        w(str);
    }
}
