package M1;

import R2.s;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.A1;
import x2.C2385o;
import x2.C2396u;
import x2.C2400w;
import x2.D;
import x2.F;
import x2.H;
import x2.J;
import x2.Q0;

/* renamed from: M1.d  reason: case insensitive filesystem */
public final class C1527d extends RecyclerView.Adapter {

    /* renamed from: o  reason: collision with root package name */
    public static final a f7548o = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2028t f7549a;

    /* renamed from: b  reason: collision with root package name */
    private final C2010a f7550b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7551c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f7552d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f7553e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f7554f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f7555g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f7556h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f7557i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f7558j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f7559k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f7560l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f7561m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f7562n = -1;

    /* renamed from: M1.d$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: M1.d$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList f7563a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList f7564b;

        public final ArrayList a() {
            ArrayList arrayList = this.f7564b;
            if (arrayList != null) {
                return arrayList;
            }
            m.u("categories");
            return null;
        }

        public final ArrayList b() {
            ArrayList arrayList = this.f7563a;
            if (arrayList != null) {
                return arrayList;
            }
            m.u("homeFeatures");
            return null;
        }

        public final void c(ArrayList arrayList) {
            m.e(arrayList, "<set-?>");
            this.f7564b = arrayList;
        }

        public final void d(ArrayList arrayList) {
            m.e(arrayList, "<set-?>");
            this.f7563a = arrayList;
        }
    }

    /* renamed from: M1.d$c */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Object f7565a;

        /* renamed from: b  reason: collision with root package name */
        private int f7566b = -1;

        public final Object a() {
            Object obj = this.f7565a;
            if (obj != null) {
                return obj;
            }
            m.u("item");
            return s.f8222a;
        }

        public final int b() {
            return this.f7566b;
        }

        public final void c(Object obj) {
            m.e(obj, "<set-?>");
            this.f7565a = obj;
        }

