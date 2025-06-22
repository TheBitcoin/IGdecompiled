package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1682o0;
import com.uptodown.R;
import f2.V;
import g2.C2039G;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2374i0;
import x2.C2407z0;
import x2.N;

/* renamed from: M1.v  reason: case insensitive filesystem */
public final class C1544v extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f7713f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7714a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7715b;

    /* renamed from: c  reason: collision with root package name */
    private final V f7716c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f7717d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private boolean f7718e;

    /* renamed from: M1.v$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1544v(ArrayList arrayList, Context context, V v4) {
        m.e(arrayList, "userData");
        m.e(context, "context");
        m.e(v4, "listener");
        this.f7714a = arrayList;
        this.f7715b = context;
        this.f7716c = v4;
        a(this.f7714a);
    }

    private final void a(ArrayList arrayList) {
        this.f7717d = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                this.f7717d.add((C2039G) next);
            }
            notifyDataSetChanged();
        }
    }

    public final ArrayList b() {
        return this.f7717d;
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, "userData");
        a(arrayList);
    }

    public int getItemCount() {
        return this.f7717d.size() + (this.f7718e ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7717d.size()) {
            return 4;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2374i0) {
            Object obj = this.f7717d.get(i4);
            m.d(obj, "get(...)");
            ((C2374i0) viewHolder).e((C2039G) obj);
        } else if (viewHolder instanceof C2407z0) {
            ((C2407z0) viewHolder).a();
        } else if (!(viewHolder instanceof N)) {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            C1682o0 c5 = C1682o0.c(LayoutInflater.from(this.f7715b), viewGroup, false);
            m.d(c5, "inflate(...)");
            return new C2374i0(c5, this.f7715b, this.f7716c, true);
        } else if (i4 == 4) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            m.b(inflate);
            return new N(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
