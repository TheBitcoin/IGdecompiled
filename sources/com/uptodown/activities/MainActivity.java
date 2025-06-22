package com.uptodown.activities;

import J1.A0;
import J1.A1;
import J1.B0;
import J1.B1;
import J1.C0;
import J1.C1313a1;
import J1.C1320b1;
import J1.C1327c1;
import J1.C1334d1;
import J1.C1341e1;
import J1.C1348f1;
import J1.C1355g1;
import J1.C1362h1;
import J1.C1369i1;
import J1.C1376j1;
import J1.C1383k1;
import J1.C1390l1;
import J1.C1397m1;
import J1.C1404n1;
import J1.C1411o1;
import J1.C1418p1;
import J1.C1425q1;
import J1.C1431r1;
import J1.C1438s1;
import J1.C1445t1;
import J1.C1452u1;
import J1.C1459v1;
import J1.C1466w1;
import J1.C1472x0;
import J1.C1473x1;
import J1.C1479y0;
import J1.C1480y1;
import J1.C1486z0;
import J1.C1487z1;
import J1.D0;
import J1.F0;
import J1.G0;
import J1.H0;
import J1.I0;
import J1.J0;
import J1.K0;
import J1.M0;
import J1.N0;
import J1.O0;
import J1.P0;
import J1.Q0;
import J1.R0;
import J1.S0;
import J1.T0;
import J1.U0;
import J1.V0;
import J1.W0;
import J1.X0;
import J1.Y0;
import J1.Z0;
import N1.k;
import S2.C1601o;
import V2.d;
import W1.C1612h;
import W1.i;
import W2.b;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import b2.C1632d;
import b2.C1640l;
import c2.C1683p;
import c2.E0;
import c2.L0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.views.ScrollableTextView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetUserDataWorker;
import d2.C1910h;
import d2.C1941r1;
import d2.C2;
import d2.E1;
import d2.H1;
import d2.Q1;
import f2.C2022m;
import f2.C2023n;
import f2.C2026q;
import f2.C2027s;
import g2.C2033A;
import g2.C2039G;
import g2.C2047e;
import g2.C2050h;
import g2.C2052j;
import g2.C2053k;
import g2.C2054l;
import g2.C2059q;
import g2.C2060s;
import g2.L;
import g2.M;
import g2.S;
import g2.U;
import g2.a0;
import h2.C2074f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import m3.h;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.Y;
import u2.C2313C;
import u2.q;
import u2.t;
import w2.C2346d;
import y2.g;

public final class MainActivity extends C1472x0 {

    /* renamed from: J0  reason: collision with root package name */
    public static final C1818b f17773J0 = new C1818b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: A0  reason: collision with root package name */
    public int f17774A0;

    /* renamed from: B0  reason: collision with root package name */
    private C2074f f17775B0;

    /* renamed from: C0  reason: collision with root package name */
    private final k f17776C0 = new k(this);
    /* access modifiers changed from: private */

    /* renamed from: D0  reason: collision with root package name */
    public C2023n f17777D0 = new C1825i(this);

    /* renamed from: E0  reason: collision with root package name */
    private final ActivityResultLauncher f17778E0;

    /* renamed from: F0  reason: collision with root package name */
    private final ActivityResultLauncher f17779F0;

    /* renamed from: G0  reason: collision with root package name */
    private final ActivityResultLauncher f17780G0;

    /* renamed from: H0  reason: collision with root package name */
    private final o f17781H0;

    /* renamed from: I0  reason: collision with root package name */
    private final ActivityResultLauncher f17782I0;

    /* renamed from: N  reason: collision with root package name */
    private RelativeLayout f17783N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public int f17784O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public ArrayList f17785P = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public boolean f17786Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public RelativeLayout f17787R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public Toolbar f17788S;

    /* renamed from: T  reason: collision with root package name */
    private AppBarLayout f17789T;

    /* renamed from: U  reason: collision with root package name */
    private SwitchCompat f17790U;

    /* renamed from: V  reason: collision with root package name */
    private SwitchCompat f17791V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public TabLayout f17792W;

    /* renamed from: X  reason: collision with root package name */
    private C2050h f17793X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public ViewPager2 f17794Y;

    /* renamed from: Z  reason: collision with root package name */
    private RelativeLayout f17795Z;

    /* renamed from: m0  reason: collision with root package name */
    private RelativeLayout f17796m0;

    /* renamed from: n0  reason: collision with root package name */
    private ProgressBar f17797n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public TabLayout f17798o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public H1 f17799p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public Q1 f17800q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public E1 f17801r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public C2 f17802s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public ArrayList f17803t0 = new ArrayList();

    /* renamed from: u0  reason: collision with root package name */
    private ArrayList f17804u0 = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public long f17805v0 = -1;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public FrameLayout f17806w0;

    /* renamed from: x0  reason: collision with root package name */
    private E0 f17807x0;
    /* access modifiers changed from: private */

    /* renamed from: y0  reason: collision with root package name */
    public FrameLayout f17808y0;
    /* access modifiers changed from: private */

    /* renamed from: z0  reason: collision with root package name */
    public FrameLayout f17809z0;

    public static final class A implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f17810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17811b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ S f17812c;

        A(TextView textView, MainActivity mainActivity, S s4) {
            this.f17810a = textView;
            this.f17811b = mainActivity;
            this.f17812c = s4;
        }

