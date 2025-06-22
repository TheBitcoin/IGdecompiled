package d2;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import d3.p;
import g2.C2053k;
import g2.L;
import g2.Q;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class U1 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f19822a;

    /* renamed from: b  reason: collision with root package name */
    private final I f19823b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19824c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19825d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f19826e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Q f19827a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19828b;

        public a(Q q4, boolean z4) {
            m.e(q4, "topByCategory");
            this.f19827a = q4;
            this.f19828b = z4;
        }

        public final boolean a() {
            return this.f19828b;
        }

        public final Q b() {
            return this.f19827a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (m.a(this.f19827a, aVar.f19827a) && this.f19828b == aVar.f19828b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f19827a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f19828b);
        }

        public String toString() {
            return "TopByCategoryData(topByCategory=" + this.f19827a + ", firstRequest=" + this.f19828b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19829a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ U1 f19830b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f19831c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2053k f19832d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(U1 u12, Context context, C2053k kVar, d dVar) {
            super(2, dVar);
            this.f19830b = u12;
            this.f19831c = context;
            this.f19832d = kVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f19830b, this.f19831c, this.f19832d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19829a == 0) {
                n.b(obj);
                this.f19830b.k(true);
                this.f19830b.f19826e = 0;
                this.f19830b.f19822a.setValue(new E.c(new a(this.f19830b.i(this.f19831c, this.f19832d), true)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19833a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ U1 f19834b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f19835c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2053k f19836d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(U1 u12, Context context, C2053k kVar, d dVar) {
            super(2, dVar);
            this.f19834b = u12;
            this.f19835c = context;
            this.f19836d = kVar;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f19834b, this.f19835c, this.f19836d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19833a == 0) {
                n.b(obj);
                this.f19834b.k(true);
                Q a5 = this.f19834b.i(this.f19835c, this.f19836d);
                if (a5.a().isEmpty()) {
                    this.f19834b.j(true);
                }
                this.f19834b.f19822a.setValue(new E.c(new a(a5, false)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public U1() {
        t a5 = K.a(E.a.f21883a);
        this.f19822a = a5;
        this.f19823b = a5;
    }

    /* access modifiers changed from: private */
    public final Q i(Context context, C2053k kVar) {
        L l4;
        u2.L l5 = new u2.L(context);
        Q q4 = new Q((C2053k) null, (ArrayList) null, 0, 7, (C2103g) null);
        q4.e(kVar);
        if (kVar.b() > 0) {
            if (kVar.h()) {
                q4 = Q.f20451d.a(l5.t(kVar.b(), 40, this.f19826e), kVar);
            } else if (kVar.g()) {
                q4.d(l5.Q0(l5.j0(kVar.b(), 40, this.f19826e)));
            } else {
                q4.d(l5.Q0(l5.i0(kVar.b(), 40, this.f19826e)));
            }
        } else if (kVar.b() == -1) {
            q4.d(l5.Q0(l5.h0(40, this.f19826e)));
        } else if (kVar.b() == -2) {
            if (kVar.e() > 0) {
                l4 = l5.W(kVar.e(), 40, this.f19826e);
            } else {
                l4 = l5.K(40, this.f19826e);
            }
            q4.d(l5.Q0(l4));
        } else if (kVar.b() == -3) {
            q4.d(l5.Q0(l5.G(40, this.f19826e)));
        }
        this.f19826e += q4.a().size();
        return q4;
    }

    public final void d(Context context, C2053k kVar) {
        m.e(context, "context");
        m.e(kVar, "category");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, kVar, (d) null), 2, (Object) null);
    }

    public final void e(Context context, C2053k kVar) {
        m.e(context, "context");
        m.e(kVar, "category");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(this, context, kVar, (d) null), 2, (Object) null);
    }

    public final boolean f() {
        return this.f19825d;
    }

    public final I g() {
        return this.f19823b;
    }

    public final boolean h() {
        return this.f19824c;
    }

    public final void j(boolean z4) {
        this.f19825d = z4;
    }

    public final void k(boolean z4) {
        this.f19824c = z4;
    }
}
