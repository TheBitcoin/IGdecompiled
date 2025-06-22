package com.uptodown.receivers;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2060s;
import g2.S;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import u2.C2313C;
import u2.t;
import u2.x;

public final class MyAppUpdatedReceiver extends BroadcastReceiver {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19269a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19270b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f19271c;

        /* renamed from: com.uptodown.receivers.MyAppUpdatedReceiver$a$a  reason: collision with other inner class name */
        static final class C0239a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19272a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f19273b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0239a(BroadcastReceiver.PendingResult pendingResult, d dVar) {
                super(2, dVar);
                this.f19273b = pendingResult;
            }

            public final d create(Object obj, d dVar) {
                return new C0239a(this.f19273b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19272a == 0) {
                    n.b(obj);
                    this.f19273b.finish();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0239a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, BroadcastReceiver.PendingResult pendingResult, d dVar) {
            super(2, dVar);
            this.f19270b = context;
            this.f19271c = pendingResult;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f19270b, this.f19271c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2060s b5;
            Object c5 = W2.b.c();
            int i4 = this.f19269a;
            if (i4 == 0) {
                n.b(obj);
                String packageName = this.f19270b.getPackageName();
                t a5 = t.f21927u.a(this.f19270b);
                a5.a();
                m.b(packageName);
                S D02 = a5.D0(packageName);
                if (D02 == null || (b5 = D02.b(this.f19270b)) == null) {
                    str = null;
                } else {
                    if (b5.o().size() == 1) {
                        str = String.valueOf(((C2060s.c) b5.o().get(0)).d());
                    } else {
                        str = null;
                    }
                    if (com.uptodown.activities.preferences.a.f18818a.P(this.f19270b)) {
                        b5.g();
                    }
                    a5.R(packageName);
                    a5.z(b5);
                }
                a5.v(packageName);
                a5.p1(0);
                a5.i();
                Bundle bundle = new Bundle();
                bundle.putString("packagename", this.f19270b.getPackageName());
                bundle.putString("type", "success");
                bundle.putInt("update", 1);
                if (!(str == null || str.length() == 0)) {
                    bundle.putString("fileId", str);
                }
                new x(this.f19270b).d("install", bundle);
                E0 c6 = Y.c();
                C0239a aVar = new C0239a(this.f19271c, (d) null);
                this.f19269a = 1;
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

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyAppUpdatedReceiver f19275b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f19276c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f19277d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MyAppUpdatedReceiver myAppUpdatedReceiver, Context context, BroadcastReceiver.PendingResult pendingResult, d dVar) {
            super(2, dVar);
            this.f19275b = myAppUpdatedReceiver;
            this.f19276c = context;
            this.f19277d = pendingResult;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f19275b, this.f19276c, this.f19277d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19274a;
            if (i4 == 0) {
                n.b(obj);
                MyAppUpdatedReceiver myAppUpdatedReceiver = this.f19275b;
                Context context = this.f19276c;
                BroadcastReceiver.PendingResult pendingResult = this.f19277d;
                m.b(pendingResult);
                this.f19274a = 1;
                if (myAppUpdatedReceiver.b(context, pendingResult, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final Object b(Context context, BroadcastReceiver.PendingResult pendingResult, d dVar) {
        Object g4 = C0977g.g(Y.b(), new a(context, pendingResult, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public void onReceive(Context context, Intent intent) {
        m.e(context, "context");
        m.e(intent, "intent");
        Context a5 = k.f7778g.a(context);
        if (m.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            aVar.B0(context, (String) null);
            aVar.O0(a5, "0");
            aVar.c1(a5, false);
            aVar.h1(a5, false);
            aVar.m1(a5, (String) null);
            C2313C.f21882a.g(a5);
            String m4 = aVar.m(a5);
            if (!m3.m.p(m4, "0", true) && !m3.m.p(m4, "1", true) && !m3.m.p(m4, "2", true)) {
                aVar.E0(a5, "2");
            }
            C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new b(this, a5, goAsync(), (d) null), 3, (Object) null);
        }
    }
}
