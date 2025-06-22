package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.C2027s;
import g2.C2050h;
import kotlin.coroutines.jvm.internal.l;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import u2.L;

public final class m {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9433a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f9434b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2027s f9435c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final J f9436d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9437a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f9438b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar, d dVar) {
            super(2, dVar);
            this.f9438b = mVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9438b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9437a;
            if (i4 == 0) {
                n.b(obj);
                m mVar = this.f9438b;
                this.f9437a = 1;
                if (mVar.f(this) == c5) {
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
        int f9439a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f9440b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9441a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f9442b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(m mVar, d dVar) {
                super(2, dVar);
                this.f9442b = mVar;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9442b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9441a == 0) {
                    n.b(obj);
                    this.f9442b.f9435c.b(-1);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, d dVar) {
            super(2, dVar);
            this.f9440b = mVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9440b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9439a;
            if (i4 == 0) {
                n.b(obj);
                Context a5 = this.f9440b.f9433a;
                kotlin.jvm.internal.m.b(a5);
                long f4 = new C2050h().f(new L(a5).m(this.f9440b.f9434b));
                if (f4 > 0) {
                    return new C1640l(this.f9440b.f9433a, f4, this.f9440b.f9435c, this.f9440b.f9436d);
                }
                E0 c6 = Y.c();
                a aVar = new a(this.f9440b, (d) null);
                this.f9439a = 1;
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public m(Context context, String str, C2027s sVar, J j4) {
        kotlin.jvm.internal.m.e(str, "packagename");
        kotlin.jvm.internal.m.e(sVar, "listener");
        kotlin.jvm.internal.m.e(j4, "scope");
        this.f9433a = context;
        this.f9434b = str;
        this.f9435c = sVar;
        this.f9436d = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
