package com.uptodown.activities;

import J1.C1343e3;
import J1.C1350f3;
import J1.C1357g3;
import J1.C1364h3;
import J1.C1371i3;
import J1.C1378j3;
import J1.C1385k3;
import J1.C1392l3;
import M1.r;
import N1.k;
import R2.g;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.X;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1846v;
import d3.p;
import f2.C2013d;
import g2.C2036D;
import g2.C2050h;
import g2.C2060s;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import r3.t;
import u2.E;
import u2.q;

public final class OrganizationActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f18070J = h.a(new C1392l3(this));

    /* renamed from: K  reason: collision with root package name */
    private final g f18071K = new ViewModelLazy(D.b(C1846v.class), new d(this), new c(this), new e((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public r f18072L;

    public static final class a implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f18073a;

        a(OrganizationActivity organizationActivity) {
            this.f18073a = organizationActivity;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0()) {
                this.f18073a.C2(hVar.e());
            }
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f18075b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OrganizationActivity f18076a;

            a(OrganizationActivity organizationActivity) {
                this.f18076a = organizationActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (m.a(e5, E.a.f21883a)) {
                    if (this.f18076a.f18072L == null) {
                        this.f18076a.p3().f10130g.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (!((C1846v.a) cVar.a()).a()) {
                        this.f18076a.r3(((C1846v.a) cVar.a()).b());
                        this.f18076a.o3(((C1846v.a) cVar.a()).b());
                    } else {
                        r j32 = this.f18076a.f18072L;
                        m.b(j32);
                        j32.a(((C1846v.a) cVar.a()).b().j());
                    }
                    this.f18076a.p3().f10130g.setVisibility(8);
                    this.f18076a.p3().f10134k.setVisibility(0);
                    r j33 = this.f18076a.f18072L;
                    if (j33 != null) {
                        j33.c(false);
                    }
                } else if (m.a(e5, E.b.f21884a)) {
                    r j34 = this.f18076a.f18072L;
                    if (j34 != null) {
                        j34.c(false);
                    }
                } else {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OrganizationActivity organizationActivity, V2.d dVar) {
            super(2, dVar);
            this.f18075b = organizationActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18075b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18074a;
            if (i4 == 0) {
                n.b(obj);
                I h4 = this.f18075b.q3().h();
                a aVar = new a(this.f18075b);
                this.f18074a = 1;
                if (h4.collect(aVar, this) == c5) {
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
        final /* synthetic */ ComponentActivity f18077a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f18077a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18077a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18078a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18078a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18078a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18079a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18080b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18079a = aVar;
            this.f18080b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18079a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18080b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OrganizationActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2060s f18082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f18083c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2060s sVar, OrganizationActivity organizationActivity, V2.d dVar) {
            super(2, dVar);
            this.f18082b = sVar;
            this.f18083c = organizationActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18082b, this.f18083c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String w4;
            W2.b.c();
            if (this.f18081a == 0) {
                n.b(obj);
                C2060s sVar = this.f18082b;
                if (!(sVar == null || (w4 = sVar.w()) == null || w4.length() == 0 || this.f18083c.f18072L == null)) {
                    r j32 = this.f18083c.f18072L;
                    m.b(j32);
                    String w5 = this.f18082b.w();
                    m.b(w5);
                    RecyclerView recyclerView = this.f18083c.p3().f10133j;
                    m.d(recyclerView, "rvOrganization");
                    j32.d(w5, recyclerView);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final void A3() {
        q3().e(this);
    }

    private final void B3() {
        q3().f(this);
    }

    /* access modifiers changed from: private */
    public static final X n3(OrganizationActivity organizationActivity) {
        return X.c(organizationActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void o3(C2036D d5) {
        String k4;
        if (!(this.f18072L != null || (k4 = d5.k()) == null || k4.length() == 0)) {
            a aVar = new a(this);
            String k5 = d5.k();
            m.b(k5);
            this.f18072L = new r(aVar, k5);
            p3().f10133j.setAdapter(this.f18072L);
        }
        r rVar = this.f18072L;
        if (rVar != null) {
            rVar.b(d5.i(), d5.g(), d5.b(), d5.j());
        }
    }

    /* access modifiers changed from: private */
    public final X p3() {
        return (X) this.f18070J.getValue();
    }

    /* access modifiers changed from: private */
    public final C1846v q3() {
        return (C1846v) this.f18071K.getValue();
    }

    /* access modifiers changed from: private */
    public final void r3(C2036D d5) {
        String a5;
        String e5;
        if (!q3().l()) {
            X p32 = p3();
            p32.f10139p.setText(d5.k());
            String c5 = d5.c();
            if (c5 == null || c5.length() == 0 || (a5 = d5.a()) == null || a5.length() == 0 || (e5 = d5.e()) == null || e5.length() == 0) {
                p3().f10132i.setVisibility(8);
            } else {
                String c6 = d5.c();
                if (!(c6 == null || c6.length() == 0)) {
                    com.squareup.picasso.s.h().l(d5.d()).n(UptodownApp.f17422D.h0(this)).i(p32.f10125b);
                }
                String e6 = d5.e();
                if (!(e6 == null || e6.length() == 0)) {
                    com.squareup.picasso.s.h().l(d5.f()).n(UptodownApp.f17422D.i0(this)).i(p32.f10127d);
                }
                TextView textView = p32.f10137n;
                k.a aVar = N1.k.f7778g;
                textView.setTypeface(aVar.w());
                p32.f10137n.setText(d5.k());
                p32.f10140q.setTypeface(aVar.w());
                p32.f10140q.setOnClickListener(new C1357g3(d5, this));
                String m4 = d5.m();
                if (!(m4 == null || m4.length() == 0)) {
                    p32.f10129f.setVisibility(0);
                    p32.f10129f.setOnClickListener(new C1364h3(this, d5));
                }
                String h4 = d5.h();
                if (!(h4 == null || h4.length() == 0)) {
                    p32.f10126c.setVisibility(0);
                    p32.f10126c.setOnClickListener(new C1371i3(this, d5));
                }
                String l4 = d5.l();
                if (!(l4 == null || l4.length() == 0)) {
                    p32.f10128e.setVisibility(0);
                    p32.f10128e.setOnClickListener(new C1378j3(this, d5));
                }
                p32.f10136m.setTypeface(aVar.x());
                p32.f10136m.setText(d5.a());
                p32.f10138o.setTypeface(aVar.w());
                p32.f10138o.setOnClickListener(new C1385k3(d5, p32));
            }
            q3().o(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void s3(C2036D d5, OrganizationActivity organizationActivity, View view) {
        if (d5.n() != null) {
            q qVar = new q();
            String n4 = d5.n();
            m.b(n4);
            qVar.q(organizationActivity, n4, d5.k());
        }
    }

    /* access modifiers changed from: private */
    public static final void t3(OrganizationActivity organizationActivity, C2036D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            q qVar = new q();
            String m4 = d5.m();
            m.b(m4);
            q.r(qVar, organizationActivity, m4, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void u3(OrganizationActivity organizationActivity, C2036D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            q qVar = new q();
            String h4 = d5.h();
            m.b(h4);
            q.r(qVar, organizationActivity, h4, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void v3(OrganizationActivity organizationActivity, C2036D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            q qVar = new q();
            String l4 = d5.l();
            m.b(l4);
            q.r(qVar, organizationActivity, l4, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void w3(C2036D d5, X x4, View view) {
        String a5 = d5.a();
        if (a5 != null && a5.length() != 0) {
            if (x4.f10141r.getVisibility() == 0) {
                x4.f10138o.setText(R.string.read_less_desc_app_detail);
                x4.f10141r.setVisibility(8);
                x4.f10136m.setMaxLines(Integer.MAX_VALUE);
                x4.f10136m.setEllipsize((TextUtils.TruncateAt) null);
                return;
            }
            x4.f10138o.setText(R.string.read_more_desc_app_detail);
            x4.f10141r.setVisibility(0);
            x4.f10136m.setMaxLines(6);
            x4.f10136m.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    private final void x3() {
        setContentView((View) p3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        X p32 = p3();
        if (drawable != null) {
            p32.f10135l.setNavigationIcon(drawable);
            p32.f10135l.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        p32.f10135l.setNavigationOnClickListener(new C1343e3(this));
        p32.f10139p.setTypeface(N1.k.f7778g.w());
        p32.f10133j.setLayoutManager(new LinearLayoutManager(this, 1, false));
        p32.f10133j.setItemAnimator((RecyclerView.ItemAnimator) null);
        if (((CharSequence) q3().k().getValue()).length() > 0) {
            p32.f10139p.setText((CharSequence) q3().k().getValue());
        }
        p32.f10134k.getViewTreeObserver().addOnScrollChangedListener(new C1350f3(this, p32));
    }

    /* access modifiers changed from: private */
    public static final void y3(OrganizationActivity organizationActivity, View view) {
        organizationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void z3(OrganizationActivity organizationActivity, X x4) {
        if (!organizationActivity.q3().i() && !organizationActivity.q3().g()) {
            ScrollView scrollView = x4.f10134k;
            if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (x4.f10134k.getHeight() + x4.f10134k.getScrollY()) <= 0 && !organizationActivity.q3().i() && !organizationActivity.q3().g()) {
                r rVar = organizationActivity.f18072L;
                if (rVar != null) {
                    rVar.c(true);
                }
                organizationActivity.B3();
            }
        }
    }

    public final void C3(C2060s sVar) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(sVar, this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("organizationID")) {
                q3().j().setValue(Long.valueOf(extras.getLong("organizationID")));
            }
            if (extras.containsKey("organizationName")) {
                t k4 = q3().k();
                String string = extras.getString("organizationName");
                m.b(string);
                k4.setValue(string);
            }
        }
        x3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
        A3();
    }
}
