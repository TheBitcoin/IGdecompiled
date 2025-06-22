package com.uptodown.activities;

import J1.C1446t2;
import J1.M1;
import J1.N1;
import J1.O1;
import J1.P1;
import J1.Q1;
import J1.R1;
import J1.S1;
import J1.T1;
import J1.U1;
import M1.C1536m;
import M1.J;
import N1.k;
import R2.n;
import R2.s;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import b2.C1629a;
import c2.C1685q;
import c2.S;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.activities.r;
import com.uptodown.workers.GenerateQueueWorker;
import d3.p;
import f2.C2008G;
import f2.C2011b;
import f2.C2016g;
import f2.C2029u;
import g2.C2048f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import y2.q;

public final class MyApps extends C1446t2 {

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f17933V = R2.h.a(new M1(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f17934W = new ViewModelLazy(D.b(r.class), new h(this), new g(this), new i((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public C1536m f17935X;

    /* renamed from: Y  reason: collision with root package name */
    private final a f17936Y = new a(this);

    /* renamed from: Z  reason: collision with root package name */
    private final j f17937Z = new j(this);

    /* renamed from: m0  reason: collision with root package name */
    private final c f17938m0 = new c(this);

    public static final class a implements C2011b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f17939a;

        a(MyApps myApps) {
            this.f17939a = myApps;
        }

        public void a(int i4) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (this.f17939a.n5(i4)) {
                C1536m Q4 = this.f17939a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                this.f17939a.T3((C2048f) obj, i4);
            } else if (this.f17939a.o5(i4)) {
                C1536m Q42 = this.f17939a.f17935X;
                m.b(Q42);
                Object obj2 = Q42.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f17939a.T3(((J.a) obj2).a(), i4);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17940a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f17941b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17942c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17943d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MyApps myApps, String str, String str2, V2.d dVar) {
            super(2, dVar);
            this.f17941b = myApps;
            this.f17942c = str;
            this.f17943d = str2;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17941b, this.f17942c, this.f17943d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
            if (r0.equals("app_updated") != false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (r0.equals("app_installed") == false) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                W2.b.c()
                int r0 = r3.f17940a
                if (r0 != 0) goto L_0x006d
                R2.n.b(r4)
                com.uptodown.activities.MyApps r4 = r3.f17941b
                java.lang.String r0 = r3.f17942c
                int r4 = r4.c5(r0)
                java.lang.String r0 = r3.f17943d
                int r1 = r0.hashCode()
                r2 = -1972881700(0xffffffff8a6836dc, float:-1.11807116E-32)
                if (r1 == r2) goto L_0x0059
                r2 = -1487908707(0xffffffffa750509d, float:-2.89095E-15)
                if (r1 == r2) goto L_0x0050
                r2 = 389690339(0x173a33e3, float:6.016533E-25)
                if (r1 == r2) goto L_0x0028
                goto L_0x006a
            L_0x0028:
                java.lang.String r1 = "app_uninstalled"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0031
                goto L_0x006a
            L_0x0031:
                if (r4 < 0) goto L_0x006a
                com.uptodown.activities.MyApps r0 = r3.f17941b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r4)
                com.uptodown.activities.MyApps r0 = r3.f17941b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemRemoved(r4)
                goto L_0x006a
            L_0x0050:
                java.lang.String r1 = "app_updated"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006a
                goto L_0x0062
            L_0x0059:
                java.lang.String r1 = "app_installed"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0062
                goto L_0x006a
            L_0x0062:
                if (r4 < 0) goto L_0x006a
                com.uptodown.activities.MyApps r4 = r3.f17941b
                r0 = 0
                r4.p5(r0)
            L_0x006a:
                R2.s r4 = R2.s.f8222a
                return r4
            L_0x006d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c implements C2029u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f17944a;

        c(MyApps myApps) {
            this.f17944a = myApps;
        }

        public void a() {
            if (UptodownApp.f17422D.a0()) {
                MyApps myApps = this.f17944a;
                String string = myApps.getString(R.string.disabled_apps_explanation);
                m.d(string, "getString(...)");
                myApps.U1(string);
            }
        }
    }

    public static final class d implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f17945a;

        d(MyApps myApps) {
            this.f17945a = myApps;
        }

        public boolean onQueryTextChange(String str) {
            m.e(str, "newText");
            this.f17945a.Y4(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f17945a.Y4(str);
            return true;
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17946a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f17947b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyApps f17948a;

            /* renamed from: com.uptodown.activities.MyApps$e$a$a  reason: collision with other inner class name */
            static final class C0219a extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f17949a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ MyApps f17950b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0219a(MyApps myApps, V2.d dVar) {
                    super(2, dVar);
                    this.f17950b = myApps;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0219a(this.f17950b, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f17949a == 0) {
                        n.b(obj);
                        this.f17950b.b5().f9990c.setVisibility(0);
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, V2.d dVar) {
                    return ((C0219a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            static final class b extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f17951a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ MyApps f17952b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ E f17953c;

                /* renamed from: com.uptodown.activities.MyApps$e$a$b$a  reason: collision with other inner class name */
                public static final class C0220a implements C2016g {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ MyApps f17954a;

                    /* renamed from: com.uptodown.activities.MyApps$e$a$b$a$a  reason: collision with other inner class name */
                    static final class C0221a extends kotlin.coroutines.jvm.internal.l implements p {

                        /* renamed from: a  reason: collision with root package name */
                        int f17955a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ MyApps f17956b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ String f17957c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ long f17958d;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0221a(MyApps myApps, String str, long j4, V2.d dVar) {
                            super(2, dVar);
                            this.f17956b = myApps;
                            this.f17957c = str;
                            this.f17958d = j4;
                        }

                        public final V2.d create(Object obj, V2.d dVar) {
                            return new C0221a(this.f17956b, this.f17957c, this.f17958d, dVar);
                        }

                        public final Object invokeSuspend(Object obj) {
                            ArrayList arrayList;
                            W2.b.c();
                            if (this.f17955a == 0) {
                                n.b(obj);
                                int S4 = this.f17956b.c5(this.f17957c);
                                if (S4 >= 0 && this.f17956b.f17935X != null) {
                                    C1536m Q4 = this.f17956b.f17935X;
                                    m.b(Q4);
                                    if (Q4.b().get(S4) instanceof C2048f) {
                                        C1536m Q42 = this.f17956b.f17935X;
                                        if (Q42 != null) {
                                            arrayList = Q42.b();
                                        } else {
                                            arrayList = null;
                                        }
                                        m.b(arrayList);
                                        Object obj2 = arrayList.get(S4);
                                        m.c(obj2, "null cannot be cast to non-null type com.uptodown.models.App");
                                        ((C2048f) obj2).b0(this.f17958d);
                                        C1536m Q43 = this.f17956b.f17935X;
                                        if (Q43 != null) {
                                            Q43.notifyItemChanged(this.f17956b.c5(this.f17957c));
                                        }
                                    }
                                }
                                return s.f8222a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object invoke(o3.J j4, V2.d dVar) {
                            return ((C0221a) create(j4, dVar)).invokeSuspend(s.f8222a);
                        }
                    }

                    C0220a(MyApps myApps) {
                        this.f17954a = myApps;
                    }

                    public void a(String str, long j4) {
                        m.e(str, "packageName");
                        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f17954a), Y.c(), (L) null, new C0221a(this.f17954a, str, j4, (V2.d) null), 2, (Object) null);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(MyApps myApps, E e5, V2.d dVar) {
                    super(2, dVar);
                    this.f17952b = myApps;
                    this.f17953c = e5;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new b(this.f17952b, this.f17953c, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f17951a == 0) {
                        n.b(obj);
                        this.f17952b.b5().f9990c.setVisibility(8);
                        this.f17952b.b5().f9989b.getRoot().setVisibility(0);
                        this.f17952b.q5(((r.a) ((E.c) this.f17953c).a()).d(), ((r.a) ((E.c) this.f17953c).a()).b(), ((r.a) ((E.c) this.f17953c).a()).a(), ((r.a) ((E.c) this.f17953c).a()).c());
                        if (!((Boolean) this.f17952b.d5().d().getValue()).booleanValue()) {
                            new C1629a(new C0220a(this.f17952b), LifecycleOwnerKt.getLifecycleScope(this.f17952b), this.f17952b);
                            this.f17952b.d5().d().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, V2.d dVar) {
                    return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            a(MyApps myApps) {
                this.f17948a = myApps;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    Object g4 = C0977g.g(Y.c(), new C0219a(this.f17948a, (V2.d) null), dVar);
                    if (g4 == W2.b.c()) {
                        return g4;
                    }
                    return s.f8222a;
                } else if (e5 instanceof E.c) {
                    Object g5 = C0977g.g(Y.c(), new b(this.f17948a, e5, (V2.d) null), dVar);
                    if (g5 == W2.b.c()) {
                        return g5;
                    }
                    return s.f8222a;
                } else if (e5 instanceof E.b) {
                    return s.f8222a;
                } else {
                    throw new R2.k();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MyApps myApps, V2.d dVar) {
            super(2, dVar);
            this.f17947b = myApps;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17947b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17946a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f17947b.d5().e();
                a aVar = new a(this.f17947b);
                this.f17946a = 1;
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

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17959a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f17960b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f17961c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MyApps myApps, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f17960b = myApps;
            this.f17961c = arrayList;
        }

        /* access modifiers changed from: private */
        public static final void l(MyApps myApps, View view) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.a0()) {
                myApps.startActivity(new Intent(myApps.getApplicationContext(), PreferencesActivity.class), aVar.a(myApps));
                AlertDialog j22 = myApps.j2();
                if (j22 != null) {
                    j22.dismiss();
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void m(MyApps myApps, View view) {
            AlertDialog j22 = myApps.j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public static final void n(ArrayList arrayList, MyApps myApps, View view) {
            if (arrayList != null && arrayList.size() > 0) {
                myApps.s5(arrayList);
            }
            AlertDialog j22 = myApps.j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17960b, this.f17961c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17959a == 0) {
                n.b(obj);
                AlertDialog j22 = this.f17960b.j2();
                if (j22 != null) {
                    j22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f17960b);
                C1685q c5 = C1685q.c(this.f17960b.getLayoutInflater());
                m.d(c5, "inflate(...)");
                MyApps myApps = this.f17960b;
                ArrayList arrayList = this.f17961c;
                TextView textView = c5.f10709f;
                k.a aVar = N1.k.f7778g;
                textView.setTypeface(aVar.w());
                c5.f10706c.setTypeface(aVar.x());
                c5.f10708e.setTypeface(aVar.w());
                c5.f10705b.setTypeface(aVar.w());
                c5.f10707d.setTypeface(aVar.w());
                c5.f10708e.setOnClickListener(new C1840o(myApps));
                c5.f10705b.setOnClickListener(new C1841p(myApps));
                c5.f10707d.setOnClickListener(new C1842q(arrayList, myApps));
                builder.setView(c5.getRoot());
                this.f17960b.J2(builder.create());
                if (!this.f17960b.isFinishing() && this.f17960b.j2() != null) {
                    this.f17960b.W2();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17962a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f17962a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f17962a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17963a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f17963a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f17963a.getViewModelStore();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f17964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17965b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f17964a = aVar;
            this.f17965b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f17964a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f17965b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.i.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class j implements C2008G {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f17966a;

        j(MyApps myApps) {
            this.f17966a = myApps;
        }

        public void a(int i4) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (this.f17966a.n5(i4)) {
                C1536m Q4 = this.f17966a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                this.f17966a.T3((C2048f) obj, i4);
            } else if (this.f17966a.o5(i4)) {
                C1536m Q42 = this.f17966a.f17935X;
                m.b(Q42);
                Object obj2 = Q42.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f17966a.T3(((J.a) obj2).a(), i4);
            }
        }

        public void b(int i4) {
            if (this.f17966a.n5(i4)) {
                C1536m Q4 = this.f17966a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                ((C2048f) obj).a0(true);
                C1536m Q42 = this.f17966a.f17935X;
                m.b(Q42);
                Q42.notifyItemChanged(i4);
            } else if (this.f17966a.o5(i4)) {
                C1536m Q43 = this.f17966a.f17935X;
                m.b(Q43);
                Object obj2 = Q43.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((J.a) obj2).a().a0(true);
                C1536m Q44 = this.f17966a.f17935X;
                m.b(Q44);
                Q44.notifyItemChanged(i4);
            }
        }

        public void c(int i4) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (this.f17966a.n5(i4)) {
                C1536m Q4 = this.f17966a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                C2048f fVar = (C2048f) obj;
                if (fVar.w() == C2048f.c.OUTDATED) {
                    this.f17966a.v4(fVar);
                }
            } else if (this.f17966a.o5(i4)) {
                C1536m Q42 = this.f17966a.f17935X;
                m.b(Q42);
                Object obj2 = Q42.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f17966a.v4(((J.a) obj2).a());
            }
        }

        public void d(int i4) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (this.f17966a.n5(i4)) {
                C1536m Q4 = this.f17966a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                this.f17966a.u4((C2048f) obj);
            } else if (this.f17966a.o5(i4)) {
                C1536m Q42 = this.f17966a.f17935X;
                m.b(Q42);
                Object obj2 = Q42.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f17966a.u4(((J.a) obj2).a());
            }
        }

        public void e(int i4) {
            if (this.f17966a.n5(i4)) {
                C1536m Q4 = this.f17966a.f17935X;
                m.b(Q4);
                Object obj = Q4.b().get(i4);
                m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                ((C2048f) obj).a0(false);
                C1536m Q42 = this.f17966a.f17935X;
                m.b(Q42);
                Q42.notifyItemChanged(i4);
            } else if (this.f17966a.o5(i4)) {
                C1536m Q43 = this.f17966a.f17935X;
                m.b(Q43);
                Object obj2 = Q43.b().get(i4);
                m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((J.a) obj2).a().a0(false);
                C1536m Q44 = this.f17966a.f17935X;
                m.b(Q44);
                Q44.notifyItemChanged(i4);
            }
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f17968b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17969c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f17970d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MyApps myApps, String str, int i4, V2.d dVar) {
            super(2, dVar);
            this.f17968b = myApps;
            this.f17969c = str;
            this.f17970d = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f17968b, this.f17969c, this.f17970d, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                r0 = 1
                r1 = 0
                W2.b.c()
                int r2 = r6.f17967a
                if (r2 != 0) goto L_0x00fe
                R2.n.b(r7)
                com.uptodown.activities.MyApps r7 = r6.f17968b
                M1.m r7 = r7.f17935X
                if (r7 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r7 = r6.f17968b
                java.lang.String r2 = r6.f17969c
                int r7 = r7.c5(r2)
                r2 = -1
                if (r7 <= r2) goto L_0x0021
                r2 = 1
                goto L_0x0022
            L_0x0021:
                r2 = 0
            L_0x0022:
                int r3 = r6.f17970d
                r4 = 306(0x132, float:4.29E-43)
                if (r3 != r4) goto L_0x0048
                if (r2 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r0 = r6.f17968b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r7)
                com.uptodown.activities.MyApps r0 = r6.f17968b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemRemoved(r7)
                goto L_0x00fb
            L_0x0048:
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 != r4) goto L_0x005c
                if (r2 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r0 = r6.f17968b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x005c:
                r4 = 305(0x131, float:4.27E-43)
                if (r3 == r4) goto L_0x00fb
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 != r4) goto L_0x007b
                if (r2 == 0) goto L_0x0074
                com.uptodown.activities.MyApps r0 = r6.f17968b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x0074:
                com.uptodown.activities.MyApps r7 = r6.f17968b
                r7.p5(r1)
                goto L_0x00fb
            L_0x007b:
                if (r2 == 0) goto L_0x00af
                com.uptodown.activities.MyApps r3 = r6.f17968b
                M1.m r3 = r3.f17935X
                kotlin.jvm.internal.m.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r7)
                boolean r3 = r3 instanceof g2.C2048f
                if (r3 == 0) goto L_0x00af
                com.uptodown.activities.MyApps r3 = r6.f17968b
                M1.m r3 = r3.f17935X
                kotlin.jvm.internal.m.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r7)
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.m.c(r3, r4)
                g2.f r3 = (g2.C2048f) r3
                java.lang.String r3 = r3.m()
                goto L_0x00b0
            L_0x00af:
                r3 = 0
            L_0x00b0:
                int r4 = r6.f17970d
                r5 = 304(0x130, float:4.26E-43)
                if (r4 == r5) goto L_0x00d2
                r5 = 307(0x133, float:4.3E-43)
                if (r4 == r5) goto L_0x00c8
                com.uptodown.activities.MyApps r4 = r6.f17968b
                r5 = 2131952077(0x7f1301cd, float:1.9540587E38)
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r3
                java.lang.String r0 = r4.getString(r5, r0)
                goto L_0x00db
            L_0x00c8:
                com.uptodown.activities.MyApps r0 = r6.f17968b
                r1 = 2131952002(0x7f130182, float:1.9540434E38)
                java.lang.String r0 = r0.getString(r1)
                goto L_0x00db
            L_0x00d2:
                com.uptodown.activities.MyApps r0 = r6.f17968b
                r1 = 2131952305(0x7f1302b1, float:1.954105E38)
                java.lang.String r0 = r0.getString(r1)
            L_0x00db:
                com.uptodown.activities.MyApps r1 = r6.f17968b
                r1.U1(r0)
                if (r2 == 0) goto L_0x00ef
                com.uptodown.activities.MyApps r0 = r6.f17968b
                M1.m r0 = r0.f17935X
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x00ef:
                com.uptodown.activities.MyApps r7 = r6.f17968b
                M1.m r7 = r7.f17935X
                kotlin.jvm.internal.m.b(r7)
                r7.c()
            L_0x00fb:
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x00fe:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17971a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17972b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MyApps f17973c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17974d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(int i4, MyApps myApps, String str, V2.d dVar) {
            super(2, dVar);
            this.f17972b = i4;
            this.f17973c = myApps;
            this.f17974d = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f17972b, this.f17973c, this.f17974d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17971a == 0) {
                n.b(obj);
                int i4 = this.f17972b;
                if (i4 == 102) {
                    MyApps myApps = this.f17973c;
                    String string = myApps.getString(R.string.descarga_error);
                    m.d(string, "getString(...)");
                    myApps.q0(string);
                } else if (i4 == 104) {
                    MyApps myApps2 = this.f17973c;
                    String string2 = myApps2.getString(R.string.no_free_space);
                    m.d(string2, "getString(...)");
                    myApps2.q0(string2);
                } else if (i4 == 106) {
                    MyApps myApps3 = this.f17973c;
                    String string3 = myApps3.getString(R.string.download_cancelled);
                    m.d(string3, "getString(...)");
                    myApps3.q0(string3);
                }
                int S4 = this.f17973c.c5(this.f17974d);
                if (S4 > -1) {
                    C1536m Q4 = this.f17973c.f17935X;
                    m.b(Q4);
                    Q4.notifyItemChanged(S4);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final void Y4(String str) {
        d5().i(str);
        p5(true);
    }

    /* access modifiers changed from: private */
    public static final S Z4(MyApps myApps) {
        return S.c(myApps.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final S b5() {
        return (S) this.f17933V.getValue();
    }

    /* access modifiers changed from: private */
    public final int c5(String str) {
        ArrayList arrayList;
        C1536m mVar = this.f17935X;
        ArrayList arrayList2 = null;
        if (mVar != null) {
            arrayList = mVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C1536m mVar2 = this.f17935X;
        if (mVar2 != null) {
            arrayList2 = mVar2.b();
        }
        m.b(arrayList2);
        int i4 = 0;
        for (Object next : arrayList2) {
            int i5 = i4 + 1;
            if (((next instanceof g2.S) && m3.m.p(((g2.S) next).h(), str, true)) || ((next instanceof C2048f) && m3.m.p(((C2048f) next).o(), str, true))) {
                return i4;
            }
            i4 = i5;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final r d5() {
        return (r) this.f17934W.getValue();
    }

    private final void e5() {
        setContentView((View) b5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            b5().f9994g.setNavigationIcon(drawable);
            b5().f9994g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        b5().f9994g.setNavigationOnClickListener(new N1(this));
        b5().f9994g.inflateMenu(R.menu.toolbar_menu_my_apps);
        TextView textView = b5().f9996i;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        b5().f9995h.setTypeface(aVar.x());
        a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
        boolean f02 = aVar2.f0(this);
        b5().f9994g.getMenu().findItem(R.id.action_show_system_apps).setChecked(f02);
        b5().f9994g.getMenu().findItem(R.id.action_show_system_services).setChecked(aVar2.g0(this));
        Toolbar toolbar = b5().f9994g;
        m.d(toolbar, "toolbarMyApps");
        m4(R.id.action_show_system_services, f02, toolbar);
        b5().f9994g.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        b5().f9994g.setOnMenuItemClickListener(new O1(this));
        b5().f9989b.f9695c.setTypeface(aVar.x());
        b5().f9989b.f9696d.setTypeface(aVar.w());
        b5().f9989b.f9696d.setText(getString(R.string.order_by_name));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.order_by_name));
        hashMap.put(1, getString(R.string.order_by_last_update));
        hashMap.put(2, getString(R.string.order_by_size));
        b5().f9989b.getRoot().setOnClickListener(new P1(this, hashMap));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        b5().f9992e.addItemDecoration(new w2.l(dimension, dimension));
        b5().f9992e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        b5().f9992e.setItemAnimator(new DefaultItemAnimator());
        NestedScrollView nestedScrollView = b5().f9991d;
        m.d(nestedScrollView, "nsvMyApps");
        hideKeyboardOnScroll(nestedScrollView);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) b5().f9992e.getItemAnimator();
        m.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        b5().f9993f.setOnQueryTextListener(new d(this));
        EditText editText = (EditText) b5().f9993f.findViewById(R.id.search_src_text);
        editText.setTypeface(aVar.x());
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        b5().f9993f.setOnClickListener(new Q1(this));
        b5().f9990c.setOnClickListener(new R1());
    }

    /* access modifiers changed from: private */
    public static final void f5(MyApps myApps, View view) {
        myApps.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean g5(MyApps myApps, MenuItem menuItem) {
        m.e(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_show_system_apps) {
            boolean isChecked = menuItem.isChecked();
            menuItem.setChecked(!isChecked);
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context applicationContext = myApps.getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            aVar.d1(applicationContext, !isChecked);
            if (isChecked) {
                Context applicationContext2 = myApps.getApplicationContext();
                m.d(applicationContext2, "getApplicationContext(...)");
                aVar.e1(applicationContext2, false);
                Toolbar toolbar = myApps.b5().f9994g;
                m.d(toolbar, "toolbarMyApps");
                myApps.m4(R.id.action_show_system_services, false, toolbar);
                Toolbar toolbar2 = myApps.b5().f9994g;
                m.d(toolbar2, "toolbarMyApps");
                myApps.F3(R.id.action_show_system_services, false, toolbar2);
            } else {
                Toolbar toolbar3 = myApps.b5().f9994g;
                m.d(toolbar3, "toolbarMyApps");
                myApps.m4(R.id.action_show_system_services, true, toolbar3);
            }
            myApps.p5(true);
        } else if (menuItem.getItemId() == R.id.action_show_system_services) {
            boolean isChecked2 = menuItem.isChecked();
            menuItem.setChecked(!isChecked2);
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            Context applicationContext3 = myApps.getApplicationContext();
            m.d(applicationContext3, "getApplicationContext(...)");
            aVar2.e1(applicationContext3, !isChecked2);
            myApps.p5(true);
        } else if (menuItem.getItemId() == R.id.action_search) {
            if (myApps.b5().f9993f.getVisibility() == 0) {
                myApps.b5().f9993f.setVisibility(8);
                myApps.b5().f9993f.clearFocus();
            } else {
                myApps.b5().f9993f.setVisibility(0);
                myApps.b5().f9993f.requestFocus();
                SearchView searchView = myApps.b5().f9993f;
                m.d(searchView, "searchViewMyApps");
                myApps.showKeyboard(searchView);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void h5(MyApps myApps, HashMap hashMap, View view) {
        m.b(view);
        new q(myApps, view, hashMap, new S1(myApps)).c();
    }

    /* access modifiers changed from: private */
    public static final s i5(MyApps myApps, int i4, String str) {
        m.e(str, "selectedOption");
        if (((Number) myApps.d5().f().getValue()).intValue() != i4) {
            myApps.d5().f().setValue(Integer.valueOf(i4));
            myApps.b5().f9989b.f9696d.setText(str);
            myApps.Y4(myApps.b5().f9993f.getQuery().toString());
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void j5(MyApps myApps, View view) {
        myApps.b5().f9993f.setIconified(false);
    }

    /* access modifiers changed from: private */
    public static final void k5(View view) {
    }

    /* access modifiers changed from: private */
    public final boolean n5(int i4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C1536m mVar = this.f17935X;
        if (mVar == null) {
            return false;
        }
        ArrayList arrayList3 = null;
        if (mVar != null) {
            arrayList = mVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        C1536m mVar2 = this.f17935X;
        if (mVar2 != null) {
            arrayList2 = mVar2.b();
        } else {
            arrayList2 = null;
        }
        m.b(arrayList2);
        if (arrayList2.size() <= i4) {
            return false;
        }
        C1536m mVar3 = this.f17935X;
        if (mVar3 != null) {
            arrayList3 = mVar3.b();
        }
        m.b(arrayList3);
        if (arrayList3.get(i4) instanceof C2048f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean o5(int i4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C1536m mVar = this.f17935X;
        if (mVar == null) {
            return false;
        }
        ArrayList arrayList3 = null;
        if (mVar != null) {
            arrayList = mVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        C1536m mVar2 = this.f17935X;
        if (mVar2 != null) {
            arrayList2 = mVar2.b();
        } else {
            arrayList2 = null;
        }
        m.b(arrayList2);
        if (arrayList2.size() <= i4) {
            return false;
        }
        C1536m mVar3 = this.f17935X;
        if (mVar3 != null) {
            arrayList3 = mVar3.b();
        }
        m.b(arrayList3);
        if (arrayList3.get(i4) instanceof J.a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void q5(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        if (this.f17935X == null) {
            this.f17935X = new C1536m(this.f17936Y, this.f17937Z, this.f17938m0);
            b5().f9992e.setAdapter(this.f17935X);
        }
        String g4 = d5().g();
        if (g4 == null || g4.length() == 0 || !arrayList.isEmpty() || !arrayList2.isEmpty() || !arrayList3.isEmpty() || !arrayList4.isEmpty()) {
            b5().f9995h.setVisibility(8);
        } else {
            b5().f9995h.setText(getString(R.string.no_results_filtered, new Object[]{d5().g()}));
            b5().f9995h.setVisibility(0);
        }
        C1536m mVar = this.f17935X;
        m.b(mVar);
        mVar.f(arrayList, arrayList2, arrayList3, arrayList4);
    }

    /* access modifiers changed from: private */
    public final void s5(ArrayList arrayList) {
        if (!UptodownApp.f17422D.U("GenerateQueueWorker", this)) {
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", 0).putBoolean("downloadAnyway", true).putString("packagename", ((C2048f) arrayList.get(0)).o()).build();
            m.d(build, "build(...)");
            WorkManager.getInstance(this).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(build)).build());
            t5();
        }
    }

    private final void t5() {
        runOnUiThread(new T1(this));
    }

    /* access modifiers changed from: private */
    public static final void u5(MyApps myApps) {
        new Handler(Looper.getMainLooper()).postDelayed(new U1(myApps), 100);
    }

    /* access modifiers changed from: private */
    public static final void v5(MyApps myApps) {
        C1536m mVar = myApps.f17935X;
        if (mVar != null) {
            mVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public void A4() {
        p5(false);
    }

    public void H2() {
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.e();
        }
    }

    public void P2(File file) {
        m.e(file, "file");
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.g(file, this);
        }
    }

    public void R2(File file) {
        m.e(file, "file");
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.e();
        }
        C1536m mVar2 = this.f17935X;
        if (mVar2 != null) {
            mVar2.d(file, this);
        }
    }

    public void S2(File file, int i4) {
        m.e(file, "file");
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.d(file, this);
        }
    }

    public final Object a5(String str, String str2, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new b(this, str2, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final void l5() {
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.e();
        }
    }

    public final void m5(String str) {
        C1536m mVar = this.f17935X;
        if (mVar != null) {
            mVar.e();
        }
        if (str != null && str.length() != 0) {
            String string = getString(R.string.install_compatibility_error, new Object[]{str});
            m.d(string, "getString(...)");
            q0(string);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e5();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new e(this, (V2.d) null), 3, (Object) null);
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        m.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i4 != 82) {
            return super.onKeyDown(i4, keyEvent);
        }
        b5().f9994g.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        p5(true);
        C2313C.f21882a.h(this);
    }

    public final void p5(boolean z4) {
        d5().c(this, z4);
    }

    public final void r5(ArrayList arrayList) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, arrayList, (V2.d) null), 2, (Object) null);
    }

    public void w4(int i4, int i5) {
        p5(false);
    }

    public final void w5(int i4, String str) {
        m.e(str, "packageName");
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new k(this, str, i4, (V2.d) null), 2, (Object) null);
    }

    public void x4(int i4, int i5) {
        p5(false);
    }

    public final void x5(int i4, String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new l(i4, this, str, (V2.d) null), 2, (Object) null);
    }
}
