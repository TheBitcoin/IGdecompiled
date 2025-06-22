package com.uptodown.tv.ui.fragment;

import R2.n;
import R2.s;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C1640l;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.preferences.a;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.C2027s;
import f2.W;
import g2.C2050h;
import g2.C2060s;
import g2.K;
import g2.O;
import g2.S;
import g2.U;
import g2.r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import p2.C2202a;
import p2.C2203b;
import r2.C2237a;
import r2.C2238b;
import r2.C2239c;
import r2.C2240d;
import r2.C2241e;
import r2.C2242f;
import r2.C2243g;
import r2.C2244h;
import r2.C2245i;
import r2.C2246j;
import r2.C2247k;
import r2.C2248l;
import r2.C2249m;
import u2.m;
import u2.t;
import u2.x;

public final class TvAppDetailFragment extends DetailsSupportFragment {

    /* renamed from: p  reason: collision with root package name */
    public static final a f19300p = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2050h f19301a;

    /* renamed from: b  reason: collision with root package name */
    private long f19302b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f19303c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ArrayObjectAdapter f19304d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BackgroundManager f19305e;

    /* renamed from: f  reason: collision with root package name */
    private AlertDialog f19306f;

    /* renamed from: g  reason: collision with root package name */
    private AlertDialog f19307g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public DetailsOverviewRow f19308h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f19309i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public S f19310j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public C2203b f19311k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19312l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19313m = true;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f19314n;

