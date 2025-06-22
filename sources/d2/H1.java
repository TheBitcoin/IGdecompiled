package d2;

import M1.C1527d;
import N1.k;
import R2.g;
import R2.h;
import R2.n;
import R2.s;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1639k;
import c2.C1658c0;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import d3.p;
import f2.C2010a;
import f2.C2028t;
import f2.r;
import g2.C2050h;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import u2.x;

public final class H1 extends Fragment {

    /* renamed from: m  reason: collision with root package name */
    public static final a f19714m = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final g f19715a = h.a(new F1(this));

    /* renamed from: b  reason: collision with root package name */
    private C2053k f19716b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1527d f19717c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f19718d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f19719e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Q f19720f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Q f19721g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public C2050h f19722h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19723i;

    /* renamed from: j  reason: collision with root package name */
    private C2028t f19724j = new d(this);

    /* renamed from: k  reason: collision with root package name */
    private final b f19725k = new b(this);

    /* renamed from: l  reason: collision with root package name */
    private final c f19726l = new c(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final H1 a(C2053k kVar) {
            m.e(kVar, "category");
            H1 h12 = new H1();
            h12.setArguments(kVar.o());
            return h12;
        }

        private a() {
        }
    }

    public static final class b implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1 f19727a;

        b(H1 h12) {
            this.f19727a = h12;
        }

