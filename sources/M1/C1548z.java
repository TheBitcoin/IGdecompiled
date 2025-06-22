package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2004C;
import g2.N;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2395t0;

/* renamed from: M1.z  reason: case insensitive filesystem */
public final class C1548z extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f7732e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7733a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7734b;

    /* renamed from: c  reason: collision with root package name */
    private final C2004C f7735c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7736d;

    /* renamed from: M1.z$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1548z(ArrayList arrayList, Context context, C2004C c5) {
        m.e(arrayList, "datos");
        m.e(context, "context");
        m.e(c5, "listener");
        this.f7733a = arrayList;
        this.f7734b = context;
        this.f7735c = c5;
    }

    public final void a(N n4) {
        m.e(n4, "review");
        this.f7733a.add(n4);
        notifyItemInserted(getItemCount());
    }

    public final ArrayList b() {
        return this.f7733a;
    }

    public final void c(boolean z4) {
        this.f7736d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void d(N n4) {
        m.e(n4, "review");
        Iterator it = this.f7733a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (((N) it.next()).f() == n4.f()) {
                break;
            }
            i4 = i5;
        }
        this.f7733a.set(i4, n4);
        notifyItemChanged(i4);
    }

    public int getItemCount() {
        return this.f7733a.size() + (this.f7736d ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7733a.size()) {
            return 2;
        }
        if (((N) this.f7733a.get(i4)).o()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2395t0) {
            Object obj = this.f7733a.get(i4);
            m.d(obj, "get(...)");
            N n4 = (N) obj;
            if (n4.o()) {
                ((C2395t0) viewHolder).g(n4, i4);
            } else {
                ((C2395t0) viewHolder).f(n4, i4);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 1) {
            return new C2395t0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_turbo, viewGroup, false), this.f7734b, this.f7735c);
        }
        if (i4 != 2) {
            return new C2395t0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review, viewGroup, false), this.f7734b, this.f7735c);
        }
        return new x2.N(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false));
    }
}
