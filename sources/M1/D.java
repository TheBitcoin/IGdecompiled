package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.C2011b;
import f2.I;
import g2.C2048f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2364d1;
import x2.C2368f0;

public final class D extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f7410f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f7411a;

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f7412b;

    /* renamed from: c  reason: collision with root package name */
    private final I f7413c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f7414d;

    /* renamed from: e  reason: collision with root package name */
    private int f7415e = -1;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public D(ArrayList arrayList, Context context, C2011b bVar, I i4) {
        m.e(arrayList, "apps");
        m.e(context, "context");
        m.e(bVar, "applistener");
        m.e(i4, "uptodownProtectListener");
        this.f7411a = context;
        this.f7412b = bVar;
        this.f7413c = i4;
        a(arrayList);
    }

    private final void a(ArrayList arrayList) {
        d(new ArrayList());
        b().add("uptodown_protect");
        this.f7415e = 0;
        b().addAll(arrayList);
    }

    public final ArrayList b() {
        ArrayList arrayList = this.f7414d;
        if (arrayList != null) {
            return arrayList;
        }
        m.u(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, "apps");
        a(arrayList);
        notifyDataSetChanged();
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f7414d = arrayList;
    }

    public int getItemCount() {
        return b().size();
    }

    public int getItemViewType(int i4) {
        Object obj = b().get(i4);
        m.d(obj, "get(...)");
        if (obj instanceof C2048f) {
            return 0;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException();
        } else if (m.a((String) obj, "uptodown_protect")) {
            return 3;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2368f0) {
            Object obj = b().get(i4);
            m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2368f0) viewHolder).c((C2048f) obj);
        } else if (viewHolder instanceof C2364d1) {
            ArrayList arrayList = new ArrayList();
            Iterator it = b().iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                if (next instanceof C2048f) {
                    arrayList.add(next);
                }
            }
            ((C2364d1) viewHolder).d(arrayList, this.f7411a);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            return new C2368f0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_positive, viewGroup, false), this.f7412b, this.f7411a);
        }
        if (i4 == 3) {
            return new C2364d1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uptodown_protect, viewGroup, false), this.f7413c);
        }
        throw new IllegalArgumentException("viewType unknown");
    }
}
