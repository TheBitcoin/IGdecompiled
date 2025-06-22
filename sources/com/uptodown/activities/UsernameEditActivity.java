package com.uptodown.activities;

import J1.R5;
import J1.S5;
import J1.T5;
import J1.U5;
import J1.V5;
import J1.W5;
import J1.X5;
import J1.Y5;
import J1.Z5;
import J1.a6;
import J1.b6;
import J1.c6;
import J1.d6;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c2.a1;
import com.uptodown.R;
import com.uptodown.activities.V;
import com.uptodown.util.views.UsernameTextView;
import d3.p;
import g2.U;
import g2.Y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import m3.j;
import o3.C1001s0;
import o3.J;
import o3.L;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.q;
import w2.u;

public final class UsernameEditActivity extends C1826a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f18594M = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private U f18595J;

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18596K = new ViewModelLazy(D.b(V.class), new g(this), new f(this), new h((d3.a) null, this));

    /* renamed from: L  reason: collision with root package name */
    private final R2.g f18597L = R2.h.a(new R5(this));

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f18598a;

        public b(UsernameEditActivity usernameEditActivity) {
            this.f18598a = usernameEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            this.f18598a.r3().f10218y.setText(charSequence);
            this.f18598a.r3().f10219z.setText(charSequence);
            this.f18598a.r3().f10192A.setText(charSequence);
            this.f18598a.r3().f10193B.setText(charSequence);
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f18599a;

        c(UsernameEditActivity usernameEditActivity) {
            this.f18599a = usernameEditActivity;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (charSequence != null) {
                this.f18599a.G3(charSequence.toString());
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18600a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f18601b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ A f18602c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C f18603d;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UsernameEditActivity f18604a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ A f18605b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f18606c;

            a(UsernameEditActivity usernameEditActivity, A a5, C c5) {
                this.f18604a = usernameEditActivity;
                this.f18605b = a5;
                this.f18606c = c5;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, V2.d dVar) {
                Iterator it = arrayList.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    Y y4 = (Y) next;
                    int b5 = y4.b();
                    if (b5 == 0) {
                        this.f18604a.r3().f10206m.setChecked(y4.d());
                        UsernameTextView.a aVar = UsernameTextView.f19434k;
                        UsernameTextView usernameTextView = this.f18604a.r3().f10218y;
                        m.d(usernameTextView, "tvUsernameType0");
                        aVar.a(usernameTextView, y4.e(), y4.c());
                    } else if (b5 == 1) {
                        this.f18604a.r3().f10207n.setChecked(y4.d());
                        UsernameTextView.a aVar2 = UsernameTextView.f19434k;
                        UsernameTextView usernameTextView2 = this.f18604a.r3().f10219z;
                        m.d(usernameTextView2, "tvUsernameType1");
                        aVar2.a(usernameTextView2, y4.e(), y4.c());
                    } else if (b5 == 2) {
                        this.f18604a.r3().f10208o.setChecked(y4.d());
                        UsernameTextView.a aVar3 = UsernameTextView.f19434k;
                        UsernameTextView usernameTextView3 = this.f18604a.r3().f10192A;
                        m.d(usernameTextView3, "tvUsernameType2");
                        aVar3.a(usernameTextView3, y4.e(), y4.c());
                    } else if (b5 == 3) {
                        this.f18604a.r3().f10209p.setChecked(y4.d());
                        UsernameTextView.a aVar4 = UsernameTextView.f19434k;
                        UsernameTextView usernameTextView4 = this.f18604a.r3().f10193B;
                        m.d(usernameTextView4, "tvUsernameType3");
                        aVar4.a(usernameTextView4, y4.e(), y4.c());
                    }
                    if (y4.d()) {
                        this.f18605b.f20966a = y4.b();
                        C c5 = this.f18606c;
                        String c6 = y4.c();
                        m.b(c6);
                        if (c6.length() == 0) {
                            c6 = "type0";
                        }
                        c5.f20968a = c6;
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UsernameEditActivity usernameEditActivity, A a5, C c5, V2.d dVar) {
            super(2, dVar);
            this.f18601b = usernameEditActivity;
            this.f18602c = a5;
            this.f18603d = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18601b, this.f18602c, this.f18603d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18600a;
            if (i4 == 0) {
                n.b(obj);
                I f4 = this.f18601b.s3().f();
                a aVar = new a(this.f18601b, this.f18602c, this.f18603d);
                this.f18600a = 1;
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18607a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsernameEditActivity f18608b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UsernameEditActivity f18609a;

            a(UsernameEditActivity usernameEditActivity) {
                this.f18609a = usernameEditActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18609a.r3().f10205l.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((V.a) cVar.a()).c() == 0 || ((V.a) cVar.a()).a()) {
                        String b5 = ((V.a) cVar.a()).b();
                        if (b5 == null || b5.length() == 0) {
                            UsernameEditActivity usernameEditActivity = this.f18609a;
                            String string = usernameEditActivity.getString(R.string.error_generico);
                            m.d(string, "getString(...)");
                            usernameEditActivity.q0(string);
                        } else {
                            this.f18609a.q0(((V.a) cVar.a()).b());
                        }
                    } else {
                        UsernameEditActivity usernameEditActivity2 = this.f18609a;
                        String string2 = usernameEditActivity2.getString(R.string.username_edit_complete);
                        m.d(string2, "getString(...)");
                        usernameEditActivity2.q0(string2);
                        this.f18609a.setResult(10);
                        this.f18609a.finish();
                    }
                    this.f18609a.r3().f10205l.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(UsernameEditActivity usernameEditActivity, V2.d dVar) {
            super(2, dVar);
            this.f18608b = usernameEditActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18608b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18607a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18608b.s3().e();
                a aVar = new a(this.f18608b);
                this.f18607a = 1;
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18610a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18610a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18610a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18611a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f18611a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18611a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18613b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18612a = aVar;
            this.f18613b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18612a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18613b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UsernameEditActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(UsernameEditActivity usernameEditActivity, A a5, C c5, View view) {
        usernameEditActivity.r3().f10206m.setChecked(false);
        usernameEditActivity.r3().f10208o.setChecked(false);
        usernameEditActivity.r3().f10209p.setChecked(false);
        a5.f20966a = 1;
        c5.f20968a = "type1";
    }

    /* access modifiers changed from: private */
    public static final void B3(UsernameEditActivity usernameEditActivity, A a5, C c5, View view) {
        usernameEditActivity.r3().f10206m.setChecked(false);
        usernameEditActivity.r3().f10207n.setChecked(false);
        usernameEditActivity.r3().f10209p.setChecked(false);
        a5.f20966a = 2;
        c5.f20968a = "type2";
    }

    /* access modifiers changed from: private */
    public static final void C3(UsernameEditActivity usernameEditActivity, A a5, C c5, View view) {
        usernameEditActivity.r3().f10206m.setChecked(false);
        usernameEditActivity.r3().f10207n.setChecked(false);
        usernameEditActivity.r3().f10208o.setChecked(false);
        a5.f20966a = 3;
        c5.f20968a = "type3";
    }

    /* access modifiers changed from: private */
    public static final void D3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void E3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void F3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.Y2();
    }

    /* access modifiers changed from: private */
    public final void G3(String str) {
        if (str.length() <= 0 || str.length() < 3) {
            r3().f10212s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            r3().f10212s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 99) {
            r3().f10211r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            r3().f10211r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || !new j("^[a-zA-Z0-9_]+$").e(str)) {
            r3().f10216w.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            r3().f10216w.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    public static final a1 q3(UsernameEditActivity usernameEditActivity) {
        return a1.c(usernameEditActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final a1 r3() {
        return (a1) this.f18597L.getValue();
    }

    /* access modifiers changed from: private */
    public final V s3() {
        return (V) this.f18596K.getValue();
    }

    private final void t3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            r3().f10210q.setNavigationIcon(drawable);
            r3().f10210q.setNavigationContentDescription((CharSequence) getString(R.string.back));
            r3().f10210q.setNavigationOnClickListener(new V5(this));
        }
        TextView textView = r3().f10213t;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        r3().f10215v.setTypeface(aVar.x());
        r3().f10214u.setTypeface(aVar.x());
        r3().f10199f.setOnClickListener(new Y5(this));
        r3().f10195b.setTypeface(aVar.x());
        EditText editText = r3().f10195b;
        U u4 = this.f18595J;
        m.b(u4);
        editText.setText(u4.h());
        r3().f10217x.setTypeface(aVar.w());
        r3().f10212s.setTypeface(aVar.x());
        r3().f10211r.setTypeface(aVar.x());
        r3().f10216w.setTypeface(aVar.x());
        r3().f10218y.setTypeface(aVar.w());
        r3().f10219z.setTypeface(aVar.w());
        r3().f10192A.setTypeface(aVar.w());
        r3().f10193B.setTypeface(aVar.w());
        UsernameTextView usernameTextView = r3().f10218y;
        U u5 = this.f18595J;
        m.b(u5);
        usernameTextView.setText(u5.h());
        UsernameTextView usernameTextView2 = r3().f10219z;
        U u6 = this.f18595J;
        m.b(u6);
        usernameTextView2.setText(u6.h());
        UsernameTextView usernameTextView3 = r3().f10192A;
        U u7 = this.f18595J;
        m.b(u7);
        usernameTextView3.setText(u7.h());
        UsernameTextView usernameTextView4 = r3().f10193B;
        U u8 = this.f18595J;
        m.b(u8);
        usernameTextView4.setText(u8.h());
        A a5 = new A();
        C c5 = new C();
        c5.f20968a = "type0";
        r3().f10206m.setOnClickListener(new Z5(this, a5, c5));
        r3().f10207n.setOnClickListener(new a6(this, a5, c5));
        r3().f10208o.setOnClickListener(new b6(this, a5, c5));
        r3().f10209p.setOnClickListener(new c6(this, a5, c5));
        U u9 = this.f18595J;
        m.b(u9);
        if (!u9.n()) {
            r3().f10214u.setVisibility(0);
            TextView textView2 = r3().f10214u;
            u.a aVar2 = u.f22048c;
            String string = getString(R.string.username_turbo_styles_locked);
            m.d(string, "getString(...)");
            textView2.setText(aVar2.a(this, string));
            r3().f10214u.setOnClickListener(new d6(this));
            r3().f10215v.setOnClickListener(new S5(this));
            r3().f10199f.setVisibility(8);
            r3().f10206m.setChecked(true);
            r3().f10196c.setVisibility(0);
            r3().f10207n.setEnabled(false);
            r3().f10197d.setVisibility(0);
            r3().f10208o.setEnabled(false);
            r3().f10198e.setVisibility(0);
            r3().f10209p.setEnabled(false);
            r3().f10201h.setOnClickListener(new T5(this));
            r3().f10202i.setOnClickListener(new U5(this));
            r3().f10203j.setOnClickListener(new W5(this));
        }
        r3().f10195b.addTextChangedListener(new c(this));
        r3().f10217x.setOnClickListener(new X5(this, a5, c5));
        EditText editText2 = r3().f10195b;
        m.d(editText2, "etUsernameEdit");
        editText2.addTextChangedListener(new b(this));
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (L) null, new d(this, a5, c5, (V2.d) null), 2, (Object) null);
        s3().d(this);
    }

    /* access modifiers changed from: private */
    public static final void u3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void v3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void w3(UsernameEditActivity usernameEditActivity, View view) {
        usernameEditActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void x3(UsernameEditActivity usernameEditActivity, A a5, C c5, View view) {
        N1.k.f7778g.d(usernameEditActivity, usernameEditActivity.r3().f10195b);
        if (usernameEditActivity.r3().f10195b.getText().toString().length() == 0) {
            String string = usernameEditActivity.getString(R.string.error_email_vacio_recuperar_pass);
            m.d(string, "getString(...)");
            usernameEditActivity.q0(string);
        } else if (usernameEditActivity.r3().f10195b.getText().toString().length() < 3) {
            String string2 = usernameEditActivity.getString(R.string.validation_three_chars_min);
            m.d(string2, "getString(...)");
            usernameEditActivity.q0(string2);
        } else if (usernameEditActivity.r3().f10195b.getText().toString().length() > 99) {
            String string3 = usernameEditActivity.getString(R.string.validation_hundred_chars_max);
            m.d(string3, "getString(...)");
            usernameEditActivity.q0(string3);
        } else {
            if (!new j("^[a-zA-Z0-9_]+$").e(usernameEditActivity.r3().f10195b.getText().toString())) {
                String string4 = usernameEditActivity.getString(R.string.validation_username_chars_type);
                m.d(string4, "getString(...)");
                usernameEditActivity.q0(string4);
                return;
            }
            usernameEditActivity.s3().c(usernameEditActivity, usernameEditActivity.r3().f10195b.getText().toString(), usernameEditActivity.f18595J, a5.f20966a, (String) c5.f20968a);
        }
    }

    /* access modifiers changed from: private */
    public static final void y3(UsernameEditActivity usernameEditActivity, View view) {
        U u4 = usernameEditActivity.f18595J;
        if (u4 != null) {
            m.b(u4);
            if (u4.m(usernameEditActivity)) {
                U u5 = usernameEditActivity.f18595J;
                m.b(u5);
                if (u5.n()) {
                    return;
                }
            }
        }
        q.r(new q(), usernameEditActivity, u2.L.f21898b.c(usernameEditActivity), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void z3(UsernameEditActivity usernameEditActivity, A a5, C c5, View view) {
        usernameEditActivity.r3().f10207n.setChecked(false);
        usernameEditActivity.r3().f10208o.setChecked(false);
        usernameEditActivity.r3().f10209p.setChecked(false);
        a5.f20966a = 0;
        c5.f20968a = "type0";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView((View) r3().getRoot());
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user"))) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f18595J = (U) extras.getParcelable("user", U.class);
            } else {
                this.f18595J = (U) extras.getParcelable("user");
            }
            t3();
        }
        U u4 = this.f18595J;
        if (u4 != null) {
            m.b(u4);
            String h4 = u4.h();
            if (!(h4 == null || h4.length() == 0)) {
                U u5 = this.f18595J;
                m.b(u5);
                String h5 = u5.h();
                m.b(h5);
                G3(h5);
            }
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (L) null, new e(this, (V2.d) null), 2, (Object) null);
    }
}
