package d2;

import M1.E;
import N1.k;
import R2.h;
import R2.n;
import R2.s;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import c2.H0;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.C2010a;
import f2.C2013d;
import f2.C2014e;
import f2.C2027s;
import f2.W;
import g2.C2047e;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import g2.K;
import g2.Q;
import g2.U;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import u2.t;
import u2.w;
import u2.x;
import w2.q;

/* renamed from: d2.h  reason: case insensitive filesystem */
public final class C1910h extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f19903f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final R2.g f19904a = h.a(new C1883a(this));

    /* renamed from: b  reason: collision with root package name */
    public C2047e f19905b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public E f19906c;

    /* renamed from: d  reason: collision with root package name */
    private g f19907d = new g(this);

    /* renamed from: e  reason: collision with root package name */
    private f f19908e = new f(this);

    /* renamed from: d2.h$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C1910h a(C2047e eVar) {
            m.e(eVar, "alternatives");
            C1910h hVar = new C1910h();
            hVar.K(eVar);
            return hVar;
        }

        private a() {
        }
    }

    /* renamed from: d2.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1910h f19911c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, C1910h hVar, V2.d dVar) {
            super(2, dVar);
            this.f19910b = str;
            this.f19911c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19910b, this.f19911c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19909a == 0) {
                n.b(obj);
                String str = this.f19910b;
                if (!(str == null || str.length() == 0 || this.f19911c.f19906c == null)) {
                    E r4 = this.f19911c.f19906c;
                    m.b(r4);
                    int i4 = 0;
                    for (E.b bVar : r4.c()) {
                        int i5 = i4 + 1;
                        if (bVar.b() != null) {
                            C2050h b5 = bVar.b();
                            m.b(b5);
                            if (b5.Q() != null) {
                                C2050h b6 = bVar.b();
                                m.b(b6);
                                if (m.a(b6.Q(), this.f19910b)) {
                                    E r5 = this.f19911c.f19906c;
                                    m.b(r5);
                                    r5.notifyItemChanged(i4);
                                }
                            }
                        }
                        i4 = i5;
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.h$c */
    public static final class c implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1910h f19912a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2050h f19913b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19914c;

        c(C1910h hVar, C2050h hVar2, int i4) {
            this.f19912a = hVar;
            this.f19913b = hVar2;
            this.f19914c = i4;
        }

        /* access modifiers changed from: private */
        public static final s e(C1910h hVar, C2050h hVar2) {
            hVar.D(hVar2);
            return s.f8222a;
        }

        /* access modifiers changed from: private */
        public static final s f(C1910h hVar, C2050h hVar2, int i4) {
            hVar.w(hVar2, i4);
            return s.f8222a;
        }

        public void a(K k4) {
            m.e(k4, "reportVT");
            if (this.f19912a.getActivity() != null && (this.f19912a.getActivity() instanceof C1826a) && !this.f19912a.requireActivity().isFinishing()) {
                this.f19913b.R0(k4);
                if (k4.d() > 0) {
                    FragmentActivity activity = this.f19912a.getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2050h hVar = this.f19913b;
                    ((C1826a) activity).d2(hVar, new C1913i(this.f19912a, hVar), new C1916j(this.f19912a, this.f19913b, this.f19914c));
                    return;
                }
                this.f19912a.D(this.f19913b);
            }
        }

        public void b() {
            this.f19912a.D(this.f19913b);
        }
    }

    /* renamed from: d2.h$d */
    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1910h f19915a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19916b;

        d(C1910h hVar, int i4) {
            this.f19915a = hVar;
            this.f19916b = i4;
        }

        public void b(int i4) {
            if (this.f19915a.getActivity() instanceof C1826a) {
                FragmentActivity activity = this.f19915a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).q0(this.f19915a.getString(R.string.error_cant_enqueue_download) + " (108)");
            }
        }

        public void c(C2050h hVar) {
            ArrayList arrayList;
            m.e(hVar, "appInfo");
            if (hVar.E0()) {
                this.f19915a.x(hVar, this.f19916b);
                E r4 = this.f19915a.f19906c;
                if (r4 != null) {
                    arrayList = r4.c();
                } else {
                    arrayList = null;
                }
                m.b(arrayList);
                ((E.b) arrayList.get(this.f19916b)).e(hVar);
                E r5 = this.f19915a.f19906c;
                if (r5 != null) {
                    r5.notifyItemChanged(this.f19916b);
                }
            } else if (hVar.G0()) {
                FragmentActivity activity = this.f19915a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f19915a.getString(R.string.download_not_available_in_this_country);
                m.d(string, "getString(...)");
                ((C1826a) activity).q0(string);
            } else {
                FragmentActivity activity2 = this.f19915a.getActivity();
                m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string2 = this.f19915a.getString(R.string.app_detail_not_available);
                m.d(string2, "getString(...)");
                ((C1826a) activity2).q0(string2);
            }
        }
    }

    /* renamed from: d2.h$e */
    public static final class e implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1910h f19917a;

        e(C1910h hVar) {
            this.f19917a = hVar;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            this.f19917a.L(hVar);
        }
    }

    /* renamed from: d2.h$f */
    public static final class f implements C2014e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1910h f19918a;

        f(C1910h hVar) {
            this.f19918a = hVar;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            this.f19918a.w(hVar, i4);
        }

        public void b(C2050h hVar, int i4) {
            boolean z4;
            boolean z5;
            boolean z6;
            m.e(hVar, "appInfo");
            if (this.f19918a.getContext() != null) {
                t.a aVar = t.f21927u;
                Context context = this.f19918a.getContext();
                m.b(context);
                t a5 = aVar.a(context);
                a5.a();
                C2060s f02 = a5.f0(String.valueOf(hVar.z()));
                boolean s4 = new u2.m().s(hVar.Q(), this.f19918a.getContext());
                a5.i();
                UptodownApp.a aVar2 = UptodownApp.f17422D;
                Context context2 = this.f19918a.getContext();
                m.b(context2);
                if (!aVar2.T("downloadApkWorker", context2) || !DownloadWorker.f19459d.j(hVar.e())) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (f02 == null || !f02.K()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (f02 == null || !f02.f()) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (f02 != null && (z4 || z5 || z6)) {
                    int x4 = f02.x();
                    if (1 <= x4 && x4 < 100 && DownloadWorker.f19459d.k(hVar.e(), hVar.H())) {
                        return;
                    }
                    if (f02.f()) {
                        w wVar = new w();
                        Context context3 = this.f19918a.getContext();
                        m.b(context3);
                        File f4 = wVar.f(context3);
                        String a6 = ((C2060s.c) f02.o().get(0)).a();
                        m.b(a6);
                        File file = new File(f4, a6);
                        Context context4 = this.f19918a.getContext();
                        m.b(context4);
                        aVar2.V(file, context4, hVar.M());
                        return;
                    }
                    Context context5 = this.f19918a.getContext();
                    m.b(context5);
                    f02.R(context5);
                    E r4 = this.f19918a.f19906c;
                    if (r4 != null) {
                        r4.notifyItemChanged(i4);
                    }
                } else if (s4) {
                    this.f19918a.I(hVar.Q());
                } else {
                    this.f19918a.C(hVar.e(), i4);
                }
            }
        }
    }

    /* renamed from: d2.h$g */
    public static final class g implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1910h f19919a;

        g(C1910h hVar) {
            this.f19919a = hVar;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (this.f19919a.getActivity() != null && (this.f19919a.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = this.f19919a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).C2(hVar.e());
            } else if (this.f19919a.getActivity() != null && (this.f19919a.getActivity() instanceof C1826a)) {
                FragmentActivity activity2 = this.f19919a.getActivity();
                m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity2).C2(hVar.e());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final s A(C1910h hVar, C2050h hVar2) {
        hVar.D(hVar2);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s B(C1910h hVar, C2050h hVar2, int i4) {
        hVar.w(hVar2, i4);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void C(long j4, int i4) {
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, j4, new d(this, i4), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void D(C2050h hVar) {
        if (getActivity() != null && (getActivity() instanceof C1826a)) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            aVar.c0(hVar, (C1826a) activity);
        }
    }

    private final H0 F() {
        return (H0) this.f19904a.getValue();
    }

    private final void G() {
        F().f9768d.setVisibility(0);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.core_vector_back);
        if (drawable != null) {
            F().f9768d.setNavigationIcon(drawable);
            F().f9768d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        F().f9768d.setNavigationOnClickListener(new C1887b(this));
        F().f9769e.setTypeface(k.f7778g.x());
        F().f9769e.setVisibility(8);
        F().f9767c.setItemAnimator((RecyclerView.ItemAnimator) null);
        F().f9767c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        F().f9767c.addItemDecoration(new q(11));
        RecyclerView recyclerView = F().f9767c;
        m.d(recyclerView, "recyclerviewTopCat");
        recyclerView.setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public static final void H(C1910h hVar, View view) {
        FragmentActivity activity = hVar.getActivity();
        if (activity instanceof MainActivity) {
            FragmentActivity activity2 = hVar.getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).Z6();
        } else if (activity instanceof AppDetailActivity) {
            FragmentActivity activity3 = hVar.getActivity();
            m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity3).finish();
        } else if (activity instanceof MoreInfo) {
            FragmentActivity activity4 = hVar.getActivity();
            m.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.MoreInfo");
            ((MoreInfo) activity4).finish();
        }
    }

    /* access modifiers changed from: private */
    public final void I(String str) {
        Intent launchIntentForPackage;
        if (getActivity() != null && str != null && str.length() != 0 && (launchIntentForPackage = requireActivity().getPackageManager().getLaunchIntentForPackage(str)) != null) {
            startActivity(launchIntentForPackage);
        }
    }

    private final void J() {
        E e5;
        if (k.f7778g.i() == null && (e5 = this.f19906c) != null) {
            e5.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void L(C2050h hVar) {
        if ((getActivity() instanceof MainActivity) || (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity).V2(hVar, new C1891c(hVar, this));
        }
    }

    /* access modifiers changed from: private */
    public static final s M(C2050h hVar, C1910h hVar2) {
        if (hVar.Q() != null) {
            String Q4 = hVar.Q();
            m.b(Q4);
            hVar2.u(Q4);
        }
        return s.f8222a;
    }

    private final void N(C2047e eVar) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            Q q4 = new Q((C2053k) null, (ArrayList) null, 0, 7, (C2103g) null);
            ArrayList a5 = eVar.a();
            m.b(a5);
            q4.d(a5);
            q4.e(new C2053k(-4, eVar.c(), eVar.b()));
            g gVar = this.f19907d;
            f fVar = this.f19908e;
            e eVar2 = new e(this);
            String b5 = eVar.b();
            String c5 = eVar.c();
            String string = getString(R.string.read_more_desc_app_detail);
            m.d(string, "getString(...)");
            String string2 = getString(R.string.read_less_desc_app_detail);
            m.d(string2, "getString(...)");
            E e5 = new E(gVar, fVar, eVar2, b5, c5, string, string2);
            this.f19906c = e5;
            e5.b(q4);
            F().f9767c.setAdapter(this.f19906c);
        }
    }

    /* access modifiers changed from: private */
    public static final H0 v(C1910h hVar) {
        return H0.c(hVar.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void w(C2050h hVar, int i4) {
        if (getContext() != null) {
            t.a aVar = t.f21927u;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            String Q4 = hVar.Q();
            m.b(Q4);
            C2060s i02 = a5.i0(Q4, hVar.H());
            a5.i();
            if (i02 != null) {
                DownloadWorker.f19459d.d(hVar.e());
                i02.g();
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                i02.R(requireContext2);
                E e5 = this.f19906c;
                if (e5 != null) {
                    e5.notifyItemChanged(i4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void x(C2050h hVar, int i4) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            U.b bVar = U.f20468m;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            U e5 = bVar.e(requireActivity);
            if (e5 == null || !e5.n()) {
                D(hVar);
                s sVar = s.f8222a;
            } else if (hVar.F0()) {
                FragmentActivity activity = getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).d2(hVar, new C1895d(this, hVar), new C1899e(this, hVar, i4));
                s sVar2 = s.f8222a;
            } else if (hVar.e0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                m.d(requireActivity2, "requireActivity(...)");
                new b2.p(requireActivity2, String.valueOf(hVar.z()), hVar.i0(), new c(this, hVar, i4), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                K e02 = hVar.e0();
                m.b(e02);
                if (e02.d() > 0) {
                    FragmentActivity activity2 = getActivity();
                    m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity2).d2(hVar, new C1903f(this, hVar), new C1907g(this, hVar, i4));
                } else {
                    D(hVar);
                }
                s sVar3 = s.f8222a;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final s y(C1910h hVar, C2050h hVar2) {
        hVar.D(hVar2);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s z(C1910h hVar, C2050h hVar2, int i4) {
        hVar.w(hVar2, i4);
        return s.f8222a;
    }

    public final C2047e E() {
        C2047e eVar = this.f19905b;
        if (eVar != null) {
            return eVar;
        }
        m.u("alternatives");
        return null;
    }

    public final void K(C2047e eVar) {
        m.e(eVar, "<set-?>");
        this.f19905b = eVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N(E());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        G();
        RelativeLayout b5 = F().getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        new x(getContext()).e("AlternativesFragment");
        J();
    }

    public final void u(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(str, this, (V2.d) null), 2, (Object) null);
    }
}
