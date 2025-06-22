package q;

import android.content.Context;
import q.v;
import r.C1027j;
import r.C1029l;
import s.C1044a;
import s.C1045b;
import s.d;
import w.C1075d;
import w.C1078g;
import w.C1080i;
import x.s;
import x.w;
import y.C1094d;
import y.C1097g;
import y.C1098h;
import y.C1099i;
import y.C1100j;
import y.N;
import y.X;

abstract class e {

    private static final class b implements v.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f3996a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.f3996a = (Context) d.b(context);
            return this;
        }

        public v build() {
            d.a(this.f3996a, Context.class);
            return new c(this.f3996a);
        }
    }

    private static final class c extends v {

        /* renamed from: a  reason: collision with root package name */
        private final c f3997a;

        /* renamed from: b  reason: collision with root package name */
        private O2.a f3998b;

        /* renamed from: c  reason: collision with root package name */
        private O2.a f3999c;

        /* renamed from: d  reason: collision with root package name */
        private O2.a f4000d;

        /* renamed from: e  reason: collision with root package name */
        private O2.a f4001e;

        /* renamed from: f  reason: collision with root package name */
        private O2.a f4002f;

        /* renamed from: g  reason: collision with root package name */
        private O2.a f4003g;

        /* renamed from: h  reason: collision with root package name */
        private O2.a f4004h;

        /* renamed from: i  reason: collision with root package name */
        private O2.a f4005i;

        /* renamed from: j  reason: collision with root package name */
        private O2.a f4006j;

        /* renamed from: k  reason: collision with root package name */
        private O2.a f4007k;

        /* renamed from: l  reason: collision with root package name */
        private O2.a f4008l;

        /* renamed from: m  reason: collision with root package name */
        private O2.a f4009m;

        /* renamed from: n  reason: collision with root package name */
        private O2.a f4010n;

        private void g(Context context) {
            this.f3998b = C1044a.a(k.a());
            C1045b a5 = s.c.a(context);
            this.f3999c = a5;
            C1027j a6 = C1027j.a(a5, A.c.a(), A.d.a());
            this.f4000d = a6;
            this.f4001e = C1044a.a(C1029l.a(this.f3999c, a6));
            this.f4002f = X.a(this.f3999c, C1097g.a(), C1099i.a());
            this.f4003g = C1044a.a(C1098h.a(this.f3999c));
            this.f4004h = C1044a.a(N.a(A.c.a(), A.d.a(), C1100j.a(), this.f4002f, this.f4003g));
            C1078g b5 = C1078g.b(A.c.a());
            this.f4005i = b5;
            C1080i a7 = C1080i.a(this.f3999c, this.f4004h, b5, A.d.a());
            this.f4006j = a7;
            O2.a aVar = this.f3998b;
            O2.a aVar2 = this.f4001e;
            O2.a aVar3 = this.f4004h;
            this.f4007k = C1075d.a(aVar, aVar2, a7, aVar3, aVar3);
            O2.a aVar4 = this.f3999c;
            O2.a aVar5 = this.f4001e;
            O2.a aVar6 = this.f4004h;
            this.f4008l = s.a(aVar4, aVar5, aVar6, this.f4006j, this.f3998b, aVar6, A.c.a(), A.d.a(), this.f4004h);
            O2.a aVar7 = this.f3998b;
            O2.a aVar8 = this.f4004h;
            this.f4009m = w.a(aVar7, aVar8, this.f4006j, aVar8);
            this.f4010n = C1044a.a(w.a(A.c.a(), A.d.a(), this.f4007k, this.f4008l, this.f4009m));
        }

        /* access modifiers changed from: package-private */
        public C1094d a() {
            return (C1094d) this.f4004h.get();
        }

        /* access modifiers changed from: package-private */
        public u d() {
            return (u) this.f4010n.get();
        }

        private c(Context context) {
            this.f3997a = this;
            g(context);
        }
    }

    public static v.a a() {
        return new b();
    }
}