        /* access modifiers changed from: private */
        public static final s c(H1 h12, C2050h hVar) {
            h12.y(hVar.Q());
            return s.f8222a;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            if (this.f19727a.getActivity() instanceof MainActivity) {
                FragmentActivity activity = this.f19727a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                RelativeLayout M5 = ((MainActivity) activity).M5();
                if (M5 == null || M5.getVisibility() != 0) {
                    FragmentActivity activity2 = this.f19727a.getActivity();
                    m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity2).V2(hVar, new I1(this.f19727a, hVar));
                }
            }
        }
    }

    public static final class c implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1 f19728a;

        c(H1 h12) {
            this.f19728a = h12;
        }

        public void a(Q q4) {
            m.e(q4, "topByCategoryReceived");
            this.f19728a.f19721g = q4;
        }

        public void b(ArrayList arrayList) {
            C1527d j4;
            m.e(arrayList, "topsByCategoryReceived");
            if (arrayList.size() > 0 && this.f19728a.u() != null && (j4 = this.f19728a.f19717c) != null) {
                C2053k u4 = this.f19728a.u();
                m.b(u4);
                j4.m(arrayList, u4);
            }
        }

        public void c(ArrayList arrayList) {
            m.e(arrayList, "featuresReceived");
            this.f19728a.f19719e = arrayList;
        }

        public void d(ArrayList arrayList) {
            m.e(arrayList, "floatingCategories");
            C1527d j4 = this.f19728a.f19717c;
            if (j4 != null) {
                j4.i(arrayList);
            }
        }

        public void e(Q q4) {
            m.e(q4, "topByCategoryReceived");
            C1527d j4 = this.f19728a.f19717c;
            if (j4 != null) {
                j4.k(q4);
            }
        }

        public void f(C2050h hVar) {
            m.e(hVar, "appReplacement");
            C1527d j4 = this.f19728a.f19717c;
            if (j4 != null) {
                j4.b(hVar);
            }
        }

        public void g() {
            this.f19728a.r();
        }

        public void h(C2050h hVar) {
            m.e(hVar, "appInfo");
            this.f19728a.f19722h = hVar;
        }

        public void i(ArrayList arrayList) {
            m.e(arrayList, "categoriesReceived");
            this.f19728a.f19718d = arrayList;
        }

        public void j(Q q4) {
            m.e(q4, "recentsByCategoryReceived");
            this.f19728a.f19720f = q4;
        }
    }

    public static final class d implements C2028t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1 f19729a;

        d(H1 h12) {
            this.f19729a = h12;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0() && this.f19729a.getActivity() != null && (this.f19729a.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = this.f19729a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).C2(hVar.e());
            }
        }

        public void b(C2053k kVar) {
            m.e(kVar, "category");
            if (UptodownApp.f17422D.a0()) {
                FragmentActivity activity = this.f19729a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).i8(kVar);
            }
        }

        public void c(Q q4) {
            m.e(q4, "topByCategory");
            if (UptodownApp.f17422D.a0()) {
                FragmentActivity activity = this.f19729a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).i8(q4.b());
            }
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19731b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H1 f19732c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, H1 h12, V2.d dVar) {
            super(2, dVar);
            this.f19731b = str;
            this.f19732c = h12;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19731b, this.f19732c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            C1527d j4;
            W2.b.c();
            if (this.f19730a == 0) {
                n.b(obj);
                String str = this.f19731b;
                if (!(str == null || str.length() == 0 || (j4 = this.f19732c.f19717c) == null)) {
                    String str2 = this.f19731b;
                    RecyclerView recyclerView = this.f19732c.s().f10253d;
                    m.d(recyclerView, "recyclerView");
                    j4.w(str2, recyclerView);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final C1658c0 q(H1 h12) {
        return C1658c0.c(h12.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0.isEmpty() == false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r() {
        /*
            r9 = this;
            M1.d r0 = r9.f19717c
            if (r0 == 0) goto L_0x0014
            if (r0 == 0) goto L_0x000b
            java.util.ArrayList r0 = r0.r()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002a
        L_0x0014:
            M1.d r0 = new M1.d
            f2.t r1 = r9.f19724j
            d2.H1$b r2 = r9.f19725k
            java.lang.Class<d2.H1> r3 = d2.H1.class
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r4 = "getSimpleName(...)"
            kotlin.jvm.internal.m.d(r3, r4)
            r0.<init>(r1, r2, r3)
            r9.f19717c = r0
        L_0x002a:
            java.util.ArrayList r0 = r9.f19719e
            int r0 = r0.size()
            r1 = 8
            r2 = 0
            if (r0 <= 0) goto L_0x006c
            java.util.ArrayList r0 = r9.f19718d
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x006c
            M1.d r3 = r9.f19717c
            if (r3 == 0) goto L_0x004e
            java.util.ArrayList r4 = r9.f19719e
            java.util.ArrayList r5 = r9.f19718d
            g2.Q r6 = r9.f19720f
            g2.h r7 = r9.f19722h
            g2.Q r8 = r9.f19721g
            r3.p(r4, r5, r6, r7, r8)
        L_0x004e:
            c2.c0 r0 = r9.s()
            androidx.recyclerview.widget.RecyclerView r0 = r0.f10253d
            M1.d r3 = r9.f19717c
            r0.setAdapter(r3)
            c2.c0 r0 = r9.s()
            androidx.recyclerview.widget.RecyclerView r0 = r0.f10253d
            r0.setVisibility(r2)
            c2.c0 r0 = r9.s()
            android.widget.TextView r0 = r0.f10255f
            r0.setVisibility(r1)
            goto L_0x0087
        L_0x006c:
            c2.c0 r0 = r9.s()
            androidx.recyclerview.widget.RecyclerView r0 = r0.f10253d
            r0.setVisibility(r1)
            c2.c0 r0 = r9.s()
            android.widget.TextView r0 = r0.f10255f
            r0.setVisibility(r2)
            c2.c0 r0 = r9.s()
            android.widget.TextView r0 = r0.f10254e
            r0.setVisibility(r2)
        L_0x0087:
            c2.c0 r0 = r9.s()
            android.view.View r0 = r0.f10252c
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.H1.r():void");
    }

    /* access modifiers changed from: private */
    public final C1658c0 s() {
        return (C1658c0) this.f19715a.getValue();
    }

    private final void t() {
        if (!this.f19723i) {
            this.f19723i = true;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            c cVar = this.f19726l;
            C2053k kVar = this.f19716b;
            m.b(kVar);
            new C1639k(requireContext, cVar, kVar, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void v(H1 h12, View view) {
        if (UptodownApp.f17422D.a0()) {
            h12.s().f10255f.setVisibility(8);
            h12.s().f10252c.setVisibility(0);
            h12.s().f10254e.setVisibility(8);
            h12.w();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
            this.f19716b = kVar;
            m.b(kVar);
            kVar.n(arguments);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        TextView textView = s().f10254e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        s().f10255f.setTypeface(aVar.w());
        s().f10255f.setOnClickListener(new G1(this));
        s().f10253d.setItemAnimator((RecyclerView.ItemAnimator) null);
        s().f10253d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        s().f10253d.addItemDecoration(new w2.n((int) getResources().getDimension(R.dimen.margin_m)));
        s().f10252c.setVisibility(0);
        FrameLayout b5 = s().getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    public void onPause() {
        super.onPause();
        C1.e l4 = UptodownApp.f17422D.l();
        if (l4 != null) {
            l4.pause();
        }
    }

    public void onResume() {
        C1.e l4;
        super.onResume();
        new x(getContext()).e("ParentCategoryFragment");
        UptodownApp.a aVar = UptodownApp.f17422D;
        C1.e k4 = aVar.k();
        if (k4 != null) {
            k4.pause();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (aVar.f(requireContext)) {
                a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                if (aVar2.k(requireContext2) > 0 && (l4 = aVar.l()) != null) {
                    l4.play();
                }
            }
        }
        t();
    }

    public final C2053k u() {
        return this.f19716b;
    }

    public final void w() {
        this.f19723i = false;
        t();
    }

    public final void x() {
        s().f10253d.smoothScrollToPosition(0);
    }

    public final void y(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(str, this, (V2.d) null), 2, (Object) null);
    }
}
