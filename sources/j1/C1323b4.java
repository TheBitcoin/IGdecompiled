package J1;

import R2.n;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.s;
import d3.p;
import f2.P;
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

/* renamed from: J1.b4  reason: case insensitive filesystem */
public final class C1323b4 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f6957a;

    /* renamed from: b  reason: collision with root package name */
    private final I f6958b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f6959c;

    /* renamed from: d  reason: collision with root package name */
    private final I f6960d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6961e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6962f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f6963g;

    /* renamed from: J1.b4$a */
    public static final class a implements P {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1323b4 f6964a;

        a(C1323b4 b4Var) {
            this.f6964a = b4Var;
        }

        public void b() {
            this.f6964a.f6959c.setValue(Boolean.FALSE);
        }

        public void g() {
            this.f6964a.f6959c.setValue(Boolean.TRUE);
        }
    }

    /* renamed from: J1.b4$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f6965a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1323b4 f6966b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f6967c;

        /* renamed from: J1.b4$b$a */
        public static final class a implements T {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1323b4 f6968a;

            a(C1323b4 b4Var) {
                this.f6968a = b4Var;
            }

            public void a() {
                this.f6968a.f6957a.setValue(new E.c(new ArrayList()));
                this.f6968a.l(false);
            }

            public void c(ArrayList arrayList, boolean z4) {
                m.e(arrayList, "userList");
                if (arrayList.size() > 0) {
                    C1323b4 b4Var = this.f6968a;
                    b4Var.f6963g = b4Var.f6963g + arrayList.size();
                    this.f6968a.f6957a.setValue(new E.c(arrayList));
                    this.f6968a.f6959c.setValue(Boolean.valueOf(z4));
                } else if (this.f6968a.f6963g == 0) {
                    this.f6968a.f6957a.setValue(new E.c(new ArrayList()));
                } else {
                    this.f6968a.k(true);
                    this.f6968a.f6957a.setValue(E.b.f21884a);
                }
                this.f6968a.l(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1323b4 b4Var, Context context, d dVar) {
            super(2, dVar);
            this.f6966b = b4Var;
            this.f6967c = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f6966b, this.f6967c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f6965a == 0) {
                n.b(obj);
                this.f6966b.l(true);
                this.f6966b.f6957a.setValue(E.a.f21883a);
                new s(this.f6967c, ViewModelKt.getViewModelScope(this.f6966b)).d(30, this.f6966b.f6963g, new a(this.f6966b));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public C1323b4() {
        t a5 = K.a(E.a.f21883a);
        this.f6957a = a5;
        this.f6958b = a5;
        t a6 = K.a(Boolean.TRUE);
        this.f6959c = a6;
        this.f6960d = a6;
    }

    public final void e(Context context) {
        m.e(context, "context");
        a aVar = new a(this);
        if (((Boolean) this.f6959c.getValue()).booleanValue()) {
            new s(context, ViewModelKt.getViewModelScope(this)).g(aVar);
        } else {
            new s(context, ViewModelKt.getViewModelScope(this)).f(aVar);
        }
    }

    public final void f(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(this, context, (d) null), 2, (Object) null);
    }

    public final boolean g() {
        return this.f6961e;
    }

    public final boolean h() {
        return this.f6962f;
    }

    public final I i() {
        return this.f6958b;
    }

    public final I j() {
        return this.f6960d;
    }

    public final void k(boolean z4) {
        this.f6961e = z4;
    }

    public final void l(boolean z4) {
        this.f6962f = z4;
    }
}
