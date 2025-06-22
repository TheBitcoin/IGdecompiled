package com.uptodown.activities;

import J1.C1433r3;
import J1.C1440s3;
import J1.C1447t3;
import J1.C1454u3;
import N1.k;
import R2.g;
import R2.h;
import R2.n;
import R2.s;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import c2.C1662e0;
import com.uptodown.R;
import d3.p;
import g2.L;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONObject;

public final class PasswordRecoveryActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f18138J = h.a(new C1433r3(this));

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18139a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f18140b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PasswordRecoveryActivity passwordRecoveryActivity, V2.d dVar) {
            super(2, dVar);
            this.f18140b = passwordRecoveryActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18140b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18139a;
            if (i4 == 0) {
                n.b(obj);
                PasswordRecoveryActivity passwordRecoveryActivity = this.f18140b;
                this.f18139a = 1;
                if (passwordRecoveryActivity.j3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f18141a;

        /* renamed from: b  reason: collision with root package name */
        Object f18142b;

        /* renamed from: c  reason: collision with root package name */
        Object f18143c;

        /* renamed from: d  reason: collision with root package name */
        Object f18144d;

        /* renamed from: e  reason: collision with root package name */
        Object f18145e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f18146f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f18147g;

        /* renamed from: h  reason: collision with root package name */
        int f18148h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PasswordRecoveryActivity passwordRecoveryActivity, V2.d dVar) {
            super(dVar);
            this.f18147g = passwordRecoveryActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18146f = obj;
            this.f18148h |= Integer.MIN_VALUE;
            return this.f18147g.j3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18149a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f18150b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f18151c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C f18152d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C f18153e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C c5, PasswordRecoveryActivity passwordRecoveryActivity, C c6, C c7, V2.d dVar) {
            super(2, dVar);
            this.f18150b = c5;
            this.f18151c = passwordRecoveryActivity;
            this.f18152d = c6;
            this.f18153e = c7;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18150b, this.f18151c, this.f18152d, this.f18153e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18149a == 0) {
                n.b(obj);
                this.f18150b.f20968a = this.f18151c.getString(R.string.error_generico);
                this.f18151c.k3().f10393d.setVisibility(0);
                this.f18152d.f20968a = this.f18151c.k3().f10392c.getText().toString();
                this.f18153e.f20968a = this.f18151c.k3().f10391b.getText().toString();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18154a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PasswordRecoveryActivity f18155b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f18156c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C f18157d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C f18158e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ A f18159f;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f18160a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ A f18161b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f18162c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ PasswordRecoveryActivity f18163d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C f18164e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(A a5, L l4, PasswordRecoveryActivity passwordRecoveryActivity, C c5, V2.d dVar) {
                super(2, dVar);
                this.f18161b = a5;
                this.f18162c = l4;
                this.f18163d = passwordRecoveryActivity;
                this.f18164e = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f18161b, this.f18162c, this.f18163d, this.f18164e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f18160a == 0) {
                    n.b(obj);
                    if (this.f18161b.f20966a == 0 || this.f18162c.b()) {
                        this.f18163d.o3((String) this.f18164e.f20968a);
                    } else {
                        PasswordRecoveryActivity passwordRecoveryActivity = this.f18163d;
                        passwordRecoveryActivity.o3(passwordRecoveryActivity.getString(R.string.msg_success_recuperar_pass));
                        this.f18163d.finish();
                    }
                    this.f18163d.k3().f10393d.setVisibility(8);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PasswordRecoveryActivity passwordRecoveryActivity, C c5, C c6, C c7, A a5, V2.d dVar) {
            super(2, dVar);
            this.f18155b = passwordRecoveryActivity;
            this.f18156c = c5;
            this.f18157d = c6;
            this.f18158e = c7;
            this.f18159f = a5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18155b, this.f18156c, this.f18157d, this.f18158e, this.f18159f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18154a;
            if (i4 == 0) {
                n.b(obj);
                L U02 = new u2.L(this.f18155b).U0((String) this.f18156c.f20968a, (String) this.f18157d.f20968a);
                if (U02.e() != null) {
                    JSONObject e5 = U02.e();
                    m.b(e5);
                    this.f18158e.f20968a = U02.g(e5);
                    if (!e5.isNull("success")) {
                        this.f18159f.f20966a = e5.optInt("success");
                    }
                }
                E0 c6 = Y.c();
                a aVar = new a(this.f18159f, U02, this.f18155b, this.f18158e, (V2.d) null);
                this.f18154a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final C1662e0 h3(PasswordRecoveryActivity passwordRecoveryActivity) {
        return C1662e0.c(passwordRecoveryActivity.getLayoutInflater());
    }

    private final void i3() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00af, code lost:
        if (o3.C0977g.g(r0, r11, r6) != r7) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j3(V2.d r19) {
        /*
            r18 = this;
            r2 = r18
            r0 = r19
            boolean r1 = r0 instanceof com.uptodown.activities.PasswordRecoveryActivity.b
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.uptodown.activities.PasswordRecoveryActivity$b r1 = (com.uptodown.activities.PasswordRecoveryActivity.b) r1
            int r3 = r1.f18148h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0018
            int r3 = r3 - r4
            r1.f18148h = r3
        L_0x0016:
            r6 = r1
            goto L_0x001e
        L_0x0018:
            com.uptodown.activities.PasswordRecoveryActivity$b r1 = new com.uptodown.activities.PasswordRecoveryActivity$b
            r1.<init>(r2, r0)
            goto L_0x0016
        L_0x001e:
            java.lang.Object r0 = r6.f18146f
            java.lang.Object r7 = W2.b.c()
            int r1 = r6.f18148h
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L_0x0059
            if (r1 == r9) goto L_0x003b
            if (r1 != r8) goto L_0x0033
            R2.n.b(r0)
            goto L_0x00b2
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            java.lang.Object r1 = r6.f18145e
            kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
            java.lang.Object r3 = r6.f18144d
            kotlin.jvm.internal.C r3 = (kotlin.jvm.internal.C) r3
            java.lang.Object r4 = r6.f18143c
            kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
            java.lang.Object r5 = r6.f18142b
            kotlin.jvm.internal.A r5 = (kotlin.jvm.internal.A) r5
            java.lang.Object r9 = r6.f18141a
            com.uptodown.activities.PasswordRecoveryActivity r9 = (com.uptodown.activities.PasswordRecoveryActivity) r9
            R2.n.b(r0)
            r14 = r1
            r15 = r4
            r16 = r5
            r12 = r9
        L_0x0057:
            r13 = r3
            goto L_0x0093
        L_0x0059:
            R2.n.b(r0)
            kotlin.jvm.internal.A r10 = new kotlin.jvm.internal.A
            r10.<init>()
            kotlin.jvm.internal.C r1 = new kotlin.jvm.internal.C
            r1.<init>()
            kotlin.jvm.internal.C r3 = new kotlin.jvm.internal.C
            r3.<init>()
            kotlin.jvm.internal.C r4 = new kotlin.jvm.internal.C
            r4.<init>()
            o3.E0 r11 = o3.Y.c()
            com.uptodown.activities.PasswordRecoveryActivity$c r0 = new com.uptodown.activities.PasswordRecoveryActivity$c
            r5 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f18141a = r2
            r6.f18142b = r10
            r6.f18143c = r1
            r6.f18144d = r3
            r6.f18145e = r4
            r6.f18148h = r9
            java.lang.Object r0 = o3.C0977g.g(r11, r0, r6)
            if (r0 != r7) goto L_0x008d
            goto L_0x00b1
        L_0x008d:
            r15 = r1
            r12 = r2
            r14 = r4
            r16 = r10
            goto L_0x0057
        L_0x0093:
            o3.G r0 = o3.Y.b()
            com.uptodown.activities.PasswordRecoveryActivity$d r11 = new com.uptodown.activities.PasswordRecoveryActivity$d
            r17 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r1 = 0
            r6.f18141a = r1
            r6.f18142b = r1
            r6.f18143c = r1
            r6.f18144d = r1
            r6.f18145e = r1
            r6.f18148h = r8
            java.lang.Object r0 = o3.C0977g.g(r0, r11, r6)
            if (r0 != r7) goto L_0x00b2
        L_0x00b1:
            return r7
        L_0x00b2:
            R2.s r0 = R2.s.f8222a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordRecoveryActivity.j3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final C1662e0 k3() {
        return (C1662e0) this.f18138J.getValue();
    }

    /* access modifiers changed from: private */
    public static final void l3(PasswordRecoveryActivity passwordRecoveryActivity, View view) {
        passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void m3(PasswordRecoveryActivity passwordRecoveryActivity, View view) {
        if (m3.m.p(passwordRecoveryActivity.k3().f10392c.getText().toString(), "", true) || m3.m.p(passwordRecoveryActivity.k3().f10391b.getText().toString(), "", true)) {
            passwordRecoveryActivity.o3(passwordRecoveryActivity.getString(R.string.error_email_vacio_recuperar_pass));
        } else if (!m3.m.p(passwordRecoveryActivity.k3().f10392c.getText().toString(), passwordRecoveryActivity.k3().f10391b.getText().toString(), true)) {
            passwordRecoveryActivity.o3(passwordRecoveryActivity.getString(R.string.error_emails_no_coinciden));
        } else {
            passwordRecoveryActivity.i3();
        }
    }

    /* access modifiers changed from: private */
    public static final void n3(View view) {
    }

    /* access modifiers changed from: private */
    public final void o3(String str) {
        if (str != null) {
            q0(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) k3().getRoot());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_password_recovery);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription((CharSequence) getString(R.string.back));
                toolbar.setNavigationOnClickListener(new C1440s3(this));
            }
            TextView textView = (TextView) findViewById(R.id.tv_title_toolbar_password_recovery);
            if (textView != null) {
                textView.setTypeface(k.f7778g.w());
            }
        }
        EditText editText = k3().f10392c;
        k.a aVar = k.f7778g;
        editText.setTypeface(aVar.x());
        k3().f10391b.setTypeface(aVar.x());
        k3().f10395f.setTypeface(aVar.w());
        k3().f10395f.setOnClickListener(new C1447t3(this));
        k3().f10393d.setOnClickListener(new C1454u3());
    }
}
