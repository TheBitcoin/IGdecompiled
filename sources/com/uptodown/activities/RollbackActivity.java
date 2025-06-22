package com.uptodown.activities;

import J1.C1446t2;
import J1.D4;
import J1.E4;
import J1.F4;
import J1.G4;
import J1.H4;
import M1.A;
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
import c2.C1703z0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.H;
import d3.p;
import f2.C2005D;
import g2.C2048f;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;

public final class RollbackActivity extends C1446t2 implements C2005D {

    /* renamed from: V  reason: collision with root package name */
    private final g f18326V = h.a(new D4(this));

    /* renamed from: W  reason: collision with root package name */
    private final g f18327W = new ViewModelLazy(D.b(H.class), new d(this), new c(this), new e((d3.a) null, this));

    /* renamed from: X  reason: collision with root package name */
    private A f18328X;

    /* renamed from: Y  reason: collision with root package name */
    private final ActivityResultLauncher f18329Y;

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            RollbackActivity.this.Y4(false);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RollbackActivity f18332b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RollbackActivity f18333a;

            a(RollbackActivity rollbackActivity) {
                this.f18333a = rollbackActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18333a.S4().f10925b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    this.f18333a.Q4(((H.a) ((E.c) e5).a()).a());
                    this.f18333a.S4().f10930g.setVisibility(0);
                    this.f18333a.S4().f10925b.setVisibility(8);
                } else if (e5 instanceof E.b) {
                    this.f18333a.S4().f10925b.setVisibility(8);
                    this.f18333a.S4().f10929f.setVisibility(0);
                    this.f18333a.S4().f10929f.setText(this.f18333a.getString(R.string.no_results));
                } else {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RollbackActivity rollbackActivity, V2.d dVar) {
            super(2, dVar);
            this.f18332b = rollbackActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18332b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18331a;
            if (i4 == 0) {
                n.b(obj);
                I d5 = this.f18332b.T4().d();
                a aVar = new a(this.f18332b);
                this.f18331a = 1;
                if (d5.collect(aVar, this) == c5) {
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
        final /* synthetic */ ComponentActivity f18334a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f18334a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18334a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18335a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18335a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18335a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18337b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18336a = aVar;
            this.f18337b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18336a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18337b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RollbackActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public RollbackActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new E4(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18329Y = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final C1703z0 P4(RollbackActivity rollbackActivity) {
        return C1703z0.c(rollbackActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void Q4(ArrayList arrayList) {
        A a5 = this.f18328X;
        if (a5 == null) {
            this.f18328X = new A(arrayList, this, this);
            S4().f10926c.setAdapter(this.f18328X);
            return;
        }
        m.b(a5);
        a5.d(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void R4(RollbackActivity rollbackActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            rollbackActivity.K2();
            rollbackActivity.S4().f10928e.setVisibility(8);
            rollbackActivity.S4().f10929f.setText(rollbackActivity.getString(R.string.msg_checking_device_rollback));
        }
    }

    /* access modifiers changed from: private */
    public final C1703z0 S4() {
        return (C1703z0) this.f18326V.getValue();
    }

    /* access modifiers changed from: private */
    public final H T4() {
        return (H) this.f18327W.getValue();
    }

    private final void U4() {
        setContentView((View) S4().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            S4().f10927d.setNavigationIcon(drawable);
            S4().f10927d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        S4().f10927d.setNavigationOnClickListener(new F4(this));
        TextView textView = S4().f10931h;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        S4().f10926c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        S4().f10926c.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        S4().f10926c.addItemDecoration(new w2.l(dimension, dimension));
        S4().f10929f.setTypeface(aVar.x());
        if (!com.uptodown.activities.preferences.a.f18818a.i0(this)) {
            S4().f10929f.setText(getString(R.string.msg_permissions_rollback));
        }
        S4().f10930g.setTypeface(aVar.x());
        S4().f10928e.setTypeface(aVar.x());
        S4().f10928e.setOnClickListener(new G4(this));
        S4().f10925b.setOnClickListener(new H4());
    }

    /* access modifiers changed from: private */
    public static final void V4(RollbackActivity rollbackActivity, View view) {
        rollbackActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void W4(RollbackActivity rollbackActivity, View view) {
        rollbackActivity.Z4();
    }

    /* access modifiers changed from: private */
    public static final void X4(View view) {
    }

    /* access modifiers changed from: private */
    public final void Y4(boolean z4) {
        T4().c(this, z4);
    }

    private final void Z4() {
        this.f18329Y.launch(new Intent(getApplicationContext(), GdprPrivacySettings.class), UptodownApp.f17422D.b(this));
    }

    /* access modifiers changed from: protected */
    public void A4() {
    }

    public void a(int i4) {
        A a5;
        if (UptodownApp.f17422D.a0() && (a5 = this.f18328X) != null) {
            m.b(a5);
            if (i4 < a5.a().size()) {
                A a6 = this.f18328X;
                m.b(a6);
                if (((C2048f) a6.a().get(i4)).b() != 0) {
                    A a7 = this.f18328X;
                    m.b(a7);
                    Object obj = a7.a().get(i4);
                    m.d(obj, "get(...)");
                    y4((C2048f) obj);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U4();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Y4(true);
    }
}