        public final void d(int i4) {
            this.f7566b = i4;
        }
    }

    public C1527d(C2028t tVar, C2010a aVar, String str) {
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        m.e(str, "fragmentName");
        this.f7549a = tVar;
        this.f7550b = aVar;
        this.f7551c = str;
    }

    private final void c(ArrayList arrayList, int i4) {
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            Q q4 = (Q) next;
            if (q4.b().b() == i4) {
                h(q4);
                arrayList.remove(q4);
                return;
            }
        }
    }

    private final void d(C2050h hVar) {
        c cVar = new c();
        cVar.c(hVar);
        cVar.d(2);
        this.f7552d.add(cVar);
    }

    private final void e(ArrayList arrayList) {
        c cVar = new c();
        cVar.c(arrayList);
        cVar.d(7);
        this.f7552d.add(cVar);
        notifyItemInserted(this.f7552d.size() - 1);
    }

    private final void f(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            c(arrayList, 558);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 566);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 562);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 564);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 559);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 645);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 560);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 561);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 565);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 593);
        }
        if (!arrayList.isEmpty()) {
            c(arrayList, 568);
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                h((Q) next);
            }
        }
    }

    private final void g(ArrayList arrayList, ArrayList arrayList2) {
        b bVar = new b();
        bVar.d(arrayList);
        bVar.c(arrayList2);
        c cVar = new c();
        cVar.c(bVar);
        cVar.d(0);
        this.f7552d.add(cVar);
    }

    private final void h(Q q4) {
        if (q4 != null) {
            c cVar = new c();
            cVar.c(q4);
            cVar.d(q4.c());
            this.f7552d.add(cVar);
            notifyItemInserted(this.f7552d.size() - 1);
        }
    }

    private final void n(ArrayList arrayList, ArrayList arrayList2) {
        b bVar = new b();
        bVar.d(arrayList);
        bVar.c(arrayList2);
        c cVar = new c();
        cVar.c(bVar);
        cVar.d(0);
        this.f7552d.add(cVar);
    }

    private final void v(Q q4, int i4) {
        if (i4 >= 0 && i4 < this.f7552d.size()) {
            c cVar = new c();
            cVar.c(q4);
            cVar.d(q4.c());
            this.f7552d.set(i4, cVar);
            notifyItemChanged(i4);
        }
    }

    public final void a(Q q4) {
        m.e(q4, "floatingCategory");
        h(q4);
    }

    public final void b(C2050h hVar) {
        m.e(hVar, "appReplacement");
        int i4 = 0;
        for (c cVar : this.f7552d) {
            int i5 = i4 + 1;
            if (cVar == null || cVar.b() != 0) {
                i4 = i5;
            } else {
                Object a5 = cVar.a();
                m.c(a5, "null cannot be cast to non-null type com.uptodown.adapters.HomeAdapter.HomeHeader");
                ((b) a5).b().add(hVar);
                notifyItemChanged(i4);
                return;
            }
        }
    }

    public int getItemCount() {
        return this.f7552d.size();
    }

    public int getItemViewType(int i4) {
        c cVar = (c) this.f7552d.get(i4);
        if (cVar != null) {
            return cVar.b();
        }
        return -1;
    }

    public final void i(ArrayList arrayList) {
        m.e(arrayList, "floatingCategories");
        if (!arrayList.isEmpty()) {
            e(arrayList);
        }
    }

    public final void j(C2050h hVar) {
        m.e(hVar, "mainApp");
        c cVar = new c();
        cVar.c(hVar);
        cVar.d(3);
        this.f7552d.set(this.f7556h, cVar);
        notifyItemChanged(this.f7556h);
    }

    public final void k(Q q4) {
        m.e(q4, "miniTop");
        h(q4);
    }

    public final void l(ArrayList arrayList) {
        m.e(arrayList, "miniTops");
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            Q q4 = (Q) next;
            int b5 = q4.b().b();
            if (b5 == 521) {
                v(q4, this.f7557i);
            } else if (b5 == 523) {
                v(q4, this.f7558j);
            } else if (b5 != 524) {
                h(q4);
            } else {
                v(q4, this.f7559k);
            }
        }
    }

    public final void m(ArrayList arrayList, C2053k kVar) {
        m.e(arrayList, "miniTops");
        m.e(kVar, "parentCategory");
        if (kVar.b() == 523) {
            f(arrayList);
            return;
        }
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            h((Q) next);
        }
    }

    public final void o(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Object obj = arrayList.get(0);
            m.d(obj, "get(...)");
            v((Q) obj, this.f7560l);
            if (arrayList.size() > 1) {
                Object obj2 = arrayList.get(1);
                m.d(obj2, "get(...)");
                v((Q) obj2, this.f7561m);
            }
            if (arrayList.size() > 2) {
                Object obj3 = arrayList.get(2);
                m.d(obj3, "get(...)");
                v((Q) obj3, this.f7562n);
            }
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        Object obj;
        Object obj2;
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2396u) {
            ((C2396u) viewHolder).a();
            return;
        }
        Object obj3 = null;
        if (viewHolder instanceof D) {
            D d5 = (D) viewHolder;
            c cVar = (c) this.f7552d.get(i4);
            if (cVar != null) {
                obj3 = cVar.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.adapters.HomeAdapter.HomeHeader");
            d5.d((b) obj3);
        } else if (viewHolder instanceof H) {
            c cVar2 = (c) this.f7552d.get(i4);
            if (cVar2 != null) {
                obj2 = cVar2.a();
            } else {
                obj2 = null;
            }
            if (obj2 instanceof Q) {
                H h4 = (H) viewHolder;
                c cVar3 = (c) this.f7552d.get(i4);
                if (cVar3 != null) {
                    obj3 = cVar3.a();
                }
                m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
                h4.b((Q) obj3);
            }
        } else if (viewHolder instanceof F) {
            c cVar4 = (c) this.f7552d.get(i4);
            if (cVar4 != null) {
                obj = cVar4.a();
            } else {
                obj = null;
            }
            if (obj instanceof Q) {
                F f4 = (F) viewHolder;
                c cVar5 = (c) this.f7552d.get(i4);
                if (cVar5 != null) {
                    obj3 = cVar5.a();
                }
                m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
                f4.b((Q) obj3);
            }
        } else if (viewHolder instanceof C2385o) {
            C2385o oVar = (C2385o) viewHolder;
            c cVar6 = (c) this.f7552d.get(i4);
            if (cVar6 != null) {
                obj3 = cVar6.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            oVar.m((C2050h) obj3);
        } else if (viewHolder instanceof x2.Q) {
            x2.Q q4 = (x2.Q) viewHolder;
            c cVar7 = (c) this.f7552d.get(i4);
            if (cVar7 != null) {
                obj3 = cVar7.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            q4.n((C2050h) obj3);
        } else if (viewHolder instanceof A1) {
            A1 a12 = (A1) viewHolder;
            c cVar8 = (c) this.f7552d.get(i4);
            if (cVar8 != null) {
                obj3 = cVar8.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            a12.c((Q) obj3);
        } else if (viewHolder instanceof Q0) {
            Q0 q02 = (Q0) viewHolder;
            c cVar9 = (c) this.f7552d.get(i4);
            if (cVar9 != null) {
                obj3 = cVar9.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            q02.b((Q) obj3);
        } else if (viewHolder instanceof J) {
            J j4 = (J) viewHolder;
            c cVar10 = (c) this.f7552d.get(i4);
            if (cVar10 != null) {
                obj3 = cVar10.a();
            }
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            j4.b((Q) obj3);
        } else if (viewHolder instanceof C2400w) {
            C2400w wVar = (C2400w) viewHolder;
            c cVar11 = (c) this.f7552d.get(i4);
            if (cVar11 != null) {
                obj3 = cVar11.a();
            }
            m.c(obj3, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.Category>");
            wVar.b((ArrayList) obj3);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        switch (i4) {
            case -1:
                return new C2396u(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_view, viewGroup, false));
            case 0:
                return new D(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_fragment_header, viewGroup, false), this.f7549a, this.f7550b);
            case 1:
                return new H(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f7549a, this.f7550b);
            case 2:
                return new C2385o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_featured, viewGroup, false), this.f7549a, this.f7550b);
            case 3:
                return new x2.Q(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_gallery_featured, viewGroup, false), this.f7549a, this.f7550b);
            case 4:
                return new A1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f7549a, this.f7550b, this.f7551c);
            case 5:
                return new Q0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f7549a, this.f7550b);
            case 6:
                return new J(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f7549a, this.f7550b);
            case 7:
                return new C2400w(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.floating_categories, viewGroup, false), this.f7549a);
            case 8:
                return new F(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f7549a, this.f7550b);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }

    public final void p(ArrayList arrayList, ArrayList arrayList2, Q q4, C2050h hVar, Q q5) {
        ArrayList a5;
        ArrayList a6;
        ArrayList a7;
        m.e(arrayList, "appsFeatured");
        m.e(arrayList2, "leafCategories");
        this.f7552d = new ArrayList();
        if (!arrayList.isEmpty()) {
            n(arrayList, arrayList2);
        }
        if (!(q4 == null || (a7 = q4.a()) == null || !(!a7.isEmpty()))) {
            h(q4);
        }
        if (arrayList2.isEmpty() || ((C2053k) arrayList2.get(0)).e() != 523) {
            if (hVar != null) {
                d(hVar);
            }
            if (q5 != null && (a5 = q5.a()) != null && (!a5.isEmpty())) {
                h(q5);
                return;
            }
            return;
        }
        if (!(q5 == null || (a6 = q5.a()) == null || !(!a6.isEmpty()))) {
            h(q5);
        }
        if (hVar != null) {
            d(hVar);
        }
    }

    public final void q(ArrayList arrayList, Q q4, Q q5) {
        m.e(arrayList, "homeFeatures");
        this.f7552d = new ArrayList();
        g(arrayList, new ArrayList());
        h(q4);
        this.f7552d.add((Object) null);
        this.f7553e = this.f7552d.size() - 1;
        h(q5);
        this.f7552d.add((Object) null);
        this.f7554f = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7561m = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7555g = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7562n = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7556h = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7557i = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7558j = this.f7552d.size() - 1;
        this.f7552d.add((Object) null);
        this.f7559k = this.f7552d.size() - 1;
    }

    public final ArrayList r() {
        return this.f7552d;
    }

    public final void s(C2050h hVar) {
        m.e(hVar, "featuredApp");
        if (this.f7554f > 0) {
            c cVar = new c();
            cVar.c(hVar);
            cVar.d(2);
            this.f7552d.set(this.f7554f, cVar);
            notifyItemChanged(this.f7554f);
        }
    }

    public final void t(Q q4) {
        m.e(q4, "top");
        v(q4, this.f7553e);
    }

    public final void u(Q q4) {
        m.e(q4, "top");
        v(q4, this.f7555g);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: g2.h} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.lang.String r11, androidx.recyclerview.widget.RecyclerView r12) {
        /*
            r10 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.m.e(r11, r0)
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.m.e(r12, r0)
            int r0 = r10.getItemCount()
            r1 = 0
            r2 = 0
        L_0x0010:
            if (r2 >= r0) goto L_0x0186
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r12.findViewHolderForAdapterPosition(r2)
            boolean r4 = r3 instanceof x2.H
            r5 = 0
            if (r4 == 0) goto L_0x0057
            x2.H r3 = (x2.H) r3
            M1.I r4 = r3.d()
            java.util.ArrayList r4 = r4.c()
            int r6 = r4.size()
            r7 = 0
        L_0x002a:
            if (r7 >= r6) goto L_0x0040
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x002a
            r5 = r8
        L_0x0040:
            g2.h r5 = (g2.C2050h) r5
            M1.I r4 = r3.d()
            java.util.ArrayList r4 = r4.c()
            int r4 = S2.C1601o.K(r4, r5)
            M1.I r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x0182
        L_0x0057:
            boolean r4 = r3 instanceof x2.F
            if (r4 == 0) goto L_0x0097
            x2.F r3 = (x2.F) r3
            M1.G r4 = r3.d()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = 0
        L_0x006a:
            if (r7 >= r6) goto L_0x0080
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x006a
            r5 = r8
        L_0x0080:
            g2.h r5 = (g2.C2050h) r5
            M1.G r4 = r3.d()
            java.util.ArrayList r4 = r4.b()
            int r4 = S2.C1601o.K(r4, r5)
            M1.G r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x0182
        L_0x0097:
            boolean r4 = r3 instanceof x2.C2385o
            if (r4 == 0) goto L_0x00ae
            x2.o r3 = (x2.C2385o) r3
            java.lang.String r3 = r3.o()
            boolean r3 = kotlin.jvm.internal.m.a(r3, r11)
            if (r3 == 0) goto L_0x0182
            int r3 = r10.f7554f
            r10.notifyItemChanged(r3)
            goto L_0x0182
        L_0x00ae:
            boolean r4 = r3 instanceof x2.Q
            if (r4 == 0) goto L_0x00c5
            x2.Q r3 = (x2.Q) r3
            java.lang.String r3 = r3.p()
            boolean r3 = kotlin.jvm.internal.m.a(r3, r11)
            if (r3 == 0) goto L_0x0182
            int r3 = r10.f7556h
            r10.notifyItemChanged(r3)
            goto L_0x0182
        L_0x00c5:
            boolean r4 = r3 instanceof x2.A1
            if (r4 == 0) goto L_0x0105
            x2.A1 r3 = (x2.A1) r3
            M1.d0 r4 = r3.e()
            java.util.ArrayList r4 = r4.m()
            int r6 = r4.size()
            r7 = 0
        L_0x00d8:
            if (r7 >= r6) goto L_0x00ee
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x00d8
            r5 = r8
        L_0x00ee:
            g2.h r5 = (g2.C2050h) r5
            M1.d0 r4 = r3.e()
            java.util.ArrayList r4 = r4.m()
            int r4 = S2.C1601o.K(r4, r5)
            M1.d0 r3 = r3.e()
            r3.notifyItemChanged(r4)
            goto L_0x0182
        L_0x0105:
            boolean r4 = r3 instanceof x2.Q0
            if (r4 == 0) goto L_0x0144
            x2.Q0 r3 = (x2.Q0) r3
            M1.i r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r6 = r4.size()
            r7 = 0
        L_0x0118:
            if (r7 >= r6) goto L_0x012e
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x0118
            r5 = r8
        L_0x012e:
            g2.h r5 = (g2.C2050h) r5
            M1.i r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r4 = S2.C1601o.K(r4, r5)
            M1.i r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x0182
        L_0x0144:
            boolean r4 = r3 instanceof x2.J
            if (r4 == 0) goto L_0x0182
            x2.J r3 = (x2.J) r3
            M1.k r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r6 = r4.size()
            r7 = 0
        L_0x0157:
            if (r7 >= r6) goto L_0x016d
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x0157
            r5 = r8
        L_0x016d:
            g2.h r5 = (g2.C2050h) r5
            M1.k r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r4 = S2.C1601o.K(r4, r5)
            M1.k r3 = r3.d()
            r3.notifyItemChanged(r4)
        L_0x0182:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.C1527d.w(java.lang.String, androidx.recyclerview.widget.RecyclerView):void");
    }
}
