package com.uptodown.workers;

import N1.k;
import R2.n;
import R2.s;
import V2.g;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C1640l;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import d3.p;
import f2.C2027s;
import g2.C2039G;
import g2.C2050h;
import g2.L;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.C2313C;
import u2.t;

public final class PreRegisterWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19481b = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f19482a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19483a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f19484b;

        public static final class a implements C2027s {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PreRegisterWorker f19485a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2039G f19486b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f19487c;

            a(PreRegisterWorker preRegisterWorker, C2039G g4, int i4) {
                this.f19485a = preRegisterWorker;
                this.f19486b = g4;
                this.f19487c = i4;
            }

            public void b(int i4) {
            }

            public void c(C2050h hVar) {
                m.e(hVar, "appInfo");
                this.f19485a.g(this.f19486b, hVar, this.f19487c);
                if (this.f19486b.d() != 1) {
                    return;
                }
                if (hVar.B0()) {
                    UptodownApp.f17422D.d0(hVar, this.f19485a.f19482a);
                    return;
                }
                String o4 = hVar.o();
                if (o4 != null && o4.length() != 0) {
                    DownloadApkWorker.a aVar = DownloadApkWorker.f19447i;
                    Context c5 = this.f19485a.f19482a;
                    String o5 = hVar.o();
                    m.b(o5);
                    aVar.a(c5, o5);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PreRegisterWorker preRegisterWorker, V2.d dVar) {
            super(2, dVar);
            this.f19484b = preRegisterWorker;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19484b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19483a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                L R4 = new u2.L(this.f19484b.f19482a).R();
                if (!R4.b() && R4.e() != null) {
                    JSONObject e5 = R4.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            C2039G.a aVar = C2039G.f20367f;
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            m.d(optJSONObject, "optJSONObject(...)");
                            C2039G b5 = aVar.b(optJSONObject);
                            arrayList.add(b5);
                            b5.i(this.f19484b.f19482a);
                        }
                    }
                    t a5 = t.f21927u.a(this.f19484b.f19482a);
                    a5.a();
                    ArrayList<C2039G> x02 = a5.x0();
                    a5.i();
                    int i5 = 0;
                    for (C2039G g4 : x02) {
                        int i6 = i5 + 1;
                        Iterator it = arrayList.iterator();
                        m.d(it, "iterator(...)");
                        boolean z4 = false;
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            if (g4.c() == ((C2039G) next).c()) {
                                z4 = true;
                            }
                        }
                        if (!z4) {
                            new C1640l(this.f19484b.f19482a, g4.c(), new a(this.f19484b, g4, i5), K.a(Y.b()));
                        }
                        i5 = i6;
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19488a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f19489b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PreRegisterWorker preRegisterWorker, V2.d dVar) {
            super(2, dVar);
            this.f19489b = preRegisterWorker;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19489b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19488a;
            if (i4 == 0) {
                n.b(obj);
                PreRegisterWorker preRegisterWorker = this.f19489b;
                this.f19488a = 1;
                if (preRegisterWorker.e(this) == c5) {
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
        int f19490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19491b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f19492c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2050h f19493d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f19494e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2039G f19495f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, PreRegisterWorker preRegisterWorker, C2050h hVar, int i4, C2039G g4, V2.d dVar) {
            super(2, dVar);
            this.f19491b = str;
            this.f19492c = preRegisterWorker;
            this.f19493d = hVar;
            this.f19494e = i4;
            this.f19495f = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19491b, this.f19492c, this.f19493d, this.f19494e, this.f19495f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            W2.b.c();
            if (this.f19490a == 0) {
                n.b(obj);
                try {
                    bitmap = com.squareup.picasso.s.h().l(this.f19491b).g();
                } catch (IOException unused) {
                    bitmap = null;
                }
                C2313C.f21882a.p(this.f19492c.f19482a, this.f19493d, this.f19494e, bitmap, this.f19495f);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f19496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19497b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2039G f19498c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2050h f19499d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f19500e;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19501a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PreRegisterWorker f19502b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f19503c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C2039G f19504d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C2050h f19505e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ int f19506f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(PreRegisterWorker preRegisterWorker, String str, C2039G g4, C2050h hVar, int i4, V2.d dVar) {
                super(2, dVar);
                this.f19502b = preRegisterWorker;
                this.f19503c = str;
                this.f19504d = g4;
                this.f19505e = hVar;
                this.f19506f = i4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19502b, this.f19503c, this.f19504d, this.f19505e, this.f19506f, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f19501a;
                if (i4 == 0) {
                    n.b(obj);
                    PreRegisterWorker preRegisterWorker = this.f19502b;
                    String str = this.f19503c;
                    C2039G g4 = this.f19504d;
                    C2050h hVar = this.f19505e;
                    int i5 = this.f19506f;
                    this.f19501a = 1;
                    if (preRegisterWorker.f(str, g4, hVar, i5, this) == c5) {
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
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        e(PreRegisterWorker preRegisterWorker, String str, C2039G g4, C2050h hVar, int i4) {
            this.f19496a = preRegisterWorker;
            this.f19497b = str;
            this.f19498c = g4;
            this.f19499d = hVar;
            this.f19500e = i4;
        }

        public void a(Exception exc) {
            C2313C.f21882a.p(this.f19496a.f19482a, this.f19499d, this.f19500e, (Bitmap) null, this.f19498c);
        }

        public void b() {
            C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new a(this.f19496a, this.f19497b, this.f19498c, this.f19499d, this.f19500e, (V2.d) null), 3, (Object) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreRegisterWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19482a = context;
        this.f19482a = k.f7778g.a(context);
    }

    /* access modifiers changed from: private */
    public final Object e(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object f(String str, C2039G g4, C2050h hVar, int i4, V2.d dVar) {
        Object g5 = C0977g.g(Y.b(), new d(str, this, hVar, i4, g4, (V2.d) null), dVar);
        if (g5 == W2.b.c()) {
            return g5;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void g(C2039G g4, C2050h hVar, int i4) {
        String E4 = hVar.E();
        if (E4 != null) {
            com.squareup.picasso.s.h().l(E4).e(new e(this, E4, g4, hVar, i4));
            return;
        }
        C2313C.f21882a.p(this.f19482a, hVar, i4, (Bitmap) null, g4);
    }

    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        try {
            C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new c(this, (V2.d) null), 3, (Object) null);
            return success;
        } catch (Exception e5) {
            e5.printStackTrace();
            return ListenableWorker.Result.failure();
        }
    }
}
