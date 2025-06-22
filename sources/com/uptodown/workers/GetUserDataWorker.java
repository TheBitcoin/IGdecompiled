package com.uptodown.workers;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import f2.M;
import g2.L;
import g2.U;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.Y;
import org.json.JSONObject;

public final class GetUserDataWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19472b = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f19473a;

    public static final class a {

        /* renamed from: com.uptodown.workers.GetUserDataWorker$a$a  reason: collision with other inner class name */
        static final class C0241a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19474a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f19475b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ M f19476c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0241a(Context context, M m4, d dVar) {
                super(2, dVar);
                this.f19475b = context;
                this.f19476c = m4;
            }

            public final d create(Object obj, d dVar) {
                return new C0241a(this.f19475b, this.f19476c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                String d5;
                JSONObject optJSONObject;
                W2.b.c();
                if (this.f19474a == 0) {
                    n.b(obj);
                    U.b bVar = U.f20468m;
                    U e5 = bVar.e(this.f19475b);
                    if (e5 != null && e5.m(this.f19475b)) {
                        L u02 = new u2.L(this.f19475b).u0();
                        if (!(u02.b() || (d5 = u02.d()) == null || d5.length() == 0)) {
                            String d6 = u02.d();
                            m.b(d6);
                            JSONObject jSONObject = new JSONObject(d6);
                            if (jSONObject.optInt("success") == 1 && !jSONObject.isNull(DataSchemeDataSource.SCHEME_DATA) && (optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                                e5.e(this.f19475b, optJSONObject);
                                e5.p(this.f19475b);
                                M m4 = this.f19476c;
                                if (m4 != null) {
                                    m4.a();
                                }
                            }
                        }
                        if (u02.f() == 401) {
                            bVar.a(this.f19475b);
                        }
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0241a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public static /* synthetic */ Object b(a aVar, Context context, M m4, d dVar, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                m4 = null;
            }
            return aVar.a(context, m4, dVar);
        }

        public final Object a(Context context, M m4, d dVar) {
            Object g4 = C0977g.g(Y.b(), new C0241a(context, m4, (d) null), dVar);
            if (g4 == W2.b.c()) {
                return g4;
            }
            return s.f8222a;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetUserDataWorker f19478b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GetUserDataWorker getUserDataWorker, d dVar) {
            super(2, dVar);
            this.f19478b = getUserDataWorker;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f19478b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19477a;
            if (i4 == 0) {
                n.b(obj);
                a aVar = GetUserDataWorker.f19472b;
                Context a5 = this.f19478b.f19473a;
                this.f19477a = 1;
                if (a.b(aVar, a5, (M) null, this, 2, (Object) null) == c5) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUserDataWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19473a = context;
    }

    public ListenableWorker.Result doWork() {
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new b(this, (d) null), 3, (Object) null);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        return success;
    }
}
