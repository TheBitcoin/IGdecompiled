package d2;

import M1.C1527d;
import N1.k;
import R2.n;
import R2.s;
import S2.C1601o;
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
import b2.C1634f;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import d3.p;
import f2.C2010a;
import f2.C2024o;
import f2.C2028t;
import g2.C2050h;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.L;
import u2.x;
import u2.z;

public final class E1 extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final R2.g f19651a = R2.h.a(new C1(this));
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C1527d f19652b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f19653c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f19654d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Q f19655e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f19656f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Q f19657g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19658h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f19659i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f19660j = true;

    /* renamed from: k  reason: collision with root package name */
    private C2028t f19661k = new c(this);

    /* renamed from: l  reason: collision with root package name */
    private final a f19662l = new a(this);

    /* renamed from: m  reason: collision with root package name */
    private final b f19663m = new b(this);

    public static final class a implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ E1 f19664a;

        a(E1 e12) {
            this.f19664a = e12;
        }

        /* access modifiers changed from: private */
        public static final s c(E1 e12, C2050h hVar) {
            e12.G(hVar.Q());
            return s.f8222a;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            if (this.f19664a.getActivity() instanceof MainActivity) {
                FragmentActivity activity = this.f19664a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                RelativeLayout M5 = ((MainActivity) activity).M5();
                if (M5 == null || M5.getVisibility() != 0) {
                    FragmentActivity activity2 = this.f19664a.getActivity();
                    m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity2).V2(hVar, new D1(this.f19664a, hVar));
                }
            }
        }
    }

    public static final class b implements C2024o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ E1 f19665a;

        b(E1 e12) {
            this.f19665a = e12;
        }

        public void a(Q q4) {
            m.e(q4, "topHorizontalTopReceived");
            C1527d j4 = this.f19665a.f19652b;
            if (j4 != null) {
                j4.u(q4);
            }
        }

        public void b(ArrayList arrayList) {
            C1527d j4;
            m.e(arrayList, "miniTopsReceived");
            this.f19665a.f19654d = arrayList;
            if (this.f19665a.f19654d.size() > 0 && (j4 = this.f19665a.f19652b) != null) {
                j4.l(this.f19665a.f19654d);
            }
        }

        public void c(Q q4) {
            m.e(q4, "topHorizontalNewReleasesReceived");
            this.f19665a.f19657g = q4;
        }

        public void d(ArrayList arrayList) {
            m.e(arrayList, "homeFeaturesReceived");
            this.f19665a.f19653c = arrayList;
        }

        public void e(C2050h hVar) {
            m.e(hVar, "appInfoReceived");
            C1527d j4 = this.f19665a.f19652b;
            if (j4 != null) {
                j4.j(hVar);
            }
        }

        public void f(Q q4) {
            m.e(q4, "topByCategory");
            this.f19665a.f19655e = q4;
        }

        public void g(C2050h hVar) {
            m.e(hVar, "appReplacement");
            C1527d j4 = this.f19665a.f19652b;
            if (j4 != null) {
                j4.b(hVar);
            }
        }

        public void h() {
            this.f19665a.z();
        }

        public void i(Q q4) {
            m.e(q4, "topHorizontalLatestReceived");
            C1527d j4 = this.f19665a.f19652b;
            if (j4 != null) {
                j4.t(q4);
            }
        }

        public void j(ArrayList arrayList) {
            C1527d j4;
            m.e(arrayList, "recentFeaturedReceived");
            if (arrayList.size() > 0 && (j4 = this.f19665a.f19652b) != null) {
                j4.s((C2050h) C1601o.H(arrayList));
            }
        }

        public void k(ArrayList arrayList) {
            m.e(arrayList, "floatingMiniTopsReceived");
            if (arrayList.size() > 3) {
                this.f19665a.f19656f = new ArrayList();
                ArrayList o4 = this.f19665a.f19656f;
                if (o4 != null) {
                    o4.add(arrayList.get(0));
                }
                ArrayList o5 = this.f19665a.f19656f;
                if (o5 != null) {
                    o5.add(arrayList.get(1));
                }
                ArrayList o6 = this.f19665a.f19656f;
                if (o6 != null) {
                    o6.add(arrayList.get(2));
                }
            } else {
                this.f19665a.f19656f = arrayList;
            }
            C1527d j4 = this.f19665a.f19652b;
            if (j4 != null) {
                j4.o(this.f19665a.f19656f);
            }
        }

        public void l(ArrayList arrayList) {
            m.e(arrayList, "categoriesReceived");
        }
    }

    public static final class c implements C2028t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ E1 f19666a;

        c(E1 e12) {
            this.f19666a = e12;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0() && this.f19666a.getActivity() != null && (this.f19666a.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = this.f19666a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).C2(hVar.e());
            }
        }

        public void b(C2053k kVar) {
            m.e(kVar, "category");
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (kVar.b() == 523) {
                FragmentActivity activity = this.f19666a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).w5(1);
                return;
            }
            FragmentActivity activity2 = this.f19666a.getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).l8(kVar);
        }

        public void c(Q q4) {
            m.e(q4, "topByCategory");
            if (UptodownApp.f17422D.a0()) {
                int b5 = q4.b().b();
                if (b5 == -3 || b5 == -2) {
                    FragmentActivity activity = this.f19666a.getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity).i8(q4.b());
                } else if (b5 == -1) {
                    FragmentActivity activity2 = this.f19666a.getActivity();
                    m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity2).w5(2);
                } else if (b5 == 523) {
                    FragmentActivity activity3 = this.f19666a.getActivity();
                    m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity3).w5(1);
                } else if (q4.b().h()) {
                    FragmentActivity activity4 = this.f19666a.getActivity();
                    m.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity4).i8(q4.b());
                } else {
                    FragmentActivity activity5 = this.f19666a.getActivity();
                    m.c(activity5, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity5).l8(q4.b());
                }
            }
        }
    }

    public static final class d extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ E1 f19667a;

        d(E1 e12) {
            this.f19667a = e12;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0 && !this.f19667a.f19659i && this.f19667a.f19660j && !recyclerView.canScrollVertically(1)) {
                this.f19667a.D();
            }
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ E1 f19669b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(E1 e12, V2.d dVar) {
            super(2, dVar);
            this.f19669b = e12;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19669b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19668a;
            if (i4 == 0) {
                n.b(obj);
                E1 e12 = this.f19669b;
                this.f19668a = 1;
                if (e12.E(this) == c5) {
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19670a;

        /* renamed from: b  reason: collision with root package name */
        Object f19671b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f19672c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ E1 f19673d;

        /* renamed from: e  reason: collision with root package name */
        int f19674e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(E1 e12, V2.d dVar) {
            super(dVar);
            this.f19673d = e12;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19672c = obj;
            this.f19674e |= Integer.MIN_VALUE;
            return this.f19673d.E(this);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19675a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ E1 f19676b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f19677c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(E1 e12, ArrayList arrayList, V2.d dVar) {
            super(2, dVar);
            this.f19676b = e12;
            this.f19677c = arrayList;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f19676b, this.f19677c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19675a == 0) {
                n.b(obj);
                Context requireContext = this.f19676b.requireContext();
                m.d(requireContext, "requireContext(...)");
                L l4 = new L(requireContext);
                ArrayList arrayList = new ArrayList();
                if (this.f19676b.f19656f != null) {
                    ArrayList o4 = this.f19676b.f19656f;
                    m.b(o4);
                    Iterator it = o4.iterator();
                    m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        m.d(next, "next(...)");
                        arrayList.add(kotlin.coroutines.jvm.internal.b.b(((Q) next).b().b()));
                    }
                }
                if (arrayList.size() > 0) {
                    g2.L j4 = l4.j(arrayList, 20, 0);
                    if (j4.b() || j4.e() == null) {
                        this.f19676b.f19660j = false;
                    } else {
                        JSONObject e5 = j4.e();
                        m.b(e5);
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (e5.optInt("success") == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("floatingCategory");
                                if (optJSONObject2 != null) {
                                    C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                                    kVar.m(optJSONObject2);
                                    ArrayList arrayList2 = new ArrayList();
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("apps");
                                    if (optJSONArray2 != null) {
                                        int length2 = optJSONArray2.length();
                                        for (int i5 = 0; i5 < length2; i5++) {
                                            C2050h hVar = new C2050h();
                                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                            m.b(optJSONObject3);
                                            C2050h.b(hVar, optJSONObject3, (Context) null, 2, (Object) null);
                                            arrayList2.add(hVar);
                                        }
                                    }
                                    Q q4 = new Q(kVar, arrayList2, 0, 4, (C2103g) null);
                                    q4.f(5);
                                    ArrayList o5 = this.f19676b.f19656f;
                                    if (o5 != null) {
                                        kotlin.coroutines.jvm.internal.b.a(o5.add(q4));
                                    }
                                    this.f19677c.add(q4);
                                }
                            }
                        }
                    }
                } else {
                    this.f19676b.f19660j = false;
                }
                this.f19676b.f19659i = false;
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
        int f19678a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f19679b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ E1 f19680c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ArrayList arrayList, E1 e12, V2.d dVar) {
            super(2, dVar);
            this.f19679b = arrayList;
            this.f19680c = e12;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f19679b, this.f19680c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19678a == 0) {
                n.b(obj);
                if (this.f19679b.size() < 4) {
                    this.f19680c.f19660j = false;
                }
                Iterator it = this.f19679b.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    Q q4 = (Q) next;
                    C1527d j4 = this.f19680c.f19652b;
                    if (j4 != null) {
                        j4.a(q4);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19681a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19682b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ E1 f19683c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str, E1 e12, V2.d dVar) {
            super(2, dVar);
            this.f19682b = str;
            this.f19683c = e12;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f19682b, this.f19683c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            C1527d j4;
            W2.b.c();
            if (this.f19681a == 0) {
                n.b(obj);
                String str = this.f19682b;
                if (!(str == null || str.length() == 0 || (j4 = this.f19683c.f19652b) == null)) {
                    String str2 = this.f19682b;
                    RecyclerView recyclerView = this.f19683c.A().f9793e;
                    m.d(recyclerView, "recyclerViewHome");
                    j4.w(str2, recyclerView);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final c2.J A() {
        return (c2.J) this.f19651a.getValue();
    }

    /* access modifiers changed from: private */
    public static final void C(E1 e12, View view) {
        if (UptodownApp.f17422D.a0()) {
            e12.A().f9792d.setVisibility(0);
            e12.A().f9791c.setVisibility(8);
            e12.B();
        }
    }

    /* access modifiers changed from: private */
    public final void D() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new e(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (o3.C0977g.g(r8, r6, r0) != r1) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof d2.E1.f
            if (r0 == 0) goto L_0x0013
            r0 = r8
            d2.E1$f r0 = (d2.E1.f) r0
            int r1 = r0.f19674e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19674e = r1
            goto L_0x0018
        L_0x0013:
            d2.E1$f r0 = new d2.E1$f
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f19672c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19674e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r8)
            goto L_0x007e
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.f19671b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r4 = r0.f19670a
            d2.E1 r4 = (d2.E1) r4
            R2.n.b(r8)
            goto L_0x0068
        L_0x0041:
            R2.n.b(r8)
            android.content.Context r8 = r7.getContext()
            if (r8 == 0) goto L_0x0081
            r7.f19659i = r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            o3.G r8 = o3.Y.b()
            d2.E1$g r6 = new d2.E1$g
            r6.<init>(r7, r2, r5)
            r0.f19670a = r7
            r0.f19671b = r2
            r0.f19674e = r4
            java.lang.Object r8 = o3.C0977g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x0067
            goto L_0x007d
        L_0x0067:
            r4 = r7
        L_0x0068:
            o3.E0 r8 = o3.Y.c()
            d2.E1$h r6 = new d2.E1$h
            r6.<init>(r2, r4, r5)
            r0.f19670a = r5
            r0.f19671b = r5
            r0.f19674e = r3
            java.lang.Object r8 = o3.C0977g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x007e
        L_0x007d:
            return r1
        L_0x007e:
            R2.s r8 = R2.s.f8222a
            return r8
        L_0x0081:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.E1.E(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final c2.J y(E1 e12) {
        return c2.J.c(e12.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void z() {
        if (this.f19653c.size() > 0) {
            C1527d dVar = this.f19652b;
            if (dVar != null) {
                dVar.q(this.f19653c, this.f19655e, this.f19657g);
            }
            A().f9793e.setAdapter(this.f19652b);
            A().f9793e.setVisibility(0);
            A().f9791c.setVisibility(8);
        } else {
            A().f9793e.setVisibility(8);
            A().f9791c.setVisibility(0);
        }
        A().f9792d.setVisibility(8);
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            if (this.f19658h) {
                this.f19658h = false;
                FragmentActivity activity = getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).E5();
            }
            if (z.f21956a.d()) {
                FragmentActivity activity2 = getActivity();
                m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity2).P5();
                return;
            }
            FragmentActivity activity3 = getActivity();
            m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity3).v7();
        }
    }

    public final void B() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            new C1634f(requireContext, this.f19663m, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void F() {
        A().f9793e.smoothScrollToPosition(0);
    }

    public final void G(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (o3.L) null, new i(str, this, (V2.d) null), 2, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19658h = true;
        C2028t tVar = this.f19661k;
        a aVar = this.f19662l;
        String simpleName = E1.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        this.f19652b = new C1527d(tVar, aVar, simpleName);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        TextView textView = A().f9794f;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        A().f9795g.setTypeface(aVar.w());
        A().f9795g.setOnClickListener(new B1(this));
        A().f9793e.setItemAnimator((RecyclerView.ItemAnimator) null);
        A().f9793e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        A().f9793e.addItemDecoration(new w2.n((int) getResources().getDimension(R.dimen.margin_m)));
        A().f9793e.addOnScrollListener(new d(this));
        B();
        FrameLayout b5 = A().getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    public void onPause() {
        super.onPause();
        C1.e k4 = UptodownApp.f17422D.k();
        if (k4 != null) {
            k4.pause();
        }
    }

    public void onResume() {
        C1.e k4;
        super.onResume();
        new x(getContext()).e("HomeFragment");
        UptodownApp.a aVar = UptodownApp.f17422D;
        C1.e l4 = aVar.l();
        if (l4 != null) {
            l4.pause();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (aVar.f(requireContext)) {
                a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                if (aVar2.k(requireContext2) > 0 && (k4 = aVar.k()) != null) {
                    k4.play();
                }
            }
        }
    }
}
