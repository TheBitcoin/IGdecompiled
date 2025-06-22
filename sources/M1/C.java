package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.C2010a;
import f2.C2013d;
import g2.C2050h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2367f;
import x2.N;

public final class C extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7406d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7407a;

    /* renamed from: b  reason: collision with root package name */
    private final C2013d f7408b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7409c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C(ArrayList arrayList, C2013d dVar) {
        m.e(arrayList, "searchResults");
        m.e(dVar, "listener");
        this.f7407a = arrayList;
        this.f7408b = dVar;
    }

    public final void a(ArrayList arrayList) {
        m.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2050h hVar = (C2050h) next;
            if (!this.f7407a.contains(hVar)) {
                this.f7407a.add(hVar);
            }
        }
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f7407a;
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f7407a = arrayList;
        notifyDataSetChanged();
    }

    public final void d(boolean z4) {
        this.f7409c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f7407a.size() + (this.f7409c ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7407a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2367f) {
            Object obj = this.f7407a.get(i4);
            m.d(obj, "get(...)");
            ((C2367f) viewHolder).m((C2050h) obj, i4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_item, viewGroup, false);
            m.b(inflate);
            return new C2367f(inflate, this.f7408b, (C2010a) null);
        } else if (i4 == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            m.b(inflate2);
            return new N(inflate2);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
