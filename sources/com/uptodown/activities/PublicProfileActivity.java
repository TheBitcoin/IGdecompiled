package com.uptodown.activities;

import J1.L3;
import J1.M3;
import J1.N3;
import J1.O3;
import J1.P3;
import J1.Q3;
import M1.C1546x;
import M1.Z;
import N1.k;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.o;
import c2.C1686q0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.E;
import com.uptodown.util.views.UsernameTextView;
import d3.p;
import f2.C2004C;
import f2.C2011b;
import f2.K;
import g2.C2050h;
import g2.N;
import g2.U;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.q;

public final class PublicProfileActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18205J = h.a(new P3(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18206K = new ViewModelLazy(D.b(E.class), new e(this), new d(this), new f((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public Z f18207L;

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f18208M;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f18210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f18211c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ U f18212d;

        /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a  reason: collision with other inner class name */
        static final class C0223a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f18213a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C f18214b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ U f18215c;

            /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a$a  reason: collision with other inner class name */
            public static final class C0224a implements C2011b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f18216a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ E f18217b;

                C0224a(PublicProfileActivity publicProfileActivity, E e5) {
                    this.f18216a = publicProfileActivity;
                    this.f18217b = e5;
                }

                public void a(int i4) {
                    this.f18216a.C2(((C2050h) ((E.a) ((E.c) this.f18217b).a()).a().get(i4)).e());
                }
            }

            /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a$b */
            public static final class b implements C2004C {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ u2.E f18218a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f18219b;

                b(u2.E e5, PublicProfileActivity publicProfileActivity) {
                    this.f18218a = e5;
                    this.f18219b = publicProfileActivity;
                }

                public void a(int i4) {
                    Object obj = ((E.a) ((E.c) this.f18218a).a()).b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18219b.o3().l(this.f18219b, (N) obj);
                }

                public void b() {
                    this.f18219b.Y2();
                }

                public void c(int i4) {
                    Object obj = ((E.a) ((E.c) this.f18218a).a()).b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18219b.C2(((N) obj).b());
                }

                public void d(int i4) {
                    Object obj = ((E.a) ((E.c) this.f18218a).a()).b().get(i4);
                    m.d(obj, "get(...)");
                    N n4 = (N) obj;
                    Intent intent = new Intent(this.f18219b, RepliesActivity.class);
                    intent.putExtra("review", n4);
                    intent.putExtra("appName", n4.c());
                    intent.putExtra("username", n4.m());
                    PublicProfileActivity publicProfileActivity = this.f18219b;
                    publicProfileActivity.startActivity(intent, UptodownApp.f17422D.a(publicProfileActivity));
                }
            }

            C0223a(PublicProfileActivity publicProfileActivity, C c5, U u4) {
                this.f18213a = publicProfileActivity;
                this.f18214b = c5;
                this.f18215c = u4;
            }

            /* access modifiers changed from: private */
            public static final void j(C c5, U u4, PublicProfileActivity publicProfileActivity, View view) {
                String str;
                Object obj = c5.f20968a;
                m.b(obj);
                String g4 = ((U) obj).g();
                if (u4 != null) {
                    str = u4.g();
                } else {
                    str = null;
                }
                if (m.a(g4, str)) {
                    publicProfileActivity.startActivity(new Intent(publicProfileActivity, RecommendedActivity.class), UptodownApp.f17422D.a(publicProfileActivity));
                    return;
                }
                Intent intent = new Intent(publicProfileActivity, PublicListActivity.class);
                intent.putExtra("user", (Parcelable) c5.f20968a);
                publicProfileActivity.startActivity(intent, UptodownApp.f17422D.a(publicProfileActivity));
            }

            /* access modifiers changed from: private */
            public static final void k(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.m3();
            }

            /* access modifiers changed from: private */
            public static final void l(PublicProfileActivity publicProfileActivity, C c5, View view) {
                String str;
                Intent intent = new Intent(publicProfileActivity, UserCommentsActivity.class);
                U u4 = (U) c5.f20968a;
                if (u4 != null) {
                    str = u4.g();
                } else {
                    str = null;
                }
                intent.putExtra("userID", str);
                publicProfileActivity.startActivity(intent, UptodownApp.f17422D.a(publicProfileActivity));
            }

            /* access modifiers changed from: private */
            public static final void m(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.m3();
            }

            /* renamed from: i */
            public final Object emit(u2.E e5, V2.d dVar) {
                String str;
                String str2;
                String str3;
                if (e5 instanceof E.a) {
                    this.f18213a.n3().f10715f.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    String str4 = null;
                    if (!((E.a) cVar.a()).a().isEmpty()) {
                        this.f18213a.n3().f10716g.f10740e.setAdapter(new C1546x(((E.a) cVar.a()).a(), new C0224a(this.f18213a, e5)));
                        this.f18213a.n3().f10716g.getRoot().setVisibility(0);
                        this.f18213a.n3().f10716g.f10739d.setOnClickListener(new y(this.f18214b, this.f18215c, this.f18213a));
                    } else {
                        U u4 = (U) this.f18214b.f20968a;
                        if (u4 != null) {
                            str2 = u4.g();
                        } else {
                            str2 = null;
                        }
                        U u5 = this.f18215c;
                        if (u5 != null) {
                            str3 = u5.g();
                        } else {
                            str3 = null;
                        }
                        if (m.a(str2, str3)) {
                            this.f18213a.n3().f10716g.f10740e.setVisibility(8);
                            this.f18213a.n3().f10716g.f10738c.setVisibility(0);
                            this.f18213a.n3().f10716g.f10741f.setOnClickListener(new z(this.f18213a));
                        }
                    }
                    if (!((E.a) cVar.a()).b().isEmpty()) {
                        this.f18213a.n3().f10717h.f10740e.setAdapter(new Z(((E.a) cVar.a()).b(), new b(e5, this.f18213a)));
                        this.f18213a.n3().f10717h.getRoot().setVisibility(0);
                        this.f18213a.n3().f10717h.f10739d.setOnClickListener(new A(this.f18213a, this.f18214b));
                    } else {
                        U u6 = (U) this.f18214b.f20968a;
                        if (u6 != null) {
                            str = u6.g();
                        } else {
                            str = null;
                        }
                        U u7 = this.f18215c;
                        if (u7 != null) {
                            str4 = u7.g();
                        }
                        if (m.a(str, str4)) {
                            this.f18213a.n3().f10717h.getRoot().setVisibility(0);
                            this.f18213a.n3().f10717h.f10740e.setVisibility(8);
                            this.f18213a.n3().f10717h.f10738c.setVisibility(0);
                            this.f18213a.n3().f10717h.f10741f.setOnClickListener(new B(this.f18213a));
                        }
                    }
                    this.f18213a.n3().f10715f.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PublicProfileActivity publicProfileActivity, C c5, U u4, V2.d dVar) {
            super(2, dVar);
            this.f18210b = publicProfileActivity;
            this.f18211c = c5;
            this.f18212d = u4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18210b, this.f18211c, this.f18212d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18209a;
            if (i4 == 0) {
                n.b(obj);
                I h4 = this.f18210b.o3().h();
                C0223a aVar = new C0223a(this.f18210b, this.f18211c, this.f18212d);
                this.f18209a = 1;
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
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18220a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f18221b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f18222c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ U f18223d;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f18224a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C f18225b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ U f18226c;

            /* renamed from: com.uptodown.activities.PublicProfileActivity$b$a$a  reason: collision with other inner class name */
            public static final class C0225a implements C2011b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f18227a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ u2.E f18228b;

                C0225a(PublicProfileActivity publicProfileActivity, u2.E e5) {
                    this.f18227a = publicProfileActivity;
                    this.f18228b = e5;
                }

                public void a(int i4) {
                    this.f18227a.C2(((C2050h) ((ArrayList) ((E.c) this.f18228b).a()).get(i4)).e());
                }
            }

            a(PublicProfileActivity publicProfileActivity, C c5, U u4) {
                this.f18224a = publicProfileActivity;
                this.f18225b = c5;
                this.f18226c = u4;
            }

            /* access modifiers changed from: private */
            public static final void h(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.startActivity(new Intent(publicProfileActivity, WishlistActivity.class));
            }

            /* access modifiers changed from: private */
            public static final void i(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.m3();
            }

            /* renamed from: e */
            public final Object emit(u2.E e5, V2.d dVar) {
                String str;
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (!((Collection) cVar.a()).isEmpty()) {
                            this.f18224a.n3().f10729t.f10740e.setAdapter(new C1546x((ArrayList) cVar.a(), new C0225a(this.f18224a, e5)));
                            this.f18224a.n3().f10729t.getRoot().setVisibility(0);
                            this.f18224a.n3().f10729t.f10740e.setVisibility(0);
                            this.f18224a.n3().f10729t.f10738c.setVisibility(8);
                            this.f18224a.n3().f10729t.f10739d.setOnClickListener(new C(this.f18224a));
                        } else {
                            U u4 = (U) this.f18225b.f20968a;
                            String str2 = null;
                            if (u4 != null) {
                                str = u4.g();
                            } else {
                                str = null;
                            }
                            U u5 = this.f18226c;
                            if (u5 != null) {
                                str2 = u5.g();
                            }
                            if (m.a(str, str2)) {
                                this.f18224a.n3().f10729t.getRoot().setVisibility(0);
                                this.f18224a.n3().f10729t.f10740e.setVisibility(8);
                                this.f18224a.n3().f10729t.f10738c.setVisibility(0);
                                this.f18224a.n3().f10729t.f10741f.setOnClickListener(new D(this.f18224a));
                            }
                        }
                        this.f18224a.n3().f10715f.setVisibility(8);
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PublicProfileActivity publicProfileActivity, C c5, U u4, V2.d dVar) {
            super(2, dVar);
            this.f18221b = publicProfileActivity;
            this.f18222c = c5;
            this.f18223d = u4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18221b, this.f18222c, this.f18223d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18220a;
            if (i4 == 0) {
                n.b(obj);
                I k4 = this.f18221b.o3().k();
                a aVar = new a(this.f18221b, this.f18222c, this.f18223d);
                this.f18220a = 1;
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18229a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f18230b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f18231a;

            a(PublicProfileActivity publicProfileActivity) {
                this.f18231a = publicProfileActivity;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((N.c) cVar.a()).b() == 1) {
                            Z i32 = this.f18231a.f18207L;
                            if (i32 != null) {
                                i32.d(((N.c) cVar.a()).a());
                            }
                        } else {
                            PublicProfileActivity publicProfileActivity = this.f18231a;
                            String string = publicProfileActivity.getString(R.string.error_generico);
                            m.d(string, "getString(...)");
                            publicProfileActivity.q0(string);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PublicProfileActivity publicProfileActivity, V2.d dVar) {
            super(2, dVar);
            this.f18230b = publicProfileActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18230b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18229a;
            if (i4 == 0) {
                n.b(obj);
                I g4 = this.f18230b.o3().g();
                a aVar = new a(this.f18230b);
                this.f18229a = 1;
                if (g4.collect(aVar, this) == c5) {
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

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18232a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18232a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18232a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18233a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18233a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18233a.getViewModelStore();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18234a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18235b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18234a = aVar;
            this.f18235b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18234a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18235b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PublicProfileActivity.f.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class g implements K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f18236a;

        g(PublicProfileActivity publicProfileActivity) {
            this.f18236a = publicProfileActivity;
        }

        public void a(U u4) {
            m.e(u4, "user");
            this.f18236a.u3(u4);
        }

        public void b() {
        }
    }

    public PublicProfileActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new Q3(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18208M = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final C1686q0 l3(PublicProfileActivity publicProfileActivity) {
        return C1686q0.c(publicProfileActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void m3() {
        setResult(1);
        finish();
    }

    /* access modifiers changed from: private */
    public final C1686q0 n3() {
        return (C1686q0) this.f18205J.getValue();
    }

    /* access modifiers changed from: private */
    public final E o3() {
        return (E) this.f18206K.getValue();
    }

    private final void p3(U u4) {
        String str;
        setContentView((View) n3().getRoot());
        n3().f10719j.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.vector_arrow_left_white));
        n3().f10719j.setNavigationContentDescription((CharSequence) getString(R.string.back));
        n3().f10719j.setNavigationOnClickListener(new L3(this));
        n3().f10718i.getViewTreeObserver().addOnScrollChangedListener(new M3(this));
        UsernameTextView usernameTextView = n3().f10725p;
        k.a aVar = N1.k.f7778g;
        usernameTextView.setTypeface(aVar.w());
        n3().f10726q.setTypeface(aVar.x());
        n3().f10722m.setTypeface(aVar.w());
        n3().f10720k.setTypeface(aVar.x());
        n3().f10721l.setTypeface(aVar.w());
        n3().f10727r.setTypeface(aVar.x());
        n3().f10728s.setTypeface(aVar.w());
        n3().f10723n.setTypeface(aVar.x());
        n3().f10724o.setTypeface(aVar.w());
        n3().f10716g.f10743h.setTypeface(aVar.w());
        n3().f10716g.f10741f.setTypeface(aVar.w());
        n3().f10716g.f10742g.setTypeface(aVar.x());
        n3().f10729t.f10743h.setTypeface(aVar.w());
        n3().f10729t.f10741f.setTypeface(aVar.w());
        n3().f10729t.f10742g.setTypeface(aVar.x());
        n3().f10717h.f10743h.setTypeface(aVar.w());
        n3().f10717h.f10741f.setTypeface(aVar.w());
        n3().f10717h.f10742g.setTypeface(aVar.x());
        u3(u4);
        n3().f10716g.f10740e.setLayoutManager(new LinearLayoutManager(this, 0, false));
        n3().f10716g.f10740e.setItemAnimator((RecyclerView.ItemAnimator) null);
        n3().f10717h.f10740e.setLayoutManager(new LinearLayoutManager(this, 0, false));
        U e5 = U.f20468m.e(this);
        String g4 = u4.g();
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (m.a(g4, str)) {
            n3().f10729t.f10740e.setLayoutManager(new LinearLayoutManager(this, 0, false));
            n3().f10729t.f10740e.setItemAnimator((RecyclerView.ItemAnimator) null);
            n3().f10729t.f10743h.setText(getString(R.string.my_wishlist));
            n3().f10716g.f10743h.setText(getString(R.string.my_recommended_apps));
            n3().f10717h.f10742g.setText(getString(R.string.my_profile_no_review));
            n3().f10717h.f10743h.setText(getString(R.string.public_profile_my_reviews));
            n3().f10722m.setVisibility(0);
            n3().f10722m.setOnClickListener(new N3(e5, this));
            n3().f10712c.setOnClickListener(new O3(this, u4));
            return;
        }
        n3().f10722m.setVisibility(8);
        n3().f10716g.f10743h.setText(getString(R.string.recommended_apps));
        n3().f10717h.f10743h.setText(getString(R.string.public_profile_activity_reviews_any_user_title));
    }

    /* access modifiers changed from: private */
    public static final void q3(PublicProfileActivity publicProfileActivity, View view) {
        publicProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void r3(PublicProfileActivity publicProfileActivity) {
        int scrollY = publicProfileActivity.n3().f10718i.getScrollY();
        float dimension = publicProfileActivity.getResources().getDimension(R.dimen.public_profile_header_size) * 0.7f;
        int alphaComponent = ColorUtils.setAlphaComponent(ContextCompat.getColor(publicProfileActivity, R.color.background_color), (int) (j3.e.e(((float) scrollY) / dimension, 0.0f, 1.0f) * ((float) 255)));
        if (((double) scrollY) >= ((double) dimension) * 0.5d) {
            publicProfileActivity.n3().f10719j.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.core_vector_back));
        } else {
            publicProfileActivity.n3().f10719j.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.vector_arrow_left_white));
        }
        publicProfileActivity.n3().f10719j.setBackgroundColor(alphaComponent);
    }

    /* access modifiers changed from: private */
    public static final void s3(U u4, PublicProfileActivity publicProfileActivity, View view) {
        if (u4 != null && u4.m(publicProfileActivity)) {
            publicProfileActivity.f18208M.launch(new Intent(publicProfileActivity, UserEditProfileActivity.class), UptodownApp.f17422D.b(publicProfileActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void t3(PublicProfileActivity publicProfileActivity, U u4, View view) {
        Intent intent = new Intent(publicProfileActivity, UserAvatarActivity.class);
        intent.putExtra("user", u4);
        publicProfileActivity.f18208M.launch(intent, UptodownApp.f17422D.b(publicProfileActivity));
    }

    /* access modifiers changed from: private */
    public final void u3(U u4) {
        UsernameTextView.a aVar = UsernameTextView.f19434k;
        UsernameTextView usernameTextView = n3().f10725p;
        m.d(usernameTextView, "tvNamePublicProfile");
        aVar.a(usernameTextView, u4.n(), u4.l());
        n3().f10725p.setText(u4.h());
        n3().f10726q.setText(u4.i());
        String d5 = u4.d();
        if (!(d5 == null || d5.length() == 0 || n3().f10711b.getDrawable() != null)) {
            com.squareup.picasso.s.h().l(u4.d()).f().i(n3().f10711b);
        }
        String b5 = u4.b();
        if (!(b5 == null || b5.length() == 0)) {
            com.squareup.picasso.s.h().l(U.f20468m.c(u4.a())).n(UptodownApp.f17422D.k0(this)).i(n3().f10712c);
            n3().f10712c.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        }
        if (u4.n()) {
            q.a aVar2 = q.f21920a;
            ImageView imageView = n3().f10712c;
            m.d(imageView, "ivIconPublicProfile");
            aVar2.a(imageView);
            n3().f10713d.setVisibility(0);
        }
        n3().f10728s.setText(String.valueOf(u4.j()));
    }

    /* access modifiers changed from: private */
    public static final void v3(PublicProfileActivity publicProfileActivity, ActivityResult activityResult) {
        U e5;
        String g4;
        if (activityResult.getResultCode() == 10 && (e5 = U.f20468m.e(publicProfileActivity)) != null && (g4 = e5.g()) != null && g4.length() != 0) {
            new o(publicProfileActivity, LifecycleOwnerKt.getLifecycleScope(publicProfileActivity)).b(String.valueOf(e5.g()), new g(publicProfileActivity));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        C c5 = new C();
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user"))) {
            c5.f20968a = extras.getParcelable("user");
        }
        Object obj = c5.f20968a;
        if (obj != null) {
            p3((U) obj);
            o3().f(this, String.valueOf(((U) c5.f20968a).g()));
        }
        U e5 = U.f20468m.e(this);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new a(this, c5, e5, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, c5, e5, (V2.d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
    }
}
