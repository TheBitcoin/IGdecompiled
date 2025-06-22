package com.uptodown.activities;

import J1.C1318b;
import J1.C1325c;
import R2.n;
import R2.s;
import S2.C1601o;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.GetUserDataWorker;
import d2.C1910h;
import d2.C1941r1;
import d2.Q1;
import d3.p;
import f2.M;
import g2.C2047e;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.S;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import m3.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import u2.t;

public final class AppDetailActivity extends C1826a {

    /* renamed from: P  reason: collision with root package name */
    public static final a f17480P = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private C2053k f17481J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public ArrayList f17482K = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public ArrayList f17483L = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public ArrayList f17484M = new ArrayList();

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f17485N;

    /* renamed from: O  reason: collision with root package name */
    private final e f17486O;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f17487a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17488b;

        public b(int i4, String str) {
            this.f17487a = i4;
            this.f17488b = str;
        }

        public void run() {
            C1941r1 f32;
            if (this.f17488b != null && (f32 = AppDetailActivity.this.k3()) != null && f32.isResumed() && m.q(f32.Y3().Q(), this.f17488b, false, 2, (Object) null)) {
                t.a aVar = t.f21927u;
                Context baseContext = AppDetailActivity.this.getBaseContext();
                kotlin.jvm.internal.m.d(baseContext, "getBaseContext(...)");
                t a5 = aVar.a(baseContext);
                a5.a();
                S D02 = a5.D0(this.f17488b);
                a5.i();
                if (D02 != null) {
                    AppDetailActivity.this.runOnUiThread(new C1941r1.C1943b(this.f17487a, D02));
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f17490a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17491b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f17492c;

        public c(AppDetailActivity appDetailActivity, String str, int i4) {
            kotlin.jvm.internal.m.e(str, "packagename");
            this.f17492c = appDetailActivity;
            this.f17490a = str;
            this.f17491b = i4;
        }

        public void run() {
            List<Fragment> fragments = this.f17492c.getSupportFragmentManager().getFragments();
            kotlin.jvm.internal.m.d(fragments, "getFragments(...)");
            Fragment fragment = (Fragment) C1601o.P(fragments);
            if (fragment != null && (fragment instanceof C1941r1)) {
                new C1941r1.C1944c((C1941r1) fragment, this.f17490a, this.f17491b);
            }
        }
    }

    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f17493a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f17494b;

        public d(int i4, C2060s sVar) {
            this.f17493a = i4;
            this.f17494b = sVar;
        }

        public void run() {
            y2.g k22;
            String str;
            C1941r1 f32 = AppDetailActivity.this.k3();
            if (f32 != null && f32.isResumed()) {
                AppDetailActivity.this.runOnUiThread(new C1941r1.C1945d(this.f17493a, this.f17494b));
            }
            String str2 = null;
            if (AppDetailActivity.this.l3() != null) {
                Q1 g32 = AppDetailActivity.this.l3();
                kotlin.jvm.internal.m.b(g32);
                C2060s sVar = this.f17494b;
                if (sVar != null) {
                    str = sVar.w();
                } else {
                    str = null;
                }
                g32.Z(str);
            }
            if (AppDetailActivity.this.j3() != null) {
                C1910h e32 = AppDetailActivity.this.j3();
                kotlin.jvm.internal.m.b(e32);
                C2060s sVar2 = this.f17494b;
                if (sVar2 != null) {
                    str2 = sVar2.w();
                }
                e32.u(str2);
            }
            if (this.f17494b != null && (k22 = AppDetailActivity.this.k2()) != null) {
                k22.N(this.f17494b, this.f17493a, AppDetailActivity.this);
            }
        }
    }

    public static final class e extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f17496a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppDetailActivity appDetailActivity) {
            super(true);
            this.f17496a = appDetailActivity;
        }

