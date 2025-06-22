package M1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c2.R0;
import f2.C2011b;
import g2.V;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.m1;

public final class O extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7502a;

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f7503b;

    public O(ArrayList arrayList, C2011b bVar) {
        m.e(arrayList, "userDeviceApps");
        m.e(bVar, "listener");
        this.f7502a = arrayList;
        this.f7503b = bVar;
    }

    public final ArrayList a() {
        return this.f7502a;
    }

    /* renamed from: b */
    public void onBindViewHolder(m1 m1Var, int i4) {
        m.e(m1Var, "viewHolder");
        Object obj = this.f7502a.get(i4);
        m.d(obj, "get(...)");
        m1Var.f((V.c) obj);
    }

    /* renamed from: c */
    public m1 onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        R0 c5 = R0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        m.d(c5, "inflate(...)");
        return new m1(c5, this.f7503b);
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "userDeviceApps");
        this.f7502a = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7502a.size();
    }
}
