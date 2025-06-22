package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2005D;
import g2.C2048f;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2399v0;

public final class A extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7400a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7401b;

    /* renamed from: c  reason: collision with root package name */
    private final C2005D f7402c;

    public A(ArrayList arrayList, Context context, C2005D d5) {
        m.e(arrayList, "rollbackApps");
        m.e(context, "context");
        m.e(d5, "listener");
        this.f7400a = arrayList;
        this.f7401b = context;
        this.f7402c = d5;
    }

    public final ArrayList a() {
        return this.f7400a;
    }

    /* renamed from: b */
    public void onBindViewHolder(C2399v0 v0Var, int i4) {
        m.e(v0Var, "viewHolder");
        Object obj = this.f7400a.get(i4);
        m.d(obj, "get(...)");
        v0Var.c((C2048f) obj, this.f7401b);
    }

    /* renamed from: c */
    public C2399v0 onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f7401b).inflate(R.layout.rollback_item, viewGroup, false);
        m.b(inflate);
        return new C2399v0(inflate, this.f7402c);
    }

    public final void d(ArrayList arrayList) {
        if (arrayList != null) {
            this.f7400a = new ArrayList(arrayList);
        } else {
            this.f7400a = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7400a.size();
    }
}
