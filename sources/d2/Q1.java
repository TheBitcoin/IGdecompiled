package d2;

import M1.E;
import N1.k;
import R2.n;
import R2.s;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import b2.r;
import c2.H0;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.workers.DownloadWorker;
import d2.U1;
import d3.p;
import f2.C2010a;
import f2.C2013d;
import f2.C2014e;
import f2.C2027s;
import f2.W;
import f2.z;
import g2.C2039G;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.K;
import g2.Q;
import g2.S;
import g2.U;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.t;
import u2.x;
import w2.q;

public final class Q1 extends Fragment {

    /* renamed from: i  reason: collision with root package name */
    public static final a f19769i = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final R2.g f19770a = R2.h.a(new J1(this));

    /* renamed from: b  reason: collision with root package name */
    private final R2.g f19771b = FragmentViewModelLazyKt.createViewModelLazy(this, D.b(U1.class), new i(new h(this)), (d3.a) null);

    /* renamed from: c  reason: collision with root package name */
    private C2053k f19772c = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);

    /* renamed from: d  reason: collision with root package name */
    private String f19773d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public E f19774e;

    /* renamed from: f  reason: collision with root package name */
    private k f19775f = new k(this);

    /* renamed from: g  reason: collision with root package name */
    private j f19776g = new j(this);

    /* renamed from: h  reason: collision with root package name */
    private final b f19777h = new b(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final Q1 a(C2053k kVar) {
            kotlin.jvm.internal.m.e(kVar, "category");
            Q1 q12 = new Q1();
            q12.W(kVar);
            return q12;
        }

        private a() {
        }
    }

    public static final class b implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19778a;

        b(Q1 q12) {
            this.f19778a = q12;
        }

        /* access modifiers changed from: private */
        public static final s c(Q1 q12, C2050h hVar) {
            q12.Y(hVar);
            return s.f8222a;
        }

        public void a(C2050h hVar, int i4) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if ((this.f19778a.getActivity() instanceof MainActivity) || (this.f19778a.getActivity() instanceof AppDetailActivity)) {
                FragmentActivity activity = this.f19778a.getActivity();
                kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).V2(hVar, new R1(this.f19778a, hVar));
            }
        }
    }

    public static final class c implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19779a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2050h f19780b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19781c;

        c(Q1 q12, C2050h hVar, int i4) {
            this.f19779a = q12;
            this.f19780b = hVar;
            this.f19781c = i4;
        }

        /* access modifiers changed from: private */
        public static final s e(Q1 q12, C2050h hVar, int i4) {
            q12.I(hVar, i4);
            return s.f8222a;
        }

        /* access modifiers changed from: private */
        public static final s f(Q1 q12, C2050h hVar, int i4) {
            q12.B(hVar, i4);
            return s.f8222a;
        }

        public void a(K k4) {
            kotlin.jvm.internal.m.e(k4, "reportVT");
            if (this.f19779a.getActivity() != null && (this.f19779a.getActivity() instanceof C1826a) && !this.f19779a.requireActivity().isFinishing()) {
                this.f19780b.R0(k4);
                if (k4.d() > 0) {
                    FragmentActivity activity = this.f19779a.getActivity();
                    kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2050h hVar = this.f19780b;
                    ((C1826a) activity).d2(hVar, new S1(this.f19779a, hVar, this.f19781c), new T1(this.f19779a, this.f19780b, this.f19781c));
                    return;
                }
                this.f19779a.I(this.f19780b, this.f19781c);
            }
        }

        public void b() {
            this.f19779a.I(this.f19780b, this.f19781c);
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19783b;

        d(Q1 q12, int i4) {
            this.f19782a = q12;
            this.f19783b = i4;
        }

        public void b(int i4) {
            FragmentActivity activity = this.f19782a.getActivity();
            kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity).q0(this.f19782a.getString(R.string.error_cant_enqueue_download) + " (108)");
        }

        public void c(C2050h hVar) {
            ArrayList arrayList;
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (hVar.E0()) {
                this.f19782a.C(hVar, this.f19783b);
                E r4 = this.f19782a.f19774e;
                if (r4 != null) {
                    arrayList = r4.c();
                } else {
                    arrayList = null;
                }
                kotlin.jvm.internal.m.b(arrayList);
                ((E.b) arrayList.get(this.f19783b)).e(hVar);
                E r5 = this.f19782a.f19774e;
                if (r5 != null) {
                    r5.notifyItemChanged(this.f19783b);
                }
            } else if (hVar.G0()) {
                FragmentActivity activity = this.f19782a.getActivity();
                kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f19782a.getString(R.string.download_not_available_in_this_country);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                ((C1826a) activity).q0(string);
            } else {
                FragmentActivity activity2 = this.f19782a.getActivity();
                kotlin.jvm.internal.m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string2 = this.f19782a.getString(R.string.app_detail_not_available);
                kotlin.jvm.internal.m.d(string2, "getString(...)");
                ((C1826a) activity2).q0(string2);
            }
        }
    }

    public static final class e extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19784a;

        e(Q1 q12) {
            this.f19784a = q12;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            kotlin.jvm.internal.m.e(recyclerView, "recyclerView");
            if (i5 > 0 && !this.f19784a.N().h() && recyclerView.getLayoutManager() != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                kotlin.jvm.internal.m.b(layoutManager);
                int childCount = layoutManager.getChildCount();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                kotlin.jvm.internal.m.b(layoutManager2);
                int itemCount = layoutManager2.getItemCount();
                RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                kotlin.jvm.internal.m.b(layoutManager3);
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition();
                if (!this.f19784a.N().f() && childCount + findFirstVisibleItemPosition >= itemCount - 10) {
                    this.f19784a.R();
                }
            }
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19785a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q1 f19786b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Q1 f19787a;

            a(Q1 q12) {
                this.f19787a = q12;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f19787a.J().f9766b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    E.c cVar = (E.c) e5;
                    if (!((U1.a) cVar.a()).a()) {
                        M1.E r4 = this.f19787a.f19774e;
                        if (r4 != null) {
                            r4.a(((U1.a) cVar.a()).b().a(), this.f19787a.K().j());
                        }
                    } else if (((U1.a) cVar.a()).b().a().size() > 0) {
                        this.f19787a.X(((U1.a) cVar.a()).b());
                        this.f19787a.J().f9767c.setVisibility(0);
                        this.f19787a.J().f9769e.setVisibility(8);
                        this.f19787a.J().f9770f.setVisibility(8);
                    } else {
                        this.f19787a.J().f9767c.setVisibility(8);
                        this.f19787a.J().f9769e.setVisibility(0);
                        this.f19787a.J().f9770f.setVisibility(0);
                    }
                    this.f19787a.N().k(false);
                    this.f19787a.J().f9766b.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new R2.k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Q1 q12, V2.d dVar) {
            super(2, dVar);
            this.f19786b = q12;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f19786b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19785a;
            if (i4 == 0) {
                n.b(obj);
                I g4 = this.f19786b.N().g();
                a aVar = new a(this.f19786b);
                this.f19785a = 1;
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
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class g implements z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19788a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2050h f19789b;

        g(Q1 q12, C2050h hVar) {
            this.f19788a = q12;
            this.f19789b = hVar;
        }

        public void a() {
            if (this.f19788a.getActivity() != null && !this.f19788a.requireActivity().isFinishing()) {
                FragmentActivity activity = this.f19788a.getActivity();
                kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f19788a.getString(R.string.error_generico);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                ((C1826a) activity).q0(string);
            }
        }

        public void b() {
            M1.E r4 = this.f19788a.f19774e;
            if (r4 != null) {
                r4.d(this.f19789b);
            }
        }

        public void c() {
            M1.E r4 = this.f19788a.f19774e;
            if (r4 != null) {
                r4.d(this.f19789b);
            }
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f19790a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.f19790a = fragment;
        }

        public final Fragment invoke() {
            return this.f19790a;
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f19791a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d3.a aVar) {
            super(0);
            this.f19791a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f19791a.invoke()).getViewModelStore();
            kotlin.jvm.internal.m.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class j implements C2014e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19792a;

        j(Q1 q12) {
            this.f19792a = q12;
        }

        public void a(C2050h hVar, int i4) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f19792a.B(hVar, i4);
        }

        public void b(C2050h hVar, int i4) {
            boolean z4;
            boolean z5;
            boolean z6;
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (this.f19792a.getContext() == null) {
                return;
            }
            if (this.f19792a.K().b() == 1090) {
                this.f19792a.U(hVar);
            } else if (hVar.z() == 0 || hVar.Q() == null) {
                this.f19792a.T(hVar);
            } else {
                t.a aVar = t.f21927u;
                Context requireContext = this.f19792a.requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                t a5 = aVar.a(requireContext);
                a5.a();
                C2060s sVar = null;
                boolean z7 = false;
                if (hVar.Q() != null) {
                    z4 = new u2.m().s(hVar.Q(), this.f19792a.getContext());
                    String Q4 = hVar.Q();
                    kotlin.jvm.internal.m.b(Q4);
                    S D02 = a5.D0(Q4);
                    if (D02 != null) {
                        Context requireContext2 = this.f19792a.requireContext();
                        kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                        sVar = D02.b(requireContext2);
                    }
                    if (sVar == null) {
                        String Q5 = hVar.Q();
                        kotlin.jvm.internal.m.b(Q5);
                        sVar = a5.i0(Q5, hVar.H());
                    }
                    if (sVar == null) {
                        String Q6 = hVar.Q();
                        kotlin.jvm.internal.m.b(Q6);
                        sVar = a5.h0(Q6);
                    }
                } else {
                    z4 = false;
                }
                a5.i();
                UptodownApp.a aVar2 = UptodownApp.f17422D;
                Context requireContext3 = this.f19792a.requireContext();
                kotlin.jvm.internal.m.d(requireContext3, "requireContext(...)");
                if (!aVar2.T("downloadApkWorker", requireContext3) || !DownloadWorker.f19459d.j(hVar.e())) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (sVar == null || !sVar.K()) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (sVar != null && sVar.f()) {
                    z7 = true;
                }
                if (sVar != null && (z5 || z6 || z7)) {
                    int x4 = sVar.x();
                    if (1 <= x4 && x4 < 100 && DownloadWorker.f19459d.k(hVar.e(), hVar.H())) {
                        return;
                    }
                    if (z7) {
                        File n4 = sVar.n();
                        if (n4 != null) {
                            Context requireContext4 = this.f19792a.requireContext();
                            kotlin.jvm.internal.m.d(requireContext4, "requireContext(...)");
                            aVar2.V(n4, requireContext4, hVar.M());
                            return;
                        }
                        return;
                    }
                    Context requireContext5 = this.f19792a.requireContext();
                    kotlin.jvm.internal.m.d(requireContext5, "requireContext(...)");
                    sVar.R(requireContext5);
                    M1.E r4 = this.f19792a.f19774e;
                    if (r4 != null) {
                        r4.notifyItemChanged(i4);
                    }
                } else if (z4) {
                    this.f19792a.S(hVar.Q());
                } else {
                    this.f19792a.H(hVar, i4);
                }
            }
        }
    }

    public static final class k implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Q1 f19793a;

        k(Q1 q12) {
            this.f19793a = q12;
        }

        public void a(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f19793a.T(hVar);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q1 f19795b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2050h f19796c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Q1 q12, C2050h hVar, V2.d dVar) {
            super(2, dVar);
            this.f19795b = q12;
            this.f19796c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f19795b, this.f19796c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19794a == 0) {
                n.b(obj);
                M1.E r4 = this.f19795b.f19774e;
                kotlin.jvm.internal.m.b(r4);
                r4.notifyItemChanged(this.f19795b.M(this.f19796c.Q()));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19797a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q1 f19798b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19799c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Q1 q12, String str, V2.d dVar) {
            super(2, dVar);
            this.f19798b = q12;
            this.f19799c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f19798b, this.f19799c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19797a == 0) {
                n.b(obj);
                M1.E r4 = this.f19798b.f19774e;
                if (r4 != null) {
                    r4.notifyItemChanged(this.f19798b.M(this.f19799c));
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final H0 A(Q1 q12) {
        return H0.c(q12.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void B(C2050h hVar, int i4) {
        C2060s sVar;
        if (getContext() != null) {
            t.a aVar = t.f21927u;
            Context requireContext = requireContext();
            kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            String Q4 = hVar.Q();
            kotlin.jvm.internal.m.b(Q4);
            S D02 = a5.D0(Q4);
            if (D02 != null) {
                Context requireContext2 = requireContext();
                kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                sVar = D02.b(requireContext2);
            } else {
                sVar = null;
            }
            if (sVar == null) {
                String Q5 = hVar.Q();
                kotlin.jvm.internal.m.b(Q5);
                sVar = a5.i0(Q5, hVar.H());
            }
            if (sVar == null) {
                String Q6 = hVar.Q();
                kotlin.jvm.internal.m.b(Q6);
                sVar = a5.h0(Q6);
            }
            a5.i();
            if (sVar != null) {
                DownloadWorker.f19459d.d(hVar.e());
                Context requireContext3 = requireContext();
                kotlin.jvm.internal.m.d(requireContext3, "requireContext(...)");
                sVar.R(requireContext3);
                M1.E e5 = this.f19774e;
                if (e5 != null) {
                    e5.notifyItemChanged(i4);
                }
                if (D02 != null) {
                    UptodownApp.f17422D.f0(D02.h());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void C(C2050h hVar, int i4) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            U.b bVar = U.f20468m;
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.m.d(requireActivity, "requireActivity(...)");
            U e5 = bVar.e(requireActivity);
            if (e5 == null || !e5.n()) {
                I(hVar, i4);
                s sVar = s.f8222a;
            } else if (hVar.F0()) {
                FragmentActivity activity = getActivity();
                kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).d2(hVar, new M1(this, hVar, i4), new N1(this, hVar, i4));
                s sVar2 = s.f8222a;
            } else if (hVar.e0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                kotlin.jvm.internal.m.d(requireActivity2, "requireActivity(...)");
                new b2.p(requireActivity2, String.valueOf(hVar.z()), hVar.i0(), new c(this, hVar, i4), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                K e02 = hVar.e0();
                kotlin.jvm.internal.m.b(e02);
                if (e02.d() > 0) {
                    FragmentActivity activity2 = getActivity();
                    kotlin.jvm.internal.m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity2).d2(hVar, new O1(this, hVar, i4), new P1(this, hVar, i4));
                } else {
                    I(hVar, i4);
                }
                s sVar3 = s.f8222a;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final s D(Q1 q12, C2050h hVar, int i4) {
        q12.I(hVar, i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s E(Q1 q12, C2050h hVar, int i4) {
        q12.B(hVar, i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s F(Q1 q12, C2050h hVar, int i4) {
        q12.I(hVar, i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s G(Q1 q12, C2050h hVar, int i4) {
        q12.B(hVar, i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void H(C2050h hVar, int i4) {
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, hVar.e(), new d(this, i4), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void I(C2050h hVar, int i4) {
        M1.E e5;
        if (getActivity() != null && (getActivity() instanceof C1826a)) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            if (aVar.c0(hVar, (C1826a) activity) >= 0 && (e5 = this.f19774e) != null) {
                e5.notifyItemChanged(i4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final H0 J() {
        return (H0) this.f19770a.getValue();
    }

    /* access modifiers changed from: private */
    public final int M(String str) {
        M1.E e5;
        int i4 = -1;
        if (!(str == null || str.length() == 0 || (e5 = this.f19774e) == null)) {
            kotlin.jvm.internal.m.b(e5);
            int i5 = 0;
            for (E.b bVar : e5.c()) {
                int i6 = i5 + 1;
                if (bVar.b() != null) {
                    C2050h b5 = bVar.b();
                    kotlin.jvm.internal.m.b(b5);
                    if (b5.Q() != null) {
                        C2050h b6 = bVar.b();
                        kotlin.jvm.internal.m.b(b6);
                        if (kotlin.jvm.internal.m.a(b6.Q(), str)) {
                            i4 = i5;
                        }
                    }
                }
                i5 = i6;
            }
        }
        return i4;
    }

    /* access modifiers changed from: private */
    public final U1 N() {
        return (U1) this.f19771b.getValue();
    }

    private final void O() {
        J().f9768d.setNavigationIcon(ContextCompat.getDrawable(requireContext(), R.drawable.core_vector_back));
        J().f9768d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        J().f9768d.setNavigationOnClickListener(new K1(this));
        TextView textView = J().f9771g;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        J().f9770f.setTypeface(aVar.w());
        J().f9770f.setOnClickListener(new L1(this));
        J().f9769e.setTypeface(aVar.x());
        J().f9769e.setVisibility(8);
        J().f9767c.setItemAnimator((RecyclerView.ItemAnimator) null);
        J().f9767c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (this.f19772c.j()) {
            J().f9767c.addItemDecoration(new q(11));
        }
        if (this.f19772c.b() != -1) {
            RecyclerView recyclerView = J().f9767c;
            kotlin.jvm.internal.m.d(recyclerView, "recyclerviewTopCat");
            recyclerView.setPadding(0, 0, 0, 0);
        }
        J().f9767c.addOnScrollListener(new e(this));
    }

    /* access modifiers changed from: private */
    public static final void P(Q1 q12, View view) {
        FragmentActivity activity = q12.getActivity();
        if (activity instanceof MainActivity) {
            if (q12.f19772c.b() == -1) {
                FragmentActivity activity2 = q12.getActivity();
                kotlin.jvm.internal.m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity2).w5(0);
                return;
            }
            FragmentActivity activity3 = q12.getActivity();
            kotlin.jvm.internal.m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity3).Z6();
        } else if (activity instanceof AppDetailActivity) {
            FragmentActivity activity4 = q12.getActivity();
            kotlin.jvm.internal.m.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity4).finish();
        } else if (activity instanceof MoreInfo) {
            FragmentActivity activity5 = q12.getActivity();
            kotlin.jvm.internal.m.c(activity5, "null cannot be cast to non-null type com.uptodown.activities.MoreInfo");
            ((MoreInfo) activity5).finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void Q(Q1 q12, View view) {
        if (UptodownApp.f17422D.a0()) {
            q12.J().f9770f.setVisibility(8);
            q12.J().f9766b.setVisibility(0);
            q12.J().f9769e.setVisibility(8);
            q12.L();
        }
    }

    /* access modifiers changed from: private */
    public final void R() {
        if (getContext() != null) {
            U1 N4 = N();
            Context requireContext = requireContext();
            kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
            N4.e(requireContext, this.f19772c);
        }
    }

    /* access modifiers changed from: private */
    public final void S(String str) {
        Intent launchIntentForPackage;
        if (getActivity() != null && str != null && str.length() != 0 && (launchIntentForPackage = requireActivity().getPackageManager().getLaunchIntentForPackage(str)) != null) {
            startActivity(launchIntentForPackage);
        }
    }

    /* access modifiers changed from: private */
    public final void T(C2050h hVar) {
        if (!UptodownApp.f17422D.a0()) {
            return;
        }
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).C2(hVar.e());
        } else if (getActivity() != null && (getActivity() instanceof C1826a)) {
            FragmentActivity activity2 = getActivity();
            kotlin.jvm.internal.m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity2).C2(hVar.e());
        }
    }

    /* access modifiers changed from: private */
    public final void U(C2050h hVar) {
        if (getContext() != null) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.a0()) {
                U.b bVar = U.f20468m;
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                if (bVar.e(requireContext) == null) {
                    Intent intent = new Intent(requireContext(), LoginActivity.class);
                    FragmentActivity requireActivity = requireActivity();
                    kotlin.jvm.internal.m.d(requireActivity, "requireActivity(...)");
                    startActivity(intent, aVar.a(requireActivity));
                    return;
                }
                g gVar = new g(this, hVar);
                t.a aVar2 = t.f21927u;
                Context requireContext2 = requireContext();
                kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                t a5 = aVar2.a(requireContext2);
                a5.a();
                C2039G v02 = a5.v0(hVar.e());
                if (v02 == null) {
                    Context requireContext3 = requireContext();
                    kotlin.jvm.internal.m.d(requireContext3, "requireContext(...)");
                    new r(requireContext3, LifecycleOwnerKt.getLifecycleScope(this), gVar).g(hVar);
                    return;
                }
                Context requireContext4 = requireContext();
                kotlin.jvm.internal.m.d(requireContext4, "requireContext(...)");
                new r(requireContext4, LifecycleOwnerKt.getLifecycleScope(this), gVar).e(v02);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void X(Q q4) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            String d5 = q4.b().d();
            if (d5 == null || d5.length() == 0) {
                this.f19773d = getResources().getString(R.string.top_downloads_title);
            } else if (q4.b().b() < 0 || kotlin.jvm.internal.m.a(q4.b().d(), getString(R.string.top_downloads_title))) {
                this.f19773d = q4.b().d();
            } else {
                this.f19773d = getResources().getString(R.string.top_category, new Object[]{q4.b().d()});
            }
            J().f9771g.setText(this.f19773d);
            k kVar = this.f19775f;
            j jVar = this.f19776g;
            b bVar = this.f19777h;
            String a5 = q4.b().a();
            String string = getString(R.string.read_more_desc_app_detail);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            String string2 = getString(R.string.read_less_desc_app_detail);
            kotlin.jvm.internal.m.d(string2, "getString(...)");
            M1.E e5 = new M1.E(kVar, jVar, bVar, a5, (String) null, string, string2);
            this.f19774e = e5;
            e5.b(q4);
            J().f9767c.setAdapter(this.f19774e);
        }
    }

    public final C2053k K() {
        return this.f19772c;
    }

    public final void L() {
        if (getContext() != null) {
            U1 N4 = N();
            Context requireContext = requireContext();
            kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
            N4.d(requireContext, this.f19772c);
        }
    }

    public final void V() {
        J().f9767c.smoothScrollToPosition(0);
    }

    public final void W(C2053k kVar) {
        kotlin.jvm.internal.m.e(kVar, "<set-?>");
        this.f19772c = kVar;
    }

    public final void Y(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        M1.E e5 = this.f19774e;
        kotlin.jvm.internal.m.b(e5);
        ((E.b) e5.c().get(M(hVar.Q()))).e(hVar);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new l(this, hVar, (V2.d) null), 2, (Object) null);
    }

    public final void Z(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new m(this, str, (V2.d) null), 2, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        C2053k kVar;
        super.onCreate(bundle);
        if (bundle != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                kVar = (C2053k) bundle.getParcelable("category", C2053k.class);
            } else {
                kVar = (C2053k) bundle.getParcelable("category");
            }
            if (kVar != null) {
                this.f19772c = kVar;
            }
        }
        if (this.f19772c.b() == 0) {
            this.f19772c.r(-1);
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, (V2.d) null), 2, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.e(layoutInflater, "inflater");
        O();
        RelativeLayout b5 = J().getRoot();
        kotlin.jvm.internal.m.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        new x(getContext()).e("TopByCategoryFragment");
        if (this.f19774e == null) {
            L();
        } else if (J().f9767c.getAdapter() == null) {
            J().f9767c.setAdapter(this.f19774e);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.m.e(bundle, "outState");
        bundle.putParcelable("category", this.f19772c);
        super.onSaveInstanceState(bundle);
    }
}
