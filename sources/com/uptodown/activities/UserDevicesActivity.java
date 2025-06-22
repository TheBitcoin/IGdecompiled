package com.uptodown.activities;

import J1.F5;
import J1.G5;
import J1.H5;
import J1.I5;
import M1.P;
import N1.k;
import R2.g;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c2.U0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.U;
import d3.p;
import f2.L;
import g2.V;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.q;

public final class UserDevicesActivity extends C1826a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f18577M = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18578J = h.a(new H5(this));

    /* renamed from: K  reason: collision with root package name */
    private final g f18579K = new ViewModelLazy(D.b(U.class), new d(this), new c(this), new e((d3.a) null, this));

    /* renamed from: L  reason: collision with root package name */
    private final ActivityResultLauncher f18580L;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18581a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDevicesActivity f18582b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDevicesActivity f18583a;

            /* renamed from: com.uptodown.activities.UserDevicesActivity$b$a$a  reason: collision with other inner class name */
            public static final class C0231a implements L {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ UserDevicesActivity f18584a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ E f18585b;

                C0231a(UserDevicesActivity userDevicesActivity, E e5) {
                    this.f18584a = userDevicesActivity;
                    this.f18585b = e5;
                }

                public void a(int i4) {
                    UserDevicesActivity userDevicesActivity = this.f18584a;
                    Object obj = ((U.a) ((E.c) this.f18585b).a()).b().get(i4);
                    m.d(obj, "get(...)");
                    userDevicesActivity.l3((V) obj);
                }
            }

            a(UserDevicesActivity userDevicesActivity) {
                this.f18583a = userDevicesActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (m.a(e5, E.a.f21883a)) {
                    this.f18583a.h3().f10044b.setVisibility(0);
                    this.f18583a.h3().f10045c.setVisibility(8);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    this.f18583a.m3(((U.a) cVar.a()).a());
                    if (!((U.a) cVar.a()).b().isEmpty()) {
                        this.f18583a.h3().f10046d.setAdapter(new P(((U.a) cVar.a()).b(), new C0231a(this.f18583a, e5)));
                    } else {
                        this.f18583a.h3().f10048f.setVisibility(8);
                    }
                    this.f18583a.h3().f10044b.setVisibility(8);
                    this.f18583a.h3().f10045c.setVisibility(0);
                } else if (!m.a(e5, E.b.f21884a)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UserDevicesActivity userDevicesActivity, V2.d dVar) {
            super(2, dVar);
            this.f18582b = userDevicesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18582b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18581a;
            if (i4 == 0) {
                n.b(obj);
                I c6 = this.f18582b.i3().c();
                a aVar = new a(this.f18582b);
                this.f18581a = 1;
                if (c6.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18586a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f18586a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18586a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18587a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18587a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18587a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18588a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18589b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18588a = aVar;
            this.f18589b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18588a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18589b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserDevicesActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public UserDevicesActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new I5(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18580L = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final U0 g3(UserDevicesActivity userDevicesActivity) {
        return U0.c(userDevicesActivity.getLayoutInflater());
    }

    private final void j3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            h3().f10047e.setNavigationIcon(drawable);
            h3().f10047e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        h3().f10047e.setNavigationOnClickListener(new G5(this));
        TextView textView = h3().f10050h;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        h3().f10049g.setTypeface(aVar.x());
        h3().f10048f.setTypeface(aVar.x());
        h3().f10046d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        h3().f10046d.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        h3().f10046d.addItemDecoration(new w2.l(dimension, dimension));
    }

    /* access modifiers changed from: private */
    public static final void k3(UserDevicesActivity userDevicesActivity, View view) {
        userDevicesActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public final void l3(V v4) {
        Intent intent = new Intent(this, UserDeviceDetailsActivity.class);
        intent.putExtra("user_device", v4);
        this.f18580L.launch(intent, UptodownApp.f17422D.b(this));
    }

    /* access modifiers changed from: private */
    public final void m3(V v4) {
        TextView textView = h3().f10051i.f10036f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        h3().f10051i.f10035e.setTypeface(aVar.x());
        h3().f10051i.f10036f.setText(v4.g());
        h3().f10051i.f10035e.setText(new q().m(v4.e()));
        h3().f10051i.getRoot().setOnClickListener(new F5(this, v4));
    }

    /* access modifiers changed from: private */
    public static final void n3(UserDevicesActivity userDevicesActivity, V v4, View view) {
        userDevicesActivity.l3(v4);
    }

    /* access modifiers changed from: private */
    public static final void o3(UserDevicesActivity userDevicesActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 3 || resultCode == 4) {
            userDevicesActivity.i3().b(userDevicesActivity);
        } else if (resultCode == 5) {
            userDevicesActivity.setResult(5);
            userDevicesActivity.getOnBackPressedDispatcher().onBackPressed();
        }
    }

    public final U0 h3() {
        return (U0) this.f18578J.getValue();
    }

    public final U i3() {
        return (U) this.f18579K.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) h3().getRoot());
        j3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (o3.L) null, new b(this, (V2.d) null), 2, (Object) null);
        i3().b(this);
    }
}