        public void handleOnBackPressed() {
            y2.g k22 = this.f17496a.k2();
            if (k22 == null || !k22.l(this.f17496a)) {
                if (this.f17496a.f17483L.size() > 0) {
                    this.f17496a.f17483L.remove(C1601o.j(this.f17496a.f17483L));
                    if (this.f17496a.f17483L.size() == 0 && this.f17496a.m3() != null && this.f17496a.f17482K.size() == 1) {
                        this.f17496a.finish();
                    } else {
                        this.f17496a.getSupportFragmentManager().popBackStackImmediate();
                    }
                } else if (this.f17496a.f17484M.size() > 0) {
                    this.f17496a.f17484M.remove(C1601o.j(this.f17496a.f17484M));
                    this.f17496a.getSupportFragmentManager().popBackStackImmediate();
                } else if (this.f17496a.f17482K.size() > 0) {
                    this.f17496a.f17482K.remove(C1601o.j(this.f17496a.f17482K));
                    this.f17496a.getSupportFragmentManager().popBackStackImmediate();
                    if (this.f17496a.f17482K.size() == 0) {
                        this.f17496a.finish();
                    }
                } else {
                    this.f17496a.finish();
                }
                if (this.f17496a.f17482K.size() > 0) {
                    ((C1941r1) C1601o.P(this.f17496a.f17482K)).X2(this.f17496a);
                }
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f17498b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppDetailActivity appDetailActivity, V2.d dVar) {
            super(2, dVar);
            this.f17498b = appDetailActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17498b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17497a;
            if (i4 == 0) {
                n.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f19472b;
                AppDetailActivity appDetailActivity = this.f17498b;
                this.f17497a = 1;
                if (GetUserDataWorker.a.b(aVar, appDetailActivity, (M) null, this, 2, (Object) null) == c5) {
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

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f17500b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17501c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppDetailActivity appDetailActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f17500b = appDetailActivity;
            this.f17501c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f17500b, this.f17501c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17499a == 0) {
                n.b(obj);
                C1941r1 f32 = this.f17500b.k3();
                if (f32 != null && f32.isResumed()) {
                    f32.q7(this.f17501c);
                    f32.o7(this.f17501c);
                }
                if (!this.f17500b.f17483L.isEmpty()) {
                    ((Q1) C1601o.P(this.f17500b.f17483L)).Z(this.f17501c);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17502a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppDetailActivity f17503b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17504c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppDetailActivity appDetailActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f17503b = appDetailActivity;
            this.f17504c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f17503b, this.f17504c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17502a == 0) {
                n.b(obj);
                C1941r1 f32 = this.f17503b.k3();
                if (f32 != null && f32.isResumed()) {
                    f32.r7(this.f17504c);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public AppDetailActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1325c(this));
        kotlin.jvm.internal.m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f17485N = registerForActivityResult;
        this.f17486O = new e(this);
    }

    /* access modifiers changed from: private */
    public static final void i3(AppDetailActivity appDetailActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            UptodownApp.a.P0(UptodownApp.f17422D, appDetailActivity, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final C1910h j3() {
        if (this.f17484M.size() > 0) {
            return (C1910h) C1601o.P(this.f17484M);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final C1941r1 k3() {
        if (this.f17482K.size() > 0) {
            return (C1941r1) C1601o.P(this.f17482K);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final Q1 l3() {
        if (this.f17483L.size() > 0) {
            return (Q1) C1601o.P(this.f17483L);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void o3(AppDetailActivity appDetailActivity, ActivityResult activityResult) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(appDetailActivity), Y.b(), (L) null, new f(appDetailActivity, (V2.d) null), 2, (Object) null);
    }

    public void Z2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        C1941r1 a5 = C1941r1.f19976n.a(hVar);
        getSupportFragmentManager().beginTransaction().add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(String.valueOf(hVar.e())).commit();
        this.f17482K.add(a5);
    }

    public final C2053k m3() {
        return this.f17481J;
    }

    public final ActivityResultLauncher n3() {
        return this.f17485N;
    }

    public void onCreate(Bundle bundle) {
        C2050h hVar;
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((int) R.layout.app_detail_activity);
        Intent intent = getIntent();
        L2((RelativeLayout) findViewById(R.id.app_info_selected_popup));
        if (intent == null || (extras = intent.getExtras()) == null) {
            hVar = null;
        } else {
            if (extras.containsKey("appInfo")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable2 = extras.getParcelable("appInfo");
                }
                hVar = (C2050h) parcelable2;
            } else {
                hVar = null;
            }
            if (extras.containsKey("viewCategory")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("viewCategory", C2053k.class);
                } else {
                    parcelable = extras.getParcelable("viewCategory");
                }
                this.f17481J = (C2053k) parcelable;
            }
        }
        C1941r1 a5 = C1941r1.f19976n.a(hVar);
        getSupportFragmentManager().beginTransaction().add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).commit();
        getOnBackPressedDispatcher().addCallback(this, this.f17486O);
        U2(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1318b(this)));
        this.f17482K.add(a5);
        C2053k kVar = this.f17481J;
        if (kVar != null) {
            kotlin.jvm.internal.m.b(kVar);
            t3(kVar);
        }
    }

    public final void p3() {
        C1941r1 k32 = k3();
        if (k32 != null) {
            k32.g6();
        }
    }

    public final Object q3(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new g(this, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object r3(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new h(this, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final void s3(C2047e eVar) {
        kotlin.jvm.internal.m.e(eVar, "alternatives");
        C1910h a5 = C1910h.f19903f.a(eVar);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(eVar.c()).commit();
        this.f17484M.add(a5);
    }

    public final void t3(C2053k kVar) {
        kotlin.jvm.internal.m.e(kVar, "category");
        Q1 a5 = Q1.f19769i.a(kVar);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add((int) R.id.fl_main_app_detail_activity, (Fragment) a5, (String) null).addToBackStack(String.valueOf(kVar.b())).commit();
        this.f17483L.add(a5);
    }
}
