package com.uptodown.activities;

import J1.C1354g0;
import J1.C1361h0;
import J1.C1368i0;
import J1.C1375j0;
import J1.C1382k0;
import J1.C1389l0;
import J1.C1396m0;
import J1.C1403n0;
import J1.C1410o0;
import J1.C1417p0;
import J1.C1424q0;
import J1.C1430r0;
import J1.C1437s0;
import J1.C1444t0;
import J1.C1472x0;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c2.O;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1837l;
import d3.p;
import g2.U;
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
import u2.E;

public final class LoginActivity extends C1472x0 {

    /* renamed from: R  reason: collision with root package name */
    public static final a f17752R = new a((C2103g) null);

    /* renamed from: N  reason: collision with root package name */
    private final R2.g f17753N = R2.h.a(new C1382k0(this));

    /* renamed from: O  reason: collision with root package name */
    private final R2.g f17754O = new ViewModelLazy(D.b(C1837l.class), new i(this), new h(this), new j((d3.a) null, this));

    /* renamed from: P  reason: collision with root package name */
    private Drawable f17755P;

    /* renamed from: Q  reason: collision with root package name */
    private final c f17756Q = new c(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17757a;

        b(LoginActivity loginActivity) {
            this.f17757a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            m.e(animation, "animation");
            this.f17757a.P3().f9870c.getRoot().setVisibility(8);
            this.f17757a.n4();
        }

        public void onAnimationRepeat(Animation animation) {
            m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            m.e(animation, "animation");
        }
    }

    public static final class c extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17758a;

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f17759a;

            a(LoginActivity loginActivity) {
                this.f17759a = loginActivity;
            }

            public void onAnimationEnd(Animation animation) {
                m.e(animation, "animation");
                this.f17759a.P3().f9871d.getRoot().setVisibility(8);
                this.f17759a.m4();
            }

            public void onAnimationRepeat(Animation animation) {
                m.e(animation, "animation");
            }

            public void onAnimationStart(Animation animation) {
                m.e(animation, "animation");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LoginActivity loginActivity) {
            super(true);
            this.f17758a = loginActivity;
        }

        public void handleOnBackPressed() {
            if (this.f17758a.P3().f9871d.getRoot().getVisibility() == 0) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setDuration(200);
                alphaAnimation.setAnimationListener(new a(this.f17758a));
                this.f17758a.P3().f9871d.getRoot().startAnimation(alphaAnimation);
                return;
            }
            this.f17758a.finish();
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17761b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f17762a;

