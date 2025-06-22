package com.uptodown.activities;

import J1.C1446t2;
import J1.Q4;
import J1.R4;
import J1.S4;
import J1.T4;
import J1.U4;
import J1.V4;
import J1.W4;
import J1.X4;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b2.C1640l;
import c2.C0;
import c2.r;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.K;
import d3.p;
import f2.C2011b;
import f2.C2027s;
import g2.C2048f;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import u2.q;

public final class SecurityActivity extends C1446t2 {

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f18387V = R2.h.a(new T4(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f18388W = new ViewModelLazy(D.b(K.class), new g(this), new f(this), new h((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public boolean f18389X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public M1.D f18390Y;

    /* renamed from: Z  reason: collision with root package name */
    private j f18391Z = new j(this);

    /* renamed from: m0  reason: collision with root package name */
    private final b f18392m0 = new b(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18393a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18394b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C0 f18395c;

        /* renamed from: com.uptodown.activities.SecurityActivity$a$a  reason: collision with other inner class name */
        static final class C0228a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f18396a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C0 f18397b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0228a(C0 c02, V2.d dVar) {
                super(2, dVar);
                this.f18397b = c02;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0228a(this.f18397b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f18396a == 0) {
                    n.b(obj);
                    this.f18397b.f9707c.setVisibility(0);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0228a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SecurityActivity securityActivity, C0 c02, V2.d dVar) {
            super(2, dVar);
            this.f18394b = securityActivity;
            this.f18395c = c02;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18394b, this.f18395c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18393a;
            if (i4 == 0) {
                n.b(obj);
                E0 c6 = Y.c();
                C0228a aVar = new C0228a(this.f18395c, (V2.d) null);
                this.f18393a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f18394b.t4();
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class b implements C2011b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18398a;

        b(SecurityActivity securityActivity) {
            this.f18398a = securityActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0() && !this.f18398a.f18389X) {
                M1.D P4 = this.f18398a.f18390Y;
                m.b(P4);
                if (P4.b().get(i4) instanceof C2048f) {
                    M1.D P42 = this.f18398a.f18390Y;
                    m.b(P42);
                    Object obj = P42.b().get(i4);
                    m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                    this.f18398a.V4((C2048f) obj);
                }
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18399a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18400b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SecurityActivity f18401a;

            a(SecurityActivity securityActivity) {
                this.f18401a = securityActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18401a.a5().f9707c.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((K.a) cVar.a()).a().isEmpty()) {
                        this.f18401a.a5().f9708d.setVisibility(0);
                        this.f18401a.a5().f9709e.setVisibility(8);
                        this.f18401a.a5().f9712h.setText(this.f18401a.getString(R.string.uptodown_last_analysis, new Object[]{String.valueOf(new q().l(com.uptodown.activities.preferences.a.f18818a.q(this.f18401a)))}));
                    } else {
                        this.f18401a.a5().f9709e.setVisibility(0);
                        this.f18401a.a5().f9708d.setVisibility(8);
                        this.f18401a.j5(((K.a) cVar.a()).a());
                    }
                    this.f18401a.a5().f9707c.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SecurityActivity securityActivity, V2.d dVar) {
            super(2, dVar);
            this.f18400b = securityActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18400b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18399a;
            if (i4 == 0) {
                n.b(obj);
                I b5 = this.f18400b.b5().b();
                a aVar = new a(this.f18400b);
                this.f18399a = 1;
                if (b5.collect(aVar, this) == c5) {
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
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2048f f18403b;

        d(SecurityActivity securityActivity, C2048f fVar) {
            this.f18402a = securityActivity;
            this.f18403b = fVar;
        }

        public void b(int i4) {
            SecurityActivity securityActivity = this.f18402a;
            String string = securityActivity.getString(R.string.rollback_not_available, new Object[]{this.f18403b.m()});
            m.d(string, "getString(...)");
            securityActivity.q0(string);
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (hVar.c()) {
                Intent intent = new Intent(this.f18402a.getApplicationContext(), OldVersionsActivity.class);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f18403b);
                intent.putExtra("appInfo", hVar);
                SecurityActivity securityActivity = this.f18402a;
                securityActivity.startActivity(intent, UptodownApp.f17422D.a(securityActivity));
                return;
            }
            SecurityActivity securityActivity2 = this.f18402a;
            String string = securityActivity2.getString(R.string.rollback_not_available, new Object[]{hVar.L()});
            m.d(string, "getString(...)");
            securityActivity2.q0(string);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18405b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SecurityActivity securityActivity, V2.d dVar) {
            super(2, dVar);
            this.f18405b = securityActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18405b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18404a == 0) {
                n.b(obj);
                this.f18405b.a5().f9707c.setVisibility(8);
                this.f18405b.a5().f9712h.setText(this.f18405b.getString(R.string.uptodown_last_analysis, new Object[]{String.valueOf(new q().l(com.uptodown.activities.preferences.a.f18818a.q(this.f18405b)))}));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18406a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18406a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18406a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18407a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f18407a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18407a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18408a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18409b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18408a = aVar;
            this.f18409b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18408a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18409b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SecurityActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18411b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(SecurityActivity securityActivity, V2.d dVar) {
            super(2, dVar);
            this.f18411b = securityActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f18411b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18410a == 0) {
                n.b(obj);
                this.f18411b.i5();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class j implements f2.I {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f18412a;

        j(SecurityActivity securityActivity) {
            this.f18412a = securityActivity;
        }

        public void a() {
        }

        public void b() {
            this.f18412a.t4();
        }
    }

    /* access modifiers changed from: private */
    public static final C0 U4(SecurityActivity securityActivity) {
        return C0.c(securityActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void V4(C2048f fVar) {
        if (!isFinishing() && fVar != null) {
            r c5 = r.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            J2(new AlertDialog.Builder(this).setView(c5.getRoot()).create());
            TextView textView = c5.f10732c;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10732c.setText(fVar.m());
            if (fVar.o() == null || fVar.k() == null || fVar.b() <= 0) {
                c5.f10731b.setVisibility(8);
                c5.f10735f.setVisibility(8);
                c5.f10733d.setVisibility(8);
            } else {
                c5.f10731b.setTypeface(aVar.x());
                c5.f10731b.setOnClickListener(new U4(this, fVar));
                c5.f10735f.setTypeface(aVar.x());
                c5.f10735f.setOnClickListener(new V4(this, fVar));
                c5.f10733d.setTypeface(aVar.x());
                c5.f10733d.setOnClickListener(new W4(this, fVar));
            }
            if (!m3.m.p(getPackageName(), fVar.o(), true)) {
                c5.f10734e.setTypeface(aVar.x());
                c5.f10734e.setOnClickListener(new X4(fVar, this));
            } else {
                c5.f10734e.setVisibility(8);
            }
            if (!isFinishing()) {
                AlertDialog j22 = j2();
                m.b(j22);
                Window window = j22.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog j23 = j2();
                m.b(j23);
                j23.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void W4(SecurityActivity securityActivity, C2048f fVar, View view) {
        securityActivity.C2(fVar.b());
        AlertDialog j22 = securityActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void X4(SecurityActivity securityActivity, C2048f fVar, View view) {
        securityActivity.F2(fVar.r());
        AlertDialog j22 = securityActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void Y4(SecurityActivity securityActivity, C2048f fVar, View view) {
        securityActivity.h5(fVar);
        AlertDialog j22 = securityActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void Z4(C2048f fVar, SecurityActivity securityActivity, View view) {
        if (fVar.o() != null) {
            N1.j jVar = new N1.j(securityActivity);
            String o4 = fVar.o();
            m.b(o4);
            jVar.h(o4);
        }
        AlertDialog j22 = securityActivity.j2();
        m.b(j22);
        j22.dismiss();
    }

    /* access modifiers changed from: private */
    public final C0 a5() {
        return (C0) this.f18387V.getValue();
    }

    /* access modifiers changed from: private */
    public final K b5() {
        return (K) this.f18388W.getValue();
    }

    private final void c5() {
        setContentView((View) a5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            a5().f9710f.setNavigationIcon(drawable);
            a5().f9710f.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        C0 a5 = a5();
        a5.f9710f.setNavigationOnClickListener(new Q4(this));
        TextView textView = a5.f9714j;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        a5.f9709e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        a5.f9709e.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) a5.f9709e.getItemAnimator();
        m.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        a5.f9709e.addItemDecoration(new w2.l((int) getResources().getDimension(R.dimen.margin_m), 0));
        a5.f9707c.setOnClickListener(new R4());
        a5.f9713i.setTypeface(aVar.w());
        a5.f9712h.setTypeface(aVar.x());
        a5.f9711g.setTypeface(aVar.w());
        a5.f9711g.setOnClickListener(new S4(this, a5));
    }

    /* access modifiers changed from: private */
    public static final void d5(SecurityActivity securityActivity, View view) {
        securityActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void e5(View view) {
    }

    /* access modifiers changed from: private */
    public static final void f5(SecurityActivity securityActivity, C0 c02, View view) {
        if (UptodownApp.f17422D.a0()) {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(securityActivity), Y.b(), (L) null, new a(securityActivity, c02, (V2.d) null), 2, (Object) null);
        }
    }

    private final void g5() {
        b5().a(this);
    }

    private final void h5(C2048f fVar) {
        new C1640l(this, fVar.b(), new d(this, fVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void j5(ArrayList arrayList) {
        M1.D d5 = this.f18390Y;
        if (d5 == null) {
            b bVar = this.f18392m0;
            j jVar = this.f18391Z;
            m.b(jVar);
            this.f18390Y = new M1.D(arrayList, this, bVar, jVar);
            a5().f9709e.setAdapter(this.f18390Y);
            return;
        }
        m.b(d5);
        d5.c(arrayList);
    }

    /* access modifiers changed from: protected */
    public void A4() {
        g5();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(this, (V2.d) null), 2, (Object) null);
    }

    public final void i5() {
        if (a5().f9707c.getVisibility() == 8) {
            t4();
            g5();
        }
    }

    public final void k5() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new i(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c5();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        m.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i4 != 82) {
            return super.onKeyDown(i4, keyEvent);
        }
        a5().f9710f.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        t4();
        C2313C.f21882a.h(this);
    }
}
