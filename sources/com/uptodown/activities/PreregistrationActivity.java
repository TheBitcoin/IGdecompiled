package com.uptodown.activities;

import J1.A3;
import J1.B3;
import J1.C1461v3;
import J1.C1468w3;
import J1.C1475x3;
import J1.C1482y3;
import J1.C1489z3;
import J1.C3;
import J1.D3;
import J1.E3;
import J1.F3;
import J1.G3;
import J1.H3;
import M1.C1544v;
import N1.k;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c2.C1680n0;
import c2.C1690t;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1848x;
import d2.Q1;
import d3.p;
import f2.V;
import g2.C2039G;
import g2.C2053k;
import g2.U;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import y2.q;

public final class PreregistrationActivity extends C1826a {

    /* renamed from: Q  reason: collision with root package name */
    public static final a f18165Q = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18166J = new ViewModelLazy(D.b(C1848x.class), new e(this), new d(this), new f((d3.a) null, this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18167K = h.a(new C1461v3(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1544v f18168L;

    /* renamed from: M  reason: collision with root package name */
    private C1848x.a f18169M = C1848x.a.DATE;

    /* renamed from: N  reason: collision with root package name */
    private boolean f18170N = true;

    /* renamed from: O  reason: collision with root package name */
    private final g f18171O = new g(this);

    /* renamed from: P  reason: collision with root package name */
    private final ActivityResultLauncher f18172P;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18173a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f18174b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PreregistrationActivity f18175a;

            a(PreregistrationActivity preregistrationActivity) {
                this.f18175a = preregistrationActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    if (this.f18175a.f18168L == null) {
                        this.f18175a.y3().f10670d.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    this.f18175a.y3().f10668b.getRoot().setVisibility(0);
                    E.c cVar = (E.c) e5;
                    this.f18175a.x3((ArrayList) cVar.a());
                    if (((ArrayList) cVar.a()).isEmpty()) {
                        this.f18175a.y3().f10675i.setVisibility(0);
                        this.f18175a.y3().f10668b.getRoot().setVisibility(8);
                    }
                    this.f18175a.y3().f10674h.setVisibility(0);
                    this.f18175a.y3().f10672f.setVisibility(0);
                    this.f18175a.y3().f10670d.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PreregistrationActivity preregistrationActivity, V2.d dVar) {
            super(2, dVar);
            this.f18174b = preregistrationActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18174b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18173a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18174b.z3().e();
                a aVar = new a(this.f18174b);
                this.f18173a = 1;
                if (e5.collect(aVar, this) == c5) {
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

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18176a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f18177b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2039G f18178c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PreregistrationActivity preregistrationActivity, C2039G g4, V2.d dVar) {
            super(2, dVar);
            this.f18177b = preregistrationActivity;
            this.f18178c = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18177b, this.f18178c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18176a == 0) {
                n.b(obj);
                this.f18177b.v3(this.f18178c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18179a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18179a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18179a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18180a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18180a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18180a.getViewModelStore();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18181a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18182b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18181a = aVar;
            this.f18182b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18181a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18182b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PreregistrationActivity.f.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class g implements V {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PreregistrationActivity f18183a;

        g(PreregistrationActivity preregistrationActivity) {
            this.f18183a = preregistrationActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0() && this.f18183a.f18168L != null) {
                C1544v p32 = this.f18183a.f18168L;
                m.b(p32);
                if (!p32.b().isEmpty()) {
                    C1544v p33 = this.f18183a.f18168L;
                    m.b(p33);
                    Object obj = p33.b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18183a.C2(((C2039G) obj).c());
                }
            }
        }

        public void f(int i4) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (U.f20468m.e(this.f18183a) == null) {
                this.f18183a.M3();
                return;
            }
            C1544v p32 = this.f18183a.f18168L;
            m.b(p32);
            Object obj = p32.b().get(i4);
            m.d(obj, "get(...)");
            this.f18183a.I3((C2039G) obj);
        }
    }

    public PreregistrationActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1489z3(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18172P = registerForActivityResult;
    }

    private final void A3() {
        setContentView((View) y3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        C1680n0 y32 = y3();
        if (drawable != null) {
            y32.f10673g.setNavigationIcon(drawable);
            y32.f10673g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        y32.f10673g.setNavigationOnClickListener(new A3(this));
        TextView textView = y32.f10676j;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        y32.f10674h.setTypeface(aVar.w());
        y32.f10672f.setLayoutManager(new LinearLayoutManager(this, 1, false));
        y32.f10672f.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        y3().f10672f.addItemDecoration(new w2.l(dimension, dimension));
        y32.f10675i.setTypeface(aVar.x());
        y32.f10670d.setOnClickListener(new B3());
        y32.f10668b.f9695c.setTypeface(aVar.x());
        y32.f10668b.f9696d.setTypeface(aVar.w());
        y32.f10674h.setOnClickListener(new C3(this));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.order_by_name));
        hashMap.put(1, getString(R.string.order_by_release_date));
        y32.f10668b.getRoot().setOnClickListener(new D3(this, hashMap, y32));
    }

    /* access modifiers changed from: private */
    public static final void B3(PreregistrationActivity preregistrationActivity, View view) {
        preregistrationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void C3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void D3(PreregistrationActivity preregistrationActivity, View view) {
        C2053k kVar = new C2053k(1090, (String) null, (String) null, 6, (C2103g) null);
        kVar.q(true);
        preregistrationActivity.P3(kVar);
    }

    /* access modifiers changed from: private */
    public static final void E3(PreregistrationActivity preregistrationActivity, HashMap hashMap, C1680n0 n0Var, View view) {
        m.b(view);
        new q(preregistrationActivity, view, hashMap, new E3(preregistrationActivity, n0Var)).c();
    }

    /* access modifiers changed from: private */
    public static final s F3(PreregistrationActivity preregistrationActivity, C1680n0 n0Var, int i4, String str) {
        m.e(str, "selectedOption");
        if (i4 == 0) {
            preregistrationActivity.f18169M = C1848x.a.NAME;
            preregistrationActivity.f18170N = false;
        } else if (i4 == 1) {
            preregistrationActivity.f18169M = C1848x.a.DATE;
            preregistrationActivity.f18170N = false;
        }
        if (((Number) preregistrationActivity.z3().f().getValue()).intValue() != i4) {
            preregistrationActivity.z3().f().setValue(Integer.valueOf(i4));
            n0Var.f10668b.f9696d.setText(str);
            preregistrationActivity.z3().h(false);
            preregistrationActivity.G3(true);
        }
        return s.f8222a;
    }

    private final void G3(boolean z4) {
        z3().d(this, this.f18169M, this.f18170N, z4);
    }

    /* access modifiers changed from: private */
    public static final void H3(PreregistrationActivity preregistrationActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            U e5 = U.f20468m.e(preregistrationActivity);
            if (e5 != null) {
                str = e5.g();
            } else {
                str = null;
            }
            if (str != null && e5.m(preregistrationActivity)) {
                UptodownApp.a aVar = UptodownApp.f17422D;
                aVar.m0(preregistrationActivity);
                aVar.l0(preregistrationActivity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void I3(C2039G g4) {
        AlertDialog j22;
        if (!isFinishing()) {
            if (!(j2() == null || (j22 = j2()) == null)) {
                j22.dismiss();
            }
            C1690t c5 = C1690t.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10767f;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10767f.setText(getString(R.string.cancel_registration));
            c5.f10765d.setTypeface(aVar.x());
            TextView textView2 = c5.f10765d;
            u2.q qVar = new u2.q();
            String string = getString(R.string.confirm_cancel_preregister, new Object[]{g4.f()});
            m.d(string, "getString(...)");
            String f4 = g4.f();
            m.b(f4);
            textView2.setText(qVar.d(string, f4, this));
            c5.f10764c.setTypeface(aVar.w());
            c5.f10766e.setTypeface(aVar.w());
            c5.f10766e.setText(getString(R.string.dialog_confirmation_verify_afirmative));
            c5.f10764c.setVisibility(0);
            c5.f10764c.setOnClickListener(new H3(this));
            c5.f10766e.setOnClickListener(new C1468w3(this, g4));
            c5.f10763b.setOnClickListener(new C1475x3(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            J2(builder.create());
            if (j2() != null) {
                AlertDialog j23 = j2();
                m.b(j23);
                Window window = j23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog j24 = j2();
                m.b(j24);
                j24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void J3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog j22 = preregistrationActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void K3(PreregistrationActivity preregistrationActivity, C2039G g4, View view) {
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new c(preregistrationActivity, g4, (V2.d) null), 3, (Object) null);
        AlertDialog j22 = preregistrationActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void L3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog j22 = preregistrationActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public final void M3() {
        AlertDialog j22;
        if (!isFinishing()) {
            if (!(j2() == null || (j22 = j2()) == null)) {
                j22.dismiss();
            }
            C1690t c5 = C1690t.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10767f;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10765d.setTypeface(aVar.x());
            c5.f10766e.setTypeface(aVar.w());
            c5.f10766e.setOnClickListener(new F3(this));
            c5.f10763b.setOnClickListener(new G3(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            J2(builder.create());
            if (j2() != null) {
                AlertDialog j23 = j2();
                m.b(j23);
                Window window = j23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog j24 = j2();
                m.b(j24);
                j24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void N3(PreregistrationActivity preregistrationActivity, View view) {
        preregistrationActivity.f18172P.launch(new Intent(preregistrationActivity.getApplicationContext(), LoginActivity.class), UptodownApp.f17422D.b(preregistrationActivity));
        AlertDialog j22 = preregistrationActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void O3(PreregistrationActivity preregistrationActivity, View view) {
        AlertDialog j22 = preregistrationActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    private final void P3(C2053k kVar) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(16908290, (Fragment) Q1.f19769i.a(kVar), (String) null).addToBackStack(String.valueOf(kVar.b())).commit();
    }

    /* access modifiers changed from: private */
    public static final C1680n0 u3(PreregistrationActivity preregistrationActivity) {
        return C1680n0.c(preregistrationActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void v3(C2039G g4) {
        z3().c(this, g4, new C1482y3(this));
    }

    /* access modifiers changed from: private */
    public static final s w3(PreregistrationActivity preregistrationActivity) {
        preregistrationActivity.G3(true);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void x3(ArrayList arrayList) {
        C1544v vVar = this.f18168L;
        if (vVar == null) {
            this.f18168L = new C1544v(arrayList, this, this.f18171O);
            y3().f10672f.setAdapter(this.f18168L);
            return;
        }
        m.b(vVar);
        vVar.c(arrayList);
    }

    /* access modifiers changed from: private */
    public final C1680n0 y3() {
        return (C1680n0) this.f18167K.getValue();
    }

    /* access modifiers changed from: private */
    public final C1848x z3() {
        return (C1848x) this.f18166J.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        G3(false);
    }
}
