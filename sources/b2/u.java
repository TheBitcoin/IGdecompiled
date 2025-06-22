package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.L;
import g2.P;
import g2.r;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.Y;
import org.json.JSONObject;

public final class u {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9579a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r f9580b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final P f9581c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9582a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f9583b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(u uVar, d dVar) {
            super(2, dVar);
            this.f9583b = uVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9583b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9582a;
            if (i4 == 0) {
                n.b(obj);
                u uVar = this.f9583b;
                this.f9582a = 1;
                if (uVar.e(this) == c5) {
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
        int f9584a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f9585b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(u uVar, d dVar) {
            super(2, dVar);
            this.f9585b = uVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9585b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f9584a == 0) {
                n.b(obj);
                L a12 = new u2.L(this.f9585b.f9579a).a1(this.f9585b.f9580b, this.f9585b.f9581c);
                if (a12.e() != null) {
                    JSONObject e5 = a12.e();
                    m.b(e5);
                    a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                    Context a5 = this.f9585b.f9579a;
                    boolean z4 = true;
                    if (e5.optInt("success") != 1) {
                        z4 = false;
                    }
                    aVar.c1(a5, z4);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public u(Context context, r rVar, P p4) {
        m.e(context, "context");
        m.e(rVar, "deviceInfo");
        m.e(p4, "settingsUTD");
        this.f9579a = context;
        this.f9580b = rVar;
        this.f9581c = p4;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object e(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
