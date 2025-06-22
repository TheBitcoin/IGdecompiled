package M1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.Z0;
import f2.L;
import g2.X;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.y1;

public final class S extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f7512a;

    /* renamed from: b  reason: collision with root package name */
    private final L f7513b;

    public S(ArrayList arrayList, L l4) {
        m.e(arrayList, "userDevices");
        m.e(l4, "listener");
        this.f7512a = arrayList;
        this.f7513b = l4;
    }

    /* renamed from: a */
    public void onBindViewHolder(y1 y1Var, int i4) {
        m.e(y1Var, "viewHolder");
        Object obj = this.f7512a.get(i4);
        m.d(obj, "get(...)");
        y1Var.c((X) obj);
    }

    /* renamed from: b */
    public y1 onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        Z0 c5 = Z0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        m.d(c5, "inflate(...)");
        return new y1(c5, this.f7513b);
    }

    public int getItemCount() {
        return this.f7512a.size();
    }
}
