package M1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2013d;
import f2.C2014e;
import g2.C2050h;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.D0;
import x2.K0;
import x2.M0;
import x2.O0;

public final class E extends RecyclerView.Adapter {

    /* renamed from: j  reason: collision with root package name */
    public static final a f7416j = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2013d f7417a;

    /* renamed from: b  reason: collision with root package name */
    private final C2014e f7418b;

    /* renamed from: c  reason: collision with root package name */
    private final C2010a f7419c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7420d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7421e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7422f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7423g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f7424h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private int f7425i;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private C2050h f7426a;

        /* renamed from: b  reason: collision with root package name */
        private int f7427b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f7428c = 1;

        public final int a() {
            return this.f7428c;
        }

        public final C2050h b() {
            return this.f7426a;
        }

        public final int c() {
            return this.f7427b;
        }

        public final void d(int i4) {
            this.f7428c = i4;
        }

        public final void e(C2050h hVar) {
            this.f7426a = hVar;
        }

        public final void f(int i4) {
            this.f7427b = i4;
        }
    }

    public E(C2013d dVar, C2014e eVar, C2010a aVar, String str, String str2, String str3, String str4) {
        m.e(dVar, "listener");
        m.e(eVar, "topItemsListener");
        m.e(aVar, "actionsClickListener");
        m.e(str3, "readMore");
        m.e(str4, "readLess");
        this.f7417a = dVar;
        this.f7418b = eVar;
        this.f7419c = aVar;
        this.f7420d = str;
        this.f7421e = str2;
        this.f7422f = str3;
        this.f7423g = str4;
    }

    private final boolean e(C2053k kVar) {
        return kVar.j();
    }

    public final void a(ArrayList arrayList, boolean z4) {
        m.e(arrayList, "apps");
        int size = this.f7424h.size();
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            b bVar = new b();
            bVar.e((C2050h) next);
            bVar.f(0);
            if (z4) {
                int i4 = this.f7425i + 1;
                this.f7425i = i4;
                bVar.d(i4);
            } else {
                bVar.d(0);
            }
            this.f7424h.add(bVar);
        }
        notifyItemRangeInserted(size, this.f7424h.size());
    }

    public final void b(Q q4) {
        m.e(q4, "topByCategory");
        this.f7424h = new ArrayList();
        if (!e(q4.b())) {
            Iterator it = q4.a().iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                b bVar = new b();
                bVar.e((C2050h) next);
                bVar.f(0);
                bVar.d(0);
                this.f7424h.add(bVar);
            }
            return;
        }
        String a5 = q4.b().a();
        if (!(a5 == null || a5.length() == 0)) {
            b bVar2 = new b();
            bVar2.f(2);
            this.f7424h.add(bVar2);
        }
        int i4 = 0;
        for (C2050h hVar : q4.a()) {
            int i5 = i4 + 1;
            b bVar3 = new b();
            bVar3.e(hVar);
            if (i4 == 0 && hVar.I0()) {
                bVar3.f(3);
            } else if (i4 >= 10) {
                bVar3.f(0);
            } else if (q4.b().b() == 1090) {
                bVar3.f(4);
            } else {
                bVar3.f(1);
            }
            this.f7425i = i5;
            bVar3.d(i5);
            this.f7424h.add(bVar3);
            i4 = i5;
        }
    }

    public final ArrayList c() {
        return this.f7424h;
    }

    public final void d(C2050h hVar) {
        m.e(hVar, "appInfo");
        int i4 = 0;
        for (b b5 : this.f7424h) {
            int i5 = i4 + 1;
            C2050h b6 = b5.b();
            if (b6 == null || b6.e() != hVar.e()) {
                i4 = i5;
            } else {
                notifyItemChanged(i4);
                return;
            }
        }
    }

    public int getItemCount() {
        return this.f7424h.size();
    }

    public int getItemViewType(int i4) {
        return ((b) this.f7424h.get(i4)).c();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof K0) {
            C2050h b5 = ((b) this.f7424h.get(i4)).b();
            m.b(b5);
            ((K0) viewHolder).r(b5, ((b) this.f7424h.get(i4)).a(), i4);
        } else if (viewHolder instanceof D0) {
            C2050h b6 = ((b) this.f7424h.get(i4)).b();
            m.b(b6);
            ((D0) viewHolder).o(b6, ((b) this.f7424h.get(i4)).a(), i4);
        } else if (viewHolder instanceof M0) {
            C2050h b7 = ((b) this.f7424h.get(i4)).b();
            m.b(b7);
            ((M0) viewHolder).m(b7, ((b) this.f7424h.get(i4)).a());
        } else if (!(viewHolder instanceof O0)) {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            return new M0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item_small, viewGroup, false), this.f7417a, this.f7419c);
        }
        if (i4 == 1) {
            return new K0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item, viewGroup, false), this.f7417a, this.f7418b, this.f7419c);
        }
        if (i4 == 2) {
            return new O0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_by_category_title_view, viewGroup, false), this.f7420d, this.f7421e, this.f7422f, this.f7423g);
        }
        if (i4 == 3) {
            return new K0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_promoted_top_by_cat_item, viewGroup, false), this.f7417a, this.f7418b, this.f7419c);
        }
        if (i4 == 4) {
            return new D0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item, viewGroup, false), this.f7417a, this.f7418b, this.f7419c);
        }
        throw new IllegalArgumentException("viewType unknown");
    }
}