            a(LoginActivity loginActivity) {
                this.f17762a = loginActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f17762a.P3().f9869b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    U e6 = U.f20468m.e(this.f17762a);
                    if (e6 == null || !e6.m(this.f17762a)) {
                        E.c cVar = (E.c) e5;
                        if (((C1837l.a) cVar.a()).b() != null) {
                            this.f17762a.q0(((C1837l.a) cVar.a()).b());
                        } else {
                            LoginActivity loginActivity = this.f17762a;
                            String string = loginActivity.getString(R.string.login_error_message);
                            m.d(string, "getString(...)");
                            loginActivity.q0(string);
                        }
                    } else {
                        E.c cVar2 = (E.c) e5;
                        if (((C1837l.a) cVar2.a()).a() != null) {
                            this.f17762a.q0(((C1837l.a) cVar2.a()).a());
                        }
                        this.f17762a.t3();
                        this.f17762a.setResult(1);
                    }
                    this.f17762a.P3().f9869b.setVisibility(8);
                    if (e6 != null && e6.m(this.f17762a) && ((C1837l.a) ((E.c) e5).a()).a() == null) {
                        this.f17762a.getOnBackPressedDispatcher().onBackPressed();
                    }
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LoginActivity loginActivity, V2.d dVar) {
            super(2, dVar);
            this.f17761b = loginActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17761b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17760a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f17761b.Q3().e();
                a aVar = new a(this.f17761b);
                this.f17760a = 1;
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17763a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17764b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f17765a;

            a(LoginActivity loginActivity) {
                this.f17765a = loginActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f17765a.P3().f9869b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((C1837l.b) cVar.a()).c() == 1) {
                        String b5 = ((C1837l.b) cVar.a()).b();
                        if (!(b5 == null || b5.length() == 0)) {
                            this.f17765a.q0(((C1837l.b) cVar.a()).b());
                        }
                        this.f17765a.k4();
                        this.f17765a.l4();
                    } else {
                        String a5 = ((C1837l.b) cVar.a()).a();
                        if (a5 == null || a5.length() == 0) {
                            LoginActivity loginActivity = this.f17765a;
                            String string = loginActivity.getString(R.string.signup_error_message);
                            m.d(string, "getString(...)");
                            loginActivity.q0(string);
                        } else {
                            this.f17765a.q0(((C1837l.b) cVar.a()).a());
                        }
                    }
                    this.f17765a.P3().f9869b.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(LoginActivity loginActivity, V2.d dVar) {
            super(2, dVar);
            this.f17764b = loginActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17764b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17763a;
            if (i4 == 0) {
                n.b(obj);
                I f4 = this.f17764b.Q3().f();
                a aVar = new a(this.f17764b);
                this.f17763a = 1;
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17766a;

        f(LoginActivity loginActivity) {
            this.f17766a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            m.e(animation, "animation");
            this.f17766a.P3().f9870c.getRoot().setVisibility(0);
            this.f17766a.P3().f9873f.setText(R.string.title_login);
        }

        public void onAnimationRepeat(Animation animation) {
            m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            m.e(animation, "animation");
        }
    }

    public static final class g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginActivity f17767a;

        g(LoginActivity loginActivity) {
            this.f17767a = loginActivity;
        }

        public void onAnimationEnd(Animation animation) {
            m.e(animation, "animation");
            this.f17767a.P3().f9871d.getRoot().setVisibility(0);
            this.f17767a.P3().f9873f.setText(R.string.title_sign_up);
        }

        public void onAnimationRepeat(Animation animation) {
            m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            m.e(animation, "animation");
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17768a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f17768a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f17768a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17769a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f17769a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f17769a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f17770a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17771b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f17770a = aVar;
            this.f17771b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f17770a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f17771b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LoginActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final O O3(LoginActivity loginActivity) {
        return O.c(loginActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final O P3() {
        return (O) this.f17753N.getValue();
    }

    /* access modifiers changed from: private */
    public final C1837l Q3() {
        return (C1837l) this.f17754O.getValue();
    }

    private final void R3() {
        Object systemService = getSystemService("input_method");
        m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        inputMethodManager.hideSoftInputFromWindow(P3().f9871d.f9741c.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(P3().f9871d.f9743e.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(P3().f9871d.f9742d.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(P3().f9870c.f9880c.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(P3().f9870c.f9879b.getWindowToken(), 0);
    }

    private final void S3() {
        k.a aVar = N1.k.f7778g;
        ((TextView) findViewById(R.id.tv_title_download_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_download_benefit)).setTypeface(aVar.x());
        ((TextView) findViewById(R.id.tv_title_discover_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_discover_benefit)).setTypeface(aVar.x());
        ((TextView) findViewById(R.id.tv_title_share_benefit)).setTypeface(aVar.w());
        ((TextView) findViewById(R.id.tv_desc_share_benefit)).setTypeface(aVar.x());
    }

    private final void T3() {
        setContentView((View) P3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        this.f17755P = drawable;
        if (drawable != null) {
            m.b(drawable);
            T2(drawable, ContextCompat.getColor(this, R.color.toolbar_icon));
            P3().f9872e.setNavigationIcon(this.f17755P);
            P3().f9872e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        P3().f9872e.setNavigationOnClickListener(new C1354g0(this));
        TextView textView = P3().f9873f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        P3().f9870c.f9887j.setTypeface(aVar.w());
        P3().f9870c.f9884g.setTypeface(aVar.x());
        P3().f9871d.f9748j.setTypeface(aVar.x());
        P3().f9869b.setOnClickListener(new C1410o0());
        P3().f9870c.f9887j.setOnClickListener(new C1417p0(this));
        P3().f9870c.f9885h.setTypeface(aVar.w());
        P3().f9870c.f9885h.setOnClickListener(new C1424q0(this));
        P3().f9870c.f9880c.setTypeface(aVar.x());
        P3().f9870c.f9880c.setOnFocusChangeListener(new C1430r0(this));
        P3().f9870c.f9879b.setTypeface(aVar.x());
        P3().f9870c.f9879b.setImeOptions(6);
        P3().f9870c.f9879b.setOnEditorActionListener(new C1437s0(this));
        P3().f9870c.f9879b.setOnFocusChangeListener(new C1444t0(this));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            Drawable[] compoundDrawables = P3().f9870c.f9879b.getCompoundDrawables();
            m.d(compoundDrawables, "getCompoundDrawables(...)");
            Drawable drawable2 = compoundDrawables[0];
            if (drawable2 != null) {
                m.b(drawable2);
                drawable2.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
            }
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_pass_forget_login);
        if (textView2 != null) {
            textView2.setTypeface(aVar.w());
            textView2.setOnClickListener(new C1361h0(this));
        }
        P3().f9871d.f9750l.setTypeface(aVar.w());
        P3().f9871d.f9750l.setOnClickListener(new C1368i0(this));
        P3().f9871d.f9743e.setTypeface(aVar.x());
        P3().f9871d.f9743e.setOnFocusChangeListener(new C1375j0(this));
        P3().f9871d.f9747i.setTypeface(aVar.w());
        P3().f9871d.f9747i.setOnClickListener(new C1389l0(this));
        P3().f9871d.f9741c.setTypeface(aVar.x());
        P3().f9871d.f9741c.setOnFocusChangeListener(new C1396m0(this));
        P3().f9871d.f9742d.setTypeface(aVar.x());
        P3().f9871d.f9742d.setOnFocusChangeListener(new C1403n0(this));
        if (i4 < 23) {
            Drawable[] compoundDrawables2 = P3().f9871d.f9742d.getCompoundDrawables();
            m.d(compoundDrawables2, "getCompoundDrawables(...)");
            Drawable drawable3 = compoundDrawables2[0];
            if (drawable3 != null) {
                m.b(drawable3);
                drawable3.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
            }
        }
        P3().f9871d.f9740b.setTypeface(aVar.x());
        P3().f9871d.f9740b.setMovementMethod(LinkMovementMethod.getInstance());
        i3(P3());
        S3();
    }

    /* access modifiers changed from: private */
    public static final void U3(LoginActivity loginActivity, View view) {
        loginActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void V3(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.P3().f9871d.f9743e.setHint("");
        } else {
            loginActivity.P3().f9871d.f9743e.setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void W3(LoginActivity loginActivity, View view) {
        loginActivity.f17756Q.handleOnBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void X3(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.P3().f9871d.f9741c.setHint("");
        } else {
            loginActivity.P3().f9871d.f9741c.setHint(loginActivity.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void Y3(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.P3().f9871d.f9742d.setHint("");
        } else {
            loginActivity.P3().f9871d.f9742d.setHint(loginActivity.getString(R.string.hint_pass_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void Z3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void a4(LoginActivity loginActivity, View view) {
        if (loginActivity.P3().f9871d.getRoot().getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(200);
            alphaAnimation.setAnimationListener(new b(loginActivity));
            loginActivity.P3().f9870c.getRoot().startAnimation(alphaAnimation);
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(LoginActivity loginActivity, View view) {
        loginActivity.j4();
    }

    /* access modifiers changed from: private */
    public static final void c4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.P3().f9870c.f9880c.setHint("");
        } else {
            loginActivity.P3().f9870c.f9880c.setHint(loginActivity.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean d4(LoginActivity loginActivity, TextView textView, int i4, KeyEvent keyEvent) {
        if (i4 != 6) {
            return false;
        }
        loginActivity.j4();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void e4(LoginActivity loginActivity, View view, boolean z4) {
        if (z4) {
            loginActivity.P3().f9870c.f9879b.setHint("");
        } else {
            loginActivity.P3().f9870c.f9879b.setHint(loginActivity.getString(R.string.hint_pass_login_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent(loginActivity.getApplicationContext(), PasswordRecoveryActivity.class), UptodownApp.f17422D.a(loginActivity));
    }

    /* access modifiers changed from: private */
    public static final void g4(LoginActivity loginActivity, View view) {
        loginActivity.o4();
    }

    private final void h4(String str, String str2) {
        Q3().c(this, str, str2);
    }

    private final void i4(String str, String str2, String str3) {
        Q3().d(this, str, str2, str3);
    }

    private final void j4() {
        R3();
        if (Q3().g(P3().f9870c.f9880c.getText().toString(), P3().f9870c.f9879b.getText().toString())) {
            h4(P3().f9870c.f9880c.getText().toString(), P3().f9870c.f9879b.getText().toString());
            return;
        }
        String string = getString(R.string.faltan_datos_login);
        m.d(string, "getString(...)");
        q0(string);
    }

    /* access modifiers changed from: private */
    public final void k4() {
        O P32 = P3();
        P32.f9871d.f9743e.setText("");
        P32.f9870c.f9880c.setText("");
        P32.f9871d.f9741c.setText("");
        P32.f9871d.f9741c.setEnabled(true);
        P32.f9871d.f9742d.setText("");
        P32.f9870c.f9879b.setText("");
        P32.f9871d.f9740b.setChecked(false);
    }

    /* access modifiers changed from: private */
    public final void l4() {
        O P32 = P3();
        P32.f9873f.setText(getString(R.string.title_login));
        P32.f9870c.getRoot().setVisibility(0);
        P32.f9871d.getRoot().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void m4() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new f(this));
        TextView e32 = e3();
        if (e32 != null) {
            e32.setText(getString(R.string.title_login));
        }
        P3().f9870c.getRoot().setVisibility(0);
        P3().f9870c.getRoot().startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    public final void n4() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new g(this));
        TextView e32 = e3();
        if (e32 != null) {
            e32.setText(getString(R.string.sign_up_with_google));
        }
        P3().f9871d.getRoot().setVisibility(0);
        P3().f9871d.getRoot().startAnimation(alphaAnimation);
    }

    private final void o4() {
        R3();
        boolean i4 = Q3().i(P3().f9871d.f9741c.getText().toString());
        if (Q3().h(P3().f9871d.f9743e.getText().toString(), P3().f9871d.f9741c.getText().toString(), P3().f9871d.f9742d.getText().toString()) && i4 && P3().f9871d.f9740b.isChecked()) {
            i4(P3().f9871d.f9743e.getText().toString(), P3().f9871d.f9741c.getText().toString(), P3().f9871d.f9742d.getText().toString());
        } else if (!P3().f9871d.f9740b.isChecked()) {
            String string = getString(R.string.falta_condiciones_uso);
            m.d(string, "getString(...)");
            q0(string);
        } else if (P3().f9871d.f9742d.length() < 6) {
            String string2 = getString(R.string.validation_six_chars_min);
            m.d(string2, "getString(...)");
            q0(string2);
        } else if (P3().f9871d.f9742d.length() > 99) {
            String string3 = getString(R.string.validation_hundred_chars_max);
            m.d(string3, "getString(...)");
            q0(string3);
        } else if (!i4) {
            String string4 = getString(R.string.error_email_not_valid);
            m.d(string4, "getString(...)");
            q0(string4);
        } else {
            String string5 = getString(R.string.faltan_datos_registro);
            m.d(string5, "getString(...)");
            q0(string5);
        }
    }

    /* access modifiers changed from: protected */
    public void h3() {
        P3().f9869b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, this.f17756Q);
        T3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Drawable drawable = this.f17755P;
        if (drawable != null) {
            m.b(drawable);
            DrawableCompat.setTintList(drawable, (ColorStateList) null);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        R3();
        U e5 = U.f20468m.e(this);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str != null && e5.m(this)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void p3(U u4) {
        String str;
        if (u4 != null) {
            u4.p(this);
        }
        try {
            if (u4 != null) {
                str = u4.h();
            } else {
                str = null;
            }
            AccountManager.get(getBaseContext()).addAccountExplicitly(new Account(str, getString(R.string.account)), (String) null, (Bundle) null);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void r3(U u4, String str) {
        String str2;
        h3();
        EditText editText = P3().f9871d.f9743e;
        String str3 = null;
        if (u4 != null) {
            str2 = u4.h();
        } else {
            str2 = null;
        }
        editText.setText(str2);
        EditText editText2 = P3().f9871d.f9741c;
        if (u4 != null) {
            str3 = u4.f();
        }
        editText2.setText(str3);
        P3().f9871d.f9741c.setEnabled(false);
        if (str != null) {
            q0(str);
        }
    }

    /* access modifiers changed from: protected */
    public void s3() {
        P3().f9869b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void t3() {
        String string = getString(R.string.login_successful);
        m.d(string, "getString(...)");
        q0(string);
    }
}