    /* renamed from: o  reason: collision with root package name */
    private final ActivityResultLauncher f19315o;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19316a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19317b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2050h f19318c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19319a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19320b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f19321c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C c5, V2.d dVar) {
                super(2, dVar);
                this.f19320b = tvAppDetailFragment;
                this.f19321c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19320b, this.f19321c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19319a == 0) {
                    n.b(obj);
                    this.f19320b.o0((C2060s) this.f19321c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TvAppDetailFragment tvAppDetailFragment, C2050h hVar, V2.d dVar) {
            super(2, dVar);
            this.f19317b = tvAppDetailFragment;
            this.f19318c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19317b, this.f19318c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2050h hVar;
            Object c5 = W2.b.c();
            int i4 = this.f19316a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                try {
                    if (!(this.f19317b.getContext() == null || (hVar = this.f19318c) == null || hVar.Q() == null)) {
                        this.f19317b.f19309i = new m().s(this.f19318c.Q(), this.f19317b.getContext());
                        t.a aVar = t.f21927u;
                        Context requireContext = this.f19317b.requireContext();
                        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                        t a5 = aVar.a(requireContext);
                        a5.a();
                        if (this.f19317b.f19309i) {
                            TvAppDetailFragment tvAppDetailFragment = this.f19317b;
                            String Q4 = this.f19318c.Q();
                            kotlin.jvm.internal.m.b(Q4);
                            tvAppDetailFragment.f19310j = a5.D0(Q4);
                        }
                        c6.f20968a = a5.f0(String.valueOf(this.f19318c.z()));
                        a5.i();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                E0 c7 = Y.c();
                a aVar2 = new a(this.f19317b, c6, (V2.d) null);
                this.f19316a = 1;
                if (C0977g.g(c7, aVar2, this) == c5) {
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19322a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2060s f19323b;

        c(TvAppDetailFragment tvAppDetailFragment, C2060s sVar) {
            this.f19322a = tvAppDetailFragment;
            this.f19323b = sVar;
        }

        /* access modifiers changed from: private */
        public static final s e(TvAppDetailFragment tvAppDetailFragment, C2060s sVar) {
            tvAppDetailFragment.b0(sVar);
            return s.f8222a;
        }

        /* access modifiers changed from: private */
        public static final s f(TvAppDetailFragment tvAppDetailFragment) {
            tvAppDetailFragment.K();
            return s.f8222a;
        }

        public void a(K k4) {
            kotlin.jvm.internal.m.e(k4, "reportVT");
            if (this.f19322a.getActivity() != null && (this.f19322a.getActivity() instanceof C1826a) && !this.f19322a.requireActivity().isFinishing()) {
                C2050h u4 = this.f19322a.f19301a;
                kotlin.jvm.internal.m.b(u4);
                u4.R0(k4);
                if (k4.d() > 0) {
                    FragmentActivity activity = this.f19322a.getActivity();
                    kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2050h u5 = this.f19322a.f19301a;
                    kotlin.jvm.internal.m.b(u5);
                    ((C1826a) activity).d2(u5, new C2248l(this.f19322a, this.f19323b), new C2249m(this.f19322a));
                    return;
                }
                this.f19322a.b0(this.f19323b);
            }
        }

        public void b() {
            this.f19322a.b0(this.f19323b);
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19324a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19325a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19326b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
                super(2, dVar);
                this.f19326b = tvAppDetailFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19326b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f19325a;
                if (i4 == 0) {
                    n.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f19326b;
                    this.f19325a = 1;
                    if (tvAppDetailFragment.d0(this) == c5) {
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
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        d(TvAppDetailFragment tvAppDetailFragment) {
            this.f19324a = tvAppDetailFragment;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f19324a.f19301a = hVar;
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f19324a), (V2.g) null, (L) null, new a(this.f19324a, (V2.d) null), 3, (Object) null);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19327a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19328b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19329a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19330b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
                super(2, dVar);
                this.f19330b = tvAppDetailFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19330b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19329a == 0) {
                    n.b(obj);
                    if (this.f19330b.getContext() != null) {
                        C2203b y4 = this.f19330b.f19311k;
                        kotlin.jvm.internal.m.b(y4);
                        Context requireContext = this.f19330b.requireContext();
                        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                        y4.a(requireContext, this.f19330b.f19301a);
                    }
                    this.f19330b.L0();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
            super(2, dVar);
            this.f19328b = tvAppDetailFragment;
        }

        /* access modifiers changed from: private */
        public static final int k(O o4, O o5) {
            return o4.b() - o5.b();
        }

        /* access modifiers changed from: private */
        public static final int l(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19328b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
            if (r1.isEmpty() != false) goto L_0x0065;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r10.f19327a
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                R2.n.b(r11)
                goto L_0x019a
            L_0x0010:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0018:
                R2.n.b(r11)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r11 = r10.f19328b
                android.content.Context r11 = r11.getContext()
                if (r11 == 0) goto L_0x0185
                u2.L r11 = new u2.L
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                android.content.Context r1 = r1.requireContext()
                java.lang.String r3 = "requireContext(...)"
                kotlin.jvm.internal.m.d(r1, r3)
                r11.<init>(r1)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                if (r1 == 0) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                java.util.ArrayList r1 = r1.y0()
                r3 = 0
                java.lang.String r4 = "data"
                java.lang.String r5 = "success"
                if (r1 == 0) goto L_0x0065
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                java.util.ArrayList r1 = r1.y0()
                kotlin.jvm.internal.m.b(r1)
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x00c8
            L_0x0065:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                long r6 = r1.e()
                g2.L r1 = r11.z0(r6)
                boolean r6 = r1.b()
                if (r6 != 0) goto L_0x00c8
                org.json.JSONObject r6 = r1.e()
                if (r6 == 0) goto L_0x00c8
                org.json.JSONObject r1 = r1.e()
                kotlin.jvm.internal.m.b(r1)
                int r6 = r1.optInt(r5)
                if (r6 != r2) goto L_0x00c8
                org.json.JSONObject r1 = r1.optJSONObject(r4)
                if (r1 == 0) goto L_0x00c8
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.lang.String r7 = "videos"
                org.json.JSONArray r1 = r1.optJSONArray(r7)
                if (r1 == 0) goto L_0x00bc
                r7 = 0
            L_0x00a3:
                int r8 = r1.length()
                if (r7 >= r8) goto L_0x00bc
                org.json.JSONObject r8 = r1.getJSONObject(r7)
                g2.Z$b r9 = g2.Z.f20518c
                kotlin.jvm.internal.m.b(r8)
                g2.Z r8 = r9.a(r8)
                r6.add(r8)
                int r7 = r7 + 1
                goto L_0x00a3
            L_0x00bc:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                r1.V0(r6)
            L_0x00c8:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                java.util.ArrayList r1 = r1.h0()
                if (r1 != 0) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                long r6 = r1.e()
                g2.L r11 = r11.e0(r6)
                boolean r1 = r11.b()
                if (r1 != 0) goto L_0x0166
                java.lang.String r1 = r11.d()
                if (r1 == 0) goto L_0x0166
                int r1 = r1.length()
                if (r1 != 0) goto L_0x00fb
                goto L_0x0166
            L_0x00fb:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r11 = r11.d()
                kotlin.jvm.internal.m.b(r11)
                r1.<init>(r11)
                int r11 = r1.optInt(r5)
                if (r11 != r2) goto L_0x0185
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                org.json.JSONArray r1 = r1.optJSONArray(r4)
                if (r1 == 0) goto L_0x0185
                int r4 = r1.length()
            L_0x011c:
                if (r3 >= r4) goto L_0x014c
                org.json.JSONObject r5 = r1.optJSONObject(r3)
                g2.O$b r6 = g2.O.f20438e
                kotlin.jvm.internal.m.b(r5)
                g2.O r5 = r6.a(r5)
                int r6 = r5.a()
                if (r6 != 0) goto L_0x0139
                boolean r5 = r11.add(r5)
                kotlin.coroutines.jvm.internal.b.a(r5)
                goto L_0x0149
            L_0x0139:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r6 = r10.f19328b
                g2.h r6 = r6.f19301a
                kotlin.jvm.internal.m.b(r6)
                java.lang.String r5 = r5.c()
                r6.M0(r5)
            L_0x0149:
                int r3 = r3 + 1
                goto L_0x011c
            L_0x014c:
                com.uptodown.tv.ui.fragment.a r1 = new com.uptodown.tv.ui.fragment.a
                r1.<init>()
                com.uptodown.tv.ui.fragment.b r3 = new com.uptodown.tv.ui.fragment.b
                r3.<init>(r1)
                S2.C1601o.t(r11, r3)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f19328b
                g2.h r1 = r1.f19301a
                kotlin.jvm.internal.m.b(r1)
                r1.S0(r11)
                goto L_0x0185
            L_0x0166:
                boolean r1 = r11.b()
                if (r1 == 0) goto L_0x0185
                int r11 = r11.f()
                r1 = 404(0x194, float:5.66E-43)
                if (r11 != r1) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r11 = r10.f19328b
                g2.h r11 = r11.f19301a
                kotlin.jvm.internal.m.b(r11)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                r11.S0(r1)
            L_0x0185:
                o3.E0 r11 = o3.Y.c()
                com.uptodown.tv.ui.fragment.TvAppDetailFragment$e$a r1 = new com.uptodown.tv.ui.fragment.TvAppDetailFragment$e$a
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r3 = r10.f19328b
                r4 = 0
                r1.<init>(r3, r4)
                r10.f19327a = r2
                java.lang.Object r11 = o3.C0977g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x019a
                return r0
            L_0x019a:
                R2.s r11 = R2.s.f8222a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19331a;

        f(TvAppDetailFragment tvAppDetailFragment) {
            this.f19331a = tvAppDetailFragment;
        }

        public void b(int i4) {
            if (i4 == 404) {
                this.f19331a.f19314n = true;
            }
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f19331a.f19301a = hVar;
            this.f19331a.h0();
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19333b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
            super(2, dVar);
            this.f19333b = tvAppDetailFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f19333b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19332a;
            if (i4 == 0) {
                n.b(obj);
                TvAppDetailFragment tvAppDetailFragment = this.f19333b;
                this.f19332a = 1;
                if (tvAppDetailFragment.s0(this) == c5) {
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
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19334a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19335b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
            super(2, dVar);
            this.f19335b = tvAppDetailFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f19335b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            W2.b.c();
            if (this.f19334a == 0) {
                n.b(obj);
                try {
                    C2050h u4 = this.f19335b.f19301a;
                    if (u4 != null) {
                        str = u4.y();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        BackgroundManager x4 = this.f19335b.f19305e;
                        if (x4 == null) {
                            return null;
                        }
                        com.squareup.picasso.s h4 = com.squareup.picasso.s.h();
                        C2050h u5 = this.f19335b.f19301a;
                        kotlin.jvm.internal.m.b(u5);
                        x4.setBitmap(h4.l(u5.y()).g());
                        return s.f8222a;
                    }
                    Drawable drawable = ContextCompat.getDrawable(this.f19335b.requireContext(), R.drawable.feature_tv);
                    BackgroundManager x5 = this.f19335b.f19305e;
                    if (x5 == null) {
                        return null;
                    }
                    x5.setDrawable(drawable);
                    return s.f8222a;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return s.f8222a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19337b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DetailsOverviewRow f19338c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19339a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19340b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
                super(2, dVar);
                this.f19340b = tvAppDetailFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19340b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19339a == 0) {
                    n.b(obj);
                    this.f19340b.startEntranceTransition();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(TvAppDetailFragment tvAppDetailFragment, DetailsOverviewRow detailsOverviewRow, V2.d dVar) {
            super(2, dVar);
            this.f19337b = tvAppDetailFragment;
            this.f19338c = detailsOverviewRow;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f19337b, this.f19338c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object c5 = W2.b.c();
            int i4 = this.f19336a;
            if (i4 == 0) {
                n.b(obj);
                try {
                    if (this.f19337b.getContext() != null) {
                        C2050h u4 = this.f19337b.f19301a;
                        if (u4 != null) {
                            str = u4.E();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            DetailsOverviewRow detailsOverviewRow = this.f19338c;
                            Context context = this.f19337b.getContext();
                            com.squareup.picasso.s h4 = com.squareup.picasso.s.h();
                            C2050h u5 = this.f19337b.f19301a;
                            kotlin.jvm.internal.m.b(u5);
                            detailsOverviewRow.setImageBitmap(context, h4.l(u5.E()).l(R.drawable.shape_bg_placeholder).g());
                        }
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                E0 c6 = Y.c();
                a aVar = new a(this.f19337b, (V2.d) null);
                this.f19336a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
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

    public static final class j implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19341a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19342a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19343b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
                super(2, dVar);
                this.f19343b = tvAppDetailFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19343b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f19342a;
                if (i4 == 0) {
                    n.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f19343b;
                    this.f19342a = 1;
                    if (tvAppDetailFragment.s0(this) == c5) {
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
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        j(TvAppDetailFragment tvAppDetailFragment) {
            this.f19341a = tvAppDetailFragment;
        }

        public void a(Exception exc) {
            kotlin.jvm.internal.m.e(exc, "e");
        }

        public void b() {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f19341a), (V2.g) null, (L) null, new a(this.f19341a, (V2.d) null), 3, (Object) null);
        }
    }

    public static final class k implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19344a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19345a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f19346b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
                super(2, dVar);
                this.f19346b = tvAppDetailFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19346b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f19345a;
                if (i4 == 0) {
                    n.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f19346b;
                    DetailsOverviewRow w4 = tvAppDetailFragment.f19308h;
                    kotlin.jvm.internal.m.b(w4);
                    this.f19345a = 1;
                    if (tvAppDetailFragment.t0(w4, this) == c5) {
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
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        k(TvAppDetailFragment tvAppDetailFragment) {
            this.f19344a = tvAppDetailFragment;
        }

        public void a(Exception exc) {
            kotlin.jvm.internal.m.e(exc, "e");
        }

        public void b() {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this.f19344a), (V2.g) null, (L) null, new a(this.f19344a, (V2.d) null), 3, (Object) null);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19347a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f19348b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(TvAppDetailFragment tvAppDetailFragment, V2.d dVar) {
            super(2, dVar);
            this.f19348b = tvAppDetailFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f19348b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19347a;
            if (i4 == 0) {
                n.b(obj);
                TvAppDetailFragment tvAppDetailFragment = this.f19348b;
                C2050h u4 = tvAppDetailFragment.f19301a;
                this.f19347a = 1;
                if (tvAppDetailFragment.L(u4, this) == c5) {
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

    public TvAppDetailFragment() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2245i(this));
        kotlin.jvm.internal.m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f19315o = registerForActivityResult;
    }

    private final void A0() {
        if (getActivity() != null) {
            if (this.f19303c != 2) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
                sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.option_button_install)));
                if (!(getActivity() == null || this.f19301a == null)) {
                    String packageName = requireActivity().getPackageName();
                    C2050h hVar = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar);
                    if (!m3.m.p(packageName, hVar.Q(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f19308h;
                kotlin.jvm.internal.m.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f19303c = 2;
            }
            C2203b bVar = this.f19311k;
            kotlin.jvm.internal.m.b(bVar);
            bVar.b(0);
        }
    }

    private final void B0() {
        if (getActivity() != null) {
            if (this.f19303c != 7) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
                sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.installing)));
                if (!(getActivity() == null || this.f19301a == null)) {
                    String packageName = requireActivity().getPackageName();
                    C2050h hVar = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar);
                    if (!m3.m.p(packageName, hVar.Q(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f19308h;
                kotlin.jvm.internal.m.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f19303c = 7;
            }
            C2203b bVar = this.f19311k;
            kotlin.jvm.internal.m.b(bVar);
            bVar.c(true);
        }
    }

    private final void C0() {
        if (getActivity() != null && this.f19303c != 11) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.app_detail_not_compatible)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 11;
        }
    }

    private final void D0() {
        if (getActivity() != null && this.f19303c != 0) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            if (!(getActivity() == null || this.f19301a == null)) {
                String packageName = requireActivity().getPackageName();
                C2050h hVar = this.f19301a;
                kotlin.jvm.internal.m.b(hVar);
                if (!m3.m.p(packageName, hVar.Q(), true)) {
                    sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.open)));
                    sparseArrayObjectAdapter.set(2, new Action(2, getString(R.string.dialogo_app_selected_uninstall)));
                    sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                }
            }
            sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
            sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 0;
        }
    }

    private final void E0() {
        if (getActivity() != null) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.updates_button_resume)));
            if (!(getActivity() == null || this.f19301a == null)) {
                String packageName = requireActivity().getPackageName();
                C2050h hVar = this.f19301a;
                kotlin.jvm.internal.m.b(hVar);
                if (!m3.m.p(packageName, hVar.Q(), true)) {
                    sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                }
            }
            sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
            sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 4;
        }
    }

    private final void F0() {
        A0();
        this.f19303c = 6;
    }

    private final void G0() {
        E0();
        this.f19303c = 4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075 A[Catch:{ Exception -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void H0() {
        /*
            r9 = this;
            r0 = 5
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00c8
            g2.h r1 = r9.f19301a     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00c8
            androidx.leanback.widget.SparseArrayObjectAdapter r1 = new androidx.leanback.widget.SparseArrayObjectAdapter     // Catch:{ Exception -> 0x0031 }
            p2.a r2 = new p2.a     // Catch:{ Exception -> 0x0031 }
            r2.<init>()     // Catch:{ Exception -> 0x0031 }
            r1.<init>((androidx.leanback.widget.Presenter) r2)     // Catch:{ Exception -> 0x0031 }
            g2.h r2 = r9.f19301a     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            java.lang.String r2 = r2.l0()     // Catch:{ NumberFormatException -> 0x0034 }
            if (r2 == 0) goto L_0x0038
            g2.h r2 = r9.f19301a     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            java.lang.String r2 = r2.l0()     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            goto L_0x003a
        L_0x0031:
            r1 = move-exception
            goto L_0x00c5
        L_0x0034:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x0031 }
        L_0x0038:
            r2 = 0
        L_0x003a:
            androidx.leanback.widget.Action r4 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r5 = 2131952761(0x7f130479, float:1.9541974E38)
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x0031 }
            W1.i r6 = new W1.i     // Catch:{ Exception -> 0x0031 }
            r6.<init>()     // Catch:{ Exception -> 0x0031 }
            android.content.Context r7 = r9.requireContext()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r8 = "requireContext(...)"
            kotlin.jvm.internal.m.d(r7, r8)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r6.d(r2, r7)     // Catch:{ Exception -> 0x0031 }
            r6 = 1
            r4.<init>(r6, r5, r2)     // Catch:{ Exception -> 0x0031 }
            r2 = 1
            r1.set(r2, r4)     // Catch:{ Exception -> 0x0031 }
            androidx.fragment.app.FragmentActivity r3 = r9.requireActivity()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0031 }
            g2.h r4 = r9.f19301a     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r4 = r4.Q()     // Catch:{ Exception -> 0x0031 }
            boolean r2 = m3.m.p(r3, r4, r2)     // Catch:{ Exception -> 0x0031 }
            if (r2 != 0) goto L_0x0099
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951935(0x7f13013f, float:1.9540299E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 2
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 2
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951934(0x7f13013e, float:1.9540297E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 3
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 3
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
        L_0x0099:
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131952832(0x7f1304c0, float:1.9542118E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 4
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 4
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951685(0x7f130045, float:1.9539791E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 5
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r1.set(r0, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.DetailsOverviewRow r2 = r9.f19308h     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0031 }
            r2.setActionsAdapter(r1)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00c8
        L_0x00c5:
            r1.printStackTrace()
        L_0x00c8:
            r9.f19303c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.H0():void");
    }

    private final void I0(FragmentActivity fragmentActivity) {
        this.f19311k = new C2203b();
        FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(this.f19311k, new p2.c());
        fullWidthDetailsOverviewRowPresenter.setBackgroundColor(ContextCompat.getColor(fragmentActivity, R.color.background_color));
        fullWidthDetailsOverviewRowPresenter.setInitialState(0);
        FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        fullWidthDetailsOverviewSharedElementHelper.setSharedElementEnterTransition(fragmentActivity, "transition_name");
        fullWidthDetailsOverviewRowPresenter.setListener(fullWidthDetailsOverviewSharedElementHelper);
        fullWidthDetailsOverviewRowPresenter.setParticipatingEntranceTransition(false);
        prepareEntranceTransition();
        fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new C2246j(this, fragmentActivity));
        fullWidthDetailsOverviewRowPresenter.setActionsBackgroundColor(ContextCompat.getColor(fragmentActivity, R.color.main_blue));
        ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
        classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);
        classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((PresenterSelector) classPresenterSelector);
        this.f19304d = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    private final void J() {
        switch (this.f19303c) {
            case 0:
                m0();
                return;
            case 1:
                a0();
                return;
            case 2:
                a0();
                return;
            case 3:
                K();
                return;
            case 4:
                a0();
                return;
            case 5:
                a0();
                return;
            case 6:
                a0();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static final void J0(TvAppDetailFragment tvAppDetailFragment, FragmentActivity fragmentActivity, Action action) {
        kotlin.jvm.internal.m.e(action, "action");
        if (action.getId() == 1) {
            tvAppDetailFragment.J();
        } else if (action.getId() == 2) {
            tvAppDetailFragment.M0();
        } else if (action.getId() == 3) {
            if (tvAppDetailFragment.f19301a != null) {
                Intent intent = new Intent(fragmentActivity, TvOldVersionsActivity.class);
                intent.putExtra("appInfo", tvAppDetailFragment.f19301a);
                tvAppDetailFragment.startActivity(intent, UptodownApp.f17422D.a(fragmentActivity));
            }
        } else if (action.getId() == 4) {
            if (tvAppDetailFragment.f19301a != null) {
                Intent intent2 = new Intent(fragmentActivity, VirusTotalReport.class);
                intent2.putExtra("appInfo", tvAppDetailFragment.f19301a);
                tvAppDetailFragment.startActivity(intent2, UptodownApp.f17422D.a(fragmentActivity));
            }
        } else if (action.getId() == 5) {
            tvAppDetailFragment.n0();
        }
    }

    /* access modifiers changed from: private */
    public final void K() {
        if (this.f19301a != null && getContext() != null) {
            DownloadWorker.a aVar = DownloadWorker.f19459d;
            C2050h hVar = this.f19301a;
            kotlin.jvm.internal.m.b(hVar);
            aVar.d(hVar.e());
        }
    }

    private final void K0() {
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
        DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(this.f19301a);
        this.f19308h = detailsOverviewRow;
        kotlin.jvm.internal.m.b(detailsOverviewRow);
        detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
        C2050h hVar = this.f19301a;
        kotlin.jvm.internal.m.b(hVar);
        if (hVar.y() != null) {
            com.squareup.picasso.s h4 = com.squareup.picasso.s.h();
            C2050h hVar2 = this.f19301a;
            kotlin.jvm.internal.m.b(hVar2);
            h4.l(hVar2.y()).e(new j(this));
        } else if (getContext() != null) {
            Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.feature_tv);
            BackgroundManager backgroundManager = this.f19305e;
            kotlin.jvm.internal.m.b(backgroundManager);
            backgroundManager.setDrawable(drawable);
        }
        com.squareup.picasso.s h5 = com.squareup.picasso.s.h();
        C2050h hVar3 = this.f19301a;
        kotlin.jvm.internal.m.b(hVar3);
        h5.l(hVar3.E()).e(new k(this));
        ArrayObjectAdapter arrayObjectAdapter = this.f19304d;
        kotlin.jvm.internal.m.b(arrayObjectAdapter);
        arrayObjectAdapter.add(this.f19308h);
    }

    /* access modifiers changed from: private */
    public final Object L(C2050h hVar, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, hVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void L0() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new l(this, (V2.d) null), 3, (Object) null);
    }

    private final void M(C2060s sVar) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            U.b bVar = U.f20468m;
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.m.d(requireActivity, "requireActivity(...)");
            U e5 = bVar.e(requireActivity);
            if (e5 == null || !e5.n()) {
                b0(sVar);
                s sVar2 = s.f8222a;
                return;
            }
            C2050h hVar = this.f19301a;
            kotlin.jvm.internal.m.b(hVar);
            if (hVar.e0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                kotlin.jvm.internal.m.d(requireActivity2, "requireActivity(...)");
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                String valueOf = String.valueOf(hVar2.z());
                C2050h hVar3 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar3);
                new b2.p(requireActivity2, valueOf, hVar3.i0(), new c(this, sVar), LifecycleOwnerKt.getLifecycleScope(this));
                return;
            }
            C2050h hVar4 = this.f19301a;
            kotlin.jvm.internal.m.b(hVar4);
            K e02 = hVar4.e0();
            kotlin.jvm.internal.m.b(e02);
            if (e02.d() > 0) {
                FragmentActivity activity = getActivity();
                kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                C2050h hVar5 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar5);
                ((C1826a) activity).d2(hVar5, new C2239c(this, sVar), new C2240d(this));
            } else {
                b0(sVar);
            }
            s sVar3 = s.f8222a;
        }
    }

    private final void M0() {
        C2050h hVar = this.f19301a;
        if (hVar != null) {
            kotlin.jvm.internal.m.b(hVar);
            if (hVar.Q() != null) {
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                N1.j jVar = new N1.j(requireContext);
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                String Q4 = hVar2.Q();
                kotlin.jvm.internal.m.b(Q4);
                jVar.h(Q4);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final s N(TvAppDetailFragment tvAppDetailFragment, C2060s sVar) {
        tvAppDetailFragment.b0(sVar);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s O(TvAppDetailFragment tvAppDetailFragment) {
        tvAppDetailFragment.K();
        return s.f8222a;
    }

    private final void P(C2060s sVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getString(R.string.descarga_completada));
        builder.setTitle(sVar.i());
        builder.setPositiveButton(R.string.option_button_install, new C2247k(sVar, this));
        builder.setNegativeButton(17039360, new C2238b());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (getActivity() != null && !requireActivity().isFinishing()) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void Q(C2060s sVar, TvAppDetailFragment tvAppDetailFragment, DialogInterface dialogInterface, int i4) {
        File file;
        kotlin.jvm.internal.m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
        if (sVar.o().size() != 1 || ((C2060s.c) sVar.o().get(0)).a() == null) {
            if (sVar.o().size() > 1) {
                Iterator it = sVar.o().iterator();
                kotlin.jvm.internal.m.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    kotlin.jvm.internal.m.d(next, "next(...)");
                    C2060s.c cVar = (C2060s.c) next;
                    if (cVar.a() != null) {
                        String a5 = cVar.a();
                        kotlin.jvm.internal.m.b(a5);
                        file = new File(a5).getParentFile();
                        break;
                    }
                }
            }
            file = null;
        } else {
            String a6 = ((C2060s.c) sVar.o().get(0)).a();
            kotlin.jvm.internal.m.b(a6);
            file = new File(a6);
        }
        File file2 = file;
        if (file2 != null && file2.exists()) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = tvAppDetailFragment.requireActivity();
            kotlin.jvm.internal.m.d(requireActivity, "requireActivity(...)");
            UptodownApp.a.Y(aVar, file2, requireActivity, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void R(DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void S(C2060s sVar, String str) {
        AlertDialog alertDialog = this.f19306f;
        if (alertDialog != null) {
            kotlin.jvm.internal.m.b(alertDialog);
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2243g(this, sVar));
        builder.setNegativeButton(17039360, new C2244h());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f19306f = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void T(TvAppDetailFragment tvAppDetailFragment, C2060s sVar, DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialog");
        tvAppDetailFragment.b0(sVar);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void U(DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    private final boolean V() {
        AlertDialog alertDialog = this.f19307g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        if (!aVar.U(requireContext)) {
            return false;
        }
        Context requireContext2 = requireContext();
        kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
        if (aVar.i0(requireContext2)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.tracking_disabled_warning_gdpr));
        builder.setPositiveButton(R.string.gdpr_set_up, new C2241e(this));
        builder.setNegativeButton(17039360, new C2242f());
        builder.setCancelable(true);
        this.f19307g = builder.create();
        if (requireActivity().isFinishing()) {
            return false;
        }
        AlertDialog alertDialog2 = this.f19307g;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void W(TvAppDetailFragment tvAppDetailFragment, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        tvAppDetailFragment.startActivity(new Intent(tvAppDetailFragment.requireActivity(), TvPrivacyPreferences.class));
    }

    /* access modifiers changed from: private */
    public static final void X(DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void Y(String str) {
        AlertDialog alertDialog = this.f19306f;
        if (alertDialog != null) {
            kotlin.jvm.internal.m.b(alertDialog);
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2237a());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f19306f = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void Z(DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    private final void a0() {
        File file;
        C2050h hVar = this.f19301a;
        if (hVar != null) {
            kotlin.jvm.internal.m.b(hVar);
            if (!(hVar.Q() == null || getContext() == null)) {
                t.a aVar = t.f21927u;
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                t a5 = aVar.a(requireContext);
                a5.a();
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                C2060s f02 = a5.f0(String.valueOf(hVar2.z()));
                if (f02 == null || f02.o().size() != 1 || ((C2060s.c) f02.o().get(0)).a() == null) {
                    file = null;
                } else {
                    String a6 = ((C2060s.c) f02.o().get(0)).a();
                    kotlin.jvm.internal.m.b(a6);
                    file = new File(a6);
                }
                File file2 = file;
                a5.i();
                if (file2 != null) {
                    UptodownApp.a aVar2 = UptodownApp.f17422D;
                    FragmentActivity requireActivity = requireActivity();
                    kotlin.jvm.internal.m.d(requireActivity, "requireActivity(...)");
                    UptodownApp.a.Y(aVar2, file2, requireActivity, (String) null, 4, (Object) null);
                    return;
                }
                r0();
                return;
            }
        }
        r0();
    }

    /* access modifiers changed from: private */
    public final void b0(C2060s sVar) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            C2050h hVar = this.f19301a;
            kotlin.jvm.internal.m.b(hVar);
            sVar.d(hVar);
            int Q4 = sVar.Q(activity);
            if (Q4 < 0) {
                String string = getString(R.string.descarga_error);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                Y(string);
                x0();
            } else if (!DownloadApkWorker.f19447i.c(activity, Q4)) {
                F f4 = F.f20971a;
                String string2 = getString(R.string.msg_added_to_downlads_queue);
                kotlin.jvm.internal.m.d(string2, "getString(...)");
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                String format = String.format(string2, Arrays.copyOf(new Object[]{hVar2.L()}, 1));
                kotlin.jvm.internal.m.d(format, "format(...)");
                Y(format);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object d0(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void e0() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, this.f19302b, new f(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final boolean g0() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return f0();
    }

    /* access modifiers changed from: private */
    public final void h0() {
        if (this.f19301a != null && getActivity() != null && !j0() && !V()) {
            p0();
        }
    }

    private final boolean i0() {
        C2050h hVar = this.f19301a;
        if (hVar == null) {
            return false;
        }
        UptodownApp.a aVar = UptodownApp.f17422D;
        kotlin.jvm.internal.m.b(hVar);
        return aVar.L(hVar.Q());
    }

    private final boolean j0() {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        C2050h hVar = this.f19301a;
        kotlin.jvm.internal.m.b(hVar);
        return aVar.j(hVar.e());
    }

    private final void k0(String str) {
        if (this.f19301a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("type", str);
            C2050h hVar = this.f19301a;
            kotlin.jvm.internal.m.b(hVar);
            bundle.putString("packagename", hVar.Q());
            C2050h hVar2 = this.f19301a;
            kotlin.jvm.internal.m.b(hVar2);
            if (hVar2.e() >= 0) {
                C2050h hVar3 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar3);
                bundle.putString("appId", String.valueOf(hVar3.e()));
            }
            C2050h hVar4 = this.f19301a;
            kotlin.jvm.internal.m.b(hVar4);
            if (hVar4.z() >= 0) {
                C2050h hVar5 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar5);
                bundle.putString("fileId", String.valueOf(hVar5.z()));
            }
            if (i0()) {
                bundle.putInt("deeplink", 1);
            } else {
                bundle.putInt("deeplink", 0);
            }
            new x(requireActivity()).d("warning", bundle);
        }
    }

    /* access modifiers changed from: private */
    public static final void l0(TvAppDetailFragment tvAppDetailFragment, ActivityResult activityResult) {
        if (tvAppDetailFragment.g0()) {
            tvAppDetailFragment.e0();
        }
    }

    private final void m0() {
        C2050h hVar = this.f19301a;
        if (hVar != null) {
            kotlin.jvm.internal.m.b(hVar);
            if (hVar.Q() != null && getContext() != null) {
                PackageManager packageManager = requireContext().getPackageManager();
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                String Q4 = hVar2.Q();
                kotlin.jvm.internal.m.b(Q4);
                Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(Q4);
                if (leanbackLaunchIntentForPackage == null) {
                    PackageManager packageManager2 = requireContext().getPackageManager();
                    C2050h hVar3 = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar3);
                    String Q5 = hVar3.Q();
                    kotlin.jvm.internal.m.b(Q5);
                    leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(Q5);
                }
                if (leanbackLaunchIntentForPackage != null) {
                    startActivity(leanbackLaunchIntentForPackage);
                }
            }
        }
    }

    private final void n0() {
        Bundle bundle;
        if (this.f19301a != null) {
            Intent intent = new Intent(getContext(), MoreInfo.class);
            intent.putExtra("appInfo", this.f19301a);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                bundle = UptodownApp.f17422D.a(activity);
            } else {
                bundle = null;
            }
            startActivity(intent, bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void o0(C2060s sVar) {
        if (getContext() != null && this.f19301a != null) {
            String str = null;
            if (!this.f19309i) {
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                if (!aVar.Q(requireContext)) {
                    u0();
                } else if (this.f19314n) {
                    z0();
                } else {
                    C2050h hVar = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar);
                    if (hVar.H0()) {
                        v0();
                        return;
                    }
                    C2050h hVar2 = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar2);
                    if (!hVar2.B0()) {
                        C0();
                        return;
                    }
                    C2050h hVar3 = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar3);
                    if (hVar3.D0()) {
                        w0();
                        return;
                    }
                    C2050h hVar4 = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar4);
                    if (hVar4.Q() != null) {
                        T1.a i4 = N1.k.f7778g.i();
                        if (i4 != null) {
                            str = i4.b();
                        }
                        C2050h hVar5 = this.f19301a;
                        kotlin.jvm.internal.m.b(hVar5);
                        if (m3.m.p(str, hVar5.Q(), true)) {
                            B0();
                        } else if (sVar == null) {
                            x0();
                        } else if (sVar.f()) {
                            A0();
                        } else if (j0()) {
                            y0(sVar);
                        } else {
                            E0();
                        }
                    }
                }
            } else if (this.f19310j == null) {
                D0();
            } else {
                T1.a i5 = N1.k.f7778g.i();
                if (i5 != null) {
                    str = i5.b();
                }
                C2050h hVar6 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar6);
                if (m3.m.p(str, hVar6.Q(), true)) {
                    B0();
                } else if (sVar == null) {
                    H0();
                } else if (sVar.f()) {
                    F0();
                } else if (j0()) {
                    y0(sVar);
                } else {
                    G0();
                }
            }
        }
    }

    private final void p0() {
        boolean z4;
        boolean z5;
        boolean z6;
        C2050h hVar = this.f19301a;
        if (hVar != null) {
            boolean z7 = true;
            if (hVar.B0()) {
                C2060s sVar = new C2060s();
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                sVar.d(hVar2);
                r rVar = new r();
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                rVar.k(requireContext);
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext2 = requireContext();
                kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                if (aVar.s1(requireContext2)) {
                    boolean i4 = rVar.i(sVar);
                    z5 = rVar.g(sVar);
                    z4 = rVar.h(sVar);
                    C2050h hVar3 = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar3);
                    if (hVar3.f0() != null) {
                        C2050h hVar4 = this.f19301a;
                        kotlin.jvm.internal.m.b(hVar4);
                        ArrayList f02 = hVar4.f0();
                        kotlin.jvm.internal.m.b(f02);
                        Context requireContext3 = requireContext();
                        kotlin.jvm.internal.m.d(requireContext3, "requireContext(...)");
                        z6 = rVar.f(f02, requireContext3);
                        z7 = i4;
                    } else {
                        z7 = i4;
                        z6 = true;
                    }
                } else {
                    z6 = true;
                    z5 = true;
                    z4 = true;
                }
                if (z7 && z5 && z4 && z6) {
                    M(sVar);
                    return;
                } else if (!z7) {
                    k0("sdk");
                    String string = getString(R.string.msg_warning_incompatible_sdk);
                    kotlin.jvm.internal.m.d(string, "getString(...)");
                    S(sVar, string);
                    return;
                } else if (!z5) {
                    k0("abi");
                    String string2 = getString(R.string.msg_warning_incompatible_abi);
                    kotlin.jvm.internal.m.d(string2, "getString(...)");
                    S(sVar, string2);
                    return;
                } else if (!z4) {
                    k0("density");
                    String string3 = getString(R.string.msg_warning_incompatible_density);
                    kotlin.jvm.internal.m.d(string3, "getString(...)");
                    S(sVar, string3);
                    return;
                } else {
                    k0("required_feature");
                    String string4 = getString(R.string.msg_warning_incompatible_required_features);
                    kotlin.jvm.internal.m.d(string4, "getString(...)");
                    S(sVar, string4);
                    return;
                }
            }
        }
        k0("no_file_id");
        String string5 = getString(R.string.msg_app_no_compatible_files);
        kotlin.jvm.internal.m.d(string5, "getString(...)");
        Y(string5);
    }

    private final void q0() {
        if (!f0()) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        } else {
            e0();
        }
    }

    private final void r0() {
        if (Build.VERSION.SDK_INT < 30) {
            q0();
        } else if (!Environment.isExternalStorageManager()) {
            try {
                this.f19315o.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + requireContext().getPackageName())));
            } catch (ActivityNotFoundException unused) {
                q0();
            }
        } else {
            q0();
        }
    }

    /* access modifiers changed from: private */
    public final Object s0(V2.d dVar) {
        return C0977g.g(Y.b(), new h(this, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final Object t0(DetailsOverviewRow detailsOverviewRow, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new i(this, detailsOverviewRow, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void u0() {
        if (getActivity() != null && this.f19303c != 9) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.status_checking_device_compatibility)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 9;
        }
    }

    private final void v0() {
        if (getActivity() != null && this.f19303c != 8) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.coming_soon_button)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 8;
        }
    }

    private final void w0() {
        if (getActivity() != null && this.f19303c != 13) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.status_discontinued)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 13;
        }
    }

    private final void x0() {
        long j4;
        if (getActivity() != null) {
            if (this.f19303c != 1) {
                try {
                    SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
                    try {
                        C2050h hVar = this.f19301a;
                        if (hVar != null) {
                            kotlin.jvm.internal.m.b(hVar);
                            if (hVar.l0() != null) {
                                C2050h hVar2 = this.f19301a;
                                kotlin.jvm.internal.m.b(hVar2);
                                String l02 = hVar2.l0();
                                kotlin.jvm.internal.m.b(l02);
                                j4 = Long.parseLong(l02);
                                String string = requireActivity().getString(R.string.updates_button_download_app);
                                W1.i iVar = new W1.i();
                                Context requireContext = requireContext();
                                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                                sparseArrayObjectAdapter.set(1, new Action(1, string, iVar.d(j4, requireContext)));
                                sparseArrayObjectAdapter.set(3, new Action(3, requireActivity().getString(R.string.dialogo_app_old_versions)));
                                sparseArrayObjectAdapter.set(4, new Action(4, requireActivity().getString(R.string.virustotal_safety_report_title)));
                                sparseArrayObjectAdapter.set(5, new Action(5, requireActivity().getString(R.string.app_detail_more_info_title)));
                                DetailsOverviewRow detailsOverviewRow = this.f19308h;
                                kotlin.jvm.internal.m.b(detailsOverviewRow);
                                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                                this.f19303c = 1;
                            }
                        }
                    } catch (NumberFormatException e5) {
                        e5.printStackTrace();
                    }
                    j4 = 0;
                    String string2 = requireActivity().getString(R.string.updates_button_download_app);
                    W1.i iVar2 = new W1.i();
                    Context requireContext2 = requireContext();
                    kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                    sparseArrayObjectAdapter.set(1, new Action(1, string2, iVar2.d(j4, requireContext2)));
                    sparseArrayObjectAdapter.set(3, new Action(3, requireActivity().getString(R.string.dialogo_app_old_versions)));
                    sparseArrayObjectAdapter.set(4, new Action(4, requireActivity().getString(R.string.virustotal_safety_report_title)));
                    sparseArrayObjectAdapter.set(5, new Action(5, requireActivity().getString(R.string.app_detail_more_info_title)));
                    DetailsOverviewRow detailsOverviewRow2 = this.f19308h;
                    kotlin.jvm.internal.m.b(detailsOverviewRow2);
                    detailsOverviewRow2.setActionsAdapter(sparseArrayObjectAdapter);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                this.f19303c = 1;
            }
            C2203b bVar = this.f19311k;
            kotlin.jvm.internal.m.b(bVar);
            bVar.b(0);
        }
    }

    private final void y0(C2060s sVar) {
        if (getActivity() != null) {
            if (this.f19303c != 3) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
                sparseArrayObjectAdapter.set(1, new Action(1, requireActivity().getString(17039360)));
                if (this.f19301a != null) {
                    String packageName = requireActivity().getPackageName();
                    C2050h hVar = this.f19301a;
                    kotlin.jvm.internal.m.b(hVar);
                    if (!m3.m.p(packageName, hVar.Q(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f19308h;
                kotlin.jvm.internal.m.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f19303c = 3;
            }
            C2203b bVar = this.f19311k;
            kotlin.jvm.internal.m.b(bVar);
            bVar.b(sVar.x());
        }
    }

    private final void z0() {
        if (getActivity() != null && this.f19303c != 10) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2202a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.app_detail_not_available)));
            DetailsOverviewRow detailsOverviewRow = this.f19308h;
            kotlin.jvm.internal.m.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f19303c = 10;
        }
    }

    public final void N0(int i4, String str) {
        C2050h hVar = this.f19301a;
        if (hVar != null) {
            kotlin.jvm.internal.m.b(hVar);
            if (hVar.Q() != null) {
                C2050h hVar2 = this.f19301a;
                kotlin.jvm.internal.m.b(hVar2);
                if (!m3.m.p(hVar2.Q(), str, true)) {
                    return;
                }
                if (i4 == 301 || i4 == 351) {
                    B0();
                    return;
                }
                D0();
                this.f19303c = 0;
            }
        }
    }

    public final void O0(String str) {
        C2050h hVar = this.f19301a;
        if (hVar != null && str != null) {
            kotlin.jvm.internal.m.b(hVar);
            if (m3.m.p(str, hVar.Q(), true)) {
                L0();
            }
        }
    }

    public final void P0(int i4, C2060s sVar) {
        if (this.f19301a != null && sVar != null && sVar.w() != null) {
            String w4 = sVar.w();
            C2050h hVar = this.f19301a;
            kotlin.jvm.internal.m.b(hVar);
            if (!m3.m.p(w4, hVar.Q(), true)) {
                return;
            }
            if (i4 == 200) {
                y0(sVar);
            } else if (i4 != 201) {
                if (i4 == 202) {
                    P(sVar);
                }
                L0();
            } else {
                y0(sVar);
            }
        }
    }

    public final void c0() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, this.f19302b, new d(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final boolean f0() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        Parcelable parcelable;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            x xVar = new x(activity);
            String simpleName = TvAppDetailFragment.class.getSimpleName();
            kotlin.jvm.internal.m.d(simpleName, "getSimpleName(...)");
            xVar.e(simpleName);
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("appId")) {
                    this.f19302b = extras.getLong("appId");
                }
                if (extras.containsKey("appInfo")) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                    } else {
                        parcelable = extras.getParcelable("appInfo");
                    }
                    C2050h hVar = (C2050h) parcelable;
                    this.f19301a = hVar;
                    if (hVar != null) {
                        kotlin.jvm.internal.m.b(hVar);
                        this.f19302b = hVar.e();
                    }
                }
            }
            BackgroundManager instance = BackgroundManager.getInstance(activity);
            this.f19305e = instance;
            if (!(instance == null || instance.isAttached() || (backgroundManager = this.f19305e) == null)) {
                backgroundManager.attach(activity.getWindow());
            }
            Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.tv_default_background);
            BackgroundManager backgroundManager2 = this.f19305e;
            if (backgroundManager2 != null) {
                backgroundManager2.setDrawable(drawable);
            }
            I0(activity);
            K0();
            c0();
            V();
        }
    }

    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        boolean z4;
        kotlin.jvm.internal.m.e(strArr, "permissions");
        kotlin.jvm.internal.m.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i4, strArr, iArr);
        if (i4 == 831) {
            if (iArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4 && iArr[0] == 0) {
                e0();
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f19313m) {
            L0();
        } else {
            this.f19313m = false;
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f19312l) {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new g(this, (V2.d) null), 3, (Object) null);
        }
        this.f19312l = false;
    }

    public void onStop() {
        BackgroundManager backgroundManager = this.f19305e;
        kotlin.jvm.internal.m.b(backgroundManager);
        backgroundManager.release();
        super.onStop();
    }
}
