package com.uptodown.activities;

import J1.J;
import J1.K;
import M1.C1526c;
import N1.j;
import N1.k;
import R2.g;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b2.C1629a;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1833h;
import d3.p;
import f2.C2011b;
import f2.C2016g;
import g2.C2048f;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
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

public final class FreeUpSpaceActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f17648J = h.a(new J(this));

    /* renamed from: K  reason: collision with root package name */
    private final g f17649K = new ViewModelLazy(D.b(C1833h.class), new e(this), new d(this), new f((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1526c f17650L;

    /* renamed from: M  reason: collision with root package name */
    private C2050h f17651M;

    /* renamed from: N  reason: collision with root package name */
    private final a f17652N = new a(this);

    public static final class a implements C2011b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f17653a;

        a(FreeUpSpaceActivity freeUpSpaceActivity) {
            this.f17653a = freeUpSpaceActivity;
        }

        public void a(int i4) {
            C1526c d32;
            ArrayList a5;
            C2048f fVar;
            String o4;
            if (UptodownApp.f17422D.a0() && (d32 = this.f17653a.f17650L) != null && (a5 = d32.a()) != null && (fVar = (C2048f) a5.get(i4)) != null && (o4 = fVar.o()) != null) {
                new j(this.f17653a).h(o4);
            }
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f17655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17656c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17657d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FreeUpSpaceActivity freeUpSpaceActivity, String str, String str2, V2.d dVar) {
            super(2, dVar);
            this.f17655b = freeUpSpaceActivity;
            this.f17656c = str;
            this.f17657d = str2;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17655b, this.f17656c, this.f17657d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r0.equals("app_updated") != false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
            if (r0.equals("app_installed") == false) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                W2.b.c()
                int r0 = r3.f17654a
                if (r0 != 0) goto L_0x0070
                R2.n.b(r4)
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f17655b
                java.lang.String r0 = r3.f17656c
                int r4 = r4.n3(r0)
                if (r4 < 0) goto L_0x0068
                java.lang.String r0 = r3.f17657d
                int r1 = r0.hashCode()
                r2 = -1972881700(0xffffffff8a6836dc, float:-1.11807116E-32)
                if (r1 == r2) goto L_0x0059
                r2 = -1487908707(0xffffffffa750509d, float:-2.89095E-15)
                if (r1 == r2) goto L_0x0050
                r2 = 389690339(0x173a33e3, float:6.016533E-25)
                if (r1 == r2) goto L_0x002a
                goto L_0x0068
            L_0x002a:
                java.lang.String r1 = "app_uninstalled"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0033
                goto L_0x0068
            L_0x0033:
                com.uptodown.activities.FreeUpSpaceActivity r0 = r3.f17655b
                M1.c r0 = r0.f17650L
                kotlin.jvm.internal.m.b(r0)
                java.util.ArrayList r0 = r0.a()
                r0.remove(r4)
                com.uptodown.activities.FreeUpSpaceActivity r0 = r3.f17655b
                M1.c r0 = r0.f17650L
                kotlin.jvm.internal.m.b(r0)
                r0.notifyItemRemoved(r4)
                goto L_0x0068
            L_0x0050:
                java.lang.String r4 = "app_updated"
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0068
                goto L_0x0062
            L_0x0059:
                java.lang.String r4 = "app_installed"
                boolean r4 = r0.equals(r4)
                if (r4 != 0) goto L_0x0062
                goto L_0x0068
            L_0x0062:
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f17655b
                r0 = 0
                r4.u3(r0)
            L_0x0068:
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f17655b
                r4.v3()
                R2.s r4 = R2.s.f8222a
                return r4
            L_0x0070:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17658a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f17659b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FreeUpSpaceActivity f17660a;

            /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$a  reason: collision with other inner class name */
            static final class C0216a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f17661a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FreeUpSpaceActivity f17662b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0216a(FreeUpSpaceActivity freeUpSpaceActivity, V2.d dVar) {
                    super(2, dVar);
                    this.f17662b = freeUpSpaceActivity;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0216a(this.f17662b, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f17661a == 0) {
                        n.b(obj);
                        this.f17662b.o3().f9722c.setVisibility(0);
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, V2.d dVar) {
                    return ((C0216a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            static final class b extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f17663a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FreeUpSpaceActivity f17664b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ E f17665c;

                /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$b$a  reason: collision with other inner class name */
                public static final class C0217a implements C2016g {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FreeUpSpaceActivity f17666a;

                    /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$b$a$a  reason: collision with other inner class name */
                    static final class C0218a extends l implements p {

                        /* renamed from: a  reason: collision with root package name */
                        int f17667a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ FreeUpSpaceActivity f17668b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ String f17669c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ long f17670d;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0218a(FreeUpSpaceActivity freeUpSpaceActivity, String str, long j4, V2.d dVar) {
                            super(2, dVar);
                            this.f17668b = freeUpSpaceActivity;
                            this.f17669c = str;
                            this.f17670d = j4;
                        }

                        public final V2.d create(Object obj, V2.d dVar) {
                            return new C0218a(this.f17668b, this.f17669c, this.f17670d, dVar);
                        }

                        public final Object invokeSuspend(Object obj) {
                            ArrayList arrayList;
                            W2.b.c();
                            if (this.f17667a == 0) {
                                n.b(obj);
                                int g32 = this.f17668b.p3(this.f17669c);
                                if (g32 >= 0) {
                                    C1526c d32 = this.f17668b.f17650L;
                                    if (d32 != null) {
                                        arrayList = d32.a();
                                    } else {
                                        arrayList = null;
                                    }
                                    m.b(arrayList);
                                    ((C2048f) arrayList.get(g32)).b0(this.f17670d);
                                    C1526c d33 = this.f17668b.f17650L;
                                    if (d33 != null) {
                                        d33.notifyItemChanged(this.f17668b.p3(this.f17669c));
                                    }
                                }
                                return s.f8222a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object invoke(o3.J j4, V2.d dVar) {
                            return ((C0218a) create(j4, dVar)).invokeSuspend(s.f8222a);
                        }
                    }

                    C0217a(FreeUpSpaceActivity freeUpSpaceActivity) {
                        this.f17666a = freeUpSpaceActivity;
                    }

                    public void a(String str, long j4) {
                        m.e(str, "packageName");
                        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f17666a), Y.c(), (L) null, new C0218a(this.f17666a, str, j4, (V2.d) null), 2, (Object) null);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(FreeUpSpaceActivity freeUpSpaceActivity, E e5, V2.d dVar) {
                    super(2, dVar);
                    this.f17664b = freeUpSpaceActivity;
                    this.f17665c = e5;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new b(this.f17664b, this.f17665c, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f17663a == 0) {
                        n.b(obj);
                        this.f17664b.o3().f9722c.setVisibility(8);
                        this.f17664b.w3(((C1833h.a) ((E.c) this.f17665c).a()).a());
                        if (!((Boolean) this.f17664b.q3().c().getValue()).booleanValue()) {
                            new C1629a(new C0217a(this.f17664b), LifecycleOwnerKt.getLifecycleScope(this.f17664b), this.f17664b);
                            this.f17664b.q3().c().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, V2.d dVar) {
                    return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            a(FreeUpSpaceActivity freeUpSpaceActivity) {
                this.f17660a = freeUpSpaceActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    Object g4 = C0977g.g(Y.c(), new C0216a(this.f17660a, (V2.d) null), dVar);
                    if (g4 == W2.b.c()) {
                        return g4;
                    }
                    return s.f8222a;
                } else if (e5 instanceof E.c) {
                    Object g5 = C0977g.g(Y.c(), new b(this.f17660a, e5, (V2.d) null), dVar);
                    if (g5 == W2.b.c()) {
                        return g5;
                    }
                    return s.f8222a;
                } else if (e5 instanceof E.b) {
                    return s.f8222a;
                } else {
                    throw new k();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FreeUpSpaceActivity freeUpSpaceActivity, V2.d dVar) {
            super(2, dVar);
            this.f17659b = freeUpSpaceActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17659b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17658a;
            if (i4 == 0) {
                n.b(obj);
                I d5 = this.f17659b.q3().d();
                a aVar = new a(this.f17659b);
                this.f17658a = 1;
                if (d5.collect(aVar, this) == c5) {
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

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17671a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f17671a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f17671a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17672a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f17672a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f17672a.getViewModelStore();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f17673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f17674b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f17673a = aVar;
            this.f17674b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f17673a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f17674b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.f.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final c2.E l3(FreeUpSpaceActivity freeUpSpaceActivity) {
        return c2.E.c(freeUpSpaceActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final int n3(String str) {
        ArrayList arrayList;
        C1526c cVar = this.f17650L;
        ArrayList<C2048f> arrayList2 = null;
        if (cVar != null) {
            arrayList = cVar.a();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C1526c cVar2 = this.f17650L;
        if (cVar2 != null) {
            arrayList2 = cVar2.a();
        }
        m.b(arrayList2);
        int i4 = 0;
        for (C2048f o4 : arrayList2) {
            int i5 = i4 + 1;
            if (m3.m.p(o4.o(), str, true)) {
                return i4;
            }
            i4 = i5;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final c2.E o3() {
        return (c2.E) this.f17648J.getValue();
    }

    /* access modifiers changed from: private */
    public final int p3(String str) {
        ArrayList arrayList;
        C1526c cVar = this.f17650L;
        ArrayList<C2048f> arrayList2 = null;
        if (cVar != null) {
            arrayList = cVar.a();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C1526c cVar2 = this.f17650L;
        if (cVar2 != null) {
            arrayList2 = cVar2.a();
        }
        m.b(arrayList2);
        int i4 = 0;
        for (C2048f o4 : arrayList2) {
            int i5 = i4 + 1;
            if (m3.m.p(o4.o(), str, true)) {
                return i4;
            }
            i4 = i5;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final C1833h q3() {
        return (C1833h) this.f17649K.getValue();
    }

    private final void r3() {
        setContentView((View) o3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o3().f9724e.setNavigationIcon(drawable);
            o3().f9724e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        o3().f9724e.setNavigationOnClickListener(new K(this));
        TextView textView = o3().f9725f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        o3().f9721b.f10403g.setTypeface(aVar.x());
        o3().f9721b.f10404h.setTypeface(aVar.x());
        o3().f9721b.f10402f.setTypeface(aVar.w());
        o3().f9721b.f10402f.setVisibility(8);
        v3();
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        o3().f9723d.addItemDecoration(new w2.l(dimension, dimension));
        o3().f9723d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        o3().f9723d.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) o3().f9723d.getItemAnimator();
        m.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        o3().f9722c.setOnClickListener(new J1.L());
    }

    /* access modifiers changed from: private */
    public static final void s3(FreeUpSpaceActivity freeUpSpaceActivity, View view) {
        freeUpSpaceActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void t3(View view) {
    }

    /* access modifiers changed from: private */
    public final void u3(boolean z4) {
        q3().b(this, z4);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v3() {
        /*
            r19 = this;
            r0 = r19
            r2 = 1
            r3 = 0
            g2.h r4 = r0.f17651M
            if (r4 == 0) goto L_0x0023
            if (r4 == 0) goto L_0x000f
            java.lang.String r4 = r4.l0()
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            if (r4 == 0) goto L_0x0023
            g2.h r4 = r0.f17651M     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r4 = r4.l0()     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0023 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r4 = 0
        L_0x0025:
            u2.w r6 = new u2.w
            r6.<init>()
            java.io.File r6 = r6.f(r0)
            u2.w r7 = new u2.w
            r7.<init>()
            long r7 = r7.k(r0, r6)
            long r9 = r6.getTotalSpace()
            double r4 = (double) r4
            r11 = 4612248968380809216(0x4002000000000000, double:2.25)
            double r4 = r4 * r11
            long r4 = (long) r4
            long r11 = r9 - r7
            r6 = 100
            long r13 = (long) r6
            long r13 = r13 * r11
            long r13 = r13 / r9
            r15 = 9
            long r15 = r15 * r9
            r17 = 10
            long r15 = r15 / r17
            long r15 = r9 - r15
            r6 = 2131952006(0x7f130186, float:1.9540443E38)
            r1 = 8
            int r18 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r18 <= 0) goto L_0x00af
            W1.i r9 = new W1.i
            r9.<init>()
            long r4 = r4 - r7
            java.lang.String r4 = r9.d(r4, r0)
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10400d
            int r7 = (int) r13
            r5.setProgress(r7)
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10399c
            r5.setVisibility(r1)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.ProgressBar r1 = r1.f10400d
            r1.setVisibility(r3)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10403g
            java.lang.String r5 = r0.getString(r6)
            r1.setText(r5)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10404h
            r5 = 2131952408(0x7f130318, float:1.9541258E38)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            java.lang.String r2 = r0.getString(r5, r2)
            r1.setText(r2)
            goto L_0x016c
        L_0x00af:
            r4 = 2131951992(0x7f130178, float:1.9540414E38)
            int r5 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r5 >= 0) goto L_0x0110
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10400d
            int r7 = (int) r13
            r5.setProgress(r7)
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10399c
            r5.setVisibility(r1)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.ProgressBar r1 = r1.f10400d
            r1.setVisibility(r3)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10403g
            java.lang.String r5 = r0.getString(r6)
            r1.setText(r5)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10404h
            W1.i r5 = new W1.i
            r5.<init>()
            java.lang.String r5 = r5.d(r11, r0)
            W1.i r6 = new W1.i
            r6.<init>()
            java.lang.String r6 = r6.d(r9, r0)
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r7[r2] = r6
            java.lang.String r2 = r0.getString(r4, r7)
            r1.setText(r2)
            goto L_0x016c
        L_0x0110:
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10399c
            int r6 = (int) r13
            r5.setProgress(r6)
            c2.E r5 = r0.o3()
            c2.e1 r5 = r5.f9721b
            android.widget.ProgressBar r5 = r5.f10400d
            r5.setVisibility(r1)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.ProgressBar r1 = r1.f10399c
            r1.setVisibility(r3)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10403g
            r5 = 2131951993(0x7f130179, float:1.9540416E38)
            java.lang.String r5 = r0.getString(r5)
            r1.setText(r5)
            c2.E r1 = r0.o3()
            c2.e1 r1 = r1.f9721b
            android.widget.TextView r1 = r1.f10404h
            W1.i r5 = new W1.i
            r5.<init>()
            java.lang.String r5 = r5.d(r11, r0)
            W1.i r6 = new W1.i
            r6.<init>()
            java.lang.String r6 = r6.d(r9, r0)
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r7[r2] = r6
            java.lang.String r2 = r0.getString(r4, r7)
            r1.setText(r2)
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.v3():void");
    }

    /* access modifiers changed from: private */
    public final void w3(ArrayList arrayList) {
        C1526c cVar = this.f17650L;
        if (cVar == null) {
            this.f17650L = new C1526c(arrayList, this, this.f17652N);
            o3().f9723d.setAdapter(this.f17650L);
            return;
        }
        m.b(cVar);
        cVar.b(arrayList);
    }

    public final Object m3(String str, String str2, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new b(this, str2, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInfo"))) {
            Intent intent2 = getIntent();
            m.b(intent2);
            Bundle extras2 = intent2.getExtras();
            m.b(extras2);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras2.getParcelable("appInfo", C2050h.class);
            } else {
                parcelable = extras2.getParcelable("appInfo");
            }
            this.f17651M = (C2050h) parcelable;
        }
        r3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new c(this, (V2.d) null), 3, (Object) null);
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        m.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i4 != 82) {
            return super.onKeyDown(i4, keyEvent);
        }
        o3().f9724e.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u3(true);
        C2313C.f21882a.h(this);
    }
}
