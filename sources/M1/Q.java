package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.X0;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.U;
import g2.C2060s;
import g2.S;
import g2.W;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;
import x2.N;
import x2.v1;

public final class Q extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f7506f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7507a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7508b;

    /* renamed from: c  reason: collision with root package name */
    private final U f7509c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7510d;

    /* renamed from: e  reason: collision with root package name */
    private int f7511e = -1;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public Q(ArrayList arrayList, Context context, U u4) {
        m.e(arrayList, "userList");
        m.e(context, "context");
        m.e(u4, "listener");
        this.f7507a = arrayList;
        this.f7508b = context;
        this.f7509c = u4;
    }

    public final void a(ArrayList arrayList) {
        m.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f7507a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f7507a;
    }

    public final void c(File file, Context context) {
        C2060s sVar;
        m.e(file, "file");
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        Iterator it = this.f7507a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            W w4 = (W) it.next();
            String f4 = w4.f();
            if (!(f4 == null || f4.length() == 0)) {
                String f5 = w4.f();
                m.b(f5);
                S D02 = a5.D0(f5);
                if (D02 != null) {
                    sVar = D02.b(context);
                } else {
                    sVar = null;
                }
                if (sVar != null && sVar.o().size() == 1 && m3.m.p(((C2060s.c) sVar.o().get(0)).a(), file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i4 = i5;
        }
        a5.i();
        if (i4 >= 0) {
            notifyItemChanged(i4);
        }
    }

    public final void d() {
        this.f7511e = -1;
        notifyDataSetChanged();
    }

    public final void e(File file, Context context) {
        C2060s sVar;
        m.e(file, "file");
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        Iterator it = this.f7507a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i5 = i4 + 1;
            W w4 = (W) it.next();
            String f4 = w4.f();
            if (!(f4 == null || f4.length() == 0)) {
                String f5 = w4.f();
                m.b(f5);
                S D02 = a5.D0(f5);
                if (D02 != null) {
                    sVar = D02.b(context);
                } else {
                    sVar = null;
                }
                if (sVar != null && sVar.o().size() == 1 && m3.m.p(((C2060s.c) sVar.o().get(0)).a(), file.getAbsolutePath(), true)) {
                    this.f7511e = i4;
                    break;
                }
            }
            i4 = i5;
        }
        a5.i();
        int i6 = this.f7511e;
        if (i6 >= 0) {
            notifyItemChanged(i6);
        }
    }

    public final void f(boolean z4) {
        this.f7510d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f7507a.size() + (this.f7510d ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7507a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        boolean z4;
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof v1) {
            v1 v1Var = (v1) viewHolder;
            Object obj = this.f7507a.get(i4);
            m.d(obj, "get(...)");
            W w4 = (W) obj;
            if (this.f7511e == i4) {
                z4 = true;
            } else {
                z4 = false;
            }
            v1Var.p(w4, z4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            X0 c5 = X0.c(LayoutInflater.from(this.f7508b), viewGroup, false);
            m.d(c5, "inflate(...)");
            return new v1(c5, this.f7508b, this.f7509c);
        } else if (i4 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            m.b(inflate);
            return new N(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
