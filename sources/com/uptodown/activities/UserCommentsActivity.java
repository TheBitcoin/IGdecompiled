package com.uptodown.activities;

import J1.C1442s5;
import J1.C1449t5;
import M1.N;
import N1.k;
import R2.h;
import R2.n;
import R2.s;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import c2.Q0;
import com.google.android.material.snackbar.Snackbar;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.S;
import d3.p;
import f2.C2027s;
import f2.J;
import g2.C2050h;
import g2.N;
import g2.U;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.F;
import w2.o;

public final class UserCommentsActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18536J = h.a(new C1449t5(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18537K = new ViewModelLazy(D.b(S.class), new f(this), new e(this), new g((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public N f18538L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public b f18539M = new b(this);

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f18540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f18541b;

        a(LinearLayoutManager linearLayoutManager, UserCommentsActivity userCommentsActivity) {
            this.f18540a = linearLayoutManager;
            this.f18541b = userCommentsActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0) {
                int findFirstVisibleItemPosition = this.f18540a.findFirstVisibleItemPosition();
                int childCount = this.f18540a.getChildCount();
                int itemCount = this.f18540a.getItemCount();
                if (!this.f18541b.l3().h() && !((Boolean) this.f18541b.l3().f().getValue()).booleanValue() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    N c32 = this.f18541b.f18538L;
                    if (c32 != null) {
                        c32.c(true);
                    }
                    this.f18541b.l3().e(this.f18541b);
                }
            }
        }
    }

    public static final class b implements J {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f18542a;

        public static final class a implements C2027s {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f18543a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f18543a = userCommentsActivity;
            }

            public void b(int i4) {
            }

            public void c(C2050h hVar) {
                m.e(hVar, "appInfo");
                Intent intent = new Intent(this.f18543a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                UserCommentsActivity userCommentsActivity = this.f18543a;
                userCommentsActivity.startActivity(intent, UptodownApp.f17422D.a(userCommentsActivity));
            }
        }

        b(UserCommentsActivity userCommentsActivity) {
            this.f18542a = userCommentsActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0()) {
                F f4 = F.f21886a;
                N c32 = this.f18542a.f18538L;
                m.b(c32);
                if (!f4.i(((g2.N) c32.b().get(i4)).f())) {
                    S f32 = this.f18542a.l3();
                    UserCommentsActivity userCommentsActivity = this.f18542a;
                    N c33 = userCommentsActivity.f18538L;
                    m.b(c33);
                    Object obj = c33.b().get(i4);
                    m.d(obj, "get(...)");
                    f32.l(userCommentsActivity, (g2.N) obj);
                }
            }
        }

        public void b(int i4) {
            Intent intent = new Intent(this.f18542a, RepliesActivity.class);
            N c32 = this.f18542a.f18538L;
            m.b(c32);
            Object obj = c32.b().get(i4);
            g2.N n4 = (g2.N) obj;
            n4.t(((U) this.f18542a.l3().k().getValue()).a());
            m.d(obj, "apply(...)");
            n4.z(((U) this.f18542a.l3().k().getValue()).n() ? 1 : 0);
            n4.C(((U) this.f18542a.l3().k().getValue()).l());
            n4.A(((U) this.f18542a.l3().k().getValue()).g());
            intent.putExtra("review", n4);
            intent.putExtra("username", ((U) this.f18542a.l3().k().getValue()).h());
            UserCommentsActivity userCommentsActivity = this.f18542a;
            userCommentsActivity.startActivity(intent, UptodownApp.f17422D.a(userCommentsActivity));
        }

        public void c(int i4) {
            if (UptodownApp.f17422D.a0()) {
                UserCommentsActivity userCommentsActivity = this.f18542a;
                N c32 = userCommentsActivity.f18538L;
                m.b(c32);
                new C1640l(userCommentsActivity, ((g2.N) c32.b().get(i4)).b(), new a(this.f18542a), LifecycleOwnerKt.getLifecycleScope(this.f18542a));
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18544a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f18545b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f18546a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f18546a = userCommentsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                String str;
                if (e5 instanceof E.a) {
                    this.f18546a.i3().f9976b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((S.a) cVar.a()).b() == null || !((S.a) cVar.a()).c()) {
                        this.f18546a.i3().f9979e.setTypeface(k.f7778g.x());
                        this.f18546a.i3().f9979e.setVisibility(0);
                    } else {
                        U e6 = U.f20468m.e(this.f18546a);
                        if (e6 != null) {
                            str = e6.g();
                        } else {
                            str = null;
                        }
                        if (m.a(str, ((S.a) cVar.a()).b().g())) {
                            this.f18546a.i3().f9980f.setText(this.f18546a.getString(R.string.public_profile_my_reviews));
                        } else {
                            TextView textView = this.f18546a.i3().f9980f;
                            kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
                            String string = this.f18546a.getString(R.string.user_reviews);
                            m.d(string, "getString(...)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{((S.a) cVar.a()).b().h()}, 1));
                            m.d(format, "format(...)");
                            textView.setText(format);
                        }
                        if (!((S.a) cVar.a()).a().isEmpty()) {
                            if (this.f18546a.f18538L == null) {
                                this.f18546a.f18538L = new N(((S.a) cVar.a()).a(), this.f18546a.f18539M);
                                this.f18546a.i3().f9977c.setAdapter(this.f18546a.f18538L);
                            } else {
                                N c32 = this.f18546a.f18538L;
                                m.b(c32);
                                c32.a(((S.a) cVar.a()).a());
                            }
                        }
                        N c33 = this.f18546a.f18538L;
                        if (c33 != null) {
                            c33.c(false);
                        }
                    }
                    this.f18546a.i3().f9976b.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UserCommentsActivity userCommentsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18545b = userCommentsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18545b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18544a;
            if (i4 == 0) {
                n.b(obj);
                I g4 = this.f18545b.l3().g();
                a aVar = new a(this.f18545b);
                this.f18544a = 1;
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

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f18548b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f18549a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f18549a = userCommentsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((N.c) cVar.a()).b() == 1) {
                        M1.N c32 = this.f18549a.f18538L;
                        if (c32 != null) {
                            c32.d(((N.c) cVar.a()).a());
                        }
                    } else {
                        Snackbar.make((View) this.f18549a.i3().f9977c, (int) R.string.error_generico, -1).show();
                        UserCommentsActivity userCommentsActivity = this.f18549a;
                        String string = userCommentsActivity.getString(R.string.error_generico);
                        m.d(string, "getString(...)");
                        userCommentsActivity.q0(string);
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UserCommentsActivity userCommentsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18548b = userCommentsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18548b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18547a;
            if (i4 == 0) {
                n.b(obj);
                I j4 = this.f18548b.l3().j();
                a aVar = new a(this.f18548b);
                this.f18547a = 1;
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

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18550a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18550a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18550a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18551a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18551a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18551a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18553b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18552a = aVar;
            this.f18553b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18552a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18553b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserCommentsActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final Q0 h3(UserCommentsActivity userCommentsActivity) {
        return Q0.c(userCommentsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final Q0 i3() {
        return (Q0) this.f18536J.getValue();
    }

    private final void j3() {
        String g4 = ((U) l3().k().getValue()).g();
        if (g4 != null && g4.length() != 0) {
            l3().e(this);
        }
    }

    private final String k3() {
        Bundle extras;
        if (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("userID")) {
            return null;
        }
        return extras.getString("userID");
    }

    /* access modifiers changed from: private */
    public final S l3() {
        return (S) this.f18537K.getValue();
    }

    private final void m3() {
        i3().f9978d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        i3().f9978d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        i3().f9978d.setNavigationOnClickListener(new C1442s5(this));
        i3().f9980f.setTypeface(k.f7778g.w());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        i3().f9977c.addItemDecoration(new o(dimension, dimension, dimension, dimension));
        i3().f9977c.setLayoutManager(linearLayoutManager);
        i3().f9977c.setItemAnimator((RecyclerView.ItemAnimator) null);
        i3().f9977c.addOnScrollListener(new a(linearLayoutManager, this));
        j3();
    }

    /* access modifiers changed from: private */
    public static final void n3(UserCommentsActivity userCommentsActivity, View view) {
        userCommentsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) i3().getRoot());
        ((U) l3().k().getValue()).t(k3());
        m3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
    }
}
