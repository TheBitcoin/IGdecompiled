package com.uptodown.core.activities;

import N1.k;
import O1.C1554c0;
import O1.C1556d0;
import O1.C1558e0;
import O1.C1560f0;
import O1.C1562g0;
import O1.C1564h0;
import O1.C1566i0;
import O1.C1568j0;
import O1.C1570k0;
import O1.C1572l0;
import O1.C1574m0;
import O1.n0;
import O1.o0;
import O1.p0;
import O1.q0;
import O1.r0;
import O1.s0;
import O1.t0;
import O1.u0;
import O1.v0;
import S2.C1601o;
import W1.C;
import W1.C1611g;
import W1.C1612h;
import W1.G;
import W1.t;
import W1.u;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class InstallerActivity extends O1.r {

    /* renamed from: Z  reason: collision with root package name */
    public static final b f19154Z = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public TextView f19155A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public TextView f19156B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public ImageView f19157C;

    /* renamed from: D  reason: collision with root package name */
    private TextView f19158D;

    /* renamed from: E  reason: collision with root package name */
    private String f19159E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public ArrayList f19160F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public String f19161G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public Uri f19162H;

    /* renamed from: I  reason: collision with root package name */
    private G f19163I;

    /* renamed from: J  reason: collision with root package name */
    private String f19164J;

    /* renamed from: K  reason: collision with root package name */
    private AlertDialog f19165K;

    /* renamed from: L  reason: collision with root package name */
    private AlertDialog f19166L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public ArrayList f19167M;

    /* renamed from: N  reason: collision with root package name */
    private C1001s0 f19168N;

    /* renamed from: O  reason: collision with root package name */
    private S1.h f19169O;

    /* renamed from: P  reason: collision with root package name */
    private S1.m f19170P;

    /* renamed from: Q  reason: collision with root package name */
    private boolean f19171Q;

    /* renamed from: R  reason: collision with root package name */
    private LinearLayout f19172R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public boolean f19173S;

    /* renamed from: T  reason: collision with root package name */
    private String f19174T;

    /* renamed from: U  reason: collision with root package name */
    private boolean f19175U;

    /* renamed from: V  reason: collision with root package name */
    private boolean f19176V;

    /* renamed from: W  reason: collision with root package name */
    private final m f19177W = new m(this);

    /* renamed from: X  reason: collision with root package name */
    private final c f19178X = new c(this);

    /* renamed from: Y  reason: collision with root package name */
    private final q f19179Y = new q(this);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public ProgressBar f19180o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public TextView f19181p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public TextView f19182q;

    /* renamed from: r  reason: collision with root package name */
    private RelativeLayout f19183r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public ImageView f19184s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public TextView f19185t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public TextView f19186u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f19187v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f19188w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public TextView f19189x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public TextView f19190y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public TextView f19191z;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final File f19192a;

        /* renamed from: b  reason: collision with root package name */
        private int f19193b = -1;

        /* renamed from: c  reason: collision with root package name */
        private String f19194c;

        /* renamed from: d  reason: collision with root package name */
        private String f19195d;

        /* renamed from: e  reason: collision with root package name */
        private long f19196e;

        public a(File file) {
            kotlin.jvm.internal.m.e(file, "file");
            this.f19192a = file;
        }

        public final int a() {
            return this.f19193b;
        }

        public final File b() {
            return this.f19192a;
        }

        public final String c() {
            return this.f19194c;
        }

        public final long d() {
            return this.f19196e;
        }

        public final String e() {
            return this.f19195d;
        }

        public final void f(int i4) {
            this.f19193b = i4;
        }

        public final void g(String str) {
            this.f19194c = str;
        }

        public final void h(long j4) {
            this.f19196e = j4;
        }

        public final void i(String str) {
            this.f19195d = str;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    public static final class c implements S1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19197a;

        c(InstallerActivity installerActivity) {
            this.f19197a = installerActivity;
        }

        public void a(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19197a.U1();
        }

        public void b(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19197a.finish();
        }

        public void c(String str, String str2) {
            kotlin.jvm.internal.m.e(str, "filename");
            if (str2 != null) {
                this.f19197a.S1(str2);
                return;
            }
            InstallerActivity installerActivity = this.f19197a;
            String string = installerActivity.getString(N1.i.error_unknown);
            kotlin.jvm.internal.m.d(string, "getString(R.string.error_unknown)");
            installerActivity.S1(string);
        }

        public void d(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            InstallerActivity installerActivity = this.f19197a;
            installerActivity.S1(str + " could not be parsed.");
        }

        public void e(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19197a.S1("invalid version code");
        }

        public void f(String str) {
            this.f19197a.S1("error: not system permissions");
        }
    }

    public static final class d implements S1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f19198a;

        d(C c5) {
            this.f19198a = c5;
        }

        public void a(View view, int i4) {
            ((T1.g) this.f19198a.j().get(i4)).g(!((T1.g) this.f19198a.j().get(i4)).a());
        }
    }

    public static final class e implements S1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f19199a;

        e(C c5) {
            this.f19199a = c5;
        }

        public void a(View view, int i4) {
            ((T1.g) this.f19199a.l().get(i4)).g(!((T1.g) this.f19199a.l().get(i4)).a());
        }
    }

    public static final class f implements S1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f19200a;

        f(C c5) {
            this.f19200a = c5;
        }

        public void a(View view, int i4) {
            ((T1.g) this.f19200a.m().get(i4)).g(!((T1.g) this.f19200a.m().get(i4)).a());
        }
    }

    public static final class g implements S1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f19201a;

        g(C c5) {
            this.f19201a = c5;
        }

        public void a(View view, int i4) {
            ((T1.g) this.f19201a.n().get(i4)).g(!((T1.g) this.f19201a.n().get(i4)).a());
        }
    }

    public static final class h implements S1.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19202a;

        h(InstallerActivity installerActivity) {
            this.f19202a = installerActivity;
        }

        public void a() {
            this.f19202a.U1();
        }

        public void b(String str) {
            this.f19202a.E1(str);
        }
    }

    public static final class i implements S1.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19203a;

        i(InstallerActivity installerActivity) {
            this.f19203a = installerActivity;
        }

        /* access modifiers changed from: private */
        public static final void k(InstallerActivity installerActivity, View view) {
            kotlin.jvm.internal.m.e(installerActivity, "this$0");
            installerActivity.finish();
        }

        public void a(File file, ArrayList arrayList) {
            kotlin.jvm.internal.m.e(file, "fileZipped");
            kotlin.jvm.internal.m.e(arrayList, "files");
            this.f19203a.O1(file, arrayList);
        }

        public void b(int i4) {
            this.f19203a.W1(i4);
        }

        public void c(File file) {
            ImageView Q02;
            if (file != null && (Q02 = this.f19203a.f19157C) != null) {
                C1612h hVar = new C1612h();
                InstallerActivity installerActivity = this.f19203a;
                String absolutePath = file.getAbsolutePath();
                kotlin.jvm.internal.m.d(absolutePath, "file.absolutePath");
                Q02.setImageDrawable(hVar.h(installerActivity, absolutePath));
            }
        }

        public void d(File file) {
            if (this.f19203a.f19160F == null) {
                this.f19203a.f19160F = new ArrayList();
            }
            ArrayList O02 = this.f19203a.f19160F;
            kotlin.jvm.internal.m.b(O02);
            O02.add(file);
        }

        public void e() {
            this.f19203a.getWindow().clearFlags(128);
            TextView c12 = this.f19203a.f19191z;
            if (c12 != null) {
                c12.setText(N1.i.error_not_enough_space);
            }
        }

        public void f() {
            N1.k.f7778g.e();
            this.f19203a.getWindow().clearFlags(128);
            TextView b12 = this.f19203a.f19181p;
            if (b12 != null) {
                InstallerActivity installerActivity = this.f19203a;
                b12.setText(installerActivity.getString(N1.i.core_kill_this_app, new Object[]{installerActivity.getString(N1.i.app_name)}));
            }
            TextView b13 = this.f19203a.f19181p;
            if (b13 != null) {
                b13.setVisibility(0);
            }
            TextView X02 = this.f19203a.f19156B;
            if (X02 != null) {
                X02.setOnClickListener(new v0(this.f19203a));
            }
        }

        public void g() {
            this.f19203a.W1(0);
        }

        public void h() {
            TextView c12 = this.f19203a.f19191z;
            if (c12 != null) {
                c12.setText(N1.i.error_unzipping);
            }
        }

        public void i() {
            N1.k.f7778g.e();
            this.f19203a.getWindow().clearFlags(128);
            TextView b12 = this.f19203a.f19181p;
            if (b12 != null) {
                InstallerActivity installerActivity = this.f19203a;
                b12.setText(installerActivity.getString(N1.i.msg_install_from_unknown_source, new Object[]{installerActivity.getString(N1.i.app_name)}));
            }
            this.f19203a.J();
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19204a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19205b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(InstallerActivity installerActivity, V2.d dVar) {
            super(2, dVar);
            this.f19205b = installerActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f19205b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19204a;
            if (i4 == 0) {
                R2.n.b(obj);
                InstallerActivity installerActivity = this.f19205b;
                this.f19204a = 1;
                if (installerActivity.L1(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19206a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19207b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f19208c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19209d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(InstallerActivity installerActivity, Uri uri, String str, V2.d dVar) {
            super(2, dVar);
            this.f19207b = installerActivity;
            this.f19208c = uri;
            this.f19209d = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f19207b, this.f19208c, this.f19209d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19206a;
            if (i4 == 0) {
                R2.n.b(obj);
                InstallerActivity installerActivity = this.f19207b;
                Uri uri = this.f19208c;
                String str = this.f19209d;
                this.f19206a = 1;
                if (installerActivity.Q1(uri, str, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19210a;

        /* renamed from: b  reason: collision with root package name */
        int f19211b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19212c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f19213a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InstallerActivity f19214b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ A f19215c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(InstallerActivity installerActivity, A a5, V2.d dVar) {
                super(2, dVar);
                this.f19214b = installerActivity;
                this.f19215c = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19214b, this.f19215c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19213a == 0) {
                    R2.n.b(obj);
                    TextView b12 = this.f19214b.f19181p;
                    if (b12 != null) {
                        ArrayList R02 = this.f19214b.f19167M;
                        kotlin.jvm.internal.m.b(R02);
                        b12.setText((CharSequence) R02.get(this.f19215c.f20966a));
                    }
                    TextView b13 = this.f19214b.f19181p;
                    if (b13 != null) {
                        b13.setVisibility(0);
                    }
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(InstallerActivity installerActivity, V2.d dVar) {
            super(2, dVar);
            this.f19212c = installerActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f19212c, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A[Catch:{ Exception -> 0x0012 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[EDGE_INSN: B:27:0x0063->B:19:0x0063 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f19211b
                r2 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                int r1 = r7.f19210a
                R2.n.b(r8)     // Catch:{ Exception -> 0x0012 }
                r8 = r1
                goto L_0x007b
            L_0x0012:
                r8 = move-exception
                goto L_0x0081
            L_0x0014:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001c:
                R2.n.b(r8)
                com.uptodown.core.activities.InstallerActivity r8 = r7.f19212c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r8 = r8.f19167M     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.m.b(r8)     // Catch:{ Exception -> 0x0012 }
                int r8 = r8.size()     // Catch:{ Exception -> 0x0012 }
                if (r8 <= 0) goto L_0x0084
                r8 = -1
            L_0x002f:
                kotlin.jvm.internal.A r1 = new kotlin.jvm.internal.A     // Catch:{ Exception -> 0x0012 }
                r1.<init>()     // Catch:{ Exception -> 0x0012 }
                h3.c$a r3 = h3.c.f20861a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r4 = r7.f19212c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r4 = r4.f19167M     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0012 }
                int r4 = r4.size()     // Catch:{ Exception -> 0x0012 }
                int r3 = r3.c(r4)     // Catch:{ Exception -> 0x0012 }
                r1.f20966a = r3     // Catch:{ Exception -> 0x0012 }
            L_0x0049:
                int r3 = r1.f20966a     // Catch:{ Exception -> 0x0012 }
                if (r3 != r8) goto L_0x0063
                h3.c$a r3 = h3.c.f20861a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r4 = r7.f19212c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r4 = r4.f19167M     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0012 }
                int r4 = r4.size()     // Catch:{ Exception -> 0x0012 }
                int r3 = r3.c(r4)     // Catch:{ Exception -> 0x0012 }
                r1.f20966a = r3     // Catch:{ Exception -> 0x0012 }
                goto L_0x0049
            L_0x0063:
                o3.E0 r8 = o3.Y.c()     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity$l$a r4 = new com.uptodown.core.activities.InstallerActivity$l$a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r5 = r7.f19212c     // Catch:{ Exception -> 0x0012 }
                r6 = 0
                r4.<init>(r5, r1, r6)     // Catch:{ Exception -> 0x0012 }
                r7.f19210a = r3     // Catch:{ Exception -> 0x0012 }
                r7.f19211b = r2     // Catch:{ Exception -> 0x0012 }
                java.lang.Object r8 = o3.C0977g.g(r8, r4, r7)     // Catch:{ Exception -> 0x0012 }
                if (r8 != r0) goto L_0x007a
                return r0
            L_0x007a:
                r8 = r3
            L_0x007b:
                r3 = 7000(0x1b58, double:3.4585E-320)
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x0012 }
                goto L_0x002f
            L_0x0081:
                r8.printStackTrace()
            L_0x0084:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class m extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19216a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(InstallerActivity installerActivity) {
            super(true);
            this.f19216a = installerActivity;
        }

        public void handleOnBackPressed() {
            this.f19216a.j1();
        }
    }

    static final class n extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19217a;

        /* renamed from: b  reason: collision with root package name */
        Object f19218b;

        /* renamed from: c  reason: collision with root package name */
        Object f19219c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f19220d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19221e;

        /* renamed from: f  reason: collision with root package name */
        int f19222f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(InstallerActivity installerActivity, V2.d dVar) {
            super(dVar);
            this.f19221e = installerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19220d = obj;
            this.f19222f |= Integer.MIN_VALUE;
            return this.f19221e.Q1((Uri) null, (String) null, this);
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19223a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19224b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(InstallerActivity installerActivity, V2.d dVar) {
            super(2, dVar);
            this.f19224b = installerActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new o(this.f19224b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19223a == 0) {
                R2.n.b(obj);
                TextView c12 = this.f19224b.f19191z;
                if (c12 != null) {
                    c12.setText(N1.i.xapk_receiving_data);
                }
                ProgressBar S02 = this.f19224b.f19180o;
                if (S02 != null) {
                    S02.setIndeterminate(true);
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((o) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19225a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19226b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19227c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Uri f19228d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f19229a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InstallerActivity f19230b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.C f19231c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(InstallerActivity installerActivity, kotlin.jvm.internal.C c5, V2.d dVar) {
                super(2, dVar);
                this.f19230b = installerActivity;
                this.f19231c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19230b, this.f19231c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19229a == 0) {
                    R2.n.b(obj);
                    ProgressBar S02 = this.f19230b.f19180o;
                    if (S02 != null) {
                        S02.setIndeterminate(false);
                    }
                    TextView c12 = this.f19230b.f19191z;
                    if (c12 != null) {
                        c12.setText("");
                    }
                    TextView X02 = this.f19230b.f19156B;
                    if (X02 != null) {
                        X02.setVisibility(8);
                    }
                    TextView Z02 = this.f19230b.f19155A;
                    if (Z02 != null) {
                        Z02.setVisibility(8);
                    }
                    if (this.f19231c.f20968a != null) {
                        TextView c13 = this.f19230b.f19191z;
                        if (c13 != null) {
                            c13.setText((CharSequence) this.f19231c.f20968a);
                        }
                    } else {
                        InstallerActivity installerActivity = this.f19230b;
                        Intent intent = new Intent();
                        intent.putExtra("realPath", this.f19230b.f19161G);
                        R2.s sVar = R2.s.f8222a;
                        installerActivity.setResult(10, intent);
                        this.f19230b.finish();
                    }
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str, InstallerActivity installerActivity, Uri uri, V2.d dVar) {
            super(2, dVar);
            this.f19226b = str;
            this.f19227c = installerActivity;
            this.f19228d = uri;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new p(this.f19226b, this.f19227c, this.f19228d, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r14.f19225a
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                R2.n.b(r15)
                goto L_0x00de
            L_0x0010:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0018:
                R2.n.b(r15)
                kotlin.jvm.internal.C r15 = new kotlin.jvm.internal.C
                r15.<init>()
                W1.h r1 = new W1.h
                r1.<init>()
                java.lang.String r3 = r14.f19226b
                boolean r1 = r1.o(r3)
                r3 = 0
                if (r1 == 0) goto L_0x00ca
                com.uptodown.core.activities.InstallerActivity r1 = r14.f19227c     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                android.net.Uri r4 = r14.f19228d     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                goto L_0x005b
            L_0x003b:
                r1 = move-exception
                goto L_0x003f
            L_0x003d:
                r1 = move-exception
                goto L_0x004d
            L_0x003f:
                r1.printStackTrace()
                com.uptodown.core.activities.InstallerActivity r1 = r14.f19227c
                int r4 = N1.i.no_permissions_directory
                java.lang.String r1 = r1.getString(r4)
                r15.f20968a = r1
                goto L_0x005a
            L_0x004d:
                r1.printStackTrace()
                com.uptodown.core.activities.InstallerActivity r1 = r14.f19227c
                int r4 = N1.i.installable_files_not_found
                java.lang.String r1 = r1.getString(r4)
                r15.f20968a = r1
            L_0x005a:
                r1 = r3
            L_0x005b:
                if (r1 == 0) goto L_0x00ca
                r4 = 8192(0x2000, float:1.14794E-41)
                byte[] r5 = new byte[r4]
                kotlin.jvm.internal.A r6 = new kotlin.jvm.internal.A
                r6.<init>()
                W1.h r7 = new W1.h
                r7.<init>()
                com.uptodown.core.activities.InstallerActivity r8 = r14.f19227c
                java.io.File r7 = r7.g(r8)
                long r8 = r7.getUsableSpace()
                int r10 = r1.available()
                double r10 = (double) r10
                r12 = 4608308318706860032(0x3ff4000000000000, double:1.25)
                double r10 = r10 * r12
                double r8 = (double) r8
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x00bd
                java.io.File r8 = new java.io.File
                java.lang.String r9 = r14.f19226b
                r8.<init>(r7, r9)
                java.io.FileOutputStream r7 = new java.io.FileOutputStream
                r7.<init>(r8)
            L_0x008f:
                r9 = 0
                int r10 = r1.read(r5, r9, r4)
                r6.f20966a = r10
                if (r10 <= 0) goto L_0x00a4
                r7.write(r5, r9, r10)     // Catch:{ IOException -> 0x009c }
                goto L_0x008f
            L_0x009c:
                r9 = move-exception
                java.lang.String r9 = r9.getLocalizedMessage()
                r15.f20968a = r9
                goto L_0x008f
            L_0x00a4:
                r7.close()     // Catch:{ IOException -> 0x00a8 }
                goto L_0x00b3
            L_0x00a8:
                r4 = move-exception
                java.lang.Object r5 = r15.f20968a
                if (r5 != 0) goto L_0x00b3
                java.lang.String r4 = r4.getLocalizedMessage()
                r15.f20968a = r4
            L_0x00b3:
                com.uptodown.core.activities.InstallerActivity r4 = r14.f19227c
                java.lang.String r5 = r8.getAbsolutePath()
                r4.f19161G = r5
                goto L_0x00c7
            L_0x00bd:
                com.uptodown.core.activities.InstallerActivity r4 = r14.f19227c
                int r5 = N1.i.error_not_enough_space
                java.lang.String r4 = r4.getString(r5)
                r15.f20968a = r4
            L_0x00c7:
                r1.close()
            L_0x00ca:
                o3.E0 r1 = o3.Y.c()
                com.uptodown.core.activities.InstallerActivity$p$a r4 = new com.uptodown.core.activities.InstallerActivity$p$a
                com.uptodown.core.activities.InstallerActivity r5 = r14.f19227c
                r4.<init>(r5, r15, r3)
                r14.f19225a = r2
                java.lang.Object r15 = o3.C0977g.g(r1, r4, r14)
                if (r15 != r0) goto L_0x00de
                return r0
            L_0x00de:
                R2.s r15 = R2.s.f8222a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((p) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class q implements S1.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19232a;

        q(InstallerActivity installerActivity) {
            this.f19232a = installerActivity;
        }

        public void a(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19232a.U1();
        }

        public void b(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19232a.finish();
        }

        public void c(String str, String str2) {
            kotlin.jvm.internal.m.e(str, "filename");
            InstallerActivity installerActivity = this.f19232a;
            String string = installerActivity.getString(N1.i.xapk_installation_failed);
            kotlin.jvm.internal.m.d(string, "getString(R.string.xapk_installation_failed)");
            installerActivity.S1(string);
        }

        public void d(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            InstallerActivity installerActivity = this.f19232a;
            installerActivity.S1(str + " could not be parsed.");
        }

        public void e(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            this.f19232a.S1("invalid version code");
        }

        public void f(String str) {
            kotlin.jvm.internal.m.e(str, "filename");
            InstallerActivity installerActivity = this.f19232a;
            installerActivity.S1(str + " not found.");
        }
    }

    static final class r extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19233a;

        /* renamed from: b  reason: collision with root package name */
        Object f19234b;

        /* renamed from: c  reason: collision with root package name */
        int f19235c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f19236d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19237e;

        /* renamed from: f  reason: collision with root package name */
        int f19238f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(InstallerActivity installerActivity, V2.d dVar) {
            super(dVar);
            this.f19237e = installerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19236d = obj;
            this.f19238f |= Integer.MIN_VALUE;
            return this.f19237e.d2(0, this);
        }
    }

    static final class s extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19239a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19240b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.C f19241c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(InstallerActivity installerActivity, kotlin.jvm.internal.C c5, V2.d dVar) {
            super(2, dVar);
            this.f19240b = installerActivity;
            this.f19241c = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new s(this.f19240b, this.f19241c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19239a == 0) {
                R2.n.b(obj);
                Intent intent = this.f19240b.getIntent();
                if (intent != null) {
                    this.f19240b.f19162H = intent.getData();
                    Bundle extras = intent.getExtras();
                    if (extras != null && extras.containsKey("realPath")) {
                        this.f19240b.f19161G = extras.getString("realPath");
                        kotlin.jvm.internal.C c5 = this.f19241c;
                        String T02 = this.f19240b.f19161G;
                        kotlin.jvm.internal.m.b(T02);
                        String T03 = this.f19240b.f19161G;
                        kotlin.jvm.internal.m.b(T03);
                        String substring = T02.substring(m3.m.R(T03, "/", 0, false, 6, (Object) null) + 1);
                        kotlin.jvm.internal.m.d(substring, "this as java.lang.String).substring(startIndex)");
                        c5.f20968a = substring;
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((s) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class t extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f19242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f19243b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19244c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.C f19245d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(InstallerActivity installerActivity, int i4, kotlin.jvm.internal.C c5, V2.d dVar) {
            super(2, dVar);
            this.f19243b = installerActivity;
            this.f19244c = i4;
            this.f19245d = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new t(this.f19243b, this.f19244c, this.f19245d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String T02;
            W2.b.c();
            if (this.f19242a == 0) {
                R2.n.b(obj);
                if (!this.f19243b.f19173S) {
                    this.f19243b.finish();
                } else if (this.f19244c == 1) {
                    TextView Z02 = this.f19243b.f19155A;
                    if (Z02 != null) {
                        Z02.setVisibility(0);
                    }
                    ProgressBar S02 = this.f19243b.f19180o;
                    if (S02 != null) {
                        S02.setVisibility(8);
                    }
                    TextView Y02 = this.f19243b.f19190y;
                    if (Y02 != null) {
                        Y02.setVisibility(8);
                    }
                    TextView V02 = this.f19243b.f19182q;
                    if (V02 != null) {
                        V02.setVisibility(0);
                    }
                    TextView a12 = this.f19243b.f19189x;
                    if (a12 != null) {
                        a12.setText(this.f19243b.getString(N1.i.core_install_next_app));
                    }
                    if (this.f19245d.f20968a != null) {
                        TextView U02 = this.f19243b.f19186u;
                        if (U02 != null) {
                            U02.setText((CharSequence) this.f19245d.f20968a);
                        }
                        TextView U03 = this.f19243b.f19186u;
                        if (U03 != null) {
                            U03.setVisibility(0);
                        }
                    } else {
                        TextView U04 = this.f19243b.f19186u;
                        if (U04 != null) {
                            U04.setText("");
                        }
                    }
                    String T03 = this.f19243b.f19161G;
                    if (!(T03 == null || T03.length() == 0)) {
                        PackageManager packageManager = this.f19243b.getPackageManager();
                        kotlin.jvm.internal.m.d(packageManager, "packageManager");
                        String T04 = this.f19243b.f19161G;
                        kotlin.jvm.internal.m.b(T04);
                        PackageInfo c5 = W1.s.c(packageManager, T04, 128);
                        if (!(c5 == null || (T02 = this.f19243b.f19161G) == null || T02.length() == 0)) {
                            C1612h hVar = new C1612h();
                            String T05 = this.f19243b.f19161G;
                            kotlin.jvm.internal.m.b(T05);
                            PackageManager packageManager2 = this.f19243b.getPackageManager();
                            kotlin.jvm.internal.m.d(packageManager2, "this@InstallerActivity.packageManager");
                            String b5 = hVar.b(c5, T05, packageManager2);
                            TextView W02 = this.f19243b.f19185t;
                            if (W02 != null) {
                                W02.setText(b5);
                            }
                            TextView W03 = this.f19243b.f19185t;
                            if (W03 != null) {
                                W03.setVisibility(0);
                            }
                        }
                        ImageView P02 = this.f19243b.f19184s;
                        if (P02 != null) {
                            P02.setVisibility(0);
                        }
                        String T06 = this.f19243b.f19161G;
                        kotlin.jvm.internal.m.b(T06);
                        if (m3.m.o(T06, ".xapk", false, 2, (Object) null)) {
                            ImageView P03 = this.f19243b.f19184s;
                            if (P03 != null) {
                                P03.setImageResource(N1.e.core_vector_xapk);
                            }
                        } else {
                            ImageView P04 = this.f19243b.f19184s;
                            if (P04 != null) {
                                C1612h hVar2 = new C1612h();
                                InstallerActivity installerActivity = this.f19243b;
                                String T07 = installerActivity.f19161G;
                                kotlin.jvm.internal.m.b(T07);
                                P04.setImageDrawable(hVar2.h(installerActivity, T07));
                            }
                        }
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((t) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    private final void A1() {
        this.f19169O = new h(this);
        this.f19170P = new i(this);
    }

    private final void B1(File file) {
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.m.d(applicationContext, "applicationContext");
        new W1.j(applicationContext, this.f19169O).v(file, this.f19175U);
    }

    private final boolean F1(File file) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        return G1(arrayList);
    }

    private final boolean G1(ArrayList arrayList) {
        try {
            if (new P1.a(this).N() && arrayList.size() == 1) {
                String name = ((File) arrayList.get(0)).getName();
                kotlin.jvm.internal.m.d(name, "files[0].name");
                if (m3.m.o(name, ".apk", false, 2, (Object) null)) {
                    PackageManager packageManager = getPackageManager();
                    kotlin.jvm.internal.m.d(packageManager, "packageManager");
                    String absolutePath = ((File) arrayList.get(0)).getAbsolutePath();
                    kotlin.jvm.internal.m.d(absolutePath, "files[0].absolutePath");
                    PackageInfo c5 = W1.s.c(packageManager, absolutePath, 0);
                    if (c5 != null) {
                        PackageManager packageManager2 = getPackageManager();
                        kotlin.jvm.internal.m.d(packageManager2, "packageManager");
                        String str = c5.packageName;
                        kotlin.jvm.internal.m.d(str, "piFileToInstall.packageName");
                        if (new C1612h().m(W1.s.d(packageManager2, str, 0)) == new C1612h().m(c5)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private final void H1() {
        if (this.f19168N == null) {
            this.f19168N = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new j(this, (V2.d) null), 3, (Object) null);
        }
    }

    private final void I1(Uri uri, String str) {
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new k(this, uri, str, (V2.d) null), 3, (Object) null);
    }

    private final void J1(String str) {
        S1.m mVar = this.f19170P;
        kotlin.jvm.internal.m.b(mVar);
        new R1.c(this, str, mVar, T());
    }

    private final ArrayList K1() {
        String string = getString(N1.i.app_name);
        kotlin.jvm.internal.m.d(string, "getString(R.string.app_name)");
        ArrayList arrayList = new ArrayList();
        try {
            String[] stringArray = getResources().getStringArray(N1.b.messages_info);
            kotlin.jvm.internal.m.d(stringArray, "resources.getStringArray(R.array.messages_info)");
            for (String str : stringArray) {
                kotlin.jvm.internal.m.d(str, TypedValues.Custom.S_STRING);
                if (str.length() > 0) {
                    if (m3.m.D(str, "%s", false, 2, (Object) null)) {
                        arrayList.add(m3.m.w(str, "%s", string, false, 4, (Object) null));
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            String[] stringArray2 = getResources().getStringArray(N1.b.messages_info_core);
            kotlin.jvm.internal.m.d(stringArray2, "resources.getStringArray…array.messages_info_core)");
            for (String str2 : stringArray2) {
                kotlin.jvm.internal.m.d(str2, TypedValues.Custom.S_STRING);
                if (str2.length() > 0) {
                    if (m3.m.D(str2, "%s", false, 2, (Object) null)) {
                        arrayList.add(m3.m.w(str2, "%s", string, false, 4, (Object) null));
                    } else {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Resources.NotFoundException e5) {
            e5.printStackTrace();
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final Object L1(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new l(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void M1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((N1.k) application).N().send(225, (Bundle) null);
        installerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void N1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((N1.k) application).N().send(226, (Bundle) null);
        installerActivity.u1();
    }

    private final void P1(String str) {
        if (str == null || !new File(str).exists()) {
            String string = getString(N1.i.installable_files_not_found);
            kotlin.jvm.internal.m.d(string, "getString(R.string.installable_files_not_found)");
            q0(string);
            finish();
        } else if (new File(str).isDirectory()) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                C1601o.v(arrayList, listFiles);
                O1((File) null, arrayList);
            }
        } else if (G.f8470b.a(str)) {
            J1(str);
        } else if (m3.m.o(str, ".apk", false, 2, (Object) null)) {
            C1(this, new File(str));
        } else {
            String string2 = getString(N1.i.installable_files_not_found);
            kotlin.jvm.internal.m.d(string2, "getString(R.string.installable_files_not_found)");
            q0(string2);
            finish();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (o3.C0977g.g(r9, r4, r0) != r1) goto L_0x007a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Q1(android.net.Uri r7, java.lang.String r8, V2.d r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.InstallerActivity.n
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.InstallerActivity$n r0 = (com.uptodown.core.activities.InstallerActivity.n) r0
            int r1 = r0.f19222f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19222f = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.InstallerActivity$n r0 = new com.uptodown.core.activities.InstallerActivity$n
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19220d
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19222f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r9)
            goto L_0x007a
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f19219c
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.f19218b
            android.net.Uri r7 = (android.net.Uri) r7
            java.lang.Object r2 = r0.f19217a
            com.uptodown.core.activities.InstallerActivity r2 = (com.uptodown.core.activities.InstallerActivity) r2
            R2.n.b(r9)
            goto L_0x0062
        L_0x0046:
            R2.n.b(r9)
            o3.E0 r9 = o3.Y.c()
            com.uptodown.core.activities.InstallerActivity$o r2 = new com.uptodown.core.activities.InstallerActivity$o
            r2.<init>(r6, r5)
            r0.f19217a = r6
            r0.f19218b = r7
            r0.f19219c = r8
            r0.f19222f = r4
            java.lang.Object r9 = o3.C0977g.g(r9, r2, r0)
            if (r9 != r1) goto L_0x0061
            goto L_0x0079
        L_0x0061:
            r2 = r6
        L_0x0062:
            o3.G r9 = o3.Y.b()
            com.uptodown.core.activities.InstallerActivity$p r4 = new com.uptodown.core.activities.InstallerActivity$p
            r4.<init>(r8, r2, r7, r5)
            r0.f19217a = r5
            r0.f19218b = r5
            r0.f19219c = r5
            r0.f19222f = r3
            java.lang.Object r7 = o3.C0977g.g(r9, r4, r0)
            if (r7 != r1) goto L_0x007a
        L_0x0079:
            return r1
        L_0x007a:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.Q1(android.net.Uri, java.lang.String, V2.d):java.lang.Object");
    }

    private final void R1() {
        TextView textView;
        String str = this.f19161G;
        if (str != null && m3.m.o(str, ".apk", false, 2, (Object) null)) {
            PackageManager packageManager = getPackageManager();
            kotlin.jvm.internal.m.d(packageManager, "pm");
            String str2 = this.f19161G;
            kotlin.jvm.internal.m.b(str2);
            PackageInfo c5 = W1.s.c(packageManager, str2, 128);
            if (c5 != null) {
                C1612h hVar = new C1612h();
                String str3 = this.f19161G;
                kotlin.jvm.internal.m.b(str3);
                String b5 = hVar.b(c5, str3, packageManager);
                long m4 = new C1612h().m(c5);
                C1611g gVar = new C1611g();
                String str4 = this.f19161G;
                kotlin.jvm.internal.m.b(str4);
                long f4 = gVar.f(str4);
                k.a aVar = N1.k.f7778g;
                String str5 = c5.packageName;
                kotlin.jvm.internal.m.d(str5, "pi.packageName");
                aVar.y(str5, m4, b5, f4);
                if (!this.f19176V) {
                    ImageView imageView = this.f19157C;
                    if (imageView != null) {
                        C1612h hVar2 = new C1612h();
                        String str6 = this.f19161G;
                        kotlin.jvm.internal.m.b(str6);
                        imageView.setImageDrawable(hVar2.h(this, str6));
                    }
                    TextView textView2 = this.f19188w;
                    if (textView2 != null) {
                        textView2.setText(getString(N1.i.app_install_info, new Object[]{b5, c5.versionName}));
                    }
                    TextView textView3 = this.f19188w;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                }
            }
        }
        if (!this.f19176V && (textView = this.f19187v) != null) {
            textView.setText(this.f19159E);
        }
    }

    /* access modifiers changed from: private */
    public static final void T1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        installerActivity.j1();
    }

    /* access modifiers changed from: private */
    public static final void V1(InstallerActivity installerActivity) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        installerActivity.R1();
        if (!installerActivity.f19176V) {
            installerActivity.Y1();
        } else {
            installerActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void X1(InstallerActivity installerActivity, int i4) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        installerActivity.H1();
        TextView textView = installerActivity.f19156B;
        if (textView != null) {
            textView.setVisibility(0);
        }
        LinearLayout linearLayout = installerActivity.f19172R;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView2 = installerActivity.f19191z;
        if (textView2 != null) {
            textView2.setText(installerActivity.getString(N1.i.unzipping_status, new Object[]{Integer.valueOf(i4)}));
        }
        ProgressBar progressBar = installerActivity.f19180o;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        ProgressBar progressBar2 = installerActivity.f19180o;
        if (progressBar2 != null) {
            progressBar2.setProgress(i4);
        }
        installerActivity.getWindow().addFlags(128);
        TextView textView3 = installerActivity.f19158D;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    private final void Y1() {
        runOnUiThread(new p0(this));
    }

    /* access modifiers changed from: private */
    public static final void Z1(InstallerActivity installerActivity) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        installerActivity.H1();
        LinearLayout linearLayout = installerActivity.f19172R;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = installerActivity.f19191z;
        if (textView != null) {
            textView.setText(N1.i.installing);
        }
        ProgressBar progressBar = installerActivity.f19180o;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
        installerActivity.getWindow().addFlags(128);
        TextView textView2 = installerActivity.f19158D;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = installerActivity.f19156B;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    private final void a2(ArrayList arrayList) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f19166L;
        if (alertDialog2 != null) {
            kotlin.jvm.internal.m.b(alertDialog2);
            if (alertDialog2.isShowing()) {
                AlertDialog alertDialog3 = this.f19166L;
                kotlin.jvm.internal.m.b(alertDialog3);
                alertDialog3.dismiss();
            }
        }
        Window window = null;
        View inflate = getLayoutInflater().inflate(N1.g.dialog_installed_version, (ViewGroup) null, false);
        k.a aVar = N1.k.f7778g;
        ((TextView) inflate.findViewById(N1.f.tv_msg_installed_version)).setTypeface(aVar.x());
        CheckBox checkBox = (CheckBox) inflate.findViewById(N1.f.cb_not_again_installed_version);
        checkBox.setTypeface(aVar.x());
        TextView textView = (TextView) inflate.findViewById(N1.f.tv_install);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new C1556d0(this, checkBox, arrayList));
        TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_cancel);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C1558e0(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.f19166L = create;
        if (create != null) {
            window = create.getWindow();
        }
        kotlin.jvm.internal.m.b(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (!isFinishing() && (alertDialog = this.f19166L) != null) {
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void b2(InstallerActivity installerActivity, CheckBox checkBox, ArrayList arrayList, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(arrayList, "$files");
        installerActivity.f19171Q = true;
        AlertDialog alertDialog = installerActivity.f19166L;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (checkBox.isChecked()) {
            new P1.a(installerActivity).J(false);
        }
        installerActivity.D1(installerActivity, arrayList);
    }

    /* access modifiers changed from: private */
    public static final void c2(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        AlertDialog alertDialog = installerActivity.f19166L;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        installerActivity.j1();
    }

    /* access modifiers changed from: private */
    public final void j1() {
        G g4 = this.f19163I;
        if (g4 != null) {
            g4.b();
        }
        N1.k.f7778g.b();
        ArrayList arrayList = this.f19160F;
        if (arrayList != null) {
            kotlin.jvm.internal.m.b(arrayList);
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                File file = (File) obj;
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
        }
        finish();
    }

    private final void k1(Context context, int i4) {
        Object systemService = context.getSystemService("notification");
        kotlin.jvm.internal.m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i4);
    }

    private final void l1(File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(N1.i.warning_title));
        builder.setMessage(N1.i.msg_dialog_install_auto);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new C1568j0(this, file));
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new C1570k0(this, file));
        builder.create().show();
    }

    private final void m1(ArrayList arrayList) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(N1.i.warning_title));
        builder.setMessage(N1.i.msg_dialog_install_auto);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new C1564h0(this, arrayList));
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new C1566i0(this, arrayList));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public static final void n1(InstallerActivity installerActivity, File file, DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(file, "$file");
        P1.a aVar = new P1.a(installerActivity);
        aVar.M(true);
        aVar.B(true);
        installerActivity.C1(installerActivity, file);
    }

    /* access modifiers changed from: private */
    public static final void o1(InstallerActivity installerActivity, File file, DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(file, "$file");
        P1.a aVar = new P1.a(installerActivity);
        aVar.M(true);
        aVar.B(false);
        installerActivity.C1(installerActivity, file);
    }

    /* access modifiers changed from: private */
    public static final void p1(InstallerActivity installerActivity, ArrayList arrayList, DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(arrayList, "$files");
        P1.a aVar = new P1.a(installerActivity);
        aVar.M(true);
        aVar.B(true);
        installerActivity.D1(installerActivity, arrayList);
    }

    /* access modifiers changed from: private */
    public static final void q1(InstallerActivity installerActivity, ArrayList arrayList, DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(arrayList, "$files");
        P1.a aVar = new P1.a(installerActivity);
        aVar.M(true);
        aVar.B(false);
        installerActivity.D1(installerActivity, arrayList);
    }

    private final void r1(String str, ArrayList arrayList) {
        Window window;
        android.app.AlertDialog alertDialog = this.f19165K;
        if (alertDialog != null) {
            kotlin.jvm.internal.m.b(alertDialog);
            if (alertDialog.isShowing()) {
                android.app.AlertDialog alertDialog2 = this.f19165K;
                kotlin.jvm.internal.m.b(alertDialog2);
                alertDialog2.dismiss();
            }
        }
        C c5 = new C(this);
        c5.x(arrayList);
        String str2 = null;
        View inflate = getLayoutInflater().inflate(N1.g.dialog_splits_selector, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(N1.f.tv_app_name_dialog_splits);
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        textView.setText(str);
        ((TextView) inflate.findViewById(N1.f.tv_label_packagename_dialog_splits)).setTypeface(aVar.w());
        TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_packagename_dialog_splits);
        textView2.setTypeface(aVar.x());
        a k4 = c5.k();
        if (k4 != null) {
            str2 = k4.c();
        }
        textView2.setText(str2);
        ((TextView) inflate.findViewById(N1.f.tv_label_version_dialog_splits)).setTypeface(aVar.w());
        TextView textView3 = (TextView) inflate.findViewById(N1.f.tv_version_dialog_splits);
        textView3.setTypeface(aVar.x());
        ((TextView) inflate.findViewById(N1.f.tv_label_apps_to_install_dialog_splits)).setTypeface(aVar.w());
        CheckBox checkBox = (CheckBox) inflate.findViewById(N1.f.cb_base_apk_dialog_splits);
        checkBox.setTypeface(aVar.x());
        if (c5.k() != null) {
            StringBuilder sb = new StringBuilder();
            a k5 = c5.k();
            kotlin.jvm.internal.m.b(k5);
            sb.append(k5.e());
            sb.append(" (");
            a k6 = c5.k();
            kotlin.jvm.internal.m.b(k6);
            sb.append(k6.d());
            sb.append(')');
            textView3.setText(sb.toString());
            a k7 = c5.k();
            kotlin.jvm.internal.m.b(k7);
            checkBox.setText(k7.b().getName());
        }
        TextView textView4 = (TextView) inflate.findViewById(N1.f.tv_label_arquitecture_dialog_splits);
        textView4.setTypeface(aVar.w());
        TextView textView5 = (TextView) inflate.findViewById(N1.f.tv_device_supported_abis_dialog_splits);
        textView5.setTypeface(aVar.x());
        View findViewById = inflate.findViewById(N1.f.rv_arquitecture_dialog_splits);
        kotlin.jvm.internal.m.d(findViewById, "view.findViewById(R.id.r…quitecture_dialog_splits)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        if (c5.j().size() > 0) {
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView.addItemDecoration(new u((int) getResources().getDimension(N1.d.margin_generic_item_recyclerview)));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new Q1.c(c5.j(), new d(c5)));
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    StringBuilder sb2 = new StringBuilder();
                    int length = strArr.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        if (i4 == 0) {
                            sb2 = new StringBuilder('(' + strArr[i4]);
                        } else {
                            sb2.append(",");
                            sb2.append(strArr[i4]);
                        }
                    }
                    sb2.append(")");
                    F f4 = F.f20971a;
                    String string = getString(N1.i.device_supported_abis_split_selector);
                    kotlin.jvm.internal.m.d(string, "getString(R.string.devic…rted_abis_split_selector)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{sb2.toString()}, 1));
                    kotlin.jvm.internal.m.d(format, "format(format, *args)");
                    textView5.setText(format);
                }
            }
            textView5.setVisibility(8);
        } else {
            recyclerView.setVisibility(8);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
            inflate.findViewById(N1.f.separator_abis_split_selector).setVisibility(8);
        }
        TextView textView6 = (TextView) inflate.findViewById(N1.f.tv_label_dpi_dialog_splits);
        k.a aVar2 = N1.k.f7778g;
        textView6.setTypeface(aVar2.w());
        TextView textView7 = (TextView) inflate.findViewById(N1.f.tv_device_supported_pdis_dialog_splits);
        textView7.setTypeface(aVar2.x());
        View findViewById2 = inflate.findViewById(N1.f.rv_dpi_dialog_splits);
        kotlin.jvm.internal.m.d(findViewById2, "view.findViewById(R.id.rv_dpi_dialog_splits)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        if (c5.l().size() > 0) {
            recyclerView2.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView2.addItemDecoration(new u((int) getResources().getDimension(N1.d.margin_generic_item_recyclerview)));
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            recyclerView2.setAdapter(new Q1.c(c5.l(), new e(c5)));
            F f5 = F.f20971a;
            String string2 = getString(N1.i.device_supported_dpis_split_selector);
            kotlin.jvm.internal.m.d(string2, "getString(R.string.devic…rted_dpis_split_selector)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{getString(N1.i.dpi_device)}, 1));
            kotlin.jvm.internal.m.d(format2, "format(format, *args)");
            textView7.setText(format2);
        } else {
            recyclerView2.setVisibility(8);
            textView6.setVisibility(8);
            textView7.setVisibility(8);
            inflate.findViewById(N1.f.separator_dpis_split_selector).setVisibility(8);
        }
        TextView textView8 = (TextView) inflate.findViewById(N1.f.tv_label_lang_dialog_splits);
        textView8.setTypeface(aVar2.w());
        TextView textView9 = (TextView) inflate.findViewById(N1.f.tv_device_lang_dialog_splits);
        textView9.setTypeface(aVar2.x());
        View findViewById3 = inflate.findViewById(N1.f.rv_lang_dialog_splits);
        kotlin.jvm.internal.m.d(findViewById3, "view.findViewById(R.id.rv_lang_dialog_splits)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        if (c5.n().size() > 0) {
            recyclerView3.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView3.addItemDecoration(new u((int) getResources().getDimension(N1.d.margin_generic_item_recyclerview)));
            recyclerView3.setItemAnimator(new DefaultItemAnimator());
            recyclerView3.setAdapter(new Q1.c(c5.n(), new g(c5)));
            textView9.setText(getString(N1.i.device_lang_split_selector));
        } else {
            recyclerView3.setVisibility(8);
            textView8.setVisibility(8);
            textView9.setVisibility(8);
            inflate.findViewById(N1.f.separator_lang_split_selector).setVisibility(8);
        }
        TextView textView10 = (TextView) inflate.findViewById(N1.f.tv_label_features_dialog_splits);
        textView10.setTypeface(aVar2.w());
        TextView textView11 = (TextView) inflate.findViewById(N1.f.tv_device_features_dialog_splits);
        textView11.setTypeface(aVar2.x());
        View findViewById4 = inflate.findViewById(N1.f.rv_features_dialog_splits);
        kotlin.jvm.internal.m.d(findViewById4, "view.findViewById(R.id.rv_features_dialog_splits)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        if (c5.m().size() > 0) {
            recyclerView4.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView4.addItemDecoration(new u((int) getResources().getDimension(N1.d.margin_generic_item_recyclerview)));
            recyclerView4.setItemAnimator(new DefaultItemAnimator());
            recyclerView4.setAdapter(new Q1.c(c5.m(), new f(c5)));
        } else {
            recyclerView4.setVisibility(8);
            textView10.setVisibility(8);
            textView11.setVisibility(8);
            inflate.findViewById(N1.f.separator_features_split_selector).setVisibility(8);
        }
        TextView textView12 = (TextView) inflate.findViewById(N1.f.tv_install_dialog_splits);
        textView12.setTypeface(aVar2.w());
        textView12.setOnClickListener(new C1560f0(this, c5));
        TextView textView13 = (TextView) inflate.findViewById(N1.f.tv_cancel_dialog_splits);
        textView13.setTypeface(aVar2.w());
        textView13.setOnClickListener(new C1562g0(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(true);
        this.f19165K = builder.create();
        if (!isFinishing()) {
            android.app.AlertDialog alertDialog3 = this.f19165K;
            if (!(alertDialog3 == null || (window = alertDialog3.getWindow()) == null)) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            android.app.AlertDialog alertDialog4 = this.f19165K;
            if (alertDialog4 != null) {
                alertDialog4.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void s1(InstallerActivity installerActivity, C c5, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(c5, "$splits");
        android.app.AlertDialog alertDialog = installerActivity.f19165K;
        kotlin.jvm.internal.m.b(alertDialog);
        alertDialog.dismiss();
        installerActivity.D1(installerActivity, c5.y());
    }

    /* access modifiers changed from: private */
    public static final void t1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        android.app.AlertDialog alertDialog = installerActivity.f19165K;
        kotlin.jvm.internal.m.b(alertDialog);
        alertDialog.dismiss();
        installerActivity.j1();
    }

    private final void u1() {
        InstallerActivity installerActivity;
        ImageView imageView;
        setContentView(N1.g.installer_activity);
        try {
            this.f19171Q = false;
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                this.f19162H = data;
                if (data != null) {
                    C1612h hVar = new C1612h();
                    Uri uri = this.f19162H;
                    kotlin.jvm.internal.m.b(uri);
                    this.f19159E = hVar.j(uri, this);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("realPath")) {
                        this.f19161G = extras.getString("realPath");
                    }
                    if (extras.containsKey("newFeatures")) {
                        this.f19174T = extras.getString("newFeatures");
                    }
                    if (extras.containsKey("requireUserAction")) {
                        this.f19175U = extras.getBoolean("requireUserAction");
                    }
                    if (extras.containsKey("action")) {
                        this.f19164J = extras.getString("action");
                    }
                    if (extras.containsKey("notificationId")) {
                        k1(this, extras.getInt("notificationId"));
                    }
                    if (extras.containsKey("backgroundInstallation")) {
                        this.f19176V = extras.getBoolean("backgroundInstallation");
                    }
                }
            }
            this.f19183r = (RelativeLayout) findViewById(N1.f.rl_logo_app_detail);
            this.f19172R = (LinearLayout) findViewById(N1.f.ll_installer_activity);
            TextView textView = (TextView) findViewById(N1.f.tv_background_installer_activity);
            this.f19158D = textView;
            kotlin.jvm.internal.m.b(textView);
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            TextView textView2 = this.f19158D;
            kotlin.jvm.internal.m.b(textView2);
            textView2.setOnClickListener(new q0(this));
            this.f19157C = (ImageView) findViewById(N1.f.iv_logo_apk_installer_activity);
            TextView textView3 = (TextView) findViewById(N1.f.tv_file_name_installer_activity);
            this.f19187v = textView3;
            if (textView3 != null) {
                textView3.setTypeface(aVar.x());
            }
            TextView textView4 = (TextView) findViewById(N1.f.tv_app_name_installer_activity);
            this.f19188w = textView4;
            if (textView4 != null) {
                textView4.setTypeface(aVar.w());
            }
            String str = this.f19159E;
            if (str != null) {
                TextView textView5 = this.f19187v;
                if (textView5 != null) {
                    textView5.setText(str);
                }
                String str2 = this.f19159E;
                kotlin.jvm.internal.m.b(str2);
                if (m3.m.o(str2, ".apk", false, 2, (Object) null)) {
                    ImageView imageView2 = this.f19157C;
                    if (imageView2 != null) {
                        imageView2.setImageResource(N1.e.core_vector_apk);
                    }
                } else {
                    String str3 = this.f19159E;
                    kotlin.jvm.internal.m.b(str3);
                    if (m3.m.o(str3, ".xapk", false, 2, (Object) null) && (imageView = this.f19157C) != null) {
                        imageView.setImageResource(N1.e.core_vector_xapk);
                    }
                }
            } else {
                String str4 = this.f19161G;
                if (str4 != null) {
                    TextView textView6 = this.f19187v;
                    if (textView6 != null) {
                        kotlin.jvm.internal.m.b(str4);
                        String str5 = this.f19161G;
                        kotlin.jvm.internal.m.b(str5);
                        String substring = str4.substring(m3.m.R(str5, "/", 0, false, 6, (Object) null) + 1);
                        kotlin.jvm.internal.m.d(substring, "this as java.lang.String).substring(startIndex)");
                        textView6.setText(substring);
                    }
                }
            }
            ProgressBar progressBar = (ProgressBar) findViewById(N1.f.pb_installer_activity);
            this.f19180o = progressBar;
            kotlin.jvm.internal.m.b(progressBar);
            progressBar.setInterpolator(new AccelerateDecelerateInterpolator());
            TextView textView7 = (TextView) findViewById(N1.f.tv_msg_info_installer_activity);
            this.f19181p = textView7;
            if (textView7 != null) {
                textView7.setTypeface(aVar.x());
            }
            TextView textView8 = (TextView) findViewById(N1.f.tv_msg_installer_activity);
            this.f19191z = textView8;
            if (textView8 != null) {
                textView8.setTypeface(aVar.x());
            }
            TextView textView9 = (TextView) findViewById(N1.f.tv_install_installer_activity);
            this.f19155A = textView9;
            if (textView9 != null) {
                textView9.setTypeface(aVar.w());
            }
            TextView textView10 = this.f19155A;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
            TextView textView11 = this.f19155A;
            if (textView11 != null) {
                textView11.setOnClickListener(new r0(this));
            }
            TextView textView12 = (TextView) findViewById(N1.f.tv_cancel_installer_activity);
            this.f19156B = textView12;
            if (textView12 != null) {
                textView12.setTypeface(aVar.w());
            }
            TextView textView13 = this.f19156B;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
            TextView textView14 = this.f19156B;
            if (textView14 != null) {
                textView14.setOnClickListener(new s0(this));
            }
            String str6 = this.f19174T;
            if (str6 == null || str6.length() == 0) {
                installerActivity = this;
            } else {
                TextView textView15 = this.f19181p;
                kotlin.jvm.internal.m.b(textView15);
                textView15.setVisibility(8);
                z zVar = new z();
                LinearLayout linearLayout = (LinearLayout) findViewById(N1.f.ll_show_version_new_features);
                TextView textView16 = (TextView) findViewById(N1.f.tv_version_new_features);
                ImageView imageView3 = (ImageView) findViewById(N1.f.iv_version_new_features);
                textView16.setTypeface(aVar.w());
                TextView textView17 = (TextView) findViewById(N1.f.tv_version_new_features_content);
                textView17.setTypeface(aVar.x());
                textView17.setText(this.f19174T);
                textView17.setVisibility(8);
                ((LinearLayout) findViewById(N1.f.ll_version_new_features)).setVisibility(0);
                installerActivity = this;
                try {
                    linearLayout.setOnClickListener(new t0(zVar, textView16, installerActivity, imageView3, textView17));
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                }
            }
            A1();
            String str7 = installerActivity.f19164J;
            if (str7 == null || !m3.m.p(str7, "delete", true)) {
                installerActivity.f19167M = K1();
                if (!(installerActivity.f19162H == null || installerActivity.f19159E == null)) {
                    C1612h hVar2 = new C1612h();
                    String str8 = installerActivity.f19159E;
                    kotlin.jvm.internal.m.b(str8);
                    if (hVar2.o(str8)) {
                        Uri uri2 = installerActivity.f19162H;
                        kotlin.jvm.internal.m.b(uri2);
                        String str9 = installerActivity.f19159E;
                        kotlin.jvm.internal.m.b(str9);
                        I1(uri2, str9);
                        return;
                    }
                }
                P1(installerActivity.f19161G);
                return;
            }
            LinearLayout linearLayout2 = installerActivity.f19172R;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            RelativeLayout relativeLayout = installerActivity.f19183r;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            TextView textView18 = installerActivity.f19191z;
            if (textView18 != null) {
                textView18.setVisibility(8);
            }
            TextView textView19 = installerActivity.f19158D;
            if (textView19 != null) {
                textView19.setVisibility(8);
            }
            TextView textView20 = installerActivity.f19187v;
            if (textView20 != null) {
                textView20.setText(getString(N1.i.dialog_delete_download_msg, new Object[]{installerActivity.f19161G}));
            }
            TextView textView21 = installerActivity.f19156B;
            if (textView21 != null) {
                textView21.setAllCaps(true);
            }
            TextView textView22 = installerActivity.f19155A;
            if (textView22 != null) {
                textView22.setAllCaps(true);
            }
            TextView textView23 = installerActivity.f19155A;
            if (textView23 != null) {
                textView23.setVisibility(0);
            }
            TextView textView24 = installerActivity.f19155A;
            if (textView24 != null) {
                textView24.setText(N1.i.option_button_delete);
            }
            TextView textView25 = installerActivity.f19155A;
            if (textView25 != null) {
                textView25.setTag(installerActivity.f19161G);
            }
            TextView textView26 = installerActivity.f19155A;
            if (textView26 != null) {
                textView26.setOnClickListener(new u0(this));
            }
            TextView textView27 = installerActivity.f19156B;
            if (textView27 != null) {
                textView27.setVisibility(0);
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void v1(InstallerActivity installerActivity, View view) {
        CharSequence charSequence;
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        TextView textView = installerActivity.f19188w;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        String valueOf = String.valueOf(charSequence);
        Bundle bundle = new Bundle();
        bundle.putString("appNameAndVersion", valueOf);
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((N1.k) application).N().send(222, bundle);
        installerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void w1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        TextView textView = installerActivity.f19155A;
        if (textView != null) {
            textView.setVisibility(8);
        }
        installerActivity.P1(installerActivity.f19161G);
    }

    /* access modifiers changed from: private */
    public static final void x1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        installerActivity.j1();
    }

    /* access modifiers changed from: private */
    public static final void y1(z zVar, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2, View view) {
        kotlin.jvm.internal.m.e(zVar, "$expanded");
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        if (!zVar.f20985a) {
            textView.setText(installerActivity.getString(N1.i.core_installer_new_features_title_hide));
            imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, N1.e.vector_arrow_angle_up_small_off));
            textView2.setVisibility(0);
            zVar.f20985a = true;
            return;
        }
        textView.setText(installerActivity.getString(N1.i.core_installer_new_features_title));
        imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, N1.e.vector_arrow_angle_down_small_off));
        textView2.setVisibility(8);
        zVar.f20985a = false;
    }

    /* access modifiers changed from: private */
    public static final void z1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.m.e(installerActivity, "this$0");
        kotlin.jvm.internal.m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Object tag = view.getTag();
        kotlin.jvm.internal.m.c(tag, "null cannot be cast to non-null type kotlin.String");
        String str = (String) tag;
        TextView textView = installerActivity.f19155A;
        if (textView != null) {
            textView.setVisibility(8);
        }
        new File(str).delete();
        installerActivity.finish();
    }

    public final void C1(Activity activity, File file) {
        kotlin.jvm.internal.m.e(activity, "activity");
        kotlin.jvm.internal.m.e(file, "file");
        P1.a aVar = new P1.a(activity);
        boolean l4 = aVar.l();
        boolean s4 = aVar.s();
        if (!this.f19171Q && F1(file)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            a2(arrayList);
        } else if (!l4 && !s4) {
            B1(file);
        } else if (!aVar.t()) {
            l1(file);
        } else if (!aVar.m()) {
            B1(file);
        } else if (aVar.l()) {
            t.a aVar2 = W1.t.f8713a;
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.m.d(absolutePath, "file.absolutePath");
            aVar2.b(absolutePath, activity, this.f19179Y);
        } else if (aVar.s()) {
            new W1.F(activity, this.f19178X).f(file);
        }
    }

    public final void D1(Activity activity, ArrayList arrayList) {
        kotlin.jvm.internal.m.e(activity, "activity");
        kotlin.jvm.internal.m.e(arrayList, "files");
        P1.a aVar = new P1.a(activity);
        boolean l4 = aVar.l();
        boolean s4 = aVar.s();
        if (!this.f19171Q && G1(arrayList)) {
            a2(arrayList);
        } else if ((l4 || s4) && !aVar.t()) {
            m1(arrayList);
        } else {
            Y1();
            new W1.j(activity, this.f19169O).w(arrayList, this.f19175U);
        }
    }

    public final void E1(String str) {
        if (!(str == null || str.length() == 0)) {
            q0(str);
        }
        j1();
    }

    public final void O1(File file, ArrayList arrayList) {
        String str;
        kotlin.jvm.internal.m.e(arrayList, "files");
        if (new P1.a(this).r()) {
            if (file != null) {
                str = file.getName();
            } else {
                str = null;
            }
            r1(str, arrayList);
            return;
        }
        C c5 = new C(this);
        c5.x(arrayList);
        D1(this, c5.y());
    }

    public final void S1(String str) {
        kotlin.jvm.internal.m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        TextView textView = this.f19191z;
        if (textView != null) {
            textView.setText(str);
        }
        ProgressBar progressBar = this.f19180o;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        getWindow().clearFlags(128);
        C1001s0 s0Var = this.f19168N;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        TextView textView2 = this.f19181p;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.f19156B;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.f19156B;
        if (textView4 != null) {
            textView4.setOnClickListener(new o0(this));
        }
        q0(str);
    }

    public final void U1() {
        runOnUiThread(new n0(this));
    }

    public final void W1(int i4) {
        runOnUiThread(new C1572l0(this, i4));
    }

    public void Y() {
    }

    public void Z() {
    }

    public void a0() {
    }

    public void b0() {
    }

    public void d0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (o3.C0977g.g(r9, r6, r0) != r1) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d2(int r8, V2.d r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.InstallerActivity.r
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.InstallerActivity$r r0 = (com.uptodown.core.activities.InstallerActivity.r) r0
            int r1 = r0.f19238f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19238f = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.InstallerActivity$r r0 = new com.uptodown.core.activities.InstallerActivity$r
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19236d
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19238f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r9)
            goto L_0x007a
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            int r8 = r0.f19235c
            java.lang.Object r2 = r0.f19234b
            kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
            java.lang.Object r4 = r0.f19233a
            com.uptodown.core.activities.InstallerActivity r4 = (com.uptodown.core.activities.InstallerActivity) r4
            R2.n.b(r9)
            goto L_0x0064
        L_0x0043:
            R2.n.b(r9)
            kotlin.jvm.internal.C r2 = new kotlin.jvm.internal.C
            r2.<init>()
            o3.G r9 = o3.Y.b()
            com.uptodown.core.activities.InstallerActivity$s r6 = new com.uptodown.core.activities.InstallerActivity$s
            r6.<init>(r7, r2, r5)
            r0.f19233a = r7
            r0.f19234b = r2
            r0.f19235c = r8
            r0.f19238f = r4
            java.lang.Object r9 = o3.C0977g.g(r9, r6, r0)
            if (r9 != r1) goto L_0x0063
            goto L_0x0079
        L_0x0063:
            r4 = r7
        L_0x0064:
            o3.E0 r9 = o3.Y.c()
            com.uptodown.core.activities.InstallerActivity$t r6 = new com.uptodown.core.activities.InstallerActivity$t
            r6.<init>(r4, r8, r2, r5)
            r0.f19233a = r5
            r0.f19234b = r5
            r0.f19238f = r3
            java.lang.Object r8 = o3.C0977g.g(r9, r6, r0)
            if (r8 != r1) goto L_0x007a
        L_0x0079:
            return r1
        L_0x007a:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.d2(int, V2.d):java.lang.Object");
    }

    public void h0() {
        S1.m mVar;
        if (T() && !new File("/Android/obb").canRead() && (mVar = this.f19170P) != null) {
            mVar.f();
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        k.a aVar = N1.k.f7778g;
        if (aVar.i() == null && aVar.j() == null) {
            u1();
        } else {
            setContentView(N1.g.installer_activity_dialog);
            this.f19173S = true;
            Application application = getApplication();
            kotlin.jvm.internal.m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
            String str = null;
            ((N1.k) application).N().send(224, (Bundle) null);
            TextView textView2 = (TextView) findViewById(N1.f.tv_header_ready_to_install);
            this.f19182q = textView2;
            kotlin.jvm.internal.m.b(textView2);
            textView2.setTypeface(aVar.w());
            this.f19184s = (ImageView) findViewById(N1.f.iv_app_to_install);
            TextView textView3 = (TextView) findViewById(N1.f.tv_app_to_install_name);
            this.f19185t = textView3;
            kotlin.jvm.internal.m.b(textView3);
            textView3.setTypeface(aVar.w());
            TextView textView4 = (TextView) findViewById(N1.f.tv_app_to_install_filename);
            this.f19186u = textView4;
            kotlin.jvm.internal.m.b(textView4);
            textView4.setTypeface(aVar.x());
            TextView textView5 = (TextView) findViewById(N1.f.tv_installation_in_progress_title);
            this.f19189x = textView5;
            kotlin.jvm.internal.m.b(textView5);
            textView5.setTypeface(aVar.x());
            TextView textView6 = (TextView) findViewById(N1.f.tv_cancel_installer_activity);
            this.f19156B = textView6;
            kotlin.jvm.internal.m.b(textView6);
            textView6.setTypeface(aVar.w());
            TextView textView7 = this.f19156B;
            kotlin.jvm.internal.m.b(textView7);
            textView7.setOnClickListener(new C1554c0(this));
            TextView textView8 = (TextView) findViewById(N1.f.tv_install_installer_activity);
            this.f19155A = textView8;
            kotlin.jvm.internal.m.b(textView8);
            textView8.setTypeface(aVar.w());
            TextView textView9 = this.f19155A;
            kotlin.jvm.internal.m.b(textView9);
            textView9.setOnClickListener(new C1574m0(this));
            this.f19180o = (ProgressBar) findViewById(N1.f.pb_installer_activity);
            TextView textView10 = (TextView) findViewById(N1.f.tv_installation_in_progress_filename);
            this.f19190y = textView10;
            kotlin.jvm.internal.m.b(textView10);
            textView10.setTypeface(aVar.x());
            T1.a i4 = aVar.i();
            if (i4 != null) {
                str = i4.a();
            }
            if (!(str == null || (textView = this.f19190y) == null)) {
                textView.setText(str);
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f19177W);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C1001s0 s0Var = this.f19168N;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        getWindow().clearFlags(128);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LinearLayout linearLayout;
        super.onResume();
        if (N1.k.f7778g.i() == null && (linearLayout = this.f19172R) != null && linearLayout.getVisibility() == 0 && this.f19164J == null) {
            finish();
        }
    }
}
