package com.uptodown.activities;

import J1.A5;
import J1.B5;
import J1.C1456u5;
import J1.C1463v5;
import J1.C1470w5;
import J1.C1477x5;
import J1.C1484y5;
import J1.C1491z5;
import J1.C5;
import J1.D5;
import J1.E5;
import M1.O;
import N1.k;
import R2.s;
import S2.C1601o;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c2.C1692u;
import c2.S0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.T;
import f2.C2011b;
import f2.C2027s;
import g2.C2050h;
import g2.V;
import g2.r;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import r3.t;
import u2.E;
import u2.q;

public final class UserDeviceDetailsActivity extends C1826a {

    /* renamed from: P  reason: collision with root package name */
    public static final a f18554P = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18555J = R2.h.a(new C1456u5(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18556K = new ViewModelLazy(D.b(T.class), new o(this), new n(this), new p((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public O f18557L;

    /* renamed from: M  reason: collision with root package name */
    private final b f18558M = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public final j f18559N = new j(this);
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public final i f18560O = new i(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements C2011b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18561a;

        b(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            this.f18561a = userDeviceDetailsActivity;
        }

        public void a(int i4) {
            if (this.f18561a.f18557L != null) {
                O o32 = this.f18561a.f18557L;
                kotlin.jvm.internal.m.b(o32);
                String d5 = ((V.c) o32.a().get(i4)).d();
                if (d5 != null && d5.length() != 0) {
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f18561a;
                    O o33 = userDeviceDetailsActivity.f18557L;
                    kotlin.jvm.internal.m.b(o33);
                    String d6 = ((V.c) o33.a().get(i4)).d();
                    kotlin.jvm.internal.m.b(d6);
                    new b2.m(userDeviceDetailsActivity, d6, this.f18561a.f18560O, LifecycleOwnerKt.getLifecycleScope(this.f18561a));
                }
            }
        }
    }

    public static final class c implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj).b()), Long.valueOf(((V.c) obj2).b()));
        }
    }

