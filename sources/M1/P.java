package M1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.T0;
import f2.L;
import g2.V;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.p1;

public final class P extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f7504a;

    /* renamed from: b  reason: collision with root package name */
    private final L f7505b;

    public P(ArrayList arrayList, L l4) {
        m.e(arrayList, "userDevices");
        m.e(l4, "listener");
        this.f7504a = arrayList;
        this.f7505b = l4;
    }

    /* renamed from: a */
    public void onBindViewHolder(p1 p1Var, int i4) {
        m.e(p1Var, "viewHolder");
        Object obj = this.f7504a.get(i4);
        m.d(obj, "get(...)");
        p1Var.e((V) obj);
    }

    /* renamed from: b */
    public p1 onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        T0 c5 = T0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        m.d(c5, "inflate(...)");
        return new p1(c5, this.f7505b);
    }

    public int getItemCount() {
        return this.f7504a.size();
    }
}
