package com.uptodown.activities;

import J1.C1338d5;
import J1.C1345e5;
import J1.C1352f5;
import J1.C1359g5;
import J1.C1366h5;
import J1.C1373i5;
import J1.C1380j5;
import J1.C1387k5;
import J1.C1394l5;
import J1.C1401m5;
import J1.C1408n5;
import J1.C1446t2;
import M1.J;
import N1.k;
import R2.s;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.WorkManager;
import b2.C1629a;
import c2.C1685q;
import c2.J0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.P;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadWorker;
import f2.C2008G;
import f2.C2009H;
import f2.C2011b;
import f2.C2016g;
import f2.C2029u;
import g2.C2048f;
import g2.C2060s;
import g2.S;
import g2.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.G;
import o3.C0977g;
import o3.C1001s0;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import u2.t;
import u2.x;

public final class Updates extends C1446t2 {

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f18462V = R2.h.a(new C1338d5(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f18463W = new ViewModelLazy(D.b(P.class), new j(this), new i(this), new k((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public ArrayList f18464X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public J f18465Y;

    /* renamed from: Z  reason: collision with root package name */
    private boolean f18466Z;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public ArrayList f18467m0 = new ArrayList();

    /* renamed from: n0  reason: collision with root package name */
    private n f18468n0 = new n(this);

    /* renamed from: o0  reason: collision with root package name */
    private a f18469o0 = new a(this);

    /* renamed from: p0  reason: collision with root package name */
    private q f18470p0 = new q(this);

    /* renamed from: q0  reason: collision with root package name */
    private d f18471q0 = new d(this);

    /* renamed from: r0  reason: collision with root package name */
    private final ActivityResultLauncher f18472r0;

    /* renamed from: s0  reason: collision with root package name */
    private final e f18473s0;

    public static final class a implements C2011b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18474a;

        a(Updates updates) {
            this.f18474a = updates;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: g2.f} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r3) {
            /*
                r2 = this;
                com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
                boolean r0 = r0.a0()
                if (r0 == 0) goto L_0x0076
                com.uptodown.activities.Updates r0 = r2.f18474a
                M1.J r0 = r0.f18465Y
                r1 = 0
                if (r0 == 0) goto L_0x001c
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                java.lang.Object r0 = r0.get(r3)
                goto L_0x001d
            L_0x001c:
                r0 = r1
            L_0x001d:
                boolean r0 = r0 instanceof M1.J.a
                if (r0 == 0) goto L_0x003e
                com.uptodown.activities.Updates r0 = r2.f18474a
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.m.c(r0, r1)
                M1.J$a r0 = (M1.J.a) r0
                g2.f r1 = r0.a()
                goto L_0x006f
            L_0x003e:
                com.uptodown.activities.Updates r0 = r2.f18474a
                M1.J r0 = r0.f18465Y
                if (r0 == 0) goto L_0x0051
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r0.get(r3)
                goto L_0x0052
            L_0x0051:
                r0 = r1
            L_0x0052:
                boolean r0 = r0 instanceof g2.C2048f
                if (r0 == 0) goto L_0x006f
                com.uptodown.activities.Updates r0 = r2.f18474a
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.m.c(r0, r1)
                r1 = r0
                g2.f r1 = (g2.C2048f) r1
            L_0x006f:
                if (r1 == 0) goto L_0x0076
                com.uptodown.activities.Updates r0 = r2.f18474a
                r0.T3(r1, r3)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.a.a(int):void");
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18475a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18476b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Updates f18477c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18478d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Updates updates, String str2, V2.d dVar) {
            super(2, dVar);
            this.f18476b = str;
            this.f18477c = updates;
            this.f18478d = str2;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18476b, this.f18477c, this.f18478d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18475a == 0) {
                R2.n.b(obj);
                if (kotlin.jvm.internal.m.a(this.f18476b, "app_installed")) {
                    this.f18477c.J5(false);
                } else {
                    int Z4 = this.f18477c.u5(this.f18478d);
                    if (kotlin.jvm.internal.m.a(this.f18476b, "app_updated")) {
                        if (Z4 >= 0) {
                            ArrayList X4 = this.f18477c.f18464X;
                            if (X4 != null) {
                                J U4 = this.f18477c.f18465Y;
                                kotlin.jvm.internal.m.b(U4);
                                kotlin.coroutines.jvm.internal.b.a(G.a(X4).remove(U4.b().get(Z4)));
                            }
                            J U42 = this.f18477c.f18465Y;
                            kotlin.jvm.internal.m.b(U42);
                            U42.h(Z4);
                        }
                        UptodownApp.f17422D.K0((C2048f) null);
                        this.f18477c.p5();
                    } else if (kotlin.jvm.internal.m.a(this.f18476b, "app_uninstalled") && Z4 >= 0) {
                        ArrayList X42 = this.f18477c.f18464X;
                        if (X42 != null) {
                            J U43 = this.f18477c.f18465Y;
                            kotlin.jvm.internal.m.b(U43);
                            kotlin.coroutines.jvm.internal.b.a(G.a(X42).remove(U43.b().get(Z4)));
                        }
                        J U44 = this.f18477c.f18465Y;
                        kotlin.jvm.internal.m.b(U44);
                        U44.b().remove(Z4);
                        J U45 = this.f18477c.f18465Y;
                        kotlin.jvm.internal.m.b(U45);
                        U45.notifyItemRemoved(Z4);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18479a;

        c(Updates updates) {
            this.f18479a = updates;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f18479a.t5().f9802g.setPadding(0, 0, 0, 0);
        }
    }

    public static final class d implements C2029u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18480a;

        d(Updates updates) {
            this.f18480a = updates;
        }

        public void a() {
            if (UptodownApp.f17422D.a0()) {
                Updates updates = this.f18480a;
                String string = updates.getString(R.string.disabled_apps_explanation);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                updates.U1(string);
            }
        }
    }

    public static final class e extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18481a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Updates updates) {
            super(true);
            this.f18481a = updates;
        }

        public void handleOnBackPressed() {
            if (!this.f18481a.f18467m0.isEmpty()) {
                this.f18481a.f18467m0 = new ArrayList();
                this.f18481a.V5();
                return;
            }
            this.f18481a.finish();
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18482a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f18483b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Updates f18484a;

            /* renamed from: com.uptodown.activities.Updates$f$a$a  reason: collision with other inner class name */
            public static final class C0229a implements C2016g {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Updates f18485a;

                /* renamed from: com.uptodown.activities.Updates$f$a$a$a  reason: collision with other inner class name */
                static final class C0230a extends kotlin.coroutines.jvm.internal.l implements d3.p {

                    /* renamed from: a  reason: collision with root package name */
                    int f18486a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ Updates f18487b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ String f18488c;

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ long f18489d;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0230a(Updates updates, String str, long j4, V2.d dVar) {
                        super(2, dVar);
                        this.f18487b = updates;
                        this.f18488c = str;
                        this.f18489d = j4;
                    }

                    public final V2.d create(Object obj, V2.d dVar) {
                        return new C0230a(this.f18487b, this.f18488c, this.f18489d, dVar);
                    }

                    public final Object invokeSuspend(Object obj) {
                        ArrayList arrayList;
                        W2.b.c();
                        if (this.f18486a == 0) {
                            R2.n.b(obj);
                            int Z4 = this.f18487b.u5(this.f18488c);
                            if (Z4 >= 0 && this.f18487b.f18465Y != null) {
                                J U4 = this.f18487b.f18465Y;
                                kotlin.jvm.internal.m.b(U4);
                                if (U4.b().get(Z4) instanceof J.a) {
                                    J U42 = this.f18487b.f18465Y;
                                    if (U42 != null) {
                                        arrayList = U42.b();
                                    } else {
                                        arrayList = null;
                                    }
                                    kotlin.jvm.internal.m.b(arrayList);
                                    Object obj2 = arrayList.get(Z4);
                                    kotlin.jvm.internal.m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                                    ((J.a) obj2).a().b0(this.f18489d);
                                    J U43 = this.f18487b.f18465Y;
                                    if (U43 != null) {
                                        U43.notifyItemChanged(Z4);
                                    }
                                }
                            }
                            return s.f8222a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Object invoke(o3.J j4, V2.d dVar) {
                        return ((C0230a) create(j4, dVar)).invokeSuspend(s.f8222a);
                    }
                }

                C0229a(Updates updates) {
                    this.f18485a = updates;
                }

                public void a(String str, long j4) {
                    kotlin.jvm.internal.m.e(str, "packageName");
                    C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f18485a), Y.c(), (L) null, new C0230a(this.f18485a, str, j4, (V2.d) null), 2, (Object) null);
                }
            }

            a(Updates updates) {
                this.f18484a = updates;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18484a.t5().f9797b.setVisibility(0);
                    if (this.f18484a.t5().f9803h.isRefreshing()) {
                        this.f18484a.t5().f9803h.setRefreshing(false);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    this.f18484a.f18464X = ((P.b) cVar.a()).d();
                    this.f18484a.K5(((P.b) cVar.a()).d(), ((P.b) cVar.a()).c(), ((P.b) cVar.a()).b(), ((P.b) cVar.a()).a());
                    this.f18484a.V5();
                    this.f18484a.t5().f9797b.setVisibility(8);
                    if (!((Boolean) this.f18484a.v5().f().getValue()).booleanValue()) {
                        new C1629a(new C0229a(this.f18484a), LifecycleOwnerKt.getLifecycleScope(this.f18484a), this.f18484a);
                        this.f18484a.v5().f().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                    }
                } else if (!(e5 instanceof E.b)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Updates updates, V2.d dVar) {
            super(2, dVar);
            this.f18483b = updates;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18483b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18482a;
            if (i4 == 0) {
                R2.n.b(obj);
                I g4 = this.f18483b.v5().g();
                a aVar = new a(this.f18483b);
                this.f18482a = 1;
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

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18490a;

        g(Updates updates) {
            this.f18490a = updates;
        }

        public void onAnimationEnd(Animation animation) {
            this.f18490a.t5().f9802g.setPadding(0, 0, 0, (int) this.f18490a.getResources().getDimension(R.dimen.bottom_bar_height));
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18491a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f18492b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18493c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Updates updates, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f18492b = updates;
            this.f18493c = arrayList;
        }

        /* access modifiers changed from: private */
        public static final void m(Updates updates, View view) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.a0()) {
                updates.startActivity(new Intent(updates.getApplicationContext(), PreferencesActivity.class), aVar.a(updates));
                AlertDialog j22 = updates.j2();
                if (j22 != null) {
                    j22.dismiss();
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void n(Updates updates, View view) {
            AlertDialog j22 = updates.j2();
            if (j22 != null) {
                j22.dismiss();
            }
            updates.m5();
            updates.V5();
        }

        /* access modifiers changed from: private */
        public static final void o(ArrayList arrayList, Updates updates, View view) {
            String str;
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    str = ((C2048f) arrayList.get(0)).o();
                } else {
                    str = null;
                }
                if (!UptodownApp.f17422D.N(updates)) {
                    updates.E4(str, true);
                    updates.V5();
                }
            }
            AlertDialog j22 = updates.j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public static final void p(Updates updates, DialogInterface dialogInterface) {
            updates.V5();
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f18492b, this.f18493c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18491a == 0) {
                R2.n.b(obj);
                AlertDialog j22 = this.f18492b.j2();
                if (j22 != null) {
                    j22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f18492b);
                C1685q c5 = C1685q.c(this.f18492b.getLayoutInflater());
                kotlin.jvm.internal.m.d(c5, "inflate(...)");
                Updates updates = this.f18492b;
                ArrayList arrayList = this.f18493c;
                TextView textView = c5.f10709f;
                k.a aVar = N1.k.f7778g;
                textView.setTypeface(aVar.w());
                c5.f10706c.setTypeface(aVar.x());
                c5.f10708e.setTypeface(aVar.w());
                c5.f10705b.setTypeface(aVar.w());
                c5.f10707d.setTypeface(aVar.w());
                c5.f10708e.setOnClickListener(new L(updates));
                c5.f10705b.setOnClickListener(new M(updates));
                c5.f10707d.setOnClickListener(new N(arrayList, updates));
                builder.setView(c5.getRoot());
                this.f18492b.J2(builder.create());
                AlertDialog j23 = this.f18492b.j2();
                kotlin.jvm.internal.m.b(j23);
                j23.setOnDismissListener(new O(this.f18492b));
                if (!this.f18492b.isFinishing() && this.f18492b.j2() != null) {
                    this.f18492b.W2();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18494a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f18494a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18494a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18495a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.f18495a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18495a.getViewModelStore();
        }
    }

    public static final class k extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18497b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18496a = aVar;
            this.f18497b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18496a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18497b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.k.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18498a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f18499b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean f18500c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f18501d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Updates updates, Boolean bool, Integer num, V2.d dVar) {
            super(2, dVar);
            this.f18499b = updates;
            this.f18500c = bool;
            this.f18501d = num;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f18499b, this.f18500c, this.f18501d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            W2.b.c();
            if (this.f18498a == 0) {
                R2.n.b(obj);
                if (this.f18499b.t5().f9803h.isRefreshing()) {
                    this.f18499b.t5().f9803h.setRefreshing(false);
                }
                this.f18499b.D4(false);
                this.f18499b.J5(false);
                if (((Boolean) this.f18499b.v5().h().getValue()).booleanValue()) {
                    if (kotlin.jvm.internal.m.a(this.f18500c, kotlin.coroutines.jvm.internal.b.a(true))) {
                        Integer num2 = this.f18501d;
                        if (num2 != null && num2.intValue() == 1) {
                            Updates updates = this.f18499b;
                            String string = updates.getString(R.string.new_updates_available);
                            kotlin.jvm.internal.m.d(string, "getString(...)");
                            updates.q0(string);
                        } else {
                            Updates updates2 = this.f18499b;
                            String string2 = updates2.getString(R.string.new_updates_available);
                            kotlin.jvm.internal.m.d(string2, "getString(...)");
                            updates2.q0(string2);
                        }
                    } else {
                        Updates updates3 = this.f18499b;
                        String string3 = updates3.getString(R.string.no_new_updates_available);
                        kotlin.jvm.internal.m.d(string3, "getString(...)");
                        updates3.q0(string3);
                    }
                    this.f18499b.v5().h().setValue(kotlin.coroutines.jvm.internal.b.a(false));
                }
                J U4 = this.f18499b.f18465Y;
                if (U4 != null) {
                    J U42 = this.f18499b.f18465Y;
                    if (U42 != null) {
                        num = kotlin.coroutines.jvm.internal.b.b(U42.c());
                    } else {
                        num = null;
                    }
                    kotlin.jvm.internal.m.b(num);
                    U4.notifyItemChanged(num.intValue());
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18502a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f18503b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Updates updates, V2.d dVar) {
            super(2, dVar);
            this.f18503b = updates;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f18503b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            W2.b.c();
            if (this.f18502a == 0) {
                R2.n.b(obj);
                J U4 = this.f18503b.f18465Y;
                if (U4 != null) {
                    J U42 = this.f18503b.f18465Y;
                    if (U42 != null) {
                        num = kotlin.coroutines.jvm.internal.b.b(U42.c());
                    } else {
                        num = null;
                    }
                    kotlin.jvm.internal.m.b(num);
                    U4.notifyItemChanged(num.intValue());
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class n implements C2008G {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18504a;

        n(Updates updates) {
            this.f18504a = updates;
        }

        public void a(int i4) {
            Object obj;
            ArrayList b5;
            if (UptodownApp.f17422D.a0()) {
                J U4 = this.f18504a.f18465Y;
                if (U4 == null || (b5 = U4.b()) == null) {
                    obj = null;
                } else {
                    obj = b5.get(i4);
                }
                if (obj instanceof J.a) {
                    J U42 = this.f18504a.f18465Y;
                    kotlin.jvm.internal.m.b(U42);
                    Object obj2 = U42.b().get(i4);
                    kotlin.jvm.internal.m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                    this.f18504a.T3(((J.a) obj2).a(), i4);
                }
            }
        }

        public void b(int i4) {
            if (this.f18504a.H5(i4)) {
                J U4 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U4);
                Object obj = U4.b().get(i4);
                kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((J.a) obj).a().a0(true);
                J U42 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U42);
                U42.notifyItemChanged(i4);
            }
        }

        public void c(int i4) {
            if (UptodownApp.f17422D.a0() && this.f18504a.H5(i4)) {
                J U4 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U4);
                Object obj = U4.b().get(i4);
                kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f18504a.v4(((J.a) obj).a());
                this.f18504a.V5();
                J U42 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U42);
                U42.notifyItemChanged(i4);
            }
        }

        public void d(int i4) {
            if (UptodownApp.f17422D.a0()) {
                this.f18504a.l5(i4);
            }
        }

        public void e(int i4) {
            if (this.f18504a.H5(i4)) {
                J U4 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U4);
                Object obj = U4.b().get(i4);
                kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((J.a) obj).a().a0(false);
                J U42 = this.f18504a.f18465Y;
                kotlin.jvm.internal.m.b(U42);
                U42.notifyItemChanged(i4);
            }
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f18506b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18507c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Updates f18508d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(Bundle bundle, int i4, Updates updates, V2.d dVar) {
            super(2, dVar);
            this.f18506b = bundle;
            this.f18507c = i4;
            this.f18508d = updates;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new o(this.f18506b, this.f18507c, this.f18508d, dVar);
        }

        /* JADX WARNING: type inference failed for: r0v50, types: [g2.f] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                W2.b.c()
                int r0 = r6.f18505a
                if (r0 != 0) goto L_0x01ac
                R2.n.b(r7)
                android.os.Bundle r7 = r6.f18506b
                r0 = 0
                if (r7 == 0) goto L_0x0016
                java.lang.String r1 = "packagename"
                java.lang.String r7 = r7.getString(r1)
                goto L_0x0017
            L_0x0016:
                r7 = r0
            L_0x0017:
                int r1 = r6.f18507c
                r2 = 110(0x6e, float:1.54E-43)
                if (r1 == r2) goto L_0x0172
                r2 = 201(0xc9, float:2.82E-43)
                if (r1 == r2) goto L_0x015f
                java.lang.String r2 = "getString(...)"
                r3 = 0
                switch(r1) {
                    case 102: goto L_0x012b;
                    case 103: goto L_0x010b;
                    case 104: goto L_0x00f3;
                    case 105: goto L_0x00d1;
                    case 106: goto L_0x00ca;
                    case 107: goto L_0x00b6;
                    case 108: goto L_0x002b;
                    default: goto L_0x0027;
                }
            L_0x0027:
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x002b:
                com.uptodown.activities.Updates r1 = r6.f18508d
                java.util.ArrayList r1 = r1.f18467m0
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x00ad
                com.uptodown.activities.Updates r1 = r6.f18508d
                java.util.ArrayList r1 = r1.f18464X
                if (r1 == 0) goto L_0x00ad
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0046
                goto L_0x00ad
            L_0x0046:
                com.uptodown.activities.Updates r1 = r6.f18508d
                java.util.ArrayList r1 = r1.f18464X
                kotlin.jvm.internal.m.b(r1)
                java.util.Iterator r1 = r1.iterator()
                java.lang.String r2 = "iterator(...)"
                kotlin.jvm.internal.m.d(r1, r2)
            L_0x0058:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00a2
                java.lang.Object r2 = r1.next()
                java.lang.String r4 = "next(...)"
                kotlin.jvm.internal.m.d(r2, r4)
                M1.J$a r2 = (M1.J.a) r2
                g2.f r4 = r2.a()
                java.lang.String r4 = r4.o()
                r5 = 2
                boolean r4 = m3.m.q(r4, r7, r3, r5, r0)
                if (r4 == 0) goto L_0x0058
                u2.t$a r1 = u2.t.f21927u
                com.uptodown.activities.Updates r3 = r6.f18508d
                u2.t r1 = r1.a(r3)
                r1.a()
                g2.f r3 = r2.a()
                java.lang.String r3 = r3.o()
                kotlin.jvm.internal.m.b(r3)
                g2.s r3 = r1.h0(r3)
                r1.i()
                if (r3 == 0) goto L_0x00a2
                boolean r1 = r3.f()
                r3 = 1
                if (r1 != r3) goto L_0x00a2
                g2.f r0 = r2.a()
            L_0x00a2:
                if (r0 == 0) goto L_0x00ad
                com.uptodown.activities.Updates r1 = r6.f18508d
                java.util.ArrayList r1 = r1.f18467m0
                r1.add(r0)
            L_0x00ad:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.p5()
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x00b6:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.R5(r7)
                com.uptodown.activities.Updates r0 = r6.f18508d
                M1.J r0 = r0.f18465Y
                if (r0 == 0) goto L_0x017e
                r0.notifyDataSetChanged()
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x00ca:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.p5()
                goto L_0x0027
            L_0x00d1:
                android.os.Bundle r1 = r6.f18506b
                if (r1 == 0) goto L_0x00e8
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 33
                java.lang.String r3 = "apps_parcelable"
                if (r0 < r2) goto L_0x00e4
                java.lang.Class<g2.f> r0 = g2.C2048f.class
                java.util.ArrayList r0 = r1.getParcelableArrayList(r3, r0)
                goto L_0x00e8
            L_0x00e4:
                java.util.ArrayList r0 = r1.getParcelableArrayList(r3)
            L_0x00e8:
                if (r0 == 0) goto L_0x00ef
                com.uptodown.activities.Updates r1 = r6.f18508d
                r1.M5(r0)
            L_0x00ef:
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x00f3:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r1 = 2131952398(0x7f13030e, float:1.9541238E38)
                java.lang.String r1 = r0.getString(r1)
                kotlin.jvm.internal.m.d(r1, r2)
                r0.q0(r1)
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.V5()
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x010b:
                com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
                java.util.ArrayList r1 = r0.D()
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0128
                java.util.ArrayList r0 = r0.E()
                if (r0 == 0) goto L_0x0123
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0128
            L_0x0123:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.J5(r3)
            L_0x0128:
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x012b:
                com.uptodown.activities.Updates r0 = r6.f18508d
                boolean r0 = r0.r2()
                if (r0 != 0) goto L_0x0142
                com.uptodown.activities.Updates r0 = r6.f18508d
                r1 = 2131951955(0x7f130153, float:1.954034E38)
                java.lang.String r1 = r0.getString(r1)
                kotlin.jvm.internal.m.d(r1, r2)
                r0.U1(r1)
            L_0x0142:
                com.uptodown.activities.Updates r0 = r6.f18508d
                java.util.ArrayList r0 = r0.f18467m0
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x015c
                com.uptodown.activities.Updates r0 = r6.f18508d
                java.util.ArrayList r0 = r0.f18467m0
                r0.remove(r3)
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.p5()
            L_0x015c:
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x015f:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.R5(r7)
                com.uptodown.activities.Updates r0 = r6.f18508d
                M1.J r0 = r0.f18465Y
                if (r0 == 0) goto L_0x017e
                r0.d(r7)
                R2.s r0 = R2.s.f8222a
                goto L_0x017e
            L_0x0172:
                com.uptodown.activities.Updates r0 = r6.f18508d
                r0.V5()
                com.uptodown.activities.a$b r0 = new com.uptodown.activities.a$b
                com.uptodown.activities.Updates r1 = r6.f18508d
                r0.<init>()
            L_0x017e:
                com.uptodown.activities.Updates r0 = r6.f18508d
                boolean r0 = r0.s4()
                if (r0 == 0) goto L_0x018d
                com.uptodown.activities.Updates r0 = r6.f18508d
                int r1 = r6.f18507c
                r0.F4(r1)
            L_0x018d:
                com.uptodown.activities.Updates r0 = r6.f18508d
                M1.J r0 = r0.f18465Y
                if (r0 == 0) goto L_0x01a9
                com.uptodown.activities.Updates r0 = r6.f18508d
                int r7 = r0.s5(r7)
                r0 = -1
                if (r7 <= r0) goto L_0x01a9
                com.uptodown.activities.Updates r0 = r6.f18508d
                M1.J r0 = r0.f18465Y
                if (r0 == 0) goto L_0x01a9
                r0.notifyItemChanged(r7)
            L_0x01a9:
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x01ac:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((o) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18509a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f18510b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18511c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f18512d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(Updates updates, String str, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18510b = updates;
            this.f18511c = str;
            this.f18512d = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new p(this.f18510b, this.f18511c, this.f18512d, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                r0 = 1
                r1 = 0
                W2.b.c()
                int r2 = r7.f18509a
                if (r2 != 0) goto L_0x0104
                R2.n.b(r8)
                com.uptodown.activities.Updates r8 = r7.f18510b
                M1.J r8 = r8.f18465Y
                if (r8 == 0) goto L_0x0101
                com.uptodown.activities.Updates r8 = r7.f18510b
                java.lang.String r2 = r7.f18511c
                int r8 = r8.s5(r2)
                r2 = -1
                if (r8 <= r2) goto L_0x0021
                r2 = 1
                goto L_0x0022
            L_0x0021:
                r2 = 0
            L_0x0022:
                int r3 = r7.f18512d
                r4 = 306(0x132, float:4.29E-43)
                if (r3 != r4) goto L_0x0048
                if (r2 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f18510b
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r8)
                com.uptodown.activities.Updates r0 = r7.f18510b
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemRemoved(r8)
                goto L_0x0101
            L_0x0048:
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 != r4) goto L_0x005c
                if (r2 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f18510b
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r8)
                goto L_0x0101
            L_0x005c:
                r4 = 305(0x131, float:4.27E-43)
                if (r3 == r4) goto L_0x0101
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 != r4) goto L_0x007b
                if (r2 == 0) goto L_0x0074
                com.uptodown.activities.Updates r0 = r7.f18510b
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r8)
                goto L_0x0101
            L_0x0074:
                com.uptodown.activities.Updates r8 = r7.f18510b
                r8.J5(r1)
                goto L_0x0101
            L_0x007b:
                if (r2 == 0) goto L_0x00b3
                com.uptodown.activities.Updates r3 = r7.f18510b
                M1.J r3 = r3.f18465Y
                kotlin.jvm.internal.m.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r8)
                boolean r3 = r3 instanceof M1.J.a
                if (r3 == 0) goto L_0x00b3
                com.uptodown.activities.Updates r3 = r7.f18510b
                M1.J r3 = r3.f18465Y
                kotlin.jvm.internal.m.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r8)
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.m.c(r3, r4)
                M1.J$a r3 = (M1.J.a) r3
                g2.f r3 = r3.a()
                java.lang.String r3 = r3.m()
                goto L_0x00b4
            L_0x00b3:
                r3 = 0
            L_0x00b4:
                int r4 = r7.f18512d
                r5 = 303(0x12f, float:4.25E-43)
                r6 = 2131952077(0x7f1301cd, float:1.9540587E38)
                if (r4 == r5) goto L_0x00e4
                r5 = 304(0x130, float:4.26E-43)
                if (r4 == r5) goto L_0x00da
                r5 = 307(0x133, float:4.3E-43)
                if (r4 == r5) goto L_0x00d0
                com.uptodown.activities.Updates r4 = r7.f18510b
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r3
                java.lang.String r0 = r4.getString(r6, r0)
                goto L_0x00ee
            L_0x00d0:
                com.uptodown.activities.Updates r0 = r7.f18510b
                r1 = 2131952002(0x7f130182, float:1.9540434E38)
                java.lang.String r0 = r0.getString(r1)
                goto L_0x00ee
            L_0x00da:
                com.uptodown.activities.Updates r0 = r7.f18510b
                r1 = 2131952305(0x7f1302b1, float:1.954105E38)
                java.lang.String r0 = r0.getString(r1)
                goto L_0x00ee
            L_0x00e4:
                com.uptodown.activities.Updates r4 = r7.f18510b
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r3
                java.lang.String r0 = r4.getString(r6, r0)
            L_0x00ee:
                com.uptodown.activities.Updates r1 = r7.f18510b
                r1.U1(r0)
                if (r2 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f18510b
                M1.J r0 = r0.f18465Y
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r8)
            L_0x0101:
                R2.s r8 = R2.s.f8222a
                return r8
            L_0x0104:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((p) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class q implements C2009H {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f18513a;

        q(Updates updates) {
            this.f18513a = updates;
        }

        public void a() {
            if (UptodownApp.f17422D.a0()) {
                this.f18513a.I5();
            }
        }

        public void b() {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.a0() && UptodownApp.a.P0(aVar, this.f18513a, false, 2, (Object) null)) {
                this.f18513a.v5().h().setValue(Boolean.TRUE);
            }
        }
    }

    public Updates() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1352f5(this));
        kotlin.jvm.internal.m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18472r0 = registerForActivityResult;
        this.f18473s0 = new e(this);
    }

    /* access modifiers changed from: private */
    public static final void A5(View view) {
    }

    /* access modifiers changed from: private */
    public static final void B5(Updates updates, View view) {
        if (UptodownApp.f17422D.a0()) {
            updates.N5();
        }
    }

    /* access modifiers changed from: private */
    public static final void C5(Updates updates, View view) {
        if (UptodownApp.f17422D.a0()) {
            updates.m5();
            updates.V5();
        }
    }

    /* access modifiers changed from: private */
    public static final void D5(Updates updates) {
        if (UptodownApp.a.P0(UptodownApp.f17422D, updates, false, 2, (Object) null)) {
            updates.v5().h().setValue(Boolean.TRUE);
        } else {
            updates.t5().f9803h.setRefreshing(false);
        }
    }

    private final void E5() {
        C2060s sVar;
        if (N1.k.f7778g.i() == null) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.C() == null) {
                if (!this.f18467m0.isEmpty()) {
                    Object remove = this.f18467m0.remove(0);
                    kotlin.jvm.internal.m.d(remove, "removeAt(...)");
                    C2048f fVar = (C2048f) remove;
                    t.a aVar2 = t.f21927u;
                    Context applicationContext = getApplicationContext();
                    kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
                    t a5 = aVar2.a(applicationContext);
                    a5.a();
                    String o4 = fVar.o();
                    kotlin.jvm.internal.m.b(o4);
                    S D02 = a5.D0(o4);
                    if (D02 != null) {
                        sVar = D02.b(this);
                    } else {
                        sVar = null;
                    }
                    a5.i();
                    T5(fVar.m());
                    if (sVar != null) {
                        boolean z4 = true;
                        if (sVar.f()) {
                            aVar.K0(fVar);
                            r rVar = new r();
                            ArrayList i4 = D02.i();
                            if (i4 != null && !i4.isEmpty()) {
                                ArrayList i5 = D02.i();
                                kotlin.jvm.internal.m.b(i5);
                                z4 = rVar.f(i5, this);
                            }
                            File n4 = sVar.n();
                            if (n4 != null) {
                                if (z4) {
                                    x2(n4, (String) null);
                                    return;
                                } else {
                                    J3(n4, D02);
                                    return;
                                }
                            }
                        }
                    }
                    p5();
                    return;
                }
                V5();
                return;
            }
        }
        V5();
    }

    /* access modifiers changed from: private */
    public final boolean H5(int i4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        J j4 = this.f18465Y;
        if (j4 == null || i4 < 0) {
            return false;
        }
        kotlin.jvm.internal.m.b(j4);
        if (i4 >= j4.getItemCount()) {
            return false;
        }
        J j5 = this.f18465Y;
        ArrayList arrayList3 = null;
        if (j5 != null) {
            arrayList = j5.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        J j6 = this.f18465Y;
        if (j6 != null) {
            arrayList2 = j6.b();
        } else {
            arrayList2 = null;
        }
        kotlin.jvm.internal.m.b(arrayList2);
        if (arrayList2.size() <= i4) {
            return false;
        }
        J j7 = this.f18465Y;
        if (j7 != null) {
            arrayList3 = j7.b();
        }
        kotlin.jvm.internal.m.b(arrayList3);
        if (arrayList3.get(i4) instanceof J.a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void I5() {
        this.f18472r0.launch(new Intent(getApplicationContext(), GdprPrivacySettings.class), UptodownApp.f17422D.b(this));
    }

    /* access modifiers changed from: private */
    public final void J5(boolean z4) {
        v5().e(this, z4);
    }

    /* access modifiers changed from: private */
    public final void K5(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        if (this.f18465Y == null) {
            this.f18465Y = new J(this.f18468n0, this.f18469o0, this.f18470p0, this.f18471q0);
            t5().f9802g.setAdapter(this.f18465Y);
        }
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.k(arrayList, arrayList2, arrayList3, arrayList4, this);
        }
    }

    private final void L5() {
        if (this.f18467m0.size() > 0) {
            t5().f9807l.setVisibility(8);
            t5().f9801f.setVisibility(0);
        } else {
            t5().f9807l.setVisibility(0);
            t5().f9801f.setVisibility(8);
        }
        RelativeLayout relativeLayout = t5().f9799d;
        kotlin.jvm.internal.m.d(relativeLayout, "rlBottomBoxDownloadButtonUpdates");
        if (relativeLayout.getVisibility() == 8) {
            y2.n nVar = new y2.n(this);
            RelativeLayout relativeLayout2 = t5().f9799d;
            kotlin.jvm.internal.m.d(relativeLayout2, "rlBottomBoxDownloadButtonUpdates");
            nVar.g(relativeLayout2, R.anim.slide_in_bottom, new g(this));
            y2.n nVar2 = new y2.n(this);
            RelativeLayout relativeLayout3 = t5().f9800e;
            kotlin.jvm.internal.m.d(relativeLayout3, "rlBottomBoxShadow");
            nVar2.h(relativeLayout3, R.anim.slide_in_bottom);
            t5().f9799d.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void M5(ArrayList arrayList) {
        if (q4()) {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new h(this, arrayList, (V2.d) null), 2, (Object) null);
        }
    }

    private final void N5() {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.U("downloadApkWorker", this) || aVar.U("GenerateQueueWorker", this) || aVar.U("DownloadUpdatesWorker", this)) {
            J j4 = this.f18465Y;
            if (j4 != null) {
                j4.m(false);
                return;
            }
            return;
        }
        this.f18467m0 = new ArrayList();
        ArrayList arrayList = this.f18464X;
        kotlin.jvm.internal.m.b(arrayList);
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            this.f18467m0.add(((J.a) next).a());
        }
        Iterator it2 = this.f18467m0.iterator();
        kotlin.jvm.internal.m.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            kotlin.jvm.internal.m.d(next2, "next(...)");
            n4((C2048f) next2);
        }
        J j5 = this.f18465Y;
        if (j5 != null) {
            j5.e();
        }
        V5();
        p5();
    }

    /* access modifiers changed from: private */
    public final void R5(String str) {
        S D02;
        if (this.f18467m0.size() > 0) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.E() != null) {
                ArrayList E4 = aVar.E();
                kotlin.jvm.internal.m.b(E4);
                if (E4.size() > 0) {
                    Object obj = this.f18467m0.get(0);
                    kotlin.jvm.internal.m.d(obj, "get(...)");
                    C2048f fVar = (C2048f) obj;
                    t a5 = t.f21927u.a(this);
                    a5.a();
                    C2060s sVar = null;
                    if (!(str == null || (D02 = a5.D0(str)) == null)) {
                        sVar = D02.b(this);
                    }
                    a5.i();
                    t5().f9801f.setOnClickListener(new C1345e5());
                    t5().f9808m.setText(fVar.m());
                    t5().f9806k.setText(getString(R.string.dialog_update_all_desc, new Object[]{String.valueOf(this.f18467m0.size())}));
                    if (sVar != null) {
                        t5().f9798c.setIndeterminate(false);
                        t5().f9798c.setProgress(sVar.x());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void S5(View view) {
    }

    private final void T5(String str) {
        if (this.f18467m0.size() > 0) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.E() != null) {
                ArrayList E4 = aVar.E();
                kotlin.jvm.internal.m.b(E4);
                if (E4.size() > 0) {
                    t5().f9808m.setText(str);
                    t5().f9806k.setText(getString(R.string.dialog_update_all_desc, new Object[]{String.valueOf(this.f18467m0.size())}));
                    t5().f9798c.setIndeterminate(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void V5() {
        ArrayList arrayList = this.f18464X;
        if (arrayList != null) {
            kotlin.jvm.internal.m.b(arrayList);
            if (arrayList.size() > 1) {
                L5();
                return;
            }
        }
        w5();
    }

    /* access modifiers changed from: private */
    public static final J0 k5(Updates updates) {
        return J0.c(updates.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void l5(int i4) {
        if (H5(i4)) {
            J j4 = this.f18465Y;
            kotlin.jvm.internal.m.b(j4);
            Object obj = j4.b().get(i4);
            kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            J.a aVar = (J.a) obj;
            Iterator it = this.f18467m0.iterator();
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i5 = -1;
                    break;
                }
                int i6 = i5 + 1;
                if (m3.m.q(((C2048f) it.next()).o(), aVar.a().o(), false, 2, (Object) null)) {
                    break;
                }
                i5 = i6;
            }
            if (i5 >= 0) {
                this.f18467m0.remove(i5);
            }
            u4(aVar.a());
        }
    }

    /* access modifiers changed from: private */
    public final void m5() {
        ArrayList b5;
        new ArrayList().addAll(this.f18467m0);
        this.f18467m0 = new ArrayList();
        Integer num = null;
        UptodownApp.f17422D.K0((C2048f) null);
        w5();
        J j4 = this.f18465Y;
        if (!(j4 == null || (b5 = j4.b()) == null)) {
            num = Integer.valueOf(b5.size());
        }
        if (num != null && num.intValue() > 0) {
            int intValue = num.intValue();
            for (int i4 = 0; i4 < intValue; i4++) {
                l5(i4);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final s n5(Updates updates) {
        UptodownApp.f17422D.K0((C2048f) null);
        updates.p5();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s o5(Updates updates, File file) {
        updates.x2(file, (String) null);
        AlertDialog j22 = updates.j2();
        if (j22 != null) {
            j22.dismiss();
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void p5() {
        C2060s sVar;
        if (!this.f18467m0.isEmpty() && N1.k.f7778g.i() == null) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.C() == null && !aVar.U("GenerateQueueWorker", this) && !aVar.U("downloadApkWorker", this)) {
                Object obj = this.f18467m0.get(0);
                kotlin.jvm.internal.m.d(obj, "get(...)");
                C2048f fVar = (C2048f) obj;
                t a5 = t.f21927u.a(this);
                a5.a();
                String o4 = fVar.o();
                kotlin.jvm.internal.m.b(o4);
                S D02 = a5.D0(o4);
                if (D02 != null) {
                    sVar = D02.b(this);
                } else {
                    sVar = null;
                }
                a5.i();
                T5(fVar.m());
                if (sVar == null || !sVar.f()) {
                    E4(fVar.o(), false);
                    return;
                } else {
                    E5();
                    return;
                }
            }
        }
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.m(false);
        }
        V5();
    }

    /* access modifiers changed from: private */
    public static final void r5(Updates updates, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            updates.K2();
            updates.J5(false);
        }
    }

    /* access modifiers changed from: private */
    public final int s5(String str) {
        if (str == null) {
            return -1;
        }
        J j4 = this.f18465Y;
        kotlin.jvm.internal.m.b(j4);
        ArrayList<Object> b5 = j4.b();
        int i4 = 0;
        for (Object obj : b5) {
            int i5 = i4 + 1;
            if (obj instanceof J.a) {
                Object obj2 = b5.get(i4);
                kotlin.jvm.internal.m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                if (m3.m.p(((J.a) obj2).a().o(), str, true)) {
                    return i4;
                }
            }
            i4 = i5;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final J0 t5() {
        return (J0) this.f18462V.getValue();
    }

    /* access modifiers changed from: private */
    public final int u5(String str) {
        ArrayList arrayList;
        J j4 = this.f18465Y;
        ArrayList arrayList2 = null;
        if (j4 != null) {
            arrayList = j4.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        J j5 = this.f18465Y;
        if (j5 != null) {
            arrayList2 = j5.b();
        }
        kotlin.jvm.internal.m.b(arrayList2);
        int i4 = 0;
        for (Object next : arrayList2) {
            int i5 = i4 + 1;
            if ((next instanceof J.a) && m3.m.p(((J.a) next).a().o(), str, true)) {
                return i4;
            }
            i4 = i5;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final P v5() {
        return (P) this.f18463W.getValue();
    }

    private final void w5() {
        t5().f9807l.setVisibility(0);
        t5().f9801f.setVisibility(8);
        RelativeLayout relativeLayout = t5().f9799d;
        kotlin.jvm.internal.m.d(relativeLayout, "rlBottomBoxDownloadButtonUpdates");
        if (relativeLayout.getVisibility() == 0) {
            y2.n nVar = new y2.n(this);
            RelativeLayout relativeLayout2 = t5().f9799d;
            kotlin.jvm.internal.m.d(relativeLayout2, "rlBottomBoxDownloadButtonUpdates");
            nVar.g(relativeLayout2, R.anim.slide_out_bottom, new c(this));
            y2.n nVar2 = new y2.n(this);
            RelativeLayout relativeLayout3 = t5().f9800e;
            kotlin.jvm.internal.m.d(relativeLayout3, "rlBottomBoxShadow");
            nVar2.i(relativeLayout3, R.anim.slide_out_bottom);
            t5().f9799d.setVisibility(8);
        }
    }

    private final void x5() {
        setContentView((View) t5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            t5().f9804i.setNavigationIcon(drawable);
            t5().f9804i.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t5().f9804i.setNavigationOnClickListener(new C1373i5(this));
        TextView textView = t5().f9809n;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        t5().f9804i.inflateMenu(R.menu.toolbar_menu_updates);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable);
        if (drawable2 != null) {
            t5().f9804i.setOverflowIcon(drawable2);
        }
        a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
        boolean f02 = aVar2.f0(this);
        t5().f9804i.getMenu().findItem(R.id.action_show_system_apps).setChecked(f02);
        t5().f9804i.getMenu().findItem(R.id.action_show_system_services).setChecked(aVar2.g0(this));
        Toolbar toolbar = t5().f9804i;
        kotlin.jvm.internal.m.d(toolbar, "toolbarUpdates");
        m4(R.id.action_show_system_services, f02, toolbar);
        t5().f9804i.setOnMenuItemClickListener(new C1380j5(this));
        t5().f9802g.setLayoutManager(new LinearLayoutManager(this, 1, false));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        t5().f9802g.addItemDecoration(new w2.l(dimension, dimension));
        t5().f9802g.setItemAnimator(defaultItemAnimator);
        t5().f9797b.setOnClickListener(new C1387k5());
        t5().f9807l.setTypeface(aVar.w());
        t5().f9807l.setOnClickListener(new C1394l5(this));
        t5().f9808m.setTypeface(aVar.w());
        t5().f9806k.setTypeface(aVar.x());
        t5().f9805j.setTypeface(aVar.w());
        t5().f9805j.setOnClickListener(new C1401m5(this));
        t5().f9803h.setColorSchemeColors(ContextCompat.getColor(this, R.color.main_blue), ContextCompat.getColor(this, R.color.main_blue_pressed));
        t5().f9803h.setOnRefreshListener(new C1408n5(this));
    }

    /* access modifiers changed from: private */
    public static final void y5(Updates updates, View view) {
        updates.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean z5(Updates updates, MenuItem menuItem) {
        kotlin.jvm.internal.m.e(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_show_system_apps) {
            boolean isChecked = menuItem.isChecked();
            menuItem.setChecked(!isChecked);
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context applicationContext = updates.getApplicationContext();
            kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
            aVar.d1(applicationContext, !isChecked);
            if (isChecked) {
                Context applicationContext2 = updates.getApplicationContext();
                kotlin.jvm.internal.m.d(applicationContext2, "getApplicationContext(...)");
                aVar.e1(applicationContext2, false);
                Toolbar toolbar = updates.t5().f9804i;
                kotlin.jvm.internal.m.d(toolbar, "toolbarUpdates");
                updates.m4(R.id.action_show_system_services, false, toolbar);
                Toolbar toolbar2 = updates.t5().f9804i;
                kotlin.jvm.internal.m.d(toolbar2, "toolbarUpdates");
                updates.F3(R.id.action_show_system_services, false, toolbar2);
                updates.J5(true);
            } else {
                Toolbar toolbar3 = updates.t5().f9804i;
                kotlin.jvm.internal.m.d(toolbar3, "toolbarUpdates");
                updates.m4(R.id.action_show_system_services, true, toolbar3);
                if (UptodownApp.a.P0(UptodownApp.f17422D, updates, false, 2, (Object) null)) {
                    updates.v5().h().setValue(Boolean.TRUE);
                }
            }
        } else if (menuItem.getItemId() == R.id.action_show_system_services) {
            boolean isChecked2 = menuItem.isChecked();
            menuItem.setChecked(!isChecked2);
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            Context applicationContext3 = updates.getApplicationContext();
            kotlin.jvm.internal.m.d(applicationContext3, "getApplicationContext(...)");
            aVar2.e1(applicationContext3, !isChecked2);
            if (isChecked2) {
                updates.J5(true);
            } else if (UptodownApp.a.P0(UptodownApp.f17422D, updates, false, 2, (Object) null)) {
                updates.v5().h().setValue(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void A4() {
        J5(false);
    }

    public final void F5() {
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.i();
        }
        UptodownApp.f17422D.K0((C2048f) null);
        p5();
    }

    public final void G5(String str) {
        String str2;
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.i();
        }
        J j5 = this.f18465Y;
        if (j5 != null) {
            j5.g(this, str);
        }
        String str3 = null;
        UptodownApp.f17422D.K0((C2048f) null);
        p5();
        C2048f A4 = new u2.m().A(this, str);
        if (A4 != null) {
            str2 = A4.m();
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            if (A4 != null) {
                str3 = A4.m();
            }
            String string = getString(R.string.install_compatibility_error, new Object[]{str3});
            kotlin.jvm.internal.m.d(string, "getString(...)");
            q0(string);
        }
    }

    public void H2() {
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.i();
        }
    }

    public void J3(File file, S s4) {
        kotlin.jvm.internal.m.e(file, "file");
        kotlin.jvm.internal.m.e(s4, "update");
        Bundle bundle = new Bundle();
        bundle.putString("type", "required_feature");
        bundle.putString("packagename", s4.h());
        x m22 = m2();
        if (m22 != null) {
            m22.d("warning", bundle);
        }
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        P1(string, new C1359g5(this, file), new C1366h5(this));
    }

    public final void O5(Boolean bool, Integer num) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new l(this, bool, num, (V2.d) null), 2, (Object) null);
    }

    public void P2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.l(file, this);
        }
    }

    public final void P5() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new m(this, (V2.d) null), 2, (Object) null);
    }

    public final void Q5(int i4, Bundle bundle) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new o(bundle, i4, this, (V2.d) null), 2, (Object) null);
    }

    public void R2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.i();
        }
        J j5 = this.f18465Y;
        if (j5 != null) {
            j5.f(file, this);
        }
    }

    public void S2(File file, int i4) {
        kotlin.jvm.internal.m.e(file, "file");
        J j4 = this.f18465Y;
        if (j4 != null) {
            j4.f(file, this);
        }
    }

    public final void U5(int i4, String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new p(this, str, i4, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x5();
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
        this.f18466Z = aVar.W(applicationContext);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, (V2.d) null), 2, (Object) null);
        getOnBackPressedDispatcher().addCallback(this, this.f18473s0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (DownloadWorker.f19459d.h()) {
            WorkManager.getInstance(this).cancelAllWorkByTag("DownloadUpdatesWorker");
            UptodownApp.f17422D.g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        J5(true);
        C2313C.f21882a.h(this);
        p5();
    }

    public final Object q5(String str, String str2, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new b(str, this, str2, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public void w4(int i4, int i5) {
        J5(false);
    }

    public void x4(int i4, int i5) {
        J5(false);
    }
}
