package J1;

import R2.n;
import V2.d;
import W2.b;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.s;
import d3.p;
import f2.T;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class K3 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f6811a;

    /* renamed from: b  reason: collision with root package name */
    private final I f6812b;

    /* renamed from: c  reason: collision with root package name */
    private t f6813c = K.a("");

    /* renamed from: d  reason: collision with root package name */
    private boolean f6814d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6815e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f6816f;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f6817a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ K3 f6818b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f6819c;

        /* renamed from: J1.K3$a$a  reason: collision with other inner class name */
        public static final class C0089a implements T {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ K3 f6820a;

            C0089a(K3 k32) {
                this.f6820a = k32;
            }

            public void a() {
                this.f6820a.f6811a.setValue(E.b.f21884a);
                this.f6820a.j(false);
            }

            public void c(ArrayList arrayList, boolean z4) {
                m.e(arrayList, "userList");
                if (arrayList.size() > 0) {
                    K3 k32 = this.f6820a;
                    k32.f6816f = k32.f6816f + arrayList.size();
                    this.f6820a.f6811a.setValue(new E.c(arrayList));
                } else if (this.f6820a.f6816f == 0) {
                    this.f6820a.f6811a.setValue(new E.c(new ArrayList()));
                } else {
                    this.f6820a.i(true);
                    this.f6820a.f6811a.setValue(E.b.f21884a);
                }
                this.f6820a.j(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(K3 k32, Context context, d dVar) {
            super(2, dVar);
            this.f6818b = k32;
            this.f6819c = context;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f6818b, this.f6819c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f6817a == 0) {
                n.b(obj);
                this.f6818b.j(true);
                this.f6818b.f6811a.setValue(E.a.f21883a);
                new s(this.f6819c, ViewModelKt.getViewModelScope(this.f6818b)).e((String) this.f6818b.h().getValue(), 30, this.f6818b.f6816f, new C0089a(this.f6818b));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public K3() {
        t a5 = K.a(E.a.f21883a);
        this.f6811a = a5;
        this.f6812b = a5;
    }

    public final void d(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new a(this, context, (d) null), 2, (Object) null);
    }

    public final boolean e() {
        return this.f6814d;
    }

    public final boolean f() {
        return this.f6815e;
    }

    public final I g() {
        return this.f6812b;
    }

    public final t h() {
        return this.f6813c;
    }

    public final void i(boolean z4) {
        this.f6814d = z4;
    }

    public final void j(boolean z4) {
        this.f6815e = z4;
    }
}
