package com.uptodown.activities;

import J1.C1330c4;
import J1.C1337d4;
import J1.C1344e4;
import J1.C1351f4;
import J1.C1358g4;
import J1.C1365h4;
import J1.C1372i4;
import J1.C1379j4;
import J1.C1386k4;
import J1.C1393l4;
import J1.C1400m4;
import J1.C1407n4;
import J1.C1414o4;
import M1.C1547y;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.o;
import c2.C1693u0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.F;
import com.uptodown.activities.preferences.a;
import com.uptodown.util.views.UsernameTextView;
import d3.p;
import f2.C2003B;
import f2.K;
import g2.C2042J;
import g2.N;
import g2.U;
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
import r3.t;
import u2.E;
import u2.q;

public final class RepliesActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18282J = R2.h.a(new C1330c4(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18283K = new ViewModelLazy(D.b(F.class), new i(this), new h(this), new j((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1547y f18284L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public final g f18285M = new g(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18286a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18287b;

        /* renamed from: com.uptodown.activities.RepliesActivity$a$a  reason: collision with other inner class name */
        static final class C0226a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f18288a;

            C0226a(RepliesActivity repliesActivity) {
                this.f18288a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    if (this.f18288a.f18284L == null) {
                        this.f18288a.t3().f10784d.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((F.a) cVar.a()).a()) {
                        C1547y n32 = this.f18288a.f18284L;
                        if (n32 != null) {
                            n32.a(((F.a) cVar.a()).b());
                        }
                    } else if (!((F.a) cVar.a()).b().isEmpty()) {
                        RepliesActivity repliesActivity = this.f18288a;
                        ArrayList b5 = ((F.a) cVar.a()).b();
                        Context applicationContext = this.f18288a.getApplicationContext();
                        m.d(applicationContext, "getApplicationContext(...)");
                        repliesActivity.f18284L = new C1547y(b5, applicationContext, this.f18288a.f18285M);
                        this.f18288a.t3().f10790j.setAdapter(this.f18288a.f18284L);
                    } else {
                        this.f18288a.t3().f10793m.setVisibility(0);
                    }
                    this.f18288a.t3().f10786f.setVisibility(0);
                    this.f18288a.t3().f10784d.setVisibility(8);
                    C1547y n33 = this.f18288a.f18284L;
                    if (n33 != null) {
                        n33.b(false);
                    }
                } else if (e5 instanceof E.b) {
                    C1547y n34 = this.f18288a.f18284L;
                    if (n34 != null) {
                        n34.b(false);
                    }
                } else {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(RepliesActivity repliesActivity, V2.d dVar) {
            super(2, dVar);
            this.f18287b = repliesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18287b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18286a;
            if (i4 == 0) {
                n.b(obj);
                I j4 = this.f18287b.v3().j();
                C0226a aVar = new C0226a(this.f18287b);
                this.f18286a = 1;
                if (j4.collect(aVar, this) == c5) {
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
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18290b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f18291a;

            a(RepliesActivity repliesActivity) {
                this.f18291a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((N.c) cVar.a()).b() == 1) {
                            this.f18291a.t3().f10787g.f10822p.setText(String.valueOf(((N.c) cVar.a()).a().g()));
                        } else {
                            RepliesActivity repliesActivity = this.f18291a;
                            String string = repliesActivity.getString(R.string.error_generico);
                            m.d(string, "getString(...)");
                            repliesActivity.q0(string);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RepliesActivity repliesActivity, V2.d dVar) {
            super(2, dVar);
            this.f18290b = repliesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18290b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18289a;
            if (i4 == 0) {
                n.b(obj);
                I l4 = this.f18290b.v3().l();
                a aVar = new a(this.f18290b);
                this.f18289a = 1;
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18293b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f18294a;

            a(RepliesActivity repliesActivity) {
                this.f18294a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((F.b) cVar.a()).a() == 1) {
                            C1547y n32 = this.f18294a.f18284L;
                            if (n32 != null) {
                                n32.c(((F.b) cVar.a()).b());
                            }
                        } else {
                            RepliesActivity repliesActivity = this.f18294a;
                            String string = repliesActivity.getString(R.string.error_generico);
                            m.d(string, "getString(...)");
                            repliesActivity.q0(string);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RepliesActivity repliesActivity, V2.d dVar) {
            super(2, dVar);
            this.f18293b = repliesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18293b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18292a;
            if (i4 == 0) {
                n.b(obj);
                I k4 = this.f18293b.v3().k();
                a aVar = new a(this.f18293b);
                this.f18292a = 1;
                if (k4.collect(aVar, this) == c5) {
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
        int f18295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18296b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f18297a;

            a(RepliesActivity repliesActivity) {
                this.f18297a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((F.c) cVar.a()).c() == 1) {
                            N n4 = new N();
                            U e6 = U.f20468m.e(this.f18297a);
                            if (e6 != null) {
                                n4.B(e6.h());
                                n4.t(e6.c());
                            }
                            n4.x(((F.c) cVar.a()).d());
                            this.f18297a.t3().f10782b.setText("");
                            RepliesActivity repliesActivity = this.f18297a;
                            String string = repliesActivity.getString(R.string.review_sended);
                            m.d(string, "getString(...)");
                            repliesActivity.q0(string);
                        } else if (((F.c) cVar.a()).b() == 401) {
                            this.f18297a.D3();
                        } else if (((F.c) cVar.a()).b() == 403) {
                            RepliesActivity repliesActivity2 = this.f18297a;
                            String string2 = repliesActivity2.getString(R.string.email_validation_msg);
                            m.d(string2, "getString(...)");
                            repliesActivity2.q0(string2);
                        } else {
                            String a5 = ((F.c) cVar.a()).a();
                            if (!(a5 == null || a5.length() == 0)) {
                                this.f18297a.q0(((F.c) cVar.a()).a());
                            }
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RepliesActivity repliesActivity, V2.d dVar) {
            super(2, dVar);
            this.f18296b = repliesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18296b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18295a;
            if (i4 == 0) {
                n.b(obj);
                I p4 = this.f18296b.v3().p();
                a aVar = new a(this.f18296b);
                this.f18295a = 1;
                if (p4.collect(aVar, this) == c5) {
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

    public static final class e implements K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18298a;

        e(RepliesActivity repliesActivity) {
            this.f18298a = repliesActivity;
        }

        public void a(U u4) {
            m.e(u4, "user");
            Intent intent = new Intent(this.f18298a, PublicProfileActivity.class);
            intent.putExtra("user", u4);
            RepliesActivity repliesActivity = this.f18298a;
            repliesActivity.startActivity(intent, UptodownApp.f17422D.a(repliesActivity));
        }

        public void b() {
        }
    }

    public static final class f implements K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18299a;

        f(RepliesActivity repliesActivity) {
            this.f18299a = repliesActivity;
        }

        public void a(U u4) {
            m.e(u4, "user");
            Intent intent = new Intent(this.f18299a, PublicProfileActivity.class);
            intent.putExtra("user", u4);
            RepliesActivity repliesActivity = this.f18299a;
            repliesActivity.startActivity(intent, UptodownApp.f17422D.a(repliesActivity));
        }

        public void b() {
        }
    }

    public static final class g implements C2003B {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f18300a;

        g(RepliesActivity repliesActivity) {
            this.f18300a = repliesActivity;
        }

        public void b() {
            this.f18300a.Y2();
        }

        public void c(C2042J j4) {
            m.e(j4, "reply");
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (!u2.F.f21886a.h(j4.c())) {
                this.f18300a.v3().r(this.f18300a, j4);
                return;
            }
            RepliesActivity repliesActivity = this.f18300a;
            String string = repliesActivity.getString(R.string.review_already_liked);
            m.d(string, "getString(...)");
            repliesActivity.q0(string);
        }

        public void d(C2042J j4) {
            m.e(j4, "reply");
            this.f18300a.G3(j4);
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18301a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f18301a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18301a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18302a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f18302a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18302a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18303a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18304b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18303a = aVar;
            this.f18304b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18303a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18304b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RepliesActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(RepliesActivity repliesActivity) {
        if (!repliesActivity.v3().m() && !repliesActivity.v3().h() && repliesActivity.t3().f10790j.getLayoutManager() != null) {
            RecyclerView.LayoutManager layoutManager = repliesActivity.t3().f10790j.getLayoutManager();
            m.b(layoutManager);
            int childCount = layoutManager.getChildCount();
            RecyclerView.LayoutManager layoutManager2 = repliesActivity.t3().f10790j.getLayoutManager();
            m.b(layoutManager2);
            int itemCount = layoutManager2.getItemCount();
            RecyclerView.LayoutManager layoutManager3 = repliesActivity.t3().f10790j.getLayoutManager();
            m.b(layoutManager3);
            if (childCount + ((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition() >= itemCount - 10) {
                C1547y yVar = repliesActivity.f18284L;
                if (yVar != null) {
                    yVar.b(true);
                }
                F v32 = repliesActivity.v3();
                Object value = repliesActivity.v3().o().getValue();
                m.b(value);
                long f4 = ((N) value).f();
                C1547y yVar2 = repliesActivity.f18284L;
                m.b(yVar2);
                v32.g(repliesActivity, f4, yVar2.getItemCount());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void B3(RepliesActivity repliesActivity, View view) {
        repliesActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void C3(RepliesActivity repliesActivity, View view) {
        repliesActivity.E3();
    }

    /* access modifiers changed from: private */
    public final void D3() {
        U.f20468m.a(this);
        F3();
    }

    private final void E3() {
        w3();
        if (t3().f10782b.getText() == null || m3.m.u0(t3().f10782b.getText().toString()).toString().length() <= 0) {
            if (m3.m.u0(t3().f10782b.getText().toString()).toString().length() == 0) {
                String string = getString(R.string.empty_answer_error);
                m.d(string, "getString(...)");
                q0(string);
            }
        } else if (!N.f20413o.b(this, t3().f10782b.getText().toString())) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            aVar.P0(applicationContext, t3().f10782b.getText().toString());
            Context applicationContext2 = getApplicationContext();
            m.d(applicationContext2, "getApplicationContext(...)");
            aVar.Q0(applicationContext2, String.valueOf(System.currentTimeMillis()));
            F v32 = v3();
            String obj = t3().f10782b.getText().toString();
            Object value = v3().o().getValue();
            m.b(value);
            v32.t(this, obj, ((N) value).f());
        } else {
            t3().f10782b.setText("");
        }
    }

    private final void F3() {
        if (!isFinishing()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class), UptodownApp.f17422D.a(this));
        }
    }

    /* access modifiers changed from: private */
    public final void G3(C2042J j4) {
        o oVar = new o(this, LifecycleOwnerKt.getLifecycleScope(this));
        String g4 = j4.g();
        m.b(g4);
        oVar.b(g4, new e(this));
    }

    private final void H3(N n4) {
        o oVar = new o(this, LifecycleOwnerKt.getLifecycleScope(this));
        String l4 = n4.l();
        m.b(l4);
        oVar.b(l4, new f(this));
    }

    private final void I3(N n4) {
        CharSequence charSequence;
        CharSequence charSequence2;
        N n5 = n4;
        if (n5.o()) {
            t3().f10788h.f10866l.setVisibility(8);
            t3().f10788h.f10865k.setOnClickListener(new C1393l4(this, n5));
            if (u2.F.f21886a.i(n5.f())) {
                t3().f10788h.f10858d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
            }
            TextView textView = t3().f10788h.f10870p;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            t3().f10788h.f10870p.setText(String.valueOf(n5.g()));
            t3().f10788h.f10859e.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            t3().f10788h.f10860f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            t3().f10788h.f10861g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            t3().f10788h.f10862h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            t3().f10788h.f10863i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            if (n5.h() >= 2) {
                t3().f10788h.f10860f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (n5.h() >= 3) {
                t3().f10788h.f10861g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (n5.h() >= 4) {
                t3().f10788h.f10862h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (n5.h() == 5) {
                t3().f10788h.f10863i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            t3().f10788h.f10874t.setTypeface(aVar.w());
            t3().f10788h.f10869o.setTypeface(aVar.x());
            t3().f10788h.f10868n.setTypeface(aVar.x());
            t3().f10788h.f10871q.setTypeface(aVar.x());
            U.b bVar = U.f20468m;
            String c5 = bVar.c(n5.e());
            if (c5 == null || c5.length() == 0) {
                com.squareup.picasso.s.h().j(R.drawable.vector_user_default).n(UptodownApp.f17422D.i0(this)).i(t3().f10788h.f10857c);
            } else {
                com.squareup.picasso.s.h().l(bVar.c(n5.e())).n(UptodownApp.f17422D.i0(this)).i(t3().f10788h.f10857c);
            }
            String m4 = n5.m();
            if (m4 == null || m4.length() == 0) {
                CharSequence charSequence3 = (CharSequence) v3().q().getValue();
                if (!(charSequence3 == null || charSequence3.length() == 0)) {
                    t3().f10788h.f10874t.setText((CharSequence) v3().q().getValue());
                    UsernameTextView.a aVar2 = UsernameTextView.f19434k;
                    UsernameTextView usernameTextView = t3().f10788h.f10874t;
                    m.d(usernameTextView, "tvUsernameReview");
                    aVar2.a(usernameTextView, n5.o(), n5.n());
                }
            } else {
                t3().f10788h.f10874t.setText(n5.m());
                UsernameTextView.a aVar3 = UsernameTextView.f19434k;
                UsernameTextView usernameTextView2 = t3().f10788h.f10874t;
                m.d(usernameTextView2, "tvUsernameReview");
                aVar3.a(usernameTextView2, n5.o(), n5.n());
            }
            String k4 = n5.k();
            if (!(k4 == null || k4.length() == 0)) {
                t3().f10788h.f10869o.setText(n5.k());
            }
            String i4 = n5.i();
            if (i4 == null || i4.length() == 0) {
                t3().f10788h.f10868n.setVisibility(8);
            } else {
                t3().f10788h.f10868n.setMaxLines(Integer.MAX_VALUE);
                TextView textView2 = t3().f10788h.f10868n;
                Spanned j4 = n5.j();
                if (j4 != null) {
                    charSequence2 = m3.m.u0(j4);
                } else {
                    charSequence2 = null;
                }
                textView2.setText(charSequence2);
                if (n5.a() > 1) {
                    t3().f10788h.f10871q.setText(String.valueOf(n5.a()));
                }
            }
            if (n5.d() == 1) {
                t3().f10788h.f10856b.setVisibility(0);
            }
            String l4 = n5.l();
            if (!(l4 == null || l4.length() == 0)) {
                t3().f10788h.f10874t.setOnClickListener(new C1400m4(this, n5));
                t3().f10788h.f10857c.setOnClickListener(new C1407n4(this, n5));
            }
            t3().f10788h.f10864j.setOnClickListener(new C1414o4(this));
            t3().f10788h.f10864j.setVisibility(0);
            q.a aVar4 = q.f21920a;
            ImageView imageView = t3().f10788h.f10857c;
            m.d(imageView, "ivAvatarReview");
            aVar4.a(imageView);
            t3().f10788h.getRoot().setVisibility(0);
            t3().f10787g.getRoot().setVisibility(8);
            return;
        }
        t3().f10787g.f10818l.setVisibility(8);
        t3().f10787g.f10817k.setOnClickListener(new C1337d4(this, n5));
        if (u2.F.f21886a.i(n5.f())) {
            t3().f10787g.f10810d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
        }
        TextView textView3 = t3().f10787g.f10822p;
        k.a aVar5 = N1.k.f7778g;
        textView3.setTypeface(aVar5.x());
        t3().f10787g.f10822p.setText(String.valueOf(n5.g()));
        t3().f10787g.f10811e.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        t3().f10787g.f10812f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        t3().f10787g.f10813g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        t3().f10787g.f10814h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        t3().f10787g.f10815i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        if (n5.h() >= 2) {
            t3().f10787g.f10812f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (n5.h() >= 3) {
            t3().f10787g.f10813g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (n5.h() >= 4) {
            t3().f10787g.f10814h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (n5.h() == 5) {
            t3().f10787g.f10815i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        t3().f10787g.f10826t.setTypeface(aVar5.w());
        t3().f10787g.f10821o.setTypeface(aVar5.x());
        t3().f10787g.f10820n.setTypeface(aVar5.x());
        t3().f10787g.f10823q.setTypeface(aVar5.x());
        U.b bVar2 = U.f20468m;
        String c6 = bVar2.c(n5.e());
        if (c6 == null || c6.length() == 0) {
            com.squareup.picasso.s.h().j(R.drawable.vector_user_default).n(UptodownApp.f17422D.i0(this)).i(t3().f10787g.f10809c);
        } else {
            com.squareup.picasso.s.h().l(bVar2.c(n5.e())).n(UptodownApp.f17422D.i0(this)).i(t3().f10787g.f10809c);
        }
        String m5 = n5.m();
        if (m5 == null || m5.length() == 0) {
            CharSequence charSequence4 = (CharSequence) v3().q().getValue();
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                t3().f10787g.f10826t.setText((CharSequence) v3().q().getValue());
                UsernameTextView.a aVar6 = UsernameTextView.f19434k;
                UsernameTextView usernameTextView3 = t3().f10787g.f10826t;
                m.d(usernameTextView3, "tvUsernameReview");
                aVar6.a(usernameTextView3, n5.o(), n5.n());
            }
        } else {
            t3().f10787g.f10826t.setText(n5.m());
            UsernameTextView.a aVar7 = UsernameTextView.f19434k;
            UsernameTextView usernameTextView4 = t3().f10787g.f10826t;
            m.d(usernameTextView4, "tvUsernameReview");
            aVar7.a(usernameTextView4, n5.o(), n5.n());
        }
        String k5 = n5.k();
        if (!(k5 == null || k5.length() == 0)) {
            t3().f10787g.f10821o.setText(n5.k());
        }
        String i5 = n5.i();
        if (i5 == null || i5.length() == 0) {
            t3().f10787g.f10820n.setVisibility(8);
        } else {
            t3().f10787g.f10820n.setMaxLines(Integer.MAX_VALUE);
            TextView textView4 = t3().f10787g.f10820n;
            Spanned j5 = n5.j();
            if (j5 != null) {
                charSequence = m3.m.u0(j5);
            } else {
                charSequence = null;
            }
            textView4.setText(charSequence);
            if (n5.a() > 0) {
                t3().f10787g.f10823q.setText(String.valueOf(n5.a()));
            }
        }
        if (n5.d() == 1) {
            t3().f10787g.f10808b.setVisibility(0);
        }
        String l5 = n5.l();
        if (l5 != null && l5.length() != 0) {
            t3().f10787g.f10826t.setOnClickListener(new C1344e4(this, n5));
            t3().f10787g.f10809c.setOnClickListener(new C1351f4(this, n5));
        }
    }

    /* access modifiers changed from: private */
    public static final void J3(RepliesActivity repliesActivity, N n4, View view) {
        if (UptodownApp.f17422D.a0()) {
            y2.n nVar = new y2.n(repliesActivity);
            ImageView imageView = repliesActivity.t3().f10788h.f10858d;
            m.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!u2.F.f21886a.i(n4.f())) {
                repliesActivity.v3().s(repliesActivity, n4);
                repliesActivity.t3().f10788h.f10870p.setText(String.valueOf(n4.g() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void K3(RepliesActivity repliesActivity, N n4, View view) {
        repliesActivity.H3(n4);
    }

    /* access modifiers changed from: private */
    public static final void L3(RepliesActivity repliesActivity, N n4, View view) {
        repliesActivity.H3(n4);
    }

    /* access modifiers changed from: private */
    public static final void M3(RepliesActivity repliesActivity, View view) {
        repliesActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void N3(RepliesActivity repliesActivity, N n4, View view) {
        if (UptodownApp.f17422D.a0()) {
            y2.n nVar = new y2.n(repliesActivity);
            ImageView imageView = repliesActivity.t3().f10787g.f10810d;
            m.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!u2.F.f21886a.i(n4.f())) {
                repliesActivity.v3().s(repliesActivity, n4);
                repliesActivity.t3().f10787g.f10822p.setText(String.valueOf(n4.g() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(RepliesActivity repliesActivity, N n4, View view) {
        repliesActivity.H3(n4);
    }

    /* access modifiers changed from: private */
    public static final void P3(RepliesActivity repliesActivity, N n4, View view) {
        repliesActivity.H3(n4);
    }

    private final void Q3() {
        String str;
        U.b bVar = U.f20468m;
        U e5 = bVar.e(this);
        if (e5 != null) {
            str = e5.a();
        } else {
            str = null;
        }
        if (str != null) {
            com.squareup.picasso.s.h().l(bVar.c(e5.a())).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(this)).i(t3().f10783c);
            if (e5.n()) {
                q.a aVar = q.f21920a;
                ImageView imageView = t3().f10783c;
                m.d(imageView, "ivUserAvatarReply");
                aVar.b(imageView);
                return;
            }
            return;
        }
        t3().f10783c.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_user_default));
    }

    private final void R3() {
        String str;
        U e5 = U.f20468m.e(this);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str != null) {
            String g4 = e5.g();
            m.b(g4);
            if (g4.length() > 0) {
                t3().f10785e.setVisibility(8);
                return;
            }
        }
        t3().f10785e.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final C1693u0 s3(RepliesActivity repliesActivity) {
        return C1693u0.c(repliesActivity.getLayoutInflater());
    }

    private final void u3(long j4) {
        v3().f(this, j4);
    }

    private final void w3() {
        Object systemService = getSystemService("input_method");
        m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(t3().f10782b.getWindowToken(), 0);
    }

    private final void x3() {
        String str;
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            t3().f10791k.setNavigationIcon(drawable);
            t3().f10791k.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t3().f10791k.setNavigationOnClickListener(new C1358g4(this));
        TextView textView = t3().f10792l;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        N n4 = (N) v3().o().getValue();
        String str2 = null;
        if (n4 != null) {
            str = n4.c();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            CharSequence charSequence = (CharSequence) v3().i().getValue();
            if (!(charSequence == null || charSequence.length() == 0)) {
                t3().f10792l.setText((CharSequence) v3().i().getValue());
            }
        } else {
            TextView textView2 = t3().f10792l;
            N n5 = (N) v3().o().getValue();
            if (n5 != null) {
                str2 = n5.c();
            }
            textView2.setText(str2);
        }
        t3().f10793m.setTypeface(aVar.x());
        Q3();
        t3().f10794n.setTypeface(aVar.w());
        t3().f10794n.setOnClickListener(new C1365h4(this));
        t3().f10785e.setOnClickListener(new C1372i4(this));
        t3().f10782b.setTypeface(aVar.x());
        t3().f10782b.setOnEditorActionListener(new C1379j4(this));
        R3();
        t3().f10790j.setLayoutManager(new LinearLayoutManager(this, 1, false));
        t3().f10790j.setItemAnimator(new DefaultItemAnimator());
        t3().f10786f.getViewTreeObserver().addOnScrollChangedListener(new C1386k4(this));
        if (v3().o().getValue() != null) {
            Object value = v3().o().getValue();
            m.b(value);
            u3(((N) value).f());
            Object value2 = v3().o().getValue();
            m.b(value2);
            I3((N) value2);
            return;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public static final void y3(RepliesActivity repliesActivity, View view) {
        repliesActivity.F3();
    }

    /* access modifiers changed from: private */
    public static final boolean z3(RepliesActivity repliesActivity, TextView textView, int i4, KeyEvent keyEvent) {
        if (i4 != 6) {
            return false;
        }
        repliesActivity.E3();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        setContentView((View) t3().getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("review")) {
                t o4 = v3().o();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("review", N.class);
                } else {
                    parcelable = extras.getParcelable("review");
                }
                o4.setValue(parcelable);
            }
            if (extras.containsKey("appName")) {
                v3().i().setValue(extras.getString("appName"));
            }
            if (extras.containsKey("username")) {
                v3().q().setValue(extras.getString("username"));
            }
        }
        x3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new a(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused4 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        R3();
        Q3();
    }

    public final C1693u0 t3() {
        return (C1693u0) this.f18282J.getValue();
    }

    public final F v3() {
        return (F) this.f18283K.getValue();
    }
}
