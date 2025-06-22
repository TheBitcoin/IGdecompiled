package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2061t;
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
import org.json.JSONObject;
import u2.L;
import u2.z;

public final class t {

    /* renamed from: b  reason: collision with root package name */
    public static final b f9573b = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9574a;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9575a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f9576b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t tVar, d dVar) {
            super(2, dVar);
            this.f9576b = tVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9576b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9575a;
            if (i4 == 0) {
                n.b(obj);
                t tVar = this.f9576b;
                this.f9575a = 1;
                if (tVar.g(this) == c5) {
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

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f9578b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t tVar, d dVar) {
            super(2, dVar);
            this.f9578b = tVar;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f9578b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONObject optJSONObject;
            W2.b.c();
            if (this.f9577a == 0) {
                n.b(obj);
                if (this.f9578b.e()) {
                    u2.t a5 = u2.t.f21927u.a(this.f9578b.f9574a);
                    a5.a();
                    ArrayList n02 = a5.n0();
                    ArrayList o02 = a5.o0();
                    a5.i();
                    if (n02.size() > 0 || o02.size() > 0) {
                        L l4 = new L(this.f9578b.f9574a);
                        g2.L d5 = l4.d();
                        if (l4.h(d5) && d5.e() != null) {
                            JSONObject e5 = d5.e();
                            m.b(e5);
                            if (e5.optInt("success") == 1 && (optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null && optJSONObject.optInt("result") == 1) {
                                if (n02.size() > 0) {
                                    g2.L I02 = l4.I0(n02);
                                    if (l4.h(I02) && I02.e() != null) {
                                        JSONObject e6 = I02.e();
                                        m.b(e6);
                                        if (e6.optInt("success") == 1) {
                                            a5.a();
                                            Iterator it = n02.iterator();
                                            m.d(it, "iterator(...)");
                                            while (it.hasNext()) {
                                                Object next = it.next();
                                                m.d(next, "next(...)");
                                                a5.E(((C2061t) next).a());
                                            }
                                            a5.i();
                                        }
                                    }
                                }
                                if (o02.size() > 0) {
                                    g2.L J02 = l4.J0(o02);
                                    if (l4.h(J02) && J02.e() != null) {
                                        JSONObject e7 = J02.e();
                                        m.b(e7);
                                        if (e7.optInt("success") == 1) {
                                            a5.a();
                                            Iterator it2 = o02.iterator();
                                            m.d(it2, "iterator(...)");
                                            while (it2.hasNext()) {
                                                Object next2 = it2.next();
                                                m.d(next2, "next(...)");
                                                a5.F(((C2061t) next2).a());
                                            }
                                            a5.i();
                                        }
                                    }
                                }
                            }
                        }
                        t tVar = this.f9578b;
                        tVar.f(tVar.f9574a);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public t(Context context) {
        m.e(context, "context");
        this.f9574a = context;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean e() {
        if (z.f21956a.d()) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            long u4 = aVar.u(this.f9574a);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - u4 > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                aVar.R0(this.f9574a, currentTimeMillis);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void f(Context context) {
        u2.t a5 = u2.t.f21927u.a(context);
        a5.a();
        a5.I();
        a5.J();
        a5.i();
    }

    /* access modifiers changed from: private */
    public final Object g(d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
