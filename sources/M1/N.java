package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.J;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.j1;

public final class N extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7498d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7499a;

    /* renamed from: b  reason: collision with root package name */
    private final J f7500b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7501c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public N(ArrayList arrayList, J j4) {
        m.e(arrayList, "reviews");
        m.e(j4, "listener");
        this.f7499a = arrayList;
        this.f7500b = j4;
    }

    public final void a(ArrayList arrayList) {
        m.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f7499a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f7499a;
    }

    public final void c(boolean z4) {
        this.f7501c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void d(g2.N n4) {
        m.e(n4, "review");
        Iterator it = this.f7499a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (((g2.N) it.next()).f() == n4.f()) {
                break;
            }
            i4 = i5;
        }
        this.f7499a.set(i4, n4);
        notifyItemChanged(i4);
    }

    public int getItemCount() {
        return this.f7499a.size() + (this.f7501c ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7499a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof j1) {
            Object obj = this.f7499a.get(i4);
            m.d(obj, "get(...)");
            ((j1) viewHolder).h((g2.N) obj, i4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review, viewGroup, false);
            J j4 = this.f7500b;
            Context context = viewGroup.getContext();
            m.d(context, "getContext(...)");
            return new j1(inflate, j4, context);
        } else if (i4 == 1) {
            return new x2.N(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false));
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
