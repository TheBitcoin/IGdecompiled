package M1;

import S2.C1601o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2003B;
import g2.C2042J;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2384n0;
import x2.N;

/* renamed from: M1.y  reason: case insensitive filesystem */
public final class C1547y extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f7727e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7728a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7729b;

    /* renamed from: c  reason: collision with root package name */
    private final C2003B f7730c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7731d;

    /* renamed from: M1.y$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1547y(ArrayList arrayList, Context context, C2003B b5) {
        m.e(arrayList, "datos");
        m.e(context, "context");
        m.e(b5, "listener");
        this.f7728a = arrayList;
        this.f7729b = context;
        this.f7730c = b5;
    }

    public final void a(ArrayList arrayList) {
        m.e(arrayList, "replies");
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            this.f7728a.add((C2042J) next);
            notifyItemInserted(C1601o.j(this.f7728a));
        }
    }

    public final void b(boolean z4) {
        this.f7731d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void c(C2042J j4) {
        m.e(j4, "reply");
        Iterator it = this.f7728a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (((C2042J) it.next()).c() == j4.c()) {
                break;
            }
            i4 = i5;
        }
        this.f7728a.set(i4, j4);
        notifyItemChanged(i4);
    }

    public int getItemCount() {
        return this.f7728a.size() + (this.f7731d ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7728a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2384n0) {
            Object obj = this.f7728a.get(i4);
            m.d(obj, "get(...)");
            ((C2384n0) viewHolder).e((C2042J) obj);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reply, viewGroup, false);
            m.b(inflate);
            return new C2384n0(inflate, this.f7729b, this.f7730c);
        } else if (i4 == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            m.b(inflate2);
            return new N(inflate2);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
