package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2002A;
import g2.C2039G;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import x2.C2402x;
import y2.n;

/* renamed from: M1.u  reason: case insensitive filesystem */
public final class C1543u extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7709a;

    /* renamed from: b  reason: collision with root package name */
    private final C2002A f7710b;

    /* renamed from: c  reason: collision with root package name */
    private int f7711c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f7712d = new ArrayList();

    public C1543u(Context context, C2002A a5) {
        m.e(context, "context");
        m.e(a5, "listener");
        this.f7709a = context;
        this.f7710b = a5;
    }

    /* access modifiers changed from: private */
    public static final void c(C1543u uVar, C2039G g4, View view) {
        uVar.f7710b.a(g4);
    }

    public final void b(C2039G g4) {
        m.e(g4, "preRegister");
        this.f7712d.add(g4);
        notifyItemInserted(this.f7712d.size());
    }

    public final void d(C2039G g4) {
        m.e(g4, "preRegister");
        Iterator it = this.f7712d.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (((C2039G) it.next()).c() == g4.c()) {
                break;
            }
            i4 = i5;
        }
        e(i4);
    }

    public final void e(int i4) {
        if (i4 > -1 && i4 < this.f7712d.size()) {
            this.f7712d.remove(i4);
            this.f7711c--;
            notifyDataSetChanged();
            this.f7710b.b();
        }
    }

    public int getItemCount() {
        return this.f7712d.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        Object obj = this.f7712d.get(absoluteAdapterPosition);
        m.d(obj, "get(...)");
        C2039G g4 = (C2039G) obj;
        if (viewHolder instanceof C2402x) {
            C2402x xVar = (C2402x) viewHolder;
            xVar.d().setText(g4.f());
            s.h().l(g4.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(this.f7709a)).i(xVar.a());
            xVar.b().setText(this.f7709a.getString(R.string.preregister_available_to_download));
            xVar.c().setText(this.f7709a.getString(R.string.updates_button_download_app));
        }
        if (absoluteAdapterPosition > this.f7711c) {
            Context context = viewHolder.itemView.getContext();
            m.d(context, "getContext(...)");
            n nVar = new n(context);
            View view = viewHolder.itemView;
            m.d(view, "itemView");
            nVar.h(view, R.anim.slide_in_bottom);
            this.f7711c = absoluteAdapterPosition;
        }
        viewHolder.itemView.setOnClickListener(new C1542t(this, g4));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f7709a).inflate(R.layout.floating_notification, viewGroup, false);
        m.b(inflate);
        return new C2402x(inflate);
    }
}