        public void b(int i4) {
            this.f17810a.setText(this.f17811b.getResources().getString(R.string.msg_no_version_details, new Object[]{this.f17811b.getResources().getString(R.string.app_name) + " v." + this.f17812c.k()}));
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            String M4 = hVar.M();
            if (M4 == null || M4.length() == 0) {
                this.f17810a.setText(this.f17811b.getResources().getString(R.string.msg_no_version_details, new Object[]{this.f17811b.getResources().getString(R.string.app_name) + " v." + this.f17812c.k()}));
                return;
            }
            this.f17810a.setText(hVar.M());
        }
    }

    public static final class B implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f17813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Animation f17814b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f17815c;

        B(ImageView imageView, Animation animation, ImageView imageView2) {
            this.f17813a = imageView;
            this.f17814b = animation;
            this.f17815c = imageView2;
        }

        /* access modifiers changed from: private */
        public static final void b(ImageView imageView, Animation animation, ImageView imageView2, Animation animation2) {
            imageView.startAnimation(animation);
            imageView2.startAnimation(animation2);
        }

        public void onAnimationEnd(Animation animation) {
            new Handler(Looper.getMainLooper()).postDelayed(new B1(this.f17813a, this.f17814b, this.f17815c, animation), 1500);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class C extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17816a;

        C(MainActivity mainActivity) {
            this.f17816a = mainActivity;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.m.e(view, "widget");
        }

        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.m.e(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(ContextCompat.getColor(this.f17816a, R.color.main_blue));
            textPaint.setTypeface(N1.k.f7778g.w());
            textPaint.setUnderlineText(false);
        }
    }

    public static final class D extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17817a;

        D(MainActivity mainActivity) {
            this.f17817a = mainActivity;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.m.e(view, "widget");
        }

        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.m.e(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(ContextCompat.getColor(this.f17817a, R.color.turbo_text_featured));
            textPaint.setTypeface(N1.k.f7778g.w());
            textPaint.setUnderlineText(false);
        }
    }

    static final class E extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17818a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17819b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17820c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        E(MainActivity mainActivity, String str, d dVar) {
            super(2, dVar);
            this.f17819b = mainActivity;
            this.f17820c = str;
        }

        public final d create(Object obj, d dVar) {
            return new E(this.f17819b, this.f17820c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f17818a == 0) {
                R2.n.b(obj);
                Fragment K5 = this.f17819b.K5();
                if (K5 instanceof C1941r1) {
                    ((C1941r1) K5).q7(this.f17820c);
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((E) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class F extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17822b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17823c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        F(MainActivity mainActivity, String str, d dVar) {
            super(2, dVar);
            this.f17822b = mainActivity;
            this.f17823c = str;
        }

        public final d create(Object obj, d dVar) {
            return new F(this.f17822b, this.f17823c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f17821a == 0) {
                R2.n.b(obj);
                Fragment K5 = this.f17822b.K5();
                if (K5 instanceof C1941r1) {
                    ((C1941r1) K5).r7(this.f17823c);
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((F) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class G extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17825b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.A f17826c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.A f17827d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f17828a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MainActivity f17829b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.C f17830c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.A f17831d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.A f17832e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MainActivity mainActivity, kotlin.jvm.internal.C c5, kotlin.jvm.internal.A a5, kotlin.jvm.internal.A a6, d dVar) {
                super(2, dVar);
                this.f17829b = mainActivity;
                this.f17830c = c5;
                this.f17831d = a5;
                this.f17832e = a6;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f17829b, this.f17830c, this.f17831d, this.f17832e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                boolean z4;
                b.c();
                if (this.f17828a == 0) {
                    R2.n.b(obj);
                    MainActivity mainActivity = this.f17829b;
                    Drawable drawable = (Drawable) this.f17830c.f20968a;
                    if (this.f17831d.f20966a + this.f17832e.f20966a > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    mainActivity.m7(drawable, z4);
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        G(MainActivity mainActivity, kotlin.jvm.internal.A a5, kotlin.jvm.internal.A a6, d dVar) {
            super(2, dVar);
            this.f17825b = mainActivity;
            this.f17826c = a5;
            this.f17827d = a6;
        }

        public final d create(Object obj, d dVar) {
            return new G(this.f17825b, this.f17826c, this.f17827d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String c5;
            Object c6 = b.c();
            int i4 = this.f17824a;
            if (i4 == 0) {
                R2.n.b(obj);
                if (this.f17825b.getApplicationContext() != null) {
                    kotlin.jvm.internal.A a5 = this.f17826c;
                    S.b bVar = S.f20455j;
                    Context applicationContext = this.f17825b.getApplicationContext();
                    kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
                    a5.f20966a = bVar.a(applicationContext);
                    t.a aVar = u2.t.f21927u;
                    Context applicationContext2 = this.f17825b.getApplicationContext();
                    kotlin.jvm.internal.m.d(applicationContext2, "getApplicationContext(...)");
                    u2.t a6 = aVar.a(applicationContext2);
                    a6.a();
                    ArrayList m02 = a6.m0();
                    a6.i();
                    Iterator it = m02.iterator();
                    kotlin.jvm.internal.m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        kotlin.jvm.internal.m.d(next, "next(...)");
                        C2060s sVar = (C2060s) next;
                        if (sVar.k() == 0 && sVar.f()) {
                            this.f17827d.f20966a++;
                        }
                    }
                    kotlin.jvm.internal.C c7 = new kotlin.jvm.internal.C();
                    U.b bVar2 = U.f20468m;
                    U e5 = bVar2.e(this.f17825b);
                    if (!(e5 == null || (c5 = e5.c()) == null || c5.length() == 0)) {
                        try {
                            c7.f20968a = new BitmapDrawable(this.f17825b.getResources(), com.squareup.picasso.s.h().l(bVar2.c(e5.a())).n(UptodownApp.f17422D.i0(this.f17825b)).g());
                        } catch (IOException unused) {
                        }
                    }
                    o3.E0 c8 = Y.c();
                    a aVar2 = new a(this.f17825b, c7, this.f17827d, this.f17826c, (d) null);
                    this.f17824a = 1;
                    if (C0977g.g(c8, aVar2, this) == c6) {
                        return c6;
                    }
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((G) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class H extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17833a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17834b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        H(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17834b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new H(this.f17834b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (com.uptodown.activities.MainActivity.q5(r6, r5) == r0) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (o3.U.b(1000, r5) == r0) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f17833a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r6)
                goto L_0x0037
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                R2.n.b(r6)
                goto L_0x002c
            L_0x001e:
                R2.n.b(r6)
                r5.f17833a = r3
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r6 = o3.U.b(r3, r5)
                if (r6 != r0) goto L_0x002c
                goto L_0x0036
            L_0x002c:
                com.uptodown.activities.MainActivity r6 = r5.f17834b
                r5.f17833a = r2
                java.lang.Object r6 = r6.Y7(r5)
                if (r6 != r0) goto L_0x0037
            L_0x0036:
                return r0
            L_0x0037:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.H.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((H) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class I extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17835a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17836b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f17837c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2060s f17838d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        I(int i4, MainActivity mainActivity, C2060s sVar, d dVar) {
            super(2, dVar);
            this.f17836b = i4;
            this.f17837c = mainActivity;
            this.f17838d = sVar;
        }

        public final d create(Object obj, d dVar) {
            return new I(this.f17836b, this.f17837c, this.f17838d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
            if (((d2.C1941r1) r5).Y3().e() != r4.f17838d.h()) goto L_0x009c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                W2.b.c()
                int r0 = r4.f17835a
                if (r0 != 0) goto L_0x00b0
                R2.n.b(r5)
                int r5 = r4.f17836b
                r0 = 202(0xca, float:2.83E-43)
                if (r5 == r0) goto L_0x0014
                r0 = 203(0xcb, float:2.84E-43)
                if (r5 != r0) goto L_0x0019
            L_0x0014:
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                r5.Z7()
            L_0x0019:
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                int r0 = r4.f17836b
                g2.s r1 = r4.f17838d
                r5.V7(r0, r1)
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                g2.s r0 = r4.f17838d
                java.lang.String r0 = r0.w()
                r5.c8(r0)
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                g2.s r0 = r4.f17838d
                java.lang.String r0 = r0.w()
                r5.X7(r0)
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                g2.s r0 = r4.f17838d
                java.lang.String r0 = r0.w()
                r5.a8(r0)
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                g2.s r0 = r4.f17838d
                java.lang.String r0 = r0.w()
                r5.S7(r0)
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                y2.g r5 = r5.k2()
                if (r5 == 0) goto L_0x005f
                g2.s r0 = r4.f17838d
                int r1 = r4.f17836b
                com.uptodown.activities.MainActivity r2 = r4.f17837c
                r5.N(r0, r1, r2)
            L_0x005f:
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                androidx.fragment.app.Fragment r5 = r5.K5()
                boolean r5 = r5 instanceof d2.C1941r1
                if (r5 != 0) goto L_0x0073
                N1.k$a r5 = N1.k.f7778g
                android.app.Activity r5 = r5.g()
                boolean r5 = r5 instanceof com.uptodown.activities.MainActivity
                if (r5 != 0) goto L_0x009c
            L_0x0073:
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                androidx.fragment.app.Fragment r5 = r5.K5()
                boolean r5 = r5 instanceof d2.C1941r1
                if (r5 == 0) goto L_0x00ad
                com.uptodown.activities.MainActivity r5 = r4.f17837c
                androidx.fragment.app.Fragment r5 = r5.K5()
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.fragments.AppDetailsFragment"
                kotlin.jvm.internal.m.c(r5, r0)
                d2.r1 r5 = (d2.C1941r1) r5
                g2.h r5 = r5.Y3()
                long r0 = r5.e()
                g2.s r5 = r4.f17838d
                long r2 = r5.h()
                int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r5 == 0) goto L_0x00ad
            L_0x009c:
                g2.s r5 = r4.f17838d
                boolean r5 = r5.f()
                if (r5 == 0) goto L_0x00ad
                u2.C r5 = u2.C2313C.f21882a
                com.uptodown.activities.MainActivity r0 = r4.f17837c
                g2.s r1 = r4.f17838d
                r5.k(r0, r1)
            L_0x00ad:
                R2.s r5 = R2.s.f8222a
                return r5
            L_0x00b0:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.I.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((I) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$a  reason: case insensitive filesystem */
    public final class C1817a implements Runnable {
        public C1817a() {
        }

        public void run() {
            LinearLayout linearLayout = (LinearLayout) MainActivity.this.findViewById(R.id.ll_auto_update);
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                MainActivity.this.d7();
            }
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$b  reason: case insensitive filesystem */
    public static final class C1818b {
        public /* synthetic */ C1818b(C2103g gVar) {
            this();
        }

        private C1818b() {
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$c  reason: case insensitive filesystem */
    public final class C1819c implements Runnable {
        public C1819c() {
        }

        public void run() {
            MainActivity.this.h7();
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$d  reason: case insensitive filesystem */
    public final class C1820d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f17841a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17842b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f17843c;

        public C1820d(MainActivity mainActivity, int i4, String str) {
            kotlin.jvm.internal.m.e(str, "packagename");
            this.f17843c = mainActivity;
            this.f17841a = i4;
            this.f17842b = str;
        }

        public void run() {
            Fragment K5 = this.f17843c.K5();
            if (K5 instanceof C1941r1) {
                this.f17843c.runOnUiThread(new C1941r1.C1944c((C1941r1) K5, this.f17842b, this.f17841a));
            }
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$e  reason: case insensitive filesystem */
    public final class C1821e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f17844a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17845b;

        public C1821e(int i4, String str) {
            this.f17844a = i4;
            this.f17845b = str;
        }

        public void run() {
            S s4;
            if (this.f17845b != null) {
                t.a aVar = u2.t.f21927u;
                Context baseContext = MainActivity.this.getBaseContext();
                kotlin.jvm.internal.m.d(baseContext, "getBaseContext(...)");
                u2.t a5 = aVar.a(baseContext);
                a5.a();
                s4 = a5.D0(this.f17845b);
                a5.i();
            } else {
                s4 = null;
            }
            MainActivity.this.W7(this.f17844a, s4);
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$f  reason: case insensitive filesystem */
    public static final class C1822f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17847a;

        C1822f(MainActivity mainActivity) {
            this.f17847a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            int y4 = this.f17847a.G5();
            if (y4 < 0 || y4 >= this.f17847a.f17785P.size()) {
                ((a0) this.f17847a.f17785P.get(this.f17847a.f17784O)).c().setVisibility(8);
                this.f17847a.finish();
            } else {
                RelativeLayout K4 = this.f17847a.f17787R;
                if (K4 != null) {
                    K4.removeAllViews();
                }
                RelativeLayout c5 = ((a0) this.f17847a.f17785P.get(y4)).c();
                RelativeLayout K42 = this.f17847a.f17787R;
                if (K42 != null) {
                    K42.addView(c5);
                }
                new y2.n(this.f17847a).h(c5, R.anim.slide_back_in);
            }
            this.f17847a.f17786Q = false;
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            this.f17847a.f17786Q = true;
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$g  reason: case insensitive filesystem */
    public static final class C1823g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17848a;

        C1823g(MainActivity mainActivity) {
            this.f17848a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            int I4 = this.f17848a.L5();
            if (I4 < 0 || I4 >= this.f17848a.f17785P.size()) {
                this.f17848a.b7();
                return;
            }
            MainActivity mainActivity = this.f17848a;
            Object obj = mainActivity.f17785P.get(I4);
            kotlin.jvm.internal.m.d(obj, "get(...)");
            mainActivity.o7((a0) obj);
            if (((a0) this.f17848a.f17785P.get(this.f17848a.f17784O)).a() == 2 && ((a0) this.f17848a.f17785P.get(0)).a() == 1) {
                ((a0) this.f17848a.f17785P.get(0)).c().removeAllViews();
                this.f17848a.f17785P.remove(0);
                this.f17848a.f17784O = 0;
            }
            this.f17848a.e8();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$h  reason: case insensitive filesystem */
    public static final class C1824h implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17849a;

        C1824h(MainActivity mainActivity) {
            this.f17849a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            FrameLayout B4 = this.f17849a.f17806w0;
            kotlin.jvm.internal.m.b(B4);
            B4.removeAllViews();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$i  reason: case insensitive filesystem */
    public static final class C1825i implements C2023n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17850a;

        C1825i(MainActivity mainActivity) {
            this.f17850a = mainActivity;
        }

        public void a() {
            FrameLayout A4 = this.f17850a.f17809z0;
            if (A4 != null) {
                A4.removeAllViews();
            }
        }

        public void b() {
            this.f17850a.g6();
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17852b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f17853a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MainActivity f17854b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.C f17855c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MainActivity mainActivity, kotlin.jvm.internal.C c5, d dVar) {
                super(2, dVar);
                this.f17854b = mainActivity;
                this.f17855c = c5;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f17854b, this.f17855c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17853a == 0) {
                    R2.n.b(obj);
                    TabLayout J4 = this.f17854b.f17792W;
                    kotlin.jvm.internal.m.b(J4);
                    TabLayout.Tab newTab = J4.newTab();
                    kotlin.jvm.internal.m.d(newTab, "newTab(...)");
                    View inflate = LayoutInflater.from(this.f17854b).inflate(R.layout.home_header_parent_category, this.f17854b.f17788S, false);
                    kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView = (TextView) inflate;
                    textView.setTypeface(N1.k.f7778g.w());
                    textView.setText(this.f17854b.getString(R.string.for_you_category));
                    newTab.setCustomView((View) textView);
                    newTab.setTag(kotlin.coroutines.jvm.internal.b.b(0));
                    TabLayout J42 = this.f17854b.f17792W;
                    kotlin.jvm.internal.m.b(J42);
                    J42.addTab(newTab);
                    Iterator it = ((ArrayList) this.f17855c.f20968a).iterator();
                    kotlin.jvm.internal.m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        kotlin.jvm.internal.m.d(next, "next(...)");
                        C2053k kVar = (C2053k) next;
                        TabLayout J43 = this.f17854b.f17792W;
                        kotlin.jvm.internal.m.b(J43);
                        TabLayout.Tab newTab2 = J43.newTab();
                        View inflate2 = LayoutInflater.from(this.f17854b).inflate(R.layout.home_header_parent_category, this.f17854b.f17788S, false);
                        kotlin.jvm.internal.m.c(inflate2, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView2 = (TextView) inflate2;
                        textView2.setTypeface(N1.k.f7778g.x());
                        textView2.setText(kVar.d());
                        newTab2.setCustomView((View) textView2);
                        newTab2.setTag(kVar);
                        TabLayout J44 = this.f17854b.f17792W;
                        kotlin.jvm.internal.m.b(J44);
                        J44.addTab(newTab2);
                    }
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        public static final class b implements TabLayout.OnTabSelectedListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MainActivity f17856a;

            b(MainActivity mainActivity) {
                this.f17856a = mainActivity;
            }

            public void onTabReselected(TabLayout.Tab tab) {
                kotlin.jvm.internal.m.e(tab, "tab");
            }

            public void onTabSelected(TabLayout.Tab tab) {
                kotlin.jvm.internal.m.e(tab, "tab");
                TabLayout J4 = this.f17856a.f17792W;
                kotlin.jvm.internal.m.b(J4);
                View childAt = J4.getChildAt(0);
                kotlin.jvm.internal.m.c(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                View findViewById = ((ViewGroup) childAt).getChildAt(tab.getPosition()).findViewById(R.id.tv_home_header_parent_category);
                kotlin.jvm.internal.m.d(findViewById, "findViewById(...)");
                ((TextView) findViewById).setTypeface(N1.k.f7778g.w());
                this.f17856a.I7();
                if (kotlin.jvm.internal.m.a(tab.getTag(), 0)) {
                    this.f17856a.j8();
                    return;
                }
                Object tag = tab.getTag();
                kotlin.jvm.internal.m.c(tag, "null cannot be cast to non-null type com.uptodown.models.Category");
                C2053k kVar = (C2053k) tag;
                if (kVar.b() != 523) {
                    this.f17856a.f17774A0 = tab.getPosition();
                }
                this.f17856a.l8(kVar);
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                kotlin.jvm.internal.m.e(tab, "tab");
                TabLayout J4 = this.f17856a.f17792W;
                kotlin.jvm.internal.m.b(J4);
                View childAt = J4.getChildAt(0);
                kotlin.jvm.internal.m.c(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                View findViewById = ((ViewGroup) childAt).getChildAt(tab.getPosition()).findViewById(R.id.tv_home_header_parent_category);
                kotlin.jvm.internal.m.d(findViewById, "findViewById(...)");
                ((TextView) findViewById).setTypeface(N1.k.f7778g.x());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17852b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new j(this.f17852b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17851a;
            if (i4 == 0) {
                R2.n.b(obj);
                kotlin.jvm.internal.C c6 = new kotlin.jvm.internal.C();
                c6.f20968a = new ArrayList();
                u2.t a5 = u2.t.f21927u.a(this.f17852b);
                a5.a();
                M C02 = a5.C0("categories");
                if (C02 == null || !C02.a()) {
                    L q4 = new u2.L(this.f17852b).q();
                    if (!q4.b() && q4.d() != null) {
                        C2053k.b bVar = C2053k.f20690g;
                        String d5 = q4.d();
                        kotlin.jvm.internal.m.b(d5);
                        c6.f20968a = C2053k.b.b(bVar, d5, 0, 2, (Object) null);
                        String d6 = q4.d();
                        kotlin.jvm.internal.m.b(d6);
                        M m4 = new M("categories", d6);
                        a5.Q("categories");
                        a5.W0(m4);
                    }
                } else {
                    c6.f20968a = C2053k.b.b(C2053k.f20690g, C02.b(), 0, 2, (Object) null);
                }
                a5.i();
                if (!((Collection) c6.f20968a).isEmpty()) {
                    o3.E0 c7 = Y.c();
                    a aVar = new a(this.f17852b, c6, (d) null);
                    this.f17851a = 1;
                    if (C0977g.g(c7, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TabLayout J4 = this.f17852b.f17792W;
            kotlin.jvm.internal.m.b(J4);
            J4.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b(this.f17852b));
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class k implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17857a;

        k(MainActivity mainActivity) {
            this.f17857a = mainActivity;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (this.f17857a.Z5()) {
                this.f17857a.Z2(hVar);
            }
        }
    }

    public static final class l implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17858a;

        l(MainActivity mainActivity) {
            this.f17858a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            FrameLayout C4 = this.f17858a.f17808y0;
            kotlin.jvm.internal.m.b(C4);
            C4.removeAllViews();
            this.f17858a.f17808y0 = null;
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17859a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17860b;

        public static final class a implements C2026q {
            a() {
            }

            public void a() {
            }

            public void b() {
            }
        }

        static final class b extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f17861a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MainActivity f17862b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(MainActivity mainActivity, d dVar) {
                super(2, dVar);
                this.f17862b = mainActivity;
            }

            public final d create(Object obj, d dVar) {
                return new b(this.f17862b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17861a == 0) {
                    R2.n.b(obj);
                    this.f17862b.g6();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17860b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new m(this.f17860b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (o3.U.b(com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, r5) == r0) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f17859a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r6)
                goto L_0x0063
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                R2.n.b(r6)
                goto L_0x003d
            L_0x001e:
                R2.n.b(r6)
                g2.U$b r6 = g2.U.f20468m
                com.uptodown.activities.MainActivity r1 = r5.f17860b
                g2.U r6 = r6.e(r1)
                if (r6 == 0) goto L_0x0032
                boolean r6 = r6.n()
                if (r6 == 0) goto L_0x0032
                goto L_0x0089
            L_0x0032:
                r5.f17859a = r3
                r3 = 2000(0x7d0, double:9.88E-321)
                java.lang.Object r6 = o3.U.b(r3, r5)
                if (r6 != r0) goto L_0x003d
                goto L_0x0062
            L_0x003d:
                g2.j$a r6 = g2.C2052j.f20686n
                com.uptodown.activities.MainActivity r1 = r5.f17860b
                g2.j r6 = r6.d(r1)
                if (r6 == 0) goto L_0x0066
                boolean r6 = r6.d()
                if (r6 == 0) goto L_0x004e
                goto L_0x0066
            L_0x004e:
                o3.E0 r6 = o3.Y.c()
                com.uptodown.activities.MainActivity$m$b r1 = new com.uptodown.activities.MainActivity$m$b
                com.uptodown.activities.MainActivity r3 = r5.f17860b
                r4 = 0
                r1.<init>(r3, r4)
                r5.f17859a = r2
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0063
            L_0x0062:
                return r0
            L_0x0063:
                R2.s r6 = R2.s.f8222a
                goto L_0x0089
            L_0x0066:
                b2.e r6 = new b2.e
                com.uptodown.activities.MainActivity r0 = r5.f17860b
                f2.n r1 = r0.f17777D0
                com.uptodown.activities.MainActivity r2 = r5.f17860b
                androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r2)
                r6.<init>(r0, r1, r2)
                b2.h r6 = new b2.h
                com.uptodown.activities.MainActivity r0 = r5.f17860b
                com.uptodown.activities.MainActivity$m$a r1 = new com.uptodown.activities.MainActivity$m$a
                r1.<init>()
                com.uptodown.activities.MainActivity r2 = r5.f17860b
                androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r2)
                r6.<init>(r0, r1, r2)
            L_0x0089:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class n implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2052j f17863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17864b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f17865c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImageView f17866d;

        n(C2052j jVar, MainActivity mainActivity, View view, ImageView imageView) {
            this.f17863a = jVar;
            this.f17864b = mainActivity;
            this.f17865c = view;
            this.f17866d = imageView;
        }

        /* access modifiers changed from: private */
        public static final void d(ImageView imageView, C2052j jVar, MainActivity mainActivity) {
            if (new u2.q().p(imageView)) {
                jVar.j(mainActivity);
            }
        }

        public void a(Exception exc) {
            this.f17863a.g(this.f17864b);
            FrameLayout A4 = this.f17864b.f17809z0;
            if (A4 != null) {
                A4.removeAllViews();
            }
        }

        public void b() {
            this.f17863a.h(this.f17864b);
            FrameLayout A4 = this.f17864b.f17809z0;
            if (A4 != null) {
                A4.addView(this.f17865c);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new A1(this.f17866d, this.f17863a, this.f17864b), 500);
        }
    }

    public static final class o extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17867a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(MainActivity mainActivity) {
            super(true);
            this.f17867a = mainActivity;
        }

        public void handleOnBackPressed() {
            g k22 = this.f17867a.k2();
            if (k22 == null || !k22.l(this.f17867a)) {
                boolean popBackStackImmediate = this.f17867a.getSupportFragmentManager().popBackStackImmediate();
                int backStackEntryCount = this.f17867a.getSupportFragmentManager().getBackStackEntryCount();
                if (!popBackStackImmediate || backStackEntryCount < 0) {
                    RelativeLayout M5 = this.f17867a.M5();
                    if (M5 != null) {
                        M5.setVisibility(8);
                    }
                    int size = this.f17867a.f17803t0.size();
                    if (size > 0) {
                        Fragment fragment = (Fragment) C1601o.P(this.f17867a.f17803t0);
                        this.f17867a.f17803t0.remove(size - 1);
                        if (fragment instanceof H1) {
                            H1 h12 = (H1) fragment;
                            if (h12.u() != null) {
                                C2053k u4 = h12.u();
                                kotlin.jvm.internal.m.b(u4);
                                if (u4.b() == 523) {
                                    this.f17867a.w5(1);
                                    return;
                                }
                            }
                            this.f17867a.j8();
                        } else if (!this.f17867a.Z5()) {
                            this.f17867a.finish();
                        } else {
                            if (this.f17867a.f17787R != null) {
                                RelativeLayout K4 = this.f17867a.f17787R;
                                kotlin.jvm.internal.m.b(K4);
                                if (K4.getVisibility() == 0) {
                                    this.f17867a.t5();
                                    return;
                                }
                            }
                            ViewPager2 P4 = this.f17867a.f17794Y;
                            if (P4 == null || P4.getCurrentItem() != 0) {
                                this.f17867a.w5(0);
                            } else {
                                this.f17867a.finish();
                            }
                        }
                    } else if (!this.f17867a.Z5()) {
                        this.f17867a.finish();
                    } else {
                        if (this.f17867a.f17787R != null) {
                            RelativeLayout K42 = this.f17867a.f17787R;
                            kotlin.jvm.internal.m.b(K42);
                            if (K42.getVisibility() == 0) {
                                this.f17867a.t5();
                                return;
                            }
                        }
                        ViewPager2 P42 = this.f17867a.f17794Y;
                        if (P42 == null || P42.getCurrentItem() != 0) {
                            this.f17867a.w5(0);
                        } else {
                            this.f17867a.finish();
                        }
                    }
                } else if (this.f17867a.K5() instanceof C1941r1) {
                    RelativeLayout M52 = this.f17867a.M5();
                    if (M52 != null) {
                        M52.setVisibility(0);
                    }
                    Fragment K5 = this.f17867a.K5();
                    kotlin.jvm.internal.m.c(K5, "null cannot be cast to non-null type com.uptodown.fragments.AppDetailsFragment");
                    ((C1941r1) K5).X2(this.f17867a);
                } else {
                    RelativeLayout M53 = this.f17867a.M5();
                    if (M53 != null) {
                        M53.setVisibility(8);
                    }
                    if (this.f17867a.K5() == null || (this.f17867a.K5() instanceof E1) || (this.f17867a.K5() instanceof H1)) {
                        TabLayout L4 = this.f17867a.f17798o0;
                        if (L4 == null || L4.getSelectedTabPosition() != 2) {
                            this.f17867a.I7();
                        }
                    }
                }
            }
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17869b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17869b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new p(this.f17869b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f17868a;
            if (i4 == 0) {
                R2.n.b(obj);
                MainActivity mainActivity = this.f17869b;
                this.f17868a = 1;
                if (mainActivity.H5(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((p) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class q implements C2022m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17871b;

        q(MainActivity mainActivity, String str) {
            this.f17870a = mainActivity;
            this.f17871b = str;
        }

        public void a(long j4, long j5, String str, long j6, boolean z4) {
            if (z4) {
                DownloadApkWorker.f19447i.a(this.f17870a, this.f17871b);
                this.f17870a.V6();
                return;
            }
            this.f17870a.S6(j4, j5, str, j6, this.f17871b);
        }

        public void b() {
            MainActivity mainActivity = this.f17870a;
            String string = mainActivity.getString(R.string.app_detail_not_available);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            mainActivity.q0(string);
        }
    }

    static final class r extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17872a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17873b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f17874c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(MainActivity mainActivity, s sVar, d dVar) {
            super(2, dVar);
            this.f17873b = mainActivity;
            this.f17874c = sVar;
        }

        public final d create(Object obj, d dVar) {
            return new r(this.f17873b, this.f17874c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f17872a;
            if (i4 == 0) {
                R2.n.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f19472b;
                MainActivity mainActivity = this.f17873b;
                s sVar = this.f17874c;
                this.f17872a = 1;
                if (aVar.a(mainActivity, sVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((r) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class s implements f2.M {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17875a;

        s(MainActivity mainActivity) {
            this.f17875a = mainActivity;
        }

        public void a() {
            C2 O4 = this.f17875a.f17802s0;
            if (O4 != null) {
                O4.N0();
            }
            this.f17875a.O7();
        }
    }

    public static final class t implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17876a;

        t(MainActivity mainActivity) {
            this.f17876a = mainActivity;
        }

        public void b(int i4) {
            this.f17876a.f17805v0 = -1;
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f17876a.Z2(hVar);
            this.f17876a.f17805v0 = -1;
        }
    }

    public static final class u implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f17877a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f17878b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17879c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MainActivity f17880d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f17881e;

        u(long j4, long j5, String str, MainActivity mainActivity, String str2) {
            this.f17877a = j4;
            this.f17878b = j5;
            this.f17879c = str;
            this.f17880d = mainActivity;
            this.f17881e = str2;
        }

        public void b(int i4) {
            this.f17880d.f17805v0 = -1;
            MainActivity mainActivity = this.f17880d;
            String string = mainActivity.getString(R.string.app_detail_not_available);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            mainActivity.q0(string);
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (hVar.E0() && hVar.B0()) {
                C2060s sVar = new C2060s();
                sVar.T(hVar.e());
                sVar.U(hVar.L());
                hVar.N0(this.f17877a);
                sVar.c0(this.f17878b);
                hVar.U0(this.f17877a);
                hVar.T0(this.f17879c);
                sVar.Z(hVar.Q());
                sVar.b0(hVar.C());
                C2060s.c cVar = new C2060s.c();
                cVar.m(this.f17877a);
                cVar.n(this.f17879c);
                sVar.o().add(cVar);
                sVar.Q(this.f17880d);
                DownloadApkWorker.f19447i.b(this.f17880d, this.f17881e, sVar.q());
                this.f17880d.Z2(hVar);
            }
            this.f17880d.f17805v0 = -1;
        }
    }

    static final class v extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17882a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17883b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17883b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new v(this.f17883b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f17882a == 0) {
                R2.n.b(obj);
                Fragment K5 = this.f17883b.K5();
                if (K5 instanceof C1941r1) {
                    ((C1941r1) K5).g6();
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((v) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class w implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17884a;

        w(MainActivity mainActivity) {
            this.f17884a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
            this.f17884a.Q5();
            this.f17884a.a7();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.m.e(animation, "animation");
        }
    }

    static final class x extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f17885a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f17886b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(MainActivity mainActivity, d dVar) {
            super(2, dVar);
            this.f17886b = mainActivity;
        }

        public final d create(Object obj, d dVar) {
            return new x(this.f17886b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f17885a;
            if (i4 == 0) {
                R2.n.b(obj);
                MainActivity mainActivity = this.f17886b;
                this.f17885a = 1;
                if (mainActivity.H5(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((x) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public static final class y implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17887a;

        y(MainActivity mainActivity) {
            this.f17887a = mainActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
            Q1 N4;
            kotlin.jvm.internal.m.e(tab, "tab");
            if (tab.getPosition() == 0) {
                if (this.f17887a.f17801r0 != null) {
                    this.f17887a.j8();
                    this.f17887a.I7();
                    E1 G4 = this.f17887a.f17801r0;
                    kotlin.jvm.internal.m.b(G4);
                    G4.F();
                }
            } else if (tab.getPosition() == 1) {
                if (this.f17887a.f17799p0 != null) {
                    this.f17887a.I7();
                    H1 E4 = this.f17887a.f17799p0;
                    kotlin.jvm.internal.m.b(E4);
                    E4.x();
                }
            } else if (tab.getPosition() == 2 && (N4 = this.f17887a.f17800q0) != null) {
                N4.V();
            }
        }

        public void onTabSelected(TabLayout.Tab tab) {
            kotlin.jvm.internal.m.e(tab, "tab");
            ViewPager2 P4 = this.f17887a.f17794Y;
            kotlin.jvm.internal.m.b(P4);
            P4.setCurrentItem(tab.getPosition(), false);
            this.f17887a.Z6();
            TabLayout J4 = this.f17887a.f17792W;
            if (J4 != null) {
                J4.setVisibility(0);
            }
            this.f17887a.I7();
            this.f17887a.O5();
            int position = tab.getPosition();
            if (position == 0) {
                TabLayout J42 = this.f17887a.f17792W;
                kotlin.jvm.internal.m.b(J42);
                if (J42.getSelectedTabPosition() == 0) {
                    this.f17887a.j8();
                } else {
                    TabLayout J43 = this.f17887a.f17792W;
                    kotlin.jvm.internal.m.b(J43);
                    TabLayout J44 = this.f17887a.f17792W;
                    kotlin.jvm.internal.m.b(J44);
                    J43.selectTab(J44.getTabAt(this.f17887a.f17774A0));
                }
                this.f17887a.u7();
            } else if (position == 1) {
                TabLayout J45 = this.f17887a.f17792W;
                kotlin.jvm.internal.m.b(J45);
                int tabCount = J45.getTabCount();
                int i4 = 0;
                for (int i5 = 0; i5 < tabCount; i5++) {
                    TabLayout J46 = this.f17887a.f17792W;
                    kotlin.jvm.internal.m.b(J46);
                    TabLayout.Tab tabAt = J46.getTabAt(i5);
                    kotlin.jvm.internal.m.b(tabAt);
                    if (tabAt.getTag() instanceof C2053k) {
                        Object tag = tabAt.getTag();
                        kotlin.jvm.internal.m.c(tag, "null cannot be cast to non-null type com.uptodown.models.Category");
                        if (((C2053k) tag).b() == 523) {
                            i4 = i5;
                        }
                    }
                }
                TabLayout J47 = this.f17887a.f17792W;
                kotlin.jvm.internal.m.b(J47);
                TabLayout J48 = this.f17887a.f17792W;
                kotlin.jvm.internal.m.b(J48);
                J47.selectTab(J48.getTabAt(i4));
            } else if (position != 2) {
                this.f17887a.R5();
                TabLayout J49 = this.f17887a.f17792W;
                if (J49 != null) {
                    J49.setVisibility(8);
                }
            } else {
                this.f17887a.R5();
                TabLayout J410 = this.f17887a.f17792W;
                if (J410 != null) {
                    J410.setVisibility(8);
                }
            }
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            kotlin.jvm.internal.m.e(tab, "tab");
        }
    }

    public static final class z extends FragmentStateAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f17888a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(MainActivity mainActivity, FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f17888a = mainActivity;
        }

        public Fragment createFragment(int i4) {
            if (i4 == 0) {
                this.f17888a.f17801r0 = new E1();
                E1 G4 = this.f17888a.f17801r0;
                kotlin.jvm.internal.m.b(G4);
                return G4;
            } else if (i4 == 1) {
                C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                kVar.r(523);
                kVar.s(this.f17888a.getString(R.string.top_games_title));
                this.f17888a.f17799p0 = H1.f19714m.a(kVar);
                H1 E4 = this.f17888a.f17799p0;
                kotlin.jvm.internal.m.b(E4);
                return E4;
            } else if (i4 != 2) {
                this.f17888a.f17802s0 = new C2();
                C2 O4 = this.f17888a.f17802s0;
                kotlin.jvm.internal.m.b(O4);
                return O4;
            } else {
                C2053k kVar2 = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                kVar2.r(-1);
                kVar2.s(this.f17888a.getString(R.string.top_downloads_title));
                this.f17888a.f17800q0 = Q1.f19769i.a(kVar2);
                Q1 N4 = this.f17888a.f17800q0;
                kotlin.jvm.internal.m.b(N4);
                return N4;
            }
        }

        public int getItemCount() {
            return 4;
        }
    }

    public MainActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new O0(this));
        kotlin.jvm.internal.m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f17778E0 = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new P0(this));
        kotlin.jvm.internal.m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f17779F0 = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new Q0(this));
        kotlin.jvm.internal.m.d(registerForActivityResult3, "registerForActivityResult(...)");
        this.f17780G0 = registerForActivityResult3;
        this.f17781H0 = new o(this);
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new R0(this));
        kotlin.jvm.internal.m.d(registerForActivityResult4, "registerForActivityResult(...)");
        this.f17782I0 = registerForActivityResult4;
    }

    private final void A5() {
        FrameLayout frameLayout = this.f17806w0;
        if (frameLayout != null) {
            kotlin.jvm.internal.m.b(frameLayout);
            if (frameLayout.getChildCount() > 0 && this.f17807x0 != null) {
                y2.n nVar = new y2.n(this);
                E0 e02 = this.f17807x0;
                kotlin.jvm.internal.m.b(e02);
                RelativeLayout b5 = e02.getRoot();
                kotlin.jvm.internal.m.d(b5, "getRoot(...)");
                nVar.g(b5, R.anim.slide_out_bottom, new C1824h(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void A6(MainActivity mainActivity, View view) {
        mainActivity.u5();
    }

    /* access modifiers changed from: private */
    public static final void A7(View view) {
    }

    private final void B5() {
        if (!isFinishing()) {
            AlertDialog j22 = j2();
            if (j22 != null) {
                j22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1683p c5 = C1683p.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(getString(R.string.notification_permission_request));
            c5.f10697e.setTypeface(aVar.w());
            c5.f10697e.setOnClickListener(new J0(this));
            c5.f10695c.setTypeface(aVar.w());
            c5.f10695c.setOnClickListener(new U0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            J2(builder.create());
            if (!isFinishing() && j2() != null) {
                AlertDialog j23 = j2();
                kotlin.jvm.internal.m.b(j23);
                Window window = j23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog j24 = j2();
                kotlin.jvm.internal.m.b(j24);
                j24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void B6(MainActivity mainActivity, View view) {
        mainActivity.t5();
    }

    /* access modifiers changed from: private */
    public static final void B7(MainActivity mainActivity, View view) {
        mainActivity.Y6();
    }

    /* access modifiers changed from: private */
    public static final void C5(MainActivity mainActivity, View view) {
        AlertDialog j22 = mainActivity.j2();
        kotlin.jvm.internal.m.b(j22);
        j22.dismiss();
        if (Build.VERSION.SDK_INT >= 33) {
            mainActivity.i0();
        }
        a.f18818a.X0(mainActivity, true);
    }

    private final void C6() {
        w6();
        r6();
    }

    /* access modifiers changed from: private */
    public static final void C7(View view) {
    }

    /* access modifiers changed from: private */
    public static final void D5(MainActivity mainActivity, View view) {
        AlertDialog j22 = mainActivity.j2();
        kotlin.jvm.internal.m.b(j22);
        j22.dismiss();
    }

    private final void D6() {
        s5(E6(), 1);
    }

    /* access modifiers changed from: private */
    public static final void D7(MainActivity mainActivity, View view) {
        mainActivity.b7();
    }

    private final RelativeLayout E6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_welcome, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        k.a aVar = N1.k.f7778g;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_welcome)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_welcome)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_slogan_to_wizard_welcome)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_welcome)).setTypeface(aVar.w());
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_terms_wizard_welcome)).setOnClickListener(new C1355g1(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_welcome)).setTypeface(aVar.w());
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_privacy_settings_wizard_welcome)).setOnClickListener(new C1362h1(this));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_welcome);
        textView.setTypeface(aVar.w());
        textView.setEnabled(false);
        textView.setOnClickListener(new C1369i1(this));
        if (l2()) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
            textView.setEnabled(true);
        }
        return relativeLayout;
    }

    private final boolean E7() {
        boolean z4;
        FrameLayout frameLayout;
        U e5 = U.f20468m.e(this);
        if (System.currentTimeMillis() - a.f18818a.D(this) >= TimeUnit.DAYS.toMillis(14)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (e5 != null || !z4 || (frameLayout = this.f17806w0) == null) {
            return false;
        }
        kotlin.jvm.internal.m.b(frameLayout);
        frameLayout.removeAllViews();
        E0 c5 = E0.c(getLayoutInflater());
        this.f17807x0 = c5;
        kotlin.jvm.internal.m.b(c5);
        TextView textView = c5.f9733h;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        c5.f9731f.setTypeface(aVar.x());
        c5.f9732g.setTypeface(aVar.w());
        c5.f9730e.setTypeface(aVar.w());
        String string = getString(R.string.reminder_login_msg_1);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        List<C2059q> e6 = C2059q.f20700f.e(string, "\\[xx](.*?)\\[/xx]");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new m3.j("\\[xx](.*?)\\[/xx]").f(string, new C1320b1()));
        for (C2059q qVar : e6) {
            int L4 = m3.m.L(spannableStringBuilder, qVar.d(), 0, false, 6, (Object) null);
            int length = qVar.d().length() + L4;
            if (L4 >= 0) {
                spannableStringBuilder.setSpan(new C(this), L4, length, 33);
            }
        }
        c5.f9731f.setText(spannableStringBuilder);
        c5.f9730e.setOnClickListener(new C1327c1(this));
        c5.f9728c.setOnClickListener(new C1334d1(this));
        FrameLayout frameLayout2 = this.f17806w0;
        kotlin.jvm.internal.m.b(frameLayout2);
        E0 e02 = this.f17807x0;
        kotlin.jvm.internal.m.b(e02);
        frameLayout2.addView(e02.getRoot());
        y2.n nVar = new y2.n(this);
        E0 e03 = this.f17807x0;
        kotlin.jvm.internal.m.b(e03);
        RelativeLayout b5 = e03.getRoot();
        kotlin.jvm.internal.m.d(b5, "getRoot(...)");
        nVar.h(b5, R.anim.slide_in_bottom);
        a.f18818a.g1(this, System.currentTimeMillis());
        return true;
    }

    /* access modifiers changed from: private */
    public static final void F5(MainActivity mainActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            mainActivity.K2();
        }
    }

    /* access modifiers changed from: private */
    public static final void F6(MainActivity mainActivity, View view) {
        mainActivity.W6();
    }

    /* access modifiers changed from: private */
    public static final CharSequence F7(h hVar) {
        kotlin.jvm.internal.m.e(hVar, "it");
        return (CharSequence) hVar.a().get(1);
    }

    /* access modifiers changed from: private */
    public final int G5() {
        int i4 = this.f17784O;
        if (i4 <= 0 || i4 >= this.f17785P.size()) {
            return -1;
        }
        int i5 = this.f17784O - 1;
        this.f17784O = i5;
        return i5;
    }

    /* access modifiers changed from: private */
    public static final void G6(MainActivity mainActivity, View view) {
        mainActivity.T6();
    }

    /* access modifiers changed from: private */
    public static final void G7(MainActivity mainActivity, View view) {
        mainActivity.startActivity(new Intent(mainActivity, LoginActivity.class), UptodownApp.f17422D.a(mainActivity));
        mainActivity.A5();
    }

    /* access modifiers changed from: private */
    public final Object H5(d dVar) {
        Object g4 = C0977g.g(Y.b(), new j(this, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void H6(MainActivity mainActivity, View view) {
        mainActivity.w4();
    }

    /* access modifiers changed from: private */
    public static final void H7(MainActivity mainActivity, View view) {
        mainActivity.A5();
    }

    private final void I6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        u2.x m22 = m2();
        if (m22 != null) {
            m22.d("wizard", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void I7() {
        AppBarLayout appBarLayout = this.f17789T;
        kotlin.jvm.internal.m.b(appBarLayout);
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.f17789T;
        kotlin.jvm.internal.m.b(appBarLayout2);
        appBarLayout2.setExpanded(true);
        TabLayout tabLayout = this.f17798o0;
        kotlin.jvm.internal.m.b(tabLayout);
        int selectedTabPosition = tabLayout.getSelectedTabPosition();
        if (selectedTabPosition != 2 && selectedTabPosition != 3) {
            TabLayout tabLayout2 = this.f17792W;
            kotlin.jvm.internal.m.b(tabLayout2);
            tabLayout2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void J6(MainActivity mainActivity, ActivityResult activityResult) {
        int i4;
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            mainActivity.b8();
        } else if (resultCode == 1) {
            if (mainActivity.j3() != null) {
                if (mainActivity.f17787R != null && mainActivity.f17785P.size() > (i4 = mainActivity.f17784O) && ((a0) mainActivity.f17785P.get(i4)).a() == 5) {
                    mainActivity.u5();
                }
                C2 c22 = mainActivity.f17802s0;
                if (c22 != null) {
                    c22.N0();
                }
            }
            mainActivity.b8();
        }
    }

    private final void J7() {
        Float f4;
        if (!isFinishing()) {
            L0 c5 = L0.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f9825f;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            float height = (float) c5.f9825f.getHeight();
            int color = ContextCompat.getColor(this, R.color.turbo_text_gradient_start);
            int color2 = ContextCompat.getColor(this, R.color.turbo_text_gradient_end);
            TextPaint paint = c5.f9825f.getPaint();
            if (paint != null) {
                f4 = Float.valueOf(paint.measureText(c5.f9825f.getText().toString()));
            } else {
                f4 = null;
            }
            int i4 = color2;
            kotlin.jvm.internal.m.b(f4);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f4.floatValue(), height, new int[]{color, i4}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            TextPaint paint2 = c5.f9825f.getPaint();
            if (paint2 != null) {
                paint2.setShader(linearGradient);
            }
            float dimension = getResources().getDimension(R.dimen.turbo_popup_lines_max_width);
            int i5 = getResources().getDisplayMetrics().widthPixels;
            float dimension2 = getResources().getDimension(R.dimen.margin_l);
            float f5 = (((float) i5) - dimension2) - dimension2;
            if (dimension > f5) {
                int i6 = (int) f5;
                c5.f9823d.setMaxWidth(i6);
                c5.f9824e.setMaxWidth(i6);
            }
            c5.f9823d.setTypeface(aVar.x());
            String obj = c5.f9823d.getText().toString();
            List<C2059q> e5 = C2059q.f20700f.e(obj, "\\[xx](.*?)\\[/xx]");
            SpannableString spannableString = new SpannableString(new m3.j("\\[xx](.*?)\\[/xx]").f(obj, new S0()));
            for (C2059q qVar : e5) {
                int L4 = m3.m.L(spannableString, qVar.d(), 0, false, 6, (Object) null);
                int length = qVar.d().length() + L4;
                if (L4 >= 0) {
                    spannableString.setSpan(new D(this), L4, length, 33);
                }
            }
            c5.f9823d.setText(spannableString);
            c5.f9824e.setTypeface(N1.k.f7778g.w());
            c5.f9821b.setOnClickListener(new T0(this));
            c5.f9824e.setOnClickListener(new V0(this));
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.m.d(locale, "getDefault(...)");
            if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                c5.f9822c.setCropType(0);
            }
            c5.f9822c.setOnClickListener(new W0());
            FrameLayout frameLayout = this.f17808y0;
            kotlin.jvm.internal.m.b(frameLayout);
            frameLayout.addView(c5.getRoot());
            y2.n nVar = new y2.n(this);
            RelativeLayout b5 = c5.getRoot();
            kotlin.jvm.internal.m.d(b5, "getRoot(...)");
            nVar.i(b5, R.anim.popup_turbo_in);
            a.f18818a.l1(this, System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public static final void K6(View view) {
    }

    /* access modifiers changed from: private */
    public static final CharSequence K7(h hVar) {
        kotlin.jvm.internal.m.e(hVar, "it");
        return (CharSequence) hVar.a().get(1);
    }

    /* access modifiers changed from: private */
    public final int L5() {
        int i4 = this.f17784O;
        if (i4 < 0 || i4 >= this.f17785P.size() - 1) {
            return -1;
        }
        int i5 = this.f17784O + 1;
        this.f17784O = i5;
        return i5;
    }

    /* access modifiers changed from: private */
    public static final void L6(MainActivity mainActivity, View view) {
        Integer num;
        H1 h12;
        if (UptodownApp.f17422D.a0()) {
            mainActivity.w5(0);
            E1 e12 = mainActivity.f17801r0;
            if (e12 != null) {
                e12.F();
            }
            TabLayout tabLayout = mainActivity.f17798o0;
            if (tabLayout != null) {
                num = Integer.valueOf(tabLayout.getSelectedTabPosition());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                TabLayout tabLayout2 = mainActivity.f17792W;
                if (tabLayout2 == null || tabLayout2.getSelectedTabPosition() != 0) {
                    TabLayout tabLayout3 = mainActivity.f17792W;
                    kotlin.jvm.internal.m.b(tabLayout3);
                    TabLayout tabLayout4 = mainActivity.f17792W;
                    kotlin.jvm.internal.m.b(tabLayout4);
                    tabLayout3.selectTab(tabLayout4.getTabAt(0));
                }
            } else if (num != null && num.intValue() == 1 && (h12 = mainActivity.f17799p0) != null) {
                h12.x();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void L7(MainActivity mainActivity, View view) {
        mainActivity.T5();
    }

    /* access modifiers changed from: private */
    public static final void M6(MainActivity mainActivity, View view) {
        mainActivity.startActivity(new Intent(mainActivity, SearchActivity.class), UptodownApp.f17422D.a(mainActivity));
        mainActivity.U5();
    }

    /* access modifiers changed from: private */
    public static final void M7(MainActivity mainActivity, View view) {
        mainActivity.T5();
        mainActivity.Y2();
    }

    private final Bitmap N5(Bitmap bitmap, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.m.d(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f4 = (float) i4;
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f4, f4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public static final void N6(MainActivity mainActivity, View view) {
        mainActivity.Y2();
    }

    /* access modifiers changed from: private */
    public static final void N7(View view) {
    }

    /* access modifiers changed from: private */
    public final void O5() {
        FrameLayout frameLayout = this.f17809z0;
        if (frameLayout != null) {
            kotlin.jvm.internal.m.b(frameLayout);
            if (frameLayout.getChildCount() > 0) {
                FrameLayout frameLayout2 = this.f17809z0;
                kotlin.jvm.internal.m.b(frameLayout2);
                frameLayout2.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O6(MainActivity mainActivity) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1376j1(mainActivity), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* access modifiers changed from: private */
    public static final void P6(MainActivity mainActivity) {
        ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(R.id.pb_splash);
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void P7(MainActivity mainActivity, View view) {
        AlertDialog j22 = mainActivity.j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void Q5() {
        RelativeLayout relativeLayout = this.f17783N;
        if (relativeLayout != null) {
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            RelativeLayout relativeLayout2 = this.f17783N;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            this.f17783N = null;
        }
    }

    /* access modifiers changed from: private */
    public static final void Q6(MainActivity mainActivity, ActivityResult activityResult) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(mainActivity), Y.b(), (o3.L) null, new r(mainActivity, new s(mainActivity), (d) null), 2, (Object) null);
    }

    private final void Q7() {
        String I4 = a.f18818a.I(this);
        if (I4 == null) {
            I4 = "https://uptodown-android.uptodown.com/android";
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(I4)));
    }

    /* access modifiers changed from: private */
    public final void R5() {
        AppBarLayout appBarLayout = this.f17789T;
        kotlin.jvm.internal.m.b(appBarLayout);
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.f17789T;
        kotlin.jvm.internal.m.b(appBarLayout2);
        appBarLayout2.setExpanded(false);
        TabLayout tabLayout = this.f17792W;
        kotlin.jvm.internal.m.b(tabLayout);
        tabLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final R2.s R6(MainActivity mainActivity, String str) {
        kotlin.jvm.internal.m.e(str, "packageName");
        E1 e12 = mainActivity.f17801r0;
        if (e12 != null) {
            kotlin.jvm.internal.m.b(e12);
            if (e12.isAdded()) {
                E1 e13 = mainActivity.f17801r0;
                kotlin.jvm.internal.m.b(e13);
                e13.G(str);
            }
        }
        H1 h12 = mainActivity.f17799p0;
        if (h12 != null) {
            kotlin.jvm.internal.m.b(h12);
            if (h12.isAdded()) {
                H1 h13 = mainActivity.f17799p0;
                kotlin.jvm.internal.m.b(h13);
                h13.y(str);
            }
        }
        Q1 q12 = mainActivity.f17800q0;
        if (q12 != null) {
            kotlin.jvm.internal.m.b(q12);
            if (q12.isAdded()) {
                Q1 q13 = mainActivity.f17800q0;
                kotlin.jvm.internal.m.b(q13);
                q13.Z(str);
            }
        }
        ArrayList arrayList = mainActivity.f17804u0;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((H1) obj).y(str);
        }
        return R2.s.f8222a;
    }

    private final Bitmap R7() {
        View rootView = getWindow().getDecorView().getRootView();
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.m.d(createBitmap, "createBitmap(...)");
        rootView.draw(new Canvas(createBitmap));
        float applyDimension = TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, rootView.getWidth() / 2, rootView.getHeight() / 2, true);
        kotlin.jvm.internal.m.d(createScaledBitmap, "createScaledBitmap(...)");
        return N5(createScaledBitmap, (int) applyDimension);
    }

    private final void S5() {
        AppBarLayout appBarLayout = this.f17789T;
        kotlin.jvm.internal.m.b(appBarLayout);
        appBarLayout.setVisibility(8);
        TabLayout tabLayout = this.f17792W;
        kotlin.jvm.internal.m.b(tabLayout);
        tabLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void S6(long j4, long j5, String str, long j6, String str2) {
        U5();
        if (j4 <= 0) {
            E2();
        } else if (this.f17805v0 == -1) {
            this.f17805v0 = j4;
            long j7 = j6;
            new C1640l(this, j4, new u(j5, j7, str, this, str2), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    private final void T5() {
        FrameLayout frameLayout = this.f17808y0;
        if (frameLayout != null) {
            kotlin.jvm.internal.m.b(frameLayout);
            if (frameLayout.getChildCount() > 0) {
                y2.n nVar = new y2.n(this);
                FrameLayout frameLayout2 = this.f17808y0;
                kotlin.jvm.internal.m.b(frameLayout2);
                nVar.g(frameLayout2, R.anim.popup_turbo_out, new l(this));
            }
        }
    }

    private final void T6() {
        this.f17778E0.launch(new Intent(this, GdprPrivacySettings.class), UptodownApp.f17422D.b(this));
    }

    private final void U5() {
        A5();
        T5();
    }

    private final void U6() {
        startActivity(new Intent(this, MyApps.class), UptodownApp.f17422D.a(this));
    }

    private final void V5() {
        a.C0236a aVar = a.f18818a;
        String e5 = aVar.e(this);
        if (e5 != null) {
            C2050h hVar = new C2050h();
            hVar.L0(Long.parseLong(e5));
            Z2(hVar);
            aVar.u0(this, (String) null);
        } else if (!aVar.l0(this)) {
            aVar.g1(this, System.currentTimeMillis());
            RelativeLayout relativeLayout = this.f17787R;
            kotlin.jvm.internal.m.b(relativeLayout);
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.f17787R;
            kotlin.jvm.internal.m.b(relativeLayout2);
            relativeLayout2.setOnClickListener(new C1383k1());
            if (R()) {
                N1();
            } else {
                l0();
            }
            if (!aVar.m0(1, this) || !aVar.T(this)) {
                D6();
            } else {
                j6();
                if (!aVar.m0(4, this)) {
                    w6();
                }
                if (!aVar.m0(5, this)) {
                    r6();
                }
            }
            this.f17784O = 0;
            Object obj = this.f17785P.get(0);
            kotlin.jvm.internal.m.d(obj, "get(...)");
            o7((a0) obj);
        } else {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public final void V6() {
        startActivity(new Intent(this, MyDownloads.class), UptodownApp.f17422D.a(this));
    }

    /* access modifiers changed from: private */
    public final void V7(int i4, C2060s sVar) {
        Fragment K5 = K5();
        if (K5 instanceof C1941r1) {
            runOnUiThread(new C1941r1.C1945d(i4, sVar));
        } else if (K5 instanceof C2) {
            ((C2) K5).O0();
        }
    }

    /* access modifiers changed from: private */
    public static final void W5(View view) {
    }

    private final void W6() {
        String string = getString(R.string.tos_title);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        String string2 = getString(R.string.url_privacy);
        kotlin.jvm.internal.m.d(string2, "getString(...)");
        new u2.q().q(this, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void X5(MainActivity mainActivity, ActivityResult activityResult) {
        String str;
        Bundle extras;
        if (activityResult.getResultCode() == 10) {
            Intent data = activityResult.getData();
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("realPath");
            }
            if (str != null && str.length() != 0) {
                C1826a.y2(mainActivity, new File(str), (String) null, 2, (Object) null);
            }
        }
    }

    private final void X6() {
        this.f17779F0.launch(new Intent(this, PreferencesActivity.class), UptodownApp.f17422D.b(this));
    }

    private final boolean Y5() {
        TextView textView = (TextView) findViewById(R.id.tv_title_auto_update);
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void Y6() {
        startActivity(new Intent(this, Updates.class), UptodownApp.f17422D.a(this));
    }

    /* access modifiers changed from: private */
    public final Object Y7(d dVar) {
        kotlin.jvm.internal.A a5 = new kotlin.jvm.internal.A();
        Object g4 = C0977g.g(Y.b(), new G(this, new kotlin.jvm.internal.A(), a5, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    /* access modifiers changed from: private */
    public final boolean Z5() {
        if (Y5() || c6()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void a7() {
        if (!e6()) {
            z5();
            O7();
        }
    }

    private final boolean b6() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void b7() {
        if (e6()) {
            Iterator it = this.f17785P.iterator();
            kotlin.jvm.internal.m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.m.d(next, "next(...)");
                ((a0) next).c().removeAllViews();
            }
            RelativeLayout relativeLayout = this.f17787R;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.f17787R;
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            this.f17787R = null;
            a.C0236a aVar = a.f18818a;
            boolean m02 = aVar.m0(4, this);
            boolean m03 = aVar.m0(5, this);
            if (m02 && m03) {
                aVar.q1(this, true);
            }
            f6();
            a7();
        }
    }

    private final boolean c6() {
        TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final boolean d6() {
        File n4 = new u2.q().n(this);
        if (a.f18818a.h0(this)) {
            k7();
            return true;
        } else if (n4 == null) {
            return false;
        } else {
            q7();
            return true;
        }
    }

    private final boolean e6() {
        RelativeLayout relativeLayout = this.f17787R;
        if (relativeLayout == null) {
            return false;
        }
        kotlin.jvm.internal.m.b(relativeLayout);
        if (relativeLayout.getVisibility() != 0) {
            return false;
        }
        RelativeLayout relativeLayout2 = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout2);
        if (relativeLayout2.getChildCount() > 0) {
            return true;
        }
        return false;
    }

    private final void e7() {
        if (this.f17783N != null) {
            y2.n nVar = new y2.n(this);
            RelativeLayout relativeLayout = this.f17783N;
            kotlin.jvm.internal.m.b(relativeLayout);
            nVar.g(relativeLayout, R.anim.fade_out, new w(this));
        }
    }

    /* access modifiers changed from: private */
    public final void e8() {
        int i4;
        if (this.f17787R != null && this.f17784O >= 0 && this.f17785P.size() > (i4 = this.f17784O) && ((a0) this.f17785P.get(i4)).a() == 4 && T() && S()) {
            ((TextView) findViewById(R.id.tv_next_wp)).setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
            ((TextView) findViewById(R.id.tv_next_wp)).setTextColor(ContextCompat.getColor(this, R.color.text_color_wizard_button));
        }
    }

    private final void f6() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new m(this, (d) null), 3, (Object) null);
    }

    private final void f7() {
        int i4;
        if (isFinishing() || this.f17787R == null || a.f18818a.l0(this)) {
            b7();
            return;
        }
        RelativeLayout relativeLayout = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout2);
        relativeLayout2.setOnClickListener(new M0());
        Iterator it = this.f17785P.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            a0 a0Var = (a0) next;
            int a5 = a0Var.a();
            if (a5 == 1) {
                a0Var.e(E6());
            } else if (a5 == 2) {
                C2050h hVar = this.f17793X;
                if (hVar != null) {
                    kotlin.jvm.internal.m.b(hVar);
                    a0Var.e(n6(hVar));
                }
            } else if (a5 == 3) {
                a0Var.e(k6());
            } else if (a5 == 4) {
                a0Var.e(x6());
            } else if (a5 == 5) {
                a0Var.e(s6());
            }
        }
        if (this.f17785P.size() <= 0 || (i4 = this.f17784O) < 0 || i4 >= this.f17785P.size()) {
            b7();
            return;
        }
        Object obj = this.f17785P.get(this.f17784O);
        kotlin.jvm.internal.m.d(obj, "get(...)");
        o7((a0) obj);
    }

    private final void f8() {
        TextView textView = (TextView) findViewById(R.id.tv_accept_wizard_welcome);
        if (textView != null) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
        }
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public final void g6() {
        U e5 = U.f20468m.e(this);
        if ((e5 == null || !e5.n()) && this.f17809z0 != null) {
            C2052j d5 = C2052j.f20686n.d(this);
            if (d5 == null || !d5.a(this)) {
                FrameLayout frameLayout = this.f17809z0;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                    return;
                }
                return;
            }
            View inflate = getLayoutInflater().inflate(R.layout.ad_banner_floating, this.f17809z0, false);
            View findViewById = inflate.findViewById(R.id.tv_download_banner);
            kotlin.jvm.internal.m.d(findViewById, "findViewById(...)");
            ((TextView) findViewById).setTypeface(N1.k.f7778g.w());
            View findViewById2 = inflate.findViewById(R.id.rl_close_banner);
            kotlin.jvm.internal.m.d(findViewById2, "findViewById(...)");
            ((RelativeLayout) findViewById2).setOnClickListener(new F0(d5, this));
            View findViewById3 = inflate.findViewById(R.id.iv_banner);
            kotlin.jvm.internal.m.d(findViewById3, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById3;
            com.squareup.picasso.s.h().l(d5.n()).n(UptodownApp.f17422D.h0(this)).j(imageView, new n(d5, this, inflate, imageView));
            imageView.setOnClickListener(new G0(d5, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void g7(View view) {
    }

    /* access modifiers changed from: private */
    public static final void h6(C2052j jVar, MainActivity mainActivity, View view) {
        jVar.f(mainActivity);
        FrameLayout frameLayout = mainActivity.f17809z0;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: private */
    public final void h7() {
        ProgressBar progressBar = this.f17797n0;
        if (progressBar != null) {
            kotlin.jvm.internal.m.b(progressBar);
            if (progressBar.getVisibility() != 0) {
                ProgressBar progressBar2 = this.f17797n0;
                kotlin.jvm.internal.m.b(progressBar2);
                progressBar2.setVisibility(0);
                C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.b(), (o3.L) null, new x(this, (d) null), 2, (Object) null);
                E1 e12 = this.f17801r0;
                if (e12 != null) {
                    e12.B();
                }
                H1 h12 = this.f17799p0;
                if (h12 != null) {
                    h12.w();
                }
                Q1 q12 = this.f17800q0;
                if (q12 != null) {
                    q12.L();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void h8(View view) {
    }

    /* access modifiers changed from: private */
    public static final void i6(C2052j jVar, MainActivity mainActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            jVar.e(mainActivity);
            FrameLayout frameLayout = mainActivity.f17809z0;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            mainActivity.C2(jVar.k());
        }
    }

    private final void i7() {
        z zVar = new z(this, getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager2 = this.f17794Y;
        if (viewPager2 != null) {
            viewPager2.setAdapter(zVar);
        }
        TabLayout tabLayout = this.f17798o0;
        if (tabLayout != null && this.f17794Y != null) {
            kotlin.jvm.internal.m.b(tabLayout);
            ViewPager2 viewPager22 = this.f17794Y;
            kotlin.jvm.internal.m.b(viewPager22);
            new TabLayoutMediator(tabLayout, viewPager22, new C1341e1(this)).attach();
            TabLayout tabLayout2 = this.f17798o0;
            kotlin.jvm.internal.m.b(tabLayout2);
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new y(this));
        }
    }

    private final void j6() {
        s5(k6(), 3);
    }

    /* access modifiers changed from: private */
    public static final void j7(MainActivity mainActivity, TabLayout.Tab tab, int i4) {
        kotlin.jvm.internal.m.e(tab, "tab");
        if (i4 == 0) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.cd_home_tab));
            mainActivity.n7(R.drawable.selector_icon_tab_home, tab);
        } else if (i4 == 1) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.top_games_title));
            mainActivity.n7(R.drawable.selector_icon_tab_games, tab);
        } else if (i4 == 2) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.top_downloads_title));
            mainActivity.n7(R.drawable.selector_icon_tab_top, tab);
        } else if (i4 == 3) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.profile_title));
            mainActivity.n7(R.drawable.vector_user_profile, tab);
        }
    }

    private final RelativeLayout k6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_continue, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        k.a aVar = N1.k.f7778g;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_continue)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_continue)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_continue_to_wizard_continue)).setTypeface(aVar.x());
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_next_wizard_continue);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new C1390l1(this));
        return relativeLayout;
    }

    private final void k7() {
        setContentView((int) R.layout.status_526);
        TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        textView.setText(u2.F.f21886a.d(getString(R.string.msg_update_app_status_526)));
        TextView textView2 = (TextView) findViewById(R.id.tv_update_status_526);
        textView2.setTypeface(aVar.x());
        textView2.setOnClickListener(new J1.E0(this));
    }

    private final void k8(E1 e12) {
        TabLayout tabLayout = this.f17792W;
        kotlin.jvm.internal.m.b(tabLayout);
        TabLayout tabLayout2 = this.f17792W;
        kotlin.jvm.internal.m.b(tabLayout2);
        tabLayout.selectTab(tabLayout2.getTabAt(0));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.d(beginTransaction, "beginTransaction(...)");
        beginTransaction.replace(R.id.fl_home_fragment, e12);
        if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        this.f17774A0 = 0;
        w5(0);
    }

    /* access modifiers changed from: private */
    public static final void l6(MainActivity mainActivity, View view) {
        mainActivity.u5();
    }

    /* access modifiers changed from: private */
    public static final void l7(MainActivity mainActivity, View view) {
        File n4 = new u2.q().n(mainActivity);
        if (n4 != null) {
            UptodownApp.a.Y(UptodownApp.f17422D, n4, mainActivity, (String) null, 4, (Object) null);
        } else {
            mainActivity.Q7();
        }
    }

    private final void m6(C2050h hVar) {
        this.f17793X = hVar;
        s5(n6(hVar), 2);
    }

    /* access modifiers changed from: private */
    public final void m7(Drawable drawable, boolean z4) {
        TabLayout.Tab tabAt;
        View inflate = getLayoutInflater().inflate(R.layout.tab_icon_user, (ViewGroup) null);
        if (inflate != null) {
            if (drawable != null) {
                View findViewById = inflate.findViewById(R.id.iv_avatar_user);
                kotlin.jvm.internal.m.d(findViewById, "findViewById(...)");
                ((ImageView) findViewById).setImageDrawable(drawable);
            }
            View findViewById2 = inflate.findViewById(R.id.iv_badge_user);
            kotlin.jvm.internal.m.d(findViewById2, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById2;
            if (z4) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TabLayout tabLayout = this.f17798o0;
            if (tabLayout != null && (tabAt = tabLayout.getTabAt(3)) != null) {
                tabAt.setCustomView(inflate);
            }
        }
    }

    private final boolean m8(Intent intent) {
        if ((intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    private final RelativeLayout n6(C2050h hVar) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_deep_link, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        com.squareup.picasso.s.h().l(hVar.E()).n(UptodownApp.f17422D.i0(this)).i((ImageView) relativeLayout.findViewById(R.id.iv_logo_wizard_deep_link));
        com.squareup.picasso.s.h().l(hVar.y()).n(new C2346d(this)).i((ImageView) relativeLayout.findViewById(R.id.iv_header_feature_wizard_deep_link));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_name_app_wizard_deep_link);
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        textView.setText(hVar.L());
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_author_wizard_deep_link);
        textView2.setTypeface(aVar.x());
        textView2.setText(hVar.g());
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_deep_link)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_deep_link)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_slogan_to_wizard_deep_link)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setOnClickListener(new B0(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setOnClickListener(new C0(this));
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_deep_link);
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new D0(this));
        return relativeLayout;
    }

    private final void n7(int i4, TabLayout.Tab tab) {
        View inflate = getLayoutInflater().inflate(R.layout.tab_icon_user, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.iv_avatar_user);
        kotlin.jvm.internal.m.d(findViewById, "findViewById(...)");
        ((ImageView) findViewById).setImageDrawable(ContextCompat.getDrawable(this, i4));
        ((ImageView) inflate.findViewById(R.id.iv_badge_user)).setVisibility(8);
        tab.setCustomView(inflate);
    }

    /* access modifiers changed from: private */
    public static final void o6(MainActivity mainActivity, View view) {
        mainActivity.W6();
    }

    /* access modifiers changed from: private */
    public final void o7(a0 a0Var) {
        RelativeLayout relativeLayout = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout);
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout2);
        relativeLayout2.addView(a0Var.c());
        I6(a0Var.b());
    }

    /* access modifiers changed from: private */
    public static final void p6(MainActivity mainActivity, View view) {
        mainActivity.T6();
    }

    /* access modifiers changed from: private */
    public static final void p7(MainActivity mainActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            u2.t a5 = u2.t.f21927u.a(mainActivity);
            a5.a();
            a5.r();
            a5.i();
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        } else if (resultCode != 1004) {
            mainActivity.q2();
        } else {
            UptodownApp.f17422D.e(mainActivity);
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        }
    }

    /* access modifiers changed from: private */
    public static final void q6(MainActivity mainActivity, View view) {
        mainActivity.w4();
    }

    private final void q7() {
        C2060s a5;
        u2.t a6 = u2.t.f21927u.a(this);
        a6.a();
        String packageName = getPackageName();
        kotlin.jvm.internal.m.d(packageName, "getPackageName(...)");
        S D02 = a6.D0(packageName);
        a6.i();
        if (D02 != null && (a5 = D02.a()) != null && a5.f()) {
            setContentView((int) R.layout.dialog_auto_update);
            k.a aVar = N1.k.f7778g;
            ((TextView) findViewById(R.id.tv_title_auto_update)).setTypeface(aVar.w());
            ((TextView) findViewById(R.id.tv_desc_auto_update)).setTypeface(aVar.x());
            ((TextView) findViewById(R.id.tv_info_auto_update)).setTypeface(aVar.x());
            TextView textView = (TextView) findViewById(R.id.tv_installed_version_auto_update);
            textView.setTypeface(aVar.x());
            PackageManager packageManager = getPackageManager();
            kotlin.jvm.internal.m.d(packageManager, "getPackageManager(...)");
            String packageName2 = getPackageName();
            kotlin.jvm.internal.m.d(packageName2, "getPackageName(...)");
            textView.setText(getString(R.string.autoupdate_installed_version, new Object[]{W1.s.d(packageManager, packageName2, 0).versionName}));
            TextView textView2 = (TextView) findViewById(R.id.tv_update_version_auto_update);
            textView2.setTypeface(aVar.w());
            kotlin.jvm.internal.m.b(D02);
            textView2.setText(getString(R.string.autoupdate_update_version, new Object[]{D02.k()}));
            TextView textView3 = (TextView) findViewById(R.id.tv_update_size_auto_update);
            textView3.setTypeface(aVar.x());
            if (D02.a() != null) {
                i iVar = new i();
                C2060s a7 = D02.a();
                kotlin.jvm.internal.m.b(a7);
                textView3.setText(getString(R.string.autoupdate_update_size, new Object[]{iVar.d(a7.z(), this)}));
            }
            ((TextView) findViewById(R.id.tv_uptodown_version_details_label)).setTypeface(aVar.x());
            TextView textView4 = (TextView) findViewById(R.id.tv_uptodown_version_details);
            textView4.setTypeface(aVar.x());
            new b2.m(this, D02.h(), new A(textView4, this, D02), LifecycleOwnerKt.getLifecycleScope(this));
            ((RelativeLayout) findViewById(R.id.rl_uptodown_version_details)).setOnClickListener(new C1487z1(textView4, (ImageView) findViewById(R.id.iv_uptodown_version_details_label)));
            ((TextView) findViewById(R.id.tv_update)).setTypeface(aVar.w());
            ((RelativeLayout) findViewById(R.id.rl_update)).setOnClickListener(new C1486z0(this));
            ((TextView) findViewById(R.id.tv_cancel)).setTypeface(aVar.w());
            ((RelativeLayout) findViewById(R.id.rl_cancel)).setOnClickListener(new A0(this));
        }
    }

    private final void r6() {
        s5(s6(), 5);
    }

    /* access modifiers changed from: private */
    public static final void r7(TextView textView, ImageView imageView, View view) {
        if (textView.getVisibility() == 0) {
            textView.setVisibility(8);
            imageView.setScaleY(1.0f);
            return;
        }
        textView.setVisibility(0);
        imageView.setScaleY(-1.0f);
    }

    private final void s5(RelativeLayout relativeLayout, int i4) {
        a0 a0Var = new a0();
        a0Var.d(i4);
        a0Var.e(relativeLayout);
        this.f17785P.add(a0Var);
    }

    private final RelativeLayout s6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_login, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wl);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(N1.k.f7778g.w());
        }
        k.a aVar = N1.k.f7778g;
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wl)).setTypeface(aVar.w());
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_login_google_wl);
        if (UptodownApp.f17422D.Q()) {
            relativeLayout3.setVisibility(8);
        } else {
            ((TextView) relativeLayout.findViewById(R.id.tv_login_google_wl)).setTypeface(aVar.w());
            relativeLayout3.setOnClickListener(new I0(this));
        }
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_login_email_wl);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new K0(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setOnClickListener(new J1.L0(this));
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public static final void s7(MainActivity mainActivity, View view) {
        try {
            File n4 = new u2.q().n(mainActivity);
            if (n4 == null || !n4.exists()) {
                mainActivity.d7();
            } else {
                mainActivity.S1(n4);
            }
        } catch (Exception unused) {
            mainActivity.Q7();
        }
    }

    /* access modifiers changed from: private */
    public final void t5() {
        int i4;
        if (!this.f17786Q && this.f17785P.size() > 0 && (i4 = this.f17784O) >= 0) {
            new y2.n(this).g(((a0) this.f17785P.get(i4)).c(), R.anim.slide_back_out, new C1822f(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void t6(MainActivity mainActivity, View view) {
        mainActivity.n3();
    }

    /* access modifiers changed from: private */
    public static final void t7(MainActivity mainActivity, View view) {
        mainActivity.finish();
    }

    private final void u5() {
        a.f18818a.r1(this, ((a0) this.f17785P.get(this.f17784O)).a());
        new y2.n(this).g(((a0) this.f17785P.get(this.f17784O)).c(), R.anim.slide_next_out, new C1823g(this));
    }

    /* access modifiers changed from: private */
    public static final void u6(MainActivity mainActivity, View view) {
        mainActivity.f17780G0.launch(new Intent(mainActivity, LoginActivity.class), UptodownApp.f17422D.b(mainActivity));
    }

    /* access modifiers changed from: private */
    public final void u7() {
        FrameLayout frameLayout = this.f17809z0;
        if (frameLayout != null) {
            kotlin.jvm.internal.m.b(frameLayout);
            if (frameLayout.getChildCount() > 0) {
                FrameLayout frameLayout2 = this.f17809z0;
                kotlin.jvm.internal.m.b(frameLayout2);
                frameLayout2.setVisibility(0);
            }
        }
    }

    private final void v5(C2050h hVar, boolean z4) {
        C1941r1 a5 = C1941r1.f19976n.a(hVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                beginTransaction.replace(R.id.rl_main_scrollable, a5);
                beginTransaction.addToBackStack((String) null);
                if (z4) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    beginTransaction.commitAllowingStateLoss();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                String string = getString(R.string.error_generico);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                q0(string);
            }
        } else {
            String string2 = getString(R.string.error_generico);
            kotlin.jvm.internal.m.d(string2, "getString(...)");
            q0(string2);
        }
    }

    /* access modifiers changed from: private */
    public static final void v6(MainActivity mainActivity, View view) {
        mainActivity.u5();
    }

    private final void w4() {
        a.C0236a aVar = a.f18818a;
        if (!aVar.T(this)) {
            aVar.G0(this, true);
            aVar.r0(this, true);
            aVar.x0(this, true);
            aVar.j1(this, true);
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            UptodownApp.a.P0(aVar2, this, false, 2, (Object) null);
            aVar2.I(this);
            N2(new u2.x(this));
            u2.x m22 = m2();
            if (m22 != null) {
                m22.b();
            }
        }
        K2();
        if (!aVar.i0(this)) {
            new u2.q().e(j2(), this);
        } else {
            u5();
        }
    }

    private final void w6() {
        s5(x6(), 4);
    }

    /* access modifiers changed from: private */
    public static final void w7(MainActivity mainActivity, View view) {
        mainActivity.U6();
    }

    private final void x5() {
        long currentTimeMillis = System.currentTimeMillis();
        a.C0236a aVar = a.f18818a;
        if (currentTimeMillis - aVar.C(this) >= TimeUnit.DAYS.toMillis(7)) {
            aVar.Y0(this, System.currentTimeMillis());
            if (Build.VERSION.SDK_INT >= 33) {
                if (!b6()) {
                    B5();
                    return;
                }
            } else if (!aVar.Y(this)) {
                B5();
                return;
            }
        }
        E7();
    }

    private final RelativeLayout x6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_permissions, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wp);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(N1.k.f7778g.w());
        }
        k.a aVar = N1.k.f7778g;
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wp)).setTypeface(aVar.w());
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_notifications_wp);
        if (Build.VERSION.SDK_INT >= 33) {
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_title_wp)).setTypeface(aVar.w());
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_msg_wp)).setTypeface(aVar.x());
            SwitchCompat switchCompat = (SwitchCompat) relativeLayout.findViewById(R.id.sc_notifications_wp);
            this.f17791V = switchCompat;
            kotlin.jvm.internal.m.b(switchCompat);
            switchCompat.setChecked(b6());
            SwitchCompat switchCompat2 = this.f17791V;
            kotlin.jvm.internal.m.b(switchCompat2);
            switchCompat2.setClickable(false);
            relativeLayout3.setOnClickListener(new X0(this));
        } else if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        ((ScrollableTextView) relativeLayout.findViewById(R.id.tv_unknown_sources_title_wp)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_badge_wp)).setTypeface(aVar.w());
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_msg_wp);
        textView.setText(getString(R.string.msg_install_from_unknown_source, new Object[]{getString(R.string.app_name)}));
        textView.setTypeface(aVar.x());
        SwitchCompat switchCompat3 = (SwitchCompat) relativeLayout.findViewById(R.id.sc_unknown_sources_wp);
        this.f17790U = switchCompat3;
        kotlin.jvm.internal.m.b(switchCompat3);
        switchCompat3.setChecked(T());
        SwitchCompat switchCompat4 = this.f17790U;
        kotlin.jvm.internal.m.b(switchCompat4);
        switchCompat4.setClickable(false);
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_unknown_sources_wp)).setOnClickListener(new Y0(this));
        if (relativeLayout3.getVisibility() == 8) {
            relativeLayout.findViewById(R.id.v_unknown_sources_separator).setVisibility(4);
        }
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_next_wp);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new Z0(this));
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_back_wp);
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new C1313a1(this));
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public static final void x7(MainActivity mainActivity, View view) {
        mainActivity.V6();
    }

    private final void y5() {
        if (!C2313C.f21882a.a(this)) {
            u2.t a5 = u2.t.f21927u.a(this);
            a5.a();
            Q2(a5.y0());
            a5.i();
            int i4 = 0;
            while (n2().size() > 0 && i4 < 2) {
                Object remove = n2().remove(0);
                kotlin.jvm.internal.m.d(remove, "removeAt(...)");
                G2((C2039G) remove);
                i4++;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void y6(MainActivity mainActivity, View view) {
        SwitchCompat switchCompat = mainActivity.f17791V;
        if (switchCompat != null && !switchCompat.isChecked()) {
            mainActivity.i0();
        }
    }

    /* access modifiers changed from: private */
    public static final void y7(MainActivity mainActivity, View view) {
        mainActivity.X6();
    }

    private final void z5() {
        U e5 = U.f20468m.e(this);
        if ((e5 == null || !e5.n()) && a.f18818a.H(this) == 0) {
            J7();
            return;
        }
        x5();
        y5();
    }

    /* access modifiers changed from: private */
    public static final void z6(MainActivity mainActivity, View view) {
        SwitchCompat switchCompat = mainActivity.f17790U;
        if (switchCompat != null && !switchCompat.isChecked() && !mainActivity.T()) {
            mainActivity.k0();
        }
    }

    /* access modifiers changed from: private */
    public static final void z7(MainActivity mainActivity, View view) {
        mainActivity.h7();
    }

    public void A2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        super.A2(hVar);
        if (this.f17787R != null && this.f17784O == 0 && this.f17785P.size() == 1 && ((a0) this.f17785P.get(this.f17784O)).a() == 1) {
            m6(hVar);
            u5();
        }
    }

    public void B2() {
        if (this.f17787R != null && this.f17784O == 0 && this.f17785P.size() == 1 && ((a0) this.f17785P.get(this.f17784O)).a() == 1) {
            f8();
            C6();
        }
    }

    public void C2(long j4) {
        U5();
        if (j4 <= 0) {
            E2();
        } else if (this.f17805v0 == -1) {
            this.f17805v0 = j4;
            new C1640l(this, j4, new t(this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void E5() {
        e7();
        if (!e6()) {
            f6();
        }
    }

    public final C2074f I5() {
        return this.f17775B0;
    }

    public final ActivityResultLauncher J5() {
        return this.f17778E0;
    }

    public final Fragment K5() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            kotlin.jvm.internal.m.d(fragments, "getFragments(...)");
            return (Fragment) C1601o.P(fragments);
        } else if (!this.f17803t0.isEmpty()) {
            return (Fragment) C1601o.P(this.f17803t0);
        } else {
            return null;
        }
    }

    public final RelativeLayout M5() {
        return this.f17796m0;
    }

    public final void O7() {
        U e5 = U.f20468m.e(this);
        if (!isFinishing() && e5 != null && e5.n()) {
            a.C0236a aVar = a.f18818a;
            if (!aVar.k0(this)) {
                AlertDialog j22 = j2();
                if (j22 != null) {
                    j22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                c2.M0 c5 = c2.M0.c(getLayoutInflater());
                kotlin.jvm.internal.m.d(c5, "inflate(...)");
                TextView textView = c5.f9850o;
                k.a aVar2 = N1.k.f7778g;
                textView.setTypeface(aVar2.w());
                String string = getString(R.string.uptodown_turbo);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                int color = ContextCompat.getColor(this, R.color.turbo_text_gradient_start);
                int color2 = ContextCompat.getColor(this, R.color.turbo_text_gradient_end);
                TextView textView2 = c5.f9850o;
                kotlin.jvm.internal.m.d(textView2, "tvTitleTurboWelcomePopup");
                String obj = textView2.getText().toString();
                float height = (float) textView2.getHeight();
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView2.getPaint().measureText(string), height, new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                SpannableString spannableString = new SpannableString(obj);
                int L4 = m3.m.L(obj, string, 0, false, 6, (Object) null);
                if (L4 >= 0) {
                    spannableString.setSpan(new q.a.C0270a(linearGradient, getResources().getDimension(R.dimen.font_size_26)), L4, string.length() + L4, 33);
                }
                textView2.setText(spannableString);
                Spanned d5 = u2.F.f21886a.d(getString(R.string.turbo_welcome_popup_description, new Object[]{getString(R.string.turbo_welcome_popup_manage_subscription)}));
                String string2 = getString(R.string.turbo_welcome_popup_manage_subscription);
                kotlin.jvm.internal.m.d(string2, "getString(...)");
                SpannableString spannableString2 = new SpannableString(d5);
                int L5 = m3.m.L(d5, string2, 0, false, 6, (Object) null);
                if (L5 >= 0) {
                    spannableString2.setSpan(new StyleSpan(1), L5, string2.length() + L5, 33);
                }
                c5.f9844i.setText(spannableString2);
                c5.f9844i.setTypeface(aVar2.x());
                c5.f9848m.setTypeface(aVar2.w());
                c5.f9847l.setTypeface(aVar2.x());
                c5.f9843h.setTypeface(aVar2.w());
                c5.f9842g.setTypeface(aVar2.x());
                c5.f9846k.setTypeface(aVar2.w());
                c5.f9845j.setTypeface(aVar2.x());
                c5.f9849n.setTypeface(aVar2.w());
                c5.f9849n.setOnClickListener(new N0(this));
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                J2(builder.create());
                if (!isFinishing() && j2() != null) {
                    AlertDialog j23 = j2();
                    kotlin.jvm.internal.m.b(j23);
                    Window window = j23.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    AlertDialog j24 = j2();
                    kotlin.jvm.internal.m.b(j24);
                    j24.show();
                    aVar.p1(this, true);
                }
            }
        }
    }

    public final void P5() {
        RelativeLayout relativeLayout = this.f17795Z;
        if (relativeLayout != null) {
            kotlin.jvm.internal.m.b(relativeLayout);
            if (relativeLayout.getVisibility() == 0) {
                RelativeLayout relativeLayout2 = this.f17795Z;
                kotlin.jvm.internal.m.b(relativeLayout2);
                relativeLayout2.setVisibility(8);
            }
        }
    }

    public final void S7(String str) {
        if (K5() instanceof C1910h) {
            Fragment K5 = K5();
            kotlin.jvm.internal.m.c(K5, "null cannot be cast to non-null type com.uptodown.fragments.AlternativesFragment");
            ((C1910h) K5).u(str);
        }
    }

    public final Object T7(String str, d dVar) {
        Object g4 = C0977g.g(Y.c(), new E(this, str, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    public final Object U7(String str, d dVar) {
        Object g4 = C0977g.g(Y.c(), new F(this, str, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    public void W() {
        super.W();
        SwitchCompat switchCompat = this.f17791V;
        if (switchCompat != null) {
            switchCompat.setChecked(false);
        }
        e8();
    }

    public final void W7(int i4, S s4) {
        Fragment K5 = K5();
        if (s4 != null && (K5 instanceof C1941r1)) {
            runOnUiThread(new C1941r1.C1943b(i4, s4));
        }
    }

    public void X() {
        super.X();
        SwitchCompat switchCompat = this.f17791V;
        if (switchCompat != null) {
            switchCompat.setChecked(true);
        }
        e8();
    }

    public void X2(long j4) {
        a.f18818a.u0(this, String.valueOf(j4));
        Bitmap R7 = R7();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_wizard);
        this.f17787R = relativeLayout;
        kotlin.jvm.internal.m.b(relativeLayout);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout2);
        relativeLayout2.setOnClickListener(new C1445t1());
        RelativeLayout relativeLayout3 = this.f17787R;
        kotlin.jvm.internal.m.b(relativeLayout3);
        relativeLayout3.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_kill, this.f17787R, false);
        kotlin.jvm.internal.m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout4 = (RelativeLayout) inflate;
        k.a aVar = N1.k.f7778g;
        ((TextView) relativeLayout4.findViewById(R.id.tv_title_wizard_kill)).setTypeface(aVar.w());
        TextView textView = (TextView) relativeLayout4.findViewById(R.id.tv_slogan_to_wizard_kill);
        textView.setTypeface(aVar.x());
        textView.setText(getString(R.string.core_kill_this_app, new Object[]{getString(R.string.app_name)}));
        ((TextView) relativeLayout4.findViewById(R.id.tv_slide_wizard_kill)).setTypeface(aVar.w());
        TextView textView2 = (TextView) relativeLayout4.findViewById(R.id.tv_accept_wizard_kill);
        textView2.setTypeface(aVar.x());
        textView2.setEnabled(true);
        textView2.setOnClickListener(new C1452u1(this));
        a0 a0Var = new a0();
        a0Var.d(6);
        a0Var.e(relativeLayout4);
        o7(a0Var);
        ImageView imageView = (ImageView) relativeLayout4.findViewById(R.id.iv_tap_screen_kill);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_tap);
        loadAnimation.setStartOffset(500);
        loadAnimation.setFillAfter(true);
        ImageView imageView2 = (ImageView) relativeLayout4.findViewById(R.id.iv_screenshot_kill);
        imageView2.setImageBitmap(R7);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up_out);
        loadAnimation2.setFillAfter(true);
        loadAnimation2.setStartOffset(500);
        loadAnimation2.setAnimationListener(new B(imageView, loadAnimation, imageView2));
        imageView.startAnimation(loadAnimation);
        imageView2.startAnimation(loadAnimation2);
    }

    public final void X7(String str) {
        if (K5() instanceof E1) {
            Fragment K5 = K5();
            kotlin.jvm.internal.m.c(K5, "null cannot be cast to non-null type com.uptodown.fragments.HomeFragment");
            ((E1) K5).G(str);
            return;
        }
        E1 e12 = this.f17801r0;
        if (e12 != null) {
            kotlin.jvm.internal.m.b(e12);
            e12.G(str);
        }
    }

    public void Z2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        Fragment K5 = K5();
        RelativeLayout relativeLayout = this.f17796m0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new C1479y0());
        }
        RelativeLayout relativeLayout2 = this.f17796m0;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        if (!(K5 instanceof C1941r1)) {
            v5(hVar, false);
        } else if (((C1941r1) K5).Y3().e() != hVar.e()) {
            v5(hVar, true);
        }
        S5();
    }

    public final void Z6() {
        TabLayout tabLayout;
        TabLayout tabLayout2;
        RelativeLayout relativeLayout;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        }
        RelativeLayout relativeLayout2 = this.f17796m0;
        if (!(relativeLayout2 == null || relativeLayout2.getVisibility() != 0 || (relativeLayout = this.f17796m0) == null)) {
            relativeLayout.setVisibility(8);
        }
        I7();
        TabLayout tabLayout3 = this.f17798o0;
        if (((tabLayout3 != null && tabLayout3.getSelectedTabPosition() == 1) || ((tabLayout2 = this.f17798o0) != null && tabLayout2.getSelectedTabPosition() == 0)) && (tabLayout = this.f17792W) != null) {
            tabLayout.setVisibility(0);
        }
    }

    public final void Z7() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new H(this, (d) null), 3, (Object) null);
    }

    public final boolean a6() {
        RelativeLayout relativeLayout = this.f17795Z;
        if (relativeLayout == null) {
            return false;
        }
        kotlin.jvm.internal.m.b(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void a8(String str) {
        if (K5() instanceof H1) {
            Fragment K5 = K5();
            kotlin.jvm.internal.m.c(K5, "null cannot be cast to non-null type com.uptodown.fragments.ParentCategoryFragment");
            ((H1) K5).y(str);
            return;
        }
        H1 h12 = this.f17799p0;
        if (h12 != null) {
            kotlin.jvm.internal.m.b(h12);
            h12.y(str);
        }
    }

    public void b0() {
        super.b0();
        a2();
    }

    public final void b8() {
        ImageView imageView = (ImageView) findViewById(R.id.home_uptodown_turbo);
        U e5 = U.f20468m.e(this);
        if (isFinishing() || e5 == null || !e5.n()) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        Z7();
    }

    public void c0() {
        super.c0();
        a2();
    }

    public final void c7() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (o3.L) null, new v(this, (d) null), 2, (Object) null);
    }

    public final void c8(String str) {
        if (K5() instanceof Q1) {
            Fragment K5 = K5();
            kotlin.jvm.internal.m.c(K5, "null cannot be cast to non-null type com.uptodown.fragments.TopByCategoryFragment");
            ((Q1) K5).Z(str);
            return;
        }
        Q1 q12 = this.f17800q0;
        if (q12 != null) {
            kotlin.jvm.internal.m.b(q12);
            q12.Z(str);
        }
    }

    public void d0() {
        super.d0();
        N1();
    }

    public final void d7() {
        b7();
        if (!d6()) {
            f7();
            e7();
            Z7();
        }
    }

    public final void d8(C2060s sVar, int i4) {
        kotlin.jvm.internal.m.e(sVar, "download");
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (o3.L) null, new I(i4, this, sVar, (d) null), 2, (Object) null);
    }

    public void e0() {
        super.e0();
        N1();
    }

    public final void g8(C2047e eVar) {
        kotlin.jvm.internal.m.e(eVar, "alternatives");
        U5();
        R5();
        C1910h a5 = C1910h.f19903f.a(eVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                beginTransaction.setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out);
                beginTransaction.add((int) R.id.rl_main_scrollable, (Fragment) a5);
                beginTransaction.addToBackStack(eVar.c());
                if (K5() instanceof Q1) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    try {
                        beginTransaction.commitAllowingStateLoss();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        String string = getString(R.string.error_generico);
                        kotlin.jvm.internal.m.d(string, "getString(...)");
                        q0(string);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                String string2 = getString(R.string.error_generico);
                kotlin.jvm.internal.m.d(string2, "getString(...)");
                q0(string2);
            }
        } else {
            String string3 = getString(R.string.error_generico);
            kotlin.jvm.internal.m.d(string3, "getString(...)");
            q0(string3);
        }
    }

    public void h0() {
        SwitchCompat switchCompat = this.f17790U;
        if (switchCompat != null) {
            switchCompat.setChecked(T());
        }
        e8();
    }

    /* access modifiers changed from: protected */
    public void h3() {
    }

    public final void i8(C2053k kVar) {
        kotlin.jvm.internal.m.e(kVar, "category");
        U5();
        R5();
        Q1 a5 = Q1.f19769i.a(kVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                beginTransaction.setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out);
                beginTransaction.add((int) R.id.rl_main_scrollable, (Fragment) a5);
                beginTransaction.addToBackStack(a5.K().d());
                if (K5() instanceof Q1) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    try {
                        beginTransaction.commitAllowingStateLoss();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        String string = getString(R.string.error_generico);
                        kotlin.jvm.internal.m.d(string, "getString(...)");
                        q0(string);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                String string2 = getString(R.string.error_generico);
                kotlin.jvm.internal.m.d(string2, "getString(...)");
                q0(string2);
            }
        } else {
            String string3 = getString(R.string.error_generico);
            kotlin.jvm.internal.m.d(string3, "getString(...)");
            q0(string3);
        }
    }

    public U j3() {
        String str;
        U e5 = U.f20468m.e(this);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str == null || !e5.m(this)) {
            return null;
        }
        return e5;
    }

    public final void j8() {
        E1 e12 = this.f17801r0;
        if (e12 != null) {
            kotlin.jvm.internal.m.b(e12);
            k8(e12);
            return;
        }
        E1 e13 = new E1();
        this.f17801r0 = e13;
        kotlin.jvm.internal.m.b(e13);
        k8(e13);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: d2.H1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: d2.H1} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l8(g2.C2053k r7) {
        /*
            r6 = this;
            java.lang.String r0 = "parentCategory"
            kotlin.jvm.internal.m.e(r7, r0)
            int r0 = r7.b()
            r1 = 523(0x20b, float:7.33E-43)
            r2 = 1
            if (r0 != r1) goto L_0x0012
            r6.w5(r2)
            return
        L_0x0012:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.f17803t0 = r0
            com.google.android.material.tabs.TabLayout r0 = r6.f17792W
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.getTabCount()
            r1 = 1
        L_0x0023:
            r3 = 0
            if (r1 >= r0) goto L_0x006f
            com.google.android.material.tabs.TabLayout r4 = r6.f17792W
            kotlin.jvm.internal.m.b(r4)
            com.google.android.material.tabs.TabLayout$Tab r4 = r4.getTabAt(r1)
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r4.getTag()
            goto L_0x0037
        L_0x0036:
            r4 = r3
        L_0x0037:
            boolean r4 = r4 instanceof g2.C2053k
            if (r4 == 0) goto L_0x006c
            com.google.android.material.tabs.TabLayout r4 = r6.f17792W
            kotlin.jvm.internal.m.b(r4)
            com.google.android.material.tabs.TabLayout$Tab r4 = r4.getTabAt(r1)
            if (r4 == 0) goto L_0x004a
            java.lang.Object r3 = r4.getTag()
        L_0x004a:
            java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.models.Category"
            kotlin.jvm.internal.m.c(r3, r4)
            g2.k r3 = (g2.C2053k) r3
            int r3 = r3.b()
            int r4 = r7.b()
            if (r3 != r4) goto L_0x006c
            com.google.android.material.tabs.TabLayout r3 = r6.f17792W
            kotlin.jvm.internal.m.b(r3)
            com.google.android.material.tabs.TabLayout r4 = r6.f17792W
            kotlin.jvm.internal.m.b(r4)
            com.google.android.material.tabs.TabLayout$Tab r4 = r4.getTabAt(r1)
            r3.selectTab(r4)
        L_0x006c:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x006f:
            java.util.ArrayList r0 = r6.f17804u0
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "iterator(...)"
            kotlin.jvm.internal.m.d(r0, r1)
        L_0x007a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r0.next()
            java.lang.String r4 = "next(...)"
            kotlin.jvm.internal.m.d(r1, r4)
            d2.H1 r1 = (d2.H1) r1
            g2.k r4 = r1.u()
            if (r4 == 0) goto L_0x007a
            g2.k r4 = r1.u()
            kotlin.jvm.internal.m.b(r4)
            int r4 = r4.b()
            int r5 = r7.b()
            if (r4 != r5) goto L_0x007a
            r3 = r1
        L_0x00a3:
            if (r3 != 0) goto L_0x00b0
            d2.H1$a r0 = d2.H1.f19714m
            d2.H1 r3 = r0.a(r7)
            java.util.ArrayList r7 = r6.f17804u0
            r7.add(r3)
        L_0x00b0:
            androidx.fragment.app.FragmentManager r7 = r6.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r7 = r7.beginTransaction()
            java.lang.String r0 = "beginTransaction(...)"
            kotlin.jvm.internal.m.d(r7, r0)
            r0 = 2131362175(0x7f0a017f, float:1.8344123E38)
            r7.replace(r0, r3)
            java.util.ArrayList r0 = r6.f17803t0
            int r0 = r0.size()
            if (r0 >= r2) goto L_0x00d0
            java.util.ArrayList r0 = r6.f17803t0
            r0.add(r3)
        L_0x00d0:
            boolean r0 = r6.isFinishing()
            if (r0 != 0) goto L_0x00e8
            androidx.fragment.app.FragmentManager r0 = r6.getSupportFragmentManager()
            boolean r0 = r0.isDestroyed()
            if (r0 != 0) goto L_0x00e8
            r7.commitAllowingStateLoss()     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00e8
        L_0x00e4:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00e8:
            r7 = 0
            r6.w5(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.l8(g2.k):void");
    }

    public void o3() {
        int i4;
        if (this.f17787R != null && this.f17785P.size() > (i4 = this.f17784O) && ((a0) this.f17785P.get(i4)).a() == 5) {
            u5();
            C2 c22 = this.f17802s0;
            if (c22 != null) {
                c22.N0();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        long j4;
        String str2;
        Bundle extras2;
        super.onCreate(bundle);
        setContentView((int) R.layout.main);
        if (new u2.J().a(this)) {
            finish();
            return;
        }
        this.f17806w0 = (FrameLayout) findViewById(R.id.fl_sign_in_popup);
        this.f17808y0 = (FrameLayout) findViewById(R.id.fl_uptodown_turbo_popup);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_splash);
        this.f17783N = relativeLayout;
        kotlin.jvm.internal.m.b(relativeLayout);
        relativeLayout.setOnClickListener(new C1348f1());
        this.f17809z0 = (FrameLayout) findViewById(R.id.fl_banner_floating);
        L2((RelativeLayout) findViewById(R.id.app_info_selected_popup));
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.J()) {
            RelativeLayout relativeLayout2 = this.f17783N;
            kotlin.jvm.internal.m.b(relativeLayout2);
            relativeLayout2.setVisibility(8);
            aVar.t0(false);
        }
        this.f17787R = (RelativeLayout) findViewById(R.id.rl_wizard);
        q2();
        this.f17788S = (Toolbar) findViewById(R.id.toolbar_main);
        this.f17789T = (AppBarLayout) findViewById(R.id.abl_toolbar);
        this.f17792W = (TabLayout) findViewById(R.id.tab_parent_categories);
        ((ImageView) findViewById(R.id.home_uptodown_logo)).setOnClickListener(new C1425q1(this));
        ((TextView) findViewById(R.id.tv_main_search_view)).setTypeface(N1.k.f7778g.x());
        ((RelativeLayout) findViewById(R.id.rl_main_search_view)).setOnClickListener(new C1459v1(this));
        ((ImageView) findViewById(R.id.home_uptodown_turbo)).setOnClickListener(new C1466w1(this));
        b8();
        b8();
        String str3 = null;
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new p(this, (d) null), 3, (Object) null);
        V5();
        runOnUiThread(new C1473x1(this));
        UptodownApp.a.P0(aVar, this, false, 2, (Object) null);
        if (!a.f18818a.V(this)) {
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
            new b2.q(applicationContext);
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            kotlin.jvm.internal.m.d(intent, "getIntent(...)");
            if (!m8(intent)) {
                Uri data = getIntent().getData();
                if (data != null) {
                    String uri = data.toString();
                    kotlin.jvm.internal.m.d(uri, "toString(...)");
                    String j5 = new C1612h().j(data, this);
                    Class<InstallerActivity> cls = InstallerActivity.class;
                    if (j5 != null && m3.m.o(j5, ".apk", false, 2, (Object) null)) {
                        String i4 = new u2.w().i(j5);
                        if (i4 != null) {
                            D2(i4, (C2054l) null);
                        } else {
                            Intent intent2 = new Intent(getApplicationContext(), cls);
                            intent2.setData(data);
                            this.f17782I0.launch(intent2);
                        }
                    } else if (j5 != null && W1.G.f8470b.a(j5)) {
                        Intent intent3 = new Intent(getApplicationContext(), cls);
                        intent3.setData(data);
                        this.f17782I0.launch(intent3);
                    } else if (m3.m.y(uri, "https://dw.uptodown.com/dwn/", false, 2, (Object) null)) {
                        new C1632d(this, uri, new q(this, uri), LifecycleOwnerKt.getLifecycleScope(this));
                    } else if (m3.m.D(uri, "preregister-available", false, 2, (Object) null)) {
                        String queryParameter = data.getQueryParameter("appID");
                        if (!(queryParameter == null || queryParameter.length() == 0)) {
                            try {
                                String queryParameter2 = data.getQueryParameter("appID");
                                kotlin.jvm.internal.m.b(queryParameter2);
                                C2(Long.parseLong(queryParameter2));
                            } catch (NumberFormatException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } else if (!aVar.S(this)) {
                        new b2.m(this, new u2.q().j(data), this.f17776C0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
                Intent intent4 = getIntent();
                if (intent4 == null || (extras2 = intent4.getExtras()) == null) {
                    str = null;
                } else {
                    str = extras2.getString("appId");
                }
                if (str != null) {
                    try {
                        j4 = Long.parseLong(str);
                    } catch (NumberFormatException e6) {
                        e6.printStackTrace();
                        j4 = -1;
                    }
                    if (j4 > 0) {
                        Bundle extras3 = getIntent().getExtras();
                        if (extras3 != null) {
                            str2 = extras3.getString("packageName");
                        } else {
                            str2 = null;
                        }
                        C2033A a5 = new C2033A();
                        a5.j(j4);
                        a5.m(str2);
                        a5.n(this);
                        new C1640l(this, j4, this.f17776C0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                } else {
                    C2033A b5 = C2033A.f20327f.b(this);
                    if (b5 != null && !b5.g()) {
                        new C1640l(this, b5.b(), this.f17776C0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
                Intent intent5 = getIntent();
                if (!(intent5 == null || (extras = intent5.getExtras()) == null)) {
                    str3 = extras.getString("campaign");
                }
                if (str3 != null && m3.m.p(str3, "BlackFriday", true)) {
                    Y2();
                }
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f17781H0);
        U2(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1480y1(this)));
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager);
        this.f17794Y = viewPager2;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(4);
        }
        ViewPager2 viewPager22 = this.f17794Y;
        if (viewPager22 != null) {
            viewPager22.setUserInputEnabled(false);
        }
        this.f17798o0 = (TabLayout) findViewById(R.id.tabs);
        this.f17796m0 = (RelativeLayout) findViewById(R.id.rl_app_detail_open);
        i7();
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        kotlin.jvm.internal.m.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return super.onKeyDown(i4, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!d6()) {
            Z7();
            C2313C.f21882a.h(this);
            if (a6()) {
                h7();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f17775B0 = new C2074f((Handler) null, new H0(this));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f17775B0 = null;
    }

    /* access modifiers changed from: protected */
    public void s3() {
    }

    /* access modifiers changed from: protected */
    public void t3() {
    }

    public final void v7() {
        if (this.f17795Z == null) {
            this.f17795Z = (RelativeLayout) findViewById(R.id.rl_container_error_no_connection);
            View inflate = LayoutInflater.from(this).inflate(R.layout.error_no_connection, this.f17795Z, false);
            RelativeLayout relativeLayout = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout);
            relativeLayout.addView(inflate);
            RelativeLayout relativeLayout2 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout2);
            k.a aVar = N1.k.f7778g;
            ((TextView) relativeLayout2.findViewById(R.id.tv_msg_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout3 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout3);
            ((TextView) relativeLayout3.findViewById(R.id.tv_my_apps_label_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout4 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout4);
            TextView textView = (TextView) relativeLayout4.findViewById(R.id.tv_updates_available_enc);
            textView.setTypeface(aVar.x());
            textView.setOnClickListener(new C1397m1(this));
            RelativeLayout relativeLayout5 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout5);
            TextView textView2 = (TextView) relativeLayout5.findViewById(R.id.tv_installed_enc);
            textView2.setTypeface(aVar.x());
            textView2.setOnClickListener(new C1404n1(this));
            RelativeLayout relativeLayout6 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout6);
            TextView textView3 = (TextView) relativeLayout6.findViewById(R.id.tv_downloads_enc);
            textView3.setTypeface(aVar.x());
            textView3.setOnClickListener(new C1411o1(this));
            RelativeLayout relativeLayout7 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout7);
            ((TextView) relativeLayout7.findViewById(R.id.tv_settings_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout8 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout8);
            ((LinearLayout) relativeLayout8.findViewById(R.id.ll_container_settings_enc)).setOnClickListener(new C1418p1(this));
            RelativeLayout relativeLayout9 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout9);
            TextView textView4 = (TextView) relativeLayout9.findViewById(R.id.tv_refresh_enc);
            textView4.setTypeface(aVar.w());
            textView4.setOnClickListener(new C1431r1(this));
            RelativeLayout relativeLayout10 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout10);
            this.f17797n0 = (ProgressBar) relativeLayout10.findViewById(R.id.pb_loading_refresh_enc);
            RelativeLayout relativeLayout11 = this.f17795Z;
            kotlin.jvm.internal.m.b(relativeLayout11);
            ((RelativeLayout) relativeLayout11.findViewById(R.id.rl_container_progressbar_enc)).setOnClickListener(new C1438s1());
        }
        RelativeLayout relativeLayout12 = this.f17795Z;
        kotlin.jvm.internal.m.b(relativeLayout12);
        relativeLayout12.setVisibility(0);
        ProgressBar progressBar = this.f17797n0;
        kotlin.jvm.internal.m.b(progressBar);
        progressBar.setVisibility(4);
    }

    public final void w5(int i4) {
        TabLayout tabLayout = this.f17798o0;
        kotlin.jvm.internal.m.b(tabLayout);
        if (i4 < tabLayout.getTabCount()) {
            TabLayout tabLayout2 = this.f17798o0;
            kotlin.jvm.internal.m.b(tabLayout2);
            if (tabLayout2.getSelectedTabPosition() != i4) {
                TabLayout tabLayout3 = this.f17798o0;
                kotlin.jvm.internal.m.b(tabLayout3);
                TabLayout.Tab tabAt = tabLayout3.getTabAt(i4);
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p3(U u4) {
    }

    /* access modifiers changed from: protected */
    public void r3(U u4, String str) {
    }
}
