package com.uptodown.activities;

import J1.C1446t2;
import J1.j6;
import J1.k6;
import J1.l6;
import J1.m6;
import J1.n6;
import J1.o6;
import J1.p6;
import J1.q6;
import J1.r6;
import M1.Q;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import S2.C1601o;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import b2.x;
import c2.h1;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.X;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.C2027s;
import f2.O;
import f2.U;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.W;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.C2313C;
import u2.E;
import u2.t;

public final class WishlistActivity extends C1446t2 {

    /* renamed from: m0  reason: collision with root package name */
    public static final a f18660m0 = new a((C2103g) null);

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f18661V = R2.h.a(new k6(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f18662W = new ViewModelLazy(D.b(X.class), new h(this), new g(this), new i((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public Q f18663X;

    /* renamed from: Y  reason: collision with root package name */
    private d f18664Y = new d(this);

    /* renamed from: Z  reason: collision with root package name */
    private final ActivityResultLauncher f18665Z;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements O {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18667b;

        b(WishlistActivity wishlistActivity, int i4) {
            this.f18666a = wishlistActivity;
            this.f18667b = i4;
        }

        public void a() {
            WishlistActivity wishlistActivity = this.f18666a;
            String string = wishlistActivity.getString(R.string.error_generico);
            m.d(string, "getString(...)");
            wishlistActivity.q0(string);
        }

        public void f() {
            ArrayList b5;
            Q R4 = this.f18666a.f18663X;
            if (!(R4 == null || (b5 = R4.b()) == null)) {
                W w4 = (W) b5.remove(this.f18667b);
            }
            Q R42 = this.f18666a.f18663X;
            if (R42 != null) {
                R42.notifyItemRemoved(this.f18667b);
            }
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f18668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18669b;

        c(LinearLayoutManager linearLayoutManager, WishlistActivity wishlistActivity) {
            this.f18668a = linearLayoutManager;
            this.f18669b = wishlistActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0) {
                int findFirstVisibleItemPosition = this.f18668a.findFirstVisibleItemPosition();
                int childCount = this.f18668a.getChildCount();
                int itemCount = this.f18668a.getItemCount();
                if (!this.f18669b.b5().g() && !this.f18669b.b5().e() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    Q R4 = this.f18669b.f18663X;
                    m.b(R4);
                    R4.f(true);
                    this.f18669b.b5().d(this.f18669b);
                }
            }
        }
    }

    public static final class d implements U {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18670a;

        public static final class a implements C2027s {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WishlistActivity f18671a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f18672b;

            a(WishlistActivity wishlistActivity, int i4) {
                this.f18671a = wishlistActivity;
                this.f18672b = i4;
            }

            public void b(int i4) {
                WishlistActivity wishlistActivity = this.f18671a;
                String string = wishlistActivity.getString(R.string.error_cant_enqueue_download);
                m.d(string, "getString(...)");
                wishlistActivity.q0(string);
            }

            public void c(C2050h hVar) {
                m.e(hVar, "appInfo");
                String o4 = hVar.o();
                if (o4 == null || o4.length() == 0) {
                    WishlistActivity wishlistActivity = this.f18671a;
                    String string = wishlistActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{hVar.L()});
                    m.d(string, "getString(...)");
                    wishlistActivity.U1(string);
                } else if (new u2.m().s(hVar.Q(), this.f18671a)) {
                    this.f18671a.v4(new u2.m().A(this.f18671a, hVar.Q()));
                } else {
                    this.f18671a.o5(hVar, this.f18672b);
                }
            }
        }

        d(WishlistActivity wishlistActivity) {
            this.f18670a = wishlistActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0() && this.f18670a.f18663X != null) {
                Q R4 = this.f18670a.f18663X;
                m.b(R4);
                if (!R4.b().isEmpty()) {
                    Q R42 = this.f18670a.f18663X;
                    m.b(R42);
                    Object obj = R42.b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18670a.C2(((W) obj).a());
                }
            }
        }

        public void b(View view, int i4) {
            m.e(view, "v");
            if (UptodownApp.f17422D.a0() && this.f18670a.f18663X != null) {
                Q R4 = this.f18670a.f18663X;
                m.b(R4);
                if (!R4.b().isEmpty()) {
                    WishlistActivity wishlistActivity = this.f18670a;
                    Q R42 = wishlistActivity.f18663X;
                    m.b(R42);
                    Object obj = R42.b().get(i4);
                    m.d(obj, "get(...)");
                    wishlistActivity.Y4((W) obj, i4);
                }
            }
        }

        public void c(int i4) {
            if (this.f18670a.f18663X != null) {
                Q R4 = this.f18670a.f18663X;
                m.b(R4);
                if (!R4.b().isEmpty()) {
                    WishlistActivity wishlistActivity = this.f18670a;
                    Q R42 = wishlistActivity.f18663X;
                    m.b(R42);
                    new C1640l(wishlistActivity, ((W) R42.b().get(i4)).a(), new a(this.f18670a, i4), LifecycleOwnerKt.getLifecycleScope(this.f18670a));
                }
            }
        }

        public void d(int i4) {
            if (this.f18670a.f18663X != null) {
                Q R4 = this.f18670a.f18663X;
                m.b(R4);
                if (!R4.b().isEmpty()) {
                    Q R42 = this.f18670a.f18663X;
                    m.b(R42);
                    Object obj = R42.b().get(i4);
                    m.d(obj, "get(...)");
                    W w4 = (W) obj;
                    String f4 = w4.f();
                    if (f4 == null || f4.length() == 0) {
                        WishlistActivity wishlistActivity = this.f18670a;
                        String string = wishlistActivity.getString(R.string.error_open_app, new Object[]{w4.e()});
                        m.d(string, "getString(...)");
                        wishlistActivity.U1(string);
                        return;
                    }
                    PackageManager packageManager = this.f18670a.getPackageManager();
                    String f5 = w4.f();
                    m.b(f5);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(f5);
                    if (launchIntentForPackage != null) {
                        this.f18670a.startActivity(launchIntentForPackage);
                        return;
                    }
                    WishlistActivity wishlistActivity2 = this.f18670a;
                    String string2 = wishlistActivity2.getString(R.string.error_open_app, new Object[]{w4.e()});
                    m.d(string2, "getString(...)");
                    wishlistActivity2.U1(string2);
                }
            }
        }

        public void e(long j4, C2053k kVar) {
            m.e(kVar, "category");
            if (UptodownApp.f17422D.a0()) {
                this.f18670a.p5(j4, kVar);
            }
        }

        public void f(int i4) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18674b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WishlistActivity f18675a;

            a(WishlistActivity wishlistActivity) {
                this.f18675a = wishlistActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    if (this.f18675a.f18663X == null) {
                        this.f18675a.a5().f10463b.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    this.f18675a.X4(((X.a) cVar.a()).a());
                    if (((X.a) cVar.a()).a().size() == 0) {
                        this.f18675a.a5().f10467f.setVisibility(0);
                        this.f18675a.a5().f10466e.setVisibility(0);
                    }
                    this.f18675a.a5().f10463b.setVisibility(8);
                } else if (e5 instanceof E.b) {
                    Q R4 = this.f18675a.f18663X;
                    if (R4 != null) {
                        R4.f(false);
                    }
                } else {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WishlistActivity wishlistActivity, V2.d dVar) {
            super(2, dVar);
            this.f18674b = wishlistActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18674b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18673a;
            if (i4 == 0) {
                n.b(obj);
                I f4 = this.f18674b.b5().f();
                a aVar = new a(this.f18674b);
                this.f18673a = 1;
                if (f4.collect(aVar, this) == c5) {
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18676a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2053k f18677b;

        f(WishlistActivity wishlistActivity, C2053k kVar) {
            this.f18676a = wishlistActivity;
            this.f18677b = kVar;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (!this.f18676a.isFinishing()) {
                Intent intent = new Intent(this.f18676a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                intent.putExtra("viewCategory", this.f18677b);
                WishlistActivity wishlistActivity = this.f18676a;
                wishlistActivity.startActivity(intent, UptodownApp.f17422D.a(wishlistActivity));
            }
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18678a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f18678a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18678a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18679a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f18679a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18679a.getViewModelStore();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18681b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18680a = aVar;
            this.f18681b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18680a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18681b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.WishlistActivity.i.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f18683b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18684c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(WishlistActivity wishlistActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18683b = wishlistActivity;
            this.f18684c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f18683b, this.f18684c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            W2.b.c();
            if (this.f18682a == 0) {
                n.b(obj);
                if (this.f18683b.f18663X != null) {
                    Q R4 = this.f18683b.f18663X;
                    m.b(R4);
                    if (!(R4.b().isEmpty() || (str = this.f18684c) == null || str.length() == 0)) {
                        Q R42 = this.f18683b.f18663X;
                        m.b(R42);
                        ArrayList b5 = R42.b();
                        String str2 = this.f18684c;
                        int size = b5.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                obj2 = null;
                                break;
                            }
                            obj2 = b5.get(i4);
                            i4++;
                            if (m.a(((W) obj2).f(), str2)) {
                                break;
                            }
                        }
                        Q R43 = this.f18683b.f18663X;
                        m.b(R43);
                        int K4 = C1601o.K(R43.b(), (W) obj2);
                        if (K4 > -1) {
                            Q R44 = this.f18683b.f18663X;
                            m.b(R44);
                            R44.notifyItemChanged(K4);
                        } else {
                            this.f18683b.n5();
                        }
                        return s.f8222a;
                    }
                }
                this.f18683b.n5();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public WishlistActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l6());
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18665Z = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final h1 W4(WishlistActivity wishlistActivity) {
        return h1.c(wishlistActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void X4(ArrayList arrayList) {
        Q q4 = this.f18663X;
        if (q4 == null) {
            this.f18663X = new Q(arrayList, this, this.f18664Y);
            a5().f10464c.setAdapter(this.f18663X);
            return;
        }
        m.b(q4);
        q4.a(arrayList);
        Q q5 = this.f18663X;
        if (q5 != null) {
            q5.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final void Y4(W w4, int i4) {
        F f4 = F.f20971a;
        String string = getString(R.string.dialog_wishlist_msg);
        m.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{w4.e()}, 1));
        m.d(format, "format(...)");
        O1(format, new r6(this, w4, i4));
    }

    /* access modifiers changed from: private */
    public static final s Z4(WishlistActivity wishlistActivity, W w4, int i4) {
        b bVar = new b(wishlistActivity, i4);
        if (UptodownApp.f17422D.a0()) {
            new x(wishlistActivity, LifecycleOwnerKt.getLifecycleScope(wishlistActivity)).g(w4.a(), bVar);
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final h1 a5() {
        return (h1) this.f18661V.getValue();
    }

    /* access modifiers changed from: private */
    public final X b5() {
        return (X) this.f18662W.getValue();
    }

    private final void c5() {
        setContentView((View) a5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        h1 a5 = a5();
        if (drawable != null) {
            a5.f10465d.setNavigationIcon(drawable);
            a5.f10465d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        a5.f10465d.setNavigationOnClickListener(new m6(this));
        TextView textView = a5.f10468g;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        a5.f10464c.setLayoutManager(linearLayoutManager);
        a5.f10464c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        a5().f10464c.addItemDecoration(new w2.l(dimension, dimension));
        a5.f10464c.setItemAnimator(defaultItemAnimator);
        a5.f10467f.setTypeface(aVar.x());
        a5.f10466e.setTypeface(aVar.w());
        a5.f10466e.setOnClickListener(new n6(this));
        a5.f10463b.setOnClickListener(new o6());
        a5.f10464c.addOnScrollListener(new c(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void d5(WishlistActivity wishlistActivity, View view) {
        wishlistActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void e5(WishlistActivity wishlistActivity, View view) {
        wishlistActivity.setResult(1);
        wishlistActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void f5(View view) {
    }

    private final void i5() {
        g2.U e5 = g2.U.f20468m.e(this);
        if (e5 == null || !e5.m(this)) {
            new Handler(Looper.getMainLooper()).postDelayed(new j6(this), 500);
        } else {
            b5().d(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void j5(WishlistActivity wishlistActivity) {
        String string = wishlistActivity.getString(R.string.wishlist_login_msg);
        m.d(string, "getString(...)");
        wishlistActivity.P1(string, new p6(wishlistActivity), new q6(wishlistActivity));
    }

    /* access modifiers changed from: private */
    public static final s k5(WishlistActivity wishlistActivity) {
        wishlistActivity.q5();
        AlertDialog j22 = wishlistActivity.j2();
        if (j22 != null) {
            j22.dismiss();
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s l5(WishlistActivity wishlistActivity) {
        wishlistActivity.finish();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void m5(ActivityResult activityResult) {
        activityResult.getResultCode();
    }

    /* access modifiers changed from: private */
    public final void n5() {
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void o5(C2050h hVar, int i4) {
        Parcelable parcelable;
        t.a aVar = t.f21927u;
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        t a5 = aVar.a(applicationContext);
        a5.a();
        C2060s f02 = a5.f0(String.valueOf(hVar.z()));
        a5.i();
        if (f02 != null) {
            int x4 = f02.x();
            if (1 <= x4 && x4 < 100) {
                DownloadWorker.a aVar2 = DownloadWorker.f19459d;
                aVar2.d(hVar.e());
                C2313C.f21882a.h(this);
                a5.a();
                a5.z(f02);
                f02.g();
                a5.i();
                aVar2.o();
                Intent intent = getIntent();
                m.d(intent, "getIntent(...)");
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) intent.getParcelableExtra("downloadResultReceiver", ResultReceiver.class);
                } else {
                    parcelable = intent.getParcelableExtra("downloadResultReceiver");
                }
                ResultReceiver resultReceiver = (ResultReceiver) parcelable;
                if (resultReceiver != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("download", f02);
                    s sVar = s.f8222a;
                    resultReceiver.send(207, bundle);
                }
            } else if (!f02.f() || f02.n() == null) {
                f02.R(this);
                Q q4 = this.f18663X;
                if (q4 != null) {
                    q4.notifyItemChanged(i4);
                }
            } else {
                UptodownApp.a aVar3 = UptodownApp.f17422D;
                File n4 = f02.n();
                m.b(n4);
                aVar3.X(n4, this, hVar.M());
            }
        } else {
            UptodownApp.f17422D.c0(hVar, this);
            Q q5 = this.f18663X;
            if (q5 != null) {
                m.b(q5);
                ((W) q5.b().get(i4)).m(hVar.z());
                Q q6 = this.f18663X;
                if (q6 != null) {
                    q6.notifyItemChanged(i4);
                }
            }
        }
    }

    private final void q5() {
        this.f18665Z.launch(new Intent(this, LoginActivity.class), UptodownApp.f17422D.b(this));
    }

    /* access modifiers changed from: protected */
    public void A4() {
    }

    public void H2() {
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.d();
        }
    }

    public void P2(File file) {
        m.e(file, "file");
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.e(file, this);
        }
    }

    public void R2(File file) {
        m.e(file, "file");
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.d();
        }
        Q q5 = this.f18663X;
        if (q5 != null) {
            q5.c(file, this);
        }
    }

    public void S2(File file, int i4) {
        m.e(file, "file");
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.c(file, this);
        }
    }

    public final void g5() {
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.d();
        }
    }

    public final void h5(String str) {
        Q q4 = this.f18663X;
        if (q4 != null) {
            q4.d();
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
        c5();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        i5();
    }

    public final void p5(long j4, C2053k kVar) {
        m.e(kVar, "floatingCategory");
        if (j4 > 0) {
            new C1640l(this, j4, new f(this, kVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        E2();
        s sVar = s.f8222a;
    }

    public final void r5(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new j(this, str, (V2.d) null), 2, (Object) null);
    }
}