    public static final class d implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj).b()), Long.valueOf(((V.c) obj2).b()));
        }
    }

    public static final class e implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj2).b()), Long.valueOf(((V.c) obj).b()));
        }
    }

    public static final class f implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj2).b()), Long.valueOf(((V.c) obj).b()));
        }
    }

    public static final class g implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj).b()), Long.valueOf(((V.c) obj2).b()));
        }
    }

    public static final class h implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((V.c) obj2).b()), Long.valueOf(((V.c) obj).b()));
        }
    }

    public static final class i implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18562a;

        i(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            this.f18562a = userDeviceDetailsActivity;
        }

        public void b(int i4) {
            UserDeviceDetailsActivity userDeviceDetailsActivity = this.f18562a;
            String string = userDeviceDetailsActivity.getString(R.string.msg_app_not_found);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            userDeviceDetailsActivity.q0(string);
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (!this.f18562a.isFinishing()) {
                Intent intent = new Intent(this.f18562a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                UserDeviceDetailsActivity userDeviceDetailsActivity = this.f18562a;
                userDeviceDetailsActivity.startActivity(intent, UptodownApp.f17422D.a(userDeviceDetailsActivity));
            }
        }
    }

    public static final class j extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18563a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(UserDeviceDetailsActivity userDeviceDetailsActivity) {
            super(true);
            this.f18563a = userDeviceDetailsActivity;
        }

        public void handleOnBackPressed() {
            this.f18563a.finish();
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18564a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18565b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f18566a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f18566a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (kotlin.jvm.internal.m.a(e5, E.a.f21883a)) {
                    this.f18566a.w3().f10002f.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    this.f18566a.u3(((T.a) ((E.c) e5).a()).a());
                    this.f18566a.w3().f10002f.setVisibility(8);
                    this.f18566a.w3().f10001e.setVisibility(0);
                } else if (!kotlin.jvm.internal.m.a(e5, E.b.f21884a)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(UserDeviceDetailsActivity userDeviceDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18565b = userDeviceDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f18565b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18564a;
            if (i4 == 0) {
                R2.n.b(obj);
                I e5 = this.f18565b.x3().e();
                a aVar = new a(this.f18565b);
                this.f18564a = 1;
                if (e5.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                R2.n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18567a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18568b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f18569a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f18569a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!kotlin.jvm.internal.m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        String a5 = ((T.b) cVar.a()).a();
                        if (!(a5 == null || a5.length() == 0)) {
                            this.f18569a.q0(((T.b) cVar.a()).a());
                        }
                        if (((T.b) cVar.a()).c() == 1) {
                            this.f18569a.w3().f10011o.setText(((T.b) cVar.a()).b());
                            this.f18569a.setResult(3);
                        }
                    } else if (!kotlin.jvm.internal.m.a(e5, E.b.f21884a)) {
                        throw new R2.k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(UserDeviceDetailsActivity userDeviceDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18568b = userDeviceDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f18568b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18567a;
            if (i4 == 0) {
                R2.n.b(obj);
                I f4 = this.f18568b.x3().f();
                a aVar = new a(this.f18568b);
                this.f18567a = 1;
                if (f4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                R2.n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18570a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserDeviceDetailsActivity f18571b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserDeviceDetailsActivity f18572a;

            a(UserDeviceDetailsActivity userDeviceDetailsActivity) {
                this.f18572a = userDeviceDetailsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!kotlin.jvm.internal.m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        String b5 = ((T.c) cVar.a()).b();
                        if (!(b5 == null || b5.length() == 0)) {
                            this.f18572a.q0(((T.c) cVar.a()).b());
                        }
                        if (((T.c) cVar.a()).c() == 1) {
                            r rVar = new r();
                            rVar.j(this.f18572a);
                            if (kotlin.jvm.internal.m.a(((T.c) cVar.a()).a(), rVar.d())) {
                                this.f18572a.setResult(5);
                                this.f18572a.f18559N.handleOnBackPressed();
                            } else {
                                this.f18572a.setResult(4);
                                this.f18572a.f18559N.handleOnBackPressed();
                            }
                        }
                    } else if (!kotlin.jvm.internal.m.a(e5, E.b.f21884a)) {
                        throw new R2.k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(UserDeviceDetailsActivity userDeviceDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18571b = userDeviceDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f18571b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18570a;
            if (i4 == 0) {
                R2.n.b(obj);
                I g4 = this.f18571b.x3().g();
                a aVar = new a(this.f18571b);
                this.f18570a = 1;
                if (g4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                R2.n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class n extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18573a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(ComponentActivity componentActivity) {
            super(0);
            this.f18573a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18573a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class o extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18574a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(ComponentActivity componentActivity) {
            super(0);
            this.f18574a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18574a.getViewModelStore();
        }
    }

    public static final class p extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18575a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18576b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18575a = aVar;
            this.f18576b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18575a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18576b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserDeviceDetailsActivity.p.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void B3(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4, View view) {
        String string = userDeviceDetailsActivity.getString(R.string.unlink_device_confirmation);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        userDeviceDetailsActivity.O1(string, new C5(userDeviceDetailsActivity, v4));
    }

    /* access modifiers changed from: private */
    public static final s C3(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4) {
        userDeviceDetailsActivity.x3().k(userDeviceDetailsActivity, v4.b(), v4.c());
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void D3(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4, View view) {
        userDeviceDetailsActivity.q3(v4);
    }

    /* access modifiers changed from: private */
    public static final void E3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        ArrayList a5;
        ArrayList a6;
        if (((Boolean) userDeviceDetailsActivity.x3().i().getValue()).booleanValue()) {
            O o4 = userDeviceDetailsActivity.f18557L;
            if (!(o4 == null || (a6 = o4.a()) == null || a6.size() <= 1)) {
                C1601o.t(a6, new g());
            }
            O o5 = userDeviceDetailsActivity.f18557L;
            if (o5 != null) {
                o5.notifyDataSetChanged();
            }
            userDeviceDetailsActivity.w3().f9999c.animate().rotation(180.0f).setDuration(200).start();
        } else {
            O o6 = userDeviceDetailsActivity.f18557L;
            if (!(o6 == null || (a5 = o6.a()) == null || a5.size() <= 1)) {
                C1601o.t(a5, new h());
            }
            O o7 = userDeviceDetailsActivity.f18557L;
            if (o7 != null) {
                o7.notifyDataSetChanged();
            }
            userDeviceDetailsActivity.w3().f9999c.animate().rotation(0.0f).setDuration(200).start();
        }
        userDeviceDetailsActivity.x3().i().setValue(Boolean.valueOf(!((Boolean) userDeviceDetailsActivity.x3().i().getValue()).booleanValue()));
        userDeviceDetailsActivity.w3().f10006j.setAdapter(userDeviceDetailsActivity.f18557L);
    }

    private final void F3(RadioButton radioButton) {
        radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_checkbox_selected_button));
        radioButton.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_check_blue), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void G3(RadioButton radioButton) {
        radioButton.setBackground(ContextCompat.getDrawable(this, R.drawable.core_ripple_bg_card));
        radioButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: private */
    public static final S0 p3(UserDeviceDetailsActivity userDeviceDetailsActivity) {
        return S0.c(userDeviceDetailsActivity.getLayoutInflater());
    }

    private final void q3(V v4) {
        if (!isFinishing()) {
            AlertDialog j22 = j2();
            if (j22 != null) {
                j22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1692u c5 = C1692u.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f10780e;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10779d.setTypeface(aVar.w());
            c5.f10779d.setOnClickListener(new D5(this, v4, c5));
            c5.f10778c.setTypeface(aVar.w());
            c5.f10778c.setOnClickListener(new E5(this));
            builder.setView(c5.getRoot());
            J2(builder.create());
            if (!isFinishing() && j2() != null) {
                W2();
                c5.f10777b.postDelayed(new C1463v5(v4, c5, this), 100);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4, C1692u uVar, View view) {
        userDeviceDetailsActivity.x3().j(userDeviceDetailsActivity, v4.b(), uVar.f10777b.getText().toString());
        userDeviceDetailsActivity.i2();
    }

    /* access modifiers changed from: private */
    public static final void s3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.i2();
    }

    /* access modifiers changed from: private */
    public static final void t3(V v4, C1692u uVar, UserDeviceDetailsActivity userDeviceDetailsActivity) {
        String g4 = v4.g();
        if (!(g4 == null || g4.length() == 0)) {
            uVar.f10777b.requestFocus();
            uVar.f10777b.setText(v4.g());
            uVar.f10777b.selectAll();
        }
        EditText editText = uVar.f10777b;
        kotlin.jvm.internal.m.d(editText, "etDialogRename");
        userDeviceDetailsActivity.showKeyboard(editText);
    }

    /* access modifiers changed from: private */
    public final void u3(V v4) {
        w3().f10011o.setText(v4.g());
        w3().f10009m.setText(v4.a());
        w3().f10015s.setText(v4.f());
        if (v4.k() > 0) {
            w3().f10000d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_unchecked));
        } else {
            w3().f10000d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_checked));
        }
        w3().f10005i.setOnCheckedChangeListener(new C1470w5(this, v4));
        this.f18557L = new O(v4.d(), this.f18558M);
        w3().f10006j.setAdapter(this.f18557L);
    }

    /* access modifiers changed from: private */
    public static final void v3(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4, RadioGroup radioGroup, int i4) {
        if (i4 == userDeviceDetailsActivity.w3().f10003g.getId()) {
            if (((Boolean) userDeviceDetailsActivity.x3().i().getValue()).booleanValue()) {
                ArrayList d5 = v4.d();
                if (d5.size() > 1) {
                    C1601o.t(d5, new e());
                }
            } else {
                ArrayList d6 = v4.d();
                if (d6.size() > 1) {
                    C1601o.t(d6, new c());
                }
            }
            O o4 = userDeviceDetailsActivity.f18557L;
            if (o4 != null) {
                o4.d(v4.d());
            }
            RadioButton radioButton = userDeviceDetailsActivity.w3().f10003g;
            kotlin.jvm.internal.m.d(radioButton, "rbInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.F3(radioButton);
            RadioButton radioButton2 = userDeviceDetailsActivity.w3().f10004h;
            kotlin.jvm.internal.m.d(radioButton2, "rbNotInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.G3(radioButton2);
        } else if (i4 == userDeviceDetailsActivity.w3().f10004h.getId()) {
            if (((Boolean) userDeviceDetailsActivity.x3().i().getValue()).booleanValue()) {
                ArrayList h4 = v4.h();
                if (h4.size() > 1) {
                    C1601o.t(h4, new f());
                }
            } else {
                ArrayList h5 = v4.h();
                if (h5.size() > 1) {
                    C1601o.t(h5, new d());
                }
            }
            O o5 = userDeviceDetailsActivity.f18557L;
            if (o5 != null) {
                o5.d(v4.h());
            }
            RadioButton radioButton3 = userDeviceDetailsActivity.w3().f10004h;
            kotlin.jvm.internal.m.d(radioButton3, "rbNotInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.F3(radioButton3);
            RadioButton radioButton4 = userDeviceDetailsActivity.w3().f10003g;
            kotlin.jvm.internal.m.d(radioButton4, "rbInstalledAppsUserDeviceDetails");
            userDeviceDetailsActivity.G3(radioButton4);
        }
        userDeviceDetailsActivity.w3().f10006j.smoothScrollToPosition(0);
    }

    private final void y3(V v4) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            w3().f10007k.setNavigationIcon(drawable);
            w3().f10007k.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        w3().f10007k.setNavigationOnClickListener(new C1477x5(this));
        TextView textView = w3().f10021y;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        w3().f10007k.setNavigationOnClickListener(new C1484y5(this));
        w3().f10011o.setTypeface(aVar.w());
        w3().f10017u.setTypeface(aVar.x());
        w3().f10018v.setTypeface(aVar.x());
        w3().f10008l.setTypeface(aVar.x());
        w3().f10009m.setTypeface(aVar.x());
        w3().f10014r.setTypeface(aVar.x());
        w3().f10015s.setTypeface(aVar.x());
        w3().f10012p.setTypeface(aVar.x());
        w3().f10013q.setTypeface(aVar.x());
        w3().f10020x.setTypeface(aVar.x());
        w3().f10019w.setTypeface(aVar.w());
        w3().f10010n.setTypeface(aVar.w());
        w3().f10003g.setTypeface(aVar.x());
        w3().f10004h.setTypeface(aVar.x());
        w3().f10019w.setOnClickListener(new C1491z5(this, v4));
        w3().f9998b.setOnClickListener(new A5(this, v4));
        w3().f9999c.setOnClickListener(new B5(this));
        w3().f10011o.setText(v4.g());
        w3().f10018v.setText(v4.i());
        w3().f10009m.setText(v4.a());
        w3().f10015s.setText(v4.f());
        w3().f10013q.setText(new q().l(v4.e()));
        w3().f10006j.setLayoutManager(new LinearLayoutManager(this, 1, false));
        w3().f10006j.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        w3().f10006j.addItemDecoration(new w2.l(dimension, dimension));
        x3().d(this, v4);
    }

    /* access modifiers changed from: private */
    public static final void z3(UserDeviceDetailsActivity userDeviceDetailsActivity, View view) {
        userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        setContentView((View) w3().getRoot());
        getOnBackPressedDispatcher().addCallback(this.f18559N);
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user_device"))) {
            t h4 = x3().h();
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("user_device", V.class);
            } else {
                parcelable = extras.getParcelable("user_device");
            }
            kotlin.jvm.internal.m.b(parcelable);
            h4.setValue(parcelable);
            y3((V) x3().h().getValue());
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new k(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new l(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new m(this, (V2.d) null), 2, (Object) null);
    }

    public final S0 w3() {
        return (S0) this.f18555J.getValue();
    }

    public final T x3() {
        return (T) this.f18556K.getValue();
    }
}
