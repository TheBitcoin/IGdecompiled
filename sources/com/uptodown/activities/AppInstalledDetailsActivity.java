package com.uptodown.activities;

import J1.C1353g;
import J1.C1360h;
import J1.C1381k;
import J1.C1388l;
import J1.C1446t2;
import J1.r;
import R2.n;
import R2.s;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C1640l;
import c2.C1664f0;
import c2.C1669i;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import f2.C2027s;
import g2.C2037E;
import g2.C2048f;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.S;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import u2.t;
import w2.C2345c;
import w2.v;

public final class AppInstalledDetailsActivity extends C1446t2 {

    /* renamed from: Z  reason: collision with root package name */
    public static final a f17527Z = new a((C2103g) null);

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f17528V = R2.h.a(new C1381k(this));
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public C2048f f17529W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public C2050h f17530X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public ArrayList f17531Y;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17533b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f17534a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppInstalledDetailsActivity f17535b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ S f17536c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C2060s f17537d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(AppInstalledDetailsActivity appInstalledDetailsActivity, S s4, C2060s sVar, V2.d dVar) {
                super(2, dVar);
                this.f17535b = appInstalledDetailsActivity;
                this.f17536c = s4;
                this.f17537d = sVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f17535b, this.f17536c, this.f17537d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17534a == 0) {
                    n.b(obj);
                    this.f17535b.g5().f10526p0.setTypeface(N1.k.f7778g.w());
                    this.f17535b.u5(this.f17536c.h());
                    C2060s sVar = this.f17537d;
                    if (sVar == null || !sVar.f()) {
                        this.f17535b.g5().f10526p0.setText(this.f17535b.getString(R.string.updates_button_download_app));
                        TextView textView = this.f17535b.g5().f10526p0;
                        m.d(textView, "tvUpdateAida");
                        v.a(textView);
                    } else {
                        this.f17535b.g5().f10526p0.setText(this.f17535b.getString(R.string.action_update));
                        TextView textView2 = this.f17535b.g5().f10526p0;
                        m.d(textView2, "tvUpdateAida");
                        v.d(textView2);
                    }
                    if (UptodownApp.f17422D.P(this.f17536c.h())) {
                        this.f17535b.x5();
                        this.f17535b.g5().f10496a0.setText(this.f17535b.getString(R.string.status_download_update_pending));
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: com.uptodown.activities.AppInstalledDetailsActivity$b$b  reason: collision with other inner class name */
        static final class C0215b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f17538a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppInstalledDetailsActivity f17539b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0215b(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
                super(2, dVar);
                this.f17539b = appInstalledDetailsActivity;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0215b(this.f17539b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17538a == 0) {
                    n.b(obj);
                    if (!this.f17539b.isFinishing()) {
                        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17539b;
                        String packageName = appInstalledDetailsActivity.getPackageName();
                        m.d(packageName, "getPackageName(...)");
                        appInstalledDetailsActivity.u5(packageName);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0215b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17533b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17533b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
            if (o3.C0977g.g(r9, r6, r8) == r0) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
            if (o3.C0977g.g(r9, r1, r8) == r0) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r8.f17532a
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L_0x0020
                if (r1 == r2) goto L_0x001c
                if (r1 != r3) goto L_0x0014
                R2.n.b(r9)
                goto L_0x00b1
            L_0x0014:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x001c:
                R2.n.b(r9)
                goto L_0x007b
            L_0x0020:
                R2.n.b(r9)
                u2.t$a r9 = u2.t.f21927u
                com.uptodown.activities.AppInstalledDetailsActivity r1 = r8.f17533b
                android.content.Context r1 = r1.getApplicationContext()
                java.lang.String r5 = "getApplicationContext(...)"
                kotlin.jvm.internal.m.d(r1, r5)
                u2.t r9 = r9.a(r1)
                r9.a()
                com.uptodown.activities.AppInstalledDetailsActivity r1 = r8.f17533b
                g2.f r1 = r1.f17529W
                kotlin.jvm.internal.m.b(r1)
                java.lang.String r1 = r1.o()
                kotlin.jvm.internal.m.b(r1)
                g2.S r1 = r9.D0(r1)
                if (r1 == 0) goto L_0x005b
                com.uptodown.activities.AppInstalledDetailsActivity r6 = r8.f17533b
                android.content.Context r6 = r6.getApplicationContext()
                kotlin.jvm.internal.m.d(r6, r5)
                g2.s r5 = r1.b(r6)
                goto L_0x005c
            L_0x005b:
                r5 = r4
            L_0x005c:
                r9.i()
                if (r1 == 0) goto L_0x007b
                boolean r9 = r1.m()
                if (r9 != 0) goto L_0x007b
                o3.E0 r9 = o3.Y.c()
                com.uptodown.activities.AppInstalledDetailsActivity$b$a r6 = new com.uptodown.activities.AppInstalledDetailsActivity$b$a
                com.uptodown.activities.AppInstalledDetailsActivity r7 = r8.f17533b
                r6.<init>(r7, r1, r5, r4)
                r8.f17532a = r2
                java.lang.Object r9 = o3.C0977g.g(r9, r6, r8)
                if (r9 != r0) goto L_0x007b
                goto L_0x00b0
            L_0x007b:
                com.uptodown.UptodownApp$a r9 = com.uptodown.UptodownApp.f17422D
                boolean r9 = r9.K()
                if (r9 == 0) goto L_0x00b1
                com.uptodown.activities.AppInstalledDetailsActivity r9 = r8.f17533b
                g2.f r9 = r9.f17529W
                kotlin.jvm.internal.m.b(r9)
                java.lang.String r9 = r9.o()
                com.uptodown.activities.AppInstalledDetailsActivity r1 = r8.f17533b
                java.lang.String r1 = r1.getPackageName()
                r2 = 0
                boolean r9 = m3.m.q(r9, r1, r2, r3, r4)
                if (r9 == 0) goto L_0x00b1
                o3.E0 r9 = o3.Y.c()
                com.uptodown.activities.AppInstalledDetailsActivity$b$b r1 = new com.uptodown.activities.AppInstalledDetailsActivity$b$b
                com.uptodown.activities.AppInstalledDetailsActivity r2 = r8.f17533b
                r1.<init>(r2, r4)
                r8.f17532a = r3
                java.lang.Object r9 = o3.C0977g.g(r9, r1, r8)
                if (r9 != r0) goto L_0x00b1
            L_0x00b0:
                return r0
            L_0x00b1:
                R2.s r9 = R2.s.f8222a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17540a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17541b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17542c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17541b = str;
            this.f17542c = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17541b, this.f17542c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17540a == 0) {
                n.b(obj);
                if (m.a(this.f17541b, "app_updated")) {
                    this.f17542c.i5();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17543a;

        d(AppInstalledDetailsActivity appInstalledDetailsActivity) {
            this.f17543a = appInstalledDetailsActivity;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            C2053k h4;
            m.e(hVar, "appInfo");
            this.f17543a.f17530X = hVar;
            if (!this.f17543a.isFinishing() && (h4 = hVar.h()) != null && h4.i() == 1) {
                this.f17543a.g5().f10490V.setText(this.f17543a.getString(R.string.app_detail_play_button));
            }
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f17544a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f17545b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17546c;

        /* renamed from: d  reason: collision with root package name */
        int f17547d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(dVar);
            this.f17546c = appInstalledDetailsActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f17545b = obj;
            this.f17547d |= Integer.MIN_VALUE;
            return this.f17546c.h5(this);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17549b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17549b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17549b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            PackageInfo packageInfo;
            PermissionInfo[] permissionInfoArr;
            W2.b.c();
            if (this.f17548a == 0) {
                n.b(obj);
                try {
                    PackageManager packageManager = this.f17549b.getPackageManager();
                    m.d(packageManager, "getPackageManager(...)");
                    C2048f S4 = this.f17549b.f17529W;
                    m.b(S4);
                    String o4 = S4.o();
                    m.b(o4);
                    packageInfo = W1.s.d(packageManager, o4, 4096);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (!(packageInfo == null || (permissionInfoArr = packageInfo.permissions) == null)) {
                    this.f17549b.f17531Y = new ArrayList();
                    Iterator a5 = C2098b.a(permissionInfoArr);
                    while (a5.hasNext()) {
                        PermissionInfo permissionInfo = (PermissionInfo) a5.next();
                        C2037E e5 = new C2037E();
                        e5.c(String.valueOf(permissionInfo.loadDescription(this.f17549b.getPackageManager())));
                        e5.d(permissionInfo.name);
                        ArrayList U4 = this.f17549b.f17531Y;
                        m.b(U4);
                        U4.add(e5);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17551b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17551b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f17551b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            W2.b.c();
            if (this.f17550a == 0) {
                n.b(obj);
                if (this.f17551b.f17531Y != null) {
                    ArrayList U4 = this.f17551b.f17531Y;
                    m.b(U4);
                    if (U4.size() > 0) {
                        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17551b;
                        ArrayList U42 = appInstalledDetailsActivity.f17531Y;
                        m.b(U42);
                        LinearLayout linearLayout = this.f17551b.g5().f10531s;
                        m.d(linearLayout, "llPermissionsAida");
                        appInstalledDetailsActivity.t5(U42, linearLayout);
                        ArrayList U43 = this.f17551b.f17531Y;
                        m.b(U43);
                        i4 = U43.size();
                        this.f17551b.g5().f10493Y.setText(String.valueOf(i4));
                        return s.f8222a;
                    }
                }
                this.f17551b.g5().f10469A.setVisibility(8);
                i4 = 0;
                this.f17551b.g5().f10493Y.setText(String.valueOf(i4));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17553b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17553b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f17553b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17552a;
            if (i4 == 0) {
                n.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17553b;
                this.f17552a = 1;
                if (appInstalledDetailsActivity.h5(this) == c5) {
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
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17554a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17555b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17555b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f17555b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17554a;
            if (i4 == 0) {
                n.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17555b;
                this.f17554a = 1;
                if (appInstalledDetailsActivity.d5(this) == c5) {
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
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17556a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17557b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppInstalledDetailsActivity appInstalledDetailsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17557b = appInstalledDetailsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f17557b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17556a;
            if (i4 == 0) {
                n.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17557b;
                this.f17556a = 1;
                if (appInstalledDetailsActivity.d5(this) == c5) {
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
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class k implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f17558a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17559b;

        k(CharSequence charSequence, AppInstalledDetailsActivity appInstalledDetailsActivity) {
            this.f17558a = charSequence;
            this.f17559b = appInstalledDetailsActivity;
        }

        /* access modifiers changed from: private */
        public static final void d(AppInstalledDetailsActivity appInstalledDetailsActivity, C2050h hVar, View view) {
            if (UptodownApp.f17422D.a0()) {
                appInstalledDetailsActivity.C2(hVar.e());
            }
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            SpannableString a5 = defpackage.b.f1090d.a(this.f17558a.toString());
            float dimension = this.f17559b.getResources().getDimension(R.dimen.text_size_m);
            Typeface x4 = N1.k.f7778g.x();
            m.b(x4);
            a5.setSpan(new defpackage.b(dimension, x4, ContextCompat.getColor(this.f17559b, R.color.blue_primary)), 0, this.f17558a.length(), 33);
            this.f17559b.g5().f10528q0.setText(a5);
            this.f17559b.g5().f10528q0.setOnClickListener(new r(this.f17559b, hVar));
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17560a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f17561b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17562c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17563d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f17564a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f17565b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ AppInstalledDetailsActivity f17566c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f17567d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C2060s f17568e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i4, AppInstalledDetailsActivity appInstalledDetailsActivity, String str, C2060s sVar, V2.d dVar) {
                super(2, dVar);
                this.f17565b = i4;
                this.f17566c = appInstalledDetailsActivity;
                this.f17567d = str;
                this.f17568e = sVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f17565b, this.f17566c, this.f17567d, this.f17568e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17564a == 0) {
                    n.b(obj);
                    switch (this.f17565b) {
                        case 102:
                            AppInstalledDetailsActivity appInstalledDetailsActivity = this.f17566c;
                            String string = appInstalledDetailsActivity.getString(R.string.descarga_error);
                            m.d(string, "getString(...)");
                            appInstalledDetailsActivity.q0(string);
                            break;
                        case 103:
                        case 106:
                            AppInstalledDetailsActivity appInstalledDetailsActivity2 = this.f17566c;
                            String str = this.f17567d;
                            m.b(str);
                            appInstalledDetailsActivity2.u5(str);
                            TextView textView = this.f17566c.g5().f10496a0;
                            textView.setText(this.f17566c.getString(R.string.zero) + this.f17566c.getString(R.string.percent));
                            this.f17566c.g5().f10535u.setProgress(0);
                            break;
                        case 107:
                            this.f17566c.x5();
                            this.f17566c.g5().f10496a0.setText(this.f17566c.getString(R.string.status_download_update_pending));
                            break;
                        case 108:
                            AppInstalledDetailsActivity appInstalledDetailsActivity3 = this.f17566c;
                            String str2 = this.f17567d;
                            m.b(str2);
                            appInstalledDetailsActivity3.u5(str2);
                            C2060s sVar = this.f17568e;
                            if (sVar != null && sVar.f()) {
                                this.f17566c.g5().f10526p0.setText(this.f17566c.getString(R.string.action_update));
                                TextView textView2 = this.f17566c.g5().f10526p0;
                                m.d(textView2, "tvUpdateAida");
                                v.d(textView2);
                                break;
                            }
                        default:
                            this.f17566c.g5().f10535u.setIndeterminate(false);
                            if (this.f17568e == null) {
                                this.f17566c.i5();
                                break;
                            } else {
                                this.f17566c.x5();
                                this.f17566c.g5().f10535u.setProgress(this.f17568e.x());
                                this.f17566c.g5().f10496a0.setText(this.f17566c.getString(R.string.percent_of_total_size, new Object[]{kotlin.coroutines.jvm.internal.b.b(this.f17568e.x()), new W1.i().d(this.f17568e.z(), this.f17566c)}));
                                break;
                            }
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppInstalledDetailsActivity appInstalledDetailsActivity, int i4, String str, V2.d dVar) {
            super(2, dVar);
            this.f17561b = appInstalledDetailsActivity;
            this.f17562c = i4;
            this.f17563d = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f17561b, this.f17562c, this.f17563d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2060s sVar;
            Object c5 = W2.b.c();
            int i4 = this.f17560a;
            if (i4 == 0) {
                n.b(obj);
                t.a aVar = t.f21927u;
                Context applicationContext = this.f17561b.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                t a5 = aVar.a(applicationContext);
                a5.a();
                C2048f S4 = this.f17561b.f17529W;
                m.b(S4);
                String o4 = S4.o();
                m.b(o4);
                S D02 = a5.D0(o4);
                if (D02 != null) {
                    Context applicationContext2 = this.f17561b.getApplicationContext();
                    m.d(applicationContext2, "getApplicationContext(...)");
                    sVar = D02.b(applicationContext2);
                } else {
                    sVar = null;
                }
                C2060s sVar2 = sVar;
                a5.i();
                E0 c6 = Y.c();
                a aVar2 = new a(this.f17562c, this.f17561b, this.f17563d, sVar2, (V2.d) null);
                this.f17560a = 1;
                if (C0977g.g(c6, aVar2, this) == c5) {
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
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final C1669i c5(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        return C1669i.c(appInstalledDetailsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final Object d5(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void f5() {
        if (this.f17530X == null) {
            C2048f fVar = this.f17529W;
            m.b(fVar);
            if (fVar.b() > 0) {
                C2048f fVar2 = this.f17529W;
                m.b(fVar2);
                new C1640l(this, fVar2.b(), new d(this), LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final C1669i g5() {
        return (C1669i) this.f17528V.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h5(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.activities.AppInstalledDetailsActivity.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.activities.AppInstalledDetailsActivity$e r0 = (com.uptodown.activities.AppInstalledDetailsActivity.e) r0
            int r1 = r0.f17547d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17547d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.AppInstalledDetailsActivity$e r0 = new com.uptodown.activities.AppInstalledDetailsActivity$e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f17545b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f17547d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f17544a
            com.uptodown.activities.AppInstalledDetailsActivity r2 = (com.uptodown.activities.AppInstalledDetailsActivity) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            com.uptodown.activities.AppInstalledDetailsActivity$f r2 = new com.uptodown.activities.AppInstalledDetailsActivity$f
            r2.<init>(r6, r5)
            r0.f17544a = r6
            r0.f17547d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            com.uptodown.activities.AppInstalledDetailsActivity$g r4 = new com.uptodown.activities.AppInstalledDetailsActivity$g
            r4.<init>(r2, r5)
            r0.f17544a = r5
            r0.f17547d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.h5(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void i5() {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = g5().f10535u;
        m.d(progressBar, "pbProgressAida");
        ImageView imageView = g5().f10503e;
        m.d(imageView, "ivLogoAida");
        cVar.c(progressBar, imageView);
        g5().f10527q.setVisibility(8);
        g5().f10526p0.setVisibility(8);
        g5().f10474F.setVisibility(8);
        g5().f10534t0.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void j5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        appInstalledDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void k5(View view) {
    }

    private final void l5() {
        g5().f10477I.setVisibility(8);
        g5().f10489U.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02b1 A[SYNTHETIC, Splitter:B:41:0x02b1] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x04d2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x05d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m5() {
        /*
            r13 = this;
            r0 = 0
            u2.F r1 = u2.F.f21886a
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            android.graphics.drawable.Drawable r1 = r1.k(r13, r2)
            c2.i r2 = r13.g5()
            android.widget.ImageView r2 = r2.f10503e
            r2.setImageDrawable(r1)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10480L
            g2.f r3 = r13.f17529W
            kotlin.jvm.internal.m.b(r3)
            java.lang.String r3 = r3.m()
            r2.setText(r3)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10480L
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r4 = r3.w()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10534t0
            g2.f r4 = r13.f17529W
            kotlin.jvm.internal.m.b(r4)
            java.lang.String r4 = r4.B()
            r2.setText(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10534t0
            android.graphics.Typeface r4 = r3.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10520m0
            android.graphics.Typeface r4 = r3.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10522n0
            android.graphics.Typeface r4 = r3.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10496a0
            android.graphics.Typeface r4 = r3.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10532s0
            android.graphics.Typeface r4 = r3.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10484P
            android.graphics.Typeface r4 = r3.w()
            r2.setTypeface(r4)
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            java.lang.String r4 = r13.getPackageName()
            boolean r2 = kotlin.jvm.internal.m.a(r2, r4)
            r4 = 1
            r5 = 8
            if (r2 != 0) goto L_0x00d4
            g2.h r2 = r13.f17530X
            if (r2 == 0) goto L_0x00dd
            kotlin.jvm.internal.m.b(r2)
            g2.k r2 = r2.h()
            if (r2 == 0) goto L_0x00dd
            int r2 = r2.i()
            if (r2 != r4) goto L_0x00dd
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10490V
            r6 = 2131951689(0x7f130049, float:1.95398E38)
            java.lang.String r6 = r13.getString(r6)
            r2.setText(r6)
            goto L_0x00dd
        L_0x00d4:
            c2.i r2 = r13.g5()
            android.widget.LinearLayout r2 = r2.f10525p
            r2.setVisibility(r5)
        L_0x00dd:
            W1.h r2 = new W1.h
            r2.<init>()
            g2.f r6 = r13.f17529W
            kotlin.jvm.internal.m.b(r6)
            java.lang.String r6 = r6.o()
            kotlin.jvm.internal.m.b(r6)
            boolean r2 = r2.p(r13, r6)
            if (r2 == 0) goto L_0x00fd
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10520m0
            r2.setVisibility(r0)
        L_0x00fd:
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10490V
            android.graphics.Typeface r6 = r3.w()
            r2.setTypeface(r6)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10490V
            J1.m r6 = new J1.m
            r6.<init>(r13)
            r2.setOnClickListener(r6)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10524o0
            android.graphics.Typeface r6 = r3.w()
            r2.setTypeface(r6)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10524o0
            J1.n r6 = new J1.n
            r6.<init>(r13)
            r2.setOnClickListener(r6)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10479K
            android.graphics.Typeface r6 = r3.w()
            r2.setTypeface(r6)
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x0189
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            boolean r2 = m3.m.p(r2, r6, r4)
            if (r2 != 0) goto L_0x0189
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10492X
            android.graphics.Typeface r7 = r3.w()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10491W
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10491W
            g2.f r7 = r13.f17529W
            kotlin.jvm.internal.m.b(r7)
            java.lang.String r7 = r7.o()
            r2.setText(r7)
            goto L_0x0192
        L_0x0189:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10544z
            r2.setVisibility(r5)
        L_0x0192:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            long r7 = r2.A()
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d2
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10538v0
            android.graphics.Typeface r7 = r3.w()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10536u0
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10536u0
            g2.f r7 = r13.f17529W
            kotlin.jvm.internal.m.b(r7)
            long r7 = r7.A()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r2.setText(r7)
            goto L_0x01db
        L_0x01d2:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10476H
            r2.setVisibility(r5)
        L_0x01db:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10537v
            r2.setVisibility(r5)
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            long r7 = r2.g()
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0227
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10486R
            android.graphics.Typeface r7 = r3.w()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10485Q
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10485Q
            u2.q r7 = new u2.q
            r7.<init>()
            g2.f r8 = r13.f17529W
            kotlin.jvm.internal.m.b(r8)
            long r11 = r8.g()
            java.lang.String r7 = r7.l(r11)
            r2.setText(r7)
            goto L_0x0230
        L_0x0227:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10539w
            r2.setVisibility(r5)
        L_0x0230:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            long r7 = r2.j()
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0273
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10488T
            android.graphics.Typeface r7 = r3.w()
            r2.setTypeface(r7)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10487S
            android.graphics.Typeface r3 = r3.x()
            r2.setTypeface(r3)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10487S
            u2.q r3 = new u2.q
            r3.<init>()
            g2.f r7 = r13.f17529W
            kotlin.jvm.internal.m.b(r7)
            long r7 = r7.j()
            java.lang.String r3 = r3.l(r7)
            r2.setText(r3)
            goto L_0x027c
        L_0x0273:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10541x
            r2.setVisibility(r5)
        L_0x027c:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            r3 = 0
            if (r2 == 0) goto L_0x02a5
            int r2 = r2.length()
            if (r2 != 0) goto L_0x028f
            goto L_0x02a5
        L_0x028f:
            u2.m r2 = new u2.m
            r2.<init>()
            g2.f r7 = r13.f17529W
            kotlin.jvm.internal.m.b(r7)
            java.lang.String r7 = r7.o()
            kotlin.jvm.internal.m.b(r7)
            java.lang.String r2 = r2.h(r13, r7)
            goto L_0x02a6
        L_0x02a5:
            r2 = r3
        L_0x02a6:
            java.lang.String r7 = "getPackageManager(...)"
            if (r2 == 0) goto L_0x0307
            int r8 = r2.length()
            if (r8 != 0) goto L_0x02b1
            goto L_0x0307
        L_0x02b1:
            android.content.pm.PackageManager r8 = r13.getPackageManager()     // Catch:{ Exception -> 0x02bd }
            kotlin.jvm.internal.m.d(r8, r7)     // Catch:{ Exception -> 0x02bd }
            android.content.pm.PackageInfo r8 = W1.s.d(r8, r2, r0)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02c2
        L_0x02bd:
            r8 = move-exception
            r8.printStackTrace()
            r8 = r3
        L_0x02c2:
            if (r8 == 0) goto L_0x02ea
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            android.content.pm.PackageManager r11 = r13.getPackageManager()
            java.lang.CharSequence r8 = r8.loadLabel(r11)
            java.lang.String r11 = "loadLabel(...)"
            kotlin.jvm.internal.m.d(r8, r11)
            c2.i r11 = r13.g5()
            android.widget.TextView r11 = r11.f10528q0
            r11.setText(r8)
            b2.m r11 = new b2.m
            com.uptodown.activities.AppInstalledDetailsActivity$k r12 = new com.uptodown.activities.AppInstalledDetailsActivity$k
            r12.<init>(r8, r13)
            androidx.lifecycle.LifecycleCoroutineScope r8 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r13)
            r11.<init>(r13, r2, r12, r8)
        L_0x02ea:
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10530r0
            N1.k$a r8 = N1.k.f7778g
            android.graphics.Typeface r11 = r8.w()
            r2.setTypeface(r11)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10528q0
            android.graphics.Typeface r8 = r8.x()
            r2.setTypeface(r8)
            goto L_0x0310
        L_0x0307:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10475G
            r2.setVisibility(r5)
        L_0x0310:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            int r2 = r2.l()
            if (r2 == 0) goto L_0x034e
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10500c0
            N1.k$a r8 = N1.k.f7778g
            android.graphics.Typeface r11 = r8.w()
            r2.setTypeface(r11)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10498b0
            android.graphics.Typeface r8 = r8.x()
            r2.setTypeface(r8)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10498b0
            g2.f r8 = r13.f17529W
            kotlin.jvm.internal.m.b(r8)
            int r8 = r8.l()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2.setText(r8)
            goto L_0x0357
        L_0x034e:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10470B
            r2.setVisibility(r5)
        L_0x0357:
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10508g0
            N1.k$a r8 = N1.k.f7778g
            android.graphics.Typeface r11 = r8.w()
            r2.setTypeface(r11)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10506f0
            android.graphics.Typeface r11 = r8.x()
            r2.setTypeface(r11)
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.util.ArrayList r2 = r2.v()
            if (r2 == 0) goto L_0x0390
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.util.ArrayList r2 = r2.v()
            kotlin.jvm.internal.m.b(r2)
            int r2 = r2.size()
            int r2 = r2 + r4
            goto L_0x0391
        L_0x0390:
            r2 = 1
        L_0x0391:
            g2.f r11 = r13.f17529W
            kotlin.jvm.internal.m.b(r11)
            java.util.ArrayList r11 = r11.n()
            if (r11 == 0) goto L_0x03ad
            g2.f r11 = r13.f17529W
            kotlin.jvm.internal.m.b(r11)
            java.util.ArrayList r11 = r11.n()
            kotlin.jvm.internal.m.b(r11)
            int r11 = r11.size()
            int r2 = r2 + r11
        L_0x03ad:
            if (r2 <= r4) goto L_0x03f3
            c2.i r6 = r13.g5()
            android.widget.TextView r6 = r6.f10508g0
            r11 = 2131951700(0x7f130054, float:1.9539822E38)
            java.lang.String r11 = r13.getString(r11)
            r6.setText(r11)
            c2.i r6 = r13.g5()
            android.widget.TextView r6 = r6.f10506f0
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r2
            r2 = 2131951703(0x7f130057, float:1.9539828E38)
            java.lang.String r2 = r13.getString(r2, r4)
            r6.setText(r2)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10540w0
            android.graphics.Typeface r4 = r8.w()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10540w0
            J1.o r4 = new J1.o
            r4.<init>(r13)
            r2.setOnClickListener(r4)
            goto L_0x0432
        L_0x03f3:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.r()
            if (r2 == 0) goto L_0x0429
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.r()
            boolean r2 = m3.m.p(r2, r6, r4)
            if (r2 != 0) goto L_0x0429
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10506f0
            g2.f r4 = r13.f17529W
            kotlin.jvm.internal.m.b(r4)
            java.lang.String r4 = r4.r()
            r2.setText(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10540w0
            r2.setVisibility(r5)
            goto L_0x0432
        L_0x0429:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10471C
            r2.setVisibility(r5)
        L_0x0432:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            long r11 = r2.t()
            int r2 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0475
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10518l0
            android.graphics.Typeface r4 = r8.w()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10516k0
            android.graphics.Typeface r4 = r8.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10516k0
            W1.i r4 = new W1.i
            r4.<init>()
            g2.f r6 = r13.f17529W
            kotlin.jvm.internal.m.b(r6)
            long r11 = r6.t()
            java.lang.String r4 = r4.d(r11, r13)
            r2.setText(r4)
            goto L_0x047e
        L_0x0475:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10473E
            r2.setVisibility(r5)
        L_0x047e:
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.o()
            if (r2 == 0) goto L_0x04ac
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0490
            goto L_0x04ac
        L_0x0490:
            u2.m r2 = new u2.m
            r2.<init>()
            android.content.pm.PackageManager r3 = r13.getPackageManager()
            kotlin.jvm.internal.m.d(r3, r7)
            g2.f r4 = r13.f17529W
            kotlin.jvm.internal.m.b(r4)
            java.lang.String r4 = r4.o()
            kotlin.jvm.internal.m.b(r4)
            java.lang.String r3 = r2.i(r3, r4)
        L_0x04ac:
            if (r3 == 0) goto L_0x04d2
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10514j0
            android.graphics.Typeface r4 = r8.w()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10512i0
            android.graphics.Typeface r4 = r8.x()
            r2.setTypeface(r4)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10512i0
            r2.setText(r3)
            goto L_0x04db
        L_0x04d2:
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10472D
            r2.setVisibility(r5)
        L_0x04db:
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10494Z
            android.graphics.Typeface r3 = r8.w()
            r2.setTypeface(r3)
            c2.i r2 = r13.g5()
            android.widget.TextView r2 = r2.f10493Y
            android.graphics.Typeface r3 = r8.x()
            r2.setTypeface(r3)
            c2.i r2 = r13.g5()
            android.widget.RelativeLayout r2 = r2.f10469A
            J1.p r3 = new J1.p
            r3.<init>(r13)
            r2.setOnClickListener(r3)
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            long r2 = r2.b()
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x056e
            c2.i r2 = r13.g5()
            android.widget.ImageView r2 = r2.f10505f
            r2.setImageDrawable(r1)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10481M
            g2.f r2 = r13.f17529W
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r2 = r2.m()
            r1.setText(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10481M
            android.graphics.Typeface r2 = r8.w()
            r1.setTypeface(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10502d0
            android.graphics.Typeface r2 = r8.w()
            r1.setTypeface(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10504e0
            android.graphics.Typeface r2 = r8.w()
            r1.setTypeface(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10510h0
            android.graphics.Typeface r2 = r8.x()
            r1.setTypeface(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10502d0
            J1.q r2 = new J1.q
            r2.<init>(r13)
            r1.setOnClickListener(r2)
            goto L_0x059b
        L_0x056e:
            c2.i r1 = r13.g5()
            android.widget.ImageView r1 = r1.f10505f
            r1.setVisibility(r5)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10481M
            r1.setVisibility(r5)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10502d0
            r1.setVisibility(r5)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10510h0
            r1.setVisibility(r5)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10504e0
            r1.setVisibility(r5)
        L_0x059b:
            g2.f r1 = r13.f17529W
            kotlin.jvm.internal.m.b(r1)
            boolean r1 = r1.H()
            if (r1 == 0) goto L_0x05d2
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10522n0
            r2 = 2131952662(0x7f130416, float:1.9541773E38)
            java.lang.String r2 = r13.getString(r2)
            r1.setText(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10522n0
            r1.setVisibility(r0)
            c2.i r0 = r13.g5()
            android.widget.TextView r0 = r0.f10490V
            r0.setVisibility(r5)
            c2.i r0 = r13.g5()
            android.widget.TextView r0 = r0.f10524o0
            r0.setVisibility(r5)
            goto L_0x05ff
        L_0x05d2:
            g2.f r1 = r13.f17529W
            kotlin.jvm.internal.m.b(r1)
            boolean r1 = r1.F()
            if (r1 == 0) goto L_0x05ff
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10522n0
            r2 = 2131952660(0x7f130414, float:1.954177E38)
            java.lang.String r2 = r13.getString(r2)
            r1.setText(r2)
            c2.i r1 = r13.g5()
            android.widget.TextView r1 = r1.f10522n0
            r1.setVisibility(r0)
            c2.i r0 = r13.g5()
            android.widget.TextView r0 = r0.f10524o0
            r0.setVisibility(r5)
        L_0x05ff:
            c2.i r0 = r13.g5()
            android.view.View r0 = r0.f10533t
            r0.setVisibility(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.m5():void");
    }

    /* access modifiers changed from: private */
    public static final void n5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        PackageManager packageManager = appInstalledDetailsActivity.getPackageManager();
        C2048f fVar = appInstalledDetailsActivity.f17529W;
        m.b(fVar);
        String o4 = fVar.o();
        m.b(o4);
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(o4);
        if (launchIntentForPackage != null) {
            appInstalledDetailsActivity.startActivity(launchIntentForPackage);
        }
    }

    /* access modifiers changed from: private */
    public static final void o5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        N1.j jVar = new N1.j(appInstalledDetailsActivity);
        C2048f fVar = appInstalledDetailsActivity.f17529W;
        m.b(fVar);
        String o4 = fVar.o();
        m.b(o4);
        jVar.h(o4);
        appInstalledDetailsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void p5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        Intent intent = new Intent(appInstalledDetailsActivity, AppFilesActivity.class);
        intent.putExtra("appInstalled", appInstalledDetailsActivity.f17529W);
        appInstalledDetailsActivity.startActivity(intent, UptodownApp.f17422D.a(appInstalledDetailsActivity));
    }

    /* access modifiers changed from: private */
    public static final void q5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        if (appInstalledDetailsActivity.g5().f10531s.getVisibility() == 0) {
            appInstalledDetailsActivity.g5().f10531s.setVisibility(8);
            appInstalledDetailsActivity.g5().f10511i.setImageResource(R.drawable.vector_add);
            return;
        }
        appInstalledDetailsActivity.g5().f10531s.setVisibility(0);
        appInstalledDetailsActivity.g5().f10511i.setImageResource(R.drawable.vector_remove);
        appInstalledDetailsActivity.g5().f10477I.post(new C1360h(appInstalledDetailsActivity));
    }

    /* access modifiers changed from: private */
    public static final void r5(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        appInstalledDetailsActivity.g5().f10477I.smoothScrollTo(0, appInstalledDetailsActivity.g5().f10469A.getTop());
    }

    /* access modifiers changed from: private */
    public static final void s5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        if (appInstalledDetailsActivity.f17530X != null) {
            Intent intent = new Intent(appInstalledDetailsActivity, AppDetailActivity.class);
            intent.putExtra("appInfo", appInstalledDetailsActivity.f17530X);
            appInstalledDetailsActivity.startActivity(intent, UptodownApp.f17422D.a(appInstalledDetailsActivity));
            return;
        }
        appInstalledDetailsActivity.f5();
    }

    /* access modifiers changed from: private */
    public final void t5(ArrayList arrayList, LinearLayout linearLayout) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1664f0 c5 = C1664f0.c(LayoutInflater.from(getApplicationContext()));
            m.d(c5, "inflate(...)");
            c5.f10408b.setTypeface(N1.k.f7778g.x());
            c5.f10408b.setText(((C2037E) arrayList.get(i4)).b());
            linearLayout.addView(c5.getRoot());
        }
    }

    /* access modifiers changed from: private */
    public final void u5(String str) {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = g5().f10535u;
        m.d(progressBar, "pbProgressAida");
        ImageView imageView = g5().f10503e;
        m.d(imageView, "ivLogoAida");
        cVar.c(progressBar, imageView);
        g5().f10496a0.setVisibility(0);
        g5().f10534t0.setVisibility(0);
        g5().f10527q.setVisibility(8);
        g5().f10526p0.setText(getString(R.string.updates_button_download_app));
        TextView textView = g5().f10526p0;
        m.d(textView, "tvUpdateAida");
        v.a(textView);
        g5().f10526p0.setOnClickListener(new C1353g(this, str));
        g5().f10526p0.setVisibility(0);
        g5().f10484P.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void v5(AppInstalledDetailsActivity appInstalledDetailsActivity, String str, View view) {
        appInstalledDetailsActivity.v4(appInstalledDetailsActivity.f17529W);
        if (UptodownApp.f17422D.P(str)) {
            appInstalledDetailsActivity.x5();
            appInstalledDetailsActivity.g5().f10496a0.setText(appInstalledDetailsActivity.getString(R.string.status_download_update_pending));
            return;
        }
        appInstalledDetailsActivity.w5();
    }

    private final void w5() {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = g5().f10535u;
        m.d(progressBar, "pbProgressAida");
        ImageView imageView = g5().f10503e;
        m.d(imageView, "ivLogoAida");
        cVar.e(progressBar, imageView);
        g5().f10535u.setIndeterminate(true);
        g5().f10527q.setVisibility(0);
        g5().f10534t0.setVisibility(0);
        g5().f10496a0.setVisibility(8);
        g5().f10526p0.setVisibility(8);
        g5().f10484P.setVisibility(8);
        g5().f10474F.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void x5() {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = g5().f10535u;
        m.d(progressBar, "pbProgressAida");
        ImageView imageView = g5().f10503e;
        m.d(imageView, "ivLogoAida");
        cVar.e(progressBar, imageView);
        g5().f10527q.setVisibility(0);
        g5().f10534t0.setVisibility(8);
        g5().f10484P.setOnClickListener(new C1388l(this));
        g5().f10526p0.setVisibility(8);
        g5().f10484P.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void y5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        C2048f fVar = appInstalledDetailsActivity.f17529W;
        m.b(fVar);
        String o4 = fVar.o();
        m.b(o4);
        aVar.f0(o4);
    }

    /* access modifiers changed from: protected */
    public void A4() {
    }

    public final Object e5(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new c(str, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            super.onCreate(r15)
            c2.i r15 = r14.g5()
            android.widget.RelativeLayout r15 = r15.getRoot()
            r14.setContentView((android.view.View) r15)
            android.content.Intent r15 = r14.getIntent()
            if (r15 == 0) goto L_0x0059
            android.os.Bundle r15 = r15.getExtras()
            r0 = 33
            if (r15 == 0) goto L_0x0039
            java.lang.String r1 = "appInstalled"
            boolean r2 = r15.containsKey(r1)
            if (r2 == 0) goto L_0x0039
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L_0x0031
            java.lang.Class<g2.f> r2 = g2.C2048f.class
            java.lang.Object r1 = r15.getParcelable(r1, r2)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            goto L_0x0035
        L_0x0031:
            android.os.Parcelable r1 = r15.getParcelable(r1)
        L_0x0035:
            g2.f r1 = (g2.C2048f) r1
            r14.f17529W = r1
        L_0x0039:
            kotlin.jvm.internal.m.b(r15)
            java.lang.String r1 = "appInfo"
            boolean r2 = r15.containsKey(r1)
            if (r2 == 0) goto L_0x0059
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L_0x0051
            java.lang.Class<g2.h> r0 = g2.C2050h.class
            java.lang.Object r15 = r15.getParcelable(r1, r0)
            android.os.Parcelable r15 = (android.os.Parcelable) r15
            goto L_0x0055
        L_0x0051:
            android.os.Parcelable r15 = r15.getParcelable(r1)
        L_0x0055:
            g2.h r15 = (g2.C2050h) r15
            r14.f17530X = r15
        L_0x0059:
            r14.f5()
            c2.i r15 = r14.g5()
            r0 = 2131230917(0x7f0800c5, float:1.80779E38)
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r14, r0)
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.widget.Toolbar r1 = r15.f10478J
            r1.setNavigationIcon((android.graphics.drawable.Drawable) r0)
            androidx.appcompat.widget.Toolbar r0 = r15.f10478J
            r1 = 2131951720(0x7f130068, float:1.9539862E38)
            java.lang.String r1 = r14.getString(r1)
            r0.setNavigationContentDescription((java.lang.CharSequence) r1)
        L_0x007a:
            androidx.appcompat.widget.Toolbar r0 = r15.f10478J
            J1.i r1 = new J1.i
            r1.<init>(r14)
            r0.setNavigationOnClickListener(r1)
            android.widget.TextView r0 = r15.f10489U
            N1.k$a r1 = N1.k.f7778g
            android.graphics.Typeface r1 = r1.x()
            r0.setTypeface(r1)
            android.view.View r0 = r15.f10533t
            J1.j r1 = new J1.j
            r1.<init>()
            r0.setOnClickListener(r1)
            android.view.View r15 = r15.f10533t
            r0 = 0
            r15.setVisibility(r0)
            r15 = 0
            g2.f r0 = r14.f17529W     // Catch:{ NameNotFoundException -> 0x00d0 }
            if (r0 == 0) goto L_0x00d4
            kotlin.jvm.internal.m.b(r0)     // Catch:{ NameNotFoundException -> 0x00d0 }
            java.lang.String r0 = r0.o()     // Catch:{ NameNotFoundException -> 0x00d0 }
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.length()     // Catch:{ NameNotFoundException -> 0x00d0 }
            if (r0 != 0) goto L_0x00b4
            goto L_0x00d4
        L_0x00b4:
            android.content.pm.PackageManager r0 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00d0 }
            java.lang.String r1 = "getPackageManager(...)"
            kotlin.jvm.internal.m.d(r0, r1)     // Catch:{ NameNotFoundException -> 0x00d0 }
            g2.f r1 = r14.f17529W     // Catch:{ NameNotFoundException -> 0x00d0 }
            kotlin.jvm.internal.m.b(r1)     // Catch:{ NameNotFoundException -> 0x00d0 }
            java.lang.String r1 = r1.o()     // Catch:{ NameNotFoundException -> 0x00d0 }
            kotlin.jvm.internal.m.b(r1)     // Catch:{ NameNotFoundException -> 0x00d0 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = W1.s.a(r0, r1, r2)     // Catch:{ NameNotFoundException -> 0x00d0 }
            goto L_0x00d5
        L_0x00d0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d4:
            r0 = r15
        L_0x00d5:
            if (r0 == 0) goto L_0x0117
            u2.t$a r1 = u2.t.f21927u
            u2.t r1 = r1.a(r14)
            r1.a()
            g2.f r2 = r14.f17529W
            kotlin.jvm.internal.m.b(r2)
            r2.J(r0, r1)
            g2.f r0 = r14.f17529W
            kotlin.jvm.internal.m.b(r0)
            r0.I(r1)
            r1.i()
            r14.m5()
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r14)
            com.uptodown.activities.AppInstalledDetailsActivity$h r5 = new com.uptodown.activities.AppInstalledDetailsActivity$h
            r5.<init>(r14, r15)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            o3.C1001s0 unused = o3.C0981i.d(r2, r3, r4, r5, r6, r7)
            androidx.lifecycle.LifecycleCoroutineScope r8 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r14)
            com.uptodown.activities.AppInstalledDetailsActivity$i r11 = new com.uptodown.activities.AppInstalledDetailsActivity$i
            r11.<init>(r14, r15)
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            o3.C1001s0 unused = o3.C0981i.d(r8, r9, r10, r11, r12, r13)
            goto L_0x011a
        L_0x0117:
            r14.l5()
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        if (this.f17529W != null) {
            T1.a i4 = N1.k.f7778g.i();
            if (i4 != null) {
                str = i4.b();
            } else {
                str = null;
            }
            C2048f fVar = this.f17529W;
            m.b(fVar);
            if (m3.m.p(str, fVar.o(), true)) {
                g5().f10535u.setIndeterminate(true);
                C2345c cVar = C2345c.f22021a;
                ProgressBar progressBar = g5().f10535u;
                m.d(progressBar, "pbProgressAida");
                ImageView imageView = g5().f10503e;
                m.d(imageView, "ivLogoAida");
                cVar.e(progressBar, imageView);
                return;
            }
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new j(this, (V2.d) null), 3, (Object) null);
        }
    }

    public final Object z5(int i4, String str, V2.d dVar) {
        C2048f fVar = this.f17529W;
        m.b(fVar);
        if (!m.a(str, fVar.o())) {
            return s.f8222a;
        }
        Object g4 = C0977g.g(Y.b(), new l(this, i4, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
