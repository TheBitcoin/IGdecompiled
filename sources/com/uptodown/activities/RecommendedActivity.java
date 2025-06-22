package com.uptodown.activities;

import J1.C1316a4;
import J1.C1323b4;
import J1.C1446t2;
import J1.R3;
import J1.S3;
import J1.T3;
import J1.U3;
import J1.V3;
import J1.W3;
import J1.X3;
import J1.Y3;
import J1.Z3;
import M1.Q;
import N1.k;
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
import c2.C1689s0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
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
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
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

public final class RecommendedActivity extends C1446t2 {

    /* renamed from: m0  reason: collision with root package name */
    public static final a f18254m0 = new a((C2103g) null);

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f18255V = R2.h.a(new S3(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f18256W = new ViewModelLazy(D.b(C1323b4.class), new i(this), new h(this), new j((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public Q f18257X;

    /* renamed from: Y  reason: collision with root package name */
    private d f18258Y = new d(this);

    /* renamed from: Z  reason: collision with root package name */
    private final ActivityResultLauncher f18259Z;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements O {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18261b;

        b(RecommendedActivity recommendedActivity, int i4) {
            this.f18260a = recommendedActivity;
            this.f18261b = i4;
        }

        public void a() {
            RecommendedActivity recommendedActivity = this.f18260a;
            String string = recommendedActivity.getString(R.string.error_generico);
            m.d(string, "getString(...)");
            recommendedActivity.q0(string);
        }

        public void f() {
            ArrayList b5;
            Q S4 = this.f18260a.f18257X;
            if (!(S4 == null || (b5 = S4.b()) == null)) {
                W w4 = (W) b5.remove(this.f18261b);
            }
            Q S42 = this.f18260a.f18257X;
            if (S42 != null) {
                S42.notifyItemRemoved(this.f18261b);
            }
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f18262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18263b;

        c(LinearLayoutManager linearLayoutManager, RecommendedActivity recommendedActivity) {
            this.f18262a = linearLayoutManager;
            this.f18263b = recommendedActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0) {
                int findFirstVisibleItemPosition = this.f18262a.findFirstVisibleItemPosition();
                int childCount = this.f18262a.getChildCount();
                int itemCount = this.f18262a.getItemCount();
                if (!this.f18263b.c5().h() && !this.f18263b.c5().g() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    Q S4 = this.f18263b.f18257X;
                    m.b(S4);
                    S4.f(true);
                    this.f18263b.c5().f(this.f18263b);
                }
            }
        }
    }

    public static final class d implements U {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18264a;

        public static final class a implements C2027s {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f18265a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f18266b;

            a(RecommendedActivity recommendedActivity, int i4) {
                this.f18265a = recommendedActivity;
                this.f18266b = i4;
            }

            public void b(int i4) {
                RecommendedActivity recommendedActivity = this.f18265a;
                String string = recommendedActivity.getString(R.string.error_cant_enqueue_download);
                m.d(string, "getString(...)");
                recommendedActivity.q0(string);
            }

            public void c(C2050h hVar) {
                m.e(hVar, "appInfo");
                String o4 = hVar.o();
                if (o4 == null || o4.length() == 0) {
                    RecommendedActivity recommendedActivity = this.f18265a;
                    String string = recommendedActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{hVar.L()});
                    m.d(string, "getString(...)");
                    recommendedActivity.U1(string);
                } else if (new u2.m().s(hVar.Q(), this.f18265a)) {
                    this.f18265a.v4(new u2.m().A(this.f18265a, hVar.Q()));
                } else {
                    this.f18265a.q5(hVar, this.f18266b);
                }
            }
        }

        d(RecommendedActivity recommendedActivity) {
            this.f18264a = recommendedActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0() && this.f18264a.f18257X != null) {
                Q S4 = this.f18264a.f18257X;
                m.b(S4);
                if (!S4.b().isEmpty()) {
                    Q S42 = this.f18264a.f18257X;
                    m.b(S42);
                    Object obj = S42.b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18264a.C2(((W) obj).a());
                }
            }
        }

        public void b(View view, int i4) {
            m.e(view, "v");
            if (UptodownApp.f17422D.a0() && this.f18264a.f18257X != null) {
                Q S4 = this.f18264a.f18257X;
                m.b(S4);
                if (!S4.b().isEmpty()) {
                    RecommendedActivity recommendedActivity = this.f18264a;
                    Q S42 = recommendedActivity.f18257X;
                    m.b(S42);
                    Object obj = S42.b().get(i4);
                    m.d(obj, "get(...)");
                    recommendedActivity.Z4((W) obj, i4);
                }
            }
        }

        public void c(int i4) {
            if (this.f18264a.f18257X != null) {
                Q S4 = this.f18264a.f18257X;
                m.b(S4);
                if (!S4.b().isEmpty()) {
                    RecommendedActivity recommendedActivity = this.f18264a;
                    Q S42 = recommendedActivity.f18257X;
                    m.b(S42);
                    new C1640l(recommendedActivity, ((W) S42.b().get(i4)).a(), new a(this.f18264a, i4), LifecycleOwnerKt.getLifecycleScope(this.f18264a));
                }
            }
        }

        public void d(int i4) {
            if (this.f18264a.f18257X != null) {
                Q S4 = this.f18264a.f18257X;
                m.b(S4);
                if (!S4.b().isEmpty()) {
                    Q S42 = this.f18264a.f18257X;
                    m.b(S42);
                    Object obj = S42.b().get(i4);
                    m.d(obj, "get(...)");
                    W w4 = (W) obj;
                    String f4 = w4.f();
                    if (f4 == null || f4.length() == 0) {
                        RecommendedActivity recommendedActivity = this.f18264a;
                        String string = recommendedActivity.getString(R.string.error_open_app, new Object[]{w4.e()});
                        m.d(string, "getString(...)");
                        recommendedActivity.U1(string);
                        return;
                    }
                    PackageManager packageManager = this.f18264a.getPackageManager();
                    String f5 = w4.f();
                    m.b(f5);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(f5);
                    if (launchIntentForPackage != null) {
                        this.f18264a.startActivity(launchIntentForPackage);
                        return;
                    }
                    RecommendedActivity recommendedActivity2 = this.f18264a;
                    String string2 = recommendedActivity2.getString(R.string.error_open_app, new Object[]{w4.e()});
                    m.d(string2, "getString(...)");
                    recommendedActivity2.U1(string2);
                }
            }
        }

        public void e(long j4, C2053k kVar) {
            m.e(kVar, "category");
            if (UptodownApp.f17422D.a0()) {
                this.f18264a.r5(j4, kVar);
            }
        }

        public void f(int i4) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18268b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f18269a;

            a(RecommendedActivity recommendedActivity) {
                this.f18269a = recommendedActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    if (this.f18269a.f18257X == null) {
                        this.f18269a.b5().f10754b.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((ArrayList) cVar.a()).size() == 0) {
                        this.f18269a.b5().f10760h.setVisibility(0);
                        this.f18269a.b5().f10758f.setVisibility(0);
                    } else {
                        this.f18269a.b5().f10756d.setVisibility(0);
                        this.f18269a.b5().f10759g.setVisibility(0);
                        this.f18269a.Y4((ArrayList) cVar.a());
                    }
                    this.f18269a.b5().f10754b.setVisibility(8);
                } else if (e5 instanceof E.b) {
                    Q S4 = this.f18269a.f18257X;
                    if (S4 != null) {
                        S4.f(false);
                    }
                } else {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(RecommendedActivity recommendedActivity, V2.d dVar) {
            super(2, dVar);
            this.f18268b = recommendedActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18268b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18267a;
            if (i4 == 0) {
                n.b(obj);
                I i5 = this.f18268b.c5().i();
                a aVar = new a(this.f18268b);
                this.f18267a = 1;
                if (i5.collect(aVar, this) == c5) {
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

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18270a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18271b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f18272a;

            a(RecommendedActivity recommendedActivity) {
                this.f18272a = recommendedActivity;
            }

            public final Object b(boolean z4, V2.d dVar) {
                this.f18272a.b5().f10756d.setChecked(!z4);
                if (z4) {
                    this.f18272a.b5().f10759g.setText(this.f18272a.getString(R.string.private_list));
                } else {
                    this.f18272a.b5().f10759g.setText(this.f18272a.getString(R.string.public_list));
                }
                return s.f8222a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, V2.d dVar) {
                return b(((Boolean) obj).booleanValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(RecommendedActivity recommendedActivity, V2.d dVar) {
            super(2, dVar);
            this.f18271b = recommendedActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18271b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18270a;
            if (i4 == 0) {
                n.b(obj);
                I j4 = this.f18271b.c5().j();
                a aVar = new a(this.f18271b);
                this.f18270a = 1;
                if (j4.collect(aVar, this) == c5) {
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

    public static final class g implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18273a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2053k f18274b;

        g(RecommendedActivity recommendedActivity, C2053k kVar) {
            this.f18273a = recommendedActivity;
            this.f18274b = kVar;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (!this.f18273a.isFinishing()) {
                Intent intent = new Intent(this.f18273a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                intent.putExtra("viewCategory", this.f18274b);
                RecommendedActivity recommendedActivity = this.f18273a;
                recommendedActivity.startActivity(intent, UptodownApp.f17422D.a(recommendedActivity));
            }
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18275a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f18275a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18275a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18276a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f18276a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18276a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18278b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18277a = aVar;
            this.f18278b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18277a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18278b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RecommendedActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18279a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f18280b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18281c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(RecommendedActivity recommendedActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18280b = recommendedActivity;
            this.f18281c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f18280b, this.f18281c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            W2.b.c();
            if (this.f18279a == 0) {
                n.b(obj);
                if (this.f18280b.f18257X != null) {
                    Q S4 = this.f18280b.f18257X;
                    m.b(S4);
                    if (!(S4.b().isEmpty() || (str = this.f18281c) == null || str.length() == 0)) {
                        Q S42 = this.f18280b.f18257X;
                        m.b(S42);
                        ArrayList b5 = S42.b();
                        String str2 = this.f18281c;
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
                        Q S43 = this.f18280b.f18257X;
                        m.b(S43);
                        int K4 = C1601o.K(S43.b(), (W) obj2);
                        if (K4 > -1) {
                            Q S44 = this.f18280b.f18257X;
                            m.b(S44);
                            S44.notifyItemChanged(K4);
                        } else {
                            this.f18280b.p5();
                        }
                        return s.f8222a;
                    }
                }
                this.f18280b.p5();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public RecommendedActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new T3());
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18259Z = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final C1689s0 X4(RecommendedActivity recommendedActivity) {
        return C1689s0.c(recommendedActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void Y4(ArrayList arrayList) {
        Q q4 = this.f18257X;
        if (q4 == null) {
            this.f18257X = new Q(arrayList, this, this.f18258Y);
            b5().f10755c.setAdapter(this.f18257X);
            return;
        }
        m.b(q4);
        q4.a(arrayList);
        Q q5 = this.f18257X;
        if (q5 != null) {
            q5.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final void Z4(W w4, int i4) {
        String string = getString(R.string.dialog_recommended_remove_msg, new Object[]{w4.e()});
        m.d(string, "getString(...)");
        O1(string, new Y3(this, w4, i4));
    }

    /* access modifiers changed from: private */
    public static final s a5(RecommendedActivity recommendedActivity, W w4, int i4) {
        b bVar = new b(recommendedActivity, i4);
        if (UptodownApp.f17422D.a0()) {
            new b2.s(recommendedActivity, LifecycleOwnerKt.getLifecycleScope(recommendedActivity)).c(w4.a(), bVar);
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final C1689s0 b5() {
        return (C1689s0) this.f18255V.getValue();
    }

    /* access modifiers changed from: private */
    public final C1323b4 c5() {
        return (C1323b4) this.f18256W.getValue();
    }

    private final void d5() {
        setContentView((View) b5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        C1689s0 b5 = b5();
        if (drawable != null) {
            b5.f10757e.setNavigationIcon(drawable);
            b5.f10757e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        b5.f10757e.setNavigationOnClickListener(new U3(this));
        TextView textView = b5.f10761i;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        b5.f10755c.setLayoutManager(linearLayoutManager);
        b5.f10755c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        b5.f10755c.addItemDecoration(new w2.l(dimension, dimension));
        b5.f10755c.setItemAnimator(defaultItemAnimator);
        b5.f10759g.setTypeface(aVar.x());
        b5.f10760h.setTypeface(aVar.x());
        b5.f10758f.setTypeface(aVar.x());
        b5.f10758f.setOnClickListener(new V3(this));
        b5().f10756d.setOnClickListener(new W3(this));
        b5.f10754b.setOnClickListener(new X3());
        b5.f10755c.addOnScrollListener(new c(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void e5(RecommendedActivity recommendedActivity, View view) {
        recommendedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void f5(RecommendedActivity recommendedActivity, View view) {
        recommendedActivity.setResult(1);
        recommendedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void g5(RecommendedActivity recommendedActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            recommendedActivity.c5().e(recommendedActivity);
        }
    }

    /* access modifiers changed from: private */
    public static final void h5(View view) {
    }

    private final void k5() {
        String g4;
        g2.U e5 = g2.U.f20468m.e(this);
        if (e5 == null || (g4 = e5.g()) == null || g4.length() == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new R3(this), 500);
        } else {
            c5().f(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void l5(RecommendedActivity recommendedActivity) {
        String string = recommendedActivity.getString(R.string.recommended_login_msg);
        m.d(string, "getString(...)");
        recommendedActivity.P1(string, new Z3(recommendedActivity), new C1316a4(recommendedActivity));
    }

    /* access modifiers changed from: private */
    public static final s m5(RecommendedActivity recommendedActivity) {
        recommendedActivity.s5();
        AlertDialog j22 = recommendedActivity.j2();
        if (j22 != null) {
            j22.dismiss();
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s n5(RecommendedActivity recommendedActivity) {
        recommendedActivity.finish();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void o5(ActivityResult activityResult) {
        activityResult.getResultCode();
    }

    /* access modifiers changed from: private */
    public final void p5() {
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void q5(C2050h hVar, int i4) {
        Parcelable parcelable;
        t.a aVar = t.f21927u;
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        t a5 = aVar.a(applicationContext);
        a5.a();
        C2060s f02 = a5.f0(String.valueOf(hVar.z()));
        a5.i();
        if (f02 != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f19459d;
            if (aVar2.l(f02)) {
                aVar2.d(hVar.e());
                UptodownApp.a aVar3 = UptodownApp.f17422D;
                String Q4 = hVar.Q();
                m.b(Q4);
                aVar3.f0(Q4);
                C2313C.f21882a.h(this);
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
            } else if (f02.f() && f02.n() != null) {
                UptodownApp.a aVar4 = UptodownApp.f17422D;
                File n4 = f02.n();
                m.b(n4);
                aVar4.X(n4, this, hVar.M());
            } else if (f02.K()) {
                f02.R(this);
                Q q4 = this.f18257X;
                if (q4 != null) {
                    q4.notifyItemChanged(i4);
                }
            }
        } else {
            UptodownApp.f17422D.c0(hVar, this);
            Q q5 = this.f18257X;
            if (q5 != null) {
                m.b(q5);
                ((W) q5.b().get(i4)).m(hVar.z());
                Q q6 = this.f18257X;
                if (q6 != null) {
                    q6.notifyItemChanged(i4);
                }
            }
        }
    }

    private final void s5() {
        this.f18259Z.launch(new Intent(this, LoginActivity.class), UptodownApp.f17422D.b(this));
    }

    /* access modifiers changed from: protected */
    public void A4() {
    }

    public void H2() {
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.d();
        }
    }

    public void P2(File file) {
        m.e(file, "file");
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.e(file, this);
        }
    }

    public void R2(File file) {
        m.e(file, "file");
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.d();
        }
        Q q5 = this.f18257X;
        if (q5 != null) {
            q5.c(file, this);
        }
    }

    public void S2(File file, int i4) {
        m.e(file, "file");
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.c(file, this);
        }
    }

    public final void i5() {
        Q q4 = this.f18257X;
        if (q4 != null) {
            q4.d();
        }
    }

    public final void j5(String str) {
        Q q4 = this.f18257X;
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
        d5();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        k5();
    }

    public final void r5(long j4, C2053k kVar) {
        m.e(kVar, "floatingCategory");
        if (j4 > 0) {
            new C1640l(this, j4, new g(this, kVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        E2();
        s sVar = s.f8222a;
    }

    public final void t5(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new k(this, str, (V2.d) null), 2, (Object) null);
    }
}
