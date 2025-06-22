package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.L;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.Y;
import org.json.JSONObject;

public final class q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9483a;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f9485b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar, d dVar) {
            super(2, dVar);
            this.f9485b = qVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9485b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9484a;
            if (i4 == 0) {
                n.b(obj);
                q qVar = this.f9485b;
                this.f9484a = 1;
                if (qVar.c(this) == c5) {
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
        int f9486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f9487b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(q qVar, d dVar) {
            super(2, dVar);
            this.f9487b = qVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9487b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f9486a == 0) {
                n.b(obj);
                L F02 = new u2.L(this.f9487b.f9483a).F0();
                if (!F02.b() && F02.e() != null) {
                    JSONObject e5 = F02.e();
                    m.b(e5);
                    if (!e5.isNull("is_request_in_eea_or_unknown")) {
                        boolean optBoolean = e5.optBoolean("is_request_in_eea_or_unknown");
                        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                        aVar.H0(this.f9487b.f9483a, optBoolean);
                        aVar.I0(this.f9487b.f9483a, true);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public q(Context context) {
        m.e(context, "context");
        this.f9483a = context;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object c(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
