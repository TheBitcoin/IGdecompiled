package com.uptodown.activities;

import J1.C1315a3;
import J1.C1322b3;
import J1.C1329c3;
import J1.C1336d3;
import J1.V2;
import J1.W2;
import J1.X2;
import J1.Y2;
import J1.Z2;
import M1.C1540q;
import N1.k;
import R2.n;
import R2.s;
import S2.C1601o;
import W1.C1612h;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1683p;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1845u;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.W;
import f2.x;
import g2.C2035C;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import g2.K;
import g2.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import u2.t;

public final class OldVersionsActivity extends C1826a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f18042N = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18043J = R2.h.a(new V2(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18044K = new ViewModelLazy(D.b(C1845u.class), new i(this), new h(this), new j((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1540q f18045L;

    /* renamed from: M  reason: collision with root package name */
    private e f18046M = new e(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f18047a;

        /* renamed from: b  reason: collision with root package name */
        private final long f18048b;

        /* renamed from: c  reason: collision with root package name */
        private final File f18049c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f18050d;

        public b(OldVersionsActivity oldVersionsActivity, String str, long j4, File file) {
            m.e(str, "packagename");
            m.e(file, "downloadFile");
            this.f18050d = oldVersionsActivity;
            this.f18047a = str;
            this.f18048b = j4;
            this.f18049c = file;
        }

        public void run() {
            if (this.f18050d.D3().d().getValue() != null) {
                Object value = this.f18050d.D3().d().getValue();
                m.b(value);
                if (((C2050h) value).Q() != null) {
                    Object value2 = this.f18050d.D3().d().getValue();
                    m.b(value2);
                    if (m3.m.p(((C2050h) value2).Q(), this.f18047a, true)) {
                        OldVersionsActivity oldVersionsActivity = this.f18050d;
                        Object value3 = oldVersionsActivity.D3().d().getValue();
                        m.b(value3);
                        String Q4 = ((C2050h) value3).Q();
                        m.b(Q4);
                        oldVersionsActivity.N3(Q4, this.f18048b, this.f18049c);
                    }
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f18051a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f18052b;

        public c(int i4, C2060s sVar) {
            this.f18051a = i4;
            this.f18052b = sVar;
        }

        public void run() {
            Long l4;
            int i4 = this.f18051a;
            if (i4 == 203) {
                OldVersionsActivity.this.U3(this.f18052b);
            } else if (i4 == 208) {
                OldVersionsActivity oldVersionsActivity = OldVersionsActivity.this;
                String string = oldVersionsActivity.getString(R.string.no_free_space);
                m.d(string, "getString(...)");
                oldVersionsActivity.q0(string);
            } else if (OldVersionsActivity.this.f18045L != null && !OldVersionsActivity.this.D3().g()) {
                C2060s sVar = this.f18052b;
                Long l5 = null;
                if (sVar != null) {
                    l4 = Long.valueOf(sVar.h());
                } else {
                    l4 = null;
                }
                C2050h hVar = (C2050h) OldVersionsActivity.this.D3().d().getValue();
                if (hVar != null) {
                    l5 = Long.valueOf(hVar.e());
                }
                if (m.a(l4, l5)) {
                    OldVersionsActivity.this.U3(this.f18052b);
                }
            }
        }
    }

    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f18054a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18055b;

        public d(String str, int i4) {
            this.f18054a = str;
            this.f18055b = i4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
            if (m3.m.p(((g2.C2048f) r0).o(), r4.f18054a, true) == false) goto L_0x00a9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                java.lang.String r0 = r4.f18054a
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r1 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r1 = r1.D3()
                r3.t r1 = r1.d()
                java.lang.Object r1 = r1.getValue()
                kotlin.jvm.internal.m.b(r1)
                g2.h r1 = (g2.C2050h) r1
                java.lang.String r1 = r1.Q()
                r2 = 1
                boolean r0 = m3.m.p(r0, r1, r2)
                if (r0 == 0) goto L_0x0110
                int r0 = r4.f18055b
                r1 = 306(0x132, float:4.29E-43)
                r3 = 8
                if (r0 != r1) goto L_0x0036
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                c2.W r0 = r0.B3()
                android.view.View r0 = r0.f10071b
                r0.setVisibility(r3)
                goto L_0x0045
            L_0x0036:
                r1 = 307(0x133, float:4.3E-43)
                if (r0 != r1) goto L_0x0045
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                c2.W r0 = r0.B3()
                android.view.View r0 = r0.f10071b
                r0.setVisibility(r3)
            L_0x0045:
                int r0 = r4.f18055b
                r1 = 301(0x12d, float:4.22E-43)
                if (r0 == r1) goto L_0x00f7
                r1 = 351(0x15f, float:4.92E-43)
                if (r0 != r1) goto L_0x0051
                goto L_0x00f7
            L_0x0051:
                r1 = 352(0x160, float:4.93E-43)
                if (r0 != r1) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                if (r0 == 0) goto L_0x00a9
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.m.b(r0)
                g2.f r0 = (g2.C2048f) r0
                java.lang.String r0 = r0.o()
                if (r0 == 0) goto L_0x00a9
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.m.b(r0)
                g2.f r0 = (g2.C2048f) r0
                java.lang.String r0 = r0.o()
                java.lang.String r1 = r4.f18054a
                boolean r0 = m3.m.p(r0, r1, r2)
                if (r0 != 0) goto L_0x00f1
            L_0x00a9:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.m.b(r0)
                g2.h r0 = (g2.C2050h) r0
                java.lang.String r0 = r0.Q()
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                r3.t r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.m.b(r0)
                g2.h r0 = (g2.C2050h) r0
                java.lang.String r0 = r0.Q()
                java.lang.String r1 = r4.f18054a
                boolean r0 = m3.m.p(r0, r1, r2)
                if (r0 == 0) goto L_0x0110
            L_0x00f1:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                r0.C3()
                return
            L_0x00f7:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                M1.q r0 = r0.f18045L
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.u r0 = r0.D3()
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                r0.T3()
            L_0x0110:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.d.run():void");
        }
    }

    public static final class e implements x {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f18057a;

        e(OldVersionsActivity oldVersionsActivity) {
            this.f18057a = oldVersionsActivity;
        }

        public void a() {
            if (UptodownApp.f17422D.a0()) {
                this.f18057a.D3().l(true);
                C1845u n32 = this.f18057a.D3();
                n32.n(n32.i() - 1);
                this.f18057a.D3().m(this.f18057a.D3().i() * 20);
                this.f18057a.C3();
            }
        }

        public void b(int i4) {
            if (UptodownApp.f17422D.a0()) {
                this.f18057a.K3(i4);
            }
        }

        public void c(int i4) {
            this.f18057a.J3(i4);
        }

        public void d() {
            if (UptodownApp.f17422D.a0()) {
                this.f18057a.D3().l(true);
                C1845u n32 = this.f18057a.D3();
                n32.n(n32.i() + 1);
                this.f18057a.D3().m(this.f18057a.D3().i() * 20);
                this.f18057a.C3();
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18058a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f18059b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OldVersionsActivity f18060a;

            a(OldVersionsActivity oldVersionsActivity) {
                this.f18060a = oldVersionsActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (m.a(e5, E.a.f21883a)) {
                    if (this.f18060a.D3().f()) {
                        this.f18060a.B3().f10071b.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((C1845u.a) cVar.a()).c()) {
                        this.f18060a.D3().c().setValue(((C1845u.a) cVar.a()).a());
                        this.f18060a.D3().d().setValue(((C1845u.a) cVar.a()).b());
                        if (((C1845u.a) cVar.a()).b().O() == null) {
                            this.f18060a.B3().f10074e.setVisibility(0);
                        } else if (this.f18060a.f18045L == null) {
                            this.f18060a.u3();
                            this.f18060a.B3().f10072c.setAdapter(this.f18060a.f18045L);
                        } else {
                            C1540q k32 = this.f18060a.f18045L;
                            m.b(k32);
                            k32.g(this.f18060a.D3().i());
                            C1540q k33 = this.f18060a.f18045L;
                            m.b(k33);
                            k33.f(((C1845u.a) cVar.a()).b().O());
                            C1540q k34 = this.f18060a.f18045L;
                            m.b(k34);
                            k34.e((C2048f) this.f18060a.D3().c().getValue());
                            this.f18060a.B3().f10072c.scrollToPosition(0);
                            this.f18060a.T3();
                        }
                        this.f18060a.R3();
                    } else {
                        C2050h hVar = (C2050h) this.f18060a.D3().d().getValue();
                        if (hVar != null) {
                            hVar.P0((ArrayList) null);
                        }
                        this.f18060a.B3().f10074e.setVisibility(0);
                        this.f18060a.R3();
                    }
                } else if (!m.a(e5, E.b.f21884a)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(OldVersionsActivity oldVersionsActivity, V2.d dVar) {
            super(2, dVar);
            this.f18059b = oldVersionsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18059b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18058a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18059b.D3().e();
                a aVar = new a(this.f18059b);
                this.f18058a = 1;
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
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class g implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f18061a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2035C f18062b;

        g(OldVersionsActivity oldVersionsActivity, C2035C c5) {
            this.f18061a = oldVersionsActivity;
            this.f18062b = c5;
        }

        public void a(K k4) {
            m.e(k4, "reportVT");
            Intent intent = new Intent(this.f18061a, VirusTotalReport.class);
            intent.putExtra("appInfo", (Parcelable) this.f18061a.D3().d().getValue());
            intent.putExtra("appReportVT", k4);
            intent.putExtra("old_version", this.f18062b.h());
            OldVersionsActivity oldVersionsActivity = this.f18061a;
            oldVersionsActivity.startActivity(intent, UptodownApp.f17422D.a(oldVersionsActivity));
        }

        public void b() {
            if (this.f18061a.D3().d().getValue() != null) {
                Object value = this.f18061a.D3().d().getValue();
                m.b(value);
                String l02 = ((C2050h) value).l0();
                if (!(l02 == null || l02.length() == 0)) {
                    Object value2 = this.f18061a.D3().d().getValue();
                    m.b(value2);
                    String l03 = ((C2050h) value2).l0();
                    m.b(l03);
                    if (Long.parseLong(l03) > 650000000) {
                        Intent intent = new Intent(this.f18061a, VirusTotalReport.class);
                        intent.putExtra("appInfo", (Parcelable) this.f18061a.D3().d().getValue());
                        intent.putExtra("isVirusTotalReportAvaialable", false);
                        OldVersionsActivity oldVersionsActivity = this.f18061a;
                        oldVersionsActivity.startActivity(intent, UptodownApp.f17422D.a(oldVersionsActivity));
                        return;
                    }
                }
            }
            OldVersionsActivity oldVersionsActivity2 = this.f18061a;
            Object value3 = oldVersionsActivity2.D3().d().getValue();
            m.b(value3);
            oldVersionsActivity2.F2(((C2050h) value3).i0());
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18063a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f18063a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18063a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18064a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f18064a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18064a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18065a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18066b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18065a = aVar;
            this.f18066b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18065a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18066b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18067a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f18068b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18069c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(OldVersionsActivity oldVersionsActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18068b = oldVersionsActivity;
            this.f18069c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f18068b, this.f18069c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a5, code lost:
            if (m3.m.p(((g2.C2050h) r3).Q(), r2.f18069c, true) != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a7, code lost:
            com.uptodown.activities.OldVersionsActivity.m3(r2.f18068b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x005d, code lost:
            if (m3.m.p(((g2.C2048f) r3).o(), r2.f18069c, true) == false) goto L_0x005f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                W2.b.c()
                int r0 = r2.f18067a
                if (r0 != 0) goto L_0x00af
                R2.n.b(r3)
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                boolean r3 = r3.g()
                if (r3 != 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                r0 = 1
                if (r3 == 0) goto L_0x005f
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.m.b(r3)
                g2.f r3 = (g2.C2048f) r3
                java.lang.String r3 = r3.o()
                if (r3 == 0) goto L_0x005f
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.m.b(r3)
                g2.f r3 = (g2.C2048f) r3
                java.lang.String r3 = r3.o()
                java.lang.String r1 = r2.f18069c
                boolean r3 = m3.m.p(r3, r1, r0)
                if (r3 != 0) goto L_0x00a7
            L_0x005f:
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.m.b(r3)
                g2.h r3 = (g2.C2050h) r3
                java.lang.String r3 = r3.Q()
                if (r3 == 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                com.uptodown.activities.u r3 = r3.D3()
                r3.t r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.m.b(r3)
                g2.h r3 = (g2.C2050h) r3
                java.lang.String r3 = r3.Q()
                java.lang.String r1 = r2.f18069c
                boolean r3 = m3.m.p(r3, r1, r0)
                if (r3 == 0) goto L_0x00ac
            L_0x00a7:
                com.uptodown.activities.OldVersionsActivity r3 = r2.f18068b
                r3.C3()
            L_0x00ac:
                R2.s r3 = R2.s.f8222a
                return r3
            L_0x00af:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(C1683p pVar, OldVersionsActivity oldVersionsActivity, View view) {
        if (pVar.f10694b.isChecked()) {
            com.uptodown.activities.preferences.a.f18818a.f1(oldVersionsActivity, true);
        }
        AlertDialog j22 = oldVersionsActivity.j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final c2.W B3() {
        return (c2.W) this.f18043J.getValue();
    }

    /* access modifiers changed from: private */
    public final void C3() {
        D3().l(true);
        if (D3().d().getValue() != null) {
            D3().b(this);
        }
    }

    /* access modifiers changed from: private */
    public final C1845u D3() {
        return (C1845u) this.f18044K.getValue();
    }

    private final void E3() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_old_versions);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            toolbar.setNavigationOnClickListener(new X2(this));
        }
        k.a aVar = N1.k.f7778g;
        ((TextView) findViewById(R.id.tv_toolbar_old_versions)).setTypeface(aVar.w());
        B3().f10074e.setTypeface(aVar.x());
        B3().f10072c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        B3().f10072c.setItemAnimator((RecyclerView.ItemAnimator) null);
        B3().f10072c.addItemDecoration(new w2.l((int) getResources().getDimension(R.dimen.margin_m), (int) getResources().getDimension(R.dimen.margin_xl)));
        B3().f10071b.setOnClickListener(new Y2());
    }

    /* access modifiers changed from: private */
    public static final void F3(OldVersionsActivity oldVersionsActivity, View view) {
        oldVersionsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void G3(View view) {
    }

    private final boolean I3(String str, long j4) {
        PackageManager packageManager = getPackageManager();
        try {
            m.b(packageManager);
            if (j4 < new C1612h().m(W1.s.d(packageManager, str, 128))) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void L3(C2035C c5) {
        if (!isFinishing() && D3().d().getValue() != null) {
            C2050h.b bVar = C2050h.f20600F0;
            Object value = D3().d().getValue();
            m.b(value);
            if (bVar.d(((C2050h) value).n())) {
                new b2.p(this, c5.a(), (String) null, new g(this, c5), LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
    }

    private final void M3(C2035C c5, C2060s sVar) {
        if (c5.e() != null) {
            r rVar = new r();
            rVar.k(this);
            ArrayList e5 = c5.e();
            m.b(e5);
            boolean f4 = rVar.f(e5, this);
            if (!com.uptodown.activities.preferences.a.f18818a.s1(this)) {
                O3(sVar);
            } else if (f4) {
                O3(sVar);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("type", "required_feature");
                bundle.putString("fileId", c5.a());
                if (sVar.h() >= 0) {
                    bundle.putString("appId", String.valueOf(sVar.h()));
                }
                bundle.putString("packagename", sVar.w());
                u2.x m22 = m2();
                if (m22 != null) {
                    m22.d("warning", bundle);
                }
                String string = getString(R.string.msg_warning_incompatible_required_features);
                m.d(string, "getString(...)");
                x3(sVar, string);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void N3(String str, long j4, File file) {
        if (I3(str, j4)) {
            v3(str, file);
        } else if (file.exists()) {
            UptodownApp.a.Y(UptodownApp.f17422D, file, this, (String) null, 4, (Object) null);
        }
    }

    private final void O3(C2060s sVar) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        Object value = D3().d().getValue();
        m.b(value);
        C2060s sVar2 = sVar;
        aVar.b0(sVar2, (C2050h) value, this, new C1329c3(), new C1336d3());
    }

    /* access modifiers changed from: private */
    public static final s P3(int i4) {
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s Q3() {
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void R3() {
        D3().k(false);
        B3().f10071b.setVisibility(8);
        D3().l(false);
    }

    private final void S3(String str) {
        new N1.j(this).h(str);
    }

    /* access modifiers changed from: private */
    public final void T3() {
        C1540q qVar = this.f18045L;
        if (qVar != null) {
            qVar.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void U3(C2060s sVar) {
        C2035C c5;
        Object obj;
        Long l4;
        ArrayList o4;
        C2060s.c cVar;
        Object value = D3().d().getValue();
        m.b(value);
        ArrayList O4 = ((C2050h) value).O();
        Integer num = null;
        if (O4 != null) {
            int size = O4.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    obj = null;
                    break;
                }
                obj = O4.get(i4);
                i4++;
                String a5 = ((C2035C) obj).a();
                if (sVar == null || (o4 = sVar.o()) == null || (cVar = (C2060s.c) o4.get(0)) == null) {
                    l4 = null;
                } else {
                    l4 = Long.valueOf(cVar.d());
                }
                if (m.a(a5, String.valueOf(l4))) {
                    break;
                }
            }
            c5 = (C2035C) obj;
        } else {
            c5 = null;
        }
        Object value2 = D3().d().getValue();
        m.b(value2);
        ArrayList O5 = ((C2050h) value2).O();
        if (O5 != null) {
            num = Integer.valueOf(C1601o.K(O5, c5));
        }
        if (c5 == null || num == null) {
            T3();
            return;
        }
        C1540q qVar = this.f18045L;
        if (qVar != null) {
            qVar.notifyItemChanged(num.intValue());
        }
    }

    /* access modifiers changed from: private */
    public static final c2.W s3(OldVersionsActivity oldVersionsActivity) {
        return c2.W.c(oldVersionsActivity.getLayoutInflater());
    }

    private final void t3(Context context, C2060s sVar) {
        Long l4;
        String str = null;
        if (sVar != null) {
            l4 = Long.valueOf(sVar.h());
        } else {
            l4 = null;
        }
        if (sVar != null) {
            str = sVar.w();
        }
        if (l4 != null) {
            DownloadWorker.a aVar = DownloadWorker.f19459d;
            if (aVar.j(l4.longValue())) {
                aVar.b();
                C2313C.f21882a.e(context);
                return;
            }
        }
        if (str != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f19459d;
            if (aVar2.m(str)) {
                aVar2.c(str);
                return;
            }
        }
        t a5 = t.f21927u.a(context);
        a5.a();
        if (sVar != null) {
            if (sVar.N()) {
                a5.z(sVar);
            } else {
                Iterator it = sVar.o().iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2060s.c cVar = (C2060s.c) next;
                    cVar.p(0);
                    cVar.l(0);
                    a5.x1(cVar);
                }
            }
        }
        a5.i();
    }

    /* access modifiers changed from: private */
    public final void u3() {
        Object value = D3().d().getValue();
        m.b(value);
        e eVar = this.f18046M;
        Object value2 = D3().d().getValue();
        m.b(value2);
        int r02 = ((C2050h) value2).r0();
        this.f18045L = new C1540q((C2050h) value, (C2048f) D3().c().getValue(), this, eVar, r02);
    }

    private final void v3(String str, File file) {
        String string = getString(R.string.msg_warning_old_versions);
        m.d(string, "getString(...)");
        O1(string, new W2(this, file, str));
    }

    /* access modifiers changed from: private */
    public static final s w3(OldVersionsActivity oldVersionsActivity, File file, String str) {
        com.uptodown.activities.preferences.a.f18818a.t0(oldVersionsActivity, file.getAbsolutePath());
        oldVersionsActivity.S3(str);
        return s.f8222a;
    }

    private final void x3(C2060s sVar, String str) {
        if (!isFinishing()) {
            C1683p c5 = C1683p.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(str);
            c5.f10694b.setVisibility(0);
            c5.f10694b.setTypeface(aVar.x());
            c5.f10694b.setOnCheckedChangeListener(new Z2(this));
            c5.f10697e.setTypeface(aVar.w());
            c5.f10697e.setOnClickListener(new C1315a3(this, sVar));
            c5.f10695c.setTypeface(aVar.w());
            c5.f10695c.setOnClickListener(new C1322b3(c5, this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            if (!UptodownApp.f17422D.M()) {
                J2(builder.create());
                if (!isFinishing()) {
                    AlertDialog j22 = j2();
                    m.b(j22);
                    Window window = j22.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    AlertDialog j23 = j2();
                    m.b(j23);
                    j23.show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void y3(OldVersionsActivity oldVersionsActivity, CompoundButton compoundButton, boolean z4) {
        com.uptodown.activities.preferences.a.f18818a.f1(oldVersionsActivity, !z4);
    }

    /* access modifiers changed from: private */
    public static final void z3(OldVersionsActivity oldVersionsActivity, C2060s sVar, View view) {
        oldVersionsActivity.O3(sVar);
        AlertDialog j22 = oldVersionsActivity.j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    public final void H3(String str) {
        m.e(str, "packageName");
        D3().j(this, str);
    }

    public final void J3(int i4) {
        Object value = D3().d().getValue();
        m.b(value);
        if (((C2050h) value).O() != null) {
            Object value2 = D3().d().getValue();
            m.b(value2);
            ArrayList O4 = ((C2050h) value2).O();
            m.b(O4);
            if (i4 < O4.size()) {
                Object value3 = D3().d().getValue();
                m.b(value3);
                ArrayList O5 = ((C2050h) value3).O();
                m.b(O5);
                long g4 = ((C2035C) O5.get(i4)).g();
                if (D3().c().getValue() != null) {
                    Object value4 = D3().c().getValue();
                    m.b(value4);
                    if (g4 == ((C2048f) value4).A()) {
                        F f4 = F.f20971a;
                        String string = getString(R.string.autoupdate_installed_version);
                        m.d(string, "getString(...)");
                        Object value5 = D3().d().getValue();
                        m.b(value5);
                        ArrayList O6 = ((C2050h) value5).O();
                        m.b(O6);
                        String format = String.format(string, Arrays.copyOf(new Object[]{((C2035C) O6.get(i4)).h()}, 1));
                        m.d(format, "format(...)");
                        q0(format);
                        return;
                    }
                }
                t.a aVar = t.f21927u;
                Context applicationContext = getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                t a5 = aVar.a(applicationContext);
                a5.a();
                Object value6 = D3().d().getValue();
                m.b(value6);
                ArrayList O7 = ((C2050h) value6).O();
                m.b(O7);
                String a6 = ((C2035C) O7.get(i4)).a();
                m.b(a6);
                C2060s f02 = a5.f0(a6);
                if (f02 == null) {
                    C2060s sVar = new C2060s();
                    Object value7 = D3().d().getValue();
                    m.b(value7);
                    ArrayList O8 = ((C2050h) value7).O();
                    m.b(O8);
                    sVar.c0(((C2035C) O8.get(i4)).g());
                    C2060s.c cVar = new C2060s.c();
                    Object value8 = D3().d().getValue();
                    m.b(value8);
                    ArrayList O9 = ((C2050h) value8).O();
                    m.b(O9);
                    String a7 = ((C2035C) O9.get(i4)).a();
                    m.b(a7);
                    cVar.m(Long.parseLong(a7));
                    Object value9 = D3().d().getValue();
                    m.b(value9);
                    ArrayList O10 = ((C2050h) value9).O();
                    m.b(O10);
                    cVar.q(((C2035C) O10.get(i4)).f());
                    sVar.o().add(cVar);
                    Object value10 = D3().d().getValue();
                    m.b(value10);
                    ArrayList O11 = ((C2050h) value10).O();
                    m.b(O11);
                    Object obj = O11.get(i4);
                    m.d(obj, "get(...)");
                    M3((C2035C) obj, sVar);
                    C1540q qVar = this.f18045L;
                    if (qVar != null) {
                        qVar.notifyItemChanged(i4);
                    }
                } else if (!DownloadWorker.f19459d.l(f02)) {
                    File n4 = f02.n();
                    if (!f02.f() || f02.o().isEmpty() || n4 == null || !n4.exists()) {
                        f02.R(this);
                        C1540q qVar2 = this.f18045L;
                        if (qVar2 != null) {
                            qVar2.notifyItemChanged(i4);
                        }
                    } else {
                        Object value11 = D3().d().getValue();
                        m.b(value11);
                        String Q4 = ((C2050h) value11).Q();
                        m.b(Q4);
                        N3(Q4, f02.E(), n4);
                    }
                } else {
                    t3(this, f02);
                }
                a5.i();
            }
        }
    }

    public final void K3(int i4) {
        C2035C c5;
        Object value = D3().d().getValue();
        m.b(value);
        if (((C2050h) value).O() != null) {
            Object value2 = D3().d().getValue();
            m.b(value2);
            ArrayList O4 = ((C2050h) value2).O();
            m.b(O4);
            if (i4 < O4.size()) {
                Object value3 = D3().d().getValue();
                m.b(value3);
                ArrayList O5 = ((C2050h) value3).O();
                if (O5 != null) {
                    c5 = (C2035C) O5.get(i4);
                } else {
                    c5 = null;
                }
                m.b(c5);
                L3(c5);
            }
        }
    }

    public final Object V3(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new k(this, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((View) B3().getRoot());
        D3().k(true);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                r3.t c5 = D3().c();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, C2048f.class);
                } else {
                    parcelable2 = extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                }
                c5.setValue(parcelable2);
            }
            if (extras.containsKey("appInfo")) {
                r3.t d5 = D3().d();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable = extras.getParcelable("appInfo");
                }
                d5.setValue(parcelable);
            }
        }
        E3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C3();
    }
}
