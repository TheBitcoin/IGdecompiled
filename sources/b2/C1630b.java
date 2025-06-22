package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.workers.DownloadApkWorker;
import d3.p;
import g2.C2041I;
import g2.C2050h;
import g2.C2060s;
import g2.U;
import g2.r;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.L;
import u2.t;
import u2.z;

/* renamed from: b2.b  reason: case insensitive filesystem */
public final class C1630b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9101a;

    /* renamed from: b  reason: collision with root package name */
    private final J f9102b;

    /* renamed from: b2.b$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1630b f9104b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1630b bVar, d dVar) {
            super(2, dVar);
            this.f9104b = bVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9104b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f9103a;
            if (i4 == 0) {
                n.b(obj);
                C1630b bVar = this.f9104b;
                this.f9103a = 1;
                if (bVar.c(this) == c5) {
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

    /* renamed from: b2.b$b  reason: collision with other inner class name */
    static final class C0139b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9105a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1630b f9106b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0139b(C1630b bVar, d dVar) {
            super(2, dVar);
            this.f9106b = bVar;
        }

        public final d create(Object obj, d dVar) {
            return new C0139b(this.f9106b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            b.c();
            if (this.f9105a == 0) {
                n.b(obj);
                U e5 = U.f20468m.e(this.f9106b.f9101a);
                if (e5 != null && e5.m(this.f9106b.f9101a)) {
                    r rVar = new r();
                    rVar.j(this.f9106b.f9101a);
                    L l4 = new L(this.f9106b.f9101a);
                    if (rVar.d() != null) {
                        String d6 = rVar.d();
                        m.b(d6);
                        g2.L a02 = l4.a0(d6);
                        if (!a02.b() && a02.e() != null) {
                            JSONObject e6 = a02.e();
                            m.b(e6);
                            int optInt = e6.optInt("success");
                            JSONArray optJSONArray = e6.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                            if (optInt == 1 && optJSONArray != null) {
                                t a5 = t.f21927u.a(this.f9106b.f9101a);
                                a5.a();
                                int length = optJSONArray.length();
                                for (int i4 = 0; i4 < length; i4++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                                    C2041I i5 = new C2041I();
                                    m.b(optJSONObject);
                                    i5.d(optJSONObject);
                                    if (!a5.B0(i5.a()).isEmpty()) {
                                        a5.M(i5.a());
                                    }
                                    a5.V0(i5);
                                }
                                a5.i();
                            }
                        }
                        t a6 = t.f21927u.a(this.f9106b.f9101a);
                        a6.a();
                        Iterator it = a6.s0().iterator();
                        m.d(it, "iterator(...)");
                        int i6 = -1;
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            C2041I i7 = (C2041I) next;
                            g2.L T4 = l4.T(i7.a());
                            if (T4.b() || (d5 = T4.d()) == null || d5.length() == 0) {
                                a6.M(i7.a());
                            } else {
                                String d7 = T4.d();
                                m.b(d7);
                                JSONObject jSONObject = new JSONObject(d7);
                                int optInt2 = jSONObject.optInt("success");
                                JSONObject optJSONObject2 = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                                if (optInt2 == 1 && optJSONObject2 != null) {
                                    C2050h hVar = new C2050h();
                                    C2050h.b(hVar, optJSONObject2, (Context) null, 2, (Object) null);
                                    C2060s sVar = new C2060s();
                                    sVar.d(hVar);
                                    i7.f(sVar.Q(this.f9106b.f9101a));
                                    a6.A1(i7);
                                    if (i6 == -1) {
                                        i6 = i7.b();
                                    }
                                }
                            }
                        }
                        a6.i();
                        if (i6 != -1 && z.f21956a.d()) {
                            DownloadApkWorker.f19447i.c(this.f9106b.f9101a, i6);
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((C0139b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1630b(Context context, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9101a = context;
        this.f9102b = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object c(d dVar) {
        Object g4 = C0977g.g(Y.b(), new C0139b(this, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
