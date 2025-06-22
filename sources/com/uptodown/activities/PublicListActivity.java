package com.uptodown.activities;

import J1.C1446t2;
import J1.I3;
import J1.J3;
import J1.K3;
import M1.Q;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import S2.C1601o;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import c2.C1684p0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.C2027s;
import f2.U;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.W;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.t;

public final class PublicListActivity extends C1446t2 {

    /* renamed from: V  reason: collision with root package name */
    private final R2.g f18184V = R2.h.a(new J3(this));

    /* renamed from: W  reason: collision with root package name */
    private final R2.g f18185W = new ViewModelLazy(D.b(K3.class), new f(this), new e(this), new g((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public Q f18186X;

    /* renamed from: Y  reason: collision with root package name */
    private b f18187Y = new b(this);

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f18188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f18189b;

        a(LinearLayoutManager linearLayoutManager, PublicListActivity publicListActivity) {
            this.f18188a = linearLayoutManager;
            this.f18189b = publicListActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0) {
                int findFirstVisibleItemPosition = this.f18188a.findFirstVisibleItemPosition();
                int childCount = this.f18188a.getChildCount();
                int itemCount = this.f18188a.getItemCount();
                if (!this.f18189b.R4().f() && !this.f18189b.R4().e() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    Q J4 = this.f18189b.f18186X;
                    m.b(J4);
                    J4.f(true);
                    this.f18189b.R4().d(this.f18189b);
                }
            }
        }
    }

    public static final class b implements U {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f18190a;

        public static final class a implements C2027s {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicListActivity f18191a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f18192b;

            a(PublicListActivity publicListActivity, int i4) {
                this.f18191a = publicListActivity;
                this.f18192b = i4;
            }

            public void b(int i4) {
                PublicListActivity publicListActivity = this.f18191a;
                String string = publicListActivity.getString(R.string.error_cant_enqueue_download);
                m.d(string, "getString(...)");
                publicListActivity.q0(string);
            }

            public void c(C2050h hVar) {
                m.e(hVar, "appInfo");
                String o4 = hVar.o();
                if (o4 == null || o4.length() == 0) {
                    PublicListActivity publicListActivity = this.f18191a;
                    String string = publicListActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{hVar.L()});
                    m.d(string, "getString(...)");
                    publicListActivity.U1(string);
                } else if (new u2.m().s(hVar.Q(), this.f18191a)) {
                    this.f18191a.v4(new u2.m().A(this.f18191a, hVar.Q()));
                } else {
                    this.f18191a.V4(hVar, this.f18192b);
                }
            }
        }

        b(PublicListActivity publicListActivity) {
            this.f18190a = publicListActivity;
        }

        public void a(int i4) {
            if (UptodownApp.f17422D.a0() && this.f18190a.f18186X != null) {
                Q J4 = this.f18190a.f18186X;
                m.b(J4);
                if (!J4.b().isEmpty()) {
                    Q J42 = this.f18190a.f18186X;
                    m.b(J42);
                    Object obj = J42.b().get(i4);
                    m.d(obj, "get(...)");
                    this.f18190a.C2(((W) obj).a());
                }
            }
        }

        public void b(View view, int i4) {
            m.e(view, "v");
        }

        public void c(int i4) {
            if (this.f18190a.f18186X != null) {
                Q J4 = this.f18190a.f18186X;
                m.b(J4);
                if (!J4.b().isEmpty()) {
                    PublicListActivity publicListActivity = this.f18190a;
                    Q J42 = publicListActivity.f18186X;
                    m.b(J42);
                    new C1640l(publicListActivity, ((W) J42.b().get(i4)).a(), new a(this.f18190a, i4), LifecycleOwnerKt.getLifecycleScope(this.f18190a));
                }
            }
        }

        public void d(int i4) {
            if (this.f18190a.f18186X != null) {
                Q J4 = this.f18190a.f18186X;
                m.b(J4);
                if (!J4.b().isEmpty()) {
                    Q J42 = this.f18190a.f18186X;
                    m.b(J42);
                    Object obj = J42.b().get(i4);
                    m.d(obj, "get(...)");
                    W w4 = (W) obj;
                    String f4 = w4.f();
                    if (f4 == null || f4.length() == 0) {
                        PublicListActivity publicListActivity = this.f18190a;
                        String string = publicListActivity.getString(R.string.error_open_app, new Object[]{w4.e()});
                        m.d(string, "getString(...)");
                        publicListActivity.U1(string);
                        return;
                    }
                    PackageManager packageManager = this.f18190a.getPackageManager();
                    String f5 = w4.f();
                    m.b(f5);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(f5);
                    if (launchIntentForPackage != null) {
                        this.f18190a.startActivity(launchIntentForPackage);
                        return;
                    }
                    PublicListActivity publicListActivity2 = this.f18190a;
                    String string2 = publicListActivity2.getString(R.string.error_open_app, new Object[]{w4.e()});
                    m.d(string2, "getString(...)");
                    publicListActivity2.U1(string2);
                }
            }
        }

        public void e(long j4, C2053k kVar) {
            m.e(kVar, "category");
            if (UptodownApp.f17422D.a0()) {
                this.f18190a.W4(j4, kVar);
            }
        }

        public void f(int i4) {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f18194b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicListActivity f18195a;

            a(PublicListActivity publicListActivity) {
                this.f18195a = publicListActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    if (this.f18195a.f18186X == null) {
                        this.f18195a.Q4().f10699b.setVisibility(0);
                    }
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (((ArrayList) cVar.a()).size() == 0) {
                        this.f18195a.Q4().f10702e.setVisibility(0);
                    } else {
                        this.f18195a.P4((ArrayList) cVar.a());
                    }
                    this.f18195a.Q4().f10699b.setVisibility(8);
                } else if (e5 instanceof E.b) {
                    this.f18195a.Q4().f10699b.setVisibility(8);
                    if (this.f18195a.f18186X != null) {
                        Q J4 = this.f18195a.f18186X;
                        m.b(J4);
                        J4.f(false);
                        Q J42 = this.f18195a.f18186X;
                        m.b(J42);
                        if (J42.b().isEmpty()) {
                            this.f18195a.Q4().f10702e.setVisibility(0);
                        }
                    }
                } else {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PublicListActivity publicListActivity, V2.d dVar) {
            super(2, dVar);
            this.f18194b = publicListActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18194b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18193a;
            if (i4 == 0) {
                n.b(obj);
                I g4 = this.f18194b.R4().g();
                a aVar = new a(this.f18194b);
                this.f18193a = 1;
                if (g4.collect(aVar, this) == c5) {
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
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f18196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2053k f18197b;

        d(PublicListActivity publicListActivity, C2053k kVar) {
            this.f18196a = publicListActivity;
            this.f18197b = kVar;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (!this.f18196a.isFinishing()) {
                Intent intent = new Intent(this.f18196a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                intent.putExtra("viewCategory", this.f18197b);
                PublicListActivity publicListActivity = this.f18196a;
                publicListActivity.startActivity(intent, UptodownApp.f17422D.a(publicListActivity));
            }
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18198a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18198a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18198a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18199a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18199a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18199a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18201b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18200a = aVar;
            this.f18201b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18200a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18201b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PublicListActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f18203b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18204c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(PublicListActivity publicListActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18203b = publicListActivity;
            this.f18204c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f18203b, this.f18204c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            W2.b.c();
            if (this.f18202a == 0) {
                n.b(obj);
                if (this.f18203b.f18186X != null) {
                    Q J4 = this.f18203b.f18186X;
                    m.b(J4);
                    if (!(J4.b().isEmpty() || (str = this.f18204c) == null || str.length() == 0)) {
                        Q J42 = this.f18203b.f18186X;
                        m.b(J42);
                        ArrayList b5 = J42.b();
                        String str2 = this.f18204c;
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
                        Q J43 = this.f18203b.f18186X;
                        m.b(J43);
                        int K4 = C1601o.K(J43.b(), (W) obj2);
                        if (K4 > -1) {
                            Q J44 = this.f18203b.f18186X;
                            m.b(J44);
                            J44.notifyItemChanged(K4);
                        } else {
                            this.f18203b.U4();
                        }
                        return s.f8222a;
                    }
                }
                this.f18203b.U4();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final C1684p0 O4(PublicListActivity publicListActivity) {
        return C1684p0.c(publicListActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void P4(ArrayList arrayList) {
        Q q4 = this.f18186X;
        if (q4 == null) {
            this.f18186X = new Q(arrayList, this, this.f18187Y);
            Q4().f10700c.setAdapter(this.f18186X);
            return;
        }
        m.b(q4);
        q4.a(arrayList);
        Q q5 = this.f18186X;
        if (q5 != null) {
            q5.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final C1684p0 Q4() {
        return (C1684p0) this.f18184V.getValue();
    }

    /* access modifiers changed from: private */
    public final K3 R4() {
        return (K3) this.f18185W.getValue();
    }

    private final void S4(g2.U u4) {
        setContentView((View) Q4().getRoot());
        Q4().f10701d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        Q4().f10701d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        Q4().f10701d.setNavigationOnClickListener(new I3(this));
        TextView textView = Q4().f10703f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        Q4().f10702e.setTypeface(aVar.x());
        Q4().f10703f.setText(getString(R.string.user_recommended_apps, new Object[]{u4.h()}));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        Q4().f10700c.setLayoutManager(linearLayoutManager);
        Q4().f10700c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        Q4().f10700c.addItemDecoration(new w2.l(dimension, dimension));
        Q4().f10700c.setItemAnimator(defaultItemAnimator);
        Q4().f10700c.addOnScrollListener(new a(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void T4(PublicListActivity publicListActivity, View view) {
        publicListActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void U4() {
        Q q4 = this.f18186X;
        if (q4 != null) {
            q4.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void V4(C2050h hVar, int i4) {
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
                aVar2.a(f02);
                Q q4 = this.f18186X;
                if (q4 != null) {
                    q4.notifyItemChanged(i4);
                }
            } else if (f02.f()) {
                File n4 = f02.n();
                if (n4 != null) {
                    UptodownApp.f17422D.X(n4, this, hVar.M());
                }
            } else if (f02.K()) {
                f02.R(this);
                Q q5 = this.f18186X;
                if (q5 != null) {
                    q5.notifyItemChanged(i4);
                }
            }
        } else {
            UptodownApp.f17422D.c0(hVar, this);
            Q q6 = this.f18186X;
            if (q6 != null) {
                m.b(q6);
                ((W) q6.b().get(i4)).m(hVar.z());
                Q q7 = this.f18186X;
                if (q7 != null) {
                    q7.notifyItemChanged(i4);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void A4() {
    }

    public final void W4(long j4, C2053k kVar) {
        m.e(kVar, "floatingCategory");
        if (j4 > 0) {
            new C1640l(this, j4, new d(this, kVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        E2();
        s sVar = s.f8222a;
    }

    public final void X4(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new h(this, str, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        g2.U u4;
        String g4;
        Bundle extras;
        super.onCreate(bundle);
        if (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user")) {
            u4 = null;
        } else {
            u4 = (g2.U) extras.getParcelable("user");
        }
        if (!(u4 == null || (g4 = u4.g()) == null || g4.length() == 0)) {
            S4(u4);
            r3.t h4 = R4().h();
            String g5 = u4.g();
            m.b(g5);
            h4.setValue(g5);
            R4().d(this);
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
    }
}
