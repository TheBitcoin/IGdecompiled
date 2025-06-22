package com.uptodown.activities;

import J1.A4;
import J1.B4;
import J1.C1421p4;
import J1.C1428q4;
import J1.C1434r4;
import J1.C1441s4;
import J1.C1448t4;
import J1.C1455u4;
import J1.C1462v4;
import J1.C1469w4;
import J1.C1476x4;
import J1.C1483y4;
import J1.C1490z4;
import J1.C4;
import M1.C1548z;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.o;
import c2.C1701y0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.G;
import d3.p;
import f2.C2004C;
import f2.K;
import g2.C2050h;
import g2.N;
import g2.U;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
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
import u2.F;
import w2.v;

public final class ReviewsActivity extends C1826a {

    /* renamed from: O  reason: collision with root package name */
    public static final a f18305O = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18306J = R2.h.a(new C1421p4(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18307K = new ViewModelLazy(D.b(G.class), new g(this), new f(this), new h((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1548z f18308L;

    /* renamed from: M  reason: collision with root package name */
    private final e f18309M = new e(this);

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f18310N;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f18312b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f18313a;

            a(ReviewsActivity reviewsActivity) {
                this.f18313a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (m.a(e5, E.a.f21883a)) {
                    this.f18313a.v3().r(true);
                    if (this.f18313a.f18308L == null) {
                        this.f18313a.t3().f10893k.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    this.f18313a.v3().r(false);
                    if (this.f18313a.f18308L == null) {
                        this.f18313a.K3(((G.a) ((E.c) e5).a()).a());
                        this.f18313a.t3().f10896n.setAdapter(this.f18313a.f18308L);
                    } else {
                        Iterator it = ((G.a) ((E.c) e5).a()).a().iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            C1548z o32 = this.f18313a.f18308L;
                            m.b(o32);
                            o32.a((N) next);
                        }
                    }
                    C1548z o33 = this.f18313a.f18308L;
                    if (o33 != null) {
                        o33.c(false);
                    }
                    this.f18313a.t3().f10893k.setVisibility(8);
                } else if (!m.a(e5, E.b.f21884a)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReviewsActivity reviewsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18312b = reviewsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18312b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18311a;
            if (i4 == 0) {
                n.b(obj);
                I f4 = this.f18312b.v3().f();
                a aVar = new a(this.f18312b);
                this.f18311a = 1;
                if (f4.collect(aVar, this) == c5) {
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
        int f18314a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f18315b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f18316a;

            a(ReviewsActivity reviewsActivity) {
                this.f18316a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (m.a(e5, E.a.f21883a)) {
                    this.f18316a.v3().r(true);
                    this.f18316a.t3().f10893k.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((G.b) cVar.a()).b() == 1) {
                        ReviewsActivity reviewsActivity = this.f18316a;
                        String string = reviewsActivity.getString(R.string.review_sended);
                        m.d(string, "getString(...)");
                        reviewsActivity.q0(string);
                        this.f18316a.t3().f10884b.setText("");
                    } else if (((G.b) cVar.a()).a() == 403) {
                        ReviewsActivity reviewsActivity2 = this.f18316a;
                        String string2 = reviewsActivity2.getString(R.string.email_validation_msg);
                        m.d(string2, "getString(...)");
                        reviewsActivity2.q0(string2);
                    } else if (((G.b) cVar.a()).b() == 0 && ((G.b) cVar.a()).a() == 0) {
                        ReviewsActivity reviewsActivity3 = this.f18316a;
                        String string3 = reviewsActivity3.getString(R.string.error_review_already_submitted);
                        m.d(string3, "getString(...)");
                        reviewsActivity3.q0(string3);
                    } else {
                        ReviewsActivity reviewsActivity4 = this.f18316a;
                        String string4 = reviewsActivity4.getString(R.string.error_generico);
                        m.d(string4, "getString(...)");
                        reviewsActivity4.q0(string4);
                    }
                } else if (!m.a(e5, E.b.f21884a)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ReviewsActivity reviewsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18315b = reviewsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18315b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18314a;
            if (i4 == 0) {
                n.b(obj);
                I n4 = this.f18315b.v3().n();
                a aVar = new a(this.f18315b);
                this.f18314a = 1;
                if (n4.collect(aVar, this) == c5) {
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

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18317a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f18318b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f18319a;

            a(ReviewsActivity reviewsActivity) {
                this.f18319a = reviewsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((N.c) cVar.a()).b() == 1) {
                            C1548z o32 = this.f18319a.f18308L;
                            if (o32 != null) {
                                o32.d(((N.c) cVar.a()).a());
                            }
                        } else {
                            ReviewsActivity reviewsActivity = this.f18319a;
                            String string = reviewsActivity.getString(R.string.error_generico);
                            m.d(string, "getString(...)");
                            reviewsActivity.q0(string);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ReviewsActivity reviewsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18318b = reviewsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18318b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18317a;
            if (i4 == 0) {
                n.b(obj);
                I l4 = this.f18318b.v3().l();
                a aVar = new a(this.f18318b);
                this.f18317a = 1;
                if (l4.collect(aVar, this) == c5) {
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e implements C2004C {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReviewsActivity f18320a;

        public static final class a implements K {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ReviewsActivity f18321a;

            a(ReviewsActivity reviewsActivity) {
                this.f18321a = reviewsActivity;
            }

            public void a(U u4) {
                m.e(u4, "user");
                Intent intent = new Intent(this.f18321a, PublicProfileActivity.class);
                intent.putExtra("user", u4);
                ReviewsActivity reviewsActivity = this.f18321a;
                reviewsActivity.startActivity(intent, UptodownApp.f17422D.a(reviewsActivity));
            }

            public void b() {
            }
        }

        e(ReviewsActivity reviewsActivity) {
            this.f18320a = reviewsActivity;
        }

        public void a(int i4) {
            N n4;
            ArrayList b5;
            C1548z o32 = this.f18320a.f18308L;
            if (o32 == null || (b5 = o32.b()) == null) {
                n4 = null;
            } else {
                n4 = (N) b5.get(i4);
            }
            if (UptodownApp.f17422D.a0() && n4 != null && !F.f21886a.i(n4.f())) {
                this.f18320a.v3().o(this.f18320a, n4);
            }
        }

        public void b() {
            this.f18320a.Y2();
        }

        public void c(int i4) {
            N n4;
            ArrayList b5;
            if (UptodownApp.f17422D.a0()) {
                C1548z o32 = this.f18320a.f18308L;
                if (o32 == null || (b5 = o32.b()) == null) {
                    n4 = null;
                } else {
                    n4 = (N) b5.get(i4);
                }
                if (n4 != null) {
                    ReviewsActivity reviewsActivity = this.f18320a;
                    o oVar = new o(reviewsActivity, LifecycleOwnerKt.getLifecycleScope(reviewsActivity));
                    String l4 = n4.l();
                    m.b(l4);
                    oVar.b(l4, new a(this.f18320a));
                }
            }
        }

        public void d(int i4) {
            N n4;
            ArrayList b5;
            C1548z o32 = this.f18320a.f18308L;
            String str = null;
            if (o32 == null || (b5 = o32.b()) == null) {
                n4 = null;
            } else {
                n4 = (N) b5.get(i4);
            }
            Intent intent = new Intent(this.f18320a, RepliesActivity.class);
            intent.putExtra("review", n4);
            C2050h hVar = (C2050h) this.f18320a.v3().e().getValue();
            if (hVar != null) {
                str = hVar.L();
            }
            if (!(str == null || str.length() == 0)) {
                Object value = this.f18320a.v3().e().getValue();
                m.b(value);
                intent.putExtra("appName", ((C2050h) value).L());
            }
            ReviewsActivity reviewsActivity = this.f18320a;
            reviewsActivity.startActivity(intent, UptodownApp.f17422D.a(reviewsActivity));
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18322a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18322a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18322a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18323a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f18323a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18323a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18324a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18325b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18324a = aVar;
            this.f18325b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18324a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18325b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.ReviewsActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public ReviewsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1455u4(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18310N = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void A3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void B3(ReviewsActivity reviewsActivity, View view) {
        String str;
        Object systemService = reviewsActivity.getSystemService("input_method");
        m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(reviewsActivity.t3().f10884b.getWindowToken(), 0);
        reviewsActivity.t3().f10884b.clearFocus();
        U e5 = U.f20468m.e(reviewsActivity);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            reviewsActivity.L3();
            return;
        }
        Editable text = reviewsActivity.t3().f10884b.getText();
        m.d(text, "getText(...)");
        reviewsActivity.N3(m3.m.u0(text).toString());
    }

    /* access modifiers changed from: private */
    public static final void C3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            reviewsActivity.v3().m().setValue(1);
            reviewsActivity.t3().f10886d.setImageDrawable(drawable);
            reviewsActivity.t3().f10887e.setImageDrawable(drawable2);
            reviewsActivity.t3().f10888f.setImageDrawable(drawable2);
            reviewsActivity.t3().f10889g.setImageDrawable(drawable2);
            reviewsActivity.t3().f10890h.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void D3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            reviewsActivity.v3().m().setValue(2);
            reviewsActivity.t3().f10886d.setImageDrawable(drawable);
            reviewsActivity.t3().f10887e.setImageDrawable(drawable);
            reviewsActivity.t3().f10888f.setImageDrawable(drawable2);
            reviewsActivity.t3().f10889g.setImageDrawable(drawable2);
            reviewsActivity.t3().f10890h.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void E3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            reviewsActivity.v3().m().setValue(3);
            reviewsActivity.t3().f10886d.setImageDrawable(drawable);
            reviewsActivity.t3().f10887e.setImageDrawable(drawable);
            reviewsActivity.t3().f10888f.setImageDrawable(drawable);
            reviewsActivity.t3().f10889g.setImageDrawable(drawable2);
            reviewsActivity.t3().f10890h.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            reviewsActivity.v3().m().setValue(4);
            reviewsActivity.t3().f10886d.setImageDrawable(drawable);
            reviewsActivity.t3().f10887e.setImageDrawable(drawable);
            reviewsActivity.t3().f10888f.setImageDrawable(drawable);
            reviewsActivity.t3().f10889g.setImageDrawable(drawable);
            reviewsActivity.t3().f10890h.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(ReviewsActivity reviewsActivity, Drawable drawable, View view) {
        if (UptodownApp.f17422D.a0()) {
            reviewsActivity.v3().m().setValue(5);
            reviewsActivity.t3().f10886d.setImageDrawable(drawable);
            reviewsActivity.t3().f10887e.setImageDrawable(drawable);
            reviewsActivity.t3().f10888f.setImageDrawable(drawable);
            reviewsActivity.t3().f10889g.setImageDrawable(drawable);
            reviewsActivity.t3().f10890h.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    public static final void H3(ReviewsActivity reviewsActivity, View view) {
        if (!m.a(reviewsActivity.v3().k().getValue(), "date")) {
            reviewsActivity.v3().k().setValue("date");
            TextView textView = reviewsActivity.t3().f10902t;
            m.d(textView, "tvOrderByDateReviews");
            v.a(textView);
            reviewsActivity.t3().f10901s.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10901s.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.t3().f10903u.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10903u.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.M3();
        }
    }

    /* access modifiers changed from: private */
    public static final void I3(ReviewsActivity reviewsActivity, View view) {
        if (!m.a(reviewsActivity.v3().k().getValue(), "best")) {
            reviewsActivity.v3().k().setValue("best");
            TextView textView = reviewsActivity.t3().f10901s;
            m.d(textView, "tvOrderByBestReviews");
            v.a(textView);
            reviewsActivity.t3().f10902t.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10902t.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.t3().f10903u.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10903u.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.M3();
        }
    }

    /* access modifiers changed from: private */
    public static final void J3(ReviewsActivity reviewsActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            U e5 = U.f20468m.e(reviewsActivity);
            if (e5 != null) {
                str = e5.g();
            } else {
                str = null;
            }
            if (str != null && e5.m(reviewsActivity)) {
                UptodownApp.a aVar = UptodownApp.f17422D;
                aVar.m0(reviewsActivity);
                aVar.l0(reviewsActivity);
                reviewsActivity.N3(reviewsActivity.t3().f10884b.getText().toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void K3(ArrayList arrayList) {
        this.f18308L = new C1548z(arrayList, this, this.f18309M);
    }

    private final void L3() {
        this.f18310N.launch(new Intent(this, LoginActivity.class), UptodownApp.f17422D.b(this));
    }

    private final void M3() {
        t3().f10896n.setAdapter((RecyclerView.Adapter) null);
        this.f18308L = null;
        v3().q(true);
        v3().s(0);
        u3();
    }

    private final void N3(String str) {
        int intValue = ((Number) v3().m().getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            String string = getString(R.string.error_review_no_valoration);
            m.d(string, "getString(...)");
            q0(string);
            return;
        }
        v3().p(this, str);
    }

    /* access modifiers changed from: private */
    public static final C1701y0 s3(ReviewsActivity reviewsActivity) {
        return C1701y0.c(reviewsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C1701y0 t3() {
        return (C1701y0) this.f18306J.getValue();
    }

    private final void u3() {
        if (v3().g()) {
            v3().d(this);
        }
    }

    /* access modifiers changed from: private */
    public final G v3() {
        return (G) this.f18307K.getValue();
    }

    private final void w3() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            t3().f10897o.setNavigationIcon(drawable);
            t3().f10897o.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t3().f10897o.setNavigationOnClickListener(new C1462v4(this));
        u2.m mVar = new u2.m();
        C2050h hVar = (C2050h) v3().e().getValue();
        String str6 = null;
        if (hVar != null) {
            str = hVar.Q();
        } else {
            str = null;
        }
        if (mVar.s(str, this)) {
            F f4 = F.f21886a;
            C2050h hVar2 = (C2050h) v3().e().getValue();
            if (hVar2 != null) {
                str5 = hVar2.Q();
            } else {
                str5 = null;
            }
            t3().f10885c.setImageDrawable(f4.k(this, str5));
        } else {
            com.squareup.picasso.s h4 = com.squareup.picasso.s.h();
            C2050h hVar3 = (C2050h) v3().e().getValue();
            if (hVar3 != null) {
                str4 = hVar3.F();
            } else {
                str4 = null;
            }
            h4.l(str4).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(this)).i(t3().f10885c);
        }
        TextView textView = t3().f10905w;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        t3().f10899q.setTypeface(aVar.w());
        TextView textView2 = t3().f10899q;
        C2050h hVar4 = (C2050h) v3().e().getValue();
        if (hVar4 != null) {
            str2 = hVar4.L();
        } else {
            str2 = null;
        }
        textView2.setText(str2);
        t3().f10900r.setTypeface(aVar.x());
        TextView textView3 = t3().f10900r;
        C2050h hVar5 = (C2050h) v3().e().getValue();
        if (hVar5 != null) {
            str3 = hVar5.w0();
        } else {
            str3 = null;
        }
        textView3.setText(str3);
        t3().f10898p.setTypeface(aVar.x());
        TextView textView4 = t3().f10898p;
        C2050h hVar6 = (C2050h) v3().e().getValue();
        if (hVar6 != null) {
            str6 = hVar6.g();
        }
        textView4.setText(str6);
        t3().f10884b.setTypeface(aVar.x());
        t3().f10904v.setTypeface(aVar.w());
        t3().f10904v.setOnClickListener(new C1483y4(this));
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.vector_star_on);
        Drawable drawable3 = ContextCompat.getDrawable(this, R.drawable.vector_star_off);
        if (v3().i().getValue() != null) {
            Object value = v3().i().getValue();
            m.b(value);
            if (((N) value).h() >= 1) {
                t3().f10886d.setImageDrawable(drawable2);
            }
            Object value2 = v3().i().getValue();
            m.b(value2);
            if (((N) value2).h() >= 2) {
                t3().f10887e.setImageDrawable(drawable2);
            }
            Object value3 = v3().i().getValue();
            m.b(value3);
            if (((N) value3).h() >= 3) {
                t3().f10888f.setImageDrawable(drawable2);
            }
            Object value4 = v3().i().getValue();
            m.b(value4);
            if (((N) value4).h() >= 4) {
                t3().f10889g.setImageDrawable(drawable2);
            }
            Object value5 = v3().i().getValue();
            m.b(value5);
            if (((N) value5).h() == 5) {
                t3().f10890h.setImageDrawable(drawable2);
            }
            Object value6 = v3().i().getValue();
            m.b(value6);
            String i4 = ((N) value6).i();
            if (!(i4 == null || i4.length() == 0)) {
                EditText editText = t3().f10884b;
                Object value7 = v3().i().getValue();
                m.b(value7);
                editText.setText(String.valueOf(((N) value7).i()));
            }
            t3().f10904v.setText(getString(R.string.edit_your_review));
        }
        t3().f10886d.setOnClickListener(new C1490z4(this, drawable2, drawable3));
        t3().f10887e.setOnClickListener(new A4(this, drawable2, drawable3));
        t3().f10888f.setOnClickListener(new B4(this, drawable2, drawable3));
        t3().f10889g.setOnClickListener(new C4(this, drawable2, drawable3));
        t3().f10890h.setOnClickListener(new C1428q4(this, drawable2));
        t3().f10902t.setTypeface(aVar.w());
        t3().f10902t.setOnClickListener(new C1434r4(this));
        t3().f10901s.setTypeface(aVar.w());
        t3().f10901s.setOnClickListener(new C1441s4(this));
        t3().f10903u.setTypeface(aVar.w());
        t3().f10903u.setOnClickListener(new C1448t4(this));
        t3().f10896n.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        t3().f10896n.addItemDecoration(new w2.o(dimension, dimension, dimension, dimension));
        t3().f10894l.setOnScrollChangeListener(new C1469w4(this));
        t3().f10893k.setOnClickListener(new C1476x4());
    }

    /* access modifiers changed from: private */
    public static final void x3(ReviewsActivity reviewsActivity, View view) {
        reviewsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void y3(ReviewsActivity reviewsActivity, View view) {
        if (!m.a(reviewsActivity.v3().k().getValue(), "most")) {
            reviewsActivity.v3().k().setValue("most");
            TextView textView = reviewsActivity.t3().f10903u;
            m.d(textView, "tvOrderByMostReviews");
            v.a(textView);
            reviewsActivity.t3().f10901s.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10901s.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.t3().f10902t.setBackground(ContextCompat.getDrawable(reviewsActivity, R.drawable.ripple_header_categories));
            reviewsActivity.t3().f10902t.setTextColor(ContextCompat.getColorStateList(reviewsActivity, R.color.selector_wizard_accept_button_text));
            reviewsActivity.M3();
        }
    }

    /* access modifiers changed from: private */
    public static final void z3(ReviewsActivity reviewsActivity, NestedScrollView nestedScrollView, int i4, int i5, int i6, int i7) {
        m.e(nestedScrollView, "v");
        if (i5 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && !reviewsActivity.v3().h() && reviewsActivity.v3().g()) {
            reviewsActivity.v3().r(true);
            C1548z zVar = reviewsActivity.f18308L;
            if (zVar != null) {
                zVar.c(true);
            }
            reviewsActivity.u3();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((View) t3().getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("appInfo")) {
                t e5 = v3().e();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable2 = extras.getParcelable("appInfo");
                }
                m.b(parcelable2);
                e5.setValue(parcelable2);
            }
            if (extras.containsKey("myReview")) {
                t i4 = v3().i();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("myReview", N.class);
                } else {
                    parcelable = extras.getParcelable("myReview");
                }
                i4.setValue(parcelable);
                if (v3().i().getValue() != null) {
                    t m4 = v3().m();
                    Object value = v3().i().getValue();
                    m.b(value);
                    m4.setValue(Integer.valueOf(((N) value).h()));
                }
            }
        }
        w3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
        u3();
    }
}
