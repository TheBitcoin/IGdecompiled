package com.uptodown.activities;

import J1.C1332d;
import J1.C1339e;
import J1.C1346f;
import M1.C1524a;
import N1.k;
import R2.h;
import R2.n;
import R2.s;
import W1.C1610f;
import W1.u;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c2.C1667h;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import f2.C2012c;
import f2.W;
import g2.C2048f;
import g2.C2063v;
import g2.K;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import u2.F;
import u2.q;
import u2.t;

public final class AppFilesActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final LifecycleCoroutineScope f17505J = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f17506K = h.a(new C1332d(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C2048f f17507L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public a f17508M = new a(this);

    public static final class a implements C2012c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17509a;

        a(AppFilesActivity appFilesActivity) {
            this.f17509a = appFilesActivity;
        }

        public void a(C2063v vVar) {
            m.e(vVar, "fileInfo");
            if (UptodownApp.f17422D.a0() && vVar.c() != null && !this.f17509a.isFinishing()) {
                this.f17509a.n3(vVar);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f17510a;

        /* renamed from: b  reason: collision with root package name */
        Object f17511b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f17512c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17513d;

        /* renamed from: e  reason: collision with root package name */
        int f17514e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppFilesActivity appFilesActivity, V2.d dVar) {
            super(dVar);
            this.f17513d = appFilesActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f17512c = obj;
            this.f17514e |= Integer.MIN_VALUE;
            return this.f17513d.k3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17515a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17516b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppFilesActivity appFilesActivity, V2.d dVar) {
            super(2, dVar);
            this.f17516b = appFilesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17516b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17515a == 0) {
                n.b(obj);
                this.f17516b.j3().f10450c.setVisibility(0);
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
        int f17517a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17518b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f17519c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppFilesActivity appFilesActivity, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f17518b = appFilesActivity;
            this.f17519c = arrayList;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17518b, this.f17519c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            W2.b.c();
            if (this.f17517a == 0) {
                n.b(obj);
                try {
                    PackageManager packageManager = this.f17518b.getPackageManager();
                    m.d(packageManager, "getPackageManager(...)");
                    C2048f d32 = this.f17518b.f17507L;
                    m.b(d32);
                    String o4 = d32.o();
                    m.b(o4);
                    applicationInfo = W1.s.a(packageManager, o4, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    File file = new File(applicationInfo.sourceDir);
                    C2063v vVar = new C2063v();
                    vVar.e(applicationInfo.sourceDir);
                    vVar.f(C1610f.f8672a.e(applicationInfo.sourceDir));
                    vVar.g(file.length());
                    this.f17519c.add(vVar);
                    t a5 = t.f21927u.a(this.f17518b);
                    a5.a();
                    C2048f d33 = this.f17518b.f17507L;
                    m.b(d33);
                    d33.J(applicationInfo, a5);
                    C2048f d34 = this.f17518b.f17507L;
                    m.b(d34);
                    if (d34.v() != null) {
                        ArrayList arrayList = this.f17519c;
                        C2048f d35 = this.f17518b.f17507L;
                        m.b(d35);
                        ArrayList v4 = d35.v();
                        m.b(v4);
                        arrayList.addAll(v4);
                    }
                    C2048f d36 = this.f17518b.f17507L;
                    m.b(d36);
                    d36.I(a5);
                    C2048f d37 = this.f17518b.f17507L;
                    m.b(d37);
                    if (d37.n() != null) {
                        ArrayList arrayList2 = this.f17519c;
                        C2048f d38 = this.f17518b.f17507L;
                        m.b(d38);
                        ArrayList n4 = d38.n();
                        m.b(n4);
                        arrayList2.addAll(n4);
                    }
                    a5.i();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17521b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f17522c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppFilesActivity appFilesActivity, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f17521b = appFilesActivity;
            this.f17522c = arrayList;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17521b, this.f17522c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17520a == 0) {
                n.b(obj);
                this.f17521b.j3().f10452e.setAdapter(new C1524a(this.f17522c, this.f17521b.f17508M));
                this.f17521b.j3().f10450c.setVisibility(8);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17524b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppFilesActivity appFilesActivity, V2.d dVar) {
            super(2, dVar);
            this.f17524b = appFilesActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17524b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17523a;
            if (i4 == 0) {
                n.b(obj);
                AppFilesActivity appFilesActivity = this.f17524b;
                this.f17523a = 1;
                if (appFilesActivity.k3(this) == c5) {
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
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class g implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f17525a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2063v f17526b;

        g(AppFilesActivity appFilesActivity, C2063v vVar) {
            this.f17525a = appFilesActivity;
            this.f17526b = vVar;
        }

        public void a(K k4) {
            m.e(k4, "reportVT");
            Intent intent = new Intent(this.f17525a, VirusTotalReport.class);
            intent.putExtra("app_selected", this.f17525a.f17507L);
            intent.putExtra("appReportVT", k4);
            AppFilesActivity appFilesActivity = this.f17525a;
            appFilesActivity.startActivity(intent, UptodownApp.f17422D.a(appFilesActivity));
        }

        public void b() {
            if (this.f17526b.c() != null && !this.f17525a.isFinishing()) {
                q qVar = new q();
                AppFilesActivity appFilesActivity = this.f17525a;
                u2.m mVar = new u2.m();
                String c5 = this.f17526b.c();
                m.b(c5);
                qVar.q(appFilesActivity, mVar.r(c5), this.f17525a.getString(R.string.virustotal_safety_report_title));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final C1667h i3(AppFilesActivity appFilesActivity) {
        return C1667h.c(appFilesActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C1667h j3() {
        return (C1667h) this.f17506K.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (o3.C0977g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k3(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.AppFilesActivity.b
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.AppFilesActivity$b r0 = (com.uptodown.activities.AppFilesActivity.b) r0
            int r1 = r0.f17514e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17514e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.AppFilesActivity$b r0 = new com.uptodown.activities.AppFilesActivity$b
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f17512c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f17514e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            R2.n.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f17511b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r4 = r0.f17510a
            com.uptodown.activities.AppFilesActivity r4 = (com.uptodown.activities.AppFilesActivity) r4
            R2.n.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f17511b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r5 = r0.f17510a
            com.uptodown.activities.AppFilesActivity r5 = (com.uptodown.activities.AppFilesActivity) r5
            R2.n.b(r9)
            goto L_0x0071
        L_0x0051:
            R2.n.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            o3.E0 r2 = o3.Y.c()
            com.uptodown.activities.AppFilesActivity$c r7 = new com.uptodown.activities.AppFilesActivity$c
            r7.<init>(r8, r6)
            r0.f17510a = r8
            r0.f17511b = r9
            r0.f17514e = r5
            java.lang.Object r2 = o3.C0977g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            o3.G r9 = o3.Y.b()
            com.uptodown.activities.AppFilesActivity$d r7 = new com.uptodown.activities.AppFilesActivity$d
            r7.<init>(r5, r2, r6)
            r0.f17510a = r5
            r0.f17511b = r2
            r0.f17514e = r4
            java.lang.Object r9 = o3.C0977g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            o3.E0 r9 = o3.Y.c()
            com.uptodown.activities.AppFilesActivity$e r5 = new com.uptodown.activities.AppFilesActivity$e
            r5.<init>(r4, r2, r6)
            r0.f17510a = r6
            r0.f17511b = r6
            r0.f17514e = r3
            java.lang.Object r9 = o3.C0977g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            R2.s r9 = R2.s.f8222a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppFilesActivity.k3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void l3(AppFilesActivity appFilesActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            appFilesActivity.getOnBackPressedDispatcher().onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void m3(View view) {
    }

    /* access modifiers changed from: private */
    public final void n3(C2063v vVar) {
        new b2.p(this, (String) null, vVar.c(), new g(this, vVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final void o3() {
        F f4 = F.f21886a;
        C2048f fVar = this.f17507L;
        m.b(fVar);
        j3().f10449b.setImageDrawable(f4.k(this, fVar.o()));
        TextView textView = j3().f10454g;
        C2048f fVar2 = this.f17507L;
        m.b(fVar2);
        textView.setText(fVar2.m());
        TextView textView2 = j3().f10454g;
        k.a aVar = k.f7778g;
        textView2.setTypeface(aVar.w());
        TextView textView3 = j3().f10455h;
        C2048f fVar3 = this.f17507L;
        m.b(fVar3);
        textView3.setText(fVar3.B());
        j3().f10455h.setTypeface(aVar.x());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        try {
            setContentView((View) j3().getRoot());
            Intent intent = getIntent();
            if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInstalled"))) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInstalled", C2048f.class);
                } else {
                    parcelable = extras.getParcelable("appInstalled");
                }
                this.f17507L = (C2048f) parcelable;
            }
            C1667h j32 = j3();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                j32.f10453f.setNavigationIcon(drawable);
                j32.f10453f.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            j32.f10453f.setNavigationOnClickListener(new C1339e(this));
            j32.f10456i.setTypeface(k.f7778g.x());
            j32.f10450c.setOnClickListener(new C1346f());
            j32.f10452e.setLayoutManager(new LinearLayoutManager(this, 1, false));
            j32.f10452e.setItemAnimator(new DefaultItemAnimator());
            j32.f10452e.addItemDecoration(new u((int) getResources().getDimension(R.dimen.margin_m)));
            if (this.f17507L != null) {
                o3();
                C1001s0 unused = C0981i.d(this.f17505J, (V2.g) null, (L) null, new f(this, (V2.d) null), 3, (Object) null);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
