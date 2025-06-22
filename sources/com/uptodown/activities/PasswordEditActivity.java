package com.uptodown.activities;

import J1.C1399m3;
import J1.C1406n3;
import J1.C1413o3;
import J1.C1420p3;
import J1.C1427q3;
import N1.k;
import R2.h;
import R2.n;
import R2.s;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c2.C1660d0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.uptodown.R;
import d3.p;
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

public final class PasswordEditActivity extends C1826a {

    /* renamed from: L  reason: collision with root package name */
    public static final a f18122L = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18123J = new ViewModelLazy(D.b(C1847w.class), new f(this), new e(this), new g((d3.a) null, this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18124K = h.a(new C1399m3(this));

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f18125a;

        b(PasswordEditActivity passwordEditActivity) {
            this.f18125a = passwordEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (charSequence != null) {
                this.f18125a.q3(charSequence.toString());
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f18126a;

        c(PasswordEditActivity passwordEditActivity) {
            this.f18126a = passwordEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (charSequence != null) {
                PasswordEditActivity passwordEditActivity = this.f18126a;
                passwordEditActivity.q3(passwordEditActivity.j3().f10346c.getText().toString());
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordEditActivity f18128b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PasswordEditActivity f18129a;

            /* renamed from: com.uptodown.activities.PasswordEditActivity$d$a$a  reason: collision with other inner class name */
            static final class C0222a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                Object f18130a;

                /* renamed from: b  reason: collision with root package name */
                /* synthetic */ Object f18131b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ a f18132c;

                /* renamed from: d  reason: collision with root package name */
                int f18133d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0222a(a aVar, V2.d dVar) {
                    super(dVar);
                    this.f18132c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f18131b = obj;
                    this.f18133d |= Integer.MIN_VALUE;
                    return this.f18132c.emit((E) null, this);
                }
            }

            a(PasswordEditActivity passwordEditActivity) {
                this.f18129a = passwordEditActivity;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(u2.E r5, V2.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.uptodown.activities.PasswordEditActivity.d.a.C0222a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.uptodown.activities.PasswordEditActivity$d$a$a r0 = (com.uptodown.activities.PasswordEditActivity.d.a.C0222a) r0
                    int r1 = r0.f18133d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f18133d = r1
                    goto L_0x0018
                L_0x0013:
                    com.uptodown.activities.PasswordEditActivity$d$a$a r0 = new com.uptodown.activities.PasswordEditActivity$d$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f18131b
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.f18133d
                    r3 = 1
                    if (r2 == 0) goto L_0x0035
                    if (r2 != r3) goto L_0x002d
                    java.lang.Object r5 = r0.f18130a
                    com.uptodown.activities.PasswordEditActivity$d$a r5 = (com.uptodown.activities.PasswordEditActivity.d.a) r5
                    R2.n.b(r6)
                    goto L_0x0088
                L_0x002d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0035:
                    R2.n.b(r6)
                    boolean r6 = r5 instanceof u2.E.a
                    if (r6 == 0) goto L_0x004a
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f18129a
                    c2.d0 r5 = r5.j3()
                    android.view.View r5 = r5.f10349f
                    r6 = 0
                    r5.setVisibility(r6)
                    goto L_0x00d9
                L_0x004a:
                    boolean r6 = r5 instanceof u2.E.c
                    if (r6 == 0) goto L_0x00d5
                    u2.E$c r5 = (u2.E.c) r5
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.w$a r6 = (com.uptodown.activities.C1847w.a) r6
                    int r6 = r6.c()
                    java.lang.String r2 = "getString(...)"
                    if (r6 == 0) goto L_0x0094
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.w$a r6 = (com.uptodown.activities.C1847w.a) r6
                    boolean r6 = r6.a()
                    if (r6 == 0) goto L_0x006b
                    goto L_0x0094
                L_0x006b:
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f18129a
                    r6 = 2131952472(0x7f130358, float:1.9541388E38)
                    java.lang.String r6 = r5.getString(r6)
                    kotlin.jvm.internal.m.d(r6, r2)
                    r5.q0(r6)
                    r0.f18130a = r4
                    r0.f18133d = r3
                    r5 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r5 = o3.U.b(r5, r0)
                    if (r5 != r1) goto L_0x0087
                    return r1
                L_0x0087:
                    r5 = r4
                L_0x0088:
                    com.uptodown.activities.PasswordEditActivity r6 = r5.f18129a
                    r0 = 2
                    r6.setResult(r0)
                    com.uptodown.activities.PasswordEditActivity r6 = r5.f18129a
                    r6.finish()
                    goto L_0x00c7
                L_0x0094:
                    java.lang.Object r6 = r5.a()
                    com.uptodown.activities.w$a r6 = (com.uptodown.activities.C1847w.a) r6
                    java.lang.String r6 = r6.b()
                    if (r6 == 0) goto L_0x00b7
                    int r6 = r6.length()
                    if (r6 != 0) goto L_0x00a7
                    goto L_0x00b7
                L_0x00a7:
                    com.uptodown.activities.PasswordEditActivity r6 = r4.f18129a
                    java.lang.Object r5 = r5.a()
                    com.uptodown.activities.w$a r5 = (com.uptodown.activities.C1847w.a) r5
                    java.lang.String r5 = r5.b()
                    r6.q0(r5)
                    goto L_0x00c6
                L_0x00b7:
                    com.uptodown.activities.PasswordEditActivity r5 = r4.f18129a
                    r6 = 2131952002(0x7f130182, float:1.9540434E38)
                    java.lang.String r6 = r5.getString(r6)
                    kotlin.jvm.internal.m.d(r6, r2)
                    r5.q0(r6)
                L_0x00c6:
                    r5 = r4
                L_0x00c7:
                    com.uptodown.activities.PasswordEditActivity r5 = r5.f18129a
                    c2.d0 r5 = r5.j3()
                    android.view.View r5 = r5.f10349f
                    r6 = 8
                    r5.setVisibility(r6)
                    goto L_0x00d9
                L_0x00d5:
                    boolean r5 = r5 instanceof u2.E.b
                    if (r5 == 0) goto L_0x00dc
                L_0x00d9:
                    R2.s r5 = R2.s.f8222a
                    return r5
                L_0x00dc:
                    R2.k r5 = new R2.k
                    r5.<init>()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordEditActivity.d.a.emit(u2.E, V2.d):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PasswordEditActivity passwordEditActivity, V2.d dVar) {
            super(2, dVar);
            this.f18128b = passwordEditActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18128b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18127a;
            if (i4 == 0) {
                n.b(obj);
                I c6 = this.f18128b.k3().c();
                a aVar = new a(this.f18128b);
                this.f18127a = 1;
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18134a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18134a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18134a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18135a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18135a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18135a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18136a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18137b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18136a = aVar;
            this.f18137b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18136a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18137b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordEditActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final C1660d0 i3(PasswordEditActivity passwordEditActivity) {
        return C1660d0.c(passwordEditActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C1660d0 j3() {
        return (C1660d0) this.f18124K.getValue();
    }

    /* access modifiers changed from: private */
    public final C1847w k3() {
        return (C1847w) this.f18123J.getValue();
    }

    private final void l3() {
        setContentView((View) j3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            j3().f10350g.setNavigationIcon(drawable);
            j3().f10350g.setNavigationContentDescription((CharSequence) getString(R.string.back));
            j3().f10350g.setNavigationOnClickListener(new C1406n3(this));
        }
        TextView textView = j3().f10355l;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        j3().f10346c.setTypeface(aVar.x());
        j3().f10345b.setTypeface(aVar.x());
        j3().f10354k.setTypeface(aVar.w());
        j3().f10353j.setTypeface(aVar.x());
        j3().f10352i.setTypeface(aVar.x());
        j3().f10351h.setTypeface(aVar.x());
        j3().f10348e.setOnClickListener(new C1413o3(this));
        j3().f10347d.setOnClickListener(new C1420p3(this));
        j3().f10346c.addTextChangedListener(new b(this));
        j3().f10345b.addTextChangedListener(new c(this));
        j3().f10354k.setOnClickListener(new C1427q3(this));
    }

    /* access modifiers changed from: private */
    public static final void m3(PasswordEditActivity passwordEditActivity, View view) {
        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void n3(PasswordEditActivity passwordEditActivity, View view) {
        EditText editText = passwordEditActivity.j3().f10346c;
        m.d(editText, "etPasswordEdit");
        ImageView imageView = passwordEditActivity.j3().f10348e;
        m.d(imageView, "ivPasswordEdit");
        passwordEditActivity.r3(editText, imageView);
    }

    /* access modifiers changed from: private */
    public static final void o3(PasswordEditActivity passwordEditActivity, View view) {
        EditText editText = passwordEditActivity.j3().f10345b;
        m.d(editText, "etConfirmPasswordEdit");
        ImageView imageView = passwordEditActivity.j3().f10347d;
        m.d(imageView, "ivConfirmPasswordEdit");
        passwordEditActivity.r3(editText, imageView);
    }

    /* access modifiers changed from: private */
    public static final void p3(PasswordEditActivity passwordEditActivity, View view) {
        k.f7778g.d(passwordEditActivity, passwordEditActivity.j3().f10346c);
        if (passwordEditActivity.j3().f10346c.getText().toString().length() == 0 || passwordEditActivity.j3().f10345b.getText().toString().length() == 0) {
            String string = passwordEditActivity.getString(R.string.error_email_vacio_recuperar_pass);
            m.d(string, "getString(...)");
            passwordEditActivity.q0(string);
        } else if (passwordEditActivity.j3().f10346c.getText().toString().length() < 6) {
            String string2 = passwordEditActivity.getString(R.string.validation_six_chars_min);
            m.d(string2, "getString(...)");
            passwordEditActivity.q0(string2);
        } else if (passwordEditActivity.j3().f10346c.getText().toString().length() > 99) {
            String string3 = passwordEditActivity.getString(R.string.validation_hundred_chars_max);
            m.d(string3, "getString(...)");
            passwordEditActivity.q0(string3);
        } else if (!m.a(passwordEditActivity.j3().f10346c.getText().toString(), passwordEditActivity.j3().f10345b.getText().toString())) {
            String string4 = passwordEditActivity.getString(R.string.password_edit_not_match);
            m.d(string4, "getString(...)");
            passwordEditActivity.q0(string4);
        } else {
            passwordEditActivity.k3().b(passwordEditActivity, passwordEditActivity.j3().f10346c.getText().toString(), passwordEditActivity.j3().f10345b.getText().toString());
        }
    }

    /* access modifiers changed from: private */
    public final void q3(String str) {
        if (str.length() <= 0 || str.length() < 6) {
            j3().f10353j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            j3().f10353j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || str.length() > 99) {
            j3().f10352i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            j3().f10352i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (m.a(str, j3().f10345b.getText().toString())) {
            j3().f10351h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            j3().f10351h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private final void r3(EditText editText, ImageView imageView) {
        if (editText.getInputType() == 129) {
            editText.setInputType(145);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_visible));
            editText.setSelection(editText.length());
            return;
        }
        editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_hidden));
        editText.setSelection(editText.length());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) j3().getRoot());
        l3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
    }
}
