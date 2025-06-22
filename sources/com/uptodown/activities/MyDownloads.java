package com.uptodown.activities;

import J1.A2;
import J1.B2;
import J1.C1453u2;
import J1.C1460v2;
import J1.C1467w2;
import J1.C1474x2;
import J1.C1481y2;
import J1.C1488z2;
import J1.C2;
import J1.D2;
import J1.E2;
import J1.F2;
import J1.G2;
import J1.H2;
import J1.I2;
import J1.J2;
import J1.K2;
import J1.L2;
import J1.M2;
import J1.N2;
import J1.O2;
import J1.P2;
import M1.C1525b;
import N1.k;
import R2.s;
import S2.C1601o;
import W1.C1612h;
import W1.G;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1681o;
import c2.T;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1843s;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.C2020k;
import g2.C2050h;
import g2.C2054l;
import g2.C2060s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.G;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import u2.q;
import u2.t;
import u2.w;

public final class MyDownloads extends C1826a {

    /* renamed from: Q  reason: collision with root package name */
    public static final a f17975Q = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f17976J = R2.h.a(new C1453u2(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f17977K = new ViewModelLazy(D.b(C1843s.class), new l(this), new k(this), new m((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1525b f17978L;

    /* renamed from: M  reason: collision with root package name */
    private C1843s.b f17979M = C1843s.b.DATE;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public boolean f17980N;

    /* renamed from: O  reason: collision with root package name */
    private final i f17981O = new i(this);

    /* renamed from: P  reason: collision with root package name */
    private final f f17982P = new f(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f17983a;

        public b(int i4) {
            this.f17983a = i4;
        }

        public void run() {
            int i4 = this.f17983a;
            if (i4 == 302 || i4 == 352) {
                MyDownloads.this.y4(false);
            } else {
                MyDownloads.this.x4();
            }
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17985a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17986b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17987c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MyDownloads myDownloads, boolean z4, V2.d dVar) {
            super(2, dVar);
            this.f17986b = myDownloads;
            this.f17987c = z4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17986b, this.f17987c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17985a == 0) {
                R2.n.b(obj);
                if (this.f17986b.f17978L != null) {
                    C1525b C32 = this.f17986b.f17978L;
                    kotlin.jvm.internal.m.b(C32);
                    if (C32.d().size() > 0) {
                        if (this.f17987c) {
                            C1525b C33 = this.f17986b.f17978L;
                            kotlin.jvm.internal.m.b(C33);
                            Iterator it = C33.d().iterator();
                            kotlin.jvm.internal.m.d(it, "iterator(...)");
                            while (it.hasNext()) {
                                Object next = it.next();
                                kotlin.jvm.internal.m.d(next, "next(...)");
                                MyDownloads myDownloads = this.f17986b;
                                C1525b C34 = myDownloads.f17978L;
                                kotlin.jvm.internal.m.b(C34);
                                myDownloads.P3(C34.d().indexOf((C2060s) next));
                            }
                        } else {
                            C1525b C35 = this.f17986b.f17978L;
                            kotlin.jvm.internal.m.b(C35);
                            Iterator it2 = C35.d().iterator();
                            kotlin.jvm.internal.m.d(it2, "iterator(...)");
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                kotlin.jvm.internal.m.d(next2, "next(...)");
                                C2060s sVar = (C2060s) next2;
                                if (!sVar.K() && !DownloadWorker.f19459d.k(sVar.h(), sVar.E())) {
                                    MyDownloads myDownloads2 = this.f17986b;
                                    C1525b C36 = myDownloads2.f17978L;
                                    kotlin.jvm.internal.m.b(C36);
                                    myDownloads2.P3(C36.d().indexOf(sVar));
                                }
                            }
                        }
                        this.f17986b.D4();
                        this.f17986b.y4(false);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f17988a;

        /* renamed from: b  reason: collision with root package name */
        int f17989b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17990c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f17991d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MyDownloads myDownloads, int i4, V2.d dVar) {
            super(2, dVar);
            this.f17990c = myDownloads;
            this.f17991d = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17990c, this.f17991d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2060s sVar;
            Parcelable parcelable;
            Object c5 = W2.b.c();
            int i4 = this.f17989b;
            if (i4 == 0) {
                R2.n.b(obj);
                C1525b C32 = this.f17990c.f17978L;
                kotlin.jvm.internal.m.b(C32);
                Object obj2 = C32.d().get(this.f17991d);
                kotlin.jvm.internal.m.d(obj2, "get(...)");
                C2060s sVar2 = (C2060s) obj2;
                C1843s D32 = this.f17990c.l4();
                MyDownloads myDownloads = this.f17990c;
                this.f17988a = sVar2;
                this.f17989b = 1;
                Object g4 = D32.g(myDownloads, sVar2, this);
                if (g4 == c5) {
                    return c5;
                }
                sVar = sVar2;
                obj = g4;
            } else if (i4 == 1) {
                sVar = (C2060s) this.f17988a;
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((Boolean) obj).booleanValue()) {
                C1525b C33 = this.f17990c.f17978L;
                kotlin.jvm.internal.m.b(C33);
                C33.d().remove(sVar);
                C1525b C34 = this.f17990c.f17978L;
                kotlin.jvm.internal.m.b(C34);
                C34.notifyItemRemoved(this.f17991d);
                C1525b C35 = this.f17990c.f17978L;
                kotlin.jvm.internal.m.b(C35);
                if (C35.d().isEmpty()) {
                    this.f17990c.j4().f10029h.setVisibility(0);
                }
            }
            Intent intent = this.f17990c.getIntent();
            kotlin.jvm.internal.m.d(intent, "getIntent(...)");
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) intent.getParcelableExtra("downloadResultReceiver", ResultReceiver.class);
            } else {
                parcelable = intent.getParcelableExtra("downloadResultReceiver");
            }
            ResultReceiver resultReceiver = (ResultReceiver) parcelable;
            if (resultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("download", sVar);
                s sVar3 = s.f8222a;
                resultReceiver.send(207, bundle);
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f17992a;

        /* renamed from: b  reason: collision with root package name */
        int f17993b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17994c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MyDownloads myDownloads, V2.d dVar) {
            super(2, dVar);
            this.f17994c = myDownloads;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17994c, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f17993b
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r5.f17992a
                java.util.Iterator r1 = (java.util.Iterator) r1
                R2.n.b(r6)
                goto L_0x003d
            L_0x0013:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001b:
                R2.n.b(r6)
                com.uptodown.activities.MyDownloads r6 = r5.f17994c
                M1.b r6 = r6.f17978L
                if (r6 == 0) goto L_0x0061
                com.uptodown.activities.MyDownloads r6 = r5.f17994c
                M1.b r6 = r6.f17978L
                kotlin.jvm.internal.m.b(r6)
                java.util.ArrayList r6 = r6.f()
                java.util.Iterator r6 = r6.iterator()
                java.lang.String r1 = "iterator(...)"
                kotlin.jvm.internal.m.d(r6, r1)
                r1 = r6
            L_0x003d:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L_0x0061
                java.lang.Object r6 = r1.next()
                java.lang.String r3 = "next(...)"
                kotlin.jvm.internal.m.d(r6, r3)
                g2.s r6 = (g2.C2060s) r6
                com.uptodown.activities.MyDownloads r3 = r5.f17994c
                com.uptodown.activities.s r3 = r3.l4()
                com.uptodown.activities.MyDownloads r4 = r5.f17994c
                r5.f17992a = r1
                r5.f17993b = r2
                java.lang.Object r6 = r3.g(r4, r6, r5)
                if (r6 != r0) goto L_0x003d
                return r0
            L_0x0061:
                com.uptodown.activities.MyDownloads r6 = r5.f17994c
                r0 = 0
                r6.y4(r0)
                com.uptodown.activities.MyDownloads r6 = r5.f17994c
                r6.D4()
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyDownloads.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements C2020k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17995a;

        f(MyDownloads myDownloads) {
            this.f17995a = myDownloads;
        }

        public void a(int i4) {
            C1525b C32 = this.f17995a.f17978L;
            kotlin.jvm.internal.m.b(C32);
            if (C32.g()) {
                C1525b C33 = this.f17995a.f17978L;
                kotlin.jvm.internal.m.b(C33);
                C33.l(i4);
                this.f17995a.A4();
            } else if (UptodownApp.f17422D.a0()) {
                C1525b C34 = this.f17995a.f17978L;
                kotlin.jvm.internal.m.b(C34);
                Object obj = C34.d().get(i4);
                kotlin.jvm.internal.m.d(obj, "get(...)");
                this.f17995a.a4((C2060s) obj, i4);
            }
        }

        public void b(int i4) {
            if (UptodownApp.f17422D.a0()) {
                this.f17995a.T3(i4);
            }
        }

        public void c(int i4) {
            if (this.f17995a.f17978L != null) {
                C1525b C32 = this.f17995a.f17978L;
                kotlin.jvm.internal.m.b(C32);
                if (!C32.g()) {
                    C1525b C33 = this.f17995a.f17978L;
                    kotlin.jvm.internal.m.b(C33);
                    C1525b C34 = this.f17995a.f17978L;
                    kotlin.jvm.internal.m.b(C34);
                    C33.m(!C34.g());
                    C1525b C35 = this.f17995a.f17978L;
                    kotlin.jvm.internal.m.b(C35);
                    C35.l(i4);
                    this.f17995a.C4();
                    this.f17995a.f17980N = true;
                    this.f17995a.j4().f10026e.smoothScrollToPosition(i4);
                }
            }
        }

        public void d(int i4) {
            if (UptodownApp.f17422D.a0()) {
                C1525b C32 = this.f17995a.f17978L;
                kotlin.jvm.internal.m.b(C32);
                if (C32.d().size() > 0) {
                    C1525b C33 = this.f17995a.f17978L;
                    kotlin.jvm.internal.m.b(C33);
                    if (i4 < C33.d().size()) {
                        C1525b C34 = this.f17995a.f17978L;
                        kotlin.jvm.internal.m.b(C34);
                        Object obj = C34.d().get(i4);
                        kotlin.jvm.internal.m.d(obj, "get(...)");
                        DownloadWorker.a aVar = DownloadWorker.f19459d;
                        if (aVar.l((C2060s) obj) && aVar.h()) {
                            aVar.o();
                        }
                    }
                }
            }
        }
    }

    public static final class g implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17996a;

        g(MyDownloads myDownloads) {
            this.f17996a = myDownloads;
        }

        public boolean onQueryTextChange(String str) {
            kotlin.jvm.internal.m.e(str, "newText");
            this.f17996a.L3(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            kotlin.jvm.internal.m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f17996a.L3(str);
            return true;
        }
    }

    public static final class h implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17997a;

        h(MyDownloads myDownloads) {
            this.f17997a = myDownloads;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            kotlin.jvm.internal.m.e(recyclerView, CampaignEx.JSON_KEY_REWARD_TEMPLATE);
            kotlin.jvm.internal.m.e(motionEvent, "e");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f17997a.f17980N = false;
            } else if (action == 2 && this.f17997a.f17980N) {
                return true;
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z4) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            kotlin.jvm.internal.m.e(recyclerView, CampaignEx.JSON_KEY_REWARD_TEMPLATE);
            kotlin.jvm.internal.m.e(motionEvent, "e");
        }
    }

    public static final class i extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f17998a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(MyDownloads myDownloads) {
            super(true);
            this.f17998a = myDownloads;
        }

        public void handleOnBackPressed() {
            C1525b C32 = this.f17998a.f17978L;
            if (C32 == null || !C32.g()) {
                this.f17998a.finish();
            } else {
                this.f17998a.D4();
            }
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f18000b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyDownloads f18001a;

            a(MyDownloads myDownloads) {
                this.f18001a = myDownloads;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18001a.j4().f10023b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    this.f18001a.j4().f10023b.setVisibility(8);
                    this.f18001a.j4().f10024c.getRoot().setVisibility(0);
                    E.c cVar = (E.c) e5;
                    this.f18001a.z4(((C1843s.a) cVar.a()).a(), ((C1843s.a) cVar.a()).b());
                    if (!this.f18001a.isFinishing()) {
                        if (((C1843s.a) cVar.a()).a().size() == 0 && ((C1843s.a) cVar.a()).b().size() == 0) {
                            this.f18001a.j4().f10029h.setVisibility(0);
                            this.f18001a.j4().f10026e.setVisibility(8);
                        } else {
                            this.f18001a.j4().f10029h.setVisibility(8);
                            this.f18001a.j4().f10026e.setVisibility(0);
                        }
                        this.f18001a.j4().f10023b.setVisibility(8);
                    }
                } else if (!(e5 instanceof E.b)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MyDownloads myDownloads, V2.d dVar) {
            super(2, dVar);
            this.f18000b = myDownloads;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f18000b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17999a;
            if (i4 == 0) {
                R2.n.b(obj);
                I j4 = this.f18000b.l4().j();
                a aVar = new a(this.f18000b);
                this.f17999a = 1;
                if (j4.collect(aVar, this) == c5) {
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
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class k extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18002a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(ComponentActivity componentActivity) {
            super(0);
            this.f18002a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18002a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class l extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18003a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(ComponentActivity componentActivity) {
            super(0);
            this.f18003a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18003a.getViewModelStore();
        }
    }

    public static final class m extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18004a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18005b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18004a = aVar;
            this.f18005b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18004a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18005b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyDownloads.m.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class n extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18006a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f18007b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18008c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2060s f18009d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MyDownloads myDownloads, int i4, C2060s sVar, V2.d dVar) {
            super(2, dVar);
            this.f18007b = myDownloads;
            this.f18008c = i4;
            this.f18009d = sVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new n(this.f18007b, this.f18008c, this.f18009d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18006a == 0) {
                R2.n.b(obj);
                if (this.f18007b.f17978L != null) {
                    int i4 = this.f18008c;
                    if (i4 == 202 || i4 == 203) {
                        this.f18007b.y4(false);
                    } else if (i4 != 207) {
                        C2060s sVar = this.f18009d;
                        if (sVar != null) {
                            int B32 = this.f18007b.k4(sVar.w());
                            if (B32 > -1) {
                                C1525b C32 = this.f18007b.f17978L;
                                kotlin.jvm.internal.m.b(C32);
                                C32.d().set(B32, this.f18009d);
                                C1525b C33 = this.f18007b.f17978L;
                                kotlin.jvm.internal.m.b(C33);
                                C33.notifyItemChanged(B32);
                            } else {
                                this.f18007b.y4(false);
                            }
                        }
                    } else {
                        C1525b C34 = this.f18007b.f17978L;
                        kotlin.jvm.internal.m.b(C34);
                        if (C1601o.B(C34.d(), this.f18009d)) {
                            C1525b C35 = this.f18007b.f17978L;
                            kotlin.jvm.internal.m.b(C35);
                            C1525b C36 = this.f18007b.f17978L;
                            kotlin.jvm.internal.m.b(C36);
                            C35.notifyItemRemoved(C1601o.K(C36.d(), this.f18009d));
                            C1525b C37 = this.f18007b.f17978L;
                            kotlin.jvm.internal.m.b(C37);
                            ArrayList d5 = C37.d();
                            G.a(d5).remove(this.f18009d);
                            C1525b C38 = this.f18007b.f17978L;
                            kotlin.jvm.internal.m.b(C38);
                            if (C38.d().isEmpty()) {
                                this.f18007b.j4().f10029h.setVisibility(0);
                            }
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((n) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final void A4() {
        int i4;
        boolean z4;
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            kotlin.jvm.internal.m.b(bVar);
            i4 = bVar.c();
            TextView textView = j4().f10024c.f10040d;
            C1525b bVar2 = this.f17978L;
            kotlin.jvm.internal.m.b(bVar2);
            if (bVar2.d().size() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            textView.setEnabled(z4);
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            j4().f10024c.f10041e.setEnabled(true);
            j4().f10024c.f10041e.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_blue_primary_button));
        } else {
            j4().f10024c.f10041e.setEnabled(false);
            j4().f10024c.f10041e.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_light_grey));
        }
        j4().f10024c.f10042f.setText(getString(R.string.core_x_items_selected, new Object[]{String.valueOf(i4)}));
    }

    private final void B4(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(str));
            intent.setType(getContentResolver().getType(uriForFile));
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser_title_share_file)));
        }
    }

    /* access modifiers changed from: private */
    public final void C4() {
        j4().f10024c.getRoot().setVisibility(0);
        j4().f10024c.f10039c.setVisibility(0);
        j4().f10024c.f10038b.getRoot().setVisibility(4);
        A4();
    }

    /* access modifiers changed from: private */
    public final void D4() {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.m(false);
        }
        j4().f10024c.getRoot().setVisibility(0);
        j4().f10024c.f10038b.getRoot().setVisibility(0);
        j4().f10024c.f10039c.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void L3(String str) {
        l4().n(str);
        y4(false);
    }

    /* access modifiers changed from: private */
    public static final T M3(MyDownloads myDownloads) {
        return T.c(myDownloads.getLayoutInflater());
    }

    private final void N3(File file) {
        G.a aVar = W1.G.f8470b;
        String name = file.getName();
        kotlin.jvm.internal.m.d(name, "getName(...)");
        if (aVar.a(name)) {
            W1.G g4 = new W1.G();
            boolean f4 = g4.f(file);
            if (g4.c(file) && !new C1612h().e().canWrite()) {
                if (T()) {
                    X2(0);
                } else {
                    k0();
                }
                f4 = false;
            }
            if (f4) {
                C1826a.y2(this, file, (String) null, 2, (Object) null);
                return;
            }
            return;
        }
        C1826a.y2(this, file, (String) null, 2, (Object) null);
    }

    private final void O3(boolean z4) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new c(this, z4, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void P3(int i4) {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            kotlin.jvm.internal.m.b(bVar);
            if (bVar.d().size() > 0) {
                C1525b bVar2 = this.f17978L;
                kotlin.jvm.internal.m.b(bVar2);
                if (i4 < bVar2.d().size()) {
                    C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new d(this, i4, (V2.d) null), 3, (Object) null);
                }
            }
        }
    }

    private final void Q3() {
        String str;
        DownloadWorker.f19459d.n();
        if (new q().i(this).size() > 1) {
            F f4 = F.f20971a;
            String string = getString(R.string.dialog_cancel_downloads_msg);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            str = String.format(string, Arrays.copyOf(new Object[0], 0));
            kotlin.jvm.internal.m.d(str, "format(...)");
        } else {
            F f5 = F.f20971a;
            String string2 = getString(R.string.dialog_cancel_download_msg);
            kotlin.jvm.internal.m.d(string2, "getString(...)");
            str = String.format(string2, Arrays.copyOf(new Object[0], 0));
            kotlin.jvm.internal.m.d(str, "format(...)");
        }
        P1(str, new G2(this), new H2(this));
    }

    /* access modifiers changed from: private */
    public static final s R3(MyDownloads myDownloads) {
        myDownloads.O3(true);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s S3(MyDownloads myDownloads) {
        myDownloads.O3(false);
        DownloadWorker.f19459d.o();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void T3(int i4) {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            kotlin.jvm.internal.m.b(bVar);
            Object obj = bVar.d().get(i4);
            kotlin.jvm.internal.m.d(obj, "get(...)");
            C2060s sVar = (C2060s) obj;
            DownloadWorker.a aVar = DownloadWorker.f19459d;
            if (aVar.k(sVar.h(), sVar.E())) {
                aVar.n();
            }
            String string = getString(R.string.download_cancel_confimation_title);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            P1(string, new C1467w2(this, i4), new C1474x2());
        }
    }

    /* access modifiers changed from: private */
    public static final s U3(MyDownloads myDownloads, int i4) {
        myDownloads.P3(i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s V3() {
        DownloadWorker.f19459d.o();
        return s.f8222a;
    }

    private final void W3() {
        F f4 = F.f20971a;
        String string = getString(R.string.dialog_delete_all_download_msg);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.m.d(format, "format(...)");
        O1(format, new P2(this));
    }

    /* access modifiers changed from: private */
    public static final s X3(MyDownloads myDownloads) {
        if (UptodownApp.f17422D.U("downloadApkWorker", myDownloads)) {
            myDownloads.Q3();
        } else {
            myDownloads.O3(false);
        }
        return s.f8222a;
    }

    private final void Y3() {
        F f4 = F.f20971a;
        String string = getString(R.string.dialog_delete_selected_download_msg);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.m.d(format, "format(...)");
        O1(format, new C1460v2(this));
    }

    /* access modifiers changed from: private */
    public static final s Z3(MyDownloads myDownloads) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(myDownloads), (V2.g) null, (L) null, new e(myDownloads, (V2.d) null), 3, (Object) null);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void a4(C2060s sVar, int i4) {
        Object obj;
        C c5 = new C();
        C1681o c6 = C1681o.c(getLayoutInflater());
        kotlin.jvm.internal.m.d(c6, "inflate(...)");
        c6.f10685i.setText(sVar.i());
        TextView textView = c6.f10685i;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        if (i4(sVar) || sVar.K()) {
            c6.f10681e.setVisibility(8);
        } else {
            c6.f10681e.setTypeface(aVar.x());
            c6.f10681e.setOnClickListener(new C1481y2(c5, sVar, this));
        }
        c6.f10683g.setTypeface(aVar.x());
        c6.f10683g.setOnClickListener(new C1488z2(this, i4, c5));
        c6.f10682f.setTypeface(aVar.x());
        DownloadWorker.a aVar2 = DownloadWorker.f19459d;
        if (aVar2.l(sVar)) {
            c6.f10682f.setVisibility(0);
            if (aVar2.h()) {
                c6.f10682f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_resume_dialog_option), (Drawable) null, (Drawable) null, (Drawable) null);
                c6.f10682f.setText(getString(R.string.updates_button_resume));
            } else {
                c6.f10682f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_pause_dialog_option), (Drawable) null, (Drawable) null, (Drawable) null);
                c6.f10682f.setText(getString(R.string.action_pause));
            }
            c6.f10682f.setOnClickListener(new A2(c5));
        } else {
            c6.f10682f.setVisibility(8);
        }
        c6.f10684h.setTypeface(aVar.x());
        c6.f10684h.setOnClickListener(new B2(c5, sVar, this));
        if (sVar.h() >= 0) {
            c6.f10678b.setTypeface(aVar.x());
            c6.f10678b.setOnClickListener(new C2(c5, this, sVar));
        } else {
            c6.f10678b.setVisibility(8);
        }
        c6.f10679c.setTypeface(aVar.x());
        c6.f10679c.setOnClickListener(new D2(c5, this, i4));
        C1525b bVar = this.f17978L;
        kotlin.jvm.internal.m.b(bVar);
        if (((C2060s.c) ((C2060s) bVar.d().get(i4)).o().get(0)).a() != null) {
            c6.f10680d.setTypeface(aVar.x());
            c6.f10680d.setOnClickListener(new E2(c5, this, i4));
        } else {
            c6.f10680d.setVisibility(8);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(c6.getRoot());
        builder.setCancelable(true);
        c5.f20968a = builder.create();
        if (!isFinishing() && (obj = c5.f20968a) != null) {
            Window window = ((AlertDialog) obj).getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            ((AlertDialog) c5.f20968a).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(MyDownloads myDownloads, int i4, C c5, View view) {
        C1525b bVar = myDownloads.f17978L;
        kotlin.jvm.internal.m.b(bVar);
        bVar.m(true);
        C1525b bVar2 = myDownloads.f17978L;
        kotlin.jvm.internal.m.b(bVar2);
        bVar2.l(i4);
        myDownloads.C4();
        myDownloads.A4();
        AlertDialog alertDialog = (AlertDialog) c5.f20968a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void c4(C c5, View view) {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        if (aVar.h()) {
            aVar.o();
        } else {
            aVar.n();
        }
        AlertDialog alertDialog = (AlertDialog) c5.f20968a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void d4(C c5, C2060s sVar, MyDownloads myDownloads, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog alertDialog = (AlertDialog) c5.f20968a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (sVar.f() && sVar.o().size() == 1) {
                myDownloads.B4(((C2060s.c) sVar.o().get(0)).a());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void e4(C c5, MyDownloads myDownloads, C2060s sVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog alertDialog = (AlertDialog) c5.f20968a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            myDownloads.C2(sVar.h());
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(C c5, MyDownloads myDownloads, int i4, View view) {
        AlertDialog alertDialog = (AlertDialog) c5.f20968a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        myDownloads.P3(i4);
    }

    /* access modifiers changed from: private */
    public static final void g4(C c5, MyDownloads myDownloads, int i4, View view) {
        String str;
        AlertDialog alertDialog = (AlertDialog) c5.f20968a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        C1525b bVar = myDownloads.f17978L;
        kotlin.jvm.internal.m.b(bVar);
        if (((C2060s.c) ((C2060s) bVar.d().get(i4)).o().get(0)).a() != null) {
            C1525b bVar2 = myDownloads.f17978L;
            kotlin.jvm.internal.m.b(bVar2);
            String a5 = ((C2060s.c) ((C2060s) bVar2.d().get(i4)).o().get(0)).a();
            kotlin.jvm.internal.m.b(a5);
            File parentFile = new File(a5).getParentFile();
            if (parentFile != null) {
                str = parentFile.getAbsolutePath();
            } else {
                str = null;
            }
            if (str != null) {
                Intent intent = new Intent(myDownloads.getApplicationContext(), FileExplorerActivity.class);
                intent.putExtra("subdir", str);
                myDownloads.startActivity(intent);
                return;
            }
            String string = myDownloads.getString(R.string.installable_files_not_found);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            myDownloads.q0(string);
        }
    }

    /* access modifiers changed from: private */
    public static final void h4(C c5, C2060s sVar, MyDownloads myDownloads, View view) {
        String a5;
        AlertDialog alertDialog = (AlertDialog) c5.f20968a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (kotlin.jvm.internal.m.a(sVar.w(), myDownloads.getPackageName())) {
            if (sVar.o().isEmpty() || ((C2060s.c) sVar.o().get(0)).a() == null) {
                String string = myDownloads.getString(R.string.installable_files_not_found);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                myDownloads.q0(string);
                return;
            }
            String a6 = ((C2060s.c) sVar.o().get(0)).a();
            kotlin.jvm.internal.m.b(a6);
            File file = new File(a6);
            if (file.exists()) {
                PackageManager packageManager = myDownloads.getPackageManager();
                kotlin.jvm.internal.m.d(packageManager, "getPackageManager(...)");
                String absolutePath = file.getAbsolutePath();
                kotlin.jvm.internal.m.d(absolutePath, "getAbsolutePath(...)");
                PackageInfo c6 = W1.s.c(packageManager, absolutePath, 128);
                if (c6 == null) {
                    String string2 = myDownloads.getString(R.string.installable_files_not_found);
                    kotlin.jvm.internal.m.d(string2, "getString(...)");
                    myDownloads.q0(string2);
                    return;
                }
                w wVar = new w();
                String name = file.getName();
                kotlin.jvm.internal.m.d(name, "getName(...)");
                String i4 = wVar.i(name);
                if (i4 == null) {
                    C1826a.y2(myDownloads, file, (String) null, 2, (Object) null);
                } else if (new C1612h().m(c6) > 671) {
                    C1826a.y2(myDownloads, file, (String) null, 2, (Object) null);
                } else {
                    myDownloads.D2(i4, (C2054l) null);
                }
            } else {
                String string3 = myDownloads.getString(R.string.installable_files_not_found);
                kotlin.jvm.internal.m.d(string3, "getString(...)");
                myDownloads.q0(string3);
            }
        } else if (sVar.o().isEmpty() || (a5 = ((C2060s.c) sVar.o().get(0)).a()) == null || a5.length() == 0) {
            String string4 = myDownloads.getString(R.string.installable_files_not_found);
            kotlin.jvm.internal.m.d(string4, "getString(...)");
            myDownloads.q0(string4);
        } else {
            String a7 = ((C2060s.c) sVar.o().get(0)).a();
            kotlin.jvm.internal.m.b(a7);
            File file2 = new File(a7);
            if (file2.exists()) {
                myDownloads.N3(file2);
                return;
            }
            String string5 = myDownloads.getString(R.string.installable_files_not_found);
            kotlin.jvm.internal.m.d(string5, "getString(...)");
            myDownloads.q0(string5);
        }
    }

    private final boolean i4(C2060s sVar) {
        if (sVar == null || sVar.x() <= 0 || sVar.x() >= 100) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final T j4() {
        return (T) this.f17976J.getValue();
    }

    /* access modifiers changed from: private */
    public final int k4(String str) {
        if (!(str == null || str.length() == 0)) {
            C1525b bVar = this.f17978L;
            kotlin.jvm.internal.m.b(bVar);
            ArrayList d5 = bVar.d();
            int size = d5.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = d5.get(i4);
                kotlin.jvm.internal.m.d(obj, "get(...)");
                if (m3.m.p(((C2060s) obj).w(), str, true)) {
                    return i4;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final C1843s l4() {
        return (C1843s) this.f17977K.getValue();
    }

    private final void m4() {
        setContentView((View) j4().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            j4().f10028g.setNavigationIcon(drawable);
            j4().f10028g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        k.a aVar = N1.k.f7778g;
        ((TextView) findViewById(R.id.tv_toolbar_title_downloads)).setTypeface(aVar.w());
        j4().f10028g.setNavigationOnClickListener(new F2(this));
        j4().f10028g.inflateMenu(R.menu.toolbar_menu_my_downloads);
        j4().f10028g.setOnMenuItemClickListener(new I2(this));
        j4().f10027f.setOnQueryTextListener(new g(this));
        j4().f10027f.setOnClickListener(new J2(this));
        ((ImageView) j4().f10027f.findViewById(R.id.search_close_btn)).setBackgroundResource(R.drawable.core_shape_transparent);
        EditText editText = (EditText) j4().f10027f.findViewById(R.id.search_src_text);
        editText.setTypeface(aVar.x());
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        j4().f10024c.f10038b.f9695c.setTypeface(aVar.x());
        j4().f10024c.f10038b.f9696d.setTypeface(aVar.w());
        j4().f10024c.f10038b.f9696d.setText(getString(R.string.order_by_date));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.order_by_name));
        hashMap.put(1, getString(R.string.order_by_date));
        hashMap.put(2, getString(R.string.order_by_size));
        j4().f10024c.f10038b.getRoot().setOnClickListener(new K2(this, hashMap));
        j4().f10026e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        j4().f10026e.addItemDecoration(new w2.l(dimension, dimension));
        j4().f10026e.setItemAnimator((RecyclerView.ItemAnimator) null);
        j4().f10026e.addOnItemTouchListener(new h(this));
        j4().f10029h.setTypeface(aVar.x());
        TextView textView = j4().f10024c.f10041e;
        j4().f10024c.f10042f.setTypeface(aVar.x());
        j4().f10024c.f10040d.setTypeface(aVar.w());
        j4().f10024c.f10040d.setOnClickListener(new L2(this));
        j4().f10024c.f10041e.setTypeface(aVar.w());
        j4().f10024c.f10041e.setOnClickListener(new M2(this));
        j4().f10023b.setOnClickListener(new N2());
        D4();
        NestedScrollView nestedScrollView = j4().f10025d;
        kotlin.jvm.internal.m.d(nestedScrollView, "nsvMyDownloads");
        hideKeyboardOnScroll(nestedScrollView);
        l0();
        getOnBackPressedDispatcher().addCallback(this, this.f17981O);
    }

    /* access modifiers changed from: private */
    public static final void n4(MyDownloads myDownloads, View view) {
        myDownloads.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final boolean o4(MyDownloads myDownloads, MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_file_explorer) {
            myDownloads.startActivity(new Intent(myDownloads, FileExplorerActivity.class));
        }
        if (menuItem.getItemId() != R.id.action_search) {
            return true;
        }
        if (myDownloads.j4().f10027f.getVisibility() == 0) {
            myDownloads.j4().f10027f.setVisibility(8);
            myDownloads.j4().f10027f.clearFocus();
            return true;
        }
        myDownloads.j4().f10027f.setVisibility(0);
        myDownloads.j4().f10027f.requestFocus();
        SearchView searchView = myDownloads.j4().f10027f;
        kotlin.jvm.internal.m.d(searchView, "searchViewMyDownloads");
        myDownloads.showKeyboard(searchView);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void p4(MyDownloads myDownloads, View view) {
        myDownloads.j4().f10027f.setIconified(false);
    }

    /* access modifiers changed from: private */
    public static final void q4(MyDownloads myDownloads, HashMap hashMap, View view) {
        kotlin.jvm.internal.m.b(view);
        new y2.q(myDownloads, view, hashMap, new O2(myDownloads)).c();
    }

    /* access modifiers changed from: private */
    public static final s r4(MyDownloads myDownloads, int i4, String str) {
        C1843s.b bVar;
        kotlin.jvm.internal.m.e(str, "selectedOption");
        if (i4 == 0) {
            C1843s.b bVar2 = myDownloads.f17979M;
            C1843s.b bVar3 = C1843s.b.NAME;
            if (bVar2 != bVar3) {
                myDownloads.f17979M = bVar3;
            }
        } else if (i4 == 1) {
            C1843s.b bVar4 = myDownloads.f17979M;
            C1843s.b bVar5 = C1843s.b.DATE;
            if (bVar4 != bVar5) {
                myDownloads.f17979M = bVar5;
            }
        } else if (i4 == 2 && myDownloads.f17979M != (bVar = C1843s.b.SIZE)) {
            myDownloads.f17979M = bVar;
        }
        if (((Number) myDownloads.l4().k().getValue()).intValue() != i4) {
            myDownloads.l4().k().setValue(Integer.valueOf(i4));
            myDownloads.j4().f10024c.f10038b.f9696d.setText(str);
            myDownloads.L3(myDownloads.j4().f10027f.getQuery().toString());
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void s4(MyDownloads myDownloads, View view) {
        myDownloads.W3();
    }

    /* access modifiers changed from: private */
    public static final void t4(MyDownloads myDownloads, View view) {
        myDownloads.Y3();
    }

    /* access modifiers changed from: private */
    public static final void u4(View view) {
    }

    /* access modifiers changed from: private */
    public final void x4() {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void z4(ArrayList arrayList, ArrayList arrayList2) {
        if (!isFinishing()) {
            if (this.f17978L == null) {
                this.f17978L = new C1525b(this.f17982P);
                j4().f10026e.setAdapter(this.f17978L);
            }
            C1525b bVar = this.f17978L;
            kotlin.jvm.internal.m.b(bVar);
            bVar.j(arrayList, arrayList2);
        }
    }

    public final void E4(int i4, C2060s sVar) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new n(this, i4, sVar, (V2.d) null), 2, (Object) null);
    }

    public void H2() {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void P2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.k(file, this);
        }
    }

    public void R2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.i();
        }
        C1525b bVar2 = this.f17978L;
        if (bVar2 != null) {
            bVar2.h(file, this);
        }
    }

    public void S2(File file, int i4) {
        kotlin.jvm.internal.m.e(file, "file");
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            bVar.h(file, this);
        }
    }

    public void Z2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        if (!isFinishing()) {
            Intent intent = new Intent(this, AppDetailActivity.class);
            intent.putExtra("appInfo", hVar);
            startActivity(intent, UptodownApp.f17422D.a(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("remoteInstallPath")) {
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                str = extras2.getString("remoteInstallPath");
            } else {
                str = null;
            }
            Log.d("utd_debug", "MyDownloads onCreate: " + str);
            kotlin.jvm.internal.m.b(str);
            File file = new File(str);
            if (file.exists()) {
                C1826a.y2(this, file, (String) null, 2, (Object) null);
            }
            C2313C.f21882a.c(this);
        }
        m4();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new j(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            t a5 = t.f21927u.a(this);
            a5.a();
            a5.n1();
            a5.i();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C2313C.f21882a.h(this);
        y4(true);
    }

    public final void v4() {
        Integer num;
        C1525b bVar;
        C1525b bVar2 = this.f17978L;
        if (bVar2 != null) {
            num = Integer.valueOf(bVar2.e());
        } else {
            num = null;
        }
        if (!(num == null || num.intValue() < 0 || (bVar = this.f17978L) == null)) {
            bVar.notifyItemChanged(num.intValue());
        }
        C1525b bVar3 = this.f17978L;
        if (bVar3 != null) {
            bVar3.i();
        }
    }

    public final void w4(String str) {
        C1525b bVar = this.f17978L;
        if (bVar != null) {
            kotlin.jvm.internal.m.b(bVar);
            if (!bVar.d().isEmpty()) {
                C1525b bVar2 = this.f17978L;
                kotlin.jvm.internal.m.b(bVar2);
                int e5 = bVar2.e();
                if (e5 >= 0) {
                    C1525b bVar3 = this.f17978L;
                    if (bVar3 != null) {
                        bVar3.notifyItemChanged(e5);
                    }
                    String string = getString(R.string.install_compatibility_error, new Object[]{str});
                    kotlin.jvm.internal.m.d(string, "getString(...)");
                    q0(string);
                }
                C1525b bVar4 = this.f17978L;
                if (bVar4 != null) {
                    bVar4.i();
                }
            }
        }
    }

    public final void y4(boolean z4) {
        l4().h(this, this.f17979M, z4);
    }
}
